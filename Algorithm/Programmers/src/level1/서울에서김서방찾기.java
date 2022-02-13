package level1;

import java.util.Arrays;

public class 서울에서김서방찾기 {

    public static String solution(String[] seoul) {
//        for (int i = 0; i < seoul.length; i++) if (seoul[i].matches("Kim")) return "김서방은 " + i + "에 있다";
//        return "";
        return "김서방은 " + Arrays.asList(seoul).indexOf("Kim")  + "에 있다";
    }

    public static void main(String[] args) {
        String[][] s_arr = {
                {"Jane", "Kim"}
        };

        for (int i = 0; i < 2; i++) System.out.println(서울에서김서방찾기.solution(s_arr[i]));
    }
}