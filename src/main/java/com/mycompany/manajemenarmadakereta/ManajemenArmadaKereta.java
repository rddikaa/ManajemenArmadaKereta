/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.manajemenarmadakereta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author masdika
 */
public class ManajemenArmadaKereta {
public static void cariKereta(String kodeKereta, ArrayList<Kereta> daftarArmada) throws KeretaTidakDitemukanException {
        System.out.println("Mencari kereta dengan Kode: " + kodeKereta);
        boolean ditemukan = false;
        for (int i = 0; i < daftarArmada.size(); i++) {
            if (daftarArmada.get(i).getKodeKereta().equalsIgnoreCase(kodeKereta)) {
                System.out.print(" Ditemukan: ");
                daftarArmada.get(i).tampilkanInfo();
                System.out.println();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            throw new KeretaTidakDitemukanException("Gagal: Armada kereta dengan kode '" + kodeKereta + "' tidak terdaftar di depo.");
        }
    }

    public static void simulasiOperasional(Kereta item) {
        item.caraOperasional();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Kereta> daftarArmada = new ArrayList<>();
        HashMap<String, String> dataMasinis = new HashMap<>();
        
        boolean isRunning = true;

        System.out.println("==================================================");
        System.out.println("||        SISTEM MANAJEMEN ARMADA KERETA        ||");
        System.out.println("==================================================");

        while (isRunning) {
            try {
                System.out.println("\nMenu Utama:");
                System.out.println("1. Tambah Armada Kereta");
                System.out.println("2. Lihat Daftar Armada");
                System.out.println("3. Cari Kereta (Custom Exception)");
                System.out.println("4. Kelola Data Masinis (Demo HashMap)");
                System.out.println("5. Keluar");
                System.out.print("Pilih Menu: 1-5: ");

                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1 -> {
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

                        if (jenis == 1) {
                            System.out.print("Masukkan Jumlah Rangkaian: ");
                            int rangkaian = scanner.nextInt();
                            scanner.nextLine();
                            daftarArmada.add(new KeretaListrik(kodeBaru, namaBaru, tahunBaru, rangkaian));
                        } else if (jenis == 2) {
                            System.out.print("Masukkan Kapasitas Bahan Bakar (Liter): ");
                            int bensin = scanner.nextInt();
                            scanner.nextLine();
                            daftarArmada.add(new KeretaDiesel(kodeBaru, namaBaru, tahunBaru, bensin));
                        } else if (jenis == 3) {
                            System.out.print("Masukkan Kecepatan Maksimal (km/jam): ");
                            int kecepatan = scanner.nextInt();
                            scanner.nextLine();
                            daftarArmada.add(new KeretaCepat(kodeBaru, namaBaru, tahunBaru, kecepatan));
                        }

                        System.out.println("Sukses! Armada kereta berhasil ditambahkan. (Total: " + daftarArmada.size() + ")");
                    }
                    case 2 -> {
                        System.out.println("\n--- Daftar Armada Kereta di Depo ---");
                        if (daftarArmada.isEmpty()) {
                            System.out.println("Belum ada armada kereta yang tersimpan.");
                        } else {
                            for (int i = 0; i < daftarArmada.size(); i++) {
                                System.out.print((i + 1) + ". ");
                                daftarArmada.get(i).tampilkanInfo();
                                System.out.println();
                                simulasiOperasional(daftarArmada.get(i));
                                daftarArmada.get(i).hitungBiayaPerawatan();

                                if (daftarArmada.get(i) instanceof DapatServis s) {
                                    s.jadwalkanServisRutin();
                                }
                                if (daftarArmada.get(i) instanceof DapatSubsidi sub) {
                                    sub.hitungSubsidiOperasional();
                                }
                                System.out.println();
                            }
                            System.out.println(" Total Seluruh Objek Terbuat: " + Kereta.totalKeretaBerhasilDibuat);
                        }
                        System.out.print("Tekan Enter untuk melanjutkan...");
                        scanner.nextLine();
                    }
                    case 3 -> {
                        System.out.println("\n-- Menu Pencarian Kereta (Custom Exception) --");
                        System.out.print("Masukkan Kode Kereta yang dicari: ");
                        String keywordKode = scanner.nextLine();
                        
                        try {
                            cariKereta(keywordKode, daftarArmada);
                        } catch (KeretaTidakDitemukanException e) {
                            System.out.println("Peringatan: " + e.getMessage());
                        } finally {
                            System.out.println("-> Sesi pencarian selesai dieksekusi.");
                        }
                        
                        System.out.print("Tekan Enter untuk melanjutkan...");
                        scanner.nextLine();
                    }
                    case 4 -> {
                        System.out.println("\n-- Kelola Data Masinis (HashMap) --");
                        System.out.println("1. Tambah Masinis Baru");
                        System.out.println("2. Cari Masinis via ID (Key)");
                        System.out.println("3. Tampilkan Semua Masinis");
                        System.out.print("Pilih (1-3): ");
                        int menuMasinis = scanner.nextInt();
                        scanner.nextLine();

                        if (menuMasinis == 1) {
                            System.out.print("Masukkan ID Pegawai (Key): ");
                            String id = scanner.nextLine();
                            System.out.print("Masukkan Nama Masinis (Value): ");
                            String nama = scanner.nextLine();
                            dataMasinis.put(id, nama);
                            System.out.println("Berhasil mendaftarkan masinis baru!");
                        } else if (menuMasinis == 2) {
                            System.out.print("Masukkan ID yang dicari: ");
                            String searchId = scanner.nextLine();
                            if (dataMasinis.containsKey(searchId)) {
                                System.out.println("Ditemukan! Nama Masinis: " + dataMasinis.get(searchId));
                            } else {
                                System.out.println("Masinis dengan ID tersebut tidak terdaftar.");
                            }
                        } else if (menuMasinis == 3) {
                            System.out.println("Total Masinis Terdaftar: " + dataMasinis.size());
                            for (String keyId : dataMasinis.keySet()) {
                                System.out.println("- ID: " + keyId + " | Nama: " + dataMasinis.get(keyId));
                            }
                        }
                        System.out.print("Tekan Enter untuk melanjutkan...");
                        scanner.nextLine();
                    }
                    case 5 -> {
                        System.out.println("Terima kasih telah menggunakan Sistem Manajemen Armada Kereta!");
                        isRunning = false;
                    }
                    default -> System.out.println("Pilihan tidak valid. Silakan masukkan angka 1-5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\n[ERROR INPUT] Format salah: Anda wajib memasukkan angka!");
                scanner.nextLine(); 
            } catch (Exception e) {
                System.out.println("\n[SYSTEM ERROR] Terjadi kesalahan: " + e.getMessage());
            }
        }
        scanner.close();
    }
}