package online.voting.system;

import java.time.LocalDate;
import java.util.Random;

public class Voter {
    private String votarName;
    private int votarId;
    private LocalDate dob;
    private int contactNumber;
    private String  address;

    public Voter(String votarName, LocalDate date, int contactNumber, String address) {
        this.votarName = votarName;
        this.dob = date;
        this.contactNumber = contactNumber;
        this.address = address;
        votarId=new Random().nextInt(1,10000);
    }

    public int getVotarId() {
        return votarId;
    }

    public void  printVoter(){
        System.out.println("Voter Name:"+votarName);
        System.out.println("Date of birth:"+dob);
        System.out.println("contactNumber:"+contactNumber);
        System.out.println("address:"+address);
    }
}
