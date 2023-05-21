import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class InfiniteChar {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int tc = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <=tc; i++) {
			String answer = "yes";
			st = new StringTokenizer(br.readLine());
			String str1 = st.nextToken();
			String str2 = st.nextToken();
			
			int str1Length = str1.length();
			int str2Length = str2.length();
			
			int min = Integer.MAX_VALUE;
			
			for(int j=1; j<Math.min(str1Length, str2Length); j++) {
				if(str1Length%j==0 && str2Length%j ==0) {
					min = Math.min((str1Length/j)*(str2Length/j)*j , min);
				}
			}
			
		
			for(int j=0; j<min; j++) {
				if(str1.charAt(j%str1Length) != str2.charAt(j%str2Length)) {
					answer ="no";
					break;
				}
				
			}
			System.out.println("#"+i+" "+answer);
		}
	}
}