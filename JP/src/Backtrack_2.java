public class Backtrack_2 {
    private static final char[] alpha = {'A', 'B', 'C', 'D'};
    public static void main(String[] args) {
        backtrack("");
    }
    private static void backtrack(String s){
        if(s.length() == 4){
            System.out.println(s);
            return;
        }

        for (int i = 0; i < 4; i++) {
            backtrack(s+alpha[i]);
        }
    }
}
