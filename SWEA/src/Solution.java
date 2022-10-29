import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        int profit =0;
        for(int test_case = 1; test_case <= T; test_case++) {
            profit =0;
            int n = sc.nextInt();
            int array[] = new int[n];
            int max =0;
            for(int i=0; i<array.length; i++){
                array[i] = sc.nextInt();
            }
            max = array[array.length-1];
            for(int i=array.length-1; i>=0; i--){
                if(max<array[i]) max =array[i];
                else profit = profit + max-array[i];
            }
            System.out.println("#"+ test_case+" "+profit );
        }
    }
}