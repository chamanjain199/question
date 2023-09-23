package self;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StackMin min=new StackMin(10);
        min.push(6);
        min.push(7);
        min.push(4);
        min.push(9);
        min.push(10);
        System.out.println(Arrays.toString(min.minimuns));
        System.out.println(min.min());

        String when="today + 2 and + 3 day + man";
        int index=when.indexOf('+',when.indexOf('+')+1);
        when=when.substring(0,index);
        System.out.println(when);

    }
}
