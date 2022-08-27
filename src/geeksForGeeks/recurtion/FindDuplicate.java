package geeksForGeeks.recurtion;

public class FindDuplicate {
    public  static int store(int[] nums,int cur){
        if(cur==nums[cur]){
            return cur;
        }
        int nxt=nums[cur];
        nums[cur]=cur;
        return store(nums,nxt);
    }
    public static int findDuplicate(int[] nums) {

        return store(nums,0);

    }
    public static void main(String[] args) {

    }
}
