package com.Linkedlist;
import java.util.Scanner;
class Student {
    int rollNumber;
    String name;
    int age;
    char grade;
    Student next;

    public Student(int rollNumber, String name, int age, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}


public class StudentLinkedList {
    private Student head = null;

    // 1. Add at the beginning
    public void addAtBeginning(int roll, String name, int age, char grade) {
        Student newStudent = new Student(roll, name, age, grade);
        newStudent.next = head;
        head = newStudent;
        System.out.println("Added at beginning.");
    }

    // 2. Add at the end
    public void addAtEnd(int roll, String name, int age, char grade) {
        Student newStudent = new Student(roll, name, age, grade);
        if (head == null) {
            head = newStudent;
        } else {
            Student temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newStudent;
        }
        System.out.println("Added at end.");
    }

    // 3. Add at specific position (1-based index)
    public void addAtPosition(int position, int roll, String name, int age, char grade) {
        if (position <= 0) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            addAtBeginning(roll, name, age, grade);
            return;
        }
        Student newStudent = new Student(roll, name, age, grade);
        Student temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds.");
            return;
        }
        newStudent.next = temp.next;
        temp.next = newStudent;
        System.out.println("Added at position " + position + ".");
    }

    // 4. Delete by roll number
    public void deleteByRollNumber(int roll) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.rollNumber == roll) {
            head = head.next;
            System.out.println("Deleted student with Roll Number: " + roll);
            return;
        }
        Student current = head;
        while (current.next != null && current.next.rollNumber != roll) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Roll Number not found.");
        } else {
            current.next = current.next.next;
            System.out.println("Deleted student with Roll Number: " + roll);
        }
    }

    // 5. Search by roll number
    public void searchByRollNumber(int roll) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == roll) {
                System.out.println("Student Found:");
                System.out.println("Roll Number: " + temp.rollNumber);
                System.out.println("Name: " + temp.name);
                System.out.println("Age: " + temp.age);
                System.out.println("Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student with Roll Number " + roll + " not found.");
    }

    // 6. Update grade by roll number
    public void updateGrade(int roll, char newGrade) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == roll) {
                temp.grade = newGrade;
                System.out.println("Updated grade for Roll Number " + roll);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Roll Number not found.");
    }

    // 7. Display all student records
    public void displayAll() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Student temp = head;
        System.out.println("Student Records:");
        while (temp != null) {
            System.out.println("---------------------------");
            System.out.println("Roll Number: " + temp.rollNumber);
            System.out.println("Name: " + temp.name);
            System.out.println("Age: " + temp.age);
            System.out.println("Grade: " + temp.grade);
            temp = temp.next;
        }
        System.out.println("---------------------------");
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentLinkedList list = new StudentLinkedList();
        boolean exit = false;

        while (!exit) {
            System.out.println("\nStudent Records Menu:");
            System.out.println("1. Add Student at Beginning");
            System.out.println("2. Add Student at End");
            System.out.println("3. Add Student at Position");
            System.out.println("4. Delete Student by Roll Number");
            System.out.println("5. Search Student by Roll Number");
            System.out.println("6. Update Grade");
            System.out.println("7. Display All Students");
            System.out.println("8. Exit");
            System.out.print("Enter your choice (1-8): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            int roll, age, pos;
            String name;
            char grade;

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll Number: ");
                    roll = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    age = scanner.nextInt();
                    System.out.print("Enter Grade: ");
                    grade = scanner.next().charAt(0);
                    list.addAtBeginning(roll, name, age, grade);
                    break;
                case 2:
                    System.out.print("Enter Roll Number: ");
                    roll = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    age = scanner.nextInt();
                    System.out.print("Enter Grade: ");
                    grade = scanner.next().charAt(0);
                    list.addAtEnd(roll, name, age, grade);
                    break;
                case 3:
                    System.out.print("Enter Position: ");
                    pos = scanner.nextInt();
                    System.out.print("Enter Roll Number: ");
                    roll = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    age = scanner.nextInt();
                    System.out.print("Enter Grade: ");
                    grade = scanner.next().charAt(0);
                    list.addAtPosition(pos, roll, name, age, grade);
                    break;
                case 4:
                    System.out.print("Enter Roll Number to Delete: ");
                    roll = scanner.nextInt();
                    list.deleteByRollNumber(roll);
                    break;
                case 5:
                    System.out.print("Enter Roll Number to Search: ");
                    roll = scanner.nextInt();
                    list.searchByRollNumber(roll);
                    break;
                case 6:
                    System.out.print("Enter Roll Number to Update Grade: ");
                    roll = scanner.nextInt();
                    System.out.print("Enter New Grade: ");
                    grade = scanner.next().charAt(0);
                    list.updateGrade(roll, grade);
                    break;
                case 7:
                    list.displayAll();
                    break;
                case 8:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}