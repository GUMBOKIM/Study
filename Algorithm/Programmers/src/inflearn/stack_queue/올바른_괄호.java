package inflearn.stack_queue;

import java.util.*;

public class 올바른_괄호 {

    public static String solution(String input) {
        int result = 0;
        for (char c : input.toCharArray()) {
            if(c == '(') {
                result ++;
            } else if(c == ')') {
                if(result > 0) result --;
                else return "NO";
            }
        }

        if(result == 0) {
            return "YES";
        } else {
            return "NO";
        }

//
//        char[] chars = input.toCharArray();
//        Stack<Character> stack = new Stack<>();
//        for (char c : chars) {
//            if (c == '(')
//                stack.push('(');
//            else if (c == ')') {
//                if (stack.isEmpty()) return "NO";
//                else stack.pop();
//            }
//        }
//        return stack.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        System.out.print(solution(input));
    }
}
