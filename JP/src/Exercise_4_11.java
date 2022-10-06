import java.util.Scanner;

class Add{
    private int a;
    private int b;

    void setValue(int a, int b){
        this.a = a;
        this.b = b;
    }
    int calculate(){

        return a+b;
    }
}
class Sub{
    private int a;
    private int b;

    void setValue(int a, int b){
        this.a = a;
        this.b = b;
    }
    int calculate(){

        return a-b;
    }
}
class Mul{
    private int a;
    private int b;

    void setValue(int a, int b){
        this.a = a;
        this.b = b;
    }
    int calculate(){

        return a*b;
    }
}
class Div{
    private int a;
    private int b;

    void setValue(int a, int b){
        this.a = a;
        this.b = b;
    }
    int calculate(){

        return a/b;
    }
}
public class Exercise_4_11 {
    public static void main(String[] args){
        int result=0;

        System.out.print("두 정수와 연산자 입력>>");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        String operator = sc.next();
        switch (operator){
            case "+":
                Add add = new Add();
                add.setValue(a,b);
                result = add.calculate();
                break;
            case "-":
                Sub sub = new Sub();
                sub.setValue(a,b);
                result = sub.calculate();
                break;
            case "*":
                Mul mul = new Mul();
                mul.setValue(a,b);
                result = mul.calculate();
                break;
            case "/":
                Div div = new Div();
                div.setValue(a,b);
                result = div.calculate();
                break;

        }
        System.out.print(result);
        sc.close();
    }
}
