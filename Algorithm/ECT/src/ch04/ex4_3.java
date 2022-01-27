package ch04;

import java.util.Scanner;

public class ex4_3 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        int x = input.charAt(1) - '0';
        int y = input.charAt(0) - 'a' + 1;
        int cnt = 0;

        int[] dx = {1, 1, 2, 2, -1, -1, -2, -2};
        int[] dy = {2, -2, 1, -1, 2, -2, 1, -1};

        for (int i = 0; i < 8; i++) {
            if (x + dx[i] > 0 && y + dy[i] > 0) cnt += 1;
        }
        System.out.println(cnt);

    }
}
