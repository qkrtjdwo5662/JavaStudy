import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class CuttingLog{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=tc; i++) {
			String answer = "Alice";
			int n = Integer.parseInt(br.readLine());
			int count = 0;
			while(n>=2) {
				n = n/2;
				count = count+1;
				if(count%2 != 0) answer = "Bob";
			}
			System.out.println("#" + i + " "+ answer);
		}
		
		
	}
}
