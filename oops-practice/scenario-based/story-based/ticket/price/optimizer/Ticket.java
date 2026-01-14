package ticket.price.optimizer;

import java.time.LocalDate;
import java.util.Random;

 class Ticket {
    private String name;
    private  int ticketId;
    private LocalDate date;
    private double price;

    public Ticket(String name, double price) {
        this.name = name;
        ticketId=new Random().nextInt(1,1000);
        date = LocalDate.now();
        this.price = price;
    }

    public int getTicketId() {
        return ticketId;
    }

     public double getPrice() {
         return price;
     }
     public void print(){
         System.out.println("Name: "+name);
         System.out.println("ticketId: "+ticketId);
         System.out.println("date: "+date);
         System.out.println("price: "+price);
     }
 }
