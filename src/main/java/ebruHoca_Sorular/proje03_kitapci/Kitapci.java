package ebruHoca_Sorular.proje03_kitapci;

import java.util.*;

import static ebruHoca_Sorular.proje03_kitapci.Kitap.*;


public class Kitapci {


    public static void kutuphaneyeGiris() {

        System.out.println(KIRMIZI + "       TEAM 21 KITABEVI'NE HOSGELDINIZ      ");

        HashMap<String, Integer> kullanicilar = new HashMap<>();
        boolean flag = true;

        do {
            kullanicilar.put("Sevim", 1234);
            kullanicilar.put("Faruk", 2345);
            kullanicilar.put("Hatice", 3456);
            kullanicilar.put("Muhammet", 4567);
            kullanicilar.put("Kubra", 5678);
            kullanicilar.put("Ali", 6789);
            kullanicilar.put("Alperen", 9876);
            kullanicilar.put("Hava", 8765);
            kullanicilar.put("Nihal", 7654);
            kullanicilar.put("Yusuf", 4321);
            kullanicilar.put("Kadir", 4322);


            System.out.println(MOR + "Kullanici adinizi giriniz");

            String kullaniciIsmi = input.next();
      int sifre = 0;

            try {

                System.out.println(MOR + "Kutuphaneye giris sifrenizi giriniz");
                sifre = input.nextInt();
                input.nextLine();

            } catch (Exception e) {

                System.out.println(KIRMIZI + "! Lutfen sifre icin sadece rakam giriniz !" +
                        MOR + "\nYeniden deneme yapmak icin herhangi bir tusa basiniz.." +
                        MOR + "\nQ - Cikis yapmak icin Q'yu seciniz");
                input.nextLine();
                String exit = input.next();
                if (exit.equalsIgnoreCase("q")) {
                    flag = false;
                }else kutuphaneyeGiris();
            }

            int counter = 0;
            for (Map.Entry<String, Integer> w : kullanicilar.entrySet()) {//Sifre ve Kullanici adi uyumu kontrolu

                if (w.getKey().equalsIgnoreCase(kullaniciIsmi) && w.getValue().equals(sifre)) {
                    menu();

                } else {
                    counter++;
                }
            }
            if (counter == kullanicilar.size()) {
                System.out.println(KIRMIZI + "Yanlis Kullanici Adi veya Sifre Girdiniz");
                kutuphaneyeGiris();
            }


        } while (flag);
    }


    //    ******************************************  MENU  *********************************************************************
    public static void menu() {

        System.out.println(SARI +
                "Yapmak istediginiz islemi seciniz:\n" +
                "\n1-Kitap Ekle\n" +
                "2-Numara ile Kitap Goruntule\n" +
                "3-Bilgi ile Kitap Goruntule\n" +
                "4-Numara ile Kitap Sil\n" +
                "5-Tum Kitaplari Listele\n" +
                "Q-Cikis");

        String secim = input.next().toUpperCase();

        switch (secim) {

            case "1":
                kitapEkle();
                break;
            case "2":
                numaraIleKitapGoruntule();
                break;
            case "3":
                bilgiIleKitapGoruntule();
                break;
            case "4":
                numaraIleKitapSil();
                break;
            case "5":
                kitapListele();
                break;
            case "Q":
                cikis();
                break;
            default:
                System.out.println(KIRMIZI + "Yanlis giris yaptiniz ! Tekrar deneyiniz..");
                menu();
                break;

        }
    }


    //-----------------------------------------------      KITAP EKLE     -------------------------------------------------------------------
    public static void kitapEkle() {


        System.out.println(MOR + "Kaydetmek istediginiz kitabin adini giriniz..");
        input.nextLine();
        String kitapIsmi = input.nextLine();

        System.out.println("Kaydetmek istediginiz kitabin Yazar adini giriniz..");
        String yazarIsmi = input.nextLine();

        double fiyat = 0;

        try {
            System.out.println("Kaydedilecek kitabin fiyatini giriniz...");
            fiyat = Math.abs(input.nextDouble());// negatif fiyat almamak icin


        } catch (Exception e) {
            String str=input.next();
            System.out.println(KIRMIZI + "Hatali karakter girdiniz ,kontrol ederek tekrar deneyiniz");
            kitapEkle();

        }
        Kitap ktp1 = new Kitap(kitapNumber, kitapIsmi, yazarIsmi, fiyat);
        kitap.add(ktp1);

        kitapListele();

        menu();
    }


