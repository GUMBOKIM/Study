package level1;

// https://programmers.co.kr/learn/courses/30/lessons/12931
public class 클라츠추측 {

    public static int solution(int num) {
        int cnt = 0;
        while(num != 1){
            cnt++;
            num = num % 2 == 0 ? num / 2 :  num * 3 + 1;
            if(cnt == 400) return -1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int num = 626331;

        System.out.println(클라츠추측.solution(num));
    }
}