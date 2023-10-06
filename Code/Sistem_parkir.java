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



        //VARIABLE ELECTRIC VEHICLE
        double totalPrice, time, chargingtime;
        double electric_carparkingprice=5000, electric_motorcycleparkingprice=2000, chargingprice_kwh=1000;
        String name, cartype, motorcycletype, platenumber, vehicletype;
        boolean iscar, ismotorcycle;

        System.out.println("Input name user");
        name = input.next();
        System.out.println("Choose a vehicle: ");
        System.out.println("1. Electric Car");
        System.out.println("2. Electric Motorcycle");
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.println("You chose a Electric Car.");
                System.out.println("Input plate number");
                platenumber = input.next();
                System.out.println("Car type = ");
                cartype = input.next();
                System.out.print("Do you want to charge the car? (yes/no): ");
                String chosecar = input.next();
        
                if (chosecar.equalsIgnoreCase("yes")) {
                    System.out.println("Go to the car park with the charger");
                    
                } else if(chosecar.equalsIgnoreCase("no")){
                    System.out.println("Go to the normal car park");
                }
                else {
                    System.out.println("Invalid choice. Please enter 'yes' to charge or 'no' to not charge.");
                }
                break;

            case 2:
                System.out.println("You chose a Electric Motorcycle.");
                 System.out.println("Input plate number");
                platenumber = input.next();
                System.out.println("Motorcycle type = ");
                cartype = input.next();
                System.out.print("Do you want to charge the car? (yes/no): ");
                String chosemotorcycle = input.next();
        
                if (chosemotorcycle.equalsIgnoreCase("yes")) {
                    System.out.println("Go to the motorcycle park with the charger");
                    
                } else if(chosemotorcycle.equalsIgnoreCase("no")){
                    System.out.println("Go to the normal motorcycle park");
                }
                else {
                    System.out.println("Invalid choice. Please enter 'yes' to charge or 'no' to not charge.");
                }
                break;
            default:
                System.out.println("Invalid choice. Please choose 1 for Electric Car or 2 for Electric Motorcycle.");
        }
    }
}

       
       





    


       