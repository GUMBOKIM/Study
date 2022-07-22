package inflearn.array;

import java.util.Scanner;

public class 가위_바위_보 {

    public static void solution(int length, int[] arrA, int[] arrB) {
        for (int i = 0; i < length; i++) {
            char answer;
            int A = arrA[i];
            int B = arrB[i];
            if(A == B) {
                answer ='D';
            } else {
                if( (A == 2 & B == 1) || (A == 3 & B == 2) || (A == 1 & B == 3) ){
                    answer = 'A';
                } else {
                    answer = 'B';
                }
            }
            System.out.println(answer);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] arrA = new int[length];
        int[] arrB = new int[length];
        for (int i = 0; i < length; i++) arrA[i] = sc.nextInt();
        for (int i = 0; i < length; i++) arrB[i] = sc.nextInt();
        solution(length, arrA, arrB);
    }
}
