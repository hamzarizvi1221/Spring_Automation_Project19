package HOMEWORK_Week1;

import java.util.ArrayList;

public class Part_1 {

    public static void main(String[] args) {
        ArrayList <String> countries = new ArrayList<>();
        ArrayList<String> countryCode = new ArrayList<>();

        countries. add("USA");
        countries. add("India");
        countries. add("Pakistan");
        countries. add("Bangladesh");

        countryCode. add("+1");
        countryCode. add("+91");
        countryCode. add("+92");
        countryCode. add("+880");

        for (int i = 0; i < countries.size(); i++)
            System.out.println("My country is " + countries.get(i) + ", and my country code is " + countryCode.get(i));

    }


}
