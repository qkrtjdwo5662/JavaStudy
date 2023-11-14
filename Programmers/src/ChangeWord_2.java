import java.util.ArrayList;
import java.util.HashSet;

public class ChangeWord_2 {
    public static String begin = "hit";
    public static String target = "cog";
    public static String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
    public static int answer;

    public static boolean[] visited;
    public static void main(String[] args) {
        System.out.println(solution(begin, target, words));
    }

    public static int solution(String begin, String target, String[] words){
        answer = Integer.MAX_VALUE;

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            set.add(words[i]);
        }
        if(!set.contains(target)) return 0;

        for (int i = 0; i < words.length; i++) {
            visited = new boolean[words.length];
            if(compare(begin, words[i]) == 1){ // 단어 차이 1
                visited[i] = true;
                dfs(1, i, target, words);
            }
        }


        return answer;
    }
    public static void dfs(int count, int index, String target, String[] words){
        if(words[index].equals(target)){
            answer = Math.min(answer, count);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if(!visited[i] && compare(words[index], words[i]) == 1){
                visited[i] = true;
                dfs(count+1, i, target, words);
                visited[i] = false;
            }
        }
    }

    public static int compare(String s1, String s2){
        int count = 0;

        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) count += 1;
        }

        return count;
    }
}
