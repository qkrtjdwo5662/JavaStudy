public class NBase {
    public static int n = 2;
    public static int t = 4;
    public static int m = 2;
    public static int p = 1;
    public static void main(String[] args) {
        System.out.println(solution(n, t, m, p));
    }
    public static String solution(int n, int t, int m, int p){
        // n : 진수
        // t : 넣어줘야 할 숫자의 개수
        // m : 같이 게임 하는 인원
        // p : 나의 순번
        StringBuilder answer = new StringBuilder();
        StringBuilder number = new StringBuilder();
        int num = 0;
        int index =0;
        while(answer.length() < t){
            number.append(Integer.toString(num, n)); // num -> n진수 변환
            for (int i = index; i < number.length(); i++) {
                if(i%m+1 == p) answer.append(String.valueOf(number.charAt(i)).toUpperCase());

                if(answer.length()==t) break;
                index++;
            }
            num ++;
        }


        return answer.toString();
    }
}
