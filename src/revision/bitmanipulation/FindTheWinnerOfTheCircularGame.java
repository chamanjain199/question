package revision.bitmanipulation;

import java.util.logging.SocketHandler;

public class FindTheWinnerOfTheCircularGame {
    public static int findTheWinner(int n, int k) {
        return 1+winner(n,k);
    }
    public static int winner(int n,int k){
        if(n==1){
            return 0;
        }
        return (k+winner(n-1,k))%n;
    }

    public static int findTheWinner2(int n, int k) {
        int variable=0;
        for (int i = 2; i <=n; i++) {
            variable=(k+variable)%i;
        }
        return variable+1;
    }
    public static void main(String[] args) {
        System.out.println(findTheWinner2(5,2));

    }
}
