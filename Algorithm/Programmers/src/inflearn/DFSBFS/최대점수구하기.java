package inflearn.DFSBFS;

import java.util.Scanner;

public class 최대점수구하기 {

    static int n, m;
    static Score[] arr;
    static int max = 0;

    static void DFS(int index, int time, int sum) {
        if (time > m) return;
        if (index == n - 1) {;
            max = Math.max(max, sum);
        } else {
            DFS(index + 1, time + arr[index + 1].time, sum + arr[index + 1].score);
            DFS(index + 1, time, sum);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new Score[n];
        for (int i = 0; i < n; i++) arr[i] = new Score(sc.nextInt(), sc.nextInt());
        DFS(-1, 0, 0);
        System.out.println(max);
    }
}

class Score {
    int score;
    int time;


    Score(int score, int time) {
        this.score = score;
        this.time = time;
    }
}
