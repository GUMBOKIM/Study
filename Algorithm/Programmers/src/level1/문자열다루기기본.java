package level1;

public class 문자열다루기기본 {

    public static boolean solution(String s) {
        int length = s.length();
        if(length == 4 || length == 6) if(s.replaceAll("[0-9]", "").equals("")) return  true;
        return false;
    }

    public static void main(String[] args) {
        String[] s_arr = {
                "a234",
                "1234"
        };


        for (int i = 0; i < 2; i++) System.out.println(문자열다루기기본.solution(s_arr[i]));
    }
}