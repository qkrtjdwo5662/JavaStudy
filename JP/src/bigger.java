import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bigger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr[]  = new int[n];
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<arr.length; i++)
        {
            arr[i] =sc.nextInt();
        }
        list.add(arr[0]);
        for(int i=1; i<arr.length-1; i++){
            if(arr[i]<arr[i+1]){
                list.add(arr[i+1]);
            }
        }
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i)+" ");
        }
    }
}
