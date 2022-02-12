package level1;

public class 숫자문자열과영단어 {

    public static int solution(String s) {
        String[] num_arr = {"0","1","2","3","4","5","6","7","8","9"};
        String[] string_arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < 10; i++) {
            s = s.replace(string_arr[i], num_arr[i]);
        }
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        String[] s_arr = {"one4seveneight", "23four5six7", "2three45sixseven", "123"};

        for (String s : s_arr) {
            System.out.println(숫자문자열과영단어.solution(s));
        }
    }
}