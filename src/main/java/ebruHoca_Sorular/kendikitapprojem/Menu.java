package ebruHoca_Sorular.kendikitapprojem;

import java.util.Map;
import java.util.Scanner;

import static ebruHoca_Sorular.kendikitapprojem.KitapPojo.*;

public class Menu {
    public static void menu(){
    System.out.println("     * 1-kitap ekle-//kitapEkle()\n" +
            "     * 2-numara ile kitap goruntule-//numaraIleKitap()\n" +
            "     * 3-bilgi ile kitap goruntule-//bilgiIleKitap()\n" +
            "     * 4-numara ile kitap sil-//numaraIleSil()\n" +
            "     * 5-tum kitaplari listele-//kitapListele()\n" +
            "     * 6-cikis-//cikis()\n" +
            "     ************************************");
    System.out.println("Yapmak istediginiz islemi seciniz:");
    Scanner input = new Scanner(System.in);

        String secim = input.next().toUpperCase();
    boolean scm = true;
    do {
        switch (secim) {
            case "1":
                kitapEkle();
                scm = false;
                break;
            case "2":
                numaraIleKitap();
                scm = false;
                break;
         /*     case "3":
                    bilgiIleKitap();
                    scm = false;
                    break;
                case "4":
                    numaraIleSil();
                    scm = false;
                    break;
          */      case "5":
                kitapListele();
                scm = false;
                break;
            case "6":
                cikis();
                scm = false;
                break;
            default:
                System.out.println( "Yanlis bir secim yaptiniz. Tekrar giris yapiniz");
                secim = input.next().toUpperCase();
        }
    } while (scm);

}

    public static void kitapEkle() {

        System.out.println("---------------------------# KITAP EKLEME SAYFASİ #---------------------------------");

        System.out.println("Eklemek istediginiz kitabin adini giriniz");
        String kitapAdi = input.next();
        System.out.println("Eklemek istediginiz kitabin yazarini giriniz");
        String yazarAdi = input.next();
        System.out.println("Eklemek istediginiz kitabin fiyatini giriniz");
        int kitapFiyati = input.nextInt();

        KitapPojo kitap = new KitapPojo(sayac, kitapAdi, yazarAdi, kitapFiyati);
        kitaplistesi.put(sayac, kitap);
        System.out.println(kitaplistesi);
        sayac++;


        System.out.println("Kitap basariyla eklenmistir.\n" );


        System.out.println("Kitap eklemeye devam etmek icin 1'e basiniz\n" +
                "Menu sayfasina donmek icin herhangibir tusa basiniz\n");
        System.out.println();
        String sss = input.next();

        if (sss.equals("1")) {
            kitapEkle();
        } else {
            menu();
        }

    }
    public static void   numaraIleKitap() {
        System.out.println("---------------------------# KITAP ARAMA SAYFASİ #---------------------------------");
        System.out.println("Aramak istediginiz kitabin kitap numarasini giriniz: ");
        int kitapNumarasi = input.nextInt();


        if (kitapNumaralariSet1.contains(kitapNumarasi)) {
            KitapPojo kitap = kitaplistesi.get(kitapNumarasi);


            System.out.println(kitap);
            System.out.println("Kitap aramaya devam etmek icin 1'e basiniz.\n " +
                    "Menuye donmek icin 2'ye basiniz\n" +
                    "Cikmak icin herhangi bir tusa basiniz");

            String sss = input.next();

            if (sss.equals("1")) {
                numaraIleKitap();
            } else if (sss.equals("2")) {
                menu();
            } else {
                cikis();
            }

        } else {
            System.out.println("Yanlis kitap numarasi girdiniz.");

            System.out.println("Kitap aramaya devam etmek icin 1'e basiniz.\n " +
                              "menusune donmek icin 2'ye basiniz\n" +
                              "Cikmakicin baska herhangi bir tusa basiniz");

            String sss = input.next();

            if (sss.equals("1")) {
                numaraIleKitap();
            } else if (sss.equals("2")) {
                menu();
            } else {
                cikis();
            }



        }

    }

    public static void kitapListele(){
       {
            System.out.println("---------------------------#  #--------------------------------------------------------");
            System.out.println(getKitapListeset());
        }

        /*
          for (Map.Entry<String, OgrenciPojo> w : ogrenciListeSet) {
                String key = w.getKey();

                System.out.printf("%-20s %-19s %-19s %-19s %-19s %-15s\n", key, ogrenciListesi.get(key).getAd(),
                        ogrenciListesi.get(key).getSoyad(), ogrenciListesi.get(key).getYas(), ogrenciListesi.get(key).getOkulNo(),
                        ogrenciListesi.get(key).getSinif());
            }

         */

        System.out.println( "menusune donmek icin 1'ye basiniz\n" +
                "Cikamk icin baska herhangi bir tusa basiniz");

        String sss = input.next();

        if (sss.equals("1")) {
            menu();
        } else {
            cikis();
        }

    }

    public static void cikis(){
        System.out.println("Cikisiniz basariyla yapilmistir. Tekrar görüsmek uzere");

    }



}
