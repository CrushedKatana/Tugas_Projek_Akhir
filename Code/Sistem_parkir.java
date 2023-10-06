
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
        /*double totalPrice, time, chargingtime;
        double electric_carparkingprice=5000, electric_motorcycleparkingprice=2000;
        String name, cartype, motorcycletype, platenumber, vehicletype;
        

        LocalDateTime timeIn = null;
        LocalDateTime timeOut = null;
        LocalDateTime startChargingTime = null;
        LocalDateTime stopChargingTime = null;

        double costPerHour = 1000; // Adjust the cost per hour as needed
        double chargingRate = 1; // Adjust the charging rate per hour as needed


        System.out.println("Input name user");
        name = input.next();
        System.out.println("Choose a vehicle: ");
        System.out.println("1. Electric Car");
        System.out.println("2. Electric Motorcycle");
        int choicetype = input.nextInt();

        switch (choicetype) {
            case 1:
                System.out.println("You chose a Electric Car.");
                System.out.println("Input plate number");
                platenumber = input.next();
                System.out.println("Car type = ");
                cartype = input.next();
                System.out.println("Press '1' to record time in, '2' to record time out, '3' to start charging, '4' to stop charging, '5' to calculate cost, or '0' to exit.");

                while (true) {
                    System.out.print("Enter your choice: ");
                    int choice = input.nextInt();
        
                    switch (choice) {
                        case 1:
                            timeIn = LocalDateTime.now();
                            System.out.println("Time in recorded: " + formatDateTime(timeIn));
                            break;
                        case 2:
                            if (timeIn == null) {
                                System.out.println("Please record time in first.");
                            } else {
                                timeOut = LocalDateTime.now();
                                System.out.println("Time out recorded: " + formatDateTime(timeOut));
                            }
                            break;
                        case 3:
                            if (timeIn != null && timeOut != null) {
                                startChargingTime = LocalDateTime.now();
                                System.out.println("Charging started at: " + formatDateTime(startChargingTime));
                            } else {
                                System.out.println("Please record both time in and time out first.");
                            }
                            break;
                        case 4:
                            if (startChargingTime != null) {
                                stopChargingTime = LocalDateTime.now();
                                System.out.println("Charging stopped at: " + formatDateTime(stopChargingTime));
                            } else {
                                System.out.println("Please start charging first.");
                            }
                            break;
                        case 5:
                            if (startChargingTime != null && stopChargingTime != null) {
                                long chargingDurationMinutes = calculateDurationMinutes(startChargingTime, stopChargingTime);
                                double chargingCost = calculateCost(chargingDurationMinutes, chargingRate);
                                long parkingDurationMinutes = calculateDurationMinutes(timeIn, timeOut);
                                double parkingCost = calculateCost(parkingDurationMinutes, costPerHour);
        
                                System.out.println("Charging Duration: " + chargingDurationMinutes + " minutes");
                                System.out.println("Charging Cost: " + chargingCost);
                                System.out.println("Parking Duration: " + parkingDurationMinutes + " minutes");
                                System.out.println("Parking Cost: " + parkingCost);
                            } else {
                                System.out.println("Please start and stop charging first.");
                            }
                            break;
                        case 0:
                            System.out.println("Exiting the program.");
                            System.exit(0);
                        default:
                            System.out.println("Invalid choice. Please enter '1', '2', '3', '4', '5', or '0'.");
                    }
                }
            }
                         // Helper method to calculate the duration in minutes
                         private static long calculateDurationMinutes(LocalDateTime start, LocalDateTime stop) {
                        return Duration.between(start, stop).toMinutes();
                        }

                        // Helper method to calculate the cost based on duration and cost per hour
                        private static double calculateCost(long durationMinutes, double costPerHour) {
                        double hours = (double) durationMinutes / 60.0; // Convert minutes to hours
                        return hours * costPerHour;
                        }

                        // Helper method to format LocalDateTime as a string
                        private static String formatDateTime(LocalDateTime dateTime) {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        return dateTime.format(formatter);
                    }
                    break;
            case 2:
                System.out.println("You chose a Electric Motorcycle.");
                 System.out.println("Input plate number");
                platenumber = input.next();
                System.out.println("Motorcycle type = ");
                motorcycletype = input.next();
                
                
                
                
                


                
                
                break;

            default:
                System.out.println("Invalid choice. Please choose 1 for Electric Car or 2 for Electric Motorcycle.");
                */
            }
    }


       
       





    


       