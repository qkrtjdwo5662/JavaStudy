package oop1;

public class MusicPlayerMain2 {

    public static void main(String[] args) {
        MusicPlayerData data = new MusicPlayerData();

        on(data);

        volumeUp(data);
        volumeUp(data);
        volumeDown(data);

        showStatus(data);

        off(data);

        // 모듈화란 레고 블럭과 같음
        // 필요한 블럭을 가져다 꼽아서 사용할 수 있음.
        // 분리한 메서드를 내가 필요할 때 호출하여 조립해서 프로그래밍을 작성가능
    }

    static void on(MusicPlayerData data){
        data.isOn = true;
        System.out.println("음악 플레이어 시작");
    }

    static void off(MusicPlayerData data){
        data.isOn = false;
        System.out.println("음악 플레이어 종료");
    }

    static void volumeUp(MusicPlayerData data){
        data.volume ++;
        System.out.println("볼륨 :" + data.volume);
    }
    static void volumeDown(MusicPlayerData data){
        data.volume --;
        System.out.println("볼륨 :" + data.volume);
    }

    static void showStatus(MusicPlayerData data){
        System.out.println("음악 플레이어 상태 확인");
        if(data.isOn){
            System.out.println("On 볼륨: " + data.volume);
        }else System.out.println("off");
    }
}
