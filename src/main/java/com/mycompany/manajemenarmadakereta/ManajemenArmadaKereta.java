/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.manajemenarmadakereta;

import java.util.Scanner;

/**
 *
 * @author masdika
 */
public class ManajemenArmadaKereta {

    // COMPILE-TIME POLYMORPHISM (Method Overloading 1: Berdasarkan Kode Kereta / String)
    public static void cariKereta(String kodeKereta, Kereta[] daftarArmada, int jumlahArmada) {
        System.out.println("Mencari kereta dengan Kode: " + kodeKereta);
        boolean ditemukan = false;
        for (int i = 0; i < jumlahArmada; i++) {
            if (daftarArmada[i].getKodeKereta().equalsIgnoreCase(kodeKereta)) {
                System.out.print(" Ditemukan: ");
                daftarArmada[i].tampilkanInfo();
                System.out.println();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Armada kereta tidak ditemukan.");
        }
    }

    // COMPILE-TIME POLYMORPHISM (Method Overloading 2: Berdasarkan Tahun Operasi / Integer)
    public static void cariKereta(int tahunOperasi, Kereta[] daftarArmada, int jumlahArmada) {
        System.out.println("Mencari kereta dengan Tahun Operasi: " + tahunOperasi);
        boolean ditemukan = false;
        for (int i = 0; i < jumlahArmada; i++) {
            if (daftarArmada[i].getTahunOperasi() == tahunOperasi) {
                System.out.print(" Ditemukan: ");
                daftarArmada[i].tampilkanInfo();
                System.out.println();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Armada kereta tidak ditemukan.");
        }
    }

    // RUNTIME POLYMORPHISM & UPCASTING PARAMETER:
    // Menerima parameter bertipe Superclass (Kereta), sehingga bisa diisi Subclass apa saja.
    public static void simulasiOperasional(Kereta item) {
        item.caraOperasional(); // Dynamic Binding mengeksekusi method spesifik milik anak saat runtime
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // ARRAY SUPERCLASS (Polymorphism container untuk menampung berbagai macam subclass)
            Kereta[] daftarArmada = new Kereta[10];
            int jumlahArmada = 0;
            boolean isRunning = true;

            System.out.println("====================================================");
            System.out.println("|| SISTEM MANAJEMEN ARMADA KERETA (TUGAS MODUL 6) ||");
            System.out.println("====================================================");

            while (isRunning) {
                System.out.println("\nMenu Utama:");
                System.out.println("1. Tambah Armada Kereta");
                System.out.println("2. Lihat Daftar Armada (Dynamic Binding)");
                System.out.println("3. Cari Kereta (Compile-time / Overloading)");
                System.out.println("4. Keluar");
                System.out.print("Pilih Menu: 1-4: ");

                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1 -> {
                        if (jumlahArmada < daftarArmada.length) {
                            System.out.println("\n-- Pilih Jenis Armada Kereta --");
                            System.out.println("1. Kereta Listrik (KRL)");
                            System.out.println("2. Kereta Diesel");
                            System.out.println("3. Kereta Cepat");
                            System.out.print("Pilihan (1/2/3): ");
                            int jenis = scanner.nextInt();
                            scanner.nextLine();

                            System.out.print("Masukkan Kode Kereta: ");
                            String kodeBaru = scanner.nextLine();
                            System.out.print("Masukkan Nama Kereta: ");
                            String namaBaru = scanner.nextLine();
                            System.out.print("Masukkan Tahun Operasi: ");
                            int tahunBaru = scanner.nextInt();
                            scanner.nextLine();

                            // Upcasting: Objek Subclass disimpan ke dalam referensi/elemen array Superclass
                            if (jenis == 1) {
                                System.out.print("Masukkan Jumlah Rangkaian: ");
                                int rangkaian = scanner.nextInt();
                                scanner.nextLine();
                                daftarArmada[jumlahArmada] = new KeretaListrik(kodeBaru, namaBaru, tahunBaru, rangkaian);
                            } else if (jenis == 2) {
                                System.out.print("Masukkan Kapasitas Bahan Bakar (Liter): ");
                                int bensin = scanner.nextInt();
                                scanner.nextLine();
                                daftarArmada[jumlahArmada] = new KeretaDiesel(kodeBaru, namaBaru, tahunBaru, bensin);
                            } else if (jenis == 3) {
                                System.out.print("Masukkan Kecepatan Maksimal (km/jam): ");
                                int kecepatan = scanner.nextInt();
                                scanner.nextLine();
                                daftarArmada[jumlahArmada] = new KeretaCepat(kodeBaru, namaBaru, tahunBaru, kecepatan);
                            }

                            jumlahArmada++;
                            System.out.println("Sukses! Armada kereta berhasil ditambahkan.");
                        } else {
                            System.out.println("Maaf, kapasitas depo armada penuh!");
                        }
                    }
                    case 2 -> {
                        System.out.println("\n--- Daftar Armada Kereta di Depo ---");
                        if (jumlahArmada == 0) {
                            System.out.println("Belum ada armada kereta yang tersimpan.");
                        } else {
                            // RUNTIME POLYMORPHISM & DYNAMIC BINDING MELALUI LOOPING
                            for (int i = 0; i < jumlahArmada; i++) {
                                System.out.print((i + 1) + ". ");
                                daftarArmada[i].tampilkanInfo(); // Java mengecek wujud asli objek secara dinamis
                                System.out.println();
                                simulasiOperasional(daftarArmada[i]); // Upcasting ke parameter method
                                System.out.println();
                            }
                            System.out.println("\n Total Seluruh Armada: " + Kereta.totalKeretaBerhasilDibuat);
                        }
                        System.out.print("Tekan Enter untuk melanjutkan...");
                        scanner.nextLine();
                    }
                    case 3 -> {
                        System.out.println("\n-- Menu Pencarian Kereta (Overloading) --");
                        System.out.println("1. Cari berdasarkan Kode Kereta (String)");
                        System.out.println("2. Cari berdasarkan Tahun Operasi (Integer)");
                        System.out.print("Pilih (1/2): ");
                        int modeCari = scanner.nextInt();
                        scanner.nextLine();

                        if (modeCari == 1) {
                            System.out.print("Masukkan Kode Kereta yang dicari: ");
                            String keywordKode = scanner.nextLine();
                            cariKereta(keywordKode, daftarArmada, jumlahArmada);
                        } else if (modeCari == 2) {
                            System.out.print("Masukkan Tahun Operasi yang dicari: ");
                            int keywordTahun = scanner.nextInt();
                            scanner.nextLine();
                            cariKereta(keywordTahun, daftarArmada, jumlahArmada);
                        } else {
                            System.out.println("Pilihan tidak valid.");
                        }
                        System.out.print("Tekan Enter untuk melanjutkan...");
                        scanner.nextLine();
                    }
                    case 4 -> {
                        System.out.println("Terima kasih telah menggunakan Sistem Manajemen Armada Kereta!");
                        isRunning = false;
                    }
                    default -> System.out.println("Pilihan tidak valid. Silakan masukkan angka 1-4.");
                }
            }
        }
    }
}