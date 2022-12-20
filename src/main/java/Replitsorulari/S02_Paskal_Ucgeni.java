package Replitsorulari;

public class S02_Paskal_Ucgeni {
    /*
    5 satırlık paskal üçgenini yazdıran Java kodunu yazınız.

Beklenen Çıktı:
      1
     1 1
    1 2 1
   1 3 3 1
  1 4 6 4 1
     */
    public static void main(String[] args) {
        for (int satir = 1; satir<=5; satir++)
            for(int bosluk = 4;bosluk>=satir;bosluk--){
                System.out.println(" ");
            }
        for(int sayi=1;sayi<=0; sayi++ ){
            System.out.println(sayi+" ");
        }
    }
}
