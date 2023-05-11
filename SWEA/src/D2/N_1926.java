package D2;

import java.util.Scanner;

public class N_1926 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            if(i<10){ // 1~9
                if(i%3==0){ //3,6,9
                    System.out.print("- ");
                    continue;
                }
                System.out.print(i+" ");
                continue;
            }
            String strNum = Integer.toString(i);
            int count = 0;
            for (int j = 0; j < strNum.length(); j++) {
                if(strNum.charAt(j) =='3'||strNum.charAt(j) =='6' ||strNum.charAt(j) =='9'){
                    count = count+1;
                }
            }
            if(count==0){
                System.out.print(i+" ");
                continue;
            }
            for (int j = 0; j < count; j++) {
                System.out.print("-");
            }
            System.out.print(" ");
        }

    }
}
