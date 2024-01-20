package extends1.super2;

public class ClassC extends ClassB{
    public ClassC(int a){
        super(10, 20); // 기본 생성자가 아니면 직접 정의
        System.out.println("ClassC 생성자");
    }
}
