package leetcode.top100.liked;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public static List<String> fizzBuzz(int n) {
        List<String> result=new ArrayList<>(n);
        for (int i = 0; i <n ; i++) {
            if(i%15==0){
                result.add("FizzBuzz");
            }else if(i%3==0){
                result.add("Fizz");
            }
            else if(i%5==0){
                result.add("Buzz");
            }else{
                result.add(""+i);
            }

        }
        return result;
    }
    public static void main(String[] args) {

    }
}
