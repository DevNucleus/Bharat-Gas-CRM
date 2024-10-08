import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Customers.*;
import gasBooking.*;
import gasSuplier.*;

public class Main {
    static int dcount, bcount, ccount, pcount;
    public String dpname;

    @SuppressWarnings("deprecation")
    public static void cylinderCount(Delivery[] obj) {
        String[] months = new String[] { "January", "Febraury", "March", "April", "May","June","July","August","september","October","November","December" };
        for (Delivery delivery : obj) {
            int count = 0;
            System.out.println("Number of cylinders delieverd " + (months[delivery.dt_2.getMonth()]));
            System.out.println(" In " + delivery.area);
            if (delivery.status.equals("D")) {
                count += delivery.numberOfCylinders;
            }
            System.out.println(" *" + count + " Cylinders Deliverd");
        }
        System.out.println("\n");
    }

    @SuppressWarnings("deprecation")
    public static void checkLateDel(Delivery[] obj) {
        String[] months = new String[] { "January", "Febraury", "March", "April", "May","June","July","August","september","October","November","December" };
        int[] month = new int[12];
        for (Delivery delivery : obj) {
            if (delivery.status.equals("D") && delivery.amount == 775.0) {
                month[delivery.dt_2.getMonth()] += 1;
            }
        }
        System.out.println("--------Late Delievery----------");
        for (int i = 0; i < 12; i++) {
            if (month[i] != 0) {
                System.out.println("In " + months[i] + " There are " + month[i]);
            }
        }
        System.out.println("\n");
    }

    public static void numOfSingleCylinders(Delivery[] obj) {
        System.out.println("-------Singel Cylinder Customer-------");
        for (int i = 0; i < obj.length; i++) {
            if (obj[i].numberOfCylinders == 1) {
                System.out.println("Customer Name: " + obj[i].name);
                System.out.println("Mobile No.: " + obj[i].phone);
                System.out.println("Connection No.: " + (i + 100));
            }
        }
        System.out.println("\n");
    }

    public static void deliverDetails(Delivery[] obj) {
        System.out.println("-------------Delivery Details-------------");
        System.out.println("Enter the Delivery Person Name: ");
        String delper = new Scanner(System.in).nextLine();
        for (Delivery delivery : obj) {
            if (delivery.status.equals("D") && delivery.delpersonname.equals(delper)) {
                System.out.println("Customer Name: " + delivery.name + " - Address: " + delivery.area + ","
                        + delivery.street + "," + delivery.pincode);
            }
        }
    }

    public static void printReport(Delivery[] obj) {
        System.out.println("----------------REPORT-----------------");
        for (int i = 0; i < obj.length; i++) {
            if (obj[i].status.equals("D")) {
                dcount++;
            } else if (obj[i].status.equals("B")) {
                bcount++;
            } else if (obj[i].status.equals("P")) {
                pcount++;
            } else if (obj[i].status.equals("C")) {
                ccount++;
            } else {
                System.out.println("invalid");
            }
        }

        System.out.println("*Booked:    " + bcount);
        System.out.println("*Pending:   " + pcount);
        System.out.println("*Cancelled: " + ccount);
        System.out.println("*Deliverd:  " + dcount);
    }

    public static void inVoice(Delivery[] obj) {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String inVoiceDate = sdf.format(d);
        for (int i = 0; i < obj.length; i++) {
            if (obj[i].status.equals("D")) {
                System.out.println("--------------------------------------------------------");
                System.out.println("                        INVOICE                         ");
                System.out.println("--------------------------------------------------------");
                System.out.println("Agency Code: " + gasAgency.agencyCode+"\t\t\t"+"Invoice Date: "+inVoiceDate);
                System.out.println("Agency Name: " + gasAgency.agencyName+"\t\t\t"+"Contac NO.  : "+gasAgency.contactNumber);
                System.out.println("Gas Connection Number: " + (i+100)+"\t\t\t"+"Customer Name: "+obj[i].name);
                System.out.println("Booking Date: "+sdf.format(obj[i].dt_1)+"\t\t\t"+"Mobile no: "+obj[i].phone);
                System.out.println("---------------------------------------------------------");
                System.out.println("Amount: "+obj[i].amount);
                System.out.println("Refund: "+obj[i].refund);
                System.out.println("Total Amount: "+(obj[i].amount - obj[i].refund));
                System.out.println("------------------------------------------------------------");
                System.out.println("Delivery Person Name: "+obj[i].delpersonname+"\t\t\t"+"Phone No."+obj[i].delmobileno);
                System.out.println("Delivery Date: "+sdf.format(obj[i].dt_2));
                System.out.println("------------------------------------------------------------");
                System.out.println("\n\n");
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("-----------------------GAS AGENCY-----------------------");
        Delivery[] deliveryObj=new Delivery[5];
        deliveryObj[0]=new Delivery("Vasanth","5th Avenue","Alpha-2","606754","145662",1);
        deliveryObj[1]=new Delivery("Krishna","7th Avenue","Alpha-3","606755","902642",1);
        deliveryObj[2]=new Delivery("Nandhini","7th Avenue","Alpha-3","606755","7826361",1);
        deliveryObj[3]=new Delivery("Ajay","2nd Avenue","Alpha-3","606752","73826826",2);
        deliveryObj[4]=new Delivery("Lakshmi","5th Avenue","Alpha-2","606754","8926287",2);

        for(Delivery delivery:deliveryObj){
            delivery.getDelpersonName();
            delivery.getLastDate();
            delivery.getDates();
            delivery.validDate();
            delivery.amountcalc();
            delivery.verifyOTP();
        }
        System.out.println("\n");
        cylinderCount(deliveryObj);
        checkLateDel(deliveryObj);
        numOfSingleCylinders(deliveryObj);
        deliverDetails(deliveryObj);
        printReport(deliveryObj);
        inVoice(deliveryObj);

    }
}
