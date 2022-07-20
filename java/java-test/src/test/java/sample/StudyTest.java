package sample;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {

    @Test
    @DisplayName("스터디 만들기")
    void create_new_study() {
        Study study = new Study();
        System.out.println("create1");
        assertNotNull(study);
    }

    @Test
    @DisplayName("스터디 다시 만들기")
    void create_new_study_again() {
        Study study = new Study();
        System.out.println("create again");
        assertNotNull(study);
    }

    @BeforeAll // 모든 테스트 실행 전 딱 한번
    static void beforeAll() { // private 불가 , return 불가 무조건 static
        System.out.println("beforeAll");
    }

    @AfterAll // 모든 테스트 실행 후 딱 한번
    static void afterAll() {
        System.out.println("afterAll");
    }

    @BeforeEach //
    void beforeEach() {
        System.out.println("beforeEach");
    }

    @AfterEach
    void afterEach() {
        System.out.println("afterEach");
    }
}