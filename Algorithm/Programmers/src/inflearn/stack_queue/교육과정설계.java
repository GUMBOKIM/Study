package inflearn.stack_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 교육과정설계 {

    public static String solution(String sentence1, String sentence2) {
//        Queue<Character> q1 = new LinkedList<>();
//        for (char c: sentence1.toCharArray()) q1.offer(c);
//        Queue<Character> q2 = new LinkedList<>();
//        for (char c: sentence2.toCharArray()) q2.offer(c);
//
//        char now = q1.poll();
//        while(!q2.isEmpty()){
//            char poll = q2.poll();
//            if(now == poll) {
//                if(q1.isEmpty()){
//                    return "YES";
//                } else {
//                    now = q1.poll();
//                }
//            }
//        }
//        return "NO";
        String answer = "YES";
        Queue<Character> Q = new LinkedList<>();
        for (char c : sentence1.toCharArray()) Q.offer(c);
        for (char c : sentence2.toCharArray()) {
            if (Q.contains(c)) {
                if (c != Q.poll()) return "NO";
            }
        }
        if (!Q.isEmpty()) return "NO";
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence1 = sc.next();
        String sentence2 = sc.next();
        System.out.print(solution(sentence1, sentence2));
    }
}
