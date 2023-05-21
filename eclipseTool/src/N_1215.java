import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class N_1215 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=1; i<=10; i++) {
			int len = Integer.parseInt(br.readLine());
			
			char [][] board = new char[8][8];
			
			for(int j=0; j<board.length; j++) {
				String s = br.readLine();
				for(int k=0; k<board[j].length; k++) {
					board[j][k] = s.charAt(k);
				}
			}
			
			int answer =0;
			
			
			for(int j=0; j<=board.length-len; j++) {
				
				for(int k=0; k<board[j].length; k++) {
					String str = "";
					boolean check = true;
					for(int l=0; l<len; l++) {
						str = str + String.valueOf(board[j+l][k]);
					}
					for(int l=0; l<str.length()/2; l++) {
						if(str.charAt(l)!=str.charAt(str.length()-1-l)) {
							check = false;
							continue;
						}
					}
					if(check) answer ++;
				}
				
			}
			for(int j=0; j<board.length; j++) {
				
				for(int k=0; k<=board[j].length-len; k++) {
					String str = "";
					boolean check = true;
					for(int l=0; l<len; l++) {
						str = str + String.valueOf(board[j][k+l]);
					}
					for(int l=0; l<str.length()/2; l++) {
						if(str.charAt(l)!=str.charAt(str.length()-1-l)) {
							check = false;
							continue;
						}
					}
					if(check) answer ++;
				}		
			}
			
			System.out.println("#" + i + " " + answer);
			
		}
		
		
		
		
		
	}
}