package revision.string;

public class RomanToDecimal {
    public int romanToInt(String s) {
        int len=s.length();
        int number=0;
        for (int i = 0; i <len-1 ; i++) {
            int cur=integerVal(s.charAt(i));
            int next=integerVal(s.charAt(i+1));
            number=next>cur?number-cur:number+cur;
        }
        number+=integerVal(s.charAt(len-1));
        return number;

    }

    private static int integerVal(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }
}
