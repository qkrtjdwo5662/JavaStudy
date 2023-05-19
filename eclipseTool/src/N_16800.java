import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class N_16800{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=tc; i++) {
			long answer = Long.MAX_VALUE;
			long n = Long.parseLong(br.readLine());
		
			for(long j=1; j<=Math.sqrt(n); j++) {
				if(n%j==0) {
					 
					 answer = Math.min(answer, j+n/j-2);
				}
			}
			
			System.out.println("#"+i+" " + answer);
		}
		
	}
}