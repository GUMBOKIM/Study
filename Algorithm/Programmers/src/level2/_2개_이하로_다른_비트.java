package level2;

public class _2개_이하로_다른_비트 {

    public static long[] solution(long[] numbers) {
        int length = numbers.length;
        long[] answer = new long[length];
        for (int i = 0; i < numbers.length; i++) {
            answer[i] = calculate(numbers[i]);
            System.out.println("answer = " + answer[i]);
        }
        return answer;
    }

    static long calculate(long number) {
        if(number % 2 == 0) {
            return number + 1;
        } else {
            String binary = Long.toBinaryString(number);
            StringBuilder sb = new StringBuilder(binary);

            if(sb.indexOf("0") < 0) {
                sb.insert(0,'0');
            }

            for(int i=binary.length()-1;i>=0;i--) {
                if(sb.charAt(i) == '0') {
                    sb.setCharAt(i, '1');
                    if(i!=binary.length()-1) {
                        sb.setCharAt(i+1, '0');
                    }
                    break;
                }
            }
            return Long.valueOf(sb.toString(), 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(new long[]{2,7}));
    }
}
