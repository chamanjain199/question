package geeksForGeeks.string;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {


    public static String intToRoman(int num) {
        StringBuilder romanNumber = new StringBuilder();
        if (num >= 1000) {
            romanNumber.append("M".repeat(num / 1000));
            num = num % 1000;
        }
        if (num >= 900) {
            romanNumber.append("CM");
            num = num % 900;
        }
        if (num >= 500) {
            romanNumber.append("D");
            num = num % 500;
        }
        if (num >= 400) {
            romanNumber.append("CD");
            num = num % 400;
        }
        if (num >= 100) {
            romanNumber.append("C".repeat(num / 100));

            num = num % 100;
        }
        if (num >= 90) {
            romanNumber.append("XC");
            num = num % 90;
        }
        if (num >= 50) {
            romanNumber.append("L");
            num = num % 50;
        }
        if (num >= 40) {
            romanNumber.append("XL");
            num = num % 40;
        }
        if (num >= 10) {
            romanNumber.append("X".repeat(num / 10));
            num = num % 10;
        }
        if (num == 9) {
            romanNumber.append("IX");
            num = 0;
        }
        if (num >= 5) {
            romanNumber.append("V");
            num = num % 5;
        }
        if (num == 4) {
            romanNumber.append("IV");
            num = 0;
        }
        if (num >= 1) {
            romanNumber.append("I".repeat(num));
        }
        return romanNumber.toString();

    }


    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }
}
