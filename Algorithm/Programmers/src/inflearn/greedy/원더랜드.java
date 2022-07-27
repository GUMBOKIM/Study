package inflearn.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 원더랜드 {
    static int[] unf;

    static int find(int v) {
        if (v == unf[v]) return v;
        else return unf[v] = find(unf[v]);
    }

    static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) unf[fa] = fb;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        unf = new int[n + 1];

        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 1; i <= n; i++) unf[i] = i;
        for (int i = 1; i <= m; i++) {
            edges.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        int answer = 0;
        Collections.sort(edges);
        for (Edge edge : edges) {
            int f1 = find(edge.v1);
            int f2 = find(edge.v2);
            if(f1 != f2) {
                answer += edge.cost;
                union(f1, f2);
            }
        }
        System.out.println("answer = " + answer);
    }
}

class Edge implements Comparable<Edge> {
    public int v1;
    public int v2;
    public int cost;

    public Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}
