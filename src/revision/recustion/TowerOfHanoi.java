package revision.recustion;

public class TowerOfHanoi {

    public static long toh(int N, int from, int to, int aux) {
        if (N == 1) {
            System.out.println("move disk " + N + " rod " + from + " to rod " + to);
            return 1;
        }
       long count= toh(N - 1, from, aux, to);
        System.out.println("move disk " + N + " rod " + from + " to rod " + to);
        count++;
        count+= toh(N - 1, aux, to, from);
        return count;
    }

    public static void main(String[] args) {
        toh(2, 1, 2, 3);
    }
}
