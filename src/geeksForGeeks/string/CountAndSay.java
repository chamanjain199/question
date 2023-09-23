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
    public String countAndSay2(int n) {
        return countAndSayHelp("1", 0, n-1);
    }

    public String countAndSayHelp(String n, int index, int last) {

        if (index == last) {
            return n;
        }

        StringBuilder sb = new StringBuilder();
        int count = 1;
        char prev = n.charAt(0);
        for (int i = 1; i < n.length(); i++) {
            char cur = n.charAt(i);
            if (prev == cur) {
                count++;
            } else {
                sb.append(count).append(prev);
                prev = cur;
                count = 1;
            }
        }
        sb.append(count).append(prev);
        return countAndSayHelp(sb.toString(),index+1,last);
    }
    public static void main(String[] args) {
        System.out.println(countAndSay(6));
    }
}
