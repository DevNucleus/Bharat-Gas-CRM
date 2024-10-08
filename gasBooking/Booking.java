package gasBooking;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import Customers.*;

public class Booking extends GasConnection {

    public double otp = 1010, amount = 825.0, refund = 0;
    public String dt, deldate, status, delmobileno = "7094953408";

    public Booking(String name, String street, String area, String pincode, String phone, int numberOfCylinders) {
        super(name, street, area, pincode, phone, numberOfCylinders);
    }

    public long diff = 0;
    public Date dt_1 = null;
    public Date dt_2 = null;
    
    public void getDates() {

        //booking Date
        System.out.println("Enter the Booking Date: ");
        dt = new Scanner(System.in).next();
        dt_2=null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            dt_1 = dateFormat.parse(dt);
        } catch (Exception e) {
            System.out.println("Error in dt_1");
        }

        //Delivery Date
        System.out.println("Enter the Delivery Date: ");
        deldate = new Scanner(System.in).nextLine();
        try {
            dt_2 = dateFormat.parse(deldate);
        } catch (Exception e) {
            System.out.println("Error in dt_2");
        }

        //Finding Differ. in Datea
        try {
            diff = dt_2.getTime() - dt_1.getTime();
            //Difference in Days
            long newDiff = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            //System.out.println("Different Between Dates: " + newDiff);
            if (newDiff > 7) {
                status = "P";
            }
        } catch (Exception e) {
            System.out.println("Error in Finding Difference");
            
        }
        
    }
    public void validDate(){
        long duration = dt_1.getTime() - lastDate.getTime();
        long diff = TimeUnit.DAYS.convert(duration, TimeUnit.MILLISECONDS);
        System.out.println("Difference is "+diff);
        if (numberOfCylinders == 1) {
            if (diff < 30) {
                System.out.println("Booking cannot be done.");
                status = "C";
            } else {
                System.out.println("Booked");
                status = "B";
                lastDate = dt_1;
            }
        } else if (numberOfCylinders == 2) {
            if (diff < 50) {
               System.out.println("Booking cannot be done");
                status = "C";
            } else {
                System.out.println("Booked");
                status = "B";
                lastDate = dt_1;
            }
        }
    }


}
