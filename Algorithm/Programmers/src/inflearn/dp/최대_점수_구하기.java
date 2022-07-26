package inflearn.dp;

import java.util.Arrays;
import java.util.Scanner;

public class 최대_점수_구하기 {

//    public static int solution(int n, int m, Question[] questions) {
//        int[] results = new int[m + 1];
//        Arrays.fill(results, 0);
//        results[0] = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = questions[i].time; j <= m; j++) {
//                results[j] = Math.max(results[j], results[j - questions[i].time] + questions[i].score);
//            }
//        }
//        return results[m];
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        Question[] questions = new Question[n];
//        for (int i = 0; i < n; i++) questions[i] = new Question(sc.nextInt(), sc.nextInt());
//        System.out.print(solution(n, m, questions));
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] dy = new int[m + 1];
        for (int i = 0; i < n; i++) {
            int ps = sc.nextInt();
            int pt = sc.nextInt();
            for (int j = m; j >= pt; j--) {
                dy[j] = Math.max(dy[j], dy[j-pt] + ps);
            }
        }
        System.out.println(dy[m]);
    }
}

class Question {
    int score;
    int time;

    Question(int score, int time) {
        this.score = score;
        this.time = time;
    }
}
