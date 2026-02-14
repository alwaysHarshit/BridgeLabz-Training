package DisasterRelief;

import java.util.HashMap;
import java.util.Map;

public class Areas {
    private  String areaName;
    private Map<String,Integer> itemsrequied;


    public Areas(String areaName) {
        this.areaName = areaName;
        this.itemsrequied = new HashMap<>();
    }
    public String getAreaName() {
        return areaName;
    }

    //add itms need in map
    public void  addItemsRequeied(String itemName, int quantity){
        itemsrequied.put(itemName,quantity);
    }

    public Map<String,Integer> getItemsRequied(){
        return itemsrequied;
    }

}
