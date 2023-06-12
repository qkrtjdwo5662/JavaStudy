import java.util.Arrays;
import java.util.Stack;

public class StockPrice {
    public static int[] prices ={1,2,3,2,3,};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(prices)));
    }
    public static int[] solution(int[] prices){
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        int second = 0;
        for (int i = prices.length-1; i >=0; i--) {
            while(!stack.isEmpty() && stack.peek() <= prices[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                answer[i] = 1;
            }else{
                answer[i] = second;
            }
            stack.push(prices[i]);
            second ++;
        }
        answer[answer.length-1] = 0;

        return answer;
    }
}
