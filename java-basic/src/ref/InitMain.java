package ref;

public class InitMain {
    public static void main(String[] args) {
        InitData data = new InitData();
        System.out.println(data.value1); // 초기화 하지 않았지만 0
        System.out.println(data.value2);
    }
}
