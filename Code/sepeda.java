import java.util.Scanner;

public class sepeda {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // VARIABEL MOTORCYCLE
        double hargatotal, hargaparkirmotorcycle = 2000, lamaparkir, hargatitiphelm = 0;
        String namauser, tipesepeda, nomorplat;
        boolean istitiphelm, ismember;
        String jenisMember = "";

        System.out.println("Input nama user =");
        namauser = input.next();
        System.out.println("Input plat nomor =");
        nomorplat = input.next();
        System.out.println("Helmet drop off ? (true/false) = ");
        istitiphelm = input.nextBoolean();

        if (istitiphelm) {
            System.out.println("Pilih tipe helm (half/full): ");
            String tipehelm = input.next();
            if (tipehelm.equalsIgnoreCase("half")) {
                hargatitiphelm = 2000;
            } else if (tipehelm.equalsIgnoreCase("full")) {
                hargatitiphelm = 3000;
            } else {
                System.out.println("Tipe helm tidak valid. Gunakan 'half' atau 'full'.");
                return;
            }
        }

        // Harga parkir per jam
        System.out.println("Input lama parkir (jam) =");
        lamaparkir = input.nextDouble();

        if (lamaparkir <= 5) {
            hargatotal = hargaparkirmotorcycle * lamaparkir;
        } else {
            hargatotal = (hargaparkirmotorcycle * 5) + (hargaparkirmotorcycle * (lamaparkir - 5));
        }

        // Harga penitipan helm
        if (istitiphelm) {
            hargatotal += hargatitiphelm;
            System.out.println("Harga penitipan helm: " + hargatitiphelm);
        }

        // Input apakah pengguna adalah member atau bukan
        System.out.println("Apakah pengguna adalah member? (true/false) = ");
        ismember = input.nextBoolean();

        // Input jenis keanggotaan jika pengguna adalah member
        if (ismember) {
            System.out.println("Pilih jenis keanggotaan (1 = Reguler, 2 = Premium, 3 = Executive): ");
            int jenisKeanggotaan = input.nextInt();
            if (jenisKeanggotaan == 1) {
                jenisMember = "Reguler";
            } else if (jenisKeanggotaan == 2) {
                jenisMember = "Premium";
            } else if (jenisKeanggotaan == 3) {
                jenisMember = "Executive";
            } else {
                System.out.println("Jenis keanggotaan tidak valid. Gunakan 1 untuk Reguler, 2 untuk Premium, atau 3 untuk Executive.");
                return;
            }
        }

        // Diskon berdasarkan jenis keanggotaan
        if (jenisMember.equals("Reguler")) {
            // Diskon 10% untuk member reguler
            double diskon = hargatotal * 0.1;
            hargatotal -= diskon;
            System.out.println("Status member: Reguler");
            System.out.println("Diskon member: " + diskon);
        } else if (jenisMember.equals("Premium")) {
            // Diskon 15% untuk member premium
            double diskon = hargatotal * 0.15;
            hargatotal -= diskon;
            System.out.println("Status member: Premium");
            System.out.println("Diskon member: " + diskon);
        } else if (jenisMember.equals("Executive")) {
            // Diskon 20% untuk member executive
            double diskon = hargatotal * 0.2;
            hargatotal -= diskon;
            System.out.println("Status member: Executive");
            System.out.println("Diskon member: " + diskon);
        }

        System.out.println("Jenis Keanggotaan: " + jenisMember);
        System.out.println("Harga total: " + hargatotal);
        input.close();
    }
}
