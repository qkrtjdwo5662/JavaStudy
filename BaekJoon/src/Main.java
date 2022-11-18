import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int day = sc.nextInt();
        int k = sc.nextInt();
        int sum ;
        int max =Integer.MIN_VALUE;
        int[] tempArray = new int[day];

        for(int i=0; i<tempArray.length; i++)
        {
            tempArray[i] = sc.nextInt();
        }
        for(int i=0; i<tempArray.length-k+1; i++)
        {
            sum=0;
            for(int j=0; j<k; j++)
            {
                sum = sum + tempArray[i+j];

            }
            max = Math.max(max,sum);

        }
        System.out.println(max);
    }
}
