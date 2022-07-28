package level2;

import java.util.Stack;

public class 괄호_변환 {
    static String solution(String p) {
        if(!p.isEmpty()) {
            if(valid(p)) return p;
            // 2
            String[] divide = divide(p);
            String u = divide[0];
            String v = divide[1];
            // 3
            if (valid(u)) {
                return u + solution(v);
                // 4
            } else {
                return "(" + solution(v) + ")" + edit(u) ;
            }
        } else return "";
    }

    static String[] divide(String w) {
        String[] result = {"", w};
        int openCount = 0;
        int closeCount = 0;
        for (int i = 0; i < w.length(); i++) {
            char c = w.charAt(i);
            if (c == '(') openCount++;
            if (c == ')') closeCount++;
            if (openCount == closeCount) {
                result[0] = w.substring(0, i + 1); // u
                result[1] = w.substring(i + 1); // v
                break;
            }
        }
        return result;
    }

    static boolean valid(String p) {
        Stack<Character> stack = new Stack<>();
        stack.push(p.charAt(0));
        char[] charArray = p.toCharArray();
        for (int i = 1; i < charArray.length; i++) {
            char c = charArray[i];
            if (!stack.isEmpty() && stack.peek() == '(' && c == ')') stack.pop();
            else stack.push(c);
        }
        return stack.size() == 0;
    }

    static String edit(String u){
        String result = "";
        u = u.substring(1, u.length() - 1);
        for (char c: u.toCharArray()) {
            result += c == '(' ? ")" : "(";
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(")("));
    }
}
