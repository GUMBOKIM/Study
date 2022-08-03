package level2;

import java.util.ArrayList;
import java.util.List;

public class 방문길이 {

    static List<Road> roadList = new ArrayList<>();

    public static int solution(String dirs) {

        Point nowPoint = new Point(0 , 0);
        for (char direction: dirs.toCharArray()) {
            Point afterPoint = move(nowPoint, direction);
            if(afterPoint.isCorrectLocation() && !afterPoint.isEqualTo(nowPoint)) {
                    Road newRoad = new Road(nowPoint, afterPoint);
                    if(!isDuplicate(newRoad))roadList.add(newRoad);
                    nowPoint = afterPoint;
            }
        }
        return roadList.size();
    }

    public static Point move(Point nowPoint, char direction) {
        int x = nowPoint.x;
        int y = nowPoint.y;

        switch (direction){
            case 'U':
                y ++;
                break;
            case 'D':
                y --;
                break;
            case 'R':
                x ++;
                break;
            case 'L':
                x --;
                break;
        }

        return new Point(x, y);
    }

    public static boolean isDuplicate(Road road){
        for (Road select: roadList) if(select.isEqualTo(road)) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU"));
    }
}

class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isCorrectLocation(){
        return this.x >= -5 && this.x <= 5 && this.y >= -5 && this.y <= 5;
    }

    public boolean isEqualTo(Point point){
        return this.x == point.x && this.y == point.y;
    }

    public Point copy(){
        return new Point(this.x, this.y);
    }
}

class Road {
    Point start;
    Point end;

    public Road(Point start, Point end) {
        this.start = start.copy();
        this.end = end.copy();
    }

    public boolean isEqualTo(Road road){
        return (this.start.isEqualTo(road.start) && this.end.isEqualTo(road.end))
                || (this.start.isEqualTo(road.end) && this.end.isEqualTo(road.start));
    }
}