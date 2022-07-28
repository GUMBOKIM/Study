package level2;

import java.util.ArrayList;

public class 거리두기_확인하기 {

    static String[][] map;
    static int targetRow, targetCol;
    static boolean flag;

    static int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int i = 0; i < 5; i++) answer[i] = check(places[i]);

        return answer;
    }

    static int check(String[] place) {
        map = new String[5][5];
        for (int row = 0; row < 5; row++) {
            String[] split = place[row].split("");
            for (int col = 0; col < 5; col++) map[row][col] = split[col];
        }

        ArrayList<Person> arr = new ArrayList<>();
        for (int row = 0; row < 5; row++)
            for (int col = 0; col < 5; col++)
                if (map[row][col].equals("P")) arr.add(new Person(row, col));


        flag = false;
        int size = arr.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (!flag) {
                    Person now = arr.get(i);
                    Person target = arr.get(j);
                    targetRow = target.row;
                    targetCol = target.col;
                    valid(now.row, now.col);
                }
            }
        }
        return flag ? 0 : 1;
    }

    static void valid(int nowRow, int nowCol) {
        if (!flag) {
            int rowDistance = targetRow - nowRow;
            int colDistance = targetCol - nowCol;
            if (Math.abs(rowDistance) + Math.abs(colDistance) <= 2) {
                if (rowDistance == 0 && colDistance == 0) flag = true;
                else {
                    if (rowDistance > 0 && !map[nowRow + 1][nowCol].equals("X")) valid(nowRow + 1, nowCol);
                    if (rowDistance < 0 && !map[nowRow - 1][nowCol].equals("X")) valid(nowRow - 1, nowCol);
                    if (colDistance > 0 && !map[nowRow][nowCol + 1].equals("X")) valid(nowRow, nowCol + 1);
                    if (rowDistance < 0 && !map[nowRow][nowCol - 1].equals("X")) valid(nowRow, nowCol - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        String[][] places = {};
        System.out.println(solution(places));
    }
}

class Person {
    int row;
    int col;

    public Person(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
