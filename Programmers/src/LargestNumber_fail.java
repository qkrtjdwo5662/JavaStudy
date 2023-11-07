public class LargestNumber_fail {
    public static int[] numbers = {6, 10, 2};
    public static long result;
    public static boolean[] visited;
    public static void main(String[] args) {
        System.out.println(solution(numbers));
    }

    public static String solution(int[] numbers){
        result = 0;
        visited = new boolean[numbers.length];
        backtrack(0, "", numbers);

        return String.valueOf(result);
    }

    public static void backtrack(int depth, String now, int[] numbers){
        if(depth == numbers.length){
            result = Math.max(result, Integer.parseInt(String.valueOf(now)));
        }
        for (int i = 0; i < numbers.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                backtrack(depth+1, now+numbers[i], numbers);
                visited[i] = false;
            }
        }

    }
}
