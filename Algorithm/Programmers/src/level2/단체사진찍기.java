package level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 단체사진찍기 {

    static String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};

    public static List<String> allCase;

    public static void createCase(String create) {
        if (create.length() == 8) allCase.add(create);
        else for (String kakao : friends) if (!create.contains(kakao)) createCase(create + kakao);
    }

    public static int solution(int n, String[] data) {
        allCase = new ArrayList<>();
        createCase("");
        for (int i = 0; i < n; i++) {
            List<String> temp = new ArrayList<>();
            char start = data[i].charAt(0);
            char end = data[i].charAt(2);
            char sign = data[i].charAt(3);
            int num = Integer.parseInt(data[i].substring(4));
            if (sign == '=') {
                for (String now_case : allCase) {
                    if (Math.abs(now_case.lastIndexOf(end) - now_case.lastIndexOf(start)) == num + 1) {
                        temp.add(now_case);
                    }
                }
            } else if (sign == '>') {
                for (String now_case : allCase) {
                    if (Math.abs(now_case.lastIndexOf(end) - now_case.lastIndexOf(start)) > num + 1) {
                        temp.add(now_case);
                    }
                }
            } else if (sign == '<') {
                for (String now_case : allCase) {
                    if (Math.abs(now_case.lastIndexOf(end) - now_case.lastIndexOf(start)) < num + 1) {
                        temp.add(now_case);
                    }
                }
            }
            allCase = temp;
        }
        return allCase.size();
    }

    public static void main(String[] args) {
        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};

        System.out.println(단체사진찍기.solution(n, data));
    }
}