package inflearn.map_set;

import java.util.HashMap;
import java.util.Scanner;

public class 매출액의_종류 {

    public static String solution(int n, int k, int[] arr) {
        // 시간초과
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < n - k + 1; i++) {
//            HashSet<Integer> set = new HashSet<>();
//            for (int j = 0; j < k; j++) set.add(arr[i + j]);
//            sb.append(set.size() + " ");
//        }
//        return sb.toString();
        StringBuilder sb = new StringBuilder();

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k - 1; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (int i = k - 1; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            sb.append(map.keySet().size() + " ");
            Integer value = map.get(arr[i - (k - 1)]);
            if(value == 1) {
                map.remove(arr[i - (k - 1)]);
            }else {
                map.put(arr[i - (k - 1)], value - 1);
            }
        }

        return sb.toString();
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
