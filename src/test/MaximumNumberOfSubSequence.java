package test;

public class MaximumNumberOfSubSequence {
    public static long maximumSubsequenceCount(String text, String pattern) {
        int countOfp1 = 0;
        int countOfp2 = 0;
        int total=0;

        char p1 = pattern.charAt(0);
        char p2 = pattern.charAt(1);
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == p1 ) {

                countOfp1++;
            }
            if (text.charAt(i) == p2 ) {
                countOfp2++;
                total+=countOfp1*countOfp2;
            }
        }
        if(countOfp1>countOfp2){
            countOfp2++;
        }else {
            countOfp1++;
        }
        return countOfp1*countOfp2;

    }

    public static void main(String[] args) {

        System.out.println( maximumSubsequenceCount("iekbksdsmmuuzwxbpmcngsfkjvpzuknqguzvzik","mp"));


    }
}
