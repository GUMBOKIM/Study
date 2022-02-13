package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 실패율 {
    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] visit = new int[N + 2];
        int[] clear = new int[N + 2];
        for (int stage : stages) {
            for (int step = 1; step <= stage; step++) {
                visit[step]++;
                if(step != stage) clear[step]++;
            }

        }

        List<Stage> stage_list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            double fail = 0;
            if(visit[i] != 0) fail = (double) (visit[i] - clear[i]) / (double) visit[i];
            stage_list.add(new Stage(i, fail));
        }

        stage_list.forEach(stage -> System.out.println(stage.level + " " + stage.fail));
        stage_list.sort(new Comparator<Stage>() {
            @Override
            public int compare(Stage o1, Stage o2) {
                if(o1.fail == o2.fail){
                    return o1.level - o2.level;
                } else {
                    if(o1.fail > o2.fail) return -1;
                    else return 1;
                }
            }
        });

        int idx = 0;
        for (Stage stage: stage_list) {
            answer[idx] = stage.level;
            idx ++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] n_arr = {
                5, 4
        };
        int[][] stages_arr = {
                {2, 1, 2, 6, 2, 4, 3, 3},
                {4, 4, 4, 4, 4}
        };


        for (int i = 0; i < 2; i++) {
            System.out.println(Arrays.toString(실패율.solution(n_arr[i], stages_arr[i])));
        }
    }
}

class Stage {
    int level;
    double fail;

    public Stage(int level, double fail) {
        this.level = level;
        this.fail = fail;
    }
}