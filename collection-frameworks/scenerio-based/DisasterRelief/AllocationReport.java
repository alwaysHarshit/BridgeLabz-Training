package DisasterRelief;

import java.time.LocalDate;
import java.util.Map;


public class AllocationReport {
    private String areaName;
    private String centreName;
    private Map<String,Integer> itemsrequied;
    private String msg;
    private LocalDate date;

    public AllocationReport(String areaName, String centerName, Map<String, Integer> map, String msg) {
        this.areaName = areaName;
        this.centreName = centerName;
        this.itemsrequied=map;
        this.msg = msg;
        this.date = LocalDate.now();
    }

    public void printReport() {
        System.out.println("==================================");
        System.out.println("        Allocation Report         ");
        System.out.println("==================================");
        System.out.println("Date       : " + date);
        System.out.println("Area       : " + areaName);
        System.out.println("Center     : " + centreName);
        System.out.println("----------------------------------");
        System.out.println("Items Required:");

        if (itemsrequied == null || itemsrequied.isEmpty()) {
            System.out.println("  None");
        } else {
            for (Map.Entry<String, Integer> entry : itemsrequied.entrySet()) {
                System.out.println("  - " + entry.getKey() + " : " + entry.getValue());
            }
        }

        System.out.println("----------------------------------");
        System.out.println("Status     : " + msg);
        System.out.println("==================================");
    }

}
