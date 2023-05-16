import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class N_1986{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int i=1; i<=tc; i++) {
			int n = Integer.parseInt(br.readLine());
			
			int answer = 0;
			for(int j=1; j<=n; j++) {
				if(j%2==0) {
					answer = answer - j;
					continue;
				}
				answer = answer + j;
			}
			
			System.out.println("#" + i + " " + answer);
		}
		
	}
}