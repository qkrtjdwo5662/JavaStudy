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
			boolean judge = false;
			for(int j=0; j<board.length; j++) {
				String s = br.readLine();
				for(int k=0; k<board[j].length; k++) {
					board[j][k] = s.charAt(k);
					if(s.charAt(k) == '#') {
						check[j][k]=1;
					}
				}
			}
			int count = 0;
		
			
			for(int j=1; j<board.length; j++) {
				for(int k=1; k<board[j].length; k++)
					if(check[j-1][k] == 1 && check[j-1][k-1] == 1 && check[j][k-1] == 1  ) {
						check[j][k] = check[j][k] + 1;
				}
			}
			
			
			for(int j=1; j<board.length; j++) {
				for(int k=1; k<board[j].length; k++) {
					if(check[j][k]>1) {
						judge = true;
						return;
					}
					else if(check[j][k]==1) {
						count ++;
					}
				}
			}
			if(count ==1) judge = true;
			
			System.out.println("#" + i+ " " + judge);
		}
	}
}