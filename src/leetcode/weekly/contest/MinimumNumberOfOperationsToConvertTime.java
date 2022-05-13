package leetcode.weekly.contest;

public class MinimumNumberOfOperationsToConvertTime {

    public static int convertTime(String current, String correct) {
        if(current.equals(correct)){
            return 0;
        }
        String[] currentTime = current.split(":");
        String[] correctTime = correct.split(":");
        int totalMin = 0;
        int minOps=0;
        int currentMinSince0=60* Integer.parseInt(currentTime[0])+Integer.parseInt(currentTime[1]);
        int correctMinSince0=60* Integer.parseInt(correctTime[0])+Integer.parseInt(correctTime[1]);
        totalMin=correctMinSince0-currentMinSince0;


        while (totalMin != 0) {
            if (totalMin >= 60) {
                minOps++;
                totalMin -= 60;
            } else if (totalMin >= 15) {
                minOps++;
                totalMin -= 15;
            } else if (totalMin >= 5) {
                minOps++;
                totalMin -= 5;
            } else if (totalMin >= 1) {
                minOps++;
                totalMin -= 1;
            }
        }
        return minOps;

    }
    public static int convertTime1(String current, String correct) {
        if(current.equals(correct)){
            return 0;
        }
        String[] currentTime = current.split(":");
        String[] correctTime = correct.split(":");
        int totalMin = 0;
        int minOps=0;
        int currentMinSince0=60* Integer.parseInt(currentTime[0])+Integer.parseInt(currentTime[1]);
        int correctMinSince0=60* Integer.parseInt(correctTime[0])+Integer.parseInt(correctTime[1]);
        totalMin=correctMinSince0-currentMinSince0;

        minOps=totalMin/60;
        totalMin%=60;

        minOps+=totalMin/15;
        totalMin%=15;

        minOps+=totalMin/5;
        totalMin%=5;

        minOps+=totalMin;

        return minOps;
    }
    public static void main(String[] args) {
        System.out.println(convertTime("00:00", "23:59"));
    }
}