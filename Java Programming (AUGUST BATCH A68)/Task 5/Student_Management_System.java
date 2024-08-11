/*
    Task 5: Student Management System
    (Date - 10/8/24)

    Create a Student class to represent individual students.
    Include attributes such as name, roll number, grade, and any other relevant details.
    Implement a StudentManagementSystem class to manage the collection of students.
    Include methods to add a student, remove a student, search for a student, and disStudent_ all students.
    Design the user interface for the Student Management System.
    This can be a console-based interface or a graphical user interface (GUI) using libraries like Swing or JavaFX.
    Implement methods to read and write student data to a storage medium, such as a file or a database.
    Allow users to interact with the Student Management System by providing options such as adding a new student, editing an existing student's information, searching for a student, disStudent_ing all students, and exiting the application.
    Implement input validation to ensure that required fields are not left empty and that the student data is in the correct format.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Student_Management_System {
    public static void main(String[] args) {
        try(Scanner sc=new Scanner(System.in)) {
            Student_Details_Manipulation studentList = new Student_Details_Manipulation();
            int choice = 0;
            while (choice != -1) {
                System.out.println("\nEnter 1 to see next student details from student list: ");
                System.out.println("Enter 2 to see previous student details from student list: ");
                System.out.println("Enter 3 to add student details at first position in student list: ");
                System.out.println("Enter 4 to add student details at last position in student list: ");
                System.out.println("Enter 5 to add student details in ascending order in student list: ");
                System.out.println("Enter 6 to add student details at specific position in student list: ");
                System.out.println("Enter 7 to delete student details, which is at first position in student list: ");
                System.out.println("Enter 8 to delete student details, which is at last position in student list: ");
                System.out.println("Enter 9 to delete student details, which is at specific position in student list: ");
                System.out.println("Enter 10 to delete given student details in student list: ");
                System.out.println("Enter 11 to delete all student details in student list: ");
                System.out.println("Enter 12 to check if student list is empty or not: ");
                System.out.println("Enter 13 to display student list: ");
                System.out.println("Enter -1 to exit music player application: ");
                choice = sc.nextInt();
                sc.nextLine();
                scan(studentList,choice);
            }
        } catch (Exception e) {
            System.out.println("\nUnknown error occurred, "+e.getMessage()+"\nProgram over.");
        }
    }

    private static void scan(Student_Details_Manipulation studentList, int choice){
        String[] stu;
        Scanner sc=new Scanner(System.in);
        switch (choice) {
            case 1:
                studentList.studentNext();
                break;

            case 2:
                studentList.studentPrevious();
                break;

            case 3:
                stu=scanDetails();
                if(stu[0]!=null && stu[1]!=null && stu[2]!=null && stu[3]!=null && stu[4]!=null){
                    studentList.insertAtFirstPosition(stu);
                }
                break;

            case 4:
                stu=scanDetails();
                if(stu[0]!=null && stu[1]!=null && stu[2]!=null && stu[3]!=null && stu[4]!=null){
                    studentList.insertAtLastPosition(stu);
                }
                break;

            case 5:
                stu=scanDetails();
                if(stu[0]!=null && stu[1]!=null && stu[2]!=null && stu[3]!=null && stu[4]!=null){
                    studentList.insertAtOrder(stu);
                }
                break;

            case 6:
                System.out.println("Enter index: ");
                int index1 = sc.nextInt();
                sc.nextLine();
                stu=scanDetails();
                if(stu[0]!=null && stu[1]!=null && stu[2]!=null && stu[3]!=null && stu[4]!=null){
                    studentList.insertAtSpecificPosition(index1, stu);
                }
                break;

            case 7:
                studentList.deleteFromFirstPosition();
                break;

            case 8:
                studentList.deleteFromLastPosition();
                break;

            case 9:
                System.out.println("Enter index: ");
                int index2 = sc.nextInt();
                sc.nextLine();
                studentList.deleteFromSpecificPosition(index2);
                break;

            case 10:
                stu = new String[5];
                System.out.println("Enter student name: ");
                stu[0] = "Name: " + sc.nextLine();
                System.out.println("Enter student rollNo: ");
                stu[1] = "Roll No: " + sc.nextLine();
                System.out.println("Enter student standard: ");
                stu[2] = "Standard: " + sc.nextLine();
                System.out.println("Enter student age: ");
                stu[3] = "Age: " + sc.nextLine();
                System.out.println("Enter student grade: ");
                stu[4] = "Grade: " + sc.nextLine();
                studentList.deleteGivenDataFromLinkedList(stu);
                break;

            case 11:
                studentList.deleteAllStudents();
                break;

            case 12:
                if (studentList.isEmpty()) {
                    System.out.println("Student list is empty.");
                } else {
                    System.out.println("Student list is not empty.");
                }
                break;

            case 13:
                studentList.displayStudentLinkedList();
                break;

            case -1:
                System.out.println("Student management system program over.");
                System.exit(0);

            default:
                System.out.println("Invalid");
        }
    }

    private static String[] scanDetails(){
        Scanner sc=new Scanner(System.in);
        String[] stu;
        stu = new String[5];
        System.out.println("Enter student's name: ");
        String name=sc.nextLine();
        if(checkName(name)){
            System.out.println("\nError: Invalid name.\nEnter this student details again.\n");
            scanDetails();
            return stu;
        }
        stu[0] = "Name: " + name;

        System.out.println("Enter student's rollNo: ");
        short rollNo;
        try {
            rollNo = sc.nextShort();
            if(rollNo<1 || rollNo>10000){ // I've assumed that there are less than or equal to 10,000 students in school/college.
                System.out.println("\nError: Invalid rollNo.\nEnter this student details again.\n");
                scanDetails();
                return stu;
            }
            sc.nextLine();
        } catch (InputMismatchException e){
            System.out.println("\nError: Invalid rollNo.\nEnter this student details again.\n");
            scanDetails();
            return stu;
        } catch (Exception e) {
            System.out.println("\nSome unknown error occurred: " + e.getMessage()+"\nEnter this student details again.");
            scanDetails();
            return stu;
        }
        stu[1] = "Roll No: " + rollNo;

        System.out.println("Enter student's standard: ");
        byte std;
        try {
            std = sc.nextByte();
            if(std<1 || std>12){
                System.out.println("\nError: Invalid standard.\nEnter this student details again.\n");
                scanDetails();
                return stu;
            }
            sc.nextLine();
        } catch (InputMismatchException e){
            System.out.println("\nError: Invalid standard.\nEnter this student details again.\n");
            scanDetails();
            return stu;
        } catch (Exception e) {
            System.out.println("\nSome unknown error occurred: " + e.getMessage() + "\nEnter this student details again.");
            scanDetails();
            return stu;
        }
        stu[2] = "Standard: " + std;

        System.out.println("Enter student age: ");
        byte age;
        try {
            age = sc.nextByte();
            if(age<1 || age>30){
                System.out.println("\nError: Invalid age.\nEnter this student details again.\n");
                scanDetails();
                return stu;
            }
            sc.nextLine();
        } catch (InputMismatchException e){
            System.out.println("\nError: Invalid age.\nEnter this student details again.\n");
            scanDetails();
            return stu;
        } catch (Exception e) {
            System.out.println("\nSome unknown error occurred: " + e.getMessage()+"\nEnter this student details again.");
            scanDetails();
            return stu;
        }
        stu[3] = "Age: " + age;

        System.out.println("Enter student grade: ");
        String grade=sc.nextLine();
        if(checkGrade(grade)){
            System.out.println("\nError: Invalid grade.\nEnter this student details again.\n");
            scanDetails();
            return stu;
        }
        stu[4] = "Grade: " + grade;
        return stu;
    }

    private static boolean checkName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return true;
        }
        String regex = "^[a-zA-Z]+( [a-zA-Z]+)*$";
        return !name.matches(regex);
    }

    private static boolean checkGrade(String grade){
        return !grade.equalsIgnoreCase("A++") &&
                !grade.equalsIgnoreCase("A+") &&
                !grade.equalsIgnoreCase("A") &&
                !grade.equalsIgnoreCase("B+") &&
                !grade.equalsIgnoreCase("B") &&
                !grade.equalsIgnoreCase("C+") &&
                !grade.equalsIgnoreCase("C") &&
                !grade.equalsIgnoreCase("D+") &&
                !grade.equalsIgnoreCase("D") &&
                !grade.equalsIgnoreCase("E+") &&
                !grade.equalsIgnoreCase("E");
    }
}


