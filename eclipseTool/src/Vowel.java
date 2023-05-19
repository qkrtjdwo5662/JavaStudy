class Vowel {
	public static char[] alpha= {'A','E','I','O','U'};
	public static void main(String[] args) {
		solution("");
	}
	public static int solution(String word) {
        int answer = 0;
        for(int i=0; i<=alpha.length; i++) {
        	backtrack("", i);
        }
        
        return answer;
        
    }
	public static void backtrack(String s, int depth) {
		if(depth == alpha.length) {
			System.out.println(s);
			return;
		}
		for(int i=0; i<alpha.length; i++) {
			backtrack(s+alpha[i], depth+1);
		}
	}
}