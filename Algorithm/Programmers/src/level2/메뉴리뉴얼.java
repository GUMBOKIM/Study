package level2;

import java.util.*;

public class 메뉴리뉴얼 {

    public static String[] solution(String[] orders, int[] course) {
        Map<String, Integer> map = new HashMap<>();
        for(String order : orders){
            for(String s : order.split("")){
                Integer temp = map.
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};

        System.out.println(메뉴리뉴얼.solution(orders, course));
    }
}