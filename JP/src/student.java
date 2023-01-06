import java.util.Scanner;

public class student {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        int temp = arr[0];
        int count =1;

        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }

        for(int i=1; i<arr.length; i++){
            if(temp<arr[i]){
                count ++;
                temp=arr[i];
            }
        }
        System.out.println(count);

    }
}
