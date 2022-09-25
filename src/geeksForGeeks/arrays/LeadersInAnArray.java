package geeksForGeeks.arrays;

import java.util.ArrayList;

public class LeadersInAnArray {
    static ArrayList<Integer> leaders(int arr[], int n) {
        ArrayList<Integer> ans=new ArrayList<>();
        ArrayList<Integer> ansInOrder=new ArrayList<>();
        ans.add(arr[n-1]);
        int lastLeader=n-1;
        for (int i = n-2; i >=0 ; i--) {
            if(arr[i]>=arr[lastLeader]){
                lastLeader=i;
                ans.add(arr[i]);
            }
        }

        for (int i =ans.size()-1; i >=0; i--) {
            ansInOrder.add(ans.get(i));
        }
        return ansInOrder;
    }

    public static void main(String[] args) {

    }
}
