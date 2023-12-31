package static1;

public class Data3 {
    public String name;
    public static int count;
    // 멤버 변수
    // 인스턴스 변수 : name -> static이 붙지 않은 변수는 인스턴스를 생성해야 사용할 수 있다.
    // 클래스 변수 : count -> 인스턴스와 무관하게 클래스에 바로 접근하여 사용할 수 있다.
    public Data3(String name){
        this.name = name;
        count++;
    }
}
