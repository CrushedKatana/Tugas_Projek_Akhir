import java.util.Scanner;

public class motorcycle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double totalCost, motorcycleParkingFee = 2000, parkingDuration, helmetStorageCost = 0;
        String userName, bikeType, licensePlate;
        boolean isHelmetStored, isMember;
        String membershipType = "";

        System.out.println("Enter user name:");
        userName = input.next();
        System.out.println("Enter license plate number:");
        licensePlate = input.next();
        System.out.println("Helmet drop off? (true/false): ");
        isHelmetStored = input.nextBoolean();

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

        System.out.println("Enter parking duration (hours):");
        parkingDuration = input.nextDouble();

        if (parkingDuration <= 5) {
            totalCost = motorcycleParkingFee * parkingDuration;
        } else {
            totalCost = (motorcycleParkingFee * 5) + (motorcycleParkingFee * (parkingDuration - 5));
        }

        if (isHelmetStored) {
            totalCost += helmetStorageCost;
            System.out.println("Helmet storage cost: " + helmetStorageCost);
        }

        System.out.println("Is the user a member? (true/false):");
        isMember = input.nextBoolean();

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
        input.close();
    }
}
