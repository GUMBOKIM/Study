package level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.regex.Pattern;

public class 가장_큰수 {
    public String solution(int[] numbers) {
        String answer = "";
        int length  =numbers.length;
        String[] strArr = new String[numbers.length];
        for (int i = 0; i < length; i++) strArr[i] = String.valueOf(numbers[i]);
        Arrays.sort(strArr, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));

        if (strArr[0].equals("0")) return "0";
        for(String str : strArr) answer += str;
        return answer;
    }
}
