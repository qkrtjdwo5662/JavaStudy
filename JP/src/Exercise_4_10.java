import java.util.Arrays;
import java.util.Scanner;

class Dictionary{

    private static String[] kor = {"사랑", "아기", "돈", "미래", "희망"};
    private static String[] eng = {"love", "baby", "money", "future","hope"};
    public static String kor2Eng(String word) {
        for(int i=0; i< kor.length; i++) {
            if (word.equals(kor[i])) {
                return eng[Arrays.asList(kor).indexOf(word)];
            }
        }
        if(word.equals("그만")) {return "stop";}

        return "false";
    }
}

public class Exercise_4_10 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("한영 단어 검색 프로그램");
        while(true) {
            System.out.print("한글 단어?");
            String word = sc.next();
            if(Dictionary.kor2Eng(word)=="false"){
                System.out.println(word + "사전에 없음");
            }else if(Dictionary.kor2Eng(word)=="stop"){
                return;
            } else{
                System.out.println(word + "는 " + Dictionary.kor2Eng(word));
            }

        }

    }
}
