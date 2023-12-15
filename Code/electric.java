
import java.util.Scanner;

public class electric {
    private static final int motorcycleSpaces = 20;
    private static final int carSpaces = 25;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // VARIABLES
        double parkingPrice, chargingRate, washPrice;
        String name, platenumber;
        boolean isMember = false;
        double parkingDurationHours = 0;
        double chargingDuration = 0;
        String membershipType = "Non-Member";

        // Arrays
        int[][] motorcycleParkingStatus = new int[1][motorcycleSpaces];
        int[][] carParkingStatus = new int[1][carSpaces];

        do {
            System.out.println("Input name user");
            name = input.next();
            System.out.println("Input time in (HH:mm): ");
            String timeIn = input.next();
            System.out.println("Input time out (HH:mm): ");
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
                    System.out.println("Input plate number");
                    platenumber = input.next();
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
                    System.out.println("Input plate number");
                    platenumber = input.next();
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

            System.out.println("Do you have a membership? (yes/no):");
            isMember = input.next().equalsIgnoreCase("yes");

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

            double parkingCost = parkingDurationHours * parkingPrice;
            double chargingCost = (userChoice == 2) ? parkingDurationHours * chargingRate : 0;
            double washCost = (userChoice == 3) ? washPrice : 0;

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

            System.out.println("==============================================================");
            System.out.println("Membership Type   : " + membershipType);
            System.out.println("Parking Duration  : " + parkingDurationHours + " hours");
            System.out.println("Parking Cost      : Rp " + parkingCost);
            if (userChoice == 2) {
                System.out.println("Charging Duration: " + parkingDurationHours + " hours");
                System.out.println("Charging Cost   : Rp " + chargingCost);
            } else if (userChoice == 3) {
                System.out.println("Vehicle Wash Cost : Rp " + washCost);
            }
            System.out.println("==============================================================");
            System.out.println("Total Cost        : Rp " + totalCost);
            System.out.println("Discount Amount   : Rp " + discountAmount);
            System.out.println("==============================================================");

            System.out.println("Do you want to calculate input another vehicle ? (yes/no):");
        } while (input.next().equalsIgnoreCase("yes"));
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
