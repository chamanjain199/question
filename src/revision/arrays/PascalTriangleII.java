package revision.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> prevRow = new ArrayList<>();
        prevRow.add(1);
        List<Integer> currRow = new ArrayList<>();
        if (rowIndex == 0) {
            return prevRow;
        }
        for (int i = 0; i <= rowIndex; i++) {
            currRow.add(1);
            for (int j = 1; j < i; j++) {
                currRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            currRow.add(1);
            prevRow = currRow;
            currRow = new ArrayList<>();
        }
        return prevRow;
    }

    public List<Integer> getRow2(int rowIndex) {
        List<Integer> currRow = new ArrayList<>();
        currRow.add(1);
        if (rowIndex == 0) {
            return currRow;
        }
        long temp = 1;
        for (int i = 0; i < rowIndex; i++) {
            temp = temp * (rowIndex - i) / (i + 1);  //previous element * (start with row, and  slowly decrease by 1 ) / ( start from 1, and slowly increase  by 1 )
            currRow.add((int) temp);
        }

        return currRow;
    }

}
