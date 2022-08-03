package level2;

import java.util.*;

public class 소수찾기 {
    static int numberLength;
    static int[] check;

    public static int solution(String numbers) {
        numberLength = numbers.length();
        char[] chars = numbers.toCharArray();
        Arrays.sort(chars);

        int[] primeNumber = findPrimeNumber(chars);
        System.out.println("Arrays.toString(primeNumber) = " + Arrays.toString(primeNumber));

        Set<Integer> numberSet = new HashSet<>();
        check = new int[numberLength];
        for (int i = 1; i <= numberLength; i++) {
            numberCombination(0, i, "", chars, numberSet);
        }
        System.out.println("numberSet = " + numberSet);

        int answer = 0;
        for (int number: numberSet) if(primeNumber[number] == 0) answer ++;
        System.out.println("answer = " + answer);
        return answer;
    }

    private static int[] findPrimeNumber(char[] chars) {
        StringBuilder sb = new StringBuilder();
        for (char c: chars) sb.append(c);
        int max = Integer.parseInt(sb.reverse().toString());

        int[] check = new int[max + 1];
        check[0] = 1;
        check[1] = 1;
        for (int i = 2; i <= Math.sqrt(max + 1); i++) {
            int count = 2;
            while(i * count <= max) {
                check[i * count] = 1;
                count++;
            }
        }
        return check;
    }

    private static void numberCombination(int L, int D, String result, char[] chars, Set<Integer> numberSet){
        if(L == D) numberSet.add(Integer.parseInt(result));
        else {
            for (int i = 0; i < numberLength; i++) {
                if(check[i] == 0){
                    check[i] = 1;
                    numberCombination(L + 1, D, result + chars[i], chars, numberSet);
                    check[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        solution("011");
    }
}