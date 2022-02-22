package level2;

public class 멀쩡한사각형 {

    public static long solution(int w, int h) {
        long count = 0;
        for (int x = 0; x < w; x++) count += Math.ceil((double) h * (x + 1) / w) - Math.floor((double) h * x / w);
        return (long) h * w - count;
    }

    public static void main(String[] args) {
        int w = 10;
        int h = 10;

        System.out.println(멀쩡한사각형.solution(w, h));
    }
}