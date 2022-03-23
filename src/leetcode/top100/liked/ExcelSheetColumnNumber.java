package leetcode.top100.liked;

public class ExcelSheetColumnNumber {

    public static int titleToNumber(String columnTitle) {
        int sum=0;
        for (int i = 0; i < columnTitle.length(); i++) {
              sum=sum*26+(columnTitle.charAt(i)-64);
        }
        return sum;

    }
    public static void main(String[] args) {

        System.out.println(titleToNumber("ZY"));

    }
}
