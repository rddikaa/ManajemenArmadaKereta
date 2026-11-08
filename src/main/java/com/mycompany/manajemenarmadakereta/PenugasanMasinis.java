/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.manajemenarmadakereta;

/**
 *
 * @author masdika
 */
public class PenugasanMasinis {
    public static void prosesTugas(Masinis masinis, Kereta kereta) {
        System.out.println("\n==================================================");
        System.out.println("          SURAT TUGAS OPERASIONAL MASINIS         ");
        System.out.println("==================================================");
        System.out.println(" Masinis : " + masinis.getNama() + " (NIP: " + masinis.getNip() + ")");
        System.out.print(" Armada  : ");
        kereta.tampilkanInfo();
        System.out.println();
        kereta.caraOperasional();
        System.out.println(" Status  : Penugasan berhasil dicatat di sistem pusat.");
        System.out.println("==================================================");
    }
}