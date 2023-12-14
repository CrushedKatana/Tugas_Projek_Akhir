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
            double totalCost, motorcycleParkingFee = 2000, parkingDuration, helmetStorageCost = 0, motorcycleStorageCostWash = 0;
            String userName, bikeType, licensePlate;
            boolean isHelmetStored, isMember, isMotorcycleWash;
            String membershipType = "";
            String timeIn, timeOut;

            System.out.println("Enter user name:");
            userName = input.next();
            System.out.println("Enter license plate number:");
            licensePlate = input.next();
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
                totalCost = motorcycleParkingFee * totalHours;
            } else {
                totalCost = (motorcycleParkingFee * 5) + (motorcycleParkingFee * (totalHours - 5));
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
                totalCost += helmetStorageCost;
                System.out.println("Helmet storage cost: " + helmetStorageCost);
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

            switch (membershipType) {
                case "Regular":
                    double discount = totalCost * 0.1;
                    totalCost -= discount;
                    System.out.println("Membership status: Regular");
                    System.out.println("Membership discount: " + discount);
                    break;
                case "Premium":
                    double discount2 = totalCost * 0.15;
                    totalCost -= discount2;
                    System.out.println("Membership status: Premium");
                    System.out.println("Membership discount: " + discount2);
                    break;
                case "Executive":
                    double discount3 = totalCost * 0.2;
                    totalCost -= discount3;
                    System.out.println("Membership status: Executive");
                    System.out.println("Membership discount: " + discount3);
                    break;
            }

            System.out.println("Membership Type: " + membershipType);
            System.out.println("Total Cost: " + totalCost);

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

            System.out.println("Do you want to enter another motorcycle ? (yes/no): ");
        } while (input.next().equalsIgnoreCase("yes"));
    }

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
    private static void parkElectric(Scanner input) {
               // VARIABLES
        double parkingPrice, chargingRate;
        String name, platenumber;
        boolean isMember = false;
        double parkingDurationHours = 0;

        do {
            System.out.println("Input name user");
            name = input.next();
            System.out.println("Do you have a membership? (yes/no):");
            isMember = input.next().equalsIgnoreCase("yes");

            String membershipType = "Non-Member";

            if (isMember) {
                System.out.println("Select membership type (1 = Regular(5%), 2 = Premium(10%), 3 = Executive(15%)): ");
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
                    System.out.println("Input plate number");
                    platenumber = input.next();
                    parkingPrice = 5000.00; //parking price for electric cars
                    chargingRate = 1000.00; //charging rate for electric cars
                    break;
                case 2:
                    System.out.println("You chose an Electric Motorcycle.");
                    System.out.println("Input plate number");
                    platenumber = input.next();
                    parkingPrice = 2000.00; //parking price for electric motorcycles
                    chargingRate = 500.00; //charging rate for electric motorcycles
                    break;
                default:
                    System.out.println("Invalid choice. Please choose 1 for Electric Car or 2 for Electric Motorcycle.");
                    return;
            }

            System.out.println("Press '1' to calculate cost without charging or '2' to calculate cost with charging.");
            System.out.print("Enter your choice: ");
            int userChoice = input.nextInt();

            switch (userChoice) {
                case 1:
                    System.out.print("Enter parking duration (in hours): ");
                    parkingDurationHours = input.nextDouble();
                    break;
                case 2:
                    System.out.print("Enter parking duration (in hours): ");
                    parkingDurationHours = input.nextDouble();
                    System.out.println("Charging started...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter '1' or '2'.");
                    return;
            }

            double parkingCost = parkingDurationHours * parkingPrice;
            double chargingCost = (userChoice == 2) ? parkingDurationHours * chargingRate : 0;

            double totalCost = parkingCost + chargingCost;

            double discount = 0.0;
            if (isMember) { // Check the membership status
                if (membershipType.equals("Regular")) {
                    discount = totalCost * 0.05;
                } else if (membershipType.equals("Premium")) {
                    discount = totalCost * 0.1;
                } else if (membershipType.equals("Executive")) {
                    discount = totalCost * 0.15;
                }
            }

            totalCost -= discount;

            System.out.println("==============================================================");
            System.out.println("Membership Type: " + membershipType);
            System.out.println("Parking Duration: " + parkingDurationHours + " hours");
            System.out.println("Parking Cost: Rp" + parkingCost);
            if (userChoice == 2) {
                System.out.println("Charging Duration: " + parkingDurationHours + " hours");
                System.out.println("Charging Cost: Rp" + chargingCost);
            }
            System.out.println("==============================================================");
            System.out.println("Total Cost: " + totalCost);
            System.out.println("==============================================================");

            System.out.println("Do you want to calculate cost again? (yes/no):");
        } while (input.next().equalsIgnoreCase("yes"));
    }
}

