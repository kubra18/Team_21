package ebruHoca_Sorular.kendikitapprojem;

import java.util.*;

public class KitapPojo {
    private static int kitapNumarasi;

    public static int getKitapNumarasi() {
        return kitapNumarasi;
    }

    public static void setKitapNumarasi(int kitapNumarasi) {
        KitapPojo.kitapNumarasi = kitapNumarasi;
    }

    private String kitapAdi;
    private String yazarAdi;
    static int sayac=1000;
    public String getKitapAdi() {
        return kitapAdi;
    }

    public void setKitapAdi(String kitapAdi) {
        this.kitapAdi = kitapAdi;
    }

    public String getYazarAdi() {
        return yazarAdi;
    }

    public void setYazarAdi(String yazarAdi) {
        this.yazarAdi = yazarAdi;
    }

    public double getKitapFiyati() {
        return kitapFiyati;
    }

    public void setKitapFiyati(double kitapFiyati) {
        this.kitapFiyati = kitapFiyati;
    }

    public static int getSayac() {
        return sayac;
    }

    public static void setSayac(int sayac) {
        KitapPojo.sayac = sayac;
    }

    public static Scanner getInput() {
        return input;
    }

    public static void setInput(Scanner input) {
        KitapPojo.input = input;
    }

    public static Map<Integer, KitapPojo> getKitaplistesi() {
        return kitaplistesi;
    }

    public static void setKitaplistesi(Map<Integer, KitapPojo> kitaplistesi) {
        KitapPojo.kitaplistesi = kitaplistesi;
    }

    public static Set<Map.Entry<Integer, KitapPojo>> getKitapListeset() {
        return kitapListeset;
    }

    public static void setKitapListeset(Set<Map.Entry<Integer, KitapPojo>> kitapListeset) {
        KitapPojo.kitapListeset = kitapListeset;
    }

    public static Set<Integer> getKitapNumaralariSet1() {
        return kitapNumaralariSet1;
    }

    public static void setKitapNumaralariSet1(Set<Integer> kitapNumaralariSet1) {
        KitapPojo.kitapNumaralariSet1 = kitapNumaralariSet1;
    }

    private double kitapFiyati;


    static Scanner input = new Scanner(System.in);
    public KitapPojo(int sayac, String kitapAdi, String yazarAdi, double kitapFiyati) {
        this.kitapNumarasi = sayac;
        this.kitapAdi = kitapAdi;
        this.yazarAdi = yazarAdi;
        this.kitapFiyati = kitapFiyati;
        sayac++;
    }

    @Override
    public String toString() {
        return "KitapPojo{" +
                "kitapAdi='" + kitapAdi + '\'' +
                ", yazarAdi='" + yazarAdi + '\'' +
                ", kitapFiyati=" + kitapFiyati +
                '}';
    }

    static Map<Integer, KitapPojo> kitaplistesi = new HashMap<>();
    static Set<Map.Entry<Integer, KitapPojo>> kitapListeset = kitaplistesi.entrySet();
    static Set<Integer> kitapNumaralariSet1 = kitaplistesi.keySet();

    static Collection<KitapPojo> kitapBilgileriSet1 = kitaplistesi.values();

}