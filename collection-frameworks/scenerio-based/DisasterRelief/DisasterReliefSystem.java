package DisasterRelief;

import java.util.*;

public class DisasterReliefSystem {
    private Map<String, ReliefCentre> reliefCentres;
    private Queue<Areas> requestQueue;
    private List<AllocationReport> reportList;

    public DisasterReliefSystem() {
        reliefCentres = new HashMap<>();
        requestQueue = new LinkedList<>();
        reportList = new ArrayList<>();
    }

    // add the reliefCenter
    public void addReliefCenter(ReliefCentre reliefCentre) {
        reliefCentres.put(reliefCentre.getCenterName(), reliefCentre);
        System.out.printf("Relief centre name: %s added...\n", reliefCentre.getCenterName());
    }

    //add affected areas
    public void addAreas(Areas areas) {
        requestQueue.offer(areas);
    }

    void processRequestQueue() {

        while (!requestQueue.isEmpty()) {
            Areas area = requestQueue.poll();
            ReliefCentre centre = reliefCentres.values().iterator().next();


            area.getItemsRequied().entrySet().stream().forEach(entry -> {
                try {
                    //allocatating resouces
                    String msg = centre.allocateResouce(entry.getKey(), entry.getValue());

                    reportList.add(new AllocationReport(area.getAreaName(), centre.getCenterName(), area.getItemsRequied(), msg));


                } catch (InsufficientResourceException e) {
                    reportList.add(new AllocationReport(area.getAreaName(), centre.getCenterName(), area.getItemsRequied(), e.getMessage()));

                }

            });

        }
    }

    public void printReports() {
        if (reportList.isEmpty()) {
            System.out.println("No reports to display.");
            return;
        }

        for (AllocationReport report : reportList) {
            report.printReport();
        }
    }
}
