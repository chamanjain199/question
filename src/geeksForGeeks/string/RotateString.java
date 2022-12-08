package geeksForGeeks.string;

public class RotateString {
    public static boolean rotateString(String s, String goal) {
        String newString = s + s;
       return newString.contains(goal);
    }

    public static void main(String[] args) {
        System.out.println(rotateString("aaaa","aaa"));

    }
}
