import java.time.LocalTime;
import java.util.Scanner;

public class Sistem_parkir{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
       
        System.out.println("  _____        _____  _  _______ _   _  _____    _______     _______ _______ ______ __  __ ");
        System.out.println(" |  __ \\ /\\   |  __ \\| |/ /_   _| \\ | |/ ____|  / ____\\ \\   / / ____|__   __|  ____|  \\/  |");
        System.out.println(" | |__) /  \\  | |__) | ' /  | | |  \\| | |  __  | (___  \\ \\_/ / (___    | |  | |__  | \\  / |");
        System.out.println(" |  ___/ /\\ \\ |  _  /|  <   | | | . ` | | |_ |  \\___ \\  \\   / \\___ \\   | |  |  __| | |\\/| |");
        System.out.println(" | |  / ____ \\| | \\ \\| . \\ _| |_| |\\  | |__| |  ____) |  | |  ____) |  | |  | |____| |  | |");
        System.out.println(" |_| /_/    \\_\\_|  \\_\\_|\\_\\_____|_| \\_|\\_____| |_____/   |_| |_____/   |_|  |______|_|  |_|");
        System.out.println(" ");
        System.out.println(" ");
       
        //variable 

        //int total_price, parking_price=2000, helmet_storage_price=1000;
        //String name, number_plate, motorcycle_type, input_helmet_drop_off;
        //double discount=0.1, puchaseprice, totalPrice, totalDiscount, parking_duration;

        //VARIABEL MOTORCYCLE
        
                double hargatotal, hargaparkirmotorcycle = 2000, lamaparkir, hargatitiphelm = 2000;
                String namauser, tipesepeda, nomorplat;
                boolean istitiphelm, ismember;
        
              
        
                System.out.println("Input nama user");
                namauser = input.next();
                System.out.println("Input plat nomor");
                nomorplat = input.next();
                System.out.println("Helmet drop off ? (true/false) = ");
                istitiphelm = input.nextBoolean();
                System.out.println("Is user a member ? (true/false) = ");
                ismember = input.nextBoolean();
                System.out.println("Input lama parkir");
                lamaparkir = input.nextInt();
        
                if (istitiphelm) {
                    hargatotal = (hargaparkirmotorcycle * lamaparkir) + hargatitiphelm;
                    System.out.println("Harga penitipan helm: " + hargatitiphelm);
                } else {
                    hargatotal = hargaparkirmotorcycle * lamaparkir;
                }
        
                if (ismember) {
                    // Diskon 10% untuk member
                    double diskon = hargatotal * 0.1;
                    hargatotal -= diskon;
                    System.out.println("Status member: Yes");
                    System.out.println("Diskon member: " + diskon);
                } else {
                    System.out.println("Status member: No");
                }
                System.out.println("Harga parkir: " + hargaparkirmotorcycle * lamaparkir);
                System.out.println("Harga total: " + hargatotal);
            
        
                
            
        
        

        


       
        //VARIABEL CAR
        double totalharga, waktu  ;
        double hargaparkir = 5000;
        String nama_user, platnomor, tipemobil;
        System.out.println("Input nama user");
        nama_user = input.next();
        System.out.println("Input plat nomor");
        platnomor = input.next();
        System.out.println("Tipe mobil");
        tipemobil = input.next();
        System.out.println(" Waktu");
        waktu = input.nextInt();
        hargaparkir = 5000;
        totalharga=(hargaparkir*waktu);
        System.out.println( "Total harga " + totalharga);



    }
}

       