package geeksForGeeks.recurtion;

public class GeneratingAllSubSets {
    public static void printAllSubSequence1(String s, String curr, int index) {
        if (index == s.length()) {
            System.out.println(curr);
            return;
        }
        printAllSubSequence1(s, curr, index + 1);
        printAllSubSequence1(s, curr + s.charAt(index), index + 1);
    }

    public static void printAllSubSequence2(String s, String curr) {
        if (s.length() == 0) {
            System.out.println(curr);
            return;
        }
        char firstChar = s.charAt(0);
        String ros = s.substring(1);
        printAllSubSequence2(ros, curr);
        printAllSubSequence2(ros, curr + firstChar);
    }

    public static void main(String[] args) {

        printAllSubSequence1("ABC", "", 0);
        System.out.println("=======================================");
        printAllSubSequence2("ABC", "");

    }
}
