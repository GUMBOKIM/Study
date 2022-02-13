package level1;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class 문2016년 {

    public static String solution(int a, int b) {
        DayOfWeek dayOfWeek = LocalDate.of(2016, a, b).getDayOfWeek();
        return dayOfWeek.name().substring(0,3);
    }

    public static void main(String[] args) {
        int[] a_arr = {
                5
        };

        int[] b_arr = {
                24
        };

        for (int i = 0; i < 1; i++) {
            System.out.println(문2016년.solution(a_arr[i], b_arr[i]));
        }
    }
}