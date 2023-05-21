import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_13732{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=tc; i++) {
			int n = Integer.parseInt(br.readLine());
			char[][] board = new char[n][n];
			int[][] check = new int[n][n];
			String judge = "no";
			for(int j=0; j<board.length; j++) {
				String s = br.readLine();
				for(int k=0; k<board[j].length; k++) {
					board[j][k] = s.charAt(k);
					if(s.charAt(k) == '#') {
						check[j][k]=1;
					}
				}
			}
			int one_count = 0;
			int max_count = 0;
			
			for(int j=1; j<board.length; j++) {
				for(int k=1; k<board[j].length; k++)
					if(check[j][k]>0 ) {
						int min = Math.min(check[j-1][k], Math.min(check[j-1][k-1], check[j][k-1]));
						check[j][k] = min + 1;
				}
			}
			
			int max =0;
			for(int j=0; j<board.length; j++) {
				for(int k=0; k<board[j].length; k++) {
					if(check[j][k]>1) {
						if(max<check[j][k]) {
							max_count = 1;
							max = check[j][k];
						}else if(max == check[j][k]) max_count ++;
					}
					else if(check[j][k]==1) {
						one_count ++;
						continue;
					}
				}
			}
			if(one_count ==1) judge = "yes";
			if(max_count ==1) judge = "yes";
			System.out.println("#" + i+ " " + judge);
		}
	}
}