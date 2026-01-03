class Course {
    protected String courseName;
    protected int duration;

    Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }
}

class OnlineCourse extends Course {
    protected String platform;
    protected boolean isRecorded;

    OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }
}

class PaidOnlineCourse extends OnlineCourse {
    protected double fee;
    protected double discount;

    PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }
}

public class EducationalCourseHierarchy {
    public static void main(String[] args) {
        Course course = new Course("Java Programming", 30);
        OnlineCourse onlineCourse = new OnlineCourse("Python Programming", 40, "Udemy", true);
        PaidOnlineCourse paidOnlineCourse = new PaidOnlineCourse("Data Science", 60, "Coursera", false, 199.99, 20.00);

        System.out.println("Course: " + course.courseName);
        System.out.println("Online Course: " + onlineCourse.courseName + " on " + onlineCourse.platform);
        System.out.println("Paid Online Course: " + paidOnlineCourse.courseName + " with fee " + paidOnlineCourse.fee);
    }
}