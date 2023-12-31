package static2;

public class DecoData {
    private int instanceValue;
    private static int staticValue;



    public static void staticCall(){
//        instanceValue++; // error
//        instanceMethod();
        staticValue++;
        staticMethod();
    }

    public void instanceCall(){
        instanceValue++; // 인스턴스 변수 접근
        instanceMethod();

        staticValue++;
        staticMethod();
    }

    private void instanceMethod(){
        System.out.println(instanceValue);
    }

    private static void staticMethod(){
        System.out.println(staticValue);
    }
}
