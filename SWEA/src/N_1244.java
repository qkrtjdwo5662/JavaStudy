import java.util.Scanner;
public class N_1244 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int index =0;
        int max =0;
        String number = Integer.toString(n);
        int N[] = new int[number.length()];
        for(int i=0; i<number.length(); i++){
            N[i] = number.charAt(i)-'0';
        }
        for(int i=0; i<N.length; i++){
            if(max<N[i]){
                max = N[i];
            }
        }
        for(int i=0; i<N.length; i++){
            System.out.print(N[i]+" ");
        }

    }
}
