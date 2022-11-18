import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T[] = new int[11];

        for (int test_case = 1; test_case < T.length; test_case++) {
            int width = sc.nextInt();
            int []buildings  = new int[width];
            int max;
            int count=0;
            for(int i=0; i<buildings.length; i++){
                buildings[i] = sc.nextInt();
            }
            for(int i=2; i<buildings.length-2; i++){
                if(buildings[i]>buildings[i-2] && buildings[i]>buildings[i-1]
                        && buildings[i]>buildings[i+1] && buildings[i]>buildings[i+2]) {
                    max = Math.max(Math.max(buildings[i-2],buildings[i-1]),Math.max(buildings[i+1],buildings[i+2]));
                    count = count+buildings[i]-max;
                }
            }
            System.out.println("#"+test_case + " "+count);
        }
    }
}