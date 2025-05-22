# Tugas-7
Program ini dibuat untuk membantu merencanakan perjalanan atau travelling secara sederhana. User bisa memasukkan beberapa destinasi, menentukan biaya perhari, jumlah hari menginap, dan budget yang dimiliki. Program akan menghitung total biaya perjalanan dan memberi tau apakah budgetnya cukup atau tidak.Tujuan lainnya untuk menerapkan konsep exception handling di java agar program tidak error saat menerima inputan yang tidak valid. Dengan adanya exception handling, program akan tetap berjalan meskipun inputan yang dimasukan oleh user tidak valid.

Tipe Exception yang digunakan 
1. NumberFormatException: Terjadi saat user memasukkan input selain angka.
2. NegativeArraySizeException: Terjadi saat user memasukkan nilai angka negatif.
3. ArrayIndexOutOfBoundsException: Terjadi saat user memilih destinasi perjalanan di laur daftar yang ada.
4. NoSuchElementException: Untuk menangani kondisi jika scanner salah membaca input atau scanner ga tersedia.
5. Validation (Custom): Untuk memeriksa apakah input berupa angka lebih dari 0.
6. BudgetMin (Custom): Untuk memeriksa apakah budget user cukup atau tidak.
