import java.util.Scanner;
import java.util.ArrayList;

public class rsp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];
        int B[] = new int[N];
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < B.length; i++) {
            B[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            if (A[i] == B[i]) {
                result.add("D");
            } else if (A[i] == 2 && B[i] == 1) {
                result.add("A");
            } else if (A[i] == 3 && B[i] == 1) {
                result.add("B");
            } else if (A[i] == 1 && B[i] == 2) {
                result.add("B");
            } else if (A[i] == 3 && B[i] == 2) {
                result.add("A");
            } else if (A[i] == 1 && B[i] == 3) {
                result.add("A");
            } else if (A[i] == 2 && B[i] == 3) {
                result.add("B");
            }
        }
        for(int i=0; i<result.size(); i++){
            System.out.println(result.get(i)+" ");
        }
    }
}
