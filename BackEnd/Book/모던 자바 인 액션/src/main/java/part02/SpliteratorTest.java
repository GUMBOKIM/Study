package part02;

import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

public class SpliteratorTest {

    public static void main(String[] args) {
        String test = "안녕 바보 멍청이 검보 그만 공부 하고 싶다 ㅠㅠ";
        System.out.println(countWordsIteratively(test));
    }

    public static int countWordsIteratively(String s) {
        int counter = 0;
        boolean lastSpace = true;
        for (char c : s.toCharArray()) {
            if (Character.isWhitespace(c)) {
                lastSpace = true;
            } else {
                if (lastSpace) counter++;
                lastSpace = false;
            }
        }
        return counter;
    }

    public static int countWords(Stream<Character> stream) {
        WordCounter wordCounter = stream.reduce(new WordCounter(0, true),
                WordCounter::accumulate,
                WordCounter::combine);
        return wordCounter.getCounter();
    }
}

class WordCounter {
    private final int counter;
    private final boolean lastSpace;

    public WordCounter(int counter, boolean lastSpace) {
        this.counter = counter;
        this.lastSpace = lastSpace;
    }

    public WordCounter accumulate(Character c) {
        if (Character.isWhitespace(c)) {
            return lastSpace ?
                    this : new WordCounter(counter, true);
        } else {
            return lastSpace ?
                    new WordCounter(counter + 1, false) : this;
        }
    }

    public WordCounter combine(WordCounter wordCounter) {
        return new WordCounter(counter + wordCounter.counter, wordCounter.lastSpace);
    }

    public int getCounter() {
        return counter;
    }
}

class WordCounterSpliterator implements Spliterator<Character> {

    private final String string;
    private int currentChar = 0;

    WordCounterSpliterator(String string) {
        this.string = string;
    }

    @Override // 문자열에서 현재 인덱스에 해당하는 문자를 Consumer에 제공한 다음 인덱스를 증가시킨다.
    public boolean tryAdvance(Consumer<? super Character> action) {
        action.accept(string.charAt(currentChar++));
        return currentChar < string.length(); // 반복해야할 문자가 남아있음
    }

    @Override // 반복될 자료구조를 분할하는 로직
    public Spliterator<Character> trySplit() {
        int currentSize = string.length() - currentChar;
        if (currentSize < 10) { // 중단할 한계
            return null; // 분할 중지
        }
        for (int splitPos = currentSize / 2;
             splitPos < string.length(); splitPos++) { // 파싱할 문자열의 중간을 분할 위치로 설정한다.
            if (Character.isWhitespace(string.charAt(splitPos))) { // 다음공백이 나올때까지 분할위치를 뒤로 이동시킨다.
                Spliterator<Character> spliterator = new WordCounterSpliterator(string.substring(currentChar, splitPos));
                currentChar = splitPos; // 시작 위치를 분할 위치로 설정한다.
                return spliterator; // 공백을 찾았고 문자열을 분리 했으므로 루프를 종료한다.
            }
        }
        return null;
    }

    @Override
    public long estimateSize() {
        return string.length() - currentChar;
    }

    @Override
    public int characteristics() {
        return ORDERED + SIZED + NONNULL + IMMUTABLE;
    }
}