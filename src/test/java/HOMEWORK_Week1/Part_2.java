package HOMEWORK_Week1;

public class Part_2 {

    public static void main(String[] args) {

        String[] region = new String[]{"USA, Pakistan, India, Bangladesh"};
        int[] regionalCode = new int[]{1, 92, 91, 880};
        int i = 0;

        while (i < region.length) {
            System.out.println("My regions are " + region[i] + " and my area codes are " + regionalCode[0] + ", " + regionalCode[1] + ", " + regionalCode[2]+ ", " + regionalCode[3]   );

            i = i+1;
        }

        }

    }

