package level1;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/12931
public class 자연수를뒤집어배열로만들기 {

    public static int[] solution(long n) {
        int[] answer = {};
        int k = 0;
        long num = n;
        while(n>0){
            k++;
            n = n/10;
        }
        answer = new int[k];
        for(int i=0; i<k; i++){
            answer[i] = (int)(num%10);
            num = num/10;
        }
        return answer;
    }

    public static void main(String[] args) {
        int N = 123456;
        int N2 = 29030;

        System.out.println(Arrays.toString(자연수를뒤집어배열로만들기.solution(N)));
        System.out.println(Arrays.toString(자연수를뒤집어배열로만들기.solution(N2)));
    }
}