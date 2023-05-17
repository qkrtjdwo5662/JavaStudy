import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class 백준_1987{
	private static class Node{
		int r, c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	private static final int rx[] = {0,0, -1, 1};
	private static final int ry[] = {1,-1, 0, 0};
	private static int answer =0;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		char[][] board = new char[r][c];
		boolean[] visited = new boolean['Z'-'A'+1];

		for(int i=0; i<board.length; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			for(int j=0; j<board[i].length; j++) {
				board[i][j] = s.charAt(j);
			}
		}
		visited[board[0][0]-'A'] = true;
		
		System.out.println(backtrack(new Node(0,0), board, visited, 1, r, c));
		
		
	}
	public static int backtrack(Node node, char[][] board, boolean[] visited, int count, int r, int c) {
		answer = Math.max(answer, count);
		
		for(int i=0; i<4; i++) {
			int nr = node.r+ry[i];
			int nc = node.c+rx[i];
			
			if(nr <0 || nc<0 || nr>=r || nc>= c) continue;
			if(visited[board[nr][nc]-'A']) continue;
			
			visited[board[nr][nc]-'A'] = true;
			backtrack(new Node(nc, nr), board, visited, count+1, r, c);
			visited[board[nr][nc]-'A'] = false;
		}
		return answer;
	}
}