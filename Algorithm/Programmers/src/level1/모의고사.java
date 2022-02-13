package level1;

public class 모의고사 {


    public static int[] solution(int[] answers) {
        int[][] students_answer = {
                {1, 2, 3, 4, 5, 1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] students_score = new int[3];
        for (int i = 0; i < 3; i++) {
            int[] student_answer = students_answer[i];
            int length = student_answer.length;

            int count = 0;
            for (int j = 0; j < answers.length; j++) {
                if(answers[j] == student_answer[j%length]) count++;
            }
            students_score[i] = count;
        }

        int max = 0;
        for (int i = 0; i < 3; i++) if(max < students_score[i]) max = students_score[i];

        int max_cnt = 0;
        int[] answer_temp = new int[3];
        for (int i = 0; i < 3; i++) {
            if(max == students_score[i]){
                answer_temp[max_cnt] = i + 1;
                max_cnt ++;
            }
        }

        int[] answer = new int[max_cnt];
        for (int i = 0; i < max_cnt; i++) {
            answer[i] = answer_temp[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] answer_arr = {{1, 2, 3, 4, 5}, {1, 3, 2, 4, 2}};

        for (int i = 0; i < 2; i++) {
            System.out.println(모의고사.solution(answer_arr[i]));
        }
    }
}