package inflearn.map_set;

import java.util.HashMap;
import java.util.Scanner;

public class 학급회장_해쉬 {


    public static char solution(String list) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char element: list.toCharArray()) {
          hashMap.put(element, hashMap.getOrDefault(element, 0) + 1);
        }

        char answer = ' ';
        int max = 0;

       for(char key : hashMap.keySet()) {
           if(hashMap.get(key) > max) {
               max = hashMap.get(key);
               answer = key;
           }
       }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        String list = sc.next();
        System.out.print(solution(list));
    }
}
