package poly.ex.sender;

public class EmailSender implements Sender{
    @Override
    public void sendMessage(String s) {
        System.out.println("메일 발송 : " + s);
    }
}
