import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class EnglishWord {
    public static int n = 2;
    public static String[] words = { "hello", "one", "even", "never", "now", "world", "draw"};
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(n, words)));
    }

    public static int[] solution(int n, String[] words){

        // 기존에 나온 단어 반복 금지
        // 끝말 잇기 규칙 수행

        ArrayList<String> arrList = new ArrayList<>();
        char temp = words[0].charAt(words[0].length()-1);

        for (int i = 0; i < words.length; i++) {

            if(arrList.contains(words[i])){
               return new int[]{(i%n)+1, (i/n) + 1};
            }

            if(i!=0 && temp!=words[i].charAt(0)){
                return new int[]{(i%n)+1, (i/n) + 1};
            }

            arrList.add(words[i]);
            temp = words[i].charAt(words[i].length()-1);
        }


        return new int[]{0,0};
    }
}
