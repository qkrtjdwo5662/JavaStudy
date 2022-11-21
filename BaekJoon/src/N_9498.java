import java.util.Scanner;
public class N_9498 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int score = sc.nextInt();
        sc.close();
        switch (score/10) {
            case 10:
            case 9:
                System.out.println("A");
                return;
            case 8:
                System.out.println("B");
                return;
            case 7:
                System.out.println("C");
                return;
            case 6:
                System.out.println("D");
                return;
            default:
                System.out.println("F");
                return;
        }

    }
}
