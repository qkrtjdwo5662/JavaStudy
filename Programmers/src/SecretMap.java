import java.util.Scanner;

public class SecretMap {
    public String[] solution(int n, int[] arr1) {

        String[] answer = new String[n];

        int bn = 0;
        int count =0;

        for(int i=0; i<n; i++){
            while(arr1[i] !=0){
                int remainder = arr1[i] %2;
                double temp = Math.pow(10,count);
                bn += remainder * temp;
                arr1[i] /=2;
                count++;
            }
            arr1[i]=bn;
        }
        for(int i=0; i<n; i++){
            answer[i] = answer[i]+arr1[i];
        }


        return answer;
    }

    public static void main(String[] args) {
        SecretMap sm = new SecretMap();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int []arr1 = new int[n];
        int []arr2 = new int[n];

        for(int i=0; i<n; i++){
            arr1[i] = sc.nextInt();
        }
//        for(int i=0; i<n; i++){
//            arr2[i] = sc.nextInt();
//        }
        sc.close();
        System.out.print(sm.solution(n,arr1));

    }
}
