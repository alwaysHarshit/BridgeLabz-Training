package question3;

public class Enrollment {

    private String studentName;
    private String courseName;
    private String date;

    public Enrollment(String studentName, String courceName, String date) {
        this.studentName = studentName;
        this.courseName = courceName;
        this.date = date;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDate() {
        return date;
    }

    public  void print(){
        System.out.println("Student name is " + studentName);
        System.out.println("Course name is " + courseName);
        System.out.println("Date is " + date);
        System.out.println("-----------------------------");
    }
}
