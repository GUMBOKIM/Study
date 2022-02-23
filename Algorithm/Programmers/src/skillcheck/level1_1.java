package skillcheck;

public class level1_1 {

    static boolean solution(String s) {

        int p_cnt = 0;
        int y_cnt = 0;

        for (char c : s.toCharArray()) {
            if (c == 'p') p_cnt++;
            if (c == 'y') y_cnt++;
        }
        if(p_cnt == y_cnt) return true;
        else return false;
    }

    public static void main(String[] args) {
        System.out.println(solution("pPoooyY"));
        System.out.println(solution("Pyy"));
    }
}
