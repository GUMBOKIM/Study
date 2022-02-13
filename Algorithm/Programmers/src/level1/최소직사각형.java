package level1;

import java.util.Arrays;

public class 최소직사각형 {

    public static int solution(int[][] sizes) {
        int w_max = 0;
        int h_max = 0;
        for(int[] size : sizes){
            int w;
            int h;
            if(size[0] >= size[1]){
                w = size[0];
                h = size[1];
            } else {
                w = size[1];
                h = size[0];
            }
            if(w > w_max) w_max = w;
            if(h > h_max) h_max = h;
        }
        return w_max * h_max;
    }

    public static void main(String[] args) {
        int[][][] sizes_arr = {
                {{60, 50}, {30, 70}, {60, 30}, {80, 40}},
                {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}},
                {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}}
        };

        for (int i = 0; i < 3; i++) {
            System.out.println(최소직사각형.solution(sizes_arr[i]));
        }
    }
}