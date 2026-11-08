/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.manajemenarmadakereta;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author masdika
 */


public class DepoKereta {
    private String namaDepo;
    private RuangKontrol ruangKontrolUtama; 
    private ArrayList<Kereta> daftarArmada; 
    private HashMap<String, Masinis> dataMasinis;

    public DepoKereta(String namaDepo) {
        this.namaDepo = namaDepo;
        this.ruangKontrolUtama = new RuangKontrol("Pusat Kontrol Operasional Kereta", 30);
        this.daftarArmada = new ArrayList<>();
        this.dataMasinis = new HashMap<>();
    }

    public void bukaDepo() {
        System.out.println("\n*** Menginisialisasi Depo: " + namaDepo + " ***");
        ruangKontrolUtama.aktifkanRuangan();
    }

    public void tambahArmada(Kereta k) {
        daftarArmada.add(k);
        System.out.println("Sukses! Armada berhasil ditambahkan ke depo. (Total Armada: " + daftarArmada.size() + ")");
    }

    public void tambahMasinis(Masinis m) {
        dataMasinis.put(m.getNip(), m);
        System.out.println("Berhasil mendaftarkan masinis baru!");
    }

    public void lihatSemuaArmada() {
        if (daftarArmada.isEmpty()) {
            System.out.println("Belum ada armada kereta yang tersimpan di depo.");
            return;
        }
        for (int i = 0; i < daftarArmada.size(); i++) {
            System.out.print((i + 1) + ". ");
            daftarArmada.get(i).tampilkanInfo();
            System.out.println();
            daftarArmada.get(i).caraOperasional();
            daftarArmada.get(i).hitungBiayaPerawatan();
            System.out.println();
        }
    }

    public void cariKereta(String kode) throws KeretaTidakDitemukanException {
        System.out.println("Mencari kereta dengan Kode: " + kode);
        boolean ditemukan = false;
        for (Kereta k : daftarArmada) {
            if (k.getKodeKereta().equalsIgnoreCase(kode)) {
                System.out.print(" Ditemukan: ");
                k.tampilkanInfo();
                System.out.println();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            throw new KeretaTidakDitemukanException("Gagal: Armada kereta dengan kode '" + kode + "' tidak terdaftar.");
        }
    }

    public void cariMasinis(String nip) {
        if (dataMasinis.containsKey(nip)) {
            System.out.println("Ditemukan! Nama Masinis: " + dataMasinis.get(nip).getNama());
        } else {
            System.out.println("Masinis dengan NIP tersebut tidak terdaftar.");
        }
    }

    public void lihatSemuaMasinis() {
        System.out.println("Total Masinis Terdaftar: " + dataMasinis.size());
        for (Masinis m : dataMasinis.values()) {
            System.out.println("- NIP: " + m.getNip() + " | Nama: " + m.getNama());
        }
    }

    public Masinis getMasinis(String nip) {
        return dataMasinis.get(nip);
    }

    public Kereta getKeretaInt(int index) {
        return daftarArmada.get(index);
    }

    public int getJumlahArmada() {
        return daftarArmada.size();
    }
}
