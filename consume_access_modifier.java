/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latihan_pertemuan1_crud;


//Tugas Java Pertemuan 2 Latihan 1 CRUD(Contoh consume method access modifier)
//Rangga Saputra
//21110422
//Kelas G2021

/**
 *
 * @author rangg
 */
public class consume_access_modifier {
    
    //bagian ini dapat di akses oleh siapapun(class,metod,dll)
    public static void methodPublic(){
        System.out.println("Consume method Public");
        methodPrivate();
    }
    
    //hanya dapat di akses oleh kelas yang bersangkutan
    private static void methodPrivate() {
        System.out.println("Consume Method Private");
    }
    
    //ini hanya dapat diakses oleh kelas dalam package yang sama
    static void methodDefault() {
        System.out.println("Consume Method Default");
    }
    //ini hanya dapat diakses oleh class dalam package yang sama dan subclassnya
    protected static void methodProtected() {
        System.out.println("Consume Method Protected");
    }
    
}
