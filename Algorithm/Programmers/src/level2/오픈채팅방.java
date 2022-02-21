package level2;

import java.util.Arrays;
import java.util.HashMap;

public class 오픈채팅방 {

    public static String[] solution(String[] record) {
        HashMap<String, String> hashMap = new HashMap<>();
        int changeCnt = 0;
        for (String s : record) {
            String[] s_arr = s.split(" ");
            if (s_arr[0].equals("Enter"))
                hashMap.put(s_arr[1], s_arr[2]);
            else if (s_arr[0].equals("Change")) {
                hashMap.put(s_arr[1], s_arr[2]);
                changeCnt++;
            }
        }
        String[] answer = new String[record.length - changeCnt];
        int idx = 0;
        for (String s : record) {
            String[] s_arr = s.split(" ");
            if (!s_arr[0].equals("Change")) {
                answer[idx] = s_arr[0].equals("Enter") ?
                        hashMap.get(s_arr[1]) + "님이 들어왔습니다." : hashMap.get(s_arr[1]) + "님이 나갔습니다.";
                idx++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};

        System.out.println(Arrays.toString(오픈채팅방.solution(record)));
    }
}