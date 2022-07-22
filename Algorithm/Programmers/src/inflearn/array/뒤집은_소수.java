package inflearn.array;

import java.util.Scanner;

public class 뒤집은_소수 {

    public static boolean isPrime(int number) {
        if (number == 1) return false;
        for (int i = 2; i < number; i++) if (number % i == 0) return false;
        return true;
    }

    public static String solution(String[] arr) {
        StringBuilder sb = new StringBuilder();
        for (String str : arr) {
            int number = Integer.parseInt(new StringBuilder(str).reverse().toString());
//            int now = 2;
//            if(number == 2) {
//                sb.append(number + " ");
//            } else {
//                int sqrt = (int) Math.ceil(Math.sqrt(number));
//                while (now <= sqrt) {
//                    if (number % now == 0) break;
//                    if (now == sqrt) {
//                        sb.append(number + " ");
//                    }
//                    now++;
//                }
//            }
            if (isPrime(number)) sb.append(number + " ");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        String[] arr = new String[length];
        for (int i = 0; i < length; i++) {
            arr[i] = sc.next();
        }
        System.out.println(solution(arr));
    }
}
