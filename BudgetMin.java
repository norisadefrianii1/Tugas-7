package travelplan;

// Class custom exception untuk validasi budget yang tidak cukup
public class BudgetMin extends Exception {
    // Konstruktor menerima pesan error yang akan ditampilkan pada saat exception
    // ditangkap
    public BudgetMin(String Message) {
        super(Message);
    }
}
