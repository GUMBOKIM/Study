package inflearn.stack_queue;

import java.util.Scanner;
import java.util.Stack;

public class 괄호문제거 {

    public static String solution(String input) {
        StringBuilder sb = new StringBuilder();

        int level = 0;
        for (char c : input.toCharArray()) {
            if (c == '(') {
                level++;
            } else if (c == ')') {
                level--;
            } else {
                if (level == 0) sb.append(c);
            }
        }

//        Stack<Character> stack = new Stack<>();
//        for (char c : input.toCharArray()) {
//            if (c == ')') while (stack.pop() == '(') ;
//            else stack.push(c);
//        }
//
//        for (int i = 0; i < stack.size(); i++) sb.append(stack.get(i));

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        System.out.print(solution(input));
    }
}
