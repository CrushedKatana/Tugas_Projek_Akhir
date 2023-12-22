
private static void car(Scanner input) {
    double parkingFee = 5000, washCost = 0, airInflateCost = 2000;
    boolean isCarWash, isAirInflate, isMember;
    String userName, carType, licensePlate, membershipType = "";
    double currentTotalCost = 0; // Rename the variable to avoid conflicts

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
            currentTotalCost = airInflateCost + parkingFee * parkingDuration;
        } else {
            currentTotalCost = parkingFee * parkingDuration;
        }

        // Car wash cost
        if (isCarWash) {
            currentTotalCost += washCost;
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
                currentTotalCost *= 0.9;
                System.out.println("Membership status: Regular");
                System.out.println("Membership discount: 10%");
                break;
            case "Premium":
                currentTotalCost *= 0.85;
                System.out.println("Membership status: Premium");
                System.out.println("Membership discount: 15%");
                break;
            case "Executive":
                currentTotalCost *= 0.8;
                System.out.println("Membership status: Executive");
                System.out.println("Membership discount: 20%");
                break;
        }

        System.out.println("Membership Type: - " + membershipType);
        System.out.println("Total Cost: " + currentTotalCost);

        // Store user information
        idxuserName++;
        idxlicensePlate++;
        idxcarType++;
        idxmembershipType++;
        idxtotalCost++;
        userName[idxuserName] = userName;
        licensePlate[idxlicensePlate] = licensePlate;
        carTypeArray[idxcarType] = carType;
        membershipTypeArray[idxmembershipType] = membershipType;
        totalCostArray[idxtotalCost] = currentTotalCost;

        System.out.println("Do you want to enter another record? (yes/no): ");
    } while (input.next().equalsIgnoreCase("yes"));
}