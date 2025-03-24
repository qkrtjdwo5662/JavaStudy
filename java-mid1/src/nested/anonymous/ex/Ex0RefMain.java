package nested.anonymous.ex;

public class Ex0RefMain {

    public static void hello(String str){
        System.out.println("시작");
        System.out.println(str);
        System.out.println("종료");
    }

    public static void main(String[] args) {
        hello("Hello Java");
        hello("Hello Spring");
    }

    // 변하는 부분과 변하지 않는 부분을 분리함
    // 변하는 부분은 외부에서 전달 받아서 재사용성 높임

}
