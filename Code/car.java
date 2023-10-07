import java.util.Scanner;
public class car {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
         //VARIABEL CAR
         double totalharga , waktu, hargaparkir = 5000,hargacucimobil = 25000, tambahangin = 2000;
         boolean ingincucimobil , ingintambahangin;
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
         tambahangin = input.nextBoolean();

        // sistem selection
        if (ingincucimobil) {
            totalharga = (hargacucimobil + hargaparkir * waktu);
        } else {
            totalharga = (hargaparkir * waktu);
        } if (ingintambahangin) {
            totalharga = (tambahangin + hargaparkir * waktu);
        } else {
            totalharga = (hargaparkir * waktu);
        }
          if (member)  {
            
          }
        
    
}
}