import java.util.Arrays;

public class ChangeBinary {
    public static String s = "01110";
    public static int zeroCount;
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(s)));
    }

    public static int[] solution(String s){
        int changeCount = 0;
        zeroCount = 0;

        while(!s.equals("1")){
            changeCount ++;
            s = change(s);
        }
        int[] answer = {changeCount, zeroCount}; // [0] : 이진변환 횟수, [1] : 제거된 0의 개수
        return answer;
    }

    public static String change(String s){
        // s의 0을 제거
        // s의 길이를 2진수로 변환
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0') zeroCount ++;
        }
        s = s.replace("0", "");
        int n = s.length();

        return Integer.toString(n, 2);

    }
}

// Integer.toString(number, n) -> n진수 변환