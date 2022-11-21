import java.util.Scanner;
public class N_2775 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int result=0;

        if(b == 1)
        {
            result = 1;
        } else if (b==2) {
            result = a*1 + 2;
        }else {
            result = (a-1) + (a-2) + 6;
        }

        System.out.println(result);
    }
}
