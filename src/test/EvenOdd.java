package test;

import java.util.*;

public class EvenOdd {
    public static void isEvenUsingAND(int number) {

        if ((number & 1) == 1) {
            System.out.println("Number " + number + " is odd ");
        } else {
            System.out.println("Number " + number + " is even ");
        }
    }

    public static void isEven1(int number) {
        if (number % 2 == 0) {
            System.out.println("Number " + number + " is even ");
        } else {
            System.out.println("Number " + number + " is odd ");
        }
    }

    public static String numeric_cardinality(int number) {
        if ((number % 10) == 0) {
            return "zero";
        } else if ((number % 5) == 0) {
            return "five";
        } else if (number % 2 == 0) {
            return "even";
        } else {
            return "odd";
        }
    }

    public static String avgMark(String[] studentArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String studentMark : studentArray) {
            String[] arr = studentMark.split("[ ,--,.:!~@#&*()+?<>]");
            String name = arr[0] + " " + arr[1];
            int sum = 0;
            int subject = 0;
            for (int i = 2; i < arr.length; i++) {
                int number = Integer.valueOf(arr[i]);
                if (number > 10) {
                    continue;
                }
                sum += number;
                subject++;
            }
            int avg = sum / subject;
            stringBuilder.append(name).append("-").append(avg).append(";");
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        Map<Student, Integer> map = new IdentityHashMap<>();
        map.put(new Student("Aman",28),1);
        map.put(new Student("Aman",28),1);
        System.out.println(map.toString());
        Properties p=System.getProperties();
        System.out.println(p);
        int[] arr=new int[0];
        Arrays.sort(arr);
        System.out.println(numeric_cardinality(27));
        System.out.println(avgMark(new String[]{"chaman jain 5 10-5", "aman&sen*5 12-5"}));
    }
}
class Student{
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}