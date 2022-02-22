package level2;

public class 일이사나라의숫자 {

    public static int conversion(int n) {
        if (n == 0) return 1;
        else if (n == 1) return 2;
        else return 4;
    }

    public static String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int remain = 0;
        while (0 < n) {
            remain = n % 3;

            if (0 == remain) {
                n = n / 3 - 1;
                remain = 4;
            } else n /= 3;
            sb.insert(0, remain);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(일이사나라의숫자.solution(n));
    }
}