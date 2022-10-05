package geeksForGeeks.arrays;

import java.util.Arrays;
import java.util.Comparator;

class Item {
    int value, weight;

    Item(int x, int y) {
        this.value = x;
        this.weight = y;
    }
}

public class FractionalKnapsack {
    static double fractionalKnapsack(int W, Item arr[], int n) {
        Arrays.sort(arr, Comparator.comparingDouble(item -> ((double) item.value / item.weight)));
        int index = n - 1;
        double totalItem = 0;
        while (index >= 0 && W - arr[index].weight >= 0) {
            W -= arr[index].weight;
            totalItem += arr[index].value;
            index--;
        }
        if (index >= 0 && W > 0) {
            Item item = arr[index];
            double unitVolumn = ((double) item.value / item.weight);
            totalItem += W * unitVolumn;
        }
        return totalItem;
    }

    public static void main(String[] args) {
        Item items[] = new Item[]{new Item(60, 10), new Item(100, 20),new Item(120, 30)};
        System.out.println(fractionalKnapsack(50, items, items.length));

    }
}
