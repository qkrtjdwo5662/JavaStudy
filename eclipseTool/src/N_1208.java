import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class N_1208 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int i=1; i<=10; i++) {
			int[] arr = new int[100];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int dump = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<arr.length; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			for(int j=0; j<dump; j++) {
				Arrays.sort(arr);
				arr[0] = arr[0]+1;
				arr[arr.length-1] = arr[arr.length-1]-1;
			}
			
			Arrays.sort(arr);
			System.out.println("#"+i+" "+(arr[arr.length-1] - arr[0]));
		}
		
		
	}
}