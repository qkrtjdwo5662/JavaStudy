import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class N_1289{
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine()); 
		
		for(int i=1; i<=tc; i++) {
			int answer = 0;
			
			String s= br.readLine();
			int[] arr = new int[s.length()];
			
			for(int j=0; j<arr.length; j++) {
				arr[j] = s.charAt(j)-'0';
			}
			
			int[] initial = new int[arr.length];
			
			for(int j=0; j<arr.length; j++) {
				
			}
			
			System.out.println("#"+i+" " + answer);
		}
	}
}