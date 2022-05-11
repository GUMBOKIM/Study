package highScoreKit.hash;

import java.util.*;

public class Spy {

    static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String[] clothe: clothes) {
            String part = clothe[1];
            hashMap.put(part, hashMap.getOrDefault(part, 0) + 1);
        }
        for(Integer count : hashMap.values()) {
            answer = answer * count;
        }
        return answer - 1;
    }
    public static void main(String[] args) {



    }
}
