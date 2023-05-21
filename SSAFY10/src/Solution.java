import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int tc = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=tc; i++) {
			int answer = 0;
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			int [] arr = new int [n];
			
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<arr.length; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			for(int j=0; j<arr.length; j++) {
				if((arr[j]+j>=0 && arr[j]+j<arr.length) &&( arr[j]+j+arr[arr[j]+j]>=0 &&arr[j]+j+arr[arr[j]+j]<arr.length ) ) {
					if(arr[j]==arr[arr[j]+j+arr[arr[j]+j]]) {
						answer ++;
					}else continue;
				}
			}
			
			System.out.println("#" + i + " " + answer/2);
		}
	}
}