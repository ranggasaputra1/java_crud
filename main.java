/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latihan_pertemuan1_crud;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Year;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

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
        
        
//Setelah memilih menu maka akan tampil menggunakan switch case
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
        cariData();
        break;
    case "3":
        System.out.println("\n================");
        System.out.println("TAMBAH DATA BUKU");
        System.out.println("================");
        tambahData();
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
        
        FileReader fileInput;
        BufferedReader bufferInput;
        
        try{
            fileInput = new FileReader("C:\\Users\\rangg\\Documents\\NetBeansProjects\\Pemrograman Java Lanjut\\src\\latihan_pertemuan1_crud/database.txt");
            bufferInput = new BufferedReader(fileInput);
        }catch(FileNotFoundException e){
            System.err.println("Database tidak ditemukan");
            System.err.println("Silahkan Tambah data terlebih dahulu");
            return;
    }
        //Header
        System.out.println("\n| No | Tahun  |\tPenulis               | Penerbit              | Judul Buku");
        System.out.println("------------------------------------------------------------------------------");
        String data = bufferInput.readLine();
        int nomorData = 0;
        while(data != null){
            nomorData++;
        StringTokenizer stringToken = new StringTokenizer(data,",");
        stringToken.nextToken();
        System.out.printf("| %2d ", nomorData);
        System.out.printf("|\t%4s  ", stringToken.nextToken());
        System.out.printf("|\t%-20s  ",stringToken.nextToken());
        System.out.printf("| %-20s  ",stringToken.nextToken());
        System.out.printf("| %s  ",stringToken.nextToken());
        System.out.print("\n");
        data = bufferInput.readLine();
      }
        //Footer
        System.out.println("------------------------------------------------------------------------------");
 }
    
    private static void cariData()throws IOException{
//  Membaca database ada atau tidak
       try{
           //dibawah ini direktori database
            File file = new File("C:\\Users\\rangg\\Documents\\NetBeansProjects\\Pemrograman Java Lanjut\\src\\latihan_pertemuan1_crud/database.txt");
        }catch(Exception e){
            System.err.println("Database tidak ditemukan");
            System.err.println("Silahkan Tambah data terlebih dahulu");
            return;
    }
        
//  ambil Keyword dari user

    Scanner terminalInput = new Scanner(System.in);
        System.out.print("Masukan kata kunci untuk mencari buku: ");
    String cariString = terminalInput.nextLine();
        String[] keywords = cariString.split("\\s+");
//  cek di database
    cekBukuDiDatabase(keywords, true);
    
 }
    
    private static void tambahData()throws IOException{
         //dibawah ini direktori database
        FileWriter fileOutput = new FileWriter("C:\\Users\\rangg\\Documents\\NetBeansProjects\\Pemrograman Java Lanjut\\src\\latihan_pertemuan1_crud/database.txt",true);
        BufferedWriter bufferOutput = new BufferedWriter(fileOutput);
        
        
        //mengambil input dari user
        
        Scanner terminalInput = new Scanner(System.in);
        String penulis,judul,penerbit,tahun;
        
        System.out.print("Masukan Nama Penulis: ");
        penulis = terminalInput.nextLine();
        System.out.print("Masukan Judul Buku: ");
        judul = terminalInput.nextLine();
        System.out.print("Masukan Nama Penerbit: ");
        penerbit = terminalInput.nextLine();
        System.out.print("Masukan Tahun Terbit, format=(YYYY): ");
        tahun = ambilTahun();
        
        //cek buku di database
       
        String[] keywords = {tahun+","+penulis+","+penerbit+","+judul};
        System.out.println(Arrays.toString(keywords));
        
        boolean isExist = cekBukuDiDatabase(keywords, false);
        
        //menulis buku di database
        if(!isExist){
//        fiersabesari_2012_1,2012,fiersa besari,media kita,jejak langkah;

            System.out.println(ambilEntryPerTahun(penulis,tahun));
            long nomorEntry = ambilEntryPerTahun(penulis,tahun)+1;
            String penulisTanpaSpasi = penulis.replaceAll("\\s+", "");
            String primaryKey = penulisTanpaSpasi+"_"+tahun+"_"+nomorEntry;
            System.out.println("\nData yang akan anda masukana adalah: ");
            System.out.println("------------------------------------------");
            System.out.println("Primary key  : " + primaryKey);
            System.out.println("Tahun Terbit : " + tahun);
            System.out.println("penulis      : " + penulis);
            System.out.println("Judul        : " + judul);
            System.out.println("Penerbit     : " + penerbit);
            
            boolean isTambah = getYesorNo("Apakah anda ingin menambah data tersebut?");
            
            if(isTambah){
                bufferOutput.write(primaryKey+","+tahun+","+penulis+","+penerbit+","+judul);
                bufferOutput.newLine();
                bufferOutput.flush();
}
        }else{
                System.out.println("Buku yang anda akan masukan sudah ada di database dengan data berikut: ");
                cekBukuDiDatabase(keywords, true);
            }
        
        bufferOutput.close();
    }
    
    private static long ambilEntryPerTahun(String penulis, String tahun) throws FileNotFoundException, IOException{
        //dibawah ini direktori database
        FileReader fileInput = new FileReader("C:\\Users\\rangg\\Documents\\NetBeansProjects\\Pemrograman Java Lanjut\\src\\latihan_pertemuan1_crud/database.txt");
        BufferedReader bufferInput = new BufferedReader(fileInput);
        
        //fungsi ambil entry berdasarkan tahun
        long entry = 0;
        String data = bufferInput.readLine();
        Scanner dataScanner;
        String primaryKey;
        
        while(data != null){
            dataScanner = new Scanner(data);
            dataScanner.useDelimiter(",");
            primaryKey = dataScanner.next();
            dataScanner = new Scanner(primaryKey);
            dataScanner.useDelimiter("_");
            
            penulis = penulis.replaceAll("\\s+", "");
            if(penulis.equalsIgnoreCase(dataScanner.next())&& tahun.equalsIgnoreCase(dataScanner.next())){
                entry = dataScanner.nextInt();
            }
            
            data = bufferInput.readLine();
        }
        return entry;
    }
   
    private static boolean cekBukuDiDatabase(String[] keywords, boolean isDisplay)throws IOException{
        //dibawah ini direktori database
        FileReader fileInput = new FileReader("C:\\Users\\rangg\\Documents\\NetBeansProjects\\Pemrograman Java Lanjut\\src\\latihan_pertemuan1_crud/database.txt");
        BufferedReader bufferInput = new BufferedReader(fileInput);
        String data = bufferInput.readLine();
        boolean isExist = false;
        int nomorData = 0;
        
        if(isDisplay){
        //Header
        System.out.println("\n| No | Tahun  |\tPenulis               | Penerbit              | Judul Buku");
        System.out.println("------------------------------------------------------------------------------");
        }
        while(data != null){
            
        //cek keywords di dalam baris
        isExist = true;
        
        for(String keyword:keywords){
            isExist = isExist && data.toLowerCase().contains(keyword.toLowerCase());
            
        }        
        //jika keyword cocok maka tampilkan
        
        
        if(isExist){
            if(isDisplay){
        nomorData++;    
        StringTokenizer stringToken = new StringTokenizer(data,",");
        stringToken.nextToken();
        System.out.printf("| %2d ", nomorData);
        System.out.printf("|\t%4s  ", stringToken.nextToken());
        System.out.printf("|\t%-20s  ",stringToken.nextToken());
        System.out.printf("| %-20s  ",stringToken.nextToken());
        System.out.printf("| %s  ",stringToken.nextToken());
        System.out.print("\n");
            }else{
        break;
        }
        }
            data = bufferInput.readLine();

        }
        if(isDisplay){
        //Footer
        System.out.println("------------------------------------------------------------------------------");
        }
        return isExist;
}
    
     private static String ambilTahun()throws IOException{
        boolean tahunValid = false;
        Scanner terminalInput = new Scanner(System.in);
        String tahunInput = terminalInput.nextLine();
        
        while(!tahunValid){
            
        try{
        Year.parse(tahunInput);
        tahunValid = true;
    } catch (Exception e){
            System.err.println("Format tahun yang anda masukan salah, format=(YYYY)");
            System.out.print("Silahkan masukan tahun terbit lagi: ");
            tahunValid = false;
            tahunInput = terminalInput.nextLine();
    }
        }
        return tahunInput;
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

    private static void clearScreen() {
        
        // Dibawah ini fungsi clear screen bila dibuka di terminal
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