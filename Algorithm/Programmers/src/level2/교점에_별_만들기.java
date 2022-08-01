package level2;

import java.util.HashSet;

public class 교점에_별_만들기 {

    public static String[] solution(int[][] line) {
        HashSet<int[]> set = new HashSet<>();
        int length = line.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                int[] point = getIntersectionPoint(line[i], line[j]);
                if (point[0] != Integer.MAX_VALUE & point[0] != Integer.MAX_VALUE) set.add(point);
            }
        }

        int[] leftTop = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        int[] rightBottom = new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
        for (int[] point : set) {
            leftTop[0] = Math.min(leftTop[0], point[0]);
            leftTop[1] = Math.max(leftTop[1], point[1]);
            rightBottom[0] = Math.max(rightBottom[0], point[0]);
            rightBottom[1] = Math.min(rightBottom[1], point[1]);
        }

        int dx = rightBottom[0] - leftTop[0] + 1;
        int dy = leftTop[1] - rightBottom[1] + 1;
        int[][] result = new int[dy][dx];
        for (int[] point : set) result[leftTop[1] - point[1]][point[0] - leftTop[0]] = 1;

        String[] answer = new String[dy];
        for (int i = 0; i < dy; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < dx; j++) sb.append(result[i][j] == 0 ? '.' : '*');
            answer[i] = sb.toString();
            System.out.println(sb.toString());
        }

        return answer;
    }

    static int[] getIntersectionPoint(int[] line1, int[] line2) {
        long A = line1[0], B = line1[1], E = line1[2];
        long C = line2[0], D = line2[1], F = line2[2];
        if (A * D - B * C == 0 || (B * F - E * D) % (A * D - B * C) != 0 || (E * C - A * F) % (A * D - B * C) != 0
        ) return new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        else {
            return new int[]{(int) ((B * F - E * D) / (A * D - B * C)), (int) ((E * C - A * F) / (A * D - B * C))};
        }
    }

    public static void main(String[] args) {
        solution(new int[][]{{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}});
    }
}
