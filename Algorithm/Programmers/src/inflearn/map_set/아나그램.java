package inflearn.map_set;

import java.util.HashMap;
import java.util.Scanner;

public class 아나그램 {

    public static String solution(String sentence1, String sentence2) {
//        HashMap<Character, Integer> map1 = new HashMap<>();
//        HashMap<Character, Integer> map2 = new HashMap<>();
//
//        for (char c : sentence1.toCharArray()) map1.put(c, map1.getOrDefault(c, 0) + 1);
//        for (char c : sentence2.toCharArray()) map2.put(c, map2.getOrDefault(c, 0) + 1);
//
//        for (char c : map1.keySet()){
//            if(map1.get(c) != map2.getOrDefault(c, 0)) {
//                return "NO";
//            }
//        }
//        return "YES";
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : sentence1.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        for (char c : sentence1.toCharArray()) {
            if(!map.containsKey(c) || map.get(c) == 0) return "NO";
            map.put(c, map.get(c) - 1);
        }
        return "YES";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence1 = sc.next();
        String sentence2 = sc.next();
        System.out.print(solution(sentence1, sentence2));
    }
}
