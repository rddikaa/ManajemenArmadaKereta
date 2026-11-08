/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.manajemenarmadakereta;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author masdika
 */
public class ManajemenArmadaKereta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        DepoKereta perpusUnila = new DepoKereta("Depo Utama Regional Lampung");
        perpusUnila.bukaDepo();
        
        boolean isRunning = true;

        System.out.println("==================================================");
        System.out.println("          SISTEM MANAJEMEN ARMADA KERETA          ");
        System.out.println("==================================================");

        while (isRunning) {
            try {
                System.out.println("\nMenu Utama:");
                System.out.println("1. Tambah Armada Kereta");
                System.out.println("2. Lihat Daftar Armada");
                System.out.println("3. Cari Kereta");
                System.out.println("4. Manajemen Masinis");
                System.out.println("5. Simulasi Penugasan Masinis");
                System.out.println("6. Keluar");
                System.out.print("Pilih Menu: 1-6: ");

                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1 -> {
                        System.out.println("\n-- Pilih Jenis Armada Kereta --");
                        System.out.println("1. Kereta Listrik (KRL)");
                        System.out.println("2. Kereta Diesel");
                        System.out.println("3. Kereta Cepat");
                        System.out.print("Pilihan (1-3): ");
                        int jenis = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Masukkan Kode Kereta: ");
                        String kode = scanner.nextLine();
                        System.out.print("Masukkan Nama Kereta: ");
                        String nama = scanner.nextLine();
                        System.out.print("Masukkan Tahun Operasi: ");
                        int tahun = scanner.nextInt();
                        scanner.nextLine();

                        if (jenis == 1) {
                            System.out.print("Masukkan Jumlah Rangkaian: ");
                            perpusUnila.tambahArmada(new KeretaListrik(kode, nama, tahun, scanner.nextInt()));
                        } else if (jenis == 2) {
                            System.out.print("Masukkan Kapasitas Bahan Bakar (Liter): ");
                            perpusUnila.tambahArmada(new KeretaDiesel(kode, nama, tahun, scanner.nextInt()));
                        } else if (jenis == 3) {
                            System.out.print("Masukkan Kecepatan Maksimal (km/jam): ");
                            perpusUnila.tambahArmada(new KeretaCepat(kode, nama, tahun, scanner.nextInt()));
                        }
                        scanner.nextLine();
                    }
                    case 2 -> {
                        System.out.println("\n--- Daftar Armada Kereta di Depo ---");
                        perpusUnila.lihatSemuaArmada();
                        System.out.println(" Total Seluruh Objek Kereta Terbuat: " + Kereta.totalKeretaBerhasilDibuat);
                        System.out.print("Tekan Enter untuk melanjutkan...");
                        scanner.nextLine();
                    }
                    case 3 -> {
                        System.out.println("\n-- Fitur Cari Kereta --");
                        System.out.print("Masukkan Kode Kereta: ");
                        String kataKunci = scanner.nextLine();
                        try {
                            perpusUnila.cariKereta(kataKunci);
                        } catch (KeretaTidakDitemukanException e) {
                            System.out.println("Peringatan: " + e.getMessage());
                        }
                        System.out.print("Tekan Enter untuk melanjutkan...");
                        scanner.nextLine();
                    }
                    case 4 -> {
                        System.out.println("\n-- Kelola Masinis --");
                        System.out.println("1. Tambah Masinis");
                        System.out.println("2. Cari Masinis");
                        System.out.println("3. Lihat Semua");
                        System.out.print("Pilih: ");
                        int menuM = scanner.nextInt();
                        scanner.nextLine();

                        if (menuM == 1) {
                            System.out.print("Masukkan NIP: ");
                            String nip = scanner.nextLine();
                            System.out.print("Masukkan Nama: ");
                            String nama = scanner.nextLine();
                            perpusUnila.tambahMasinis(new Masinis(nip, nama));
                        } else if (menuM == 2) {
                            System.out.print("NIP yg dicari: ");
                            perpusUnila.cariMasinis(scanner.nextLine());
                        } else if (menuM == 3) {
                            perpusUnila.lihatSemuaMasinis();
                        }
                        System.out.print("Tekan Enter untuk melanjutkan...");
                        scanner.nextLine();
                    }
                    case 5 -> {
                        System.out.println("\n-- Simulasi Penugasan Masinis (Association) --");
                        System.out.print("Masukkan NIP Masinis Petugas: ");
                        String inputNip = scanner.nextLine();
                        Masinis petugas = perpusUnila.getMasinis(inputNip);

                        if (petugas == null) {
                            System.out.println("Gagal: Masinis belum terdaftar!");
                        } else if (perpusUnila.getJumlahArmada() == 0) {
                            System.out.println("Gagal: Belum ada armada kereta di depo.");
                        } else {
                            perpusUnila.lihatSemuaArmada();
                            System.out.print("Pilih Nomor Armada yang ditugaskan: ");
                            int noArmada = scanner.nextInt() - 1;
                            scanner.nextLine();

                            if (noArmada >= 0 && noArmada < perpusUnila.getJumlahArmada()) {
                                Kereta itemTugas = perpusUnila.getKeretaInt(noArmada);
                                PenugasanMasinis.prosesTugas(petugas, itemTugas);
                            } else {
                                System.out.println("Nomor armada tidak valid!");
                            }
                        }
                        System.out.print("Tekan Enter untuk melanjutkan...");
                        scanner.nextLine();
                    }
                    case 6 -> {
                        System.out.println("Terima kasih telah menggunakan Sistem Manajemen Armada Kereta!");
                        isRunning = false;
                    }
                    default -> System.out.println("Pilihan tidak valid.");
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