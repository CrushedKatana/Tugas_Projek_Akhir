import java.util.Scanner;

public class Sistem_parkir{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
       //variable// 
        int total_price, parking_price=2000, helmet_storage_price=1000 ;
        String name, number_plate, motorcycle_type, input_helmet_drop_off;
        double discount=0.1, parking_duration, puchaseprice, totalPrice, totalDiscount;

        //formulas//
        totalPrice=parking_duration*parking_price;
        totalDiscount=totalPrice*discount;
        puchaseprice=totalPrice-totalDiscount;
      


        //output//
        System.out.println("Input name: ");
        name=input.next();
        System.out.println("Input number plate: ");
        number_plate=input.next();
        System.out.println("Input motorcycle type: ");
        motorcycle_type=input.next();
        System.out.println("Input helmet drop off: ");
        input_helmet_drop_off=input.next();
        System.out.println("Input discount: " +totalDiscount);
        System.out.println("Final purchase price: " +puchaseprice);
        
        
    
    }
}