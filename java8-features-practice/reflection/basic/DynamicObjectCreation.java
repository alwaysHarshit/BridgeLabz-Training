class Student {
    String name;

    public Student() {
        this.name = "Default Student";
    }
}

public class DynamicObjectCreation {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("Student");
        Object obj = clazz.getDeclaredConstructor().newInstance();

        Student s = (Student) obj;
        System.out.println("Student name = " + s.name);
    }
}
