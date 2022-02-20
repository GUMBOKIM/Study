package level1;

public class 이상한문자만들기 {

    public static String solution(String s) {
        System.out.println("s = " + s);
        int index = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char now_char = s.charAt(i);
            boolean now_space = Character.isWhitespace(now_char);
            if (!now_space) {
                index++;
                now_char = index % 2 == 1 ? Character.toUpperCase(now_char) : Character.toLowerCase(now_char);
            } else {
                index = 0;
            }
            sb.append(now_char);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "  tryaa   helloaa   worldaa";

        System.out.println("이상한문자만들기.solution(s) = " + 이상한문자만들기.solution(s));
    }
}