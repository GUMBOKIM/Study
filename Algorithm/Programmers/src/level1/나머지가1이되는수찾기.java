package level1;

public class 나머지가1이되는수찾기 {

    public static int solution(int n) {
        int answer = 1;
        while(true){
            answer++;
            if(n % answer == 1) return answer;
        }
    }

    public static void main(String[] args) {
        int[] n_arr = {
                10, 12
        };


        for (int i = 0; i < 1; i++) {
            System.out.println(나머지가1이되는수찾기.solution(n_arr[i]));
        }
    }
}