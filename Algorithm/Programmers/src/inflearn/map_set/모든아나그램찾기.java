package inflearn.map_set;

import java.util.HashMap;
import java.util.Scanner;

public class 모든아나그램찾기 {

    public static int solution(String sentence1, String sentence2) {
        int answer = 0;

        char[] arr1 = sentence1.toCharArray();
        int arr1_length = arr1.length;
        char[] arr2 = sentence2.toCharArray();
        int arr2_length = arr2.length;

        HashMap<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < arr2_length - 1; i++) {
            map1.put(arr1[i], map1.getOrDefault(arr1[i], 0) + 1);
        }

        HashMap<Character, Integer> map2 = new HashMap<>();
        for (char c : arr2) map2.put(c, map2.getOrDefault(c, 0) + 1);

        for (int i = arr2_length - 1; i < arr1_length; i++) {
            map1.put(arr1[i], map1.getOrDefault(arr1[i], 0) + 1);

            if (map1.equals(map2)) answer++;

            Integer value = map1.get(arr1[i - (arr2_length - 1)]);
            if (value == 1) {
                map1.remove(arr1[i - (arr2_length - 1)]);
            } else {
                map1.put(arr1[i - (arr2_length - 1)], value - 1);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence1 = sc.next();
        String sentence2 = sc.next();
        System.out.print(solution(sentence1, sentence2));
    }
}
