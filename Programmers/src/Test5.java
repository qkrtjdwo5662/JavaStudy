import java.util.ArrayList;
import java.util.Arrays;

public class Test5 {
//    public static String s = "centerminus";
//    public static String[] word_dict = {"cent", "center", "term", "terminus", "rm", "min", "minus", "us"};

    public static String s = "aaaababab";
    public static String[] word_dict = {"aaa", "aaaa", "ab", "bab", "aababa"};
    public static int answer;
    public static boolean[] visited;
    public static void main(String[] args) {
        System.out.println(solution(s, word_dict));
    }

    public static int solution(String s, String[] word_dict){
        answer = 0;
        int n = word_dict.length;
        visited = new boolean[n];


        backtrack(s, 0, word_dict, "");
        return answer;

    }
    public static void backtrack(String now, int count, String[] word_dict, String num){
        if(now.equals("")){
//            System.out.println(num);
            answer = Math.max(answer, count);
            return;
        }else if(count == word_dict.length){
//            System.out.println(num);
            return;
        }


        for (int i = 0; i < word_dict.length; i++) {
            System.out.println(num);
            if(now.startsWith(word_dict[i])){
                if(now.equals(word_dict[i])){
                    backtrack(now.replace(word_dict[i], ""), count+1, word_dict, num +i);
                }else{
                    char last = word_dict[i].charAt(word_dict[i].length()-1);
                    backtrack(last+now.replace(word_dict[i], ""), count+1, word_dict,num +i);
                }
            }else if(now.endsWith(word_dict[i])){
                if(now.equals(word_dict[i])){
                    backtrack(now.replace(word_dict[i], ""), count+1, word_dict,num +i);
                }else{
                    char first = word_dict[i].charAt(0);
                    backtrack(now.replace(word_dict[i], "") + first, count+1, word_dict,num +i);
                }
            }
//            else if(now.contains(word_dict[i])) {
//                if(now.equals(word_dict[i])){
//                    backtrack(now.replace(word_dict[i], ""), count+1, word_dict);
//                }else{
//                    String[] arr = now.split(word_dict[i]);
//                    char first = word_dict[i].charAt(0);
//                    char last = word_dict[i].charAt(word_dict[i].length()-1);
//                    backtrack(arr[0] +first + last+ arr[1], count+1, word_dict);
//                }
//            }

        }
    }
}
