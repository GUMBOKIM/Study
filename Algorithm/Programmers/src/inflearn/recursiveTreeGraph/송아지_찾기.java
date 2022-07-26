package inflearn.recursiveTreeGraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 송아지_찾기 {
/*
    static int s;
    static int e;
    static int answer = Integer.MAX_VALUE;

    public static void DFS(int location, int count) {
        if (count <= answer) {
            if (location > e) {
                DFS(location - 1, count + 1);
            } else if (location == e) {
                answer = Math.min(answer, count);
            } else {
                DFS(location + 1, count + 1);
                DFS(location + 5, count + 1);
            }
        }
    }
*/

    static int answer = 0;
    static int[] dis = {1, -1, 5};
    static int[] ch;
    static Queue<Integer> Q = new LinkedList<>();

    static int BFS(int s, int e) {
        ch = new int[10001];
        ch[s] = 1;
        Q.offer(s);
        int L = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int x = Q.poll();
                if(x==e) return L;
                for (int j = 0; j < 3; j++) {
                    int nx = x + dis[j];
                    if (nx >= 1 && nx <= 10000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }
        return answer;
    }

    ;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        s = sc.nextInt();
//        e = sc.nextInt();
//        System.out.println("answer = " + answer);
        int s = sc.nextInt();
        int e = sc.nextInt();
        System.out.println(BFS(s, e));


    }
}
