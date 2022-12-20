
package ebruHoca_Sorular.proje02_KimlikYap;

import java.util.HashMap;

import java.util.Scanner;

public class KimlikYap {

    static HashMap<String , proje02_KimlikYap.Persons> person = new HashMap<>();

    static Scanner sc = new Scanner(System.in);

    static void selectOption() {
        System.out.println("yapmak istediginiz islemi giriniz :\n0:islemi sonlandir\n" +
                "1:kullanici ekle\n2:kullanici bilgisi alma\n3:kullanici silme");

        int secim = sc.nextInt();//nextLine hata verir.çünkü bir üst satır println değil print olduğu için tum satırı alır.
        switch (secim) {
            case 0:
                cikis();
                break;
            case 1:
                saveInfo();
                selectOption();
                break;
            case 2:
                getInfo();
                selectOption();
                break;
            case 3:
                removeInfo();
                selectOption();
                break;
            default:
                System.out.println("yanlis giris yaptiniz. Tekrar deneyiniz");
                selectOption();
                break;
        }
    }
    public static void saveInfo() {


        System.out.println("Id numaranizi girniz");

        String idNumber = sc.next();

     if (idNumber.length()!=4){

            System.out.println("Girilen ID no gecersiz ! ");
            saveInfo();
        }
        else if (person.containsKey(idNumber)){
            System.out.println("Zaten varolan bir IdNumber girdiniz...Kontrol ederek tekrar deneyiniz");
            saveInfo();
        }else {

            System.out.println("Lütfen Ad giriniz");
            String name = sc.next();

            System.out.println("Lütfen SoyAd giriniz");
            String surname = sc.next();

            System.out.println("Lütfen Adresinizi girniz");
            String adressInfo = sc.next();


            System.out.println("Telefon numaranizi giriniz");
            String telNumber = sc.next();

            proje02_KimlikYap.Persons p01 = new proje02_KimlikYap.Persons(name.concat(" ").concat(surname), adressInfo, telNumber);

            person.put(idNumber, p01);

            System.out.println(person);
        }
    }
    public static void cikis() {
        System.out.println("Cikis basariyla yapildi ");

    }

    public static void getInfo(){


        System.out.println("Lütfen bilgi almak istediginiz kisinin idNumberini giriniz");
        String idNo = sc.next();
        person.get(idNo);
        if (!person.containsKey(idNo)){
            System.out.println("Girdiginiz id no'ya ait sistemde kayitli bir kisi yoktur");
            getInfo();

        }else {
            System.out.println(person.get(idNo));

        }
    }

    public static void removeInfo(){

        System.out.println("Silmek istediginiz kisinin Id numarasini girniz");

        String idNumber = sc.next();

        if (!person.containsKey(idNumber)){

            System.out.println("Girdiginiz id sistemde kayitli degil");
            removeInfo();
        }else {
            person.remove(idNumber);
            System.out.println("silme islemi basariyla tamamlandi");
            System.out.println(person);

        }
    }

}