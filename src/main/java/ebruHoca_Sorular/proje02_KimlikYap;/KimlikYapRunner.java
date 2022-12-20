package ebruHoca_Sorular.proje02_KimlikYap;

import static ebruHoca_Sorular.proje02_KimlikYap.KimlikYap.person;
import static ebruHoca_Sorular.proje02_KimlikYap.KimlikYap.selectOption;
 /*
                     1) Kullanicidan kimlik numarasini(4 haneli), tam ismini, adresini, telefonunu, alin
                     2) Kimlik numarasini key olarak, diger bilgileri value olarak bir map'e depolayin

                     saveInfo() method olusturun:
                     3)Kullanicidan bircok kimlik numarasi(4 haneli), isim, adres ve telefon alin.
                     4)Kimlik numarasini key olarak, diger bilgileri value olarak bir map'e depolayin.
                     5)Ayni kimlik numarasi ile bilgi girilmesine engel olun.

                	 getInfo() method olusturun:
          		     1)Kimlik numarasini girerek kullanicinin bilgilerine ulasin.
                     2)Olmayan kimlik numarasi girilirse kullaniciya hata mesaji verin.

                     removeInfo() method olusturun:
                     1)Kimlik numarasini girerek data silin.
                     2)Girilen kimlik numarasi yoksa kullaniciya hata mesaji verin.
                     3)Collection bos ise kullaniciya hata mesaji verin.

                     selectOption() method olusturun:
                     1)Yukaridaki 3 methodu programi sonlandirana kadar secme hakki verin
               */


public class KimlikYapRunner {

    public static void main(String[] args) {

        person.put("2345",new proje02_KimlikYap.Persons("Dilara","Samsun","01478520"));
        person.put("3345",new proje02_KimlikYap.Persons("Busra","Kars","01478521"));
        person.put("4345",new proje02_KimlikYap.Persons("Merve","Hatay","01478522"));
        selectOption();

    }
}
