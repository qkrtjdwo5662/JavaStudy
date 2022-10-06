import java.util.Scanner;

class Player{
    private String name;
    private String word;
    private int score;
    private Player[] player;
    private Scanner sc= new Scanner(System.in);

    void setName(String name){
        this.name = name;
    }
    String getName(){
        return name;
    }
    void setScore(int score){
        this.score = this.score + score;
    }
    int getScore(){
        return score;
    }
    void getWordFromUser(String word){
        this.word = word;
    }
    char getLastChar(){
        if(word==null){
            word="아버지";
        }
        int lastIndex = word.length()-1;
        return word.charAt(lastIndex);
    }
    char getFirstChar(){
        return word.charAt(0);
    }
    void checkSuccess(){
        while(true) {
            for (int i = 0; i < player.length; i++) {
                System.out.print(player[i].getName()+">>");
                String word = sc.next();
                player[i].getWordFromUser(word);
                if(player[(i+2)%3].getLastChar()!=player[(i+3)%3].getFirstChar()){
                    System.out.println(player[i].getName()+"이 졌습니다.");
                    return;
                }else{
                    player[i].setScore(50);
                }
            }
        }
    }
    void resultScore(){
        System.out.println("----끝말잇기 게임걀과----");
        for (int i = 0; i < player.length; i++) {
            System.out.println(player[i].getName()+" : "+player[i].getScore()+"점");
        }
    }
    void run(){
        System.out.println("끝말잇기 게임을 시작합니다...");
        System.out.print("게임에 참가하는 인원은 몇명입니까>>");
        int num = sc.nextInt();
        player = new Player[num];//배열 레퍼런스 생성
        for(int i=0; i< player.length; i++){
            player[i] = new Player();
        }
        for(int i=0; i< player.length; i++){
            System.out.print("참가자의 이름을 입력하세요>>");
            String name = sc.next();
            player[i].setName(name);
        }
        System.out.println("시작하는 단어는 아버지 입니다");
        checkSuccess();
        resultScore();
    }
}

public class WordGameApp {
    public static void main(String[] args){
        Player player = new Player();
        player.run();
    }
}
