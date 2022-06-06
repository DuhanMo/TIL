package sample;

@FunctionalInterface
public interface RunSomething {
    void doIt(); // 다른 형태의 메서드는 상관없다. 중요한건 추상 메서드가 한개여야 functional interface 이다.
}
