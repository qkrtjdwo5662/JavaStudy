import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution02{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int tc = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=tc; i++) {
			int answer = 0;
			
			
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			int[]ld = new int[d] ;
			int[]rd =new int[d];
			
			int[] delay = new int[d];
			
			
			for(int j=0; j<n; j++) {
				st = new StringTokenizer(br.readLine());
				
				int index = Integer.parseInt(st.nextToken());
				int el = Integer.parseInt(st.nextToken());
				
				delay[index] = el;
			}
			
			for(int j=0; j<d; j++) {
				ld[j] = ld[j]+1;
				rd[j] = d-j;
				
				if(delay[ld[j]]!=0) {
					for(int k=0; k<ld[j]; k++) {
						
					}
				}
			}
			
			
			System.out.println("#"+i+" " + answer);
		}
	}
}