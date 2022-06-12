package sample;

public interface Foo {

    String getName();
    /**
     * @implSpec
     * getName() 의 구현메서드를 이용해 대문자로 이름을 출력한다.
     * 기본 메서드는 구현체가 모르는 인터페이스의 메서드이기 때문에
     * 구현체에 따라 에러가 발생할 수 있다.
     * 해당 @implSpec 애너테이션을 이용하자.
     */
    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    }

    static void printNameEveryWhere() {
        System.out.println("this is interface static method");
    }
}
