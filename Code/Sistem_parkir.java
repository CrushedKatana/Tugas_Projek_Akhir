import java.time.LocalTime;
import java.util.Scanner;

public class Sistem_parkir{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
       
        System.out.println("  _____        _____  _  _______ _   _  _____    _______     _______ _______ ______ __  __ ");
        System.out.println(" |  __ \\ /\\   |  __ \\| |/ /_   _| \\ | |/ ____|  / ____\\ \\   / / ____|__   __|  ____|  \\/  |");
        System.out.println(" | |__) /  \\  | |__) | ' /  | | |  \\| | |  __  | (___  \\ \\_/ / (___    | |  | |__  | \\  / |");
        System.out.println(" |  ___/ /\\ \\ |  _  /|  <   | | | . ` | | |_ |  \\___ \\  \\   / \\___ \\   | |  |  __| | |\\/| |");
        System.out.println(" | |  / ____ \\| | \\ \\| . \\ _| |_| |\\  | |__| |  ____) |  | |  ____) |  | |  | |____| |  | |");
        System.out.println(" |_| /_/    \\_\\_|  \\_\\_|\\_\\_____|_| \\_|\\_____| |_____/   |_| |_____/   |_|  |______|_|  |_|");
        System.out.println(" ");
        System.out.println(" ");
       
        //variable 

        //int total_price, parking_price=2000, helmet_storage_price=1000;
        //String name, number_plate, motorcycle_type, input_helmet_drop_off;
        //double discount=0.1, puchaseprice, totalPrice, totalDiscount, parking_duration;

        //formulas
        //totalPrice=parking_price*parking_duration;
        //totalDiscount=totalPrice*discount;
        //puchaseprice=totalPrice-totalDiscount;
       
        //output
        //System.out.println("Input name: ");
        //name=input.next();
        //System.out.println("Input number plate: ");
        //number_plate=input.next();
        //System.out.println("Input motorcycle type: ");
        //motorcycle_type=input.next();
        //System.out.println("Input helmet drop off: ");
       // input_helmet_drop_off=input.next();
        //System.out.println("Input parking duration: ");
        //parking_duration=input.nextInt();
        //System.out.println("Input discount: " +totalDiscount);
        //System.out.println("Final purchase price: " +puchaseprice);
        //VARIABEL CAR
        double totalharga, waktu  ;
        double hargaparkir = 5000;
        String nama_user, platnomor, tipemobil;
        System.out.println("input nama user");
        nama_user = input.next();
        System.out.println("input plat nomor");
        platnomor = input.next();
        System.out.println("tipe mobil");
        tipemobil = input.next();
        System.out.println(" waktu");
        waktu = input.nextInt();
        hargaparkir = 5000;
        totalharga=(hargaparkir*waktu);
        System.out.println( "total harga " + totalharga);

    }
}

       