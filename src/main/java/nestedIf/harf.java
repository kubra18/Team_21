package nestedIf;

import java.util.Scanner;

public class harf {

    /*
    Kullanıcıdan bir harf girmesini isteyiniz. Girilen harf sesli ise Sesli harf olduğunu, değilse sessiz harf olduğunu ekrana yazdırsın.
    Girdiği değer harf değilse yada 1 karakterden fazla ise hata mesajı göstersin. (Test girilen harfi büyük yada küçüklüğüne duyarlıdır.)

    Sesli harfler: a,e,i,o,u

    Test Data:
    a

    Beklenen Çıktı:
    a harfi sesli harfdir.

    Test Data:
    d

    Beklenen Çıktı:
    d harfi sesiz harftir.

    Test Data:
    we  yada %

    Beklenen Çıktı:
    Yanlis karakter girdiniz!

     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Bir harf giriniz");
        String harf = input.next();
        if ((harf.length()>1)||("[^a-zA-Z]").contains(harf)){
            System.out.println("hatali giris yaptiniz");
        }
        if (harf.equals("a") ||
                harf.equals("e") ||
                harf.equals("i") ||
                harf.equals("o") ||
                harf.equals("u") ||
                harf.equals("A") ||
                harf.equals("E") ||
                harf.equals("I") ||
                harf.equals("O") ||
                harf.equals("U")) {
            System.out.println(harf + " sesli harftir");
        } else {
            System.out.println(harf + " sesli harf degildir");
        }

    }

}















