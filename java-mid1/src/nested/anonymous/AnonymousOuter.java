package nested.anonymous;

import nested.local.Printer;

public class AnonymousOuter {
    private int outInstanceVar = 3;

    public void process(int paramVar){

        int localVar = 1;

        Printer printer = new Printer(){
            // 인터페이스를 생성하는 것이 아니고,
            // Printer 인터페이스를 구현하는 익명 클래스를 생성하는 것임
            int value = 0;

            @Override
            public void print(){
                System.out.println(value);
                System.out.println(localVar);
                System.out.println(paramVar);
                System.out.println(outInstanceVar);
            }
        };

        printer.print();
        System.out.println(printer.getClass());
    }

    public static void main(String[] args) {
        AnonymousOuter outer = new AnonymousOuter();
        outer.process(2);
    }
}
