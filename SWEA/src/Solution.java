import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T[] = new int[10];

        for(int test_case = 1; test_case <= T.length; test_case++)
        {
            int weight = sc.nextInt();
            int array[] = new int[weight+1];
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
            T[test_case] = count;
        }

        for(int test_case = 1; test_case <= T.length; test_case++)
        {
            System.out.println("#"+ test_case + T[test_case]);


        }
    }
}