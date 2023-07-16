public class MakeLargeNumber {
    public static String number= "4177252841";
    public static int k = 9;
    public static int answer =0;
    public static boolean[] visited;
    public static void main(String[] args) {
        System.out.println(solution(number, k));
    }

    public static String solution(String number, int k){
//        if(k == 0) return number; // k는 1 이상
        visited = new boolean[number.length()];
        backtrack("", number.length() - k, number, -1);
        return String.valueOf(answer);
    }
    public static void backtrack(String s, int depth, String number, int index){
        if(s.length() == depth){
            answer = Math.max(answer, Integer.parseInt(s));
            return;
        }

        for (int i = index + 1; i < number.length(); i++) {
            if(!visited[i]){
                visited[i] = true;
                backtrack(s + number.charAt(i), depth, number, i);
                visited[i] = false;
            }

        }
    }
}
