package inflearn.stack_queue;

import java.util.Scanner;
import java.util.Stack;

public class 후위_연산식 {

    public static int solution(String input) {
        Stack<Integer> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - 48);
            } else {
                int rt = stack.pop();
                int lt = stack.pop();
                switch (c) {
                    case '+': stack.push(lt + rt);
                        break;
                    case '-': stack.push(lt - rt);
                        break;
                    case '*': stack.push(lt * rt);
                        break;
                    case '/': stack.push(lt / rt);
                        break;
                }
            }
        }
        return stack.get(0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.print(solution(input));
    }
}
