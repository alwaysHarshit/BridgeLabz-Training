package restaurant.table.reservation.system;

import java.time.LocalDateTime;

public class Reservation {
    private int tableNumber;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String customerName;

    public Reservation(int tableNumber, LocalDateTime startTime, LocalDateTime endTime, String customerName) {
        this.tableNumber = tableNumber;
        this.startTime = startTime;
        this.endTime = endTime;
        this.customerName = customerName;
    }

    public void getDetatils(){
        System.out.printf("Table Number: %d\nCustomer Name: %s\n Start Time: %s\n End Time: %s \n",tableNumber,customerName,startTime,endTime);
    }

}
