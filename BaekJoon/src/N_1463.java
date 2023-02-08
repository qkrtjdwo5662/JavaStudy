import java.util.Scanner;

public class N_1463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int count = 0;
        while(x!=1 && x!=0) {
            if (x % 3 == 0) {
                x =x/3;
            } else if (x%2==0) {
                if((x-1)%3==0){
                    x = x-1;
                }else{
                    x = x/2;
                }
            }
            else{
                x = x-1;
            }
            count++;
        }
        System.out.println(count);
    }
}
