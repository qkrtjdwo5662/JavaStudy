import java.io.IOException;
import java.util.Scanner;

public class nextNumber {
    public static void main(String[] args) throws IOException {
        Scanner sc =new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print(solution(arr));
    }
    static int solution(int[] common) {
        int answer = 0;
        int d=0;

        if(common[1]-common[0]!=common[2]-common[1]){
            //공비
            d = common[1]/common[0];
            answer = common[common.length-1]*d;
        }else{
            //공차
            d = common[1] - common[0];
            answer = common[common.length-1]+d;
        }

        return answer;
    }
}
