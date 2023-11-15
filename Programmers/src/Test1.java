import java.util.ArrayList;

public class Test1 {
    private static final boolean [] visited = new boolean[7];
    public static ArrayList<Integer> arrList = new ArrayList<>();
    public static String numbers = "17";

    public static void main(String[] args) {
        System.out.println(solution(numbers));
    }

    public static int solution(String numbers) {
        int answer = 0;

        for(int i=1; i<=numbers.length(); i++) {
            backtrack("", i, numbers);
        }

        for(int i=0; i<arrList.size(); i++) {
            if(check(arrList.get(i))) answer++;
        }
        System.out.println(arrList);
        return answer;
    }
    public static void backtrack(String s, int depth, String numbers) {
        if(s.length()==depth) {
            int num = Integer.parseInt(s);
            System.out.println(num + " " + depth);
            if(!arrList.contains(num)) {
                arrList.add(num);
            }
            return;
        }
        for(int i=0; i<numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                backtrack(s+numbers.charAt(i), depth, numbers);
                visited[i] = false;
            }
        }
    }
    public static boolean check(int n) {
        if(n<2) return false;

        for(int i=2; i<n; i++) {
            if(n%i==0) return false;
        }

        return true;
    }
}