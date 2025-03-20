package nested.nested;

public class NestedOuter {
    private static int outClassValue = 3;
    private int outInstanceValue = 2;

    static class Nested {
        private int nestedInstanceValue = 1;

        public void print(){
            System.out.println(nestedInstanceValue);

            //System.out.println(outInstanceValue);
            // 바깥 클래스의 인스턴스 멤버에는 접근 불가

            System.out.println(outClassValue);
            // 바깥 클래스의 클래스 멤버에는 접근 할 수 있음
            // private이여도 접근 할 수 있다.
        }
    }
}
