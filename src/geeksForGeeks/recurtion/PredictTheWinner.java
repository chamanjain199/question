package geeksForGeeks.recurtion;

public class PredictTheWinner {

    public static boolean PredictTheWinner(int[] nums) {
        long playerOneScore = 0L;
        long playerTwoScore = 0L;
        int start = 0;
        int end = nums.length - 1;
        boolean isFirstPlayerTurn=true;
        while (start < end) {





        }
        return false;
    }

    private void maxOfPlayerOne(int[] nums, int turn, int start, int end) {


        if (start == end) {
            return;
        }
        if (turn == 1) {

            //int a=nums[start]+maxOfPlayerOne(nums,turn*-1,start+1,end);


        } else {

        }
    }

    public static void main(String[] args) {
        System.out.println(PredictTheWinner(new int[]{
                3606449, 6, 5, 9, 452429, 7, 9580316, 9857582, 8514433, 9, 6, 6614512, 753594, 5474165, 4, 2697293, 8, 7, 1}));
    }


}
