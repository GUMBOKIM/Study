package practicetest;


import java.util.HashMap;

public class test2_2 {
    public static int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> leftMap = new HashMap<>();
        HashMap<Integer, Integer> rightMap = new HashMap<>();
        for(int select : topping) rightMap.put(select, rightMap.getOrDefault(select, 0) + 1);
        for(int i = 0; i < topping.length; i ++) {
            int select = topping[i];
            leftMap.put(select, leftMap.getOrDefault(select, 0) + 1);
            int rightCount = rightMap.get(select);
            if(rightCount == 1) rightMap.remove(select);
            else rightMap.put(select, rightCount - 1);
            if(leftMap.size() == rightMap.size()) answer ++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,1,3,1,4,1,2}));
    }

}
