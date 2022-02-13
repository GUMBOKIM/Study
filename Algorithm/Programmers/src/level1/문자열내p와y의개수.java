package level1;

import java.util.*;

public class 문자열내p와y의개수 {

    public static boolean solution(String s) {
        int p_cnt = 0;
        int y_cnt = 0;
//        for (String str : s.split("")) {
//            if (str.equalsIgnoreCase("p")) p_cnt++;
//            if (str.equalsIgnoreCase("y")) y_cnt++;
//        }

//        s.toLowerCase();
//        for (String str : s.split("")) {
//            if (str.equals("p")) p_cnt++;
//            if (str.equals("y")) y_cnt++;
//        }


        if(p_cnt == 0 && y_cnt == 0) return true;
        return p_cnt == y_cnt ? true : false;
    }

    public static void main(String[] args) {
        String[] s_arr = {
                "pPoooyY",
                "Pyy"
        };


        for (int i = 0; i < 2; i++) System.out.println(문자열내p와y의개수.solution(s_arr[i]));
    }
}