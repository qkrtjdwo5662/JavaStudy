import java.util.Scanner;

public class AlphabetOrder2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next().toLowerCase();
        char c = s.charAt(0);
        for(char i='a'; i<=c;i++){
            for(char j=i; j<=c; j++){
                System.out.print(j);
            }
            System.out.println("");
        }
    }
}

