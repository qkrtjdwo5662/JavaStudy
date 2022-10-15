import java.util.Arrays;
import java.util.Scanner;
public class MinAndMax {
    public String solution(String s) {
        String answer = "";
        String []strings = s.split(" ");//문자열 자르기
        int []arr = new int[strings.length];

        for(int i=0; i<strings.length; i++)
        {
            arr[i] = Integer.parseInt(strings[i]);//String to int
        }
        Arrays.sort(arr);
        answer = arr[0] + " " + arr[arr.length-1];
        return answer;

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        MinAndMax mm = new MinAndMax();
        System.out.println(mm.solution(s));
    }
}
