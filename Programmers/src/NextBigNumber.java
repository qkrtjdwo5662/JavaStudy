public class NextBigNumber {
    public static int n = 78;
    public static void main(String[] args) {
        System.out.println(solution(n));
    }

    public static int solution(int n){
        int count =0;
        String s = Integer.toString(n, 2);
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') count++;
        }

        while(true){
            n ++;
            int num = n;
            if(checkCount(count, num)){
                return n;
            }
        }

    }

    public static boolean checkCount(int count, int num){
        String s = Integer.toString(num, 2);

        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') answer++;
        }

        if(count == answer) return true;
        else return false;

    }
}
