import java.util.*;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> jobList =  new ArrayList<Integer>();
        int scanTimes = 0;
        while (scanTimes < n){
            int n_k = scanner.nextInt();
            jobList.add(n_k);
            scanTimes++;
        }
        System.out.println(jobList);
        PriorityQueue<Integer>[] priorityQueues = new PriorityQueue[5];
        for (int i = 0; i < 5; i++) {
            priorityQueues[i]=new PriorityQueue<Integer>((o1, o2)->o2 - o1);
        }

        for (int i = 0; i < n; i++) {
            priorityQueues[jobList.get(i)-1].add(i+1);
            if (priorityQueues[0].isEmpty()|| priorityQueues[1].isEmpty()||priorityQueues[2].isEmpty()||priorityQueues[3].isEmpty()||priorityQueues[4].isEmpty()){
                System.out.println("-1");
            }else {
                for (int j = 0; j < 5; j++) {
                    System.out.print(priorityQueues[j].poll() + " ");
                }
                System.out.println();
            }
        }
    }
}
