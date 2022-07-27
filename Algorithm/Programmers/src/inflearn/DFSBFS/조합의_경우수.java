package inflearn.DFSBFS;

import java.util.Scanner;

public class 조합의_경우수 {

    static int recursive(int n, int r) {
        if (r == 0) return 1;
        if (n == 1 && r == 1) return n;
        if (n == r) return 1;
        return recursive(n-1, r-1) + recursive(n-1, r);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        System.out.println(recursive(n, r));
    }
}
