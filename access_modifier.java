/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latihan_pertemuan1_crud;

//Tugas Java Pertemuan 2 Latihan 1 CRUD(Contoh method access modifier)
//Rangga Saputra
//21110422
//Kelas G2021

//disini bisa digunakan untuk import package dan class ya rangga.



/**
 *
 * @author rangg
 */
public class access_modifier {
    
    public static void main(String[] args) {
        
        // rangga belajar acces modifier = public,private,default, dan protected
        
        //ini diambil dari method yang ada di file consume_access_modifier dan public bisa di akses
        consume_access_modifier.methodPublic();
        
        //sedangkan method access modifier ini tidak bisa di akes dari luar file
        //consume_access_modifier.methodPrivate();
        
        //ini bisa di akes karena berada di dalam package yang sama
        consume_access_modifier.methodDefault();
        
        //ini bisa di akes karena berada di dalam package yang sama 
        consume_access_modifier.methodProtected();
        
        //dibawah ini adalah contoh pemanggilan method diluar package akan tetapi agar bisa mengakses method 
        //tersebut harus melakukan import di bagian header fil dengan memanggil nama pacakage dan class nya.
        
        // contoh : memasak.memasak();
    }
    
}