    // ***************************************      NUMARAYLA KITAP GORUNTULEME      *********************************************************
    public static void numaraIleKitapGoruntule() {

        System.out.println(MAVI + "Goruntulemek istediginiz kitabin numarasini giriniz");
        int kitapNo=0;
        try {
            kitapNo = input.nextInt();

        }catch (Exception e) {
            String str = input.next();
            System.out.println(KIRMIZI+"Kitap numarasina yalnizca rakam giriniz..");
            menu();
        }

        for (Kitap w : kitap) {           // Login kisminda counter kullanarak yaptigimiz islemi burada list ile yaptik
            // for döngüsünün icine if else yazmak tekrara düsürür bunu önledik
            if (w.getKitapNumarasi() == kitapNo) {
                geciciKitapListem.add(w);
            }
        }

        if (!geciciKitapListem.isEmpty()) {
            kitapListele2(geciciKitapListem);
            geciciKitapListem.clear();
            menu();
        } else {
            System.out.println(KIRMIZI + "Girdiginiz kitap no'ya ait Kitap bulunamadi");
            System.out.println(SARI + "Baska bir kitap görüntülemek icin herhangi bir tusa, Menuye dönmek icin M'yi seciniz..");
            String secim = input.next();
            if (secim.equalsIgnoreCase("M")) {
                menu();
            } else {
                numaraIleKitapGoruntule();
            }
        }


    }

    //------------------------------------------------    BILGI ILE KITAP GÖRÜNTÜLEME    -----------------------------------------------------------------
    public static void bilgiIleKitapGoruntule() {
        Scanner input = new Scanner(System.in);
        System.out.println(MAVI + "1-Kitap ismi ile arama\n" +
                "2-Yazar ismi ile arama\n" +
                "3-Kitap fiyatiyla arama" +
                "\nM-Menu");
        String secim = input.nextLine();


        switch (secim.toUpperCase()) {

            case "M":
                menu();
                break;

            case "1":     // **********KULLANICIDAN KITAP ADI ALARAK KITAP BILGISI GÖRÜNTÜLEME SECENEGI*************

                System.out.println("Lutfen kitap ismini giriniz..");
                String kitapIsmi = input.nextLine();

                for (Kitap w : kitap) {

                    if (w.getKitapAdi().equalsIgnoreCase(kitapIsmi)) {
                        geciciKitapListem.add(w);

                    }
                }

                if (!geciciKitapListem.isEmpty()) {
                    kitapListele2(geciciKitapListem);
                    geciciKitapListem.clear();
                    bilgiIleKitapGoruntule();

                } else {
                    System.out.println(KIRMIZI + "Aradiginiz kitap kütüphanemizde yoktur");
                    bilgiIleKitapGoruntule();
                }

                break;


            case "2":   //************ KULLANICIDAN YAZAR ADI ALARAK KITAP BILGISI GÖRÜNTÜLEME SECENEGI***************

                System.out.println("Lütfen yazarin adini giriniz");
                String yazarAdi = input.nextLine();

                for (Kitap w : kitap) {

                    if (w.getYazarAdi().equalsIgnoreCase(yazarAdi)) {

                        geciciKitapListem.add(w);
                    }
                }

                if (!geciciKitapListem.isEmpty()) {
                    kitapListele2(geciciKitapListem);
                    geciciKitapListem.clear();
                    bilgiIleKitapGoruntule();

                } else {
                    System.out.println(KIRMIZI + "Girdiginiz yazara ait kitap yoktur");
                    bilgiIleKitapGoruntule();
                }

                break;

            case "3":    //*************KULLANICIDAN FIYAT ARALIGI ALARAK KITAP BILGISI GÖRÜNTÜLEME SECENEGI*************


                System.out.println("Almak istediginiz kitap fiyat araligini giriniz");
                double fiyat1 =0;
                double fiyat2 =0;
                try {
                    fiyat1 = input.nextDouble();
                    fiyat2 = input.nextDouble();
                }catch (Exception e) {
                    String str = input.next();
                    System.out.println(KIRMIZI+"Fiyatlar rakam olarak girilmelidir.. Tekrar deneyiniz..");
                    bilgiIleKitapGoruntule();
                }

                double min = Math.min(fiyat1, fiyat2);
                double max = Math.max(fiyat1, fiyat2);

                for (Kitap w : kitap) {

                    if (w.getKitapFiyati() <= max && w.getKitapFiyati() >= min) {

                        geciciKitapListem.add(w);

                    }
                }
                if (!geciciKitapListem.isEmpty()) {
                    System.out.println(moneyFormat.format(min) + "-" + moneyFormat.format(max) + " fiyat araligindaki kitaplar:");
                    kitapListele2(geciciKitapListem);
                    geciciKitapListem.clear();
                    bilgiIleKitapGoruntule();

                } else {
                    System.out.println(KIRMIZI + "Aradiginiz fiyat araliginda kitap yoktur");
                }


                break;

            default:
                System.out.println(KIRMIZI+"Lütfen gecerli bir secim yapiniz");
                bilgiIleKitapGoruntule();


        }

    }

