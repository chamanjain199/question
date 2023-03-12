package geeksForGeeks.dp;


import java.util.*;

class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

public class JobSequencingProblem {


    private static int compare(Job a, Job b) {
        if (a.deadline == b.deadline) {
            return Integer.compare(a.profit, b.profit);
        }
        return Integer.compare(a.deadline, b.deadline);
    }

    private static int compare2(Job a, Job b) {
        return Integer.compare(a.profit, b.profit);
    }

    int[] JobScheduling(Job[] arr, int n) {
        Arrays.sort(arr, JobSequencingProblem::compare);
        PriorityQueue<Job> priorityQueue = new PriorityQueue<>(JobSequencingProblem::compare2);
        priorityQueue.add(arr[0]);
        for (int i = 1; i < n; i++) {
            Job job = arr[i];
            if (job.deadline < (priorityQueue.size())) {
                priorityQueue.add(job);
            } else if (job.deadline == priorityQueue.size()) {
                Job peak = priorityQueue.peek();
                if (job.profit > peak.profit) {
                    priorityQueue.poll();
                    priorityQueue.add(job);
                }
            } else {
                priorityQueue.add(job);
            }
        }
        int totalProfit = priorityQueue.parallelStream().mapToInt(x -> x.profit).sum();
        return new int[]{priorityQueue.size(), totalProfit};
    }

    public int jobSchedulingLeetcode(int[] startTime, int[] endTime, int[] profit) {
        int len = profit.length;
        Job[] jobs = new Job[len];
        for (int i = 0; i < len; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobs, Comparator.comparingInt(x -> x.deadline));
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(0, 0);
        for (int i = 0; i < len; i++) {
            Job job = jobs[i];
            int totalProfit = job.profit + treeMap.floorEntry(job.id).getValue();
            if (totalProfit > treeMap.lastEntry().getValue()) {
                treeMap.put(job.deadline, totalProfit);
            }
        }
        return treeMap.lastEntry().getValue();

    }


    public static void main(String[] args) {
        // 1 2 100 2 1 19 3 2 27 4 1 25 5 1 15
        Job[] jobs = new Job[]{new Job(1, 2, 100), new Job(2, 1, 19), new Job(3, 2, 27), new Job(4, 1, 25), new Job(5, 1, 15)};
        //1 4 20,  2 1 10 3 1 40 4 1 30
        jobs = new Job[]{new Job(1, 4, 20), new Job(2, 1, 10), new Job(3, 1, 40), new Job(4, 1, 30), new Job(5, 4, 21), new Job(5, 4, 25), new Job(6, 4, 80)};
        JobSequencingProblem obj = new JobSequencingProblem();
         System.out.print(Arrays.toString(obj.JobScheduling(jobs, jobs.length)));

        System.out.println(obj.jobSchedulingLeetcode(new int[]{4, 2, 4, 8, 2}, new int[]{5, 5, 5, 10, 8}, new int[]{1, 2, 8, 10, 4}));


    }
}
