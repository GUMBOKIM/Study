package highscorekit.dp;

public class ExpressN {

    static int solution(int N, int number) {
        if(number > 11111111 * N) return -1;
        int answer = 0;

        return answer;
    }

    public static void main(String[] args) {
        int result = solution(5, 12);
        System.out.println("result = " + result);
        result = solution(2, 11);
        System.out.println("result = " + result);
    }
}
