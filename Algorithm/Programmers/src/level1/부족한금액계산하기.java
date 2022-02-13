package level1;

import java.util.Arrays;

public class 부족한금액계산하기 {

    public static long solution(int price, int money, int count) {
        long answer = -1 * money;
        for (int i = 1; i <= count; i++) answer += price * i;
        if(answer <= 0) return 0;
        else return answer;
    }

    public static void main(String[] args) {

        System.out.println(부족한금액계산하기.solution(3, 20, 4));

    }
}