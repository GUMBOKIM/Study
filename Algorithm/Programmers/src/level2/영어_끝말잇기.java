package level2;

import java.util.Arrays;
import java.util.HashSet;

public class 영어_끝말잇기 {
    public static int[] solution(int n, String[] words) {
        HashSet<String> set = new HashSet<>();

        int sequence = 1;
        int people = 1;
        char last = words[0].charAt(0);
        for (String word: words) {
            if(!set.contains(word) && last == word.charAt(0)){
                set.add(word);
                last = word.charAt(word.length() - 1);
            } else {
                return new int[]{people, sequence};
            }
            people ++;
            if(people > n) {
                sequence ++;
                people = 1;
            }
        }
        return new int[]{0,0};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
        System.out.println(Arrays.toString(solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"})));
        System.out.println(Arrays.toString(solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"})));
    }
}
