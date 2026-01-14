package ticket.price.optimizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Event {
    public static void main(String[] args) {
        ArrayList<Ticket> list=new ArrayList<>();
        Random random = new Random();

        //creating 100 random tickets
        for(int i = 0; i < 100; i++) {
            String name = "Ticket_" + (i + 1);
            double price = 10.0 + (random.nextDouble() * 590.0); // Random price between 10.0 and 500.0
            Ticket ticket = new Ticket(name, price);
            list.add(ticket);
        }
        //priting all tickets before sorting
//        for (Ticket ticket : list) {
//            ticket.print();
//            System.out.println("-------------------");
//        }



        // sorting all tickets
        QuickSort quickSort=new QuickSort();
        quickSort.sort(list, 0, list.size()-1);


        //priting all tickets after sorting
//        for (Ticket ticket : list) {
//            ticket.print();
//            System.out.println("-------------------");
//        }
        //priting only top 50
        for (int i = list.size() - 1; i >=50; i--) {
            Ticket ticket = list.get(i);
            System.out.println("Ticket: "+(list.size()-i));
            ticket.print();
            System.out.println("-------------------");
        }

    }
}
