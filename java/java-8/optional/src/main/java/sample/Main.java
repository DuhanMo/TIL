package sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        // Optional 은 리턴타입으로만 사용하길 권장한다.\
        // 파라미터로 사용시 해당 Optional 파라미터의 널체크를 해줘야하고, null 을 호출할 수 가 있다.
        // 이렇게 되면 null 에다가 무언가를 진행할 수 있고 -> NPE가 발생한다.

        Optional<OnlineClass> optionalOnlineClass = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("jpa"))
                .findFirst();

        // get() 을 사용하려면 isPresent를 if문으로서 추가해야한다.
        // 다른 api 들을 사용하면 이러한 스타일을 사용안할 수 있다.
        if (optionalOnlineClass.isPresent()) {
            OnlineClass onlineClass = optionalOnlineClass.get();
            System.out.println(onlineClass.getTitle());
        }

        optionalOnlineClass.ifPresent(oc -> System.out.println(oc.getTitle()));

        // 없을 때는 ~~을 해라 orElse
        // orElse() -> Optional 이 감싸고 있는 인스턴스타입을 리턴하는 api
        // Optional 안에 이미 객체가 있더라도 무조건 실행되는 api 이다.
        // 상수로 만들어져 있는 것을 참조할 때는 orElse 를 이용하자.
        // 동적으로 해야하는 일이라면 orElseGet 을 이용하자
        OnlineClass orElseOnlineClass = optionalOnlineClass.orElse(createNewOnlineClass());
        System.out.println("orElseOnlineClass = " + orElseOnlineClass.getTitle());

        OnlineClass orElseGetOnlineClass = optionalOnlineClass.orElseGet(Main::createNewOnlineClass);
        System.out.println("orElseGetOnlineClass = " + orElseGetOnlineClass.getTitle());

        try {
            // 무언가 만들어 줄 수 없는 상황일 땐 orElseThrow를 이용
            OnlineClass orElseThrowOnlineClass = optionalOnlineClass.orElseThrow(IllegalStateException::new);
            System.out.println("orElseThrowOnlineClass = " + orElseThrowOnlineClass.getTitle());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 있다는 가정하에 filter() 사용가능하고 리턴타입은 Optional이다.
        Optional<OnlineClass> filterOnlineClass = optionalOnlineClass
                .filter(oc -> oc.getId() > 0);
        System.out.println("filterOnlineClass = " + filterOnlineClass.isPresent());


        Optional<Integer> mapOptional = optionalOnlineClass.map(OnlineClass::getId);
        Integer integer = mapOptional.orElse(100);
        System.out.println(integer);
    }


    private static OnlineClass createNewOnlineClass() {
        System.out.println("create new Online Class");
        return new OnlineClass(11, "New Class", false);
    }
}
