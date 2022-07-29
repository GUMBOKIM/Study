package practicetest;


import java.util.HashMap;

public class test1_2 {

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        HashMap<String, Integer> hashMap = new HashMap<>();
        // 초기 10일 세팅
        for (int i = 0; i < 10; i++) {
            hashMap.put(discount[i], hashMap.getOrDefault(discount[i], 0) + 1);
        }
        if (check(hashMap, want, number)) answer++;

        // 10일 이후 부터
        for (int i = 10; i < 15; i++) {
            hashMap.put(discount[i], hashMap.getOrDefault(discount[i], 0) + 1);
            hashMap.put(discount[i - 10], hashMap.get(discount[i - 10]) - 1);
            if (check(hashMap, want, number)) answer++;
        }

        return answer;
    }

    static boolean check(HashMap<String, Integer> hashMap, String[] want, int[] number) {
        for (int i = 0; i < want.length; i++) {
            if (hashMap.getOrDefault(want[i], 0) != number[i]) return false;
        }
        return true;
    }
}
