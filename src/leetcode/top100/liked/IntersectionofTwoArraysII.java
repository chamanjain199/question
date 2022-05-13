package leetcode.top100.liked;

import java.util.ArrayList;
import java.util.List;

public class IntersectionofTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        int tempMap[] = new int[1000];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            tempMap[nums1[i]]++;
        }
        for (int i = 0; i < nums2.length; i++) {
            if (tempMap[nums2[i]] != 0) {
                list.add(nums2[i]);
                tempMap[nums2[i]]--;
            }
        }
        int resutMap[] = new int[list.size()];


        for (int i = 0; i < nums1.length; i++) {
            resutMap[i] = list.get(i);
        }

        return resutMap;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
