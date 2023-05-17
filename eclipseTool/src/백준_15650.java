import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_15650{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int count = 0;
		int number = 0;
		boolean visited[] = new boolean[n+1];
		
		backtrack("", n, m, count, number, visited);
		
	}
	public static void backtrack(String s, int n, int m, int count,int number,  boolean[] visited) {
		if(count==m) {
			System.out.println(s.trim());
			return;
		}
		
		for(int i=number+1; i<=n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				backtrack(s+" "+ i, n, m, count+1,i, visited);
				visited[i] = false;
			}
		}
	}
	
	
}