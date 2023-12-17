import java.util.Scanner;

public class Sistem_parkir{
    // Define a class to represent motorcycle data
    public static class Parkir{
        static String[] userName = new String[50];
        static String[] licensePlate = new String[50];
        static String[] bikeType = new String[50];
        static String[] membershipType = new String[50]; 
        static double[] totalCost = new double[50];  
        
        static int idxuserName = -1;
        static int idxlicensePlate = -1;
        static int idxbiketype = -1;
        static int idxmembershipType = -1; 
        static int idxtotalCost = -1;

    

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

        System.out.println("Selamat datang di Sistem Parkir");

        do  {
            System.out.println("==============================================================");
            System.out.println("|Pilih jenis kendaraan yang ingin dimasukkan data parkirnya |");
            System.out.println("==============================================================");
            System.out.println("1. Motorcycle");
            System.out.println("2. Car");
            System.out.println("3. Electric");
            System.out.println("0. Keluar");
            System.out.println("==============================================================");

            int vehicleChoice = input.nextInt();

            switch (vehicleChoice) {
                case 1:
                    parkMotorcycle(input);
                    break;
                case 2:
                    parkCar(input);
                    break;
                case 3:
                    parkElectric(input);
                    break;
                case 0:
                    System.out.println("Terima kasih. Keluar dari program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih 1 untuk Motorcycle, 2 untuk Car, 3 untuk Electric, atau 0 untuk keluar.");
            }
         System.out.println("Do you want to enter another vehicle? (yes/no): ");
         } while (input.next().equalsIgnoreCase("yes"));
    }


