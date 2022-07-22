package inflearn.string;

import java.util.Scanner;

public class 숫자만_추출 {

    public static int solution(String input) {
//        input = input.toUpperCase().replaceAll("\\D", "");
//        return Integer.parseInt(input);
        String answer = "";
        for(char x : input.toCharArray()){
            if(Character.isDigit(x)) answer += x;
        }
        return Integer.parseInt(input);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.print(solution(input));
    }
}
