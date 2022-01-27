package test;

import java.util.Arrays;

public class test_real2 {

    public static void main(String[] args) {

        Runtime.getRuntime().gc();
        String[] replies = {"FFCCAAFCCAAA", "AAAABBBBCCCC", "ABCABCABCABC"};
        int n = 3;
        int k = 3;

        int reply_cnt = replies.length;
        int reply_len = replies[0].length();

        int[] answer = new int[reply_cnt];
        for (int i = 0; i < reply_cnt; i++) {
            answer[i] = 1;
        }

        while (n * k <= reply_len) {
            int goal = n * k;
            for (int i = 0; i < reply_cnt; i++) {
                if (answer[i] == 1) {
                        for(int j = 0; j < reply_len - goal; j++){
                            String temp = replies[i];
                            String str = temp.substring(j, j+n);
                            int after = temp.replaceAll(str, "").length();
                            if (reply_len - after >= goal) {
                                answer[i] = 0;
                                break;
                            }
                        }
                }
            }
            n++;
        }
        Arrays.stream(answer).forEach(a -> System.out.println("a = " + a));

        long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.print(usedMemory + " bytes");
    }
}
