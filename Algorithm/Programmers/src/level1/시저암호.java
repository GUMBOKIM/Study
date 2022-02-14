package level1;


public class 시저암호 {

    public static String solution(String s, int n){
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if(c != ' '){
                int temp = c + n;
                if(c < 91){
                    chars[i] = temp > 90 ? (char) (temp - 26) : (char) temp;
                } else {
                    chars[i] = temp > 122 ? (char) (temp - 26) : (char) temp;
                }
            }
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        char a = 'a';
        System.out.println((int) 'A');
        System.out.println((int) 'Z');
        System.out.println((int) 'a');
        System.out.println((int) 'z');
        String[] s_r = {
                "AB","z", "a B z"
        };
        int[] n_r = {
                1,1,4
        };

        for (int i = 0; i < 3; i++) {
            System.out.println(시저암호.solution(s_r[i],n_r[i]));
        }
    }
}