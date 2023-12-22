import java.util.Scanner;

public class Parking_System {
    static Scanner input = new Scanner(System.in);
    static String[] userName = new String[50];
    static String[] licensePlate = new String[50];
    static String[] membershipType = new String[50];
    static int idxuserName = 0;
    static int idxlicensePlate = 0;
    static int[][] parkingStatus = new int[50][2];
    static int[] vipCount = new int[50];  // Adjusted array size for membership types
    static int[] regulerCount = new int[50];
    static int[] biasaCount = new int[50];
    static double motorcycleWashCost = 0;
    static double carWashCost = 0;
    static double tireInflationCost = 0;

    static final double MOTORCYCLE_PARKING_FEE = 2000;
    static final double CAR_PARKING_FEE = 5000;

    public static void main(String[] args) {
        System.out.println("Selamat datang");
        do {
            menuVehicle();
        } while (true);
    }

    public static void Datadiri() {
        System.out.print("Input user name = ");
        userName[idxuserName] = input.next();
        System.out.print("Input license plate = ");
        licensePlate[idxlicensePlate] = input.next();
        System.out.print("Choose membership type (vip/reguler/biasa): ");
        membershipType[idxuserName] = input.next().toLowerCase();

        idxuserName++;
        idxlicensePlate++;

        // Increment the count for the corresponding membership type
        switch (membershipType[idxuserName - 1]) {
            case "vip":
                vipCount[idxuserName - 1]++;
                break;
            case "reguler":
                regulerCount[idxuserName - 1]++;
                break;
            case "biasa":
                biasaCount[idxuserName - 1]++;
                break;
            // Add more cases for other membership types if needed
        }
        menukendaraan();
    }
    public static void menukendaraan(){
        System.out.println("==============================================================");
        System.out.println("| Pilih jenis kendaraan yang ingin dimasukkan data parkirnya |");
        System.out.println("==============================================================");
        System.out.println("1. Motorcycle");
        System.out.println("2. Car");
        System.out.println("0. Keluar");
        System.out.println("==============================================================");
        int vehicleChoice = input.nextInt();

        switch (vehicleChoice) {
                case 1:
                    parkMotorcycle();
                    break;
                case 2:
                    parkCar();
                    break;
            case 0:
                System.out.println("Terima kasih. Keluar dari program.");
                System.exit(0);
                break;
            default:
                System.out.println("Pilihan tidak valid. Silakan pilih 1 untuk Motorcycle, 2 untuk Car, atau 0 untuk keluar.");
        }
    }

    public static void menuVehicle() {
        System.out.println("==============================================================");
        System.out.println("| Pilih jenis kendaraan yang ingin dimasukkan data parkirnya |");
        System.out.println("==============================================================");
        System.out.println("1. Data Diri");
        System.out.println("2. Electric");
        System.out.println("3. Lihat Status Parkir");
        System.out.println("0. Keluar");
        System.out.println("==============================================================");

        int vehicleChoice = input.nextInt();

        switch (vehicleChoice) {
            case 1:
                Datadiri();
                break;
            case 2:
                parkElectric();
                break;
            case 3:
                displayParkingStatus();
                break;
            case 0:
                System.out.println("Terima kasih. Keluar dari program.");
                System.exit(0);
                break;
            default:
                System.out.println("Pilihan tidak valid. Silakan pilih 1 untuk Motorcycle, 2 untuk Car, 3 untuk Electric, 4 untuk Lihat Status Parkir, atau 0 untuk keluar.");
    }
}

    private static void parkMotorcycle() {
        // Motorcycle parking logic here
        int totalParkingSpaces = 50;

        // Helmet drop off
        System.out.println("Do you want to store your helmet? (yes/no): ");
        boolean isHelmetStored = input.next().equalsIgnoreCase("yes");

        double helmetStorageCost = 0;
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
        System.out.println("Do you want to wash your motorcycle? (yes/no): ");
        String washChoice = input.next();
        System.out.println("Choose motorcycle type (matic/manual): ");
        String motorcycleType = input.next();

        double motorcycleStorageCostWash = 0;
        if (washChoice.equalsIgnoreCase("yes")) {
            switch (motorcycleType.toLowerCase()) {
                case "matic":
                    motorcycleStorageCostWash = 15000;
                    break;
                case "manual":
                    motorcycleStorageCostWash = 20000;
                    break;
                default:
                    System.out.println("Invalid motorcycle type. Use 'matic' or 'manual'.");
                    return;
            }
        }

        // Update parking status
        int availableSlot = findAvailableSlot(parkingStatus);
        if (availableSlot != -1) {
            parkingStatus[availableSlot][0] = 1; // Mark the parking slot as occupied
            parkingStatus[availableSlot][1] = idxuserName - 1; // Store user index in the parking slot
            System.out.println("Motorcycle parked successfully in slot " + availableSlot);

            // Calculate parking fee based on parking duration
            double parkingFee = (MOTORCYCLE_PARKING_FEE);

            // Apply membership discount
            double totalCost = calculateTotalCost(helmetStorageCost, motorcycleStorageCostWash + motorcycleWashCost, parkingFee);
            System.out.println("Total Parking Cost: " + totalCost);
            generateReceipt("Motorcycle", helmetStorageCost, motorcycleStorageCostWash + motorcycleWashCost, parkingFee, totalCost);
        } else {
            System.out.println("Sorry, parking is full.");
        }
    }

