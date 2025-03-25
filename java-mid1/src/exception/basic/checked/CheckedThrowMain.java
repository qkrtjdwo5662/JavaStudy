package exception.basic.checked;

public class CheckedThrowMain {
    public static void main(String[] args) throws MyCheckedException{
        Service service = new Service();
        service.catchThrow();
        // 메인 메서드 밖으로 나가버리면 예외 메시지 출력 후 종료
        System.out.println("정상 종료");
    }
}
