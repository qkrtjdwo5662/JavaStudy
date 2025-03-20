package nested.inner;

public class InnerOuter {
    private static int outClassValue = 3;
    private int outInstanceValue = 2;

    class Inner{
        private int innerInstanceValue = 1;

        public void print(){
            System.out.println(innerInstanceValue);

            System.out.println(outInstanceValue);
            // 외부 클래스의 인스턴스 멤버에 접근 가능
            // 이부분이 중첩 정적 클래스와는 차이가 있음

            System.out.println(outInstanceValue);
        }
    }
}
