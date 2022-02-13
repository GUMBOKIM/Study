package level1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 다트게임 {

    static int powConvert(String kind) {
        if (kind.equals("S")) return 1;
        else if (kind.equals("D")) return 2;
        else return 3;
    }

    static int prizeConvert(String kind) {
        if (kind.equals("*")) return 2;
        else if (kind.equals("#")) return -1;
        else return 1;
    }

    public static int solution(String dartResult) {
        int answer = 0;

        int[] score_arr = new int[3];
        int[] pow_arr =  new int[3];
        int[] prize_arr =  new int[3];

        //숫자 찾기
        Pattern pattern = Pattern.compile("([0-9]+)([SDT])([*#]?)");
        Matcher matcher = pattern.matcher(dartResult);
        int idx = 0;
        while (matcher.find()) {
            score_arr[idx] = Integer.parseInt(matcher.group(1));
            pow_arr[idx] = powConvert(matcher.group(2));
            int prize_bonus = prizeConvert(matcher.group(3));
            prize_arr[idx] = prize_bonus;
            if(prize_bonus == 2 && idx != 0){
                prize_arr[idx - 1] *= 2;
            }
            idx++;
        }

        for (int i = 0; i < 3; i++) answer += Math.pow(score_arr[i], pow_arr[i]) * prize_arr[i];
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