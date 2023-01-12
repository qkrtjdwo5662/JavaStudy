//import java.util.Scanner;
//
//public class DemicalToBinary {
//    public int Binary(int a, int b){
//        int result1 = 0;//return 값
//        int result2 = 0;
//        int remainder = 0; // 나머지
//        int count =0; //제곱 수
//        double temp=0; //double을 담을 temp
//
//        while(a!=0){
//            remainder = a%2;
//            temp = temp + remainder * Math.pow(10,count);
//            count++;
//            a=a/2;
//        }
//        result1 = (int)temp;
//
//        while(b!=0){
//            remainder = b%2;
//            temp = temp + remainder * Math.pow(10,count);
//            count++;
//            b=b/2;
//        }
//        result2 = (int)temp;
//
//        return result1; return result2;
//    }
//    public String Sharp(int n){
//        int result = Binary(n);
//        String answer ="";
//
//        answer = Integer.toString(result);
//        answer=answer.replace("1","#");
//        answer=answer.replace("0"," ");
//        return answer;
//    }
//    public static void main(String[] args) {
//        Scanner sc =new Scanner(System.in);
//        DemicalToBinary db = new DemicalToBinary();
//        System.out.print("2진수로 변환 할 10진수 입력 : ");
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        System.out.println(db.Binary(a));
//        System.out.println(db.Sharp(a));
//        System.out.println(db.Binary(b));
//        System.out.println(db.Sharp(b));
//
//
//    }
//}
