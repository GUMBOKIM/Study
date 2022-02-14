package level1;


public class 핸드폰번호가리기 {

    public static String solution(String phone_number) {
        int split = phone_number.length() - 4;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split; i++) sb.append("*");
        sb.append(phone_number.substring(split));
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] n_r = {
                "01033334444","027778888"
        };

        for (int i = 0; i < 2; i++) {
            System.out.println(핸드폰번호가리기.solution(n_r[i]));
        }
    }
}