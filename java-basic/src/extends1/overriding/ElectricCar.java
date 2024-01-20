package extends1.overriding;

public class ElectricCar extends Car {

//    @Override
//    public void moveeee(){
//        System.out.println("전기차를 빠르게 이동");
//    }

    // Override를 하지 않아도 문제는 없음
    // 그럼 왜?

    // Override 애노테이션을 사용하여 부모의 메서드 재정의를 선언하였는데,
    // Override가 정확히 되지 않으면 컴파일 오류를 발생시킨다.

    // 부모의 메서드를 정확히 재정의 하는지를 확인 할 수 있음.

    // 혹시라도 모를 실수를 방지해준다.
    // 코드의 명확성을 위해 붙여줌

    public void charge(){
        System.out.println("충전");
    }
}
