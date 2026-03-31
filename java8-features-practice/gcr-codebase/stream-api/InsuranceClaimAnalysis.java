import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InsuranceClaimAnalysis {
    public static void main(String[] args) {
        List<InsuranceClaim> insurances = new ArrayList<>();

        insurances.add(new InsuranceClaim("ID1", ClaimType.LIFE, 50000));
        insurances.add(new InsuranceClaim("ID2", ClaimType.HEALTH, 85000));
        insurances.add(new InsuranceClaim("ID3", ClaimType.LIFE, 12500));
        insurances.add(new InsuranceClaim("ID4", ClaimType.MOTOR, 45000));
        insurances.add(new InsuranceClaim("ID5", ClaimType.DEATH, 97500));
        insurances.add(new InsuranceClaim("ID6", ClaimType.HOME, 125000));
        insurances.add(new InsuranceClaim("ID7", ClaimType.HEALTH, 48050));
        insurances.add(new InsuranceClaim("ID8", ClaimType.MOTOR, 36945));
        insurances.add(new InsuranceClaim("ID9", ClaimType.LIFE, 78369));
        insurances.add(new InsuranceClaim("ID10", ClaimType.HEALTH, 75800));
        insurances.add(new InsuranceClaim("ID11", ClaimType.HOME, 190000));
        insurances.add(new InsuranceClaim("ID12", ClaimType.DEATH, 157000));
        insurances.add(new InsuranceClaim("ID13", ClaimType.DEATH, 94000));

        InsuranceAnalyzer.analyzeInsurances(insurances);

        
    }
}

enum ClaimType{
    HEALTH, LIFE, MOTOR, HOME, DEATH;
}

class InsuranceClaim{
    protected String id;
    protected ClaimType claimType;
    protected double amount;

    public InsuranceClaim(String id, ClaimType claimType, double amount) {
        this.id = id;
        this.claimType = claimType;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("[Insurance ID: %s, Claim type: %s, Amount: %.2f INR]", id, claimType.toString(), amount);
    }

}

class InsuranceAnalyzer{
    public static void analyzeInsurances(List<InsuranceClaim> insurances){
        Map<ClaimType, Double> averageClaimAmountByClaimType = insurances.stream()
                                                                    .collect(Collectors.groupingBy(
                                                                        insuranceClaim -> insuranceClaim.claimType,
                                                                        Collectors.averagingDouble(insuranceClaim -> insuranceClaim.amount)
                                                                    ));

        for(Map.Entry<ClaimType, Double> entry: averageClaimAmountByClaimType.entrySet()){
            System.out.printf("[Claim Type: %s, Average claim amount: %.2f INR]%n",entry.getKey(), entry.getValue());
        }
    }
}