package level2;

import java.util.*;

public class 메뉴_리뉴얼_못품 {
    static String[] solution(String[] orders, int[] course) {
        int length = orders.length;

        Arrays.sort(orders, (s1, s2) -> {
            if(s1.indexOf(0) == s2.indexOf(0)) return s1.length() - s2.length();
            return s1.indexOf(0) - s2.indexOf(0);
        });

        ArrayList<String> answer = new ArrayList<>();

        for (int count: course) {
            for (int i = 0; i < length; i++) {
                String a = orders[i];
                int a_length = a.length();
                if(a_length >= count) {
                    for (int j = 1; j < length; j++) {
                        String b = orders[j];
                    }
                }
            }
        }
        return new String[]{"asd"};
    }

    static ArrayList<Character> check(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();

        ArrayList<Character> result = new ArrayList<>();

        for (int i = 0; i < aLength; i++) {
            for (int j = 0; j < bLength; j++) {
                if(a.charAt(i) == b.charAt(j)){
                    result.add(a.charAt(i));
                    break;
                }
            }
        }

        return result;
    }

    static ArrayList<String> create(ArrayList<Character> arr, int length) {
        ArrayList<String> result = new ArrayList<>();
        int size = arr.size();
        int count = 0;
        // 5 3 -> 0 1 2

        if (size >= length) {

        }

        return result;
    }

    public static void main(String[] args) {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {};

        solution(orders, course);
    }
}