    // Method untuk parkir kendaraan motor
    private static void parkMotorcycle(Scanner input) {
        // Total number of parking spaces
        int totalParkingSpaces = 50;

        // Matrix to store parking status (0: empty, 1: occupied)
        int[][] parkingStatus = new int[totalParkingSpaces][2];

        
        

        do {
            double totCost, motorcycleParkingFee = 2000, parkingDuration, helmetStorageCost = 0, motorcycleStorageCostWash = 0;
            boolean isHelmetStored, isMember, isMotorcycleWash;
            String memberType = "";
            String timeIn, timeOut;

            idxuserName++;
            idxlicensePlate++;
            idxbiketype++;
            idxmembershipType++;
            idxtotalCost++;
            System.out.print("Input user name = ");
            userName[idxuserName] = input.next();
            System.out.print("Input license plate = ");
            licensePlate[idxlicensePlate] = input.next();
            System.out.print("Input bike type = ");
            bikeType[idxbiketype] = input.next(); 
            System.out.println("Enter time in (HH:mm): ");
            timeIn = input.next();
            System.out.println("Enter time out (HH:mm): ");
            timeOut = input.next();

            // Parsing time in and time out
            int hoursIn = Integer.parseInt(timeIn.split(":")[0]);
            int minutesIn = Integer.parseInt(timeIn.split(":")[1]);
            int hoursOut = Integer.parseInt(timeOut.split(":")[0]);
            int minutesOut = Integer.parseInt(timeOut.split(":")[1]);

            // Calculating total parking hours
            double totalHours = (hoursOut - hoursIn) + (double) (minutesOut - minutesIn) / 60;

            if (totalHours <= 5) {
                totCost = motorcycleParkingFee * totalHours;
            } else {
                totCost = (motorcycleParkingFee * 5) + (motorcycleParkingFee * (totalHours - 5));
            }

            System.out.println("Helmet drop off? (yes/no): ");
            isHelmetStored = input.next().equalsIgnoreCase("yes");

            // Helmet drop off
            if (isHelmetStored) {
                System.out.println("Choose helmet type (half/full): ");
                String helmetType = input.next();
                switch (helmetType.toLowerCase()) {
                    case "half":
                        helmetStorageCost = 2000;
                        break;
                    case "full":
                        helmetStorageCost = 3000;
                        break;
                    default:
                        System.out.println("Invalid helmet type. Use 'half' or 'full'.");
                        return;
                }
            }

            // Motorcycle wash
            System.out.println("Want to wash your motorcycle? (yes/no): ");
            isMotorcycleWash = input.next().equalsIgnoreCase("yes");

            if (isMotorcycleWash) {
                System.out.println("Choose motorcycle type (matic/manual): ");
                String motorcycleType = input.next();
                switch (motorcycleType.toLowerCase()) {
                    case "matic":
                        motorcycleStorageCostWash = 15000;
                        break;
                    case "manual":
                        motorcycleStorageCostWash = 20000;
                        break;
                    default:
                        System.out.println("Invalid motorcycle type. Use 'matic' or 'manual'.");
                }
            }

            // Total cost of helmet storage + parking fee
            if (isHelmetStored) {
                totCost += helmetStorageCost;
                System.out.println("Helmet storage cost: " + helmetStorageCost);
            }

            if (isMotorcycleWash) {
                totCost += motorcycleStorageCostWash;
                System.out.println("Motorcycle storage cost: " + motorcycleStorageCostWash);
            }

            // Membership
            System.out.println("Is the user a member? (yes/no): ");
            isMember = input.next().equalsIgnoreCase("yes");
            

            if (isMember) {
                System.out.println("Select membership type (1 = Regular, 2 = Premium, 3 = Executive): ");
                int membershipChoice = input.nextInt();
                switch (membershipChoice) {
                    case 1:
                        memberType = "Regular";
                        break;
                    case 2:
                        memberType = "Premium";
                        break;
                    case 3:
                        memberType = "Executive";
                        break;
                    default:
                        System.out.println("Invalid membership type. Use 1 for Regular, 2 for Premium, or 3 for Executive.");
                        return;
                }
            }
            membershipType[idxmembershipType] = ""+memberType;

            switch (memberType) {
                case "Regular":
                    double discount = totCost * 0.1;
                    totCost -= discount;
                    System.out.println("Membership status: Regular");
                    System.out.println("Membership discount: " + discount);
                    break;
                case "Premium":
                    double discount2 = totCost * 0.15;
                    totCost -= discount2;
                    System.out.println("Membership status: Premium");
                    System.out.println("Membership discount: " + discount2);
                    break;
                case "Executive":
                    double discount3 = totCost * 0.2;
                    totCost -= discount3;
                    System.out.println("Membership status: Executive");
                    System.out.println("Membership discount: " + discount3);
                    break;
            }
            
            System.out.println("Membership Type: " + membershipType);
            System.out.println("Total Cost: " + totalCost);
            totalCost[idxtotalCost] = totCost;

            // Display available parking spaces
            System.out.println("Available parking spaces:");
            displayAvailableParking(parkingStatus);

            // Select parking space
            int chosenParkingSpace = selectParkingSpace(parkingStatus);
            if (chosenParkingSpace == -1) {
                System.out.println("All parking spaces are occupied. Cannot proceed.");
                return;
            }

            // Mark parking space as occupied
            parkingStatus[chosenParkingSpace][1] = 1;

            

            System.out.println("Do you want to enter another motorcycle? (yes/no): ");
        } while (input.next().equalsIgnoreCase("yes"));
    
    //call ooutput for method each motorcycle after loop
    for(int i = 0; i <=idxuserName;i++){
        output(userName[i]);
    }

    }
    static void output (String uname) {
      //cari idx dimana username tsb berada
      int idxUname = -1;
      for(int i=0;i<userName.length;i++){
        if(userName[i].equalsIgnoreCase(uname)){
            idxUname = i;
            break;
        }
         
      }    
      System.out.println("Username = "+userName[idxUname]);
      System.out.println("License Plate = "+licensePlate[idxUname]);
      System.out.println("Bike Type = "+bikeType[idxUname]);
      System.out.println("Membership Type: " + membershipType[idxUname]);
      System.out.println("Total Cost: " + totalCost[idxUname]);

      
    }

    // Your existing methods for displayAvailableParking and selectParkingSpace
    // Method to display available parking spaces
    private static void displayAvailableParking(int[][] parkingStatus) {
        for (int i = 0; i < parkingStatus.length; i++) {
            if (parkingStatus[i][1] == 0) {
                System.out.print(i + 1 + " ");
            } else {
                System.out.print("X ");
            }

            if ((i + 1) % 10 == 0) {
                System.out.println(); // Move to the next line every 10 parking spaces
            }
        }
        System.out.println();
    }

