package inflearn.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 가장_높은_탑_쌓기 {

    public static int solution(int n, ArrayList<Brick> arr) {
        int answer = 0;
        Collections.sort(arr);
        int[] dy = new int[n];
        dy[0] = arr.get(0).height;
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr.get(j).weight > arr.get(i).weight && dy[j] > max) {
                    max = dy[j];
                }
                dy[i] = max + arr.get(i).height;
                answer = Math.max(answer, dy[i]);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Brick> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) arr.add(new Brick(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        System.out.print(solution(n, arr));
    }
}

class Brick implements Comparable<Brick>{
    int area;
    int height;
    int weight;

    Brick(int area, int height, int weight) {
        this.area = area;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Brick o) {
        return o.area - this.area;
    }
}
