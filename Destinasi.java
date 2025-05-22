package travelplan;

// Class destinasi untuk menyimpan informasi tentang destinasi
public class Destinasi {
    private String nama; // Nama destinasi
    private double biayaPerHari; // Biaya destinasi per hari

    // Konstruktor untuk menginisialisasi nama dan biaya per hari
    public Destinasi(String nama, double biayaPerHari) {
        this.nama = nama;
        this.biayaPerHari = biayaPerHari;
    }

    // Method untuk mendapatkan nama destinasi
    public String getNama() {
        return nama;
    }

    // Method untuk mendapatkan biaya per hari
    public double getBiayaPerHari() {
        return biayaPerHari;
    }
}
