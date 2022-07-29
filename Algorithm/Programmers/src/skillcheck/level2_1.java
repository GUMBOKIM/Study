package skillcheck;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class level2_1 {

    class Solution {
        public int solution(int[] priorities, int location) {
            // 0 - Q생성
            Queue<Print> priorityQ = new LinkedList<>();
            for(int i = 0; i < priorities.length; i++) priorityQ.offer(new Print(priorities[i],i));

            // 1
            int answer = 0;
            while(!priorityQ.isEmpty()){
                Print print = priorityQ.poll();
                // 2
                if(hasHigher(print, priorityQ)) {
                    priorityQ.offer(print);
                    // 3
                } else {

                    answer ++;
                    if(print.location == location) return answer;
                }
            }
            return answer;
        }

        static boolean hasHigher(Print print, Queue<Print> priorityQ) {
            for (Print select : priorityQ) {
                if(select.priority > print.priority) return true;
            }
            return false;
        }
    }

    class Print{
        int priority;
        int location;

        Print(int priority, int location) {
            this.priority = priority;
            this.location = location;
        }
    }
}
