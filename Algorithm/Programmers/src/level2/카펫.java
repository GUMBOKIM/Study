package level2;

public class 카펫 {

    public static int[] solution(int brown, int yellow) {
        int total = brown + yellow;

        int height = 3;
        while(total / height >= height) {
            if(total % height == 0){
                int width = total / height;
                if((height - 2) * (width - 2) == yellow) return new int[]{width, height};
            }
            height ++;
        }

        int[] answer = {};
        return answer;
    }

    public static void main(String[] args) {
        solution(10, 2);
    }
}
