package generics;

import java.util.*;

abstract class JobRole { abstract String roleName(); }
class SoftwareEngineer extends JobRole { @Override String roleName(){ return "Software Engineer"; } }
class DataScientist extends JobRole { @Override String roleName(){ return "Data Scientist"; } }
class ProductManager extends JobRole { @Override String roleName(){ return "Product Manager"; } }

class Resume<T extends JobRole> {
    private String applicantName;
    private T role;
    public Resume(String name, T role){ this.applicantName = name; this.role = role; }
    public T getRole(){ return role; }
    @Override public String toString(){ return applicantName + " applying as " + role.roleName(); }
}

public class AI_resume {
    public static void screenResumes(List<? extends Resume<? extends JobRole>> list) {
        list.forEach(r -> System.out.println("Screening: " + r));
    }
    public static void main(String[] args) {
        List<Resume<? extends JobRole>> resumes = new ArrayList<>();
        resumes.add(new Resume<>("Alice", new SoftwareEngineer()));
        resumes.add(new Resume<>("Bob", new DataScientist()));
        resumes.add(new Resume<>("Carol", new ProductManager()));

        screenResumes(resumes);
    }
}

