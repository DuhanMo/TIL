package sample;

public class Main {
    public static void main(String[] args) {
        Foo foo = new DefaultFoo("duhan");
        System.out.println(foo.getName());
        foo.printNameUpperCase();

        Foo.printNameEveryWhere();
    }
}
