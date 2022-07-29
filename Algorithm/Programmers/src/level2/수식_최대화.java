package level2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class 수식_최대화 {

    static long solution(String expression) {
        long answer = 0;
        HashSet<Character> operatorSet = new HashSet();
        LinkedList<Character> operatorList = new LinkedList<>();
        LinkedList<Long> numberList = new LinkedList<>();

        parsing(expression, operatorSet, operatorList, numberList);

        return answer;
    }

    static void parsing(String expression, HashSet<Character> operatorSet, LinkedList<Character> operatorList, LinkedList<Long> numberList) {
        StringBuilder sb = new StringBuilder();
        for (char c : expression.toCharArray()) {
            if (c == '*' || c == '-' || c == '+') {
                numberList.add(Long.parseLong(sb.toString()));
                sb = new StringBuilder();
                operatorSet.add(c);
                operatorList.add(c);
            } else {
                sb.append(c);
            }
        }
        numberList.add(Long.parseLong(sb.toString()));
    }

    public static void main(String[] args) {
        System.out.println(solution("100-200*300-500+20"));
    }
}
