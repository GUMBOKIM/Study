package level1;

import java.util.HashMap;

public class 완주하지못한선수 {

    public static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> name_map = new HashMap<>();
        for (String name: participant){
            if(name_map.containsKey(name)) name_map.put(name, name_map.get(name) + 1);
            else name_map.put(name, 1);
        }
        for (String name: completion) {
            if(name_map.containsKey(name)){
                int cnt = name_map.get(name);
                if(cnt == 1) name_map.remove(name);
                else name_map.put(name, cnt - 1);
            }
        }
        return name_map.keySet().toArray(new String[1])[0];
    }

    public static void main(String[] args) {
        String[][] participant_arr = {
                {"leo", "kiki", "eden"},
                {"marina", "josipa", "nikola", "vinko", "filipa"},
                {"mislav", "stanko", "mislav", "ana"}
        };

        String[][] completion_arr = {
                {"eden", "kiki"},
                {"josipa", "filipa", "marina", "nikola"},
                {"stanko", "ana", "mislav"}
        };

        for (int i = 0; i < 2; i++) {
            System.out.println(완주하지못한선수.solution(participant_arr[i], completion_arr[i]));
        }
    }
}