package level2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.regex.Pattern;

public class 뉴스_클러스터링 {
    static int solution(String str1, String str2) {
        HashMap<String, Integer> map1 = createMap(str1.toLowerCase());
        HashMap<String, Integer> map2 = createMap(str2.toLowerCase());
        int intersection = intersection(map1, map2);
        int union = union(map1, map2);
        if (union != 0) return 65536 * intersection / union;
        else return 65536;
    }

    static HashMap<String, Integer> createMap(String str) {
        HashMap<String, Integer> result = new HashMap<>();
        for (int i = 0; i < str.length() - 1; i++) {
            String key = str.substring(i, i + 2);
            if (Pattern.matches("^[a-z]*$", key)) result.put(key, result.getOrDefault(key, 0) + 1);
        }
        return result;
    }

    static int intersection(HashMap<String, Integer> map1, HashMap<String, Integer> map2) {
        int answer = 0;
        for (String key : map1.keySet()) {
            int value1 = map1.getOrDefault(key, 0);
            int value2 = map2.getOrDefault(key, 0);
            answer += Math.min(value1, value2);
        }
        return answer;
    }

    static int union(HashMap<String, Integer> map1, HashMap<String, Integer> map2) {
        HashSet<String> set = new HashSet<>();
        set.addAll(map1.keySet());
        set.addAll(map2.keySet());
        int answer = 0;
        for (String key : set) {
            int value1 = map1.getOrDefault(key, 0);
            int value2 = map2.getOrDefault(key, 0);
            answer += Math.max(value1, value2);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("handshake", "shake hands"));
    }
}
