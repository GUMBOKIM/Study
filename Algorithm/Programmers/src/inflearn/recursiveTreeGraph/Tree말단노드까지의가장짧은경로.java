package inflearn.recursiveTreeGraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tree말단노드까지의가장짧은경로 {

    static Node root;

    public static int DFS(int L, Node root) {
        if(root.lt == null && root.rt == null) return L;
        else return Math.min(DFS(L + 1, root.lt), DFS(L + 1, root.rt));
    }

    public static int BFS(Node root){
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0;
        while(!Q.isEmpty()) {
            int size = Q.size();
            for (int i = 0; i < size; i++) {
                Node current = Q.poll();
                if(current.lt == null && current.rt == null) return L;
                if(current.lt != null) Q.offer(current.lt);
                if(current.rt != null) Q.offer(current.rt);
            }
            L ++;
        }
        return -1;
    }


    public static void main(String[] args) {
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        System.out.println(DFS(0, root));
        System.out.println(BFS(root));
    }
}
