/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.manajemenarmadakereta;

/**
 *
 * @author masdika
 */
public class KeretaListrik extends Kereta {
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
        System.out.println("\n -> Info Operasional: Menggunakan pasokan aliran listrik atas (Pantograph) untuk komuter perkotaan.");
    }
}
