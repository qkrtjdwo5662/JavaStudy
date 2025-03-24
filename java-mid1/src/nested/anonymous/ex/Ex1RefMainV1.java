package nested.anonymous.ex;

import java.util.Random;

public class Ex1RefMainV1 {
    static class Dice implements Process{
        @Override
        public void run(){
            int randomValue = new Random().nextInt(6) + 1;
            System.out.println("주사위 = " + randomValue);
        }
    }

    static class Sum implements Process{
        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println("i = " + i);
            }
        }
    }

    public static void hello(Process process){
        System.out.println("시작");

        process.run();

        System.out.println("종료");
    }


    public static void main(String[] args) {
        // 코드 조각 전달을 인터페이스를 구현한 인스턴스로 전달해서 해당 인터페이스의 메서드를 호출
        // 다형성을 활용

        hello(new Dice());
        hello(new Sum());
    }
}
