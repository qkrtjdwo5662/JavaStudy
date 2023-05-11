package D2;

import java.util.Scanner;

public class N_2007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        int count = 0;
        for (int i = 1; i < sentence.length()/2; i++) {
            if(sentence.substring(0, i).equals(sentence.substring(i, i * 2))){
                count = i;
                break;
            }
        }
        System.out.println(count);
        sc.close();
    }
}
