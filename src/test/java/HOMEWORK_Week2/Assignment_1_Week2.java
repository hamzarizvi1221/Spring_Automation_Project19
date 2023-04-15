package HOMEWORK_Week2;

public class Assignment_1_Week2 {

    public static void main(String[] args) {

        // set initial grade value to 90
        int grade = 90;

// Check if grade is between 90 and 100
        if (grade >= 90 && grade <= 100){
            System.out.println("Grade is A");
            // Check if grade is between 80 and under 90
        } else if (grade >= 80 && grade < 90) {
            System.out.println("Grade is B");
            // Check if grade is between 70 and under 80
        } else if (grade >= 70 && grade <80) {
            System.out.println("Grade is C");
            // Check if grade is between 60 and less than 70
        } else if (grade >= 60 && grade < 70) {
            System.out.println("Grade is D");
            // Check if grade is below 60
        } else {
            System.out.println("Grade is F");
            // Print out the final value of the grade variable

        }

    }
    }

