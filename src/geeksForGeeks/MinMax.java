package geeksForGeeks;

import javax.xml.transform.stream.StreamSource;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MinMax {
    public static void main(String[] args) {
        List<Integer> elements1= Arrays.stream(new int[]{4,5,7}).boxed().sorted((num1,num2)->num2.compareTo(num1)).distinct().collect(Collectors.toList());
        System.out.println(elements1);

    }
}
