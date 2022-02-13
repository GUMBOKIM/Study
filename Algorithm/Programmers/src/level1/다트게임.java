package level1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 다트게임 {

    static int multi(String kind) {
        if (kind.equals("S")) return 1;
        else if (kind.equals("D")) return 2;
        else return 3;
    }

    public static int solution(String dartResult) {
        int answer = 0;

        int[] score_arr = {0, 0, 0};
        int[] multi_arr = {1, 1, 1};
        int[] bonus_arr = {1, 1, 1};

        //숫자 찾기
        Pattern pattern = Pattern.compile("([0-9]+)");
        Matcher matcher = pattern.matcher(dartResult);

        int idx = 0;
        while (matcher.find()) {
            score_arr[idx] = Integer.parseInt(matcher.group());
            idx++;
        }

        String[] split = dartResult.split("([0-9]+)");
        for (int i = 0; i < 3; i++) {
            String temp = split[i + 1];
            multi_arr[i] = multi(temp.substring(0, 1));
            if (temp.length() == 2) {
                String bonus = temp.substring(1, 2);
                if (bonus.equals("*")) {
                    if (i == 0) {
                        bonus_arr[i] *= 2;
                    } else {
                        bonus_arr[i] *= 2;
                        bonus_arr[i - 1] *= 2;
                    }
                } else {
                    bonus_arr[i] *= -1;
                }
            }
        }

        for (int i = 0; i < 3; i++) answer += Math.pow(score_arr[i], multi_arr[i]) * bonus_arr[i];

        return answer;
    }

    public static void main(String[] args) {

        String[] array_arr = {
                "1S2D*3T",
                "1D2S#10S",
                "1D2S0T",
                "1S*2T*3S",
                "1D#2S*3S",
                "1T2D3D#",
                "1D2S3T*"
        };

        for (int i = 0; i < array_arr.length; i++) {
            System.out.println(다트게임.solution(array_arr[i]));
        }
    }
}