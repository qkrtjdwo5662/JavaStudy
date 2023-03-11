import java.util.Arrays;

public class HIndex {
    static int[] citations;

    public static void main(String[] args) {
        citations = new int[] {3,0,6,1,5};
        System.out.println(solution(citations));
    }

    static int solution(int[] citations)
    {
        int answer = 0;
        Arrays.sort(citations);
        System.out.println(citations[0]);
        for (int i = 0; i < citations.length; i++) {
            if(citations[i]==i+1 && citations[i]==citations.length-i){
                answer  = citations[i];
                return answer;
            }
        }
        return citations.length/2;
    }
}
