public class Toss_2022 {
//    public static String s = "12223";
//    public static String s = "111999333";
//    public static String s = "123";
    public static String s = "1000123";
    public static void main(String[] args) {
        System.out.println(solution(s));
    }
    public static int solution(String s){
        int answer = 0;
        int max = -1;
        for (int i = 0; i < s.length()-2; i++) {
            if(s.charAt(i) == s.charAt(i+1) && s.charAt(i+1) == s.charAt(i+2)){
                StringBuilder sb = new StringBuilder();
                sb.append(s.charAt(i)).append(s.charAt(i+1)).append(s.charAt(i+2));
                int num = Integer.parseInt(sb.toString());
                max = Math.max(max, num);
            }
        }
        if(max == -1) return -1;
        else return max;
    }
}
