/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.manajemenarmadakereta;

/**
 *
 * @author masdika
 */

public class KeretaDiesel extends Kereta implements DapatServis {
    private int kapasitasBensinLiter;

    public KeretaDiesel(String kodeKereta, String namaKereta, int tahunOperasi, int kapasitasBensinLiter) throws Exception {
        super(kodeKereta, namaKereta, tahunOperasi);
        if (kapasitasBensinLiter <= 0) {
            throw new Exception("Kapasitas bahan bakar diesel harus lebih dari 0 liter.");
        }
        this.kapasitasBensinLiter = kapasitasBensinLiter;
    }

    public int getKapasitasBensinLiter() {
        return kapasitasBensinLiter;
    }

    public void setKapasitasBensinLiter(int kapasitasBensinLiter) {
        this.kapasitasBensinLiter = kapasitasBensinLiter;
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[Diesel]        Kode: %-8s | Nama: %-12s | Tahun: %d | Bahan Bakar: %d Liter", 
                          this.kodeKereta, this.namaKereta, this.tahunOperasi, this.kapasitasBensinLiter);
    }

    @Override
    public void caraOperasional() {
        System.out.println(" -> Info Operasional: Menggerakkan lokomotif menggunakan mesin diesel-elektrik untuk jalur jarak jauh.");
    }

    @Override
    public void hitungBiayaPerawatan() {
        System.out.println(" -> [Abstract] Biaya Perawatan Diesel: Rp 25.000.000 / bulan (Fokus overhaul mesin diesel & transmisi).");
    }

    @Override
    public void jadwalkanServisRutin() {
        System.out.println(" -> [Interface Servis] Jadwal servis berkala Kereta Diesel dilakukan setelah 5.000 km perjalanan.");
    }
}