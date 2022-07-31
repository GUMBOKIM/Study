import java.util.Scanner;

public class Template {
    public static String solution(String number, int k) {
        String answer = "";
        int index = 0;
        while(true) {
        int max = 0;
        int maxIndex = 0;
        for (int i = index; i <= k + index; i++) {
            int now = Character.getNumericValue(number.charAt(i));
            if (now > max) {
                max = now;
                maxIndex = i;
            }
        }
        // k = 3 index = 0 maxIndex = 3
        // move = 2;

        String front = number.substring(0, index);
        String back = number.substring(maxIndex);
        number = front + back;

        int move = maxIndex - index;
        k -= move;
        index++;
        if(k == 0) break;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("1231234", 3));
    }
}
