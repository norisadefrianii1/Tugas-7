package travelplan;

// Class custom exception untuk validasi inpit dari biaya atau jumlah hari yang tidak valid
public class Validation extends Exception {
    // Konstruktor menerima pesan error yang akan ditampilkan pada saat exception
    // ditangkap
    public Validation(String Message) {
        super(Message);
    }
}
