package Replitsorulari;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class S01_KelimeSayisi {
    /*
Bir string icerisindeki kelimelerin kac kez tekrar ettigini bulan bir method yaziniz.
input= "Ali   ,  okula ....geldi     ve Ayse   de   okula geldi
 */
    public static void main(String[] args) {
        String str = "Ali   ,  okula ....geldi     ve Ayse   de   okula geldi";
        String arr[] = str.replaceAll("\\p{Punct}","").replaceAll("\\s+"," ").split(" ");
        System.out.println(Arrays.toString(arr));
        Map<String,Integer> myMap = new HashMap<>();
        for (String w:arr){
            if(!myMap.containsKey(w)){
                myMap.put(w,1);
            }else{
                myMap.put(w,myMap.get(w)+1);
            }
        }
        System.out.println(myMap);

    }
}
