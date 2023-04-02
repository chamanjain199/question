package geeksForGeeks.bitmanipulation;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public static List<Integer> grayCode(int n) {

        if (n == 1) {
            return List.of(0, 1);
        }
        List<Integer> rs = grayCode(n - 1);
        List<Integer> rse = new ArrayList<>(rs);
        for (int i = rs.size() - 1; i >= 0; i--) {
            rse.add(rs.get(i) | (1 << n - 1));
        }
        return rse;
    }

    public static ArrayList<String> graycode(int n) {

        if (n == 1) {
            ArrayList<String> as=new ArrayList();
            as.add("0");
            as.add("1");
            return as;
        }
        ArrayList<String> rs = graycode(n - 1);
        ArrayList<String> rse = new ArrayList<>();
        for (int i = 0; i < rs.size(); i++) {
            rse.add("0" + rs.get(i));
        }
        for (int i = rs.size() - 1; i >= 0; i--) {
            rse.add("1" + rs.get(i));
        }
        return rse;

    }


    public static void main(String[] args) {
        System.out.println(grayCode(4));

    }
}
