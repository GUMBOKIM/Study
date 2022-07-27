package inflearn.greedy;

import java.util.*;

public class 씨름_선수 {

    public static int solution(Player[] players) {
        Arrays.sort(players, (a1, a2) -> a2.height - a1.height != 0 ? a2.height - a1.height : a2.weight - a1.weight);
        int answer = 0;
        int max = Integer.MIN_VALUE;
        for (Player player: players) {
            if(player.weight > max) {
                max= player.weight;
                answer ++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Player[] players = new Player[n];

        for (int i = 0; i < n; i++) players[i] = new Player(sc.nextInt(), sc.nextInt());
        System.out.print(solution(players));
    }
}

class Player implements Comparable<Player> {
    int height;
    int weight;

    public Player(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Player o) {
        return o.height - this.height;
    }
}
