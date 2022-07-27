package inflearn.DFSBFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 피재배달거리 {

    static int n, m;
    static int[] check;
    static ArrayList<Location> stores = new ArrayList<>();
    static ArrayList<Location> houses = new ArrayList<>();
    static int storesLength, housesLength;
    static int answer = Integer.MAX_VALUE;

    static void DFS(int L, int last) {
        if (L == m) {
            int sum = calculateDistance();
            answer = Math.min(answer, sum);
            return;
        }

        for (int i = last + 1; i < storesLength; i++) {
            if(check[i] == 0) {
                check[i] = 1;
                DFS(L + 1, i);
                check[i] = 0;
            }
        }


    }

    public static int calculateDistance() {
        int sum = 0;
        for (int i = 0; i < housesLength; i++) {
            Location house = houses.get(i);
            int min = Integer.MAX_VALUE;
            for (int y = 0; y < storesLength; y++) {
                if(check[y] == 1) {
                    Location store = stores.get(y);
                    min = Math.min(min, Math.abs(house.x - store.x) + Math.abs(house.y - store.y));
                }
            }
            sum += min;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                int input = sc.nextInt();
                if (input == 1) houses.add(new Location(x, y));
                if (input == 2) stores.add(new Location(x, y));
            }
        }

        storesLength = stores.size();
        housesLength = houses.size();

        check = new int[storesLength];
        DFS(0,  -1);
        System.out.println(answer);
    }
}

class Location {
    int x, y;

    Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
