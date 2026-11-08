/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.manajemenarmadakereta;

/**
 *
 * @author masdika
 */

public class RuangKontrol {
    private String namaRuangan;
    private int kapasitasMonitor;

    public RuangKontrol(String namaRuangan, int kapasitasMonitor) {
        this.namaRuangan = namaRuangan;
        this.kapasitasMonitor = kapasitasMonitor;
    }

    public void aktifkanRuangan() {
        System.out.println("-> [Komposisi] " + namaRuangan + " diaktifkan dengan kapasitas " + kapasitasMonitor + " monitor kontrol.");
    }
}