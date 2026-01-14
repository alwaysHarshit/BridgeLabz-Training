package online.voting.system;

import java.time.LocalDate;
import java.util.Random;

public class Candidate {
    private String candidateName;
    private int candidateId;;
    private String partyName;
    private  String symbol;
    private String consistouncy;

    public Candidate(String candidateName, String partyName, String symbol, String consistouncy) {
        this.candidateName = candidateName;
        this.partyName = partyName;
        this.symbol = symbol;
        this.consistouncy = consistouncy;
        candidateId=new Random().nextInt(1,1000);
    }

    public int getCandidateId() {
        return candidateId;
    }


}
