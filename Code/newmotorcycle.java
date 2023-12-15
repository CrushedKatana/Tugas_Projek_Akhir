import java.util.Scanner;

public class newmotorcycle{
    class Parkir{
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
            Scanner sc = new Scanner(System.in);
            
            // Total number of parking spaces
            int totalParkingSpaces = 50;

            // Matrix to store parking status (0: empty, 1: occupied)
            int[][] parkingStatus = new int[totalParkingSpaces][2];

            do {
                double totalCost, motorcycleParkingFee = 2000, parkingDuration, helmetStorageCost = 0, motorcycleStorageCostWash = 0;
                boolean isHelmetStored, isMember, isMotorcycleWash;
                String membershipType = "";
                String timeIn, timeOut;
      
            idxuserName++;
            idxlicensePlate++;
            idxbiketype++;
            idxmembershipType++;
            idxtotalCost++;
            System.out.print(" Input user name = ");
            userName[idxuserName] = sc.next();
            System.out.print(" Input license plate = ");
            licensePlate[idxlicensePlate] = sc.next();
            System.out.print(" Input bike type = ");
            bikeType[idxbiketype] = sc.next();
        while (isMotorcycleWash) {
            
        }
        

    }
