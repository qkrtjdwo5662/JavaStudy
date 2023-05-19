class Fatigue {
	public static int answer = 0;
	public static int k =80;
	public static int [][] dungeons = {{80,20},{50,40},{30,10}};
	public static boolean[] visited = new boolean[dungeons.length];
	public static void main(String[] args) {
		
		System.out.println(solution(k, dungeons));

	}
	public static int solution (int k, int[][] dungeons) {
	
		backtrack(k, dungeons, 0);
		
		return answer;
	}
	public static void backtrack(int k, int[][] dungeons, int count) {
		for(int i=0; i<dungeons.length; i++) {
			if(!visited[i] && k-dungeons[i][0]>=0 ) {
				visited[i] = true;
				backtrack(k-dungeons[i][1], dungeons, count+1);
				visited[i] = false;
			}
		}
		answer = Math.max(answer, count);
	}
}