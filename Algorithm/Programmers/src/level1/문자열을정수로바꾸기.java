package level1;


public class 문자열을정수로바꾸기 {

    public static int solution(String s) {

        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        String[] n_r = {
                "1234","-1234"
        };

        for (int i = 0; i < 2; i++) {
            System.out.println(문자열을정수로바꾸기.solution(n_r[i]));
        }
    }
}