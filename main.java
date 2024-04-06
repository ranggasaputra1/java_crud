/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latihan_pertemuan1_crud;

import java.io.IOException;
import java.util.Scanner;

//Tugas Java Pertemuan 2 Latihan 1 CRUD(Membuat Halaman Main Menu)
//Rangga Saputra
//21110422
//Kelas G2021

/**
 *
 * @author rangg
 */
public class main {
    public static void main(String[] args) throws IOException {
        
//Dibawah ini code meminta inputan dari terminal
        Scanner terminalInput = new Scanner(System.in);
        String pilihanUser;
        boolean isLanjutkan=true;
        
        
//Menu yang akan ditampilkan
        while(isLanjutkan){
        clearScreen();
        System.out.println("Database Perpustakaan\n");
        System.out.println("1.\tLihat seluruh buku");
        System.out.println("2.\tCari data buku");
        System.out.println("3.\tTambah data buku");
        System.out.println("4.\tUbah data buku");
        System.out.println("5.\tHapus data buku");
        
        System.out.print("\n\nPilihan anda: ");
        pilihanUser = terminalInput.next();
        
        
//Setelah memilih menu maka akan tampil
        switch (pilihanUser) {
    case "1":
        System.out.println("\n================");
        System.out.println("LIST SELURUH BUKU");
        System.out.println("=================");
        tampilkanData();
        break;
    case "2":
        System.out.println("\n=========");
        System.out.println("CARI BUKU");
        System.out.println("=========");
        break;
    case "3":
        System.out.println("\n================");
        System.out.println("TAMBAH DATA BUKU");
        System.out.println("================");
        break;
    case "4":
        System.out.println("\n==============");
        System.out.println("UBAH DATA BUKU");
        System.out.println("==============");
        break;
    case "5":
        System.out.println("\n===============");
        System.out.println("HAPUS DATA BUKU");
        System.out.println("===============");
        break;
    default:
        System.err.println("\nInput anda tidak ditemukan\nSilahkan pilih opsi (1-5)");
}

// Message yang akan ditampilkan
        isLanjutkan = getYesorNo("Apakah anda ingin melanjutkan?");
      }
    }
    private static void tampilkanData() throws IOException{
        System.out.println("Kita akan menampilkan data dari method tampilkan data");
        
        boolean isTambah = getYesorNo("Apakah anda ingin menambah data?");
    }
    
    private static boolean getYesorNo(String message){
        
        Scanner terminalInput = new Scanner(System.in);
        //Buat kondisi untuk input terminal dilanjutkan atau tidak
        System.out.print("\n"+message+" (y/n)? ");
         String pilihanUser = terminalInput.next();
         
        while(!pilihanUser.equalsIgnoreCase("y") && !pilihanUser.equalsIgnoreCase("n")){
            System.err.println("Pilihan anda bukan y atau n");
            System.out.print("\n"+message+" (y/n)? ");
            pilihanUser = terminalInput.next();
        }
         
        return pilihanUser.equalsIgnoreCase("y");
    }
// Dibawah ini fungsi clear screen bila dibuka di terminal
    private static void clearScreen() {
        try{
            if(System.getProperty("os.name").contains("Windows")){
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            }else{
                System.out.print("\033\143");
            }
        }catch(IOException | InterruptedException ex){
            System.err.println("tidak bisa clear screen");
        }
    }
}

