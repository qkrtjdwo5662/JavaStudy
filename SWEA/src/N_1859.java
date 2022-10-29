import java.util.Scanner;

public class N_1859 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int array[] = new int[n];
        int max =0;
        int profit = 0;
        for(int i=0; i<array.length; i++){
            array[i] = sc.nextInt();
        }
        max = array[array.length-1];
        for(int i=array.length-1; i>=0; i--){
            if(max<array[i]) max = array[i];
            else profit = profit + max - array[i];
        }
        System.out.println(profit);

    }
}
