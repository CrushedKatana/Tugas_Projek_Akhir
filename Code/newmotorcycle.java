import java.util.Scanner;

public class newmotorcycle {
    public static class UserData {
        String userName;
        String licensePlate;
        String bikeType;
        double totalCost;
        String membershipType;

        public UserData(String userName, String licensePlate, String bikeType, double totalCost, String membershipType) {
            this.userName = userName;
            this.licensePlate = licensePlate;
            this.bikeType = bikeType;
            this.totalCost = totalCost;
            this.membershipType = membershipType;    
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Total number of parking spaces
        int totalParkingSpaces = 50;

        // Matrix to store parking status (0: empty, 1: occupied)
        int[][] parkingStatus = new int[totalParkingSpaces][2];

        // Array to store user data
        UserData[] userDataArray = new UserData[totalParkingSpaces];

        do {
            double totalCost, motorcycleParkingFee = 2000, parkingDuration, helmetStorageCost = 0, motorcycleStorageCostWash = 0;
            String userName, bikeType, licensePlate;
            boolean isHelmetStored, isMember, isMotorcycleWash;
            String membershipType = "";
            String timeIn, timeOut;

            // Corrected variable name
            int chosenParkingSpace;

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
            chosenParkingSpace = selectParkingSpace(parkingStatus);
            if (chosenParkingSpace == -1) {
                System.out.println("All parking spaces are occupied. Cannot proceed.");
                return;
            }

            // Mark parking space as occupied
            parkingStatus[chosenParkingSpace][1] = 1;

            System.out.println("Do you want to enter another record? (yes/no): ");
        } while (input.next().equalsIgnoreCase("yes"));
        for (UserData userData : userDataArray) {
            if (userData != null) {
                System.out.println("User Name: " + userData.userName);
                System.out.println("License Plate: " + userData.licensePlate);
                System.out.println("Bike Type: " + userData.bikeType);
                System.out.println("Total Cost: " + userData.totalCost);
                System.out.println("Membership Type: " + userData.membershipType);
                System.out.println("-------------------------");
            }
        }
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
}