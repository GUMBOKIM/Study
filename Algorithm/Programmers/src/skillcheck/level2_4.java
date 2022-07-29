package skillcheck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class level2_4 {
    public static int solution(int[][] routes) {
        ArrayList<Path> paths = new ArrayList<>();
        for (int[] route : routes) paths.add(new Path(route[0], route[1]));
        Collections.sort(paths);
        System.out.println("paths = " + paths);

        int start = paths.get(0).start + 1;
        int end = paths.get(0).end - 1;

        int answer = 0;
        for (Path path : paths) {
            if(path.start >= end) {
               answer++;
               start = path.start;
               end = path.end;
            } else {
                if (start > path.start) start = path.start;
                if (end < path.end) end = path.end;
            }

        }
        return answer + 1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}}));
    }
}

class Path implements Comparable<Path> {
    int start;
    int end;

    public Path(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Path path) {
        if (this.start == path.start) return this.end - path.end;
        else return this.start - path.start;
    }

    @Override
    public String toString() {
        return this.start + " " + this.end;
    }
}
