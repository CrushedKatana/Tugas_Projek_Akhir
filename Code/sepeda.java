import java.time.LocalTime;
import java.util.Scanner;

public class sepeda{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
    
        //VARIABEL MOTORCYCLE
        
                double hargatotal, hargaparkirmotorcycle = 2000, lamaparkir, hargatitiphelm = 2000;
                String namauser, tipesepeda, nomorplat;
                boolean istitiphelm, ismember;
        
              
        
                System.out.println("Input nama user =");
                namauser = input.next();
                System.out.println("Input plat nomor =");
                nomorplat = input.next();
                System.out.println("Helmet drop off ? (true/false) = ");
                istitiphelm = input.nextBoolean();
                System.out.println("Is user a member ? (true/false) = ");
                ismember = input.nextBoolean();
                System.out.println("Input lama parkir =");
                lamaparkir = input.nextInt();
        
                if (istitiphelm) {
                    hargatotal = (hargaparkirmotorcycle * lamaparkir) + hargatitiphelm;
                    System.out.println("Harga penitipan helm: " + hargatitiphelm);
                } else {
                    hargatotal = hargaparkirmotorcycle * lamaparkir;
                }
        
                if (ismember) {
                    // Diskon 10% untuk member
                    double diskon = hargatotal * 0.1;
                    hargatotal -= diskon;
                    System.out.println("Status member: Yes");
                    System.out.println("Diskon member: " + diskon);
                } else {
                    System.out.println("Status member: No");
                }
                System.out.println("Harga parkir: " + hargaparkirmotorcycle * lamaparkir);
                System.out.println("Harga total: " + hargatotal);
            
    
    }
    
}
