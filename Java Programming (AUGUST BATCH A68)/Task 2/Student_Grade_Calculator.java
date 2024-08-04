/*
    Task 2: Student Grade Calculator
    (Date - 4/8/24)

    Input: Take marks obtained (out of 100) in each subject.
    Calculate Total Marks: Sum up the marks obtained in all subjects.
    Calculate Average Percentage: Divide the total marks by the total number of subjects to get the average percentage.
    Grade Calculation: Assign grades based on the average percentage achieved.
    Display Results: Show the total marks, average percentage, and the corresponding grade to the user
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Student_Grade_Calculator {
    private final String name;
    private final int rollNo;
    private int obtained_Marks = 0;
    private final int number_of_subjects;
    private final int[] subject_marks;
    private final float percentage;
    private final String grade;

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("How many student are there?");
            int n = sc.nextInt();
            Student_Grade_Calculator[] sgc = new Student_Grade_Calculator[n];
            for (int i = 0; i < n; i++) {
                sgc[i] = new Student_Grade_Calculator(i + 1);
            }
            for (int i = 0; i < n; i++) {
                sgc[i].display_Student(i);
            }
        } catch (InputMismatchException e) {
            System.out.println("\nInvalid input. Please enter integer values.\nProgram Over");
        } catch (Exception e) {
            System.out.println("\nAn unexpected error occurred: " + e.getMessage());
        }
    }

    private Student_Grade_Calculator(int i) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nStudent " + i + ":");
        System.out.println("Enter student name:");
        this.name = sc.nextLine().trim();
        System.out.println("Enter student roll no.:");
        this.rollNo = sc.nextInt();
        sc.nextLine();
        System.out.println("How many subjects is this student pursuing?");
        this.number_of_subjects = sc.nextInt();
        sc.nextLine();
        this.subject_marks = new int[number_of_subjects];
        scan_Subjects(sc);
        this.percentage = (float) calculate_Percentage();
        this.grade = calculate_Grade();
    }

    private void scan_Subjects(Scanner sc) {
        for (int i = 0; i < number_of_subjects; i++) {
            System.out.println("Enter marks of subject " + (i + 1) + ":");
            this.subject_marks[i] = sc.nextInt();
        }
    }

    private double calculate_Percentage() {
        int total_marks = number_of_subjects * 100;
        for (int mark : subject_marks) {
            this.obtained_Marks += mark;
        }
        return (float) this.obtained_Marks / total_marks * 100;
    }

    private String calculate_Grade() {
        if (percentage == 100)
            return "A++";
        if (percentage >= 90)
            return "A+";
        if (percentage >= 80)
            return "A";
        if (percentage >= 70)
            return "B+";
        if (percentage >= 60)
            return "B";
        if (percentage >= 50)
            return "C+";
        if (percentage >= 40)
            return "C";
        if (percentage >= 30)
            return "D+";
        if (percentage >= 20)
            return "D";
        if (percentage >= 10)
            return "E+";
        return "E";
    }

    private void display_Student(int i) {
        System.out.println("\nStudent " + (i + 1) + ":");
        System.out.println("Name: " + name);
        System.out.println("Roll number: " + rollNo);
        System.out.println("Number of subjects pursuing: " + number_of_subjects);
        System.out.println("Obtained marks: " + obtained_Marks);
        System.out.printf("Percentage: %.2f", percentage);
        System.out.println("%\nGrade: " + grade);
    }
}
