import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

@Author(name = "Harshit")
class Book {
}

public class ReadAnnotation {
    public static void main(String[] args) {
        Class<Book> clazz = Book.class;

        if (clazz.isAnnotationPresent(Author.class)) {
            Author a = clazz.getAnnotation(Author.class);
            System.out.println("Author name = " + a.name());
        }
    }
}
