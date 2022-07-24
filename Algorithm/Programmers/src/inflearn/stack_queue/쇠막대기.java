package inflearn.stack_queue;

import java.util.Scanner;
import java.util.Stack;

public class 쇠막대기 {

    public static int solution(String input) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
//        for (char c : input.toCharArray()) stack.push(c);
//        char before = '(';
//        int level = 0;
//        while(!stack.isEmpty()) {
//            char pop = stack.pop();
//            if(pop == ')') {
//                level ++;
//            } else {
//                level --;
//                answer += before == '(' ? 1 : level;
//            }
//            before = pop;
//        }
        for(int i=0; i<input.length(); i++) {
            if(input.charAt(i) == '(') answer += stack.size();
            else {
                stack.pop();
                if(input.charAt(i - 1) == '(') answer += stack.size();
                else answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.print(solution(input));
    }
}
