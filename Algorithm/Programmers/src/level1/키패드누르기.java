package level1;

public class 키패드누르기 {

    static StringBuilder sb = new StringBuilder();
    static int[][] location = {{1, 0}, {0, 3}, {1, 3}, {2, 3}, {0, 2}, {1, 2}, {2, 2}, {0, 1}, {1, 1}, {2, 1}};
    static int now_num;
    static int[] left_loc = {0, 0};
    static int[] right_loc = {2, 0};

    static void left_click() {
        left_loc = location[now_num].clone();
        sb.append("L");
    }

    static void right_click() {
        right_loc = location[now_num].clone();
        sb.append("R");
    }

    static int calculate_dist(int[] hand_loc, int[] num_loc) {
        return Math.abs(hand_loc[0] - num_loc[0]) + Math.abs(hand_loc[1] - num_loc[1]);
    }

    public static String solution(int[] numbers, String hand) {
        boolean flag = hand.equals("right"); // 왼쪽이면 false, 오른쪽이면 true;

        for (int number : numbers) {
            now_num = number + 0;
            if (number == 1 || number == 4 || number == 7) {
                left_click();
            } else if (number == 3 || number == 6 || number == 9) {
                right_click();
            } else {
                int left_dist = calculate_dist(left_loc, location[number]);
                int right_dist = calculate_dist(right_loc, location[number]);
                if (left_dist < right_dist) {
                    left_click();
                } else if (left_dist > right_dist) {
                    right_click();
                } else {
                    if (flag) {
                        right_click();
                    } else {
                        left_click();
                    }
                }
            }
        }

        return sb.toString();
        }

public static void main(String[]args){
        int[][]numbers_arr={
        {1,3,4,5,8,2,1,4,5,9,5},
        {7,0,8,2,8,3,1,5,7,6,2},
        {1,2,3,4,5,6,7,8,9,0},
        };
        String[]hand_arr={
        "right",
        "left",
        "right"
        };

        for(int i=1;i< 2;i++){
        System.out.println(키패드누르기.solution(numbers_arr[i],hand_arr[i]));
        sb=new StringBuilder();
        }
        }
        }