import java.util.Scanner;

public class speda {
    static Scanner input = new Scanner(System.in);
    static String[] userName = new String[50];
    static String[] licensePlate = new String[50];
    static String[] membershipType = new String[50];
    static int idxuserName = 0;
    static int idxlicensePlate = 0;
    static int[][] parkingStatus = new int[50][2];
    static int[] vipCount = new int[3];  // Adjusted array size for membership types
    static int[] regulerCount = new int[3];
    static int[] biasaCount = new int[3];
    static double motorcycleWashCost = 0;
    static double carWashCost = 0;
    static double tireInflationCost = 0;

    static final double MOTORCYCLE_PARKING_FEE = 2000;
    static final double CAR_PARKING_FEE = 5000;

    public static void main(String[] args) {
        System.out.println("Selamat datang");
        do {
            Datadiri(input);
            menuVehicle();
        } while (true);
    }

    public static void Datadiri(Scanner input) {
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
    }

    public static void menuVehicle() {
        System.out.println("==============================================================");
        System.out.println("| Pilih jenis kendaraan yang ingin dimasukkan data parkirnya |");
        System.out.println("==============================================================");
        System.out.println("1. Motorcycle");
        System.out.println("2. Car");
        System.out.println("3. Electric");
        System.out.println("4. Lihat Status Parkir");
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
            case 3:
                parkElectric();
                break;
            case 4:
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
            double parkingFee = calculateParkingFee(MOTORCYCLE_PARKING_FEE);

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
            double parkingFee = calculateParkingFee(CAR_PARKING_FEE);

            // Apply membership discount
            double totalCost = calculateTotalCost(0, carWashCost + tireInflationCost, parkingFee);
            System.out.println("Total Parking Cost: " + totalCost);
            generateReceipt("Car", 0, carWashCost + tireInflationCost, parkingFee, totalCost);
        } else {
            System.out.println("Sorry, parking is full.");
        }
    }

    private static void parkElectric() {
        // Electric vehicle parking logic here, if needed
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

    private static double calculateParkingFee(double baseParkingFee) {
        // ... (gunakan logika bisnis Anda untuk menghitung biaya parkir berdasarkan durasi parkir atau aturan bisnis lainnya)
        return baseParkingFee; // Contoh: biaya parkir dihitung sebagai biaya dasar
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
}