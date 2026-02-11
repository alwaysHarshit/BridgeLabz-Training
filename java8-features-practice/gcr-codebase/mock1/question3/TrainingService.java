package question3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TrainingService {
    List<Enrollment> list;

    public TrainingService() {
        list = new ArrayList<>();
    }

    //add to the the list
    public void add(Enrollment e) {
        list.add(e);
    }

    // Filter enrollments by course category
    public void filterbycategory(String filterCategory) {
        System.out.println("this is from filter by caterfory \n");

        /* this is one way to filter and print
        List<Enrollment> list1 = list.stream()
                .filter(enrollment -> enrollment.getCourseName().equals(filterCategory))
                .toList();
        list1.stream().forEach(e -> System.out.printf("student name %s cource name %s data %s \n",e.getStudentName(),e.getCourseName(),e.getDate()));
         */


        /* this is another is in which we took help of method reference
        here we have created a print method in enorllment and here we direclty referencing it

         */
        list.stream().
                filter(enrollment -> enrollment.getCourseName().equalsIgnoreCase(filterCategory))
                .toList().forEach(Enrollment::print);
    }

    //count enrollment per category
    public void countEnrollments() {
        /*
        here group by return map . and we can't direclty stream over map  so here
        groupingBy(Enrollment::getCourseName, counting()) → gives: Map<String, Long> like:
        forEach((course, count) -> ...) prints each pair
         */
        list.stream()
                .collect(Collectors.groupingBy(Enrollment::getCourseName, Collectors.counting()))
                .forEach((course, count) ->
                        System.out.println(course + " -> " + count)
                );

    }

    //Sort enrollments by enrollment date
    public  void sortByDate(){
        list.stream().
                sorted(Comparator.
                        comparing(e-> LocalDate.parse(e.getDate(),DateTimeFormatter.ofPattern("dd/MM/yyyy"))))
                .forEach(Enrollment::print);
    }

}
