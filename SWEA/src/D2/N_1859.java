package D2;

import java.util.Scanner;

public class N_1859 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        int[] result = new int[tc];

        for (int i = 1; i < result.length+1; i++) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int j = 0; j < array.length; j++) {
                array[j] = sc.nextInt();
            }
            int max = array[array.length-1];
            for (int j = array.length-1; j >=0 ; j--) {
                if(max>array[j]) result[i] = result[i] + (max-array[j]);
                else max = array[j];
            }
            System.out.println("#" + i + " " + result[i]);
        }
    }
}
