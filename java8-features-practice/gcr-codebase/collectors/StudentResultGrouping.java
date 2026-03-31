import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class StudentResultGrouping{

    public static Map<Grade, List<String>> groupStudents(List<Student> students){

        Map<Grade, List<String>> groupedStudents = students.stream()
                                                            .collect(Collectors.groupingBy(student -> student.getGrade(),
                                                                    Collectors.mapping(Student::getName , Collectors.toList())));
        return groupedStudents;
    }

    public static void main(String[] args) {

        List<Student> students =  new ArrayList<>();

        students.add(new Student("STU123", "Ava", Grade.A));
        students.add(new Student("STU456", "Liz", Grade.B));
        students.add(new Student("STU789", "Bella", Grade.F));
        students.add(new Student("STU147", "Kate", Grade.B));
        students.add(new Student("STU258", "Rosie", Grade.A));
        students.add(new Student("STU369", "Jennie", Grade.A));
        students.add(new Student("STU357", "Marilyn", Grade.B));
        students.add(new Student("STU159", "Alice", Grade.C));
        students.add(new Student("STU248", "Mellisa", Grade.B));
        students.add(new Student("STU862", "Bethany", Grade.D));
        students.add(new Student("STU153", "Lisa", Grade.A));
        students.add(new Student("STU759", "Jisoo", Grade.A));

        Map<Grade, List<String>> groupedStudents = groupStudents(students);

        for(Map.Entry<Grade, List<String>> entry: groupedStudents.entrySet()){
            System.out.println("Grade: "+entry.getKey()+", Students: "+entry.getValue());
        }
        
    }
}

enum Grade{
    A, B, C, D, F;
}
class Student{
    
    private String id;
    private String name;
    private Grade grade;

    public Student(String id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return String.format("[Student ID: %s, Name: %s, Grade: %s]", id, name, grade);
    }

    
}