package revision.bitmanipulation;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

    public static List<Integer> grayCode(int n) {
        if (n == 1) {
            List<Integer> rs = new ArrayList<>();
            rs.add(0);
            rs.add(1);
            return rs;
        }
        List<Integer> rs = grayCode(n - 1);
        List<Integer> rs1 = new ArrayList<>(rs);
        for (int i = rs.size() - 1; i >= 0; i--) {
            rs1.add(rs.get(i) | (1 << (n - 1)));
        }
        return rs1;
    }
}
