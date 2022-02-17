package part02;

import common.CaloricLevel;
import common.Dish;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.IntStream;

import static common.Dish.menu;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class ch0603 {

    public static void main(String[] args) {
        System.out.println("partitionPrimes(100) = " + partitionPrimes(100));
    }

    public static Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(partitioningBy(candidate -> isPrime(candidate)));
    }


    public static boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.range(2, candidateRoot).noneMatch(i -> candidate % i == 0);
    }

    public static boolean isPrime(List<Integer> primes, int candidate) {
//        return primes.stream().noneMatch(i -> candidate % i == 0);
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return primes.stream().takeWhile(i -> i <= candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }

}

// 1. Collector 클래스 시그니쳐 정의
class PrimeNumbersCollector implements Collector<Integer, // 스트림 요소의 형식
        Map<Boolean, List<Integer>>, // 누적자 형식
        Map<Boolean, List<Integer>>> { // 수집 연산의 결과 형식

    // 2. 리듀싱 연산 구현
    @Override // 누적자를 만드는 함수
    public Supplier<Map<Boolean, List<Integer>>> supplier() {
        return () -> new HashMap<Boolean, List<Integer>>() {{
            put(true, new ArrayList<Integer>()); // 소수
            put(false, new ArrayList<Integer>()); // 비소수
        }};
    }
    // 3. 병렬 실행할 수 있는 컬렉터 만들기(가능하다면)
    @Override
    public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
        return (Map<Boolean, List<Integer>> map1, Map<Boolean, List<Integer>> map2) ->{ // 두번째 맵을 첫 번째 맵에 병합한다.
            map1.get(true).addAll(map2.get(true));
            map1.get(false).addAll(map2.get(false));
            return map1;
        };
    }
    @Override
    public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
        return (Map<Boolean, List<Integer>> acc, Integer candidate) -> {
            acc.get(ch0603.isPrime(acc.get(true), candidate)) // isPrime 결과에 따라 소수 리스트와 비소수 리스트를 만든다.
                    .add(candidate); // candidate에 알맞은 리스트를 추가한다.
        };
    }

    // 4. finisher 메서드와 컬렉터의 characteristics 메서드
    @Override
    public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
        return Function.identity(); // 최종 수집과정에서 데이터 변환이 필요하지 않으므로 항등 함수를 반환한다.
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));
    }
}