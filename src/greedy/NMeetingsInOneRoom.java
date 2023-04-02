package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class NMeetingsInOneRoom {
    public static int maxMeetings(int start[], int end[], int n) {
        int[][] meetings = new int[n][2];
        for (int i = 0; i < n; i++) {
            meetings[i][0] = start[i];
            meetings[i][1] = end[i];
        }
        Arrays.sort(meetings, Comparator.comparingInt(x -> x[1]));

        int count = 1;
        int endTime = meetings[0][1];
        for (int i = 1; i < n; i++) {
            if (meetings[i][0] > endTime) {
                count++;
                endTime = meetings[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
