package Customers;

import java.text.SimpleDateFormat;
import java.util.*;

public class GasConnection extends Customer {
    public int numberOfCylinders;
    String date;
    static int connectionNumber = 100;
    {
        connectionNumber += 1;
    }

    public Date lastDate = null;
    public GasConnection(String name, String street, String area, String pincode, String phone, int numberOfCylinders) {
        super(name, street, area, pincode, phone);
        this.numberOfCylinders = numberOfCylinders;

    }

    public void getLastDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Enter the last Date: ");
        date = new Scanner(System.in).next(); // Scanner sc=new Scanner(System.in);
        try {
            lastDate = dateFormat.parse(date);

        } catch (Exception e) {
            System.out.println("Error in getLastDate-" + e);
        }
        System.out.println("Last date is " + lastDate);
    }

}
