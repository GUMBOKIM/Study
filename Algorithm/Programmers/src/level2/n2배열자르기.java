package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class n2배열자르기 {
//    public static int[] solution(int n, long left, long right) {
//        int[] answer = new int[(int) (right - left + 1)];
//
//        int index = 0;
//        int startRow = (int) (left / (long) n);
//        int startCol = (int) (left % (long) n);
//        int endRow = (int) (right / (long) n);
//        int endCol = (int) (right % (long) n);
////        System.out.println("startRow = " + startRow);
////        System.out.println("startCol = " + startCol);
////        System.out.println("endRow = " + endRow);
////        System.out.println("endCol = " + endCol);
//
//        // 시작 맨윗부분
//        int[] tempArray = createArray(n, startRow);
//        for (int col = startCol; col < n; col++) {
//            answer[index] = tempArray[col];
//            index++;
//        }
//        // 중간 부분
//        for (int row = startRow + 1; row < endRow; row++) {
//            tempArray = createArray(n, row);
//            for (int now: tempArray) {
//                answer[index] = now;
//                index ++;
//            }
//        }
//        // 마지막 아랫부분
//        tempArray = createArray(n, endRow);
//        for (int col = 0; col <= endCol; col++) {
//            answer[index] = tempArray[col];
//            index++;
//        }
//        return answer;
//    }
//
//    static int[] createArray(int n, int row){
//        int[] result = new int[n];
//        for (int i = 0; i < n; i++) result[i] = Math.max(i + 1, row + 1);
////        System.out.println(Arrays.toString(result));
//        return result;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(3, 2, 5)));
//    }

    public List<Long> solution(int n, long left, long right) {

        List<Long> list = new ArrayList<>();

        for(long i=left;i<right+1;i++){
            list.add(Math.max(i/n,i%n) + 1);
        }

        return list;
    }
}