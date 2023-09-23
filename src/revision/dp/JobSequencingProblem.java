package revision.dp;

import java.util.Arrays;
import java.util.PriorityQueue;

public class JobSequencingProblem {

    int[] JobScheduling(Job arr[], int n) {
        Arrays.sort(arr, ((o1, o2) -> {
            if (o1.deadline == o2.deadline) {
                return Integer.compare(o1.profit, o2.profit);
            }
            return Integer.compare(o1.deadline, o2.deadline);
        }));
        PriorityQueue<Job> priorityQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.profit, o2.profit));
        priorityQueue.add(arr[0]);
        for (int i = 1; i < n; i++) {
            Job job = arr[i];
            if (job.deadline == priorityQueue.size()) {
                if (job.profit > priorityQueue.peek().profit)
                    priorityQueue.poll();
            } else {
                priorityQueue.add(job);
            }
        }
        int totalProfit = priorityQueue.stream().mapToInt(x -> x.profit).sum();
        return new int[]{priorityQueue.size(), totalProfit};
    }

    public static void main(String[] args) {
        JobSequencingProblem obj = new JobSequencingProblem();
        //1 2 100 2 1 19 3 2 27 4 1 25 5 1 15
        Job[] jobs = new Job[]{new Job(1, 2, 100), new Job(2, 1, 19), new Job(3, 2, 27
        ), new Job(4, 1, 25), new Job(5, 1, 15)};
        System.out.println(Arrays.toString(obj.JobScheduling(jobs, jobs.length)));
    }
}

