import java.util.Scanner;

public class Score {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int arr[] = new int[N];
        int result=0;
        int temp=0;

        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        for(int i=0; i<arr.length; i++){
            if(arr[i]==1){
                temp++;
                result = result+temp;
            }else {
                temp = 0;
            }
        }
        System.out.print(result);
    }
}
