package ebruHoca_Sorular.proje03_EmreBey;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Option extends Kitap {
    LinkedHashMap<Integer,Kitap> depo = new LinkedHashMap<>();
    int counter = 1000;
    Scanner scan = new Scanner(System.in);
    private void kitapEkle(){
        System.out.println("Kitap adini giriniz.");
        scan.nextLine();
        setKitapAdi(scan.nextLine());
        System.out.println("Lutfen yazar ismi ekleyin.");
        setYazarAdi(scan.nextLine());
        System.out.println("Lutfen kitap fiyati ekleyiniz");
        setFiyat(scan.nextDouble());
        counter++;
        depo.put(counter,new Kitap(getKitapAdi(),getYazarAdi(),getFiyat()));
        System.out.println(counter + " numarali kitap kaydedilmistir.");
        kitapEklemeyeDevamMi();
    }
    private void kitapEklemeyeDevamMi(){
        System.out.println("Kitap eklemeye devam etmek ister misiniz?Evet/Hayir");
        String secim = scan.next();
        if(secim.equalsIgnoreCase("evet")){
            kitapEkle();
        } else if (secim.equalsIgnoreCase("hayir")) {
            System.out.println("Ana sayfaya yonlendiriliyorsunuz.");
            scan.nextLine();
            menu();
        }else {
            System.out.println("Gecersiz secim.Tekrar deneyiniz.");
            kitapEklemeyeDevamMi();
        }
    }
    private void numaraIleKitapGor() {
        System.out.println("Kitap numarasini giriniz");
        int kitapNo = scan.nextInt();
        if (depo.containsKey(kitapNo)) {
            System.out.println(depo.get(kitapNo));
        } else {
            System.out.println("Bu numaraya ait bir kitap bulunamadi.");
        }
        numaraIleKitapGorDevamMi();
    }
    private void numaraIleKitapGorDevamMi(){
        System.out.println("Kitap no ile goruntelemeye devam etmek ister misiniz?Evet/Hayir");
        String secim = scan.next();
        if(secim.equalsIgnoreCase("evet")){
            numaraIleKitapGor();
        } else if (secim.equalsIgnoreCase("hayir")) {
            System.out.println("Ana sayfaya yonlendiriliyorsunuz.");
            scan.nextLine();
            menu();
        }else {
            System.out.println("Gecersiz secim.Tekrar deneyiniz.");
            numaraIleKitapGor();
        }
    }
    private void bilgiIleKitapGoruntule(){
        System.out.println("Hangi bilgi ile kitap verilerine ulasmak istersiniz.\n1.Kitap Adi\n2.Yazar Adi\n3.Kitap Fiyati");
        String secim = scan.next();
        switch (secim){
            case "1" :
                System.out.println("Kitap ismi giriniz.");
                scan.nextLine();
                String kitapIsmi= scan.nextLine();
                int sayac = 0;
                for (Map.Entry<Integer,Kitap> w: depo.entrySet()) {
                    if (w.getValue().getKitapAdi().equalsIgnoreCase(kitapIsmi)){
                        System.out.println(w);
                        sayac++;
                    }
                }
                if(sayac==0){
                    System.out.println("Bu isime ait bir kitap yoktur.");
                }
                break;
            case "2":
                System.out.println("Yazar ismi giriniz.");
                scan.nextLine();
                String yazarIsmi= scan.nextLine();
                System.out.println(depo.values().stream().anyMatch(t -> t.getYazarAdi().equalsIgnoreCase(yazarIsmi)) ?
                        f(yazarIsmi) : "Bu isme ait bir yazar yoktur.");
                /* int sayac2 = 0;
                for (Map.Entry<Integer,Kitap> w: depo.entrySet()) {
                    if (w.getValue().getYazarAdi().equalsIgnoreCase(yazarIsmi)){
                        System.out.println(w);
                        sayac2++;
                    }
                }
                if(sayac2==0){
                    System.out.println("Bu isime ait bir yazar yoktur.");
                } */
                break;
            case "3":
                System.out.println("Kitap fiyati giriniz");
                scan.nextLine();
                Double fiyat = scan.nextDouble();
                int sayac3 = 0;
                for (Map.Entry<Integer,Kitap> w: depo.entrySet()) {
                    if (w.getValue().getFiyat()==(fiyat)){
                        System.out.println(w);
                        sayac3++;
                    }
                }
                if(sayac3==0){
                    System.out.println("Bu fiyatta bir kitap yoktur.");
                }
                break;
            default:
                System.out.println("Yanlis bir secim yaptiniz.");
        }
        bilgiIleKitapGorDevamMi();
    }
    private List<Kitap> f(String yazarIsmi){
        return depo.values().stream().filter(t -> t.getYazarAdi().equalsIgnoreCase(yazarIsmi)).collect(Collectors.toList());
    }
    private void bilgiIleKitapGorDevamMi(){
        System.out.println("Bilgi ile goruntulemeye devam etmek ister misiniz?Evet/Hayir");
        String secim = scan.next();
        if(secim.equalsIgnoreCase("evet")){
            bilgiIleKitapGoruntule();
        } else if (secim.equalsIgnoreCase("hayir")) {
            System.out.println("Ana sayfaya yonlendiriliyorsunuz.");
            scan.nextLine();
            menu();
        }else {
            System.out.println("Gecersiz secim.Tekrar deneyiniz.");
            bilgiIleKitapGorDevamMi();
        }
    }
    private void numaraIleSil() {
        if (depo.size()!=0) {
            System.out.println("Kitap no girin");
            int silinecekNo = scan.nextInt();
            if (depo.containsKey(silinecekNo)) {
                depo.remove(silinecekNo);
                System.out.println("Girdiginiz numaraya ait kitap bilgileri silindi");
                counter--;
            } else {
                System.out.println("Boyle bir numara kutuphane listesinde kayitli degildir");
            }
            kitapSilDevamMi();
        }else {
            System.out.println("Kutuphane listemizde kitap bulunmamaktadir. Anasayfaya yonlendiriliyorsunuz");
            menu();
        }
    }
    private void kitapSilDevamMi(){
        System.out.println("Kitap silmeye devam etmek ister misiniz?Evet/Hayir");
        String secim = scan.next();
        if(secim.equalsIgnoreCase("evet")){
            numaraIleSil();
        } else if (secim.equalsIgnoreCase("hayir")) {
            System.out.println("Ana sayfaya yonlendiriliyorsunuz.");
            scan.nextLine();
            menu();
        }else {
            System.out.println("Gecersiz secim.Tekrar deneyiniz.");
            kitapSilDevamMi();
        }
    }
    private void kitaplariListele(){
        if(depo.size()==0){
            System.out.println("Goruntulenecek kitap bulunamadi. Kitap eklemek istermisiniz?Evet/Hayir");
            String secim= scan.next();
            if(secim.equalsIgnoreCase("evet")){
                kitapEkle();
            }else{
                System.out.println("Anasayfaya yonlendiriliyorsunuz.");
                menu();
            }
        }else {
            System.out.println("***Kutuphane listesi***\n"+depo);
            menu();
        }
    }
    private void cikis(){
        System.out.println("Tesekkurler..");
    }
    public void menu(){
        System.out.println("Kutuphanemize Hosgeldiniz..\nLutfen bir secim yapiniz\n1.Kitap Ekle\n2.Kitap No Ile Goruntule" +
                "\n3.Bilgi Ile Goruntule\n4.Kitap No Ile Sil\n5.Tum Kitaplari Listele\n6.Cikis.");
        int secim=0;
        try{
            secim = scan.nextInt();
            if(!(secim>0||secim<7)){
                throw new IllegalArgumentException();
            }
        }catch (Exception e){
            System.out.println("Gecersiz islem.Tekrar deneyiniz..");
            scan.nextLine();
            menu();
        }
        switch (secim){
            case 1:
                kitapEkle();
                break;
            case 2:
                numaraIleKitapGor();
                break;
            case 3:
                bilgiIleKitapGoruntule();
                break;
            case 4:
                numaraIleSil();
                break;
            case 5:
                kitaplariListele();
                break;
            case 6:
                cikis();
                break;
            default:
                System.out.println("Gecersiz islem.Tekrar deneyiniz.");
                menu();
        }
    }
}