import java.util.HashMap;
import java.util.HashSet;

public class ChangeWord {
    public static String begin = "hit";
    public static String target = "cog";
    public static String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

    public static boolean[] visited;
    public static int answer = 987654321;
    public static void main(String[] args) {
        System.out.println(solution(begin, target, words));
    }

    public static int solution(String begin, String target, String[] words){

        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            hashSet.add(words[i]);
        }

        if(!hashSet.contains(target)) return 0;



        for (int i = 0; i < words.length; i++) {
            if(compare(begin, words[i]) == 1) { // 단어 차이가 1일 때 만
                visited = new boolean[words.length];
                visited[i] = true;
                dfs(1, i, target, words);
            }
        }

        return answer;
    }
    public static void dfs(int count, int now, String target, String[] words){
        if(words[now].equals(target)){
            answer = Math.min(count, answer);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if(!visited[i] && compare(words[now], words[i]) == 1){ // 방문 X, 그 다음 변환 할 단어 찾기
                visited[i] = true;
                dfs(count+1, i, target, words);
                visited[i] = false;
            }
        }
    }


    public static int compare(String s1, String s2){
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) count++;
        }

        return count;
    }
}
