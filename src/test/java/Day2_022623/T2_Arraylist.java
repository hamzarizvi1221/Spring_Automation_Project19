package Day2_022623;

import java.sql.SQLOutput;
import java.util.ArrayList;

public record T2_Arraylist() {

    public static void main(String[] args) {
        ArrayList <String> countries = new ArrayList<>();
        countries.add("USA");
        countries.add("India");
        countries.add("Bangladesh");
        countries.add("Pakistan");

        System.out.println("Countries List: " + countries.size());
        System.out.println("Countries are " + countries.get(0) + " and " + countries.get(2));

        ArrayList <Integer> areaCode = new ArrayList<>();
        areaCode.add(777);
        areaCode.add(222);
        areaCode.add(333);
//get the count of the list
        System.out.println("Area code list: " + areaCode.size());
//Print the first and third area code
        System.out.println("Area codes are " + areaCode.get(0) + ", " + areaCode.get(2));

        for (int i = 0; i <= 2; i++)
        System.out.println("Country is " + countries.get(i));
    }

}
