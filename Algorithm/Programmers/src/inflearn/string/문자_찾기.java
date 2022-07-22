package inflearn.string;

import java.util.Scanner;

public class 문자_찾기 {

    public static int solution(String str, char t) {
        int answer = 0;
        t = Character.toUpperCase(t);
        for (char element : str.toUpperCase().toCharArray()) if(element == t) answer ++;
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);

        System.out.print(solution(str, c));
    }
}
