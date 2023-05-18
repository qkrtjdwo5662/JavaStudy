class FindDecimal{
	private static final int [] numbers = {1,2,3};
	private static final boolean [] visited = new boolean[numbers.length];
	private static final int length = numbers.length;
	public static void main(String[] args) {
		int depth = 2;
		
		backtrack("", depth);
	}
	public static void backtrack(String s, int depth) {
		if(s.length()==depth) {
			System.out.println(s);
			return;
		}
		
		for(int i=0; i<numbers.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				backtrack(s+numbers[i], depth);
				visited[i] = false;
			}
		}
	}
}