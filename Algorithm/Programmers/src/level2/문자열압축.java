package level2;

public class 문자열압축 {
    public static int solution(String s) {
        StringBuilder sb = new StringBuilder(s);
        int length = s.length();
        int answer = s.length();

        for (int i = 1; i <= length / 2; i++) {
            int result = length;
            for (int j = 0; j < length - i; j += i) {
                int cnt = 1;
                int index = j + i;
                String temp = sb.substring(j, j + i);
                while((index + i <= length) && temp.equals(sb.substring(index, index + i))){
                    index += i;
                    cnt++;
                }
                if(cnt != 1) {
                    j = index;
                    result = result - ((cnt - 1) * i - 1);
                }
            }
            answer = Math.min(answer, result);
        }
        return answer;
    }

    public static void main(String[] args) {
        String s = "abcabcabcabcdededededede";

        System.out.println(문자열압축.solution(s));
    }
}