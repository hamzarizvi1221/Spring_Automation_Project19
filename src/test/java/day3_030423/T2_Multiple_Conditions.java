package day3_030423;

public class T2_Multiple_Conditions {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        int c = 4;

        if (a + b > c) {
            System.out.println("a & b is greater than c");
        } else if (a + b < c) {

            System.out.println("a & b is less than c");
        } else if (a + b == c) System.out.println("a & b is equal to c");
    }
}



