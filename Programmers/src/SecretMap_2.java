public class SecretMap_2 {
    public static int n = 5;
    public static int[] arr1 = {9, 20, 28, 18, 11};
    public static int[] arr2 = {30, 1, 21, 17, 28};
    public static void main(String[] args) {
        System.out.println(solution(n, arr1, arr2));
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            StringBuilder elem1 = new StringBuilder(Integer.toString(arr1[i], 2));
            StringBuilder elem2 = new StringBuilder(Integer.toString(arr2[i], 2));

            if(elem1.length() != n){
                while(elem1.length() < n){
                    elem1 = new StringBuilder("0" + elem1);
                }
            }

            if(elem2.length() != n){
                while(elem2.length() < n){
                    elem2 = new StringBuilder("0" + elem2);
                }
            }

            StringBuilder union = new StringBuilder();

            for (int j = 0; j < n; j++) {
                if(elem1.charAt(j) == '1' || elem2.charAt(j) == '1') union.append('#');
                else union.append(' ');
            }

            answer[i] = union.toString();
        }



        return answer;
    }
}
