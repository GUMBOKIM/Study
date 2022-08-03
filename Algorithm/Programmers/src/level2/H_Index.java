package level2;

import java.util.Arrays;

public class H_Index {
    public static int solution(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int h = citations.length - i;
            if(citations[i] >= h){
                answer = h;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 0, 6, 1, 5}));
    }
}
