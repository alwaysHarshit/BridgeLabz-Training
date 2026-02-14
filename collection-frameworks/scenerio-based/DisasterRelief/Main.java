package DisasterRelief;

public class Main {
    public static void main(String[] args) {

        DisasterReliefSystem disasterReliefSystem = new DisasterReliefSystem();

        // ===== Create 5 Relief Centres =====
        ReliefCentre r1 = new ReliefCentre("R1");
        r1.addResource("Food", 100);
        r1.addResource("Water", 200);
        r1.addResource("MedicalKit", 50);

        ReliefCentre r2 = new ReliefCentre("R2");
        r2.addResource("Food", 50);
        r2.addResource("Water", 50);
        r2.addResource("MedicalKit", 10);

        ReliefCentre r3 = new ReliefCentre("R3");
        r3.addResource("Food", 500);
        r3.addResource("Water", 300);
        r3.addResource("MedicalKit", 100);

        ReliefCentre r4 = new ReliefCentre("R4");
        r4.addResource("Food", 20);
        r4.addResource("Water", 20);
        r4.addResource("MedicalKit", 5);

        ReliefCentre r5 = new ReliefCentre("R5");
        r5.addResource("Food", 1000);
        r5.addResource("Water", 1000);
        r5.addResource("MedicalKit", 500);

        // Add centres to system
        disasterReliefSystem.addReliefCenter(r1);
        disasterReliefSystem.addReliefCenter(r2);
        disasterReliefSystem.addReliefCenter(r3);
        disasterReliefSystem.addReliefCenter(r4);
        disasterReliefSystem.addReliefCenter(r5);

        // ===== Create 5 Areas =====
        Areas a1 = new Areas("Area1");
        a1.addItemsRequeied("Food", 50);
        a1.addItemsRequeied("Water", 100);

        Areas a2 = new Areas("Area2");
        a2.addItemsRequeied("Food", -10);        // ❌ wrong quantity (invalid)
        a2.addItemsRequeied("MedicalKit", 10);

        Areas a3 = new Areas("Area3");
        a3.addItemsRequeied("Water", 10000);     // ❌ too much
        a3.addItemsRequeied("Food", 20);

        Areas a4 = new Areas("Area4");
        a4.addItemsRequeied("MedicalKit", 2000); // ❌ too much

        Areas a5 = new Areas("Area5");
        a5.addItemsRequeied("Food", 10);
        a5.addItemsRequeied("Water", 20);
        a5.addItemsRequeied("MedicalKit", 5);

        // Add areas to system queue
        disasterReliefSystem.addAreas(a1);
        disasterReliefSystem.addAreas(a2);
        disasterReliefSystem.addAreas(a3);
        disasterReliefSystem.addAreas(a4);
        disasterReliefSystem.addAreas(a5);

        // ===== Process requests =====
        disasterReliefSystem.processRequestQueue();

        //printing the repot
        disasterReliefSystem.printReports();
    }
}
