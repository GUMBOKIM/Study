package skillcheck;

import java.util.Collections;
import java.util.PriorityQueue;

public class level2_3 {
    public static long solution(int n, int[] works) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int work : works) queue.offer(work);
        System.out.println("queue = " + queue);
        while(n != 0) {
            int max = queue.poll();
            if(max == 0) return 0;
            queue.offer(max - 1);
            System.out.println("queue = " + queue);
            n--;
        }
        return calculate(works);
    }

    static int findMax(int[] works) {
        int max = 0;
        for (int i = 0; i < works.length; i++) max = Math.min(max, works[i]);
        return max;
    }

    static int findIndex(int value, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == value) return i;
        }
        return -1;
    }

    static long calculate(int[] works) {
        long sum = 0;
        for (int work: works) sum += work * work;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(solution(4, new int[]{4,3,3}));
    }
}
