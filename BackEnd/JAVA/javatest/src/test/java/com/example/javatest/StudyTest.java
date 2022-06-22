package com.example.javatest;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudyTest {

    @Test
    @Order(2)
    @DisplayName("스터디 만들기")
    @Tag("fast")
    void createTest() {
        Study study = new Study();
        assertAll(
                () -> assertNotNull(study),
                () -> assertEquals(
                StudyStatus.DRAFT,
                study.getStatus(),
                "스터디를 처음 만들면 상태값이 DRAFT여야 한다."
        ),
                () -> assertEquals(
                StudyStatus.DRAFT,
                study.getStatus(),
                () -> "스터디를 처음 만들면 상태값이 DRAFT여야 한다."
        )
        );
        System.out.println("create");
    }


    @Test
    @Order(1)
    @Tag("slow")
    void create1_test() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Study(-10));
        String message = exception.getMessage();
        assertEquals(message, "limit은 0보다 커야합니다.");
    }



    @SlowTest
    void create3_test() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Study(-10));
        String message = exception.getMessage();
        assertEquals(message, "limit은 0보다 커야합니다.");
    }



    @Test
    @DisplayName("테스트 만들기 꾸루룩")
//    @Disabled
    void createTest2() {
//        assertTimeout(Duration.ofMillis(100), () ->{
//                new Study(10);
//                Thread.sleep(1000);
//        });
        assertTimeoutPreemptively(Duration.ofMillis(100), () ->{
            new Study(10);
            Thread.sleep(1000);
        });
    }

    @Test
    void assumeTest() {
        String test_env = System.getenv("TEST_ENV");
//        assumeTrue("LOCAL".equalsIgnoreCase(test_env));

        assumingThat("TEST".equalsIgnoreCase(test_env),
                () -> {
                    System.out.println("TEST 환경");
        });
        assumingThat(() -> true,
                () -> {
                    System.out.println("없음");
                });
    }

    @Test
    @EnabledOnOs(OS.MAC)
    @EnabledOnJre(JRE.JAVA_10)
    void assumeTest2() {
        assertTrue(true);
    }

    @DisplayName("반복 테스트")
    @RepeatedTest(value=10, name="{displayName}, {currentRepetition}/{totalRepetitions}")
    void repeatTest(RepetitionInfo repetitionInfo) {
        System.out.println("repetitionInfo.getCurrentRepetition() = " + repetitionInfo.getCurrentRepetition());
        System.out.println("repetitionInfo.getCurrentRepetition() = " + repetitionInfo.getTotalRepetitions());
        assertTrue(true);
    }


    @DisplayName("테스트 만들기")
    @ParameterizedTest(name="{index} {displayName} message={0}")
    @ValueSource(strings = {"테스트1", "테스트2", "테스트3"})
    void repeatTest2(String message) {
        System.out.println("message = " + message);
        assertTrue(true);
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("afterAll");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("beforeEach");
    }

    @AfterEach
    void afterEach() {
        System.out.println("afterEach");
    }

}