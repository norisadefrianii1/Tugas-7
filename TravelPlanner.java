package travelplan; // file berada dalam package travelplan

import java.util.NoSuchElementException; // untuk menangani exception saat input tidak ditemukan
import java.util.Scanner; // untuk membaca input dari pengguna

public class TravelPlanner { // main class

    // Method untuk validasi input biaya dan jumlah hari
    public static void validasiInput(double value, String namaInput) throws Validation {
        // Jika nilai kurang dari atau sama dengan 0, maka melemporkan exception
        // Validation
        if (value <= 0) {
            throw new Validation(namaInput + " harus lebih dari 0.");
        }
    }

    // Method untuk validasi apakah budget cukup atau tidak
    public static void ValidasiBudget(double budget, double totalCost) throws BudgetMin {
        // Jika budget kurang dari total biaya, maka melemparkan exception BudgetMin
        if (budget < totalCost) {
            throw new BudgetMin("Budget tidak cukup untuk perjalanan ini.");
        }
    }

    // Method utama untuk menjalankan program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("=== Travel Planner ===");

            // Meminta user untuk memasukkan jumlah destinasi
            System.out.print("Berapa destinasi yang ingin kamu input? ");
            int jumlahDestinasi = scanner.nextInt();
            scanner.nextLine();

            // Membuat array untuk menyimpan daftar destinasi
            Destinasi[] daftarDestinasi = new Destinasi[jumlahDestinasi];

            // Meminta user untuk memasukkan nama dan biaya per hari untuk setiap destinasi
            for (int i = 0; i < jumlahDestinasi; i++) {
                System.out.print("Nama destinasi ke-" + (i + 1) + ": ");
                String name = scanner.nextLine(); // Input nama destinasi

                System.out.print("Biaya per hari di " + name + ": ");
                double cost = scanner.nextDouble(); // Input biaya per hari
                scanner.nextLine();

                validasiInput(cost, "Biaya"); // Validasi input biaya

                daftarDestinasi[i] = new Destinasi(name, cost); // Menyimpan objek Destinasi ke dalam array
            }

            // Menampilkan daftar destinasi yang telah dimasukkan
            System.out.println("\n--- Daftar Destinasi ---");
            for (int i = 0; i < daftarDestinasi.length; i++) {
                System.out.printf("%d. %s (Rp%.0f per hari)%n", i + 1,
                        daftarDestinasi[i].getNama(), daftarDestinasi[i].getBiayaPerHari());
            }

            // Meminta user untuk memilih destinasi dari daftar yang telah dimasukkan
            System.out.print("Pilih destinasi (1-" + jumlahDestinasi + "): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            // Validasi jika pilihan di luar dari range destinasi yang ada
            if (pilihan < 1 || pilihan > jumlahDestinasi) { // Jika pilihan tidak valid maka lemparkan exception
                throw new ArrayIndexOutOfBoundsException("Pilihan destinasi tidak valid.");
            }

            Destinasi terpilih = daftarDestinasi[pilihan - 1]; // Mengambil destinasi yang dipilih oleh user

            // Meminta user untuk memasukkan jumlah hari menginap
            System.out.print("Berapa hari kamu ingin menginap? ");
            int hari = scanner.nextInt();
            scanner.nextLine();

            validasiInput(hari, "Jumlah hari"); // Validasi input hari

            // Meminta user untuk memasukkan budget yang dimiliki
            System.out.print("Masukkan budget kamu: ");
            double budget = scanner.nextDouble();
            scanner.nextLine();

            double totalCost = terpilih.getBiayaPerHari() * hari; // Menghitung total biaya perjalanan

            ValidasiBudget(budget, totalCost); // Validasi apakah budget cukup

            // Jika semua input valid, tampilkan rencana travelling
            System.out.println("\nRencana travelling berhasil dibuat!");
            System.out.printf("Destinasi: %s%nDurasi: %d hari%nTotal Biaya: Rp%.0f%nSisa Budget: Rp%.0f%n",
                    terpilih.getNama(), hari, totalCost, budget - totalCost);

            // Tangkap error jika user input selain
        } catch (NumberFormatException error) {
            System.out.println("Error: Input harus berupa angka yang valid ya! ");

            // Tangkap error jika jumlah destinasi kurang dari 0 atau pilihan salah
        } catch (NegativeArraySizeException | ArrayIndexOutOfBoundsException error) {
            System.out.println("Error: " + error.getMessage());

            // Tangkap error jika input kosong
        } catch (NoSuchElementException error) {
            System.out.println("Error: Input tidak ditemukan.");

            // Tangkap custom exception Validation dan BudgetMin
        } catch (Validation | BudgetMin error) {
            System.out.println("Error: " + error.getMessage());

            // Tangkap error lain yang tidak terduga
        } catch (Exception error) {
            System.out.println("Terjadi kesalahan tidak terduga: " + error.getMessage());

            // Blok yang selalu dijalankan di akhir
        } finally {
            scanner.close();
            System.out.println("Program selesai. Terima kasih telah menggunakan Travel Planner!");
        }
    }
}
