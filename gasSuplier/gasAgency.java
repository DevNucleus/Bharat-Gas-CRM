package gasSuplier;

public interface gasAgency {
    public static String agencyName = "Bharat Gas Service";
    public static int agencyCode = 1234;
    public static int contactNumber = 000000;

    default void agencyDisplay() {
        System.out.print("Agency Name: \n" + agencyName);
        System.out.print("Agency Code: \n" + agencyCode);
        System.out.print("contactNumber: \n" + contactNumber);
    }
}