package level2;

public class 모음_사전 {
    public static int solution(String word) {
        int answer = 0, per = 3905;
        for(String s : word.split("")) answer += "AEIOU".indexOf(s) * (per /= 5) + 1;
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("AAAAE"));
    }
}
