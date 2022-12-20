package ebruHoca_Sorular.proje03_EmreBey;

public class Kitap {
    private String kitapAdi;
    private String yazarAdi;
    private double fiyat;
    public Kitap(){
    }
    public Kitap(String kitapAdi, String yazarAdi, double fiyat) {
        this.kitapAdi = kitapAdi;
        this.yazarAdi = yazarAdi;
        this.fiyat = fiyat;
    }
    @Override
    public String toString() {
        return "{" +
                "kitapAdi='" + kitapAdi + '\'' +
                ", yazarAdi='" + yazarAdi + '\'' +
                ", fiyat=" + fiyat +
                '}';
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
    public double getFiyat() {
        return fiyat;
    }
    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }
}
