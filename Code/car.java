import java.util.Scanner;
public class car {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
         //VARIABEL CAR
         double totalharga , waktu, hargaparkir = 5000,hargacucimobil , tambahangin = 2000;
         boolean ingincucimobil , ingintambahangin, inginmember ; 
         String nama_user, platnomor, tipemobil ;

         //sistem pertama
         System.out.println("Input nama user");
         nama_user = input.next();
         System.out.println("Input plat nomor");
         platnomor = input.next();
         System.out.println("Tipe mobil");
         tipemobil = input.next();
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
       System.out.println("input jam parkir = ");
       waktu = input.nextDouble();
        totalharga = (hargaparkir * waktu);
        System.out.println("harga parkir =");

       // harga cuci mobil
        if (ingincucimobil) { 
          totalharga += hargacucimobil;
             System.out.println("harga cuci mobil =" + hargacucimobil);
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
        if (inginmember) {
            System.out.println("input status member (1 =  executive) ( 2  = premium) (3= reguler)");
        int statusmember = input.nextInt();
        if (statusmember == 1) {
            System.out.println("executive"); ;
        } else if (statusmember == 2) {
            System.out.println("premium");;
        } else if (statusmember == 3) {
            System.out.println("reguler");;
        } else {
            System.out.println("input tidak valid (gunakan angka 1,2,3)");
        return;
        }
    }

// jenis status member
String jenismemberparkir = "";
if (jenismemberparkir.equals("executive")) {
    // diskon member parkir executive 20%
     double diskon = totalharga * 0.2;
    totalharga -= diskon;
    System.out.println("status member executive");
    System.out.println("status member executive " + diskon );

} if (jenismemberparkir.equals("premium")) {
 // diskon member parkir executive 15% 
double diskon = totalharga * 0.15;
totalharga -= diskon;
System.out.println("status premium");
System.out.println("status member premium " + diskon );

}  if  (jenismemberparkir.equals("reguler")) {
    // diskon member parkir executive 10%
    double diskon = totalharga * 0.1;
    totalharga -= diskon;
    System.out.println("status member reguler" + jenismemberparkir);
    System.out.println("status member reguler " + diskon );
}
 System.out.println("total pembayaran " + totalharga);

        }
}