package poly.ex.sender;

public class SmsSender implements Sender{
    @Override
    public void sendMessage(String s) {
        System.out.println("SMS 발송 : " + s);
    }
}
