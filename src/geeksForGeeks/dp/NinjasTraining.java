package geeksForGeeks.dp;

public class NinjasTraining {
    static int pointsArr[][];
    static int dp[][];

    public static int ninjaTraining(int n, int points[][]) {
        dp = new int[n][4];
        pointsArr = points;
        return ninjaTrainingTopDown(n - 1, 3); //sending 3 initial because no skill selected
    }

    public static int ninjaTrainingTopDown(int day, int lastSkillSelected) {
        if (day == 0) {
            int max = 0;
            for (int i = 0; i < 3; i++) {
                if (i != lastSkillSelected) max = Math.max(max, pointsArr[day][i]);
            }
            return max;
        } else {
            if (dp[day][lastSkillSelected] != 0) {
                return dp[day][lastSkillSelected];
            }
            int max = 0;
            for (int i = 0; i < 3; i++) {
                if (i != lastSkillSelected) max = Math.max(max, pointsArr[day][i] + ninjaTrainingTopDown(day - 1, i));
            }
            return dp[day][lastSkillSelected] = max;
        }
    }

    public static int ninjaTrainingBottomUp(int n, int points[][]) {
        dp = new int[n][4];
        pointsArr = points;
        dp[0][0] = Math.max(pointsArr[0][1], pointsArr[0][2]);
        dp[0][1] = Math.max(pointsArr[0][0], pointsArr[0][2]);
        dp[0][2] = Math.max(pointsArr[0][0], pointsArr[0][1]);
        dp[0][3] = Math.max(Math.max(pointsArr[0][0], pointsArr[0][1]), pointsArr[0][2]);

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                int maxi = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) maxi = Math.max(maxi, pointsArr[day][task] + dp[day - 1][task]);
                }
                dp[day][last] = maxi;
            }
        }

        return dp[n - 1][3];
    }

    public static int ninjaTrainingBottomUpSpaceOptimized(int n, int points[][]) {
        int[] prev = new int[4];
        pointsArr = points;
        prev[0] = Math.max(pointsArr[0][1], pointsArr[0][2]);
        prev[1] = Math.max(pointsArr[0][0], pointsArr[0][2]);
        prev[2] = Math.max(pointsArr[0][0], pointsArr[0][1]);
        prev[3] = Math.max(Math.max(pointsArr[0][0], pointsArr[0][1]), pointsArr[0][2]);

        for (int day = 1; day < n; day++) {
            int[] temp = new int[4];
            for (int last = 0; last < 4; last++) {
                int maxi = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) maxi = Math.max(maxi, pointsArr[day][task] + prev[task]);
                }
                temp[last] = maxi;
            }
            prev = temp;

        }

        return prev[3];
    }

    public int maximumPoints(int points[][], int N) {
        int[] prev = new int[3];
        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        int[] temp = new int[3];

        for (int day = 1; day < N; day++) {
            for (int last = 0; last < 3; last++) {
                for (int task = 0; task < 3; task++) {
                    if (task != last) temp[last] = Math.max(temp[last], points[day][task] + prev[task]);
                }
            }
            prev = temp;
        }
        return Math.max(Math.max(prev[0], prev[1]), prev[2]);
    }
    private static int ninjaTrainingSpaceOptimized(int n, int[][] points) {
        int c1 = points[0][0], c2 = points[0][1], c3 = points[0][2];

        for(int i = 1; i < points.length; i++) {
            int n1 = Math.max(c2, c3) + points[i][0];
            int n2 = Math.max(c1, c3) + points[i][1];
            int n3 = Math.max(c1, c2) + points[i][2];

            c1 = n1;
            c2 = n2;
            c3 = n3;
        }

        return Math.max(c1, Math.max(c3, c2));
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}};

        System.out.println(ninjaTrainingBottomUpSpaceOptimized(3, input));


    }
}
