package revision.string;

public class CountAndSay {
    public String countAndSay(int n) {
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
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(4)+"  hh ");
    }
}
