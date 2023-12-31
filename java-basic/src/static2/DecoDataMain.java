package static2;

public class DecoDataMain {
    public static void main(String[] args) {
        System.out.println("정적 호출");
        DecoData.staticCall();

        System.out.println("인스턴스 호출");
        DecoData deco1 = new DecoData();
        deco1.instanceCall();

        System.out.println("인스턴스 호출");
        DecoData deco2 = new DecoData();
        deco2.instanceCall();


        DecoData data3 = new DecoData();
        data3.staticCall();

        DecoData.staticCall();
    }
}
