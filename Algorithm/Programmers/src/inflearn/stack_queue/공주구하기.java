package inflearn.stack_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 공주구하기 {

    public static int solution(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) queue.add(i);
        int count = 1;
        while(queue.size() != 1) {
            if(count != k) {
                queue.offer(queue.poll());
                count++;
            } else {
                queue.poll();
                count = 1;
            }
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.print(solution(n, k));
    }
}
