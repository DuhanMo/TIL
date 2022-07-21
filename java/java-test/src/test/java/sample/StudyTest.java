package sample;

import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {

    @Test
    @DisplayName("스터디 만들기")
    void create_new_study() {
        Study study = new Study(10);
        System.out.println("create1");
        assertNotNull(study);
        // 기대하는 값을 먼저 적어주고, 나오는 값을 두번째에 작성
        assertEquals(StudyStatus.DRAFT, study.getStatue(),
//            람다식으로 만들게되면 최대한 하지 않는다. 필요한 시점에만 작성하게 된다.
//            하지만 람다식으로 작성하지 않게되면 항상 코드를 실행하게 된다.
                () -> "스터디 생성시 최초 상태는 DRAFT 다."
        );
        // 먼저 진행된 assert가 깨진다면 이후 assert가 진행되지 않는다.
        // 따라서 assertAll로 묶는다면 모든 assert문을 진행한다.
        assertAll(
                () -> assertNotNull(study),
                () -> assertEquals(StudyStatus.DRAFT, study.getStatue()),
                () -> assertTrue(study.getLimit() > 0, "스터디 최대 참석 가능 인원은 0보다 커야한다.")
        );
    }

    @Test
    @DisplayName("스터디 다시 만들기")
    void create_new_study_again() {
        System.out.println("create again");
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> new Study(-10));
        String message = exception.getMessage();
        assertEquals("limit은 0보다 커야한다.", message);

        assertTimeout(Duration.ofMillis(100), () -> { // assertTimeout() 이 코드블럭이 실행 완료될 때 까지 기다린다(300을 기다림).
            new Study(10);
            Thread.sleep(300);
        });

        assertTimeoutPreemptively(Duration.ofMillis(100), () -> { // assertTimeoutPreemptively() expect 의 시간만 기다림(100을 기다림).
            new Study(10);
            Thread.sleep(300);
        });

        // 트랜잭션 테스트는 롤백을 기준으로 한다.
        // 하지만 assertTimeoutPreemptively 는 코드블럭을 별도 스레드에서 진행하기 때문에
        // 트랜잭션 (Thread Local 전략) 을 사용하는 테스트에서는 예상치못하게 롤백이 안되고 DB에 반영될 수가 있다.
    }

    @BeforeAll // 모든 테스트 실행 전 딱 한번
    static void beforeAll() { // private 불가 , return 불가 무조건 static
        System.out.println("beforeAll");
    }

    @AfterAll // 모든 테스트 실행 후 딱 한번
    static void afterAll() {
        System.out.println("afterAll");
    }

    @BeforeEach
        //
    void beforeEach() {
        System.out.println("beforeEach");
    }

    @AfterEach
    void afterEach() {
        System.out.println("afterEach");
    }
}