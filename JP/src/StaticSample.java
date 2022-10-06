public class StaticSample {
    public int n;   //non-static
    public void g() {//non-static
        m =20;
    }
    public void h() {//non-static
        m=30;
    }
    public static int m;    //static 멤버
    public static void f(){    //static 멤버
        m=5;
    }
    //StaticSample() {} 컴파일러가 자동 삽입 후 호출됨
    public static void main(String[] args)
    {
        System.out.println(StaticSample.m);
        StaticSample.f();

        System.out.println("객체 생성 전");
        //n사용 불가
        //객체 생성
        StaticSample s1; // 레퍼런스 변수 셍성
        s1 = new StaticSample();
        s1.g();
        s1.h();

        StaticSample s2; // 레퍼런스 변수 셍성
        s2 = new StaticSample();
        s2.g();
        s2.h();
    }
}
