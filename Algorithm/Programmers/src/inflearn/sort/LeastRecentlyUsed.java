package inflearn.sort;

import java.util.Arrays;
import java.util.Scanner;

public class LeastRecentlyUsed {

    public static String solution(int storageLength, int workLength, int[] works) {
        int[] storage = new int[storageLength];
        for (int i = 0; i < storageLength; i++) storage[i] = 0;

        for (int i = 0; i < workLength; i++) {
            int work = works[i];

            int index = findContainIndex(work, storage, storageLength);
            int[] tempStorage = new int[storageLength];
            tempStorage[0] = work;

            if (index == -1) {
                for (int j = 1; j < storageLength; j++) tempStorage[j] = storage[j - 1];
            } else {
                int tempIndex = 1;
                for (int j = 0; j < storageLength; j++) {
                    if(j != index) {
                        tempStorage[tempIndex] = storage[j];
                        tempIndex++;
                    }
                }
            }
            storage = tempStorage;
        }

        StringBuilder sb = new StringBuilder();
        for (int num : storage) sb.append(num + " ");
        return sb.toString();
    }

    public static int findContainIndex(int work, int[] storage, int storageLength) {
        for (int i = 0; i < storageLength; i++) {
            if (work == storage[i]) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int storageLength = sc.nextInt();
        int workLength = sc.nextInt();
        int[] works = new int[workLength];
        for (int i = 0; i < workLength; i++) works[i] = sc.nextInt();
        System.out.print(solution(storageLength, workLength, works));
    }
}
