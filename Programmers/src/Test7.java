import java.util.HashSet;

public class Test7 {
    public static int n=5;
    public static int[][] nationality = {{1,2}, {2,3}};
    public static void main(String[] args) {
        System.out.println(solution(n, nationality));
    }

    public static int solution(int n, int[][] nationality){
        int answer =0;

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nationality.length; i++) {
            set.add(nationality[i][0]);
            set.add(nationality[i][1]);
        }

        int equalNation = set.size();
        int other = n- set.size();

        answer = answer + (other * (other-1))/2;
        answer = answer + equalNation *other;
       return answer;
    }
}
