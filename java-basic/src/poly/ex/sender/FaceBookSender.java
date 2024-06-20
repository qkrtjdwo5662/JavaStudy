package poly.ex.sender;

public class FaceBookSender implements Sender{
    @Override
    public void sendMessage(String s) {
        System.out.println("페이스북 발송 : " + s);
    }
}
