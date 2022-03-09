package leetcode.top100.liked;

public class RomanToInteger {

    public static int romanToInt(String s) {

        char ch[] = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < ch.length; i++) {
            int ch1 = integerVal(ch[i]);
            int ch2 = 0;
            if (i < ch.length - 1)
                ch2 = integerVal(ch[i + 1]);
            if (i < ch.length - 1 && ch1 < ch2) {
                sum += ch2 - ch1;
                i++;
            } else {
                sum += ch1;

            }

        }
        return sum;
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
    public static int romanToInt1(String s) {
        int res=0;
        for(int i=s.length()-1;i>=0;i--){
            switch(s.charAt(i)){
                case 'M':
                    res+=1000;
                    break;
                case 'D':
                    res+=500;
                    break;
                case 'C':
                    res+=100*(res>=500?-1:1);
                    break;
                case 'L':
                    res+=50;
                    break;
                case 'X':
                    res+=10*(res>=50?-1:1);
                    break;
                case 'V':
                    res+=5;
                    break;
                case 'I':
                    res+=(res>=5?-1:1);
                    break;
                default:
                    break;
            }
        }
        return res;

    }

    public static void main(String[] args) {

        System.out.println(romanToInt1("IXII"));
    }
}
