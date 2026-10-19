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

    public KeretaListrik(String kodeKereta, String namaKereta, int tahunOperasi, int jumlahRangkaian) {
        super(kodeKereta, namaKereta, tahunOperasi);
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
        System.out.println(" -> Info Operasional: Menggunakan pasokan aliran listrik atas (Pantograph) untuk komuter perkotaan.");
    }

    @Override
    public void hitungBiayaPerawatan() {
        System.out.println(" -> [Abstract] Biaya Perawatan KRL: Rp 15.000.000 / bulan (Fokus perawatan pantograf & kelistrikan).");
    }

    @Override
    public void jadwalkanServisRutin() {
        System.out.println(" -> [Interface Servis] Jadwal servis berkala KRL dilakukan setiap 1 bulan sekali di Depo KRL.");
    }

    @Override
    public void hitungSubsidiOperasional() {
        System.out.println(" -> [Interface Subsidi] KRL berhak menerima subsidi PSO (Public Service Obligation) dari pemerintah.");
    }
}