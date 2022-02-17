package part02;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import static java.util.stream.Collector.Characteristics.*;

public class ToListCollector <T> implements Collector<T, List<T>, List<T>> {

    @Override // 빈 결과로 이루어진 Supplier를 반환 해야한다. 수집과정에서 빈 누적자 인스턴스를 만드는 파라미터가 없는 함수.
    public Supplier<List<T>> supplier() {
        return ArrayList::new; // 수집 연산의 시발점
    }

    @Override // 리듀싱 연산을 수행하는 함수를 반환한다. 스트림에서 누적자와 n번째 요소를 함수에 적용
    public BiConsumer<List<T>, T> accumulator() {
        return List::add; // 탐색항 항목을 누적하고 바로 누적자를 고친다.
    }

    @Override // 스트림 탐색을 끝내고 누적자 객체를 최종 결과로 반환하면서 누적 과정을 끝낼 때 호출할 함수를 반환해야한다.
    public Function<List<T>, List<T>> finisher() {
        return Function.identity(); // 항등함수
    }

    @Override // 스트림의 서로 다른 서브파트를 병렬로 처리할때 누적자가 이 결과를 어떻게 처리 할지 정의
    public BinaryOperator<List<T>> combiner() {
        return (list1, list2) -> { // 두 번째 콘텐츠와 합쳐서 첫 번쨰 누적자를 고친다.
            list1.addAll(list2); // 변경된 첫 번쨰 누적자를 반환한다.
            return list1;
        };
    }

    @Override // 컬렉터의 연산을 정의한다. 스트림을 병렬로 리듀스 할 것인지 그리고 병렬로 리듀스한다면 어떤 최적화를 선택해야 할지
    public Set<Characteristics> characteristics() {
        /*
            UNORDERED : 리듀싱 결과는 스트림 요소의 방문 순서나 누적 순서에 영향을 받지 않는다.
            CONCURRENT : 다중 스레드에서 ACCUMULATOR 함수를 동시에 호출할 수 있으며 이 컬렉터는 스트림의 병렬 리듀싱을 수행할 수 있다.
            IDENTITY_FINISH : FINISHER 메서드가 반환하는 함수는 단순히 identity를 적용할 뿐이므로 이를 생략할 수 있다.
         */
        return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH, CONCURRENT));
        // 컬렉터의 플래그를 IDENTITY_FINISH, CONCURRENT로 설정한다.
    }
}
