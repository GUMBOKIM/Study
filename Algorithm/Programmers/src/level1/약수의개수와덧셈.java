package level1;

public class 약수의개수와덧셈 {

    public static int solution(int left, int right) {
        int answer = 0;
        for (int now = left; now <= right; now++) {
            Double root = Math.sqrt(now);
            if(root != Math.floor(root)) answer += now;
            else answer -= now;
        }
        System.out.println("answer = " + answer);
        return answer;
    }

    public static void main(String[] args) {
        int[] left_arr = {13, 24};
        int[] right_arr = {17, 27};

        for (int i = 0; i < 2; i++) {
            System.out.println(약수의개수와덧셈.solution(left_arr[i], right_arr[i]));
        }
    }
}