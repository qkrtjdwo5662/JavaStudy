package final1;

public class FinalFieldMain {
    public static void main(String[] args) {
        System.out.println("생성자 초기화");

        // final 필드 생성자 초기화
        ConstructInit constructInit1 = new ConstructInit(10);
        ConstructInit constructInit2 = new ConstructInit(20);

        System.out.println(constructInit1.value);
        System.out.println(constructInit2.value);

        // final 필드 초기화
        System.out.println("필드 초기화");
        FieldInit fieldInit1 = new FieldInit();
        FieldInit fieldInit2 = new FieldInit();
        FieldInit fieldInit3 = new FieldInit();
        System.out.println(fieldInit1.value);
        System.out.println(fieldInit2.value);
        System.out.println(fieldInit3.value);
        // 고정된 같은 값이 계속 생성되어 메모리 낭비 현상

        System.out.println(FieldInit.CONST_VALUE);
        // 고정된 값으로 계속 사용 가능
        // fianl + 필드 초기화는 static을 붙여서 사용하는 것이 효과적


    }

}
