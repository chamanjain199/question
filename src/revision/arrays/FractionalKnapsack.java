package revision.arrays;

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

    double fractionalKnapsack(int W, Item arr[], int n) {
        Arrays.sort(arr, Comparator.comparingDouble((x) -> (double) x.value / x.weight));
        int index = n - 1;
        double value = 0d;
        while (index >= 0 && W - arr[index].weight > 0) {
            value += arr[index].value;
            W -= arr[index].weight;
            index--;
        }
        if (index >= 0 && W > 0) {

            Item item = arr[index];
            double unitValue = (double) item.value / item.weight;
            value += W * unitValue;
        }
        return value;

    }

    public static void main(String[] args) {

    }
}
