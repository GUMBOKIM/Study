package inflearn.string;

import java.util.Arrays;
import java.util.Scanner;

public class 특정_문자_뒺비기 {

    public static String solution(String input) {
        StringBuilder sb = new StringBuilder();
        char[] arr = input.toCharArray();
        int leftIndex = 0;
        int rightIndex = input.length() - 1;

        while(leftIndex < rightIndex) {
            char leftChar = arr[leftIndex];
            boolean isLeftAlphabetic = Character.isAlphabetic(leftChar);
            char rightChar = arr[rightIndex];
            boolean isRightAlphabetic = Character.isAlphabetic(rightChar);

            if(isLeftAlphabetic && isRightAlphabetic){
                arr[leftIndex] = rightChar;
                arr[rightIndex] = leftChar;
                leftIndex ++;
                rightIndex --;
            } else {
                if(!isLeftAlphabetic) {
                    arr[leftIndex] = leftChar;
                    leftIndex ++;
                }
                if(!isRightAlphabetic) {
                    arr[rightIndex] = rightChar;
                    rightIndex --;
                }
            }
        }


        return sb.append(arr).toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.print(solution(input));
    }
}
