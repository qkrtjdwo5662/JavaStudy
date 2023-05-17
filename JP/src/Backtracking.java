public class Backtracking {

        public static final char alphabet[] = {'A','B','C','D'};
        public static final boolean visited[] = new boolean[4];

        public static void main(String[] args) {
            backtrack("");
        }

        public static void backtrack(String s) {
            if(s.length()==4) {
                System.out.println(s);
                return;
            }
            for(int i=0; i<alphabet.length; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    backtrack(s+alphabet[i]);
                    visited[i] = false;
                }
            }

        }
}
