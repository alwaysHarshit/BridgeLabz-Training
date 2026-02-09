import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NameUppercasing {
    
    private final List<String> employeeNames;

    public NameUppercasing() {
        this.employeeNames = new ArrayList<>();
    }

    public void addEmployeeName(String employeeName){
        if(employeeName==null || employeeName.isEmpty()){
            return;
        }
        employeeNames.add(employeeName);
    }

    public List<String> uppercaseEmployeeNames(){
        List<String> uppercaseNames = employeeNames.stream()
                                                    .map(String::toUpperCase)
                                                    .collect(Collectors.toList());
        return uppercaseNames;
    }
    
    public static void main(String[] args) {
        NameUppercasing nameUppercasing = new NameUppercasing();

        nameUppercasing.addEmployeeName("Ava");
        nameUppercasing.addEmployeeName("Lisa");
        nameUppercasing.addEmployeeName("Rosie");
        nameUppercasing.addEmployeeName("Jennie");
        nameUppercasing.addEmployeeName("Jisoo");

        List<String> uppercaseNames = nameUppercasing.uppercaseEmployeeNames();

        System.out.println(uppercaseNames);
    }

}
