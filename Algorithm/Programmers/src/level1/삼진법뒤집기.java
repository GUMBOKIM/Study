package level1;

import java.util.Stack;

public class 삼진법뒤집기 {

    public static int solution(int n) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        while(n > 2){
            int r = n % 3;
            n = (n - r) / 3;
            stack.add(r);
        }
        stack.add(n);

        int locale = 0;
        while(!stack.empty()){
            answer += stack.pop() * Math.pow(3, locale);
            locale ++;
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] n_arr = {45, 125};

        for (int i = 0; i < 2; i++) {
            System.out.println(삼진법뒤집기.solution(n_arr[i]));
        }
    }
}