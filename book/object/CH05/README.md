# CH05. 책임 할당하기

**아래와 같은 원칙을 기반으로 실제 구현을 진행 한다.**

1. 데이터보다 행동을 먼저 결정하라
2. 협력이라는 문맥 안에서 책임을 결정하라

## 데이터보다 행동을 먼저 결정하라

*“이 객체가 수행해야 하는 책임은 무엇인가"* 를 결정한 후에 *“이 책임을 수행하는데 필요한 데이터는 무엇인가"* 를 결정한다.

그렇다면 객체에게 어떤 책임을 할당해야 할까?

## 협력이라는 문맥 안에서 책임을 결정하라

협력을 시작하는 주체는 메시지 전송자이기 때문에 협력에 적합한 책임이란 메시지 수신자가 아니라 메시지 전송자에게 적합한 책임을 의미한다.

메시지를 결정한 후에 객체를 선택하자.

## 책임 주도 설계

책임 주도 설계의 흐름

- 시스템이 사용자에게 제공해야 하는 기능인 시스템 책임을 파악한다.
- 시스템 책임을 더 작은 책임으로 분할한다.
- 분할된 책임을 수행할 수 있는 적절한 객체 또는 역할을 찾아 책임을 할당한다.
- 객체가 책임을 수행하는 도중 다른 객체의 도움이 필요한 경우 이를 책임질 적절한 객체 또는 역할을 찾는다.
- 해당 객체 또는 역할에게 책임을 할당함으로써 두 객체가 협력하게 된다.

## 코드를 통해 변경의 이유를 파악할 수 있는 방법

- 함께 초기화되는 속성을 기준으로 코드를 분리해야한다.
  - ex: 할인조건이 시퀀스할인정보와 날짜할인정보를 함께 갖고있을 때 시퀀스 정보가 초기화될 때는 날짜 조건은 초기화되지 않고 그 반대도 마찬가지이다.
- 메서드들이 인스턴스 변수를 사용하는 방식 파악한다.
  - 모든 메서드가 객체의 모든 속성을 사용한다면 클래스의 응집도는 높다.
  - 반면, 메서드들이 사용하는 속성에 따라 그룹이 나뉜다면 클래스의 응집도가 낮다고 볼 수 있다.
  - ex: isSatisfiedBySequence 메서드는 sequence만 사용하고 시간속성은 사용하지 않는다. 반대로 isSatisfiedByPeriod는 시간속성만 사용한다.
  - 속성 그룹과 해당 그룹에 접근하는 메서드 그룹을 기준으로 코드를 분리해야 한다.