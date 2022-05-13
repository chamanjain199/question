package leetcode.daily.challenge;

import java.util.ArrayList;
import java.util.List;

public class BackspaceStringCompare {

    public static boolean backspaceCompare(String s, String t) {

        int index1 = s.length() - 1;
        int index2 = t.length() - 1;
        int shascount = 0;
        int phashCount = 0;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        while (index1 > -1) {
            char sChar = s.charAt(index1);
            boolean con = false;
            if (sChar == '#') {
                shascount++;
                index1--;
                con = true;
            } else {
                if (shascount > 0) {
                    shascount--;
                    index1--;
                    con = true;
                }
            }
            if (con) {
                continue;
            }
            index1--;
            sb1.append(sChar);
        }

        while (index2 > -1) {
            char tChar = t.charAt(index2);
            boolean con = false;
            if (tChar == '#') {
                phashCount++;
                index2--;
                con = true;
            } else {
                if (phashCount > 0) {
                    phashCount--;
                    index2--;
                    con = true;
                }
            }
            if (con) {
                continue;
            }
            index2--;
            sb2.append(tChar);
        }
        return sb1.toString().equals(sb2.toString());
    }
    public static boolean backspaceCompare2(String s, String t) {

        int index1 = s.length() - 1;
        int index2 = t.length() - 1;
        int shascount = 0;
        int phashCount = 0;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        while (index1 > -1) {
            char sChar = s.charAt(index1);
            boolean con = false;
            if (sChar == '#') {
                shascount++;
                index1--;
                con = true;
            } else {
                if (shascount > 0) {
                    shascount--;
                    index1--;
                    con = true;
                }
            }
            if (con) {
                continue;
            }
            index1--;
            sb1.append(sChar);
        }

        while (index2 > -1) {
            char tChar = t.charAt(index2);
            boolean con = false;
            if (tChar == '#') {
                phashCount++;
                index2--;
                con = true;
            } else {
                if (phashCount > 0) {
                    phashCount--;
                    index2--;
                    con = true;
                }
            }
            if (con) {
                continue;
            }
            index2--;
            sb2.append(tChar);
        }
        return sb1.toString().equals(sb2.toString());
    }
//    public static boolean backspaceCompare3(String s, String t) {
//        int index1 = s.length() - 1;
//        int index2 = t.length() - 1;
//        int shascount = 0;
//        int phashCount = 0;
//
//
//
//    }

    public static void main(String[] args) {



        System.out.println(backspaceCompare("y#fo##f", "y#fx#o##f"));
    }
}
