package inflearn.string;

import java.util.Scanner;

public class 문장_속_단어 {

    public static String solution(String input) {
        String answer = "";
        int maxLength = 0;
        for (String element: input.split(" ")) {
            int length = element.length();
            if(maxLength < element.length()) {
                answer = element;
                maxLength = length;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.print(solution(input));
    }
}
