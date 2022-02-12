package level1;

public class 없는숫자더하기 {

    public static int solution(int[] numbers) {
        int answer = 45;
        for (int number : numbers) answer -= number;
        return answer;
    }

    public static void main(String[] args) {
        int[][] numbers_arr = {{1, 2, 3, 4, 6, 7, 8, 0}, {5, 8, 4, 0, 6, 7, 9}};
        for (int[] numbers : numbers_arr) {
            System.out.println(없는숫자더하기.solution(numbers));
        }
    }
}