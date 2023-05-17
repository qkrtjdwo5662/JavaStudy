import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class 백준_15649{
	public static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int count = 0;
		visited = new boolean[n+1];
		backtrack(n,m,"", count);
		
	}
	public static void backtrack(int n, int m, String s, int count) {
		if(count == m) {
			System.out.println(s.trim());
			return;
		}
		for(int i=1; i<=n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				backtrack(n, m,s+" "+i, count+1);
				visited[i] = false;
			}
		}
	}
}

