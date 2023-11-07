import java.util.Arrays;

public class HIndex_2 {
    public static int[] citations = {3, 0, 6, 1, 5};
    public static void main(String[] args) {
        System.out.println(solution(citations));
    }

    public static int solution(int[] citations){
        int answer = 0;
        int n = citations.length;
        // n편의 논문 중
        // h번 이상이 인용된 것이 h번
        // h번 이하

        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int count = n - i;

            if(count <= citations[i]) {
                answer = count;
                break;
            }
        }

        return answer;
    }
}
