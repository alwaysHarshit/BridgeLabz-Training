package generics;
import java.util.*;

abstract class CourseType { abstract String typeName(); }
class ExamCourse extends CourseType { @Override String typeName() { return "Exam"; } }
class AssignmentCourse extends CourseType { @Override String typeName() { return "Assignment"; } }
class ResearchCourse extends CourseType { @Override String typeName() { return "Research"; } }

class Course<T extends CourseType> {
    private String code;
    private T courseType;
    public Course(String code, T ct){ this.code = code; this.courseType = ct; }
    @Override public String toString(){ return code + " (" + courseType.typeName() + ")"; }
}

public class UniversityCourse {
    public static void printCourses(List<? extends Course<? extends CourseType>> courses) {
        courses.forEach(System.out::println);
    }
    public static void main(String[] args) {
        List<Course<? extends CourseType>> courseList = new ArrayList<>();
        courseList.add(new Course<>("CSE101", new ExamCourse()));
        courseList.add(new Course<>("ART202", new AssignmentCourse()));
        courseList.add(new Course<>("RES303", new ResearchCourse()));

        System.out.println("University Courses:");
        printCourses(courseList);
    }
}