    private static void parkCar() {
        // Car parking logic here

        // Car wash
        System.out.println("Do you want a car wash? (yes/no): ");
        String washChoice = input.next();

        if (washChoice.equalsIgnoreCase("yes")) {
            System.out.println("Choose car wash type (basic/premium): ");
            String carWashType = input.next();
            switch (carWashType.toLowerCase()) {
                case "basic":
                    carWashCost = 30000;
                    break;
                case "premium":
                    carWashCost = 50000;
                    break;
                default:
                    System.out.println("Invalid car wash type. Use 'basic' or 'premium'.");
                    return;
            }
        }

        // Tire inflation
        System.out.println("Do you want tire inflation? (yes/no): ");
        String inflationChoice = input.next();

        if (inflationChoice.equalsIgnoreCase("yes")) {
            System.out.println("Choose tire inflation type (standard/nitrogen): ");
            String inflationType = input.next();
            switch (inflationType.toLowerCase()) {
                case "standard":
                    tireInflationCost = 20000;
                    break;
                case "nitrogen":
                    tireInflationCost = 40000;
                    break;
                default:
                    System.out.println("Invalid tire inflation type. Use 'standard' or 'nitrogen'.");
                    return;
            }
        }

        // Update parking status
        int availableSlot = findAvailableSlot(parkingStatus);
        if (availableSlot != -1) {
            parkingStatus[availableSlot][0] = 1; // Mark the parking slot as occupied
            parkingStatus[availableSlot][1] = idxuserName - 1; // Store user index in the parking slot
            System.out.println("Car parked successfully in slot " + availableSlot);

            // Calculate parking fee based on parking duration
            double parkingFee = (CAR_PARKING_FEE);

            // Apply membership discount
            double totalCost = calculateTotalCost(0, carWashCost + tireInflationCost, parkingFee);
            System.out.println("Total Parking Cost: " + totalCost);
            generateReceipt("Car", 0, carWashCost + tireInflationCost, parkingFee, totalCost);
        } else {
            System.out.println("Sorry, parking is full.");
        }
    }

    private static void displayParkingStatus() {
        System.out.println("==============================================================");
        System.out.println("|                      Status Parkir                          |");
        System.out.println("==============================================================");
        System.out.println("Slot No. | Status    | User Name      | License Plate");
        System.out.println("==============================================================");
        for (int i = 0; i < parkingStatus.length; i++) {
            System.out.printf("%-9d| %-10s| %-15s| %-13s%n", i,
                    (parkingStatus[i][0] == 0 ? "Empty" : "x"),
                    (parkingStatus[i][0] == 1 ? userName[parkingStatus[i][1]] : ""),
                    (parkingStatus[i][0] == 1 ? licensePlate[parkingStatus[i][1]] : ""));
        }
        System.out.println("==============================================================");
    }

    private static int findAvailableSlot(int[][] parkingStatus) {
        for (int i = 0; i < parkingStatus.length; i++) {
            if (parkingStatus[i][0] == 0) {
                return i;
            }
        }
        return -1; // Return -1 if no available slot is found
    }

    private static double calculateTotalCost(double helmetCost, double washCost, double parkingFee) {
        double totalCost = helmetCost + washCost + parkingFee;

        // Apply membership discount
        switch (membershipType[idxuserName - 1]) {
            case "vip":
                totalCost *= 0.9; // 10% discount
                break;
            case "reguler":
                totalCost *= 0.85; // 15% discount
                break;
            case "biasa":
                totalCost *= 0.8; // 20% discount
                break;
            // You can add more cases for other membership types if needed
        }

        return totalCost;
    }

    

    private static void generateReceipt(String vehicleType, double helmetCost, double washCost, double parkingFee, double totalCost) {
        System.out.println("\n=========================== RECEIPT ===========================");
        System.out.println("User Name: " + userName[idxuserName - 1]);
        System.out.println("License Plate: " + licensePlate[idxuserName - 1]);
        System.out.println("Membership Type: " + membershipType[idxuserName - 1]);
        System.out.println("Vehicle Type: " + vehicleType);

        if (helmetCost > 0) {
            System.out.println("Helmet Cost: " + helmetCost);
        }

        if (vehicleType.equalsIgnoreCase("Motorcycle")) {
            if (washCost > 0) {
                System.out.println("Motorcycle Wash Cost: " + washCost);
            }
        } else if (vehicleType.equalsIgnoreCase("Car")) {
            if (carWashCost > 0) {
                System.out.println("Car Wash Cost: " + carWashCost);
            }
        }

        if (tireInflationCost > 0) {
            System.out.println("Tire Inflation Cost: " + tireInflationCost);
        }

        System.out.println("Parking Fee: " + parkingFee);
        System.out.println("Total Parking Cost: " + totalCost);

        double discount = 0;
        switch (membershipType[idxuserName - 1]) {
            case "vip":
                discount = 0.1; // 10% discount
                break;
            case "reguler":
                discount = 0.15; // 15% discount
                break;
            case "biasa":
                discount = 0.2; // 20% discount
                break;
            // Add more cases for other membership types if needed
        }

        double discountAmount = totalCost * discount;
        System.out.println("Discount Applied: " + discount * 100 + "% (" + discountAmount + ")");
        System.out.println("==============================================================\n");
    }

        private static final int motorcycleSpacesElectric = 40;
        private static final int carSpacesElectric = 20;

        static String[] userNameElectric = new String[50];
        static String[] licensePlateElectric = new String[50];
        static String[] membershipTypeElectric = new String[50];
        static double[] totalCostElectric = new double[50];

        static int idxuserNameElectric = -1;
        static int idxlicensePlateElectric = -1;
        static int idxmembershipTypeElectric = -1;
        static int idxtotalCostElectric = -1;

        private static void parkElectric() {

        // VARIABLES
        do{
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

            System.out.println("Press '1' to calculate cost without charging, '2' to calculate cost with charging, or '3' to calculate cost with vehicle wash");
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
                System.out.println("Do you want to calculate input another electric vehicle ? (yes/no):");
                input.nextLine();
                } while (input.next().equalsIgnoreCase("yes"));    
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
        }
}
