package geeksForGeeks.string;

public class RomanToDecimal {
    public static int romanToDecimal(String str) {

        char[] chars = str.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            int currentValue = integerVal(chars[i]);
            int nextChar = integerVal(chars[i + 1]);
            count = currentValue < nextChar ? count - currentValue : count + currentValue;
        }
        count += integerVal(chars[chars.length - 1]);
        return count;

    }

    private static int integerVal(char c) {
        int val = switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
        return val;
    }

    public static void main(String[] args) {
        System.out.println(romanToDecimal("XLIX"));
    }
}
