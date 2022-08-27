package geeksForGeeks.recurtion;

public class TowerOfHanoi {
    static long ans=0;
    public static long toh(int N, int from, int to, int aux) {
        System.out.println("N "+N+" From "+from+"  to "+to+" aux "+aux);
        if (N == 1) {
            //System.out.println("move disk " + N + " from rod " + from + " to rod " + to);
            return 1;
        }

        ans+=toh(N-1,from,aux,to);
        //System.out.println("move disk " + N + " from rod " + from + " to rod " + to);
        ans+=toh(N-1,aux,from,to);

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(toh(5,1,3,2));

    }
}
