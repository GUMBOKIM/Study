package practicetest;


public class test1_4 {

    static int[][] now;
    static int[][] goal;
    static int rowLength, colLength;
    static int count = 0;


    public static int solution(int[][] beginning, int[][] target) {
        rowLength = beginning.length;
        colLength = beginning[0].length;
        goal = target;
        now = beginning;

        for (int row = 0; row < rowLength; row++) {
            int before = countDiff();
            rowReverse(row);
            int after = countDiff();
            if(before > after) {
                count++;
                if(after == 0) return count;
            }
            else rowReverse(row);
        }
        for (int col = 0; col < colLength; col++) {
            int before = countDiff();
            colReverse(col);
            int after = countDiff();
            if(before > after) {
                count++;
                if(after == 0) return count;
            }
            else colReverse(col);
        }

        return -1;
    }
    static void rowReverse(int row) {
        for (int col = 0; col < colLength; col++) now[row][col] = now[row][col] == 0 ? 1 : 0;
    }

    static void colReverse(int col) {
        for (int row = 0; row < colLength; row++) now[row][col] = now[row][col] == 0 ? 1 : 0;
    }

    static int countDiff() {
        int count = 0;
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if(now[row][col] != goal[row][col]) count ++;
            }
        }
        return count;
    }


    public static void main(String[] args) {

        System.out.println(solution(
                new int[][]{
                        {0, 1, 0, 0, 0},
                        {1, 0, 1, 0, 1},
                        {0, 1, 1, 1, 0},
                        {1, 0, 1, 1, 0},
                        {0, 1, 0, 1, 0},
                },
                new int[][]{
                        {0, 0, 0, 1, 1},
                        {0, 0, 0, 0, 1},
                        {0, 0, 1, 0, 1},
                        {0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 1},
                }
        ));
    }

}
