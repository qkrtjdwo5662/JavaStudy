package nested.test;

public class AnonymousMain {
    public static void main(String[] args) {
        Hello helloClass = new Hello() {
            @Override
            public void hello() {
                System.out.println("hello");
            }
        };

        helloClass.hello();
    }
}
