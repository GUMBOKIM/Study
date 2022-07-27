package inflearn.greedy;

import java.util.*;

public class 회의실배정 {

    public static int solution(ArrayList<Meeting> meetings) {
        int answer = 0;
        Collections.sort(meetings);
        int endTime = 0;

        for (Meeting meeting: meetings) {
            if(meeting.start >= endTime) {
                answer ++;
                endTime = meeting.end;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Meeting> meetings = new ArrayList<>();

        for (int i = 0; i < n; i++) meetings.add(new Meeting(sc.nextInt(), sc.nextInt()));
        System.out.print(solution(meetings));
    }
}

class Meeting implements Comparable<Meeting> {
    int start;
    int end;

    public Meeting(int height, int weight) {
        this.start = height;
        this.end = weight;
    }

    @Override
    public int compareTo(Meeting o) {
        if(this.end == o.end) return this.start - o.start;
        return this.end - o.end;
    }
}
