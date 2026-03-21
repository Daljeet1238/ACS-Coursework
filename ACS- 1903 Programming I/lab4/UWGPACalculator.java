/**
 * Daljeet Singh
 * 3169763
 */

import java.util.Scanner;
public class UWGPACalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalCreditHours = 0;
        double totalWGPs = 0;

        System.out.println("Enter the credit hours and grade for each course (enter 0 X to end):");

        int creditHours;

        while ((creditHours = sc.nextInt()) != 0) {
            String grade = sc.next().toUpperCase();
            System.out.println("Grade :" + grade);

            double gradePoints = 0;
            if(creditHours == 3){
                if (grade.equals("A+")) {
                    gradePoints = 4.5;
                } else if (grade.equals("A")) {
                    gradePoints = 4.25;
                } else if (grade.equals("A-")) {
                    gradePoints = 4.0;
                } else if (grade.equals("B+")) {
                    gradePoints = 3.5;
                } else if (grade.equals("B")) {
                    gradePoints = 3.0;
                } else if (grade.equals("C+")) {
                    gradePoints = 2.5;
                } else if (grade.equals("C")) {
                    gradePoints = 2.0;
                } else if (grade.equals("D")) {
                    gradePoints = 1.0;
                }else if (grade.equals("F")){
                    gradePoints = 0.0;
                }
            }else if(creditHours == 6){
                if (grade.equals("A+")) {
                    gradePoints = 4.5;
                } else if (grade.equals("A")) {
                    gradePoints = 4.25;
                } else if (grade.equals("A-")) {
                    gradePoints = 4.0;
                } else if (grade.equals("B+")) {
                    gradePoints = 3.5;
                } else if (grade.equals("B")) {
                    gradePoints = 3.0;
                } else if (grade.equals("C+")) {
                    gradePoints = 2.5;
                } else if (grade.equals("C")) {
                    gradePoints = 2.0;
                } else if (grade.equals("D")) {
                    gradePoints = 1.0;
                }else if (grade.equals("F")){
                    gradePoints = 0.0;
                }
            }
            else{
                System.out.println("Invalid Credit Hours");
            }
            double courseWGP = creditHours * gradePoints;

            totalCreditHours += creditHours;
            totalWGPs += courseWGP;
        }
        double gpa = totalWGPs / totalCreditHours;

        System.out.println("\nGrade Point Average: " + gpa);
    }
}