        //--------Kullanicidan Alinan KitapNo ile Kitap Silme ------------

    public static void numaraIleKitapSil() {
        System.out.println("Silmek istediginiz kitabin numarasini giriniz");
        input.nextLine();

        int number=0;
        try {
            number = input.nextInt();
        }catch (Exception e){
            String str = input.next();
            System.out.println(KIRMIZI+"Kitap Numarasi harf olamaz!");
            numaraIleKitapSil();
        }

        int size1 = kitap.size();
        for (Kitap w : kitap) {

            if (w.getKitapNumarasi() == number) {
                System.out.println(KIRMIZI + w.getKitapAdi() + " isimli kitabi silmek istediginize emin misiniz?\n" +
                        "E/H");
                String scm = input.next();
                if (scm.equalsIgnoreCase("h")) {
                    menu();
                } else if (scm.equalsIgnoreCase("e")) {
                    kitap.remove(w);
                    System.out.println(YESIL + "Silme isleminiz basariyla gerceklestirilmistir");
                    menu();
                }

            }
        }
        int size2 = kitap.size();
        if (size1 == size2) {
            System.out.println(KIRMIZI + "Silmek istediginiz kitap numarasi listede bulunmamaktadir\n");
            menu();
        }

    }
    //-------------------------------  TUM KITAPLARI LISTELE  ------------------------------

    public static void kitapListele() {
        System.out.println("------------------------------  KITAP LISTESI  --------------------------------");
        for (Kitap w : kitap) {

            System.out.println(CYAN + "KITAP NO: " + w.getKitapNumarasi() + "   ***   KITAP ADI: " + w.getKitapAdi() + "   ***   YAZAR ADI: " + w.getYazarAdi()
                    + "   ***   KITAP FIYATI: " + moneyFormat.format(w.getKitapFiyati()));
        }
        menu();
    }

    //----------------------------VERILEN LISTEDEKI KITAPLARI LISTELE----------------------------------
    public static void kitapListele2(List<Kitap> list) {
        System.out.println("------------------------------  KITAP LISTESI  --------------------------------");
        for (Kitap w : list) {

            System.out.println(CYAN + "KITAP NO: " + w.getKitapNumarasi() + "   ***   KITAP ADI: " + w.getKitapAdi() + "   ***   YAZAR ADI: " + w.getYazarAdi()
                    + "   ***   KITAP FIYATI: " + moneyFormat.format(w.getKitapFiyati()));
        }
    }

        //     ************************* *******CIKIS METODU******** *********************************

    public static void cikis() {
        System.out.println(MOR + "Cikmak istediginize emin misiniz?\n" +
                "Evet ise E'ye,\n" +
                "Menuye donmek icin M'ye basiniz");
        input.nextLine();
        String secim = input.nextLine();
        if (secim.equalsIgnoreCase("E")) {
            System.out.println(YESIL + "Cikis isleminiz basariyla gerceklestirilmistir");
            kutuphaneyeGiris();
        } else if (secim.equalsIgnoreCase("M")) {
            menu();
        } else {
            System.out.println(KIRMIZI + "Lutfen gecerli bir secim yapiniz");
            cikis();
        }
    }
}
