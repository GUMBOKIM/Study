package inflearn.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 최대수입스케쥴 {

    public static int solution(ArrayList<Income> incomes, int n, int max) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(incomes);
        for (Income income: incomes) System.out.println(income.time + " " + income.pay);

        int j = 0;
        for (int i = max; i >= 1; i--) {
            for (; j < n; j++) {
                if(incomes.get(j).time < i) break;
                pq.offer(incomes.get(j).pay);
            }
            if(!pq.isEmpty()) answer += pq.poll();
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Income> incomes = new ArrayList<>();

        int max = 0;
        for (int i = 0; i < n; i++) {
            int pay = sc.nextInt();
            int time = sc.nextInt();
            incomes.add(new Income(pay, time));
            max = Math.max(max, time);
        }
        System.out.print(solution(incomes, n, max));
    }
}

class Income implements Comparable<Income>{
    int pay;
    int time;

    public Income(int pay, int time) {
        this.pay = pay;
        this.time = time;
    }

    @Override
    public int compareTo(Income o) {
        return o.time - this.time;
    }
}
