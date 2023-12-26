package access;

public class Speaker {
    private int volume;

    Speaker(int volume){
        this.volume = volume;
    }

    void volumeUp(){
        if(volume >= 100){
            System.out.println("소리 초과");
        }else{
            volume += 10;
            System.out.println("증가");
        }
    }

    void volumeDown(){
        volume -= 10;
        System.out.println("다운");
    }

    void showVolume(){
        System.out.println(volume);
    }
}
