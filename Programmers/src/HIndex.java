import java.util.Arrays;

public class HIndex {

    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5};
        System.out.println(solution(citations));
    }

    static int solution(int[] citations)
    {
        int answer = 0;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            answer = citations.length - i;
            if(citations[i] >= answer) return answer;
        }
        return 0;
    }
}