    // Method to select an available parking space
    private static int selectParkingSpace(int[][] parkingStatus) {
        Scanner input = new Scanner(System.in);
        System.out.print("Choose an available parking space (1-" + parkingStatus.length + "): ");
        int chosenParkingSpace = input.nextInt();

        if (chosenParkingSpace < 1 || chosenParkingSpace > parkingStatus.length || parkingStatus[chosenParkingSpace - 1][1] == 1) {
            System.out.println("Invalid choice or parking space already occupied. Please choose again.");
            return selectParkingSpace(parkingStatus); // Recursion if the choice is invalid or the parking space is already occupied
        }

        return chosenParkingSpace - 1; // Return the matrix index (starting from 0)
    }
  }

    

    // Method untuk parkir mobil
    private static void parkCar(Scanner input) {
            double totalCost, parkingFee = 5000, washCost = 0, airInflateCost = 2000;
            boolean isCarWash, isAirInflate, isMember;
            String userName, carType, licensePlate, membershipType = "";
            
            // Initialize an array to track available parking spaces
            boolean[] availableParkingSpaces = new boolean[50];
            for (int i = 0; i < availableParkingSpaces.length; i++) {
                availableParkingSpaces[i] = true;
            }

            do {
                // Input information
                System.out.println("Available parking spaces:");
                displayAvailableSpaces(availableParkingSpaces);
                
                System.out.println("Choose an available parking space (1-50): ");
                int chosenSpace = input.nextInt();
                
                // Check if the chosen space is valid
                if (chosenSpace < 1 || chosenSpace > 50 || !availableParkingSpaces[chosenSpace - 1]) {
                    System.out.println("Invalid parking space. Please choose an available space.");
                    continue;
                }
                
                // Mark the chosen space as occupied
                availableParkingSpaces[chosenSpace - 1] = false;

                System.out.println("Enter user name:");
                userName = input.next();
                System.out.println("Enter license plate number:");
                licensePlate = input.next();
                System.out.println("Car type (sedan/suv): ");
                carType = input.next();
                System.out.println("Parking duration (hours):");
                double parkingDuration = input.nextDouble();
                System.out.println("Want a car wash? (yes/no): ");
                isCarWash = input.next().equalsIgnoreCase("yes");
                System.out.println("Want to inflate the tires? (yes/no): ");
                isAirInflate = input.next().equalsIgnoreCase("yes");

                // Car wash
                if (isCarWash) {
                    System.out.println("Choose wash type (prem/reg): ");
                    String washType = input.next();
                    switch (washType.toLowerCase()) {
                        case "prem":
                            washCost = 30000;
                            break;
                        case "reg":
                            washCost = 20000;
                            break;
                        default:
                            System.out.println("Invalid wash type. Use 'prem' or 'reg'.");
                            return;
                    }
                }

                // Air inflate
                if (isAirInflate) {
                    totalCost = airInflateCost + parkingFee * parkingDuration;
                } else {
                    totalCost = parkingFee * parkingDuration;
                }

                // Car wash cost
                if (isCarWash) {
                    totalCost += washCost;
                    System.out.println("Car wash cost: " + washCost);
                }

                // Membership
                System.out.println("Is the user a member? (yes/no): ");
                isMember = input.next().equalsIgnoreCase("yes");

                if (isMember) {
                    System.out.println("Select membership type (1 = Regular, 2 = Premium, 3 = Executive): ");
                    int membershipChoice = input.nextInt();
                    switch (membershipChoice) {
                        case 1:
                            membershipType = "Regular";
                            break;
                        case 2:
                            membershipType = "Premium";
                            break;
                        case 3:
                            membershipType = "Executive";
                            break;
                        default:
                            System.out.println("Invalid membership type. Use 1 for Regular, 2 for Premium, or 3 for Executive.");
                            return;
                    }
                }

                // Membership discounts
                switch (membershipType) {
                    case "Regular":
                        totalCost *= 0.9;
                        System.out.println("Membership status: Regular");
                        System.out.println("Membership discount: 10%");
                        break;
                    case "Premium":
                        totalCost *= 0.85;
                        System.out.println("Membership status: Premium");
                        System.out.println("Membership discount: 15%");
                        break;
                    case "Executive":
                        totalCost *= 0.8;
                        System.out.println("Membership status: Executive");
                        System.out.println("Membership discount: 20%");
                        break;
                }

                System.out.println("Membership Type: - " + membershipType);
                System.out.println("Total Cost: " + totalCost);

                System.out.println("Do you want to enter another record? (yes/no): ");
            } while (input.next().equalsIgnoreCase("yes"));
        }

        private static void displayAvailableSpaces(boolean[] spaces) {
            for (int i = 0; i < spaces.length; i++) {
                if (spaces[i]) {
                    System.out.print((i + 1) + " ");
                } else {
                    System.out.print("X ");
                }

                if ((i + 1) % 10 == 0) {
                    System.out.println();
                }
            }
            System.out.println();
        }

        
            
        

        // Method untuk parkir kendaraan listrik
        private static final int motorcycleSpacesElectric = 20;
        private static final int carSpacesElectric = 25;

        static String[] userNameElectric = new String[50];
        static String[] licensePlateElectric = new String[50];
        static String[] membershipTypeElectric = new String[50];
        static double[] totalCostElectric = new double[50];

        static int idxuserNameElectric = -1;
        static int idxlicensePlateElectric = -1;
        static int idxmembershipTypeElectric = -1;
        static int idxtotalCostElectric = -1;

        private static void parkElectric(Scanner input) {

        // VARIABLES
        double parkingPrice, chargingRate, washPrice;
        String name, platenumber;
        boolean isMember = false;
        double parkingDurationHours = 0;
        double chargingDuration = 0;

        // Arrays
        int[][] motorcycleParkingStatus = new int[1][motorcycleSpacesElectric];
        int[][] carParkingStatus = new int[1][carSpacesElectric];

        
            idxuserNameElectric++;
            idxlicensePlateElectric++;
            idxmembershipTypeElectric++;
            idxtotalCostElectric++;

            System.out.print("Input username : ");
            userNameElectric[idxuserNameElectric] = input.next();
            System.out.print("Input license plate : ");
            licensePlateElectric[idxlicensePlateElectric] = input.next();

            System.out.print("Input time in (HH:mm): ");
            String timeIn = input.next();
            System.out.print("Input time out (HH:mm): ");
            String timeOut = input.next();

            int hoursIn = Integer.parseInt(timeIn.split(":")[0]);
            int minutesIn = Integer.parseInt(timeIn.split(":")[1]);
            int hoursOut = Integer.parseInt(timeOut.split(":")[0]);
            int minutesOut = Integer.parseInt(timeOut.split(":")[1]);
            double totalHours = (hoursOut - hoursIn) + (double) (minutesOut - minutesIn) / 60;

            System.out.print("Do you have a membership? (yes/no): ");
            isMember = input.next().equalsIgnoreCase("yes");

            String membershipType = "Non-Member";

            if (isMember) {
                System.out.print("Select membership type (1 = Regular(5%), 2 = Premium(10%), 3 = Executive(15%)): ");
                int membershipChoice = input.nextInt();
                switch (membershipChoice) {
                    case 1:
                        membershipType = "Regular";
                        break;
                    case 2:
                        membershipType = "Premium";
                        break;
                    case 3:
                        membershipType = "Executive";
                        break;
                    default:
                        System.out.println("Invalid membership type. Use 1 for Regular, 2 for Premium, or 3 for Executive.");
                        return;
}
            }

            System.out.println("Choose a vehicle: ");
            System.out.println("1. Electric Car");
            System.out.println("2. Electric Motorcycle");
            int choicetype = input.nextInt();

            switch (choicetype) {
                case 1:
                    System.out.println("You chose an Electric Car.");
                    parkingPrice = 5000.0; // parking price for electric cars
                    chargingRate = 1000.0; // charging rate for electric cars
                    washPrice = 25000.0; // wash price for electric cars

                    // Parking space car
                    System.out.println("Car Parking Spaces:");
                    displayAvailableParking(carParkingStatus);
                    int chosenCarParkingSpace = selectParkingSpace(carParkingStatus);
                    carParkingStatus[0][chosenCarParkingSpace] = 1;
                    break;

                case 2:
                    System.out.println("You chose an Electric Motorcycle.");
                    parkingPrice = 2000.0; // parking price for electric motorcycles
                    chargingRate = 500.0; // charging rate for electric motorcycles
                    washPrice = 15000.0; // wash price for electric motorcycles

                    // Parking spaces motorcycles
                    System.out.println("Motorcycle Parking Spaces:");
                    displayAvailableParking(motorcycleParkingStatus);
                    int chosenMotorcycleParkingSpace = selectParkingSpace(motorcycleParkingStatus);
                    motorcycleParkingStatus[0][chosenMotorcycleParkingSpace] = 1; // Mark the selected space as occupied
                    break;

                default:
                    System.out.println("Invalid choice. Please choose 1 for Electric Car or 2 for Electric Motorcycle.");
                    return;
            }

            System.out.println("Press '1' to calculate cost without charging, '2' to calculate cost with charging, or '3' to calculate cost with vehicle wash:");
            System.out.print("Enter your choice: ");
            int userChoice = input.nextInt();

            switch (userChoice) {
                case 1:
                    parkingDurationHours = totalHours;
                    break;

                case 2:
                    parkingDurationHours = totalHours;
                    System.out.println("Charging started...");
                    break;

                case 3:
                    parkingDurationHours = totalHours;
                    System.out.println("Vehicle wash started...");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter '1', '2', or '3'.");
                    return;
            }

            double parkingCost = parkingDurationHours * parkingPrice;
            double chargingCost = (userChoice == 2) ? parkingDurationHours * chargingRate : 0;
            double washCost = (userChoice == 3) ? washPrice : 0;
            membershipTypeElectric[idxmembershipTypeElectric] = membershipType;

            double totalCost = parkingCost + chargingCost + washCost;

            double discount = 0.0;
            if (isMember) {
                switch (membershipType) {
                    case "Regular":
                        discount = totalCost * 0.1;
                        break;

                    case "Premium":
                        discount = totalCost * 0.15;
                        break;

                    case "Executive":
                        discount = totalCost * 0.2;
                        break;
                }
            }

            totalCost -= discount;
            double discountAmount = totalCost - (parkingCost + chargingCost + washCost);

            finalPriceInformationDisplay(userChoice, parkingDurationHours, parkingCost, chargingCost, washCost, totalCost, discountAmount, idxmembershipTypeElectric);
            
    }

    private static void finalPriceInformationDisplay(int userChoice, double parkingDurationHours, double parkingCost, double chargingCost, double washCost, double totalCost, double discountAmount, int idx) {
        System.out.println("==============================================================");
        System.out.println("User Name         : " + userNameElectric[idxuserNameElectric]);
        System.out.println("License Plate     : " + licensePlateElectric[idxlicensePlateElectric]);
        System.out.println("Membership Type   : " + membershipTypeElectric[idx]);
        System.out.println("Parking Duration  : " + parkingDurationHours + " hours");
        System.out.println("Parking Cost      : Rp " + parkingCost);
        if (userChoice == 2) {
            System.out.println("Charging Duration: " + parkingDurationHours + " hours");
            System.out.println("Charging Cost     : Rp " + chargingCost);
        } else if (userChoice == 3) {
            System.out.println("Vehicle Wash Cost : Rp " + washCost);
        }
        System.out.println("==============================================================");
        System.out.println("Total Cost        : Rp " + totalCost);
        System.out.println("Discount Amount   : Rp " + discountAmount);
        System.out.println("==============================================================");
    }

    private static void displayAvailableParking(int[][] parkingStatus) {
        for (int i = 0; i < parkingStatus[0].length; i++) {
            if (parkingStatus[0][i] == 0) {
                System.out.print(i + 1 + " ");
            } else {
                System.out.print("X ");
            }
        }
        System.out.println();
    }

    private static int selectParkingSpace(int[][] parkingStatus) {
        Scanner input = new Scanner(System.in);
        System.out.print("Choose an available parking space (1-" + parkingStatus[0].length + "): ");
        int chosenParkingSpace = input.nextInt();

        if (chosenParkingSpace < 1 || chosenParkingSpace > parkingStatus[0].length || parkingStatus[0][chosenParkingSpace - 1] == 1) {
            System.out.println("Invalid choice or parking space already occupied. Please choose again.");
            return selectParkingSpace(parkingStatus);
        }
        return chosenParkingSpace - 1;
    }//charel :)
}
    


    
