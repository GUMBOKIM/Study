package level1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class 신고결과받기 {

    private static int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, Set<String>> id_report = new HashMap<>();
        HashMap<String, Integer> report_result = new HashMap<>();

        for (String id : id_list) {
            id_report.put(id, new HashSet<>());
            report_result.put(id, 0);
        }

        for (String str : report) {
            String[] str_split = str.split(" ");
            String name = str_split[0];
            String target_name = str_split[1];
            Set<String> targets = id_report.get(name);
            if(!targets.contains(target_name)) {
                targets.add(target_name);
                Integer count = report_result.get(target_name) + 1;
                report_result.put(target_name, count);
            }
        }

        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            String name = id_list[i];
            int count = 0;
            Set<String> targets = id_report.get(name);
            for (String target : targets) if (report_result.get(target) >= k) count ++;
            answer[i] = count;
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

        신고결과받기.solution(id_list, report, k);
    }
}