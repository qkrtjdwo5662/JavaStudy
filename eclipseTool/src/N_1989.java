import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N_1989{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=tc; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			int l = 0;
			int answer =1;
			
			if(str.length()%2!=0) {
				l = str.length()/2+1;
			}else l = str.length()/2;
			
			
			for(int j=0; j<l; j++) {
				if(str.charAt(j) != str.charAt(str.length()-j-1)) {
					answer = 0;
					break;
				}
			}
            System.out.println("#"+i+" "+answer);
		}
	}
}