import java.util.Scanner;

public class sepeda {
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
}
