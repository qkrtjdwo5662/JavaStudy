import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution());
    }
    public static int solution(){
        int answer = 0;

        String s = "1231";

        for (int i = 0; i < s.length()-2; i++) {
            System.out.println(s.substring(i,i+3));
            Integer.parseInt(String.valueOf(s.charAt(i)));
        }


        return answer;

    }
}
