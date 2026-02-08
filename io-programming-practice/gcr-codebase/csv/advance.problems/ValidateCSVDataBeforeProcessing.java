package csv_data_handling;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class ValidateCSVDataBeforeProcessing {
    
    public static void processData() throws IOException , CsvValidationException{
        
        String filePath = "./src/main/java/csv_data_handling/Person.csv";

        try (
            FileReader fileReader = new FileReader(filePath);
            CSVReader csvReader = new CSVReader(fileReader);
        ){
            String[] person;
            person = csvReader.readNext();

            if(person!=null){
                System.out.println(Arrays.toString(person));

                while ((person = csvReader.readNext()) != null) { 
                    try {
                        if(validatePhoneNumber(person[3]) && validateEmail(person[4])){
                            System.out.println(Arrays.toString(person));
                        }
                        else{
                            System.out.println("Error! Invalid person data: "+Arrays.toString(person));
                        }
                    } 
                    catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Error! Person data missing: "+Arrays.toString(person));
                    }
                }
            }
        } 
    }

    private static boolean validateEmail(String email){
        String regex = "^[a-zA-Z0-9]+([\\.][a-zA-Z0-9]+)*@[a-zA-Z0-9]+([\\.][a-zA-Z0-9]+)*[\\.][a-zA-Z]{2,}$";
        return email.matches(regex);
    }

    private static boolean validatePhoneNumber(String phoneNumber){
        final String REGEX = "[0-9]{10}";
        return phoneNumber.matches(REGEX) && !phoneNumber.equals("0000000000");
    }
}
