import java.util.Arrays;

public class MinRectangle_2 {
    public static int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
    public static void main(String[] args) {
        System.out.println(solution(sizes));
    }
    public static int solution(int[][] sizes){
        int answer = 0;

        int[] max = new int[sizes.length];
        int[] min = new int[sizes.length];

        for (int i = 0; i < sizes.length; i++) {
            max[i] = Math.max(sizes[i][0], sizes[i][1]);
            min[i] = Math.min(sizes[i][0], sizes[i][1]);
        }

        Arrays.sort(max);
        Arrays.sort(min);

        answer = max[sizes.length-1] * min[sizes.length-1];


        return answer;
    }
}
