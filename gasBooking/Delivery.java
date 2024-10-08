package gasBooking;
import java.util.*;
import java.util.concurrent.TimeUnit;
public class Delivery extends Booking {
    public Delivery(String name, String street, String area, String pincode, String phone, int numberOfCylinders) {
        super(name, street, area, pincode, phone, numberOfCylinders);
    }
    public String delpersonname;
    int cutomerotp;
    public void amountcalc(){
        long daydiff=dt_2.getTime()-dt_1.getTime();
        long newdiff=TimeUnit.DAYS.convert(daydiff,TimeUnit.MILLISECONDS);
        if(newdiff>7){
            refund=40.0;
            amount=amount-refund;
        }
    }
    public void verifyOTP(){
        if(status.equals("B")){
            System.out.println("Enter the OTP: ");
            int newotp= new Scanner(System.in).nextInt();
            if(newotp==otp){
                status="D";
            }else{
                status="C";
            }
        }else{
            System.out.println("No booking Found!");
        }
    }
    public void getDelpersonName(){
        System.out.println("\nEnter Delivery person Name: ");
        delpersonname=new Scanner(System.in).nextLine();
    }
    
}
