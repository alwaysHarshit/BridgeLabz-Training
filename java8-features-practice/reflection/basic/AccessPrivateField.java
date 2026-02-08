import java.lang.reflect.Field;

class Person {
    private int age = 20;
}

public class AccessPrivateField {
    public static void main(String[] args) throws Exception {
        Person p = new Person();

        Field field = Person.class.getDeclaredField("age");
        field.setAccessible(true); // bypass private

        field.set(p, 30); // modify
        int value = (int) field.get(p); // read

        System.out.println("Modified age = " + value);
    }
}
