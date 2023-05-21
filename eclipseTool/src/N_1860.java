import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N_1860{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=tc; i++) {
			String answer = "Possible";
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int [] person = new int[11112];
			
			for(int j=0; j<n; j++) {
				int index = Integer.parseInt(st.nextToken());
				person[index] = 1;
			}
			
			
			int [] time = new int[11112];
			int bread = 0;
			
			
			for(int j=0; j<time.length; j++) {
				if(j!=0 && j%m==0) {
					bread = bread + k;
				}
				if(person[j]==1) {
					bread = bread - 1;
					if(bread<0) {
						answer = "Impossible"; break;
					}else continue;
				}
				
			}
			sb.append("#" + i + " " + answer+"\n");
			
			
			
			
		}
		System.out.println(sb);
		
	}
}