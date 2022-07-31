package level2;

import java.util.LinkedList;
import java.util.Queue;

public class 캐시 {

    public static int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5;

        String asd = "";
        asd.toLowerCase();
        int answer = 0;

        Queue<String> queue = new LinkedList<>();
        for (String city : cities) {
            if (queue.contains(city)) {
                answer += 1;
                queue.remove(city);
            } else {
                answer += 5;
                if (queue.size() == cacheSize) queue.poll();
            }
            queue.offer(city);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(3, 	new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
    }


}
