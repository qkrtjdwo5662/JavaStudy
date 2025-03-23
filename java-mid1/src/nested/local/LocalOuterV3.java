package nested.local;

import java.lang.reflect.Field;

public class LocalOuterV3 {
    private int outInstanceVar = 3;

    public Printer process(int paramVar){

        int localVar = 1; // 지역 변수는 스택영역이 종료되는 순간 함께 제거된다.
        // localVar = 2;
        // 사실상 지역변수와 매개변수는 final로 선언이 됨

        // 지역변수의 캡처를 위해 도중에 값이 변하면 안되기 때문에
        class LocalPrinter implements Printer{
            int value = 0;

            @Override
            public void print(){
                System.out.println(value);

                // 인스턴스는 지역변수보다 더 오래 살아 남는다.
                System.out.println(localVar);
                System.out.println(paramVar);
                System.out.println(outInstanceVar);
            }
        }

        LocalPrinter printer = new LocalPrinter();
        // printer.print();
        return printer;
    }

    public static void main(String[] args) {
        LocalOuterV3 localOuterV1 = new LocalOuterV3();
        Printer printer = localOuterV1.process(2);
        printer.print();

        // 추가
        System.out.println("필드 확인");
        Field[] fields = printer.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
    }
}
