class Fatigue_2 {
	public static int [][] dungeons = {{80,20},{50,40},{30,10}};
	public static boolean[] visited = new boolean[dungeons.length];
	
	public static void main(String[] args) {
		
		backtrack("", 0);
	}
	public static void backtrack(String s, int depth) {
		if(depth==dungeons.length) {
			System.out.println(s);
		}
		for(int i=0; i<dungeons.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				backtrack(s+dungeons[i][0]+dungeons[i][1]+"/" , depth+1);
				visited[i] = false;
			}
		}
	}
}