package access;

public class SpeakerMain {
    public static void main(String[] args) {
        Speaker speaker = new Speaker(90);

        speaker.showVolume();

        speaker.volumeUp();
        speaker.showVolume();

        speaker.volumeUp();
        speaker.showVolume();

        //필드에 직접 접근
        System.out.println("수정");
//        speaker.volume = 200;
        speaker.showVolume();
        // 직접 접근하면 문제가 생길수 있음
        // 접근제어자로 멤버변수에 직접접근하는 것을 막는다.
        // 메서드를 통해서만 접근가능
    }
}
