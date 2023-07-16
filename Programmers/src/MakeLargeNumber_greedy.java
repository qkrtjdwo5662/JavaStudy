public class MakeLargeNumber_greedy {
    public static String number= "4177252841";
    public static int k = 4;

    public static void main(String[] args) {
        System.out.println(solution(number, k));
    }

    public static String solution(String number, int k){
        StringBuilder answer = new StringBuilder();

        int max = 0;
        int index = 0;
        for (int i = 0; i < number.length() - k; i++) {
            max = 0;
            for (int j = index; j <=k+i; j++) {
                if(max < number.charAt(j) - '0'){
                    max = number.charAt(j) - '0';
                    index = j+1;
                }
            }
            answer.append(max);
        }


        return answer.toString();
    }
}
