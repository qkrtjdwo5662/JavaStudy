import java.util.HashSet;

public class ChangeWord_3 {
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
            if(compare(words[i], begin) == 1){
                visited[i] = true;
                dfs(1, i, words, target);
            }
        }

        return answer;
    }

    public static void dfs(int count, int now, String[] words, String target){
        if(words[now].equals(target)){
            answer = Math.min(answer, count);
        }

        for (int i = 0; i < words.length; i++) {
            if(!visited[i] && compare(words[now], words[i]) == 1){
                visited[i] = true;
                dfs(count+1, i, words, target);
                visited[i] = false;
            }
        }
    }

    public static int compare(String s1, String s2){
        int count = 0;
        for (int i = 0; i < s1.length() ; i++) {
            if(s1.charAt(i) != s2.charAt(i)) count++;
        }
        return count;
    }
}
