
package ebruHoca_Sorular.proje03_kitapci;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Kitap {

    static ArrayList<Kitap> kitap = new ArrayList<>();
    static List<Kitap> geciciKitapListem = new ArrayList<>();

    static DecimalFormat moneyFormat = new DecimalFormat("###,##0.00'€'");
    static Scanner input = new Scanner(System.in);

    public static final String KIRMIZI = "\u001B[31m";
    public static final String SARI = "\u001B[33m";
    public static final String MAVI = "\u001B[34m";
    public static final String MOR = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String YESIL = "\u001B[32m";
    private int kitapNumarasi;
    private String kitapAdi ;
    private String yazarAdi ;
    private double kitapFiyati ;
    static int kitapNumber=1000;
    private int sifre;
    private int kullanici;


    public Kitap() {
    }

    public Kitap(int kitapNumarasi, String kitapAdi, String yazarAdi, double kitapFiyati) {
        this.kitapAdi = kitapAdi;
        this.yazarAdi = yazarAdi;
        this.kitapFiyati = kitapFiyati;
        this.kitapNumarasi=kitapNumarasi;
        kitapNumber++;

    }




    public int getKitapNumarasi() {
        return kitapNumarasi;
    }

    public void setKitapNumarasi(int kitapNumarasi) {
        this.kitapNumarasi = kitapNumarasi;
    }

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

    public int getSifre() {
        return sifre;
    }

    public void setSifre(int sifre) {
        this.sifre = sifre;
    }

    public int getKullanici() {
        return kullanici;
    }

    public void setKullanici(int kullanici) {
        this.kullanici = kullanici;
    }

    @Override

    public String toString() {
        return "Kitap{" +
                "kitapNumarasi=" + kitapNumarasi +
                ", kitapAdi='" + kitapAdi + '\'' +
                ", yazarAdi='" + yazarAdi + '\'' +
                ", kitapFiyati=" + kitapFiyati +
                '}';
    }



}