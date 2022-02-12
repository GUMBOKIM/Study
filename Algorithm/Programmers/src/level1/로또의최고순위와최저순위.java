package level1;

import java.util.HashSet;
import java.util.Set;

public class 로또의최고순위와최저순위 {

    static int rank(int i){
        switch (i) {
            case 6 :
                return 1;
            case 5 :
                return 2;
            case 4 :
                return 3;
            case 3 :
                return 4;
            case 2 :
                return 5;
            default:
                return 6;
        }
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        Set<Integer> win_set = new HashSet<>();
        for (int num : win_nums) {
            win_set.add(num);
        }

        int find = 0;
        int unknown = 0;
        for (int num : lottos) {
            if (num == 0) unknown++;
            else if (win_set.contains(num)) find++;
        }

        return new int[]{rank(find + unknown), rank(find)};
    }

    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};

        로또의최고순위와최저순위.solution(lottos, win_nums);
    }
}