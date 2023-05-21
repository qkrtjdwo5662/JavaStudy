import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


class N_2805{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int tc = Integer.parseInt(st.nextToken());
		for(int i=1; i<=tc; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[][] array = new int[n][n];
			
			
			for(int j=0; j<n; j++) {
				st = new StringTokenizer(br.readLine());
				String str = st.nextToken();
				for(int k=0; k<n; k++) {
					array[j][k] = str.charAt(k)-'0';
				}
			}
			
			int sum = 0;
			// 0 ~ array.length/2
			for(int j=0; j<=array.length/2; j++) {
				for(int k=array.length/2-j; k<=array.length/2+j; k++) {
					sum = sum + array[j][k];
				}
			}
			
			// array.length ~ array.length/2
			for(int j=array.length-1; j>array.length/2; j--) {
				for(int k=array.length/2-((array.length-1)-j); k<=array.length/2+((array.length-1)-j); k++) {
					sum = sum + array[j][k];
				}
			}
			System.out.println("#"+i+" "+sum);
			
		}
		
	}
}