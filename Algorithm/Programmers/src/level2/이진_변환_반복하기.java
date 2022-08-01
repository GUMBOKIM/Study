package level2;

public class 이진_변환_반복하기 {

    public static int[] solution(String s) {
        return recursive(0, 0, s);
    }

    public static int[] recursive(int level, int count, String before) {
        if(before.equals("1")) return new int[]{level, count};
        String after = before.replace("0", "");
        return recursive(level + 1, count + (before.length() - after.length()), Integer.toBinaryString(after.length()));
    }

    public static void main(String[] args) {
        int[] solution = solution("110010101001");
        System.out.println(solution[0] + " " + solution[1]);
    }
}
