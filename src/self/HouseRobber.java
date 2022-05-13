package self;

public class HouseRobber {
    public int rob(int[] nums) {

        int inclution = nums[0];
        int exclution = 0;

        for (int i = 1; i < nums.length; i++) {
            int max=Math.max(inclution,exclution);
            inclution=exclution+nums[i];
            exclution=max;

        }
        return Math.max(inclution,exclution);

    }

    public static void main(String[] args) {
        HouseRobber houseRobber = new HouseRobber();
        System.out.println(houseRobber.rob(new int[]{2, 7, 9, 3, 1}));

    }
}
