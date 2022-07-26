package inflearn.recursiveTreeGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 그래프최단거리BFS {

    static int n, m;
    static int[] ch, distance;
    static ArrayList<ArrayList<Integer>> graph;

    static void BFS(int v) {
        Queue<Integer> Q = new LinkedList<>();
        ch[v] = 1;
        distance[v] = 0;
        Q.offer(v);
        while(!Q.isEmpty()) {
            int cv = Q.poll();
            for(int nv : graph.get(cv)){
                if(ch[nv] == 0) {
                    ch[nv] = 1;
                    Q.offer(nv);
                    distance[nv] = distance[cv] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        ch = new int[n + 1];
        distance = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        ch[1] = 1;
        BFS(1);
    }

}