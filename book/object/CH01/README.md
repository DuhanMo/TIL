# ch01 객체, 설계

- 모든 모듈은 제대로 실행돼야 하고
- 변경이 용이해야 하며
- 이해하기 쉬어야 한다

의존성은 변경에 대한 영향을 암시한다.

의존성이라는 말 속에는 어떤 객체가 변경될 때 그 객체에게 의존하는 다른 객체도 함께 변경될 수 있다는 사실이 내포돼 있다.

의존성을 완전히 없애는 것이 정답이 아니다.

### 객체지향 설계는 서로 의존하면서 협력하는 객체들의 공동체를 구축하는 것

객체 사이의 의존성이 과한경우 → **결합도**가 높다

객체사이 결합도가 높으면 높을 수록 함께 변경될 확률이 높아 변경하기 어렵다.

그렇기 때문에 설계의 목표는 객체사이의 결합도를 낮춰 변경용이한 설계를 만드는 것.

## 자율성을 높이자

개념적이나 물리적으로 객체 내부의 세부적인 사항을 감추는 것을 **캡슐화**라고 한다.

캡슐화를 통해 객체 내부로의 접근을 제한하면 객체사이 결합도를 낮출 수 있기 때문에 설계를 좀 더 쉽게 변경할 수 있다.

- 객체를 인터페이스와 구현으로 나누고 인터페이스만을 공개하자
- 결합도를 낮추고 변경용이한 코드를 작성하기 위한 가장 기본적인 설계 원칙이다.

### 캡슐화와 응집도

밀접하게 연관된 작업만을 수행하고 연관성 없는 작업은 다른 객체에게 위임하는 객체를 가리켜 **응집도**가 높다고 한다.

### 절차지향과 객체지향

객체가 다루는 데이터와 실제 그 데이터를 이용해 진행되는 프로세스를 별도의 모듈에 위치시키는 방식을 **절차적 프로그래밍** 이라고 부른다.

절차적 프로그래밍은 데이터의 변경으로 인한 영향을 지역적으로 고립시키기 어렵기 때문에, 메서드의 변경은 버그를 부르고 버그에 대한 두려움은 코드를 변경하기 어렵게 한다. 따라서 절차적 프로그래밍은 변경하기 어려운 코드를 양산하는 경향이 있다.

반면, 데이터와 프로세스가 동일한 모듈 내부에 위치하도록 하는 방식을 **객체지향 프로그래밍이**라고 부른다. 적절한 의존성의 통제는 사이드이펙트를 줄인다. 훌륭한 객체지향설계의 핵심은 캡슐화를 이용해 의존성을 적절히 관리하고, 객체사이의 결합도를 낮추는 것이다.

### 책임의 이동

**절차지향 vs 객체지향** 두 방식의 차이는 **책임의 이동**이다. 객체지향 세계에서는 각 객체는 스스로를 책임진다. 적절한 객체에 적절한 책임을 할당하면 이해하기 쉬운 구조와 읽기 쉬운 코드를 얻는다. 설계를 어렵게 하는 것은 **의존성**이다. 불필요한 의존성을 제거하여 **결합도를 낮추자.**

캡슐화를 함으로써 결합도를 낮출 수 있고 이에 따라 객체의 자율성을 높이고 응집도를 높일 수 있다.