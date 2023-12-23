package oop1;

public class MusicPlayer {
    int volume;
    boolean isOn;

    void on(){
        isOn = true;
        System.out.println("시작");
    }
    void off(){
        isOn = false;
        System.out.println("끔");
    }

    void volumeUp(){
        volume++;
        System.out.println(volume);
    }

    void volumeDown(){
        volume--;
        System.out.println(volume);
    }

    void showStatus(){
        if(isOn){
            System.out.println("켜져있음, volume :" + volume);
        }else System.out.println("꺼짐");
    }
}
