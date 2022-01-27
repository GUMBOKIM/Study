package test;

public class test_기출3 {

    static String[] grid;
    static int layer_max;
    static int dir;
    static int x;
    static int y;
    static char now_color;

    static int recursive(int i) {
        if (x < 0 || x >= 2 * y || y >= layer_max || y < 0) {
            return i;
        }
        if (now_color == 'B') {
            rotate_B();
        } else if (now_color == 'R') {
            rotate_R();
        }
        now_color = grid[x].charAt(y);
        return recursive(i + 1);
    }

    // MOVE :  L x-1, R x+1, U y-1, D y+1
    static void move(char kind) {
        if (kind == 'L') {  //L
            x -= 1;
        } else if (kind == 'R') { // R
            x += 1;
        } else if (kind == 'U') { // U
            y -= 1;
        } else if (kind == 'D') { // D
            y += 1;
        }
    }

    // R : 12 -> 8 D / 2 -> 10 L / 4 -> 12 U / 6 -> 2 R / 8 -> 4 R / 10 -> 6 D
    static void rotate_R() {
        if (dir == 12) {
            dir = 8;
            move('D');
        } else if (dir == 2) {
            dir = 10;
            move('L');
        } else if (dir == 4) {
            dir = 12;
            move('U');
        } else if (dir == 6) {
            dir = 2;
            move('R');
        } else if (dir == 8) {
            dir = 4;
            move('R');
        } else if (dir == 10) {
            dir = 6;
            move('D');
        }
    }

    // B : 12 -> 4  / 2 -> 6 D / 4 -> 8 / 6 -> 10 / 8 -> 12 / 10 -> 2
    static void rotate_B() {
        if (dir == 12) {
            dir = 4;
            move('R');
        } else if (dir == 2) {
            dir = 6;
            move('D');
        } else if (dir == 4) {
            dir = 8;
            move('R');
        } else if (dir == 6) {
            dir = 10;
            move('L');
        } else if (dir == 8) {
            dir = 12;
            move('U');
        } else if (dir == 10) {
            dir = 2;
            move('R');
        }
    }

    public static void main(String[] args) {
        grid = new String[]{"B", "RRB"};
//        String[] grid = {"R", "BBB", "RBRBR"};
//        String[] grid = {"R", "RRR", "RBBBB", "BRRRBRR"};

        layer_max = grid.length - 1;

        for(int i = 0; i <= layer_max; i++){
            x = 0;
            y = i;
            dir = 10;
            System.out.println(recursive(1));
        }

        for(int i = 0; i<= layer_max; i++){
            x = 2 * i;
            y = i;
            dir = 2;
            System.out.println(recursive(1));
        }

        for(int i = 0; i < 2 * layer_max; i++){
            x = i;
            y = layer_max - 1;
            dir = 6;
            System.out.println(recursive(1));
        }

    }

}
//
//    /\
// a /  \ b
//   ____
//    c