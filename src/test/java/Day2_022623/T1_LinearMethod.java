package Day2_022623;

public class T1_LinearMethod {
    public static void main(String[] args) {
        // Create list of cities
        String [] cities = new String[]{"Brooklyn" ,"Queens", "Manhattan","Bronx","Staten Island"};
                System.out.println("Cities count " + cities.length);
        System.out.println("My cities are " + cities [0] + cities [3]);

        int[] zipCode = new int[] {11218,22222,33333,555555};
        System.out.println("Zip code count" + zipCode.length);
        System.out.println("My zip codes are" + zipCode [0] + "," + zipCode[2]);
    }
}
