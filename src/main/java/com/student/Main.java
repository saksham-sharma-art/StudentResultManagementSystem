package com.student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in);
             DatabaseManager db = new DatabaseManager()) {

            while (true) {
                System.out.println("\n1. Add Student\n2. Add Result\n3. Show All Students\n4. Show Result\n5. Update Marks\n6. Delete Student\n7. Exit");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Roll No: ");
                        int roll = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        db.addStudent(new Student(roll, name));
                        break;
                    case 2:
                        System.out.print("Roll No: ");
                        roll = sc.nextInt();
                        System.out.print("Math: ");
                        double math = sc.nextDouble();
                        System.out.print("Science: ");
                        double science = sc.nextDouble();
                        System.out.print("English: ");
                        double english = sc.nextDouble();
                        db.addResult(new Result(roll, math, science, english));
                        break;
                    case 3:
                        db.showAllStudents();
                        break;
                    case 4:
                        System.out.print("Roll No: ");
                        roll = sc.nextInt();
                        db.showResult(roll);
                        break;
                    case 5:
                        System.out.print("Roll No: ");
                        roll = sc.nextInt();
                        System.out.print("New Math: ");
                        math = sc.nextDouble();
                        System.out.print("New Science: ");
                        science = sc.nextDouble();
                        System.out.print("New English: ");
                        english = sc.nextDouble();
                        db.updateMarks(roll, math, science, english);
                        break;
                    case 6:
                        System.out.print("Roll No: ");
                        roll = sc.nextInt();
                        db.deleteStudent(roll);
                        break;
                    case 7:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}