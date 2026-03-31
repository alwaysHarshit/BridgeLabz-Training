package question3;

import java.util.List;
import java.util.Scanner;

public class CourseEnrollmentAnalyzer {
    public static void main(String[] args) {

        TrainingService trainingService=new TrainingService();

        List<Enrollment> list = List.of(
                new Enrollment("Harshit", "Java", "10/12/2020"),
                new Enrollment("Amit", "Python", "11/12/2020"),
                new Enrollment("Riya", "Java", "12/12/2020"),
                new Enrollment("Neha", "C++", "13/12/2020"),
                new Enrollment("Rahul", "Python", "14/12/2020"),
                new Enrollment("Priya", "Java", "15/12/2020"),
                new Enrollment("Karan", "C", "16/12/2020"),
                new Enrollment("Sneha", "Java", "17/12/2020"),
                new Enrollment("Vikram", "Python", "18/12/2020"),
                new Enrollment("Anita", "C++", "19/12/2020")
        );

        for (Enrollment enrollment : list) {
            //validate
            if(!enrollment.getStudentName().matches("^[a-zA-Z]+$") || !enrollment.getCourseName().matches("^[a-zA-Z+]+$")) throw new RuntimeException("Invalid student name or course name");

            //creating object
            trainingService.add(enrollment);
        }

        trainingService.filterbycategory("Java");

        trainingService.countEnrollments();

        trainingService.sortByDate();
    }
}
