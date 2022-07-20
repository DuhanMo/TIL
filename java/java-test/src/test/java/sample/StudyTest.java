package sample;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudyTest {

    @Test
    void create() {
        Study study = new Study();
        System.out.println("create1");
        assertNotNull(study);
    }

    @Disabled
    @Test
    void createDisabled() {
        Study study = new Study();
        System.out.println("createDisabled");
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