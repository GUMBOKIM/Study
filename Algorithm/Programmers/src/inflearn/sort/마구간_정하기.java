package inflearn.sort;

import java.util.Arrays;
import java.util.Scanner;

public class 마구간_정하기 {

    public static int count(int[] arr, int dist) {
        int cnt = 1;
        int ep = arr[0];
        for(int i=1; i< arr.length; i++) {
            if(arr[i] - ep >= dist) {
                cnt ++;
                ep = arr[i];
            }
        }
        return cnt;
    }

    public static int solution(int n, int m, int[] line) {
        int answer = 0;
        Arrays.sort(line);

        int lt = 1;
        int rt = line[n -1];
        while(lt <= rt) {
            int mid = (lt+rt) / 2;
            if(count(line, mid) >= m) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.print(solution(n, m, arr));
    }
}
