package inflearn.string;

import java.util.Scanner;

public class 단어_뒤집기 {

    public static void solution(String[] inputs) {
        for (String element: inputs) {
//            StringBuilder sb = new StringBuilder();
//            int length = element.length();
//            for (int i = length - 1; i >= 0; i--) {
//                sb.append(element.charAt(i));
//            }
//            System.out.println(sb);
            int index = element.length() - 1;
            while (index >= 0) {
                System.out.print(element.charAt(index));
                index --;
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        String[] inputs = new String[count];
        for (int i = 0; i < count; i++) {
            inputs[i] = sc.next();
        }
        solution(inputs);
    }
}
