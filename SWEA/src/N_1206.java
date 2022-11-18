import java.util.Scanner;

public class N_1206 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
    }
}
