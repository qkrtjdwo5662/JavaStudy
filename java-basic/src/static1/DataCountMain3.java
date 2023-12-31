package static1;

public class DataCountMain3 {
    public static void main(String[] args) {
        Data3 data1 = new Data3("A");
        System.out.println(Data3.count);

        Data3 data2 = new Data3("B");
        System.out.println(Data3.count);

        Data3 data3 = new Data3("C");
        System.out.println(Data3.count);

        // 클래스에 직접접근

        // 인스턴스를 통한 접근
        Data3 data4 = new Data3("D");
        System.out.println(data4.count); // -> 인스턴스 변수 인지 클래스 변수 인지 헷갈린다.

        // 클래스를 통한 접근
        System.out.println(Data3.count);

    }
}
