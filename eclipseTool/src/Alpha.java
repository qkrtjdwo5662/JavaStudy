import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Alpha{
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=tc; i++) {
			
			String s = br.readLine();
			int count = 0;
			for(int j=0; j<s.length(); j++) {
				if((int)(s.charAt(j)-'a')==j) {
					count ++;
				}else break;
			}
			System.out.println("#"+i+" " + count);
		}
		
	}
}