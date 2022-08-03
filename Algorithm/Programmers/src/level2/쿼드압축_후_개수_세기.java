package level2;


import java.util.Arrays;

public class 쿼드압축_후_개수_세기 {
    public static int[] solution(int[][] arr) {
        return quadComp(arr);
    }

    public static int[] quadComp(int[][] arr) {
        int length = arr.length;

        int first = arr[0][0];
        boolean flag = true;
        for (int row = 0; row < length; row++) {
            if(!flag) break;
            for (int col = 0; col < length; col++) {
                if(arr[row][col] != first){
                    flag = false;
                    break;
                }
            }
        }

        if (flag) return first == 0 ? new int[]{1, 0} : new int[]{0, 1};
        else {
            int[] answer = new int[2];
            for (int[][] dividedArr: divide(arr)) {
                int[] result = quadComp(dividedArr);
                answer[0] += result[0];
                answer[1] += result[1];
            }
            return answer;
        }
    }

    public static int[][][] divide(int[][] arr) {
        int half = arr.length / 2;
        int[][][] divideArr = new int[4][half][half];
        int[][] areas = new int[][]{{0, 0}, {0, half}, {half, 0}, {half, half}};
        for (int i = 0; i < 4; i++) {
            int[] area = areas[i];
            for (int j = 0; j < half; j++) {
                for (int k = 0; k < half; k++) {
                    divideArr[i][j][k] = arr[j + area[0]][k + area[1]];
                }
            }
        }
        return divideArr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}})));
    }
}
