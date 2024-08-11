import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

class Student {
    public String[] info;
    // This info[] ↑ contains 5 details of a student (name, rollNo, standard, age, grade).
    public Student link;

    public Student(String[] data){
        this.info=data;
        this.link=null;
    }
}

class Student_Details_Manipulation{
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

    protected void deleteGivenDataFromLinkedList(String[] data) {
        if (first == null) {
            System.out.println("Empty student list.");
            return;
        }
        if (isDataSame(first.info, data)) {
            first = first.link;
            return;
        }
        Student current = first;
        while (current.link != null && !isDataSame(current.link.info, data)) {
            current = current.link;
        }
        if (current.link == null) {
            System.out.println("No such student in student list.");
            return;
        }
        current.link = current.link.link;
    }

    private boolean isDataSame(String[] info1, String[] info2) {
        if (info1.length != info2.length) return false;
        for (int i = 0; i < info1.length; i++) {
            if (!info1[i].equals(info2[i])) return false;
        }
        return true;
    }


    protected void deleteAllStudents() {
        first=null;
    }

    protected void searchStudent(Scanner sc){
        if (first == null) {
            System.out.println("Empty student list.");
            return;
        }
        System.out.println("Enter student's rollNo: ");
        int rollNo;
        try {
            rollNo = sc.nextShort();
            if (rollNo < 1 || rollNo > 10000) {  // I've assumed that there are maximum 10,000 students in school/college.
                System.out.println("\nError: Invalid rollNo.\nYour operation on student list has started again.\n");
                searchStudent(sc);
                return;
            }
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("\nError: Invalid rollNo.\nYour operation on student list has started again.\n");
            sc.nextLine();
            searchStudent(sc);
            return;
        }
        if(first.link == null){
            if(rollNo==Integer.parseInt(first.info[1].replaceAll("Roll No: ", "").trim())){
                System.out.println("Index: 1");
                return;
            }
        }
        Student current = first;
        int i=1;
        while (current.link != null) {
            if(rollNo==Integer.parseInt(current.info[1].replaceAll("Roll No: ", "").trim())){
                System.out.println("Index: "+i);
                return;
            }
            current = current.link;
        }
        System.out.println("No such student in student list.");
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
        System.out.println("\nStudent list:- ");
        int i=1;
        while (current != null) {
            System.out.println((i++)+". "+rightArrow+" "+Arrays.toString(current.info));
            current = current.link;
        }
    }

    protected void saveOnFile(Scanner sc) {
        if (first == null) {
            System.out.println("The student list is empty.");
            return;
        }
        File file = new File("Student_List.txt");
        String yesNo;
        if (file.exists() && file.isFile() && file.length() != 0) {
            System.out.println("\nNote: Saving the current list will overwrite the previously saved list.\nDo you want to proceed? (Yes/No)");
            while (true) {
                yesNo = sc.nextLine().trim();
                if (yesNo.equalsIgnoreCase("Yes") || yesNo.equalsIgnoreCase("No")) {
                    break;
                } else {
                    System.out.println("\nInvalid input. Please enter 'Yes' or 'No'.");
                }
            }
            if (yesNo.equalsIgnoreCase("No")) {
                return;
            }
        }
        else if(!file.exists() || !file.isFile()) {
            try {
                file.createNewFile();
            } catch (Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
        try (FileWriter fw = new FileWriter(file); BufferedWriter writer = new BufferedWriter(fw)) {
            char rightArrow = '→';
            Student current = first;
            writer.write("Student list:");
            writer.newLine();
            writer.newLine();
            int i = 1;
            while (current != null) {
                writer.write(i++ + ". " + rightArrow + " " + Arrays.toString(current.info));
                if(current.link!=null)
                    writer.newLine();
                current = current.link;
            }
            System.out.println("Student details have been saved to Student_List.txt.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}