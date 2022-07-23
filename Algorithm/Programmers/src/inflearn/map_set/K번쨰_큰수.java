package inflearn.map_set;

import java.util.*;

public class K번쨰_큰수 {


    public static int solution(int n, int k, int[] arr) {
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < n - 2; i++)
            for (int j = i + 1; j < n - 1; j++)
                for (int l = j + 1; l < n; l++)
                    set.add(arr[i] + arr[j] + arr[l]);

        int answer = -1;
        int count = 0;

        for(int x : set) {
            count ++;
            if(count == k) return x;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.print(solution(n, k, arr));
    }
}
