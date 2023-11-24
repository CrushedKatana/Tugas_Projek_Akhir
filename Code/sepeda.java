import java.util.Scanner;

public class sepeda {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Jumlah total parkiran
        int totalParkingSpaces = 50;

        // Matriks untuk menyimpan status parkiran (0: kosong, 1: terisi)
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

            // Parse waktu masuk dan waktu keluar
            int hoursIn = Integer.parseInt(timeIn.split(":")[0]);
            int minutesIn = Integer.parseInt(timeIn.split(":")[1]);
            int hoursOut = Integer.parseInt(timeOut.split(":")[0]);
            int minutesOut = Integer.parseInt(timeOut.split(":")[1]);

            // Menghitung total jam parkir
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

           

            // Total harga penitipan helm + harga parkir
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

          

            // Menampilkan parkiran yang tersedia
            System.out.println("Available parking spaces:");
            displayAvailableParking(parkingStatus);

            // Memilih parkiran
            int chosenParkingSpace = selectParkingSpace(parkingStatus);
            if (chosenParkingSpace == -1) {
                System.out.println("All parking spaces are occupied. Cannot proceed.");
                return;
            }

            // Menandai parkiran sebagai terisi
            parkingStatus[chosenParkingSpace][1] = 1;

            // ... (kode yang sudah ada)

            System.out.println("Do you want to enter another record? (yes/no): ");
        } while (input.next().equalsIgnoreCase("yes"));

       
    }

    // Metode untuk menampilkan parkiran yang tersedia
    private static void displayAvailableParking(int[][] parkingStatus) {
        for (int i = 0; i < parkingStatus.length; i++) {
            if (parkingStatus[i][1] == 0) {
                System.out.print(i + 1 + " ");
            } else {
                System.out.print("X ");
            }

            if ((i + 1) % 10 == 0) {
                System.out.println(); // Pindah baris setiap 10 parkiran
            }
        }
        System.out.println();
    }

    // Metode untuk memilih parkiran yang tersedia
    private static int selectParkingSpace(int[][] parkingStatus) {
        Scanner input = new Scanner(System.in);
        System.out.print("Choose an available parking space (1-" + parkingStatus.length + "): ");
        int chosenParkingSpace = input.nextInt();

        if (chosenParkingSpace < 1 || chosenParkingSpace > parkingStatus.length || parkingStatus[chosenParkingSpace - 1][1] == 1) {
            System.out.println("Invalid choice or parking space already occupied. Please choose again.");
            return selectParkingSpace(parkingStatus); // Rekursif jika pilihan tidak valid atau parkiran sudah terisi
        }

        return chosenParkingSpace - 1; // Mengembalikan indeks matriks (dimulai dari 0)
    }
}
