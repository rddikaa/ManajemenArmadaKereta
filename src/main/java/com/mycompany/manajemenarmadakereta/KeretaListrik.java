/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.manajemenarmadakereta;

/**
 *
 * @author masdika
 */

public class KeretaListrik extends Kereta implements DapatServis, DapatSubsidi {
    private int jumlahRangkaian;

    public KeretaListrik(String kodeKereta, String namaKereta, int tahunOperasi, int jumlahRangkaian) throws Exception {
        super(kodeKereta, namaKereta, tahunOperasi);
        if (jumlahRangkaian <= 0) {
            throw new Exception("Jumlah rangkaian kereta listrik minimal harus 1.");
        }
        this.jumlahRangkaian = jumlahRangkaian;
    }

    public int getJumlahRangkaian() {
        return jumlahRangkaian; 
    }
    public void setJumlahRangkaian(int jumlahRangkaian) {
        this.jumlahRangkaian = jumlahRangkaian; 
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[KRL / Listrik] Kode: %-8s | Nama: %-12s | Tahun: %d | Rangkaian: %d Kereta", 
                          this.kodeKereta, this.namaKereta, this.tahunOperasi, this.jumlahRangkaian);
    }

    @Override
    public void caraOperasional() {
        System.out.println(" -> Info Operasional: Menggunakan pasokan aliran listrik atas (Pantograph).");
    }

    @Override
    public void hitungBiayaPerawatan() {
        System.out.println(" -> [Abstract] Biaya Perawatan KRL: Rp 15.000.000 / bulan.");
    }

    @Override
    public void jadwalkanServisRutin() {
        System.out.println(" -> [Interface Servis] Servis rutin KRL dilakukan 1 bulan sekali.");
    }

    @Override
    public void hitungSubsidiOperasional() {
        System.out.println(" -> [Interface Subsidi] KRL menerima subsidi PSO dari pemerintah.");
    }
}