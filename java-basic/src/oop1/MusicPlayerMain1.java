package oop1;

public class MusicPlayerMain1 {
    public static void main(String[] args) {
        int volume = 0;
        boolean isOn = false;

        isOn = true;
        System.out.println("음악 플레이어 시작");

        // 볼륨 증가
        volume++;
        System.out.println(volume);
        // 볼륨 증가
        volume++;
        System.out.println(volume);
        // 볼륨 감소
        volume--;
        System.out.println(volume);
        // 음악 플레이어 상태
        System.out.println("음악 플레이어 상태 확인");
        if(isOn){
            System.out.println("On 볼륨: " + volume);
        }else System.out.println("off");

        // 음악 플레이서 끄기
        isOn = false;
        System.out.println("음악 플레이어 종료");
    }
}
