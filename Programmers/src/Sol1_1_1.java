import java.util.Scanner;

class Solution {
    public long[] solution(int x, int n) {
        long[] answer = {};
        for(int i=0; i< answer.length; i++ ){
            answer[i] = x*(i+1);
        }
        return answer;
    }
}

public class Sol1_1_1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();

        Solution sol = new Solution();
        sol.solution(x, n);
    }
}
