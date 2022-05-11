package highScoreKit.hash;

import java.util.Arrays;
import java.util.Comparator;

public class PhoneNumberList {

    static boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        for(int i=0; i<phone_book.length; i++){
            if(i == phone_book.length -1) break;
            if(phone_book[i+1].startsWith(phone_book[i])){
                answer = false;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        solution(new String[]{"123", "456", "789"});
    }
}
