import java.util.ArrayList;
import java.util.List;

abstract class Employee {
    private int employeeId;
    private String name;
    protected int baseSalary;

    Employee(int employeeId, String name, int baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    abstract int calculateSalary();

    void displayDetails() {
        System.out.println("Employee Name: " + name + ", Employee ID: " + employeeId + ", Salary: " + calculateSalary());
    }
}

class FullTimeEmployee extends Employee {
    FullTimeEmployee(int employeeId, String name, int baseSalary) {
        super(employeeId, name, baseSalary);
    }

    int calculateSalary() {
        final int joiningBonus = 200000;
        final int perks = 50000;
        return super.baseSalary + joiningBonus + perks;
    }
}

class PartTimeEmployee extends Employee {
    PartTimeEmployee(int employeeId, String name, int baseSalary) {
        super(employeeId, name, baseSalary);
    }

    int calculateSalary() {
        return (int) (super.baseSalary * 0.5); // Assuming part-time employees earn half the base salary
    }
}

interface Department {
    void assignDepartment(String departmentName);
    String getDepartmentDetails();
}

class EmployeeManagement {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new FullTimeEmployee(101, "Sanju Kataria", 1200000));
        employees.add(new PartTimeEmployee(102, "Ravi Kumar", 600000));

        for (Employee employee : employees) {
            employee.displayDetails();
        }
    }
}