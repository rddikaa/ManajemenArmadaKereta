/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.manajemenarmadakereta;

/**
 *
 * @author masdika
 */
public class KeretaDiesel extends Kereta {
    private int kapasitasBensinLiter; 

    public KeretaDiesel(String kodeKereta, String namaKereta, int tahunOperasi, int kapasitasBensinLiter) {
        super(kodeKereta, namaKereta, tahunOperasi);
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
        System.out.println("\n -> Info Operasional: Menggerakkan lokomotif menggunakan mesin diesel-elektrik untuk jalur jarak jauh.");
    }
}