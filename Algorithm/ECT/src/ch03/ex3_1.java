package ch03;

public class ex3_1 {

    public static void main(String[] args) {
        int total = 1260;
        int coin = 0;
        int[] coinKind = {500, 100, 50, 10};
        for (int nowCoin : coinKind) {
            int x = total/nowCoin;
            total -= x * nowCoin;
            coin += x;
            if(total == 0) break;
        }
        System.out.println(coin);
    }
}
