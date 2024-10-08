package Customers;

import gasSuplier.gasAgency;

public class Customer implements gasAgency{
    public String name;
    public String street;
    public String area;
    public String pincode;
    public String phone;
    public Customer(String name, String street, String area, String pincode, String phone) {
        this.name = name;
        this.street = street;
        this.area = area;
        this.pincode = pincode; 
        this.phone = phone;
    }
    
}