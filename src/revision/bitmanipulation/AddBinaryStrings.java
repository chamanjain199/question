package revision.bitmanipulation;

public class AddBinaryStrings {

    static String addBinary(String A, String B) {
        int len1 = A.length() - 1;
        int len2 = B.length() - 1;

        StringBuilder ans = new StringBuilder();
        int carry = 0;
        char a;
        char b;
        while (len1 >= 0 && len2 >= 0) {
            a = A.charAt(len1);
            b = B.charAt(len2);
            if (a == '1' && b == '1') {
                if (carry == 0) {
                    ans.append("0");
                    carry = 1;
                } else {
                    ans.append("1");
                }
            } else if (a == '1' || b == '1') {
                if (carry == 0) {
                    ans.append("1");
                } else {
                    ans.append('0');
                }
            } else {
                if (carry == 0) {
                    ans.append("0");
                } else {
                    ans.append('1');
                    carry = 0;
                }
            }
            len1--;
            len2--;
        }
        while (len1 >= 0) {
            a = A.charAt(len1);
            if (a == '1' && carry == 1) {
                ans.append("0");
            } else if (a == '1' || carry == 1) {
                ans.append("1");
                carry = 0;
            } else {
                ans.append(a);
            }
            len1--;
        }
        while (len2 >= 0) {
            b = B.charAt(len2);
            if (b == '1' && carry == 1) {
                ans.append("0");
            } else if (b == '1' || carry == 1) {
                ans.append("1");
                carry = 0;
            } else {
                ans.append(b);
            }
            len2--;
        }
        if (carry == 1) {
            ans.append("1");
        }
        ans= ans.reverse();
        while (ans.charAt(0) == '0') {
            ans.deleteCharAt(0);
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("00101", "0"));
    }
}
