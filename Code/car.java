import java.util.Scanner;
public class car {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
         //VARIABEL CAR
         double totalharga , waktu, hargaparkir = 5000,hargacucimobil , tambahangin = 2000;
         boolean ingincucimobil , ingintambahangin, inginmember ; 
         String nama_user, platnomor, tipemobil;


         //sistem pertama
         System.out.println("Input nama user");
         nama_user = input.next();
         System.out.println("Input plat nomor");
         platnomor = input.next();
         System.out.println("Tipe mobil");
         tipemobil = input.next();
         System.out.println("waktu");
         waktu = input.nextDouble();
         System.out.println("ingin cuci mobil atau tidak? (true/false)");
         ingincucimobil = input.nextBoolean();
         System.out.println("tambah angin? (true/false)");
         ingintambahangin = input.nextBoolean();

        
        
        
         // sistem selection
        if (ingincucimobil) 
        System.out.println("pilih jenis layanan cuci mobil (prem/reg)");
        String tipelayanan = input.next();
        if (tipelayanan.equalsIgnoreCase("prem")) {
            hargacucimobil = 20000;
        } else if (tipelayanan.equalsIgnoreCase("reg")){
            hargacucimobil = 30000;
        } else {
            System.out.println("input tidak valid gunakan (prem/reg)");
        return;
        }
       
       
       
       // harga parkir 
       System.out.println("harga parkir perjam = ");
       waktu = input.nextDouble();
        totalharga = (hargaparkir * waktu);


       // harga cuci mobil
        if (ingincucimobil) { 
          totalharga += hargacucimobil;
             System.out.println("harga titip cuci mobil" + hargacucimobil);
        }
        
        
        
            // tambah angin
         if (ingintambahangin) {
        totalharga = (tambahangin + totalharga);
        System.out.println("total pemabayaran = " + totalharga);
        }
        
        

        // menginput member atau tidak member
          System.out.println("apakah pengguna parkir adalah member? ( true/false)");
            inginmember = input.nextBoolean();

            // status dari member
        System.out.println("input status member (1 =  exsecutive)");








        }
}