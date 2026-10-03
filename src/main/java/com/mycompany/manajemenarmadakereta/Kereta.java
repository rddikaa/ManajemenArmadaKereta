/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.manajemenarmadakereta;

/**
 *
 * @author masdika
 */
public class Kereta {
    protected String kodeKereta;
    protected String namaKereta;
    protected int tahunOperasi;
    
    public static int totalKeretaBerhasilDibuat = 0;
    
    public Kereta(String kodeKereta, String namaKereta, int tahunOperasi) {
        this.kodeKereta = kodeKereta;
        this.namaKereta = namaKereta;
        this.tahunOperasi = tahunOperasi;
        totalKeretaBerhasilDibuat++;
    }
    
    public String getKodeKereta() { 
        return this.kodeKereta; 
    }
    
    public int getTahunOperasi() { 
        return this.tahunOperasi; 
    }
    
    public void tampilkanInfo() {
        System.out.printf("Kode: %-10s | Nama: %-15s | Tahun: %d", 
                          this.kodeKereta, this.namaKereta, this.tahunOperasi);
    }
    
    public void caraOperasional() {
        System.out.println("Armada kereta beroperasi sesuai jalur rel utama.");
    }
}
