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

import java.util.Arrays;
import java.util.Scanner;

public class Student_Management_System {
    public static void main(String[] args) {
        try(Scanner sc=new Scanner(System.in)) {
            String_LinkedList studentList = new String_LinkedList();
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
                String[] stu;
                switch (choice) {
                    case 1:
                        studentList.studentNext();
                        break;

                    case 2:
                        studentList.studentPrevious();
                        break;

                    case 3:
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
                        studentList.insertAtFirstPosition(stu);
                        break;

                    case 4:
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
                        studentList.insertAtLastPosition(stu);
                        break;

                    case 5:
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
                        studentList.insertAtOrder(stu);
                        break;

                    case 6:
                        System.out.println("Enter index :");
                        int index1 = sc.nextInt();
                        sc.nextLine();
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
                        studentList.insertAtSpecificPosition(index1, stu);
                        break;

                    case 7:
                        studentList.deleteFromFirstPosition();
                        break;

                    case 8:
                        studentList.deleteFromLastPosition();
                        break;

                    case 9:
                        System.out.println("Enter index :");
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
                        if(studentList.isEmpty()){
                            System.out.println("Student list is empty.");
                        }
                        else{
                            System.out.println("Student list is not empty.");
                        }
                        break;

                    case 13:
                        studentList.displayStudentLinkedList();
                        break;

                    case -1:
                        System.out.println("Student management system program over.");
                        break;

                    default:
                        System.out.println("Invalid");
                }
            }
        } catch (Exception e) {
            System.out.println("\nUnknown error occurred, "+e.getMessage()+"\nProgram over.");
        }
    }
}

class Student {
    public String[] info;
    public Student link;

    public Student(String[] data){
        this.info=data;
        this.link=null;
    }
}

class String_LinkedList{
    Student first=null;
    Student Student_Position=null;

    protected void studentNext() {
        if (Student_Position==null) {
            if (first == null) {
                System.out.println("Empty student list.");
                return;
            }
            Student_Position = first;
            System.out.println("Current student: " + Arrays.toString(Student_Position.info));
            return;
        }
        if (Student_Position.link == null) {
            System.out.println("End of student list reached.");
            return;
        }
        Student_Position = Student_Position.link;
        System.out.println("Current student: " + Arrays.toString(Student_Position.info));
    }

    protected void studentPrevious() {
        if (Student_Position==null) {
            if (first == null) {
                System.out.println("Empty student list.");
                return;
            }
            Student_Position = first;
            System.out.println("Current student: " + Arrays.toString(Student_Position.info));
            return;
        }
        if (Student_Position == first) {
            System.out.println("Already at the beginning of the student list.");
            return;
        }
        Student previous = first;
        while (previous.link != Student_Position) {
            previous = previous.link;
        }
        Student_Position = previous;
        System.out.println("Current student: " + Arrays.toString(Student_Position.info));
    }

    protected void insertAtFirstPosition(String[] data){
        Student newStudent=new Student(data);
        newStudent.link=first;
        first=newStudent;
    }

    protected void insertAtLastPosition(String[] data){
        Student newStudent=new Student(data);
        if(first==null){
            first=newStudent;
            return;
        }
        Student current=first;
        while(current.link!=null){
            current=current.link;
        }
        current.link=newStudent;
    }

    protected void insertAtOrder(String[] data) {
        Student newStudent = new Student(data);
        int newRollNo = Integer.parseInt(newStudent.info[1].substring(9).trim());
        if (first == null || newRollNo < Integer.parseInt(first.info[1].substring(9).trim())) {
            newStudent.link = first;
            first = newStudent;
            return;
        }
        Student current = first;
        while (current.link != null && newRollNo >= Integer.parseInt(current.link.info[1].substring(9).trim())) {
            current = current.link;
        }
        newStudent.link = current.link;
        current.link = newStudent;
    }

    // user enters 1 based index :-
    protected void insertAtSpecificPosition(int index, String[] data) {
        Student newStudent = new Student(data);
        if (index <= 0) {
            System.out.println("Invalid index.");
            return;
        }
        if (index == 1) {
            newStudent.link = first;
            first = newStudent;
            return;
        }
        Student current = first;
        int currentIndex = 1;
        while (current != null && currentIndex < index - 1) {
            current = current.link;
            currentIndex++;
        }
        if (current == null) {
            System.out.println("Index out of bounds.");
            return;
        }
        newStudent.link = current.link;
        current.link = newStudent;
    }

    protected void deleteFromFirstPosition(){
        if(first==null){
            System.out.println("Empty student list.");
            return;
        }
        first=first.link;
    }

    protected void deleteFromLastPosition(){
        if(first==null){
            System.out.println("Empty student list.");
            return;
        }
        if (first.link == null) {
            first = null;
            return;
        }
        Student current=first;
        while(current.link != null && (current.link).link!=null){
            current=current.link;
        }
        current.link=null;
    }

    // user enters 1 based index :-
    protected void deleteFromSpecificPosition(int index) {
        if (first == null) {
            System.out.println("Empty student list.");
            return;
        }
        if (index <= 0) {
            System.out.println("Invalid index.");
            return;
        }
        if (index == 1) {
            first = first.link;
            return;
        }
        Student current = first;
        int currentIndex = 1;
        while (currentIndex < index - 1 && current.link != null) {
            current = current.link;
            currentIndex++;
        }
        if (current.link == null) {
            System.out.println("Invalid index.");
            return;
        }
        current.link = current.link.link;
    }

    protected void deleteGivenDataFromLinkedList(String[] data){
        if(first==null){
            System.out.println("Empty student list.");
            return;
        }
        if(first.info==data){
            first=first.link;
            return;
        }
        Student current=first;
        while(current.link!=null && !(current.link.info==data)){
            current=current.link;
        }
        if(current.link==null){
            System.out.println("No such element in student list.");
            return;
        }
        current.link=(current.link).link;
    }

    protected void deleteAllStudents() {
        first=null;
    }

    protected boolean isEmpty() {
        return first==null;
    }

    protected void displayStudentLinkedList() {
        if (first == null) {
            System.out.println("Empty student list.");
            return;
        }
        char rightArrow = '→';
        Student current = first;
        System.out.println("\nStudent list: ");
        int i=1;
        while (current != null) {
            System.out.println((i++)+". "+rightArrow+" "+Arrays.toString(current.info));
            current = current.link;
        }
    }
}