package level2;

import java.util.HashMap;
import java.util.HashSet;

public class 튜플 {

    static int[] solution(String expression) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        boolean isStart = false;
        StringBuilder sb = new StringBuilder();
        for (char c : expression.toCharArray()) {
            if (c == '{' || c == ',' || c == '}') {
                if (isStart) {
                    isStart = false;
                    int number = Integer.parseInt(sb.toString());
                    hashMap.put(number, hashMap.getOrDefault(number, 0) + 1);
                    sb = new StringBuilder();
                }
            } else {
                if (!isStart) isStart = true;
                sb.append(c);
            }
        }

        int size = hashMap.size();
        int[] result = new int[size];
        for (Integer key: hashMap.keySet()) {
            int index = size - hashMap.get(key);
            result[index] = key;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution("100-200*300-500+20"));
    }
}
