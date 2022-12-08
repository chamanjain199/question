package geeksForGeeks.string;

public class CountAndSay {


    public static String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        char ch;
        for (int i = 2; i <= n; i++) {
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < sb.length(); j++) {
                ch = sb.charAt(j);
                int count = 1;
                while (j < sb.length() - 1 && sb.charAt(j + 1) == ch) {
                    j++;
                    count++;
                }
                temp.append(count).append(ch);
            }
            sb = temp;
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(countAndSay(6));
    }
}
