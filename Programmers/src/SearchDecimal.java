import java.util.HashSet;

public class SearchDecimal {
    public static String numbers = "011";

    public static int answer = 0;
    public static int n;
    public static boolean[] visited;
    public static HashSet<Integer> set;
    public static void main(String[] args) {
        System.out.println(solution(numbers));
    }

    public static int solution(String numbers){
        answer = 0;
        set = new HashSet<>();
        n = numbers.length();
        visited = new boolean[n];
        dfs("", 0, numbers);

        System.out.println(set);
        return set.size();
    }

    public static void dfs(String now, int depth, String numbers){
        if(depth == n){
            if(check(now)){
                set.add(Integer.parseInt(now));
            }
            return;
        }

        if(depth!= 0 && check(now)){
            set.add(Integer.parseInt(now));
        }

        for (int i = 0; i < numbers.length(); i++) {
            if(!visited[i]){
                visited[i] = true;
                dfs(now+numbers.charAt(i), depth+1, numbers);
                visited[i] = false;
            }
        }


    }

    public static boolean check(String s){
        int num = Integer.parseInt(s);
        if(num == 1 || num == 0) return false;

        for (int i = 2; i < num; i++) {
            if(num % i == 0){
                return false;
            }
        }


        return true;
    }
}
