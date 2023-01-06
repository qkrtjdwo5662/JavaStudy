import java.util.Scanner;

public class Array_Solution11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int array[][] = new int[n][5];
        int result=0;
        int count ;
        int max = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                array[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<n; i++){
            count =0;
            for(int j=0; j<n; j++){
                for(int k=0; k<5; k++){
                    if(array[i][k]==array[j][k]){
                        count++;
                        break;
                    }
                }
            }
            System.out.println(count);
            if(max < count){
                max = count;
                result = i+1;
            }
        }

        System.out.print(result);

    }
}
