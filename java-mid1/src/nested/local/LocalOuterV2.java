package nested.local;

public class LocalOuterV2 {
    private int outInstanceVar = 3;

    public void process(int paramVar){

        int localVar = 1;

        class LocalPrinter implements Printer{
            int value = 0;

            @Override
            public void print(){
                System.out.println(value);
                System.out.println(localVar);
                System.out.println(paramVar);
                System.out.println(outInstanceVar);
                // 지역 클래스도 내부 클래스의 한 종류임
                // 따라서 바깥 클래스의 인스턴스 멤버에 접근 가능함
            }
        }

        LocalPrinter printer = new LocalPrinter();
        printer.print();
    }

    public static void main(String[] args) {
        LocalOuterV2 localOuterV1 = new LocalOuterV2();
        localOuterV1.process(2);
    }
}
