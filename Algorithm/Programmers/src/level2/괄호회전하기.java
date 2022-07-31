package level2;

import java.util.Stack;

public class 괄호회전하기 {

    public static int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) if (check(s.substring(i) + s.substring(0, i))) answer++;
        return answer;
    }

    public static boolean check(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (stack.isEmpty()) stack.push(c);
            else {
                if ((c == ')' && stack.peek() == '(')
                        || (c == ')' && stack.peek() == '(')
                        || (c == ')' && stack.peek() == '(')) {
                    stack.pop();
                } else stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
