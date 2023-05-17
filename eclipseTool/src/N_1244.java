import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N_1244{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int tc = Integer.parseInt(st.nextToken());
		
		
		for(int i=1; i<=tc; i++) {
			st = new StringTokenizer(br.readLine());
			int answer = 0;
			
			int n = Integer.parseInt(st.nextToken());
			int count = Integer.parseInt(st.nextToken());
			
			answer = swap(n, count);
			System.out.println("#"+i+" "+answer);
		}
	}
	public static int swap(int n, int count) {
		
		return n;
	}
}