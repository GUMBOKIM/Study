package inflearn.stack_queue;

import java.util.Scanner;
import java.util.Stack;

public class 후위_연산식 {

    public static int solution(String input) {
        int answer = 0;
        int temp = 0;
        Stack<Character> stack = new Stack<>();
        for (char c: input.toCharArray()) {
            if(Character.isDigit(c)) {
                stack.push(c);

            }
            stack.push(c);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.print(solution(input));
    }
}
