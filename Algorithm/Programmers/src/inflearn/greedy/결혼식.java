package inflearn.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 결혼식 {

    public static int solution(ArrayList<피로연> 피로연s) {
        Collections.sort(피로연s);
        int answer = Integer.MIN_VALUE;
        int cnt = 0;
        for(피로연 element : 피로연s) {
            if(element.state == 's') cnt ++;
            else cnt --;
            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<피로연> 피로연s = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            피로연s.add(new 피로연(sc.nextInt(), 's'));
            피로연s.add(new 피로연(sc.nextInt(), 'e'));

        }
        System.out.print(solution(피로연s));
    }
}

class 피로연 implements Comparable<피로연>{
    int time;
    char state;

    public 피로연(int time, char state) {
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(피로연 o) {
        if(this.time == o.time) return this.state - o.state;
        else return this.time - o.time;
    }
}
