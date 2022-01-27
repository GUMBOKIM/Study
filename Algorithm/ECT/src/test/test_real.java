package test;

class Node {
    String now;

}

public class test_real {

    public static void main(String[] args) {

        String[] grid = {"??b", "abc", "cc?"};

        int row = grid.length;
        int col = grid[0].length();

        String[][] map = new String[row][col];

        for (int i = 0; i<row; i++){
            map[i] = grid[i].split("");
        }

    }
/*
??b
abc
cc?
 */
}
