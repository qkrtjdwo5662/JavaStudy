import java.util.Scanner;
public class N_1206 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int height = sc.nextInt();
        int array[] = new int[height+1];
        int max =0;
        int count =0;
        for(int i=1; i<array.length; i++){
            array[i] = sc.nextInt();
        }

        for(int i=3; i<=array.length-2; i++){
            if(array[i]>array[i-1] && array[i]>array[i-2] &&
                array[i]>array[i+1] && array[i]>array[i+2]){
                max = Math.max(Math.max(array[i-2],array[i-1]),Math.max(array[i+1],array[i+2]));
                count = count + array[i]-max;
            }
        }
        System.out.println(count);
    }
}
