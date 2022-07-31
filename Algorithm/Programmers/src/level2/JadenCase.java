package level2;

import java.util.Arrays;

public class JadenCase {

    public static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] split = s.split("\s+");
        for (int i = 0; i < split.length; i++) {
            String string = split[i];
            sb.append(string.substring(0, 1).toUpperCase());
            if (string.length() > 1) sb.append(string.substring(1).toLowerCase());
            if (i != split.length - 1) sb.append(' ');
        }
        return sb.toString();
    }

    public String solution2(String s) {

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(i == 0){
                sb.append(Character.toUpperCase(s.charAt(i)));
            }else{
                if(s.charAt(i-1) == ' '){
                    sb.append(Character.toUpperCase(s.charAt(i)));
                }else{
                    sb.append(Character.toLowerCase(s.charAt(i)));
                }
            }
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(solution("3people unFollowed me"));
    }
}
