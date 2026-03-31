package DisasterRelief;

import java.util.HashMap;
import java.util.Map;

public class ReliefCentre {

    private final String centerName;
    Map<String,Integer> resouces;

    public ReliefCentre(String centerName) {
        this.centerName=centerName;
        resouces=new HashMap<>();
    }

    //methods
     public void  addResource(String itemName, int quantity){
        resouces.put(itemName,quantity);
     }

     public  String allocateResouce(String itemName, int quantityRequierd) throws InsufficientResourceException {
        Integer currentQuantity=resouces.get(itemName);

         if (currentQuantity == null || currentQuantity < quantityRequierd) {
              throw new InsufficientResourceException(
                     "Not enough " + itemName + ". Available: " + (currentQuantity == null ? 0 : currentQuantity)
                             + ", Requested: " + quantityRequierd
             );
         }
        //else allocate the resouce
        resouces.compute(itemName, (k, v) -> v - quantityRequierd);
         return "Successfully allocated";
     }

    public String getCenterName() {
        return this.centerName;
    }
}
