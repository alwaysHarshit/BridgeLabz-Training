package csv.advance.problems;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConvertCSVDataIntoJavaObjects {
    
    public static void convertingDataIntoObject() throws IOException , CsvValidationException{
        String filePath = "./src/main/java/csv_data_handling/Student.csv";

        List<Student> students = new ArrayList<>();
        try(
            FileReader fileReader = new FileReader(filePath);
            CSVReader csvReader = new CSVReader(fileReader);
        ){
            String[] student;
            csvReader.readNext();
            while((student = csvReader.readNext()) !=null){
                try {
                    String id = student[0];
                    String name = student[1];
                    int age = Integer.parseInt(student[2]);
                    int marks = Integer.parseInt(student[3]);

                    Student s = new Student(id, name, age, marks);
                    students.add(s);

                }
                catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid student data. Cannot be converted to object.");
                }
            }
        }
        if(students.isEmpty()){
            System.out.println("No valid student data found");
        }
        else{
            for(Student s: students){
                System.out.println(s);
            }
        }
    }
    
}

class Student{
    String ID;
    String name;
    int age;
    int marks;

    public Student(String ID, String name, int age, int marks) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }
    
    @Override
    public String toString(){
        return String.format("ID: %s, Name: %s, Age: %d, Marks: %d", ID,name,age,marks);
    }
}
