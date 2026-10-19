/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.manajemenarmadakereta;

/**
 *
 * @author masdika
 */
public class KeretaCepat extends Kereta implements DapatServis {
    private int kecepatanMaksJam;
    
    public KeretaCepat(String kodeKereta, String namaKereta, int tahunOperasi, int kecepatanMaksJam) {
        super(kodeKereta, namaKereta, tahunOperasi);
        this.kecepatanMaksJam = kecepatanMaksJam;
    }

    public int getKecepatanMaksJam() {
        return kecepatanMaksJam;
    }

    public void setKecepatanMaksJam(int kecepatanMaksJam) {
        this.kecepatanMaksJam = kecepatanMaksJam;
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[Kereta Cepat]  Kode: %-8s | Nama: %-12s | Tahun: %d | Kecepatan: %d km/jam", 
                          this.kodeKereta, this.namaKereta, this.tahunOperasi, this.kecepatanMaksJam);
    }

    @Override
    public void caraOperasional() {
        System.out.println(" -> Info Operasional: Memanfaatkan jalur rel khusus berteknologi tinggi (ballastless track).");
    }

    @Override
    public void hitungBiayaPerawatan() {
        System.out.println(" -> [Abstract] Biaya Perawatan Kereta Cepat: Rp 50.000.000 / bulan (Inspeksi jalur rel & sistem aerodinamika).");
    }

    @Override
    public void jadwalkanServisRutin() {
        System.out.println(" -> [Interface Servis] Pengecekan sensor & rel khusus Kereta Cepat dilakukan setiap malam hari.");
    }
}