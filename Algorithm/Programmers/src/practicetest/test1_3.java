package practicetest;


import java.util.Stack;

public class test1_3 {

    public static int solution(int[] order) {
        int answer = 0;
        int parcel = 1;
        Stack<Integer> subContainer = new Stack<>();

        while (parcel < order.length + 1) {
            // 물건 받기
            if (order[answer] == parcel) {
                answer++;
            } else {
                subContainer.push(parcel);
            }
            parcel++;

            // 서브컨테이너 체크
            while(!subContainer.isEmpty()) {
                if(order[answer] != subContainer.peek()) break;
                subContainer.pop();
                answer ++;
            }
            System.out.println(subContainer);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{5, 4, 3, 2, 1}));
    }
}
