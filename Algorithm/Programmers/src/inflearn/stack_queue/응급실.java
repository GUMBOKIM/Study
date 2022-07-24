package inflearn.stack_queue;

import java.util.*;

public class 응급실 {

    public static int solution(int n, int m, int[] input) {
        int answer = 0;
        Queue<Patient> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) queue.offer(new Patient(i, input[i]));

        while (true) {
            Patient now = queue.poll();
            boolean isBiggerThanNow = false;
            for (Patient patient : queue) {
                if (patient.point > now.point) {
                    isBiggerThanNow = true;
                    break;
                }
            }
            if (isBiggerThanNow) {
                queue.offer(now);
            } else {
                answer++;
                if (now.index == m) break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) input[i] = sc.nextInt();
        System.out.print(solution(n, m, input));
    }
}

class Patient {
    int index;
    int point;

    Patient(int index, int point) {
        this.index = index;
        this.point = point;
    }
}