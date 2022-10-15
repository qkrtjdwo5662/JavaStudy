import java.util.Scanner;

public class DemicalToBinary {
    public int Binary(int n){
        int result =0; //return 값
        int remainder = 0; // 나머지
        int count =0; //제곱 수
        double temp=0; //double을 담을 temp

        while(n!=0){
            remainder = n%2;
            temp = temp + remainder * Math.pow(10,count);
            count++;
            n=n/2;
        }
        result = (int)temp;
        return result;
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        DemicalToBinary db = new DemicalToBinary();
        System.out.print("2진수로 변환 할 10진수 입력 : ");
        int n = sc.nextInt();

        System.out.println(db.Binary(n));


    }
}
