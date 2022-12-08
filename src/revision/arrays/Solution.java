package revision.arrays;

import java.awt.*;

public class Solution {
    public static void solution(int[] inArray) {
        int count = 1;
        int len = inArray.length;
        int prev = inArray[0];
        for (int i = 1; i < len; i++) {
            if (prev == inArray[i]) {
                count++;
            } else {
                System.out.println(prev + " " + count);
                count = 1;
                prev = inArray[i];
            }
        }
        if (len > 1 && inArray[len - 1] == inArray[len - 2]) {
            System.out.println(inArray[len - 1] + " " + count);
        } else {
            System.out.println(inArray[len - 1] + " " + 1);
        }

    }

    public static void main(String[] args) {
        solution(new int[]{1, 1, 2, 2, 3, 3,5,6,8,8});
        System.out.println();
    }
}
