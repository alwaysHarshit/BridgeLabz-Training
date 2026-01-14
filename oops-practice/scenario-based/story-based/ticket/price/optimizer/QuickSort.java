package ticket.price.optimizer;

import java.util.ArrayList;

public class QuickSort {

    public void sort(ArrayList<Ticket> list, int low, int high){
        if (low < high) {
            int pi = partition(list, low, high);
            sort(list, low, pi - 1);
            sort(list, pi + 1, high);
        }
    }

    private static int partition(ArrayList<Ticket> list, int low, int high) {
        double pivot = list.get(high).getPrice();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (list.get(j).getPrice() < pivot) {
                i++;
                swap(list, i, j);
            }
        }

        swap(list, i + 1, high);
        return i + 1;
    }

    private static void swap(ArrayList<Ticket> list, int i, int j) {
        Ticket temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
