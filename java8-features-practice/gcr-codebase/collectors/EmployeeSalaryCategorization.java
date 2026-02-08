import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeSalaryCategorization {
    
    public static void displayAverageSalaryPerDepartment(List<Employee> employees){
        Map<String, Double> averageSalaryByDepartment = employees.stream()
                                                                .collect(Collectors.groupingBy(employee -> employee.getDepartment().toString(),
                                                                        Collectors.averagingDouble(Employee::getSalary)));

        for(Map.Entry<String, Double> entry: averageSalaryByDepartment.entrySet()){
            System.out.printf("Department: %s, Average Salary: %.2f INR%n", entry.getKey(), entry.getValue());
        }

    }
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("EMP1", "Ava", Department.IT, 775000.0));
        employees.add(new Employee("EMP2", "Lisa", Department.HR, 850000.0));
        employees.add(new Employee("EMP3", "Jennie", Department.HR, 900000.0));
        employees.add(new Employee("EMP4", "Jisoo", Department.MARKETING, 880000.0));
        employees.add(new Employee("EMP5", "Rosie", Department.PRODUCTION, 850000.0));
        employees.add(new Employee("EMP6", "Violet", Department.PRODUCTION, 800000.0));
        employees.add(new Employee("EMP7", "Caitlyn", Department.IT, 950000.0));
        employees.add(new Employee("EMP8", "Mel", Department.FINANCE, 925000.0));
        employees.add(new Employee("EMP9", "Mitsuki", Department.PRODUCTION, 75000.0));
        employees.add(new Employee("EMP10", "Aya", Department.FINANCE, 775000.0));
        employees.add(new Employee("EMP11", "Yuki", Department.HR, 875000.0));
        employees.add(new Employee("EMP12", "Shoko", Department.IT, 925000.0));

        displayAverageSalaryPerDepartment(employees);
    }
}

enum Department{
    MARKETING, IT, HR, FINANCE, PRODUCTION;
}

class Employee{

    private final String id;
    private String name;
    private Department department;
    private double salary;

    public Employee(String id, String name, Department department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

}