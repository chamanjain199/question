package geeksForGeeks.math;

import geeksForGeeks.linkedList.DeleteWithoutHeadPointer;

class Tuple {
    int number;
    int step;

    public Tuple(int number, int step) {
        this.number = number;
        this.step = step;
    }
}

public class ReachANumber  extends DeleteWithoutHeadPointer  {


    public static int reachNumber(int target) {
        if (target < 0) {
            target = -target;
        }
        int step = 0;
        int sum = 0;
        while (true) {
            step++;
            sum = sum + step;
            if (sum == target) {
                return step;
            } else if (sum > target && (sum - target) % 2 == 0) {
                return step;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(reachNumber(2));
        DeleteWithoutHeadPointer obj=new DeleteWithoutHeadPointer();
    }
}
