import java.util.Arrays;
import java.util.Scanner;
class Seat{
    private String name;

    void setInfo(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    void deleteInfo(){
        this.name = null;
    }
    void show(){
        if(name ==null){
            System.out.print(" ---");
        }else{
            System.out.print(" "+name);
        }
    }

}
class Reservation{
    private Scanner sc = new Scanner(System.in);
    private Seat [] s = new Seat[10];
    private Seat [] a = new Seat[10];
    private Seat [] b = new Seat[10];
    void reserve(){
        System.out.print("좌석구분 : S(1), A(2), B(3)>>");
        int select = sc.nextInt();
        char type = '0';
        switch (select){
            case 1:
                System.out.print("S>>");
                for(int i=0; i<s.length; i++){s[i].show();}
                System.out.println("");
                type = 's';
                break;
            case 2:
                System.out.print("A>>");
                for(int i=0; i<a.length; i++){a[i].show();}
                System.out.println("");
                type = 'a';
                break;
            case 3:
                System.out.print("B>>");
                for(int i=0; i<b.length; i++){b[i].show();}
                System.out.println("");
                type = 'b';
        }
        System.out.print("이름>>");
        String name = sc.next();
        System.out.print("번호>>");
        int num = sc.nextInt();

        if(type=='s'){
            s[num-1].setInfo(name);
        } else if (type=='a') {
            a[num-1].setInfo(name);
        } else if (type=='b') {
            b[num-1].setInfo(name);
        } else System.out.print("이상해");


    }
    void view(){
        System.out.print("S>>");
        for(int i=0; i<s.length; i++){s[i].show();}
        System.out.println("");
        System.out.print("A>>");
        for(int i=0; i<a.length; i++){a[i].show();}
        System.out.println("");
        System.out.print("B>>");
        for(int i=0; i<b.length; i++){b[i].show();}
        System.out.println("");
        System.out.println("조회 완료");

    }
    void cancel(){
        System.out.print("좌석 S:1, A:2, B:3>>");
        int select = sc.nextInt();
        char type = '0';
        switch (select){
            case 1:
                System.out.print("S>>");
                for(int i=0; i<s.length; i++){s[i].show();}
                System.out.println("");
                type = 's';
                break;
            case 2:
                System.out.print("A>>");
                for(int i=0; i<a.length; i++){a[i].show();}
                System.out.println("");
                type = 'a';
                break;
            case 3:
                System.out.print("B>>");
                for(int i=0; i<b.length; i++){b[i].show();}
                System.out.println("");
                type = 'b';
        }
        System.out.print("이름>>");
        String name = sc.next();
        if(type=='s'){
            for(int i=0; i<s.length; i++){
                if(name.equals(s[i].getName())){
                    s[i].deleteInfo();
                }
            }
        } else if (type=='a') {
            for(int i=0; i<a.length; i++){
                if(name.equals(a[i].getName())){
                    a[i].deleteInfo();
                }
            }
        } else if (type=='b') {
            for(int i=0; i<b.length; i++){
                if(name.equals(b[i].getName())){
                    b[i].deleteInfo();
                }
            }
        } else System.out.print("이상해");
    }

    void run(){
        for(int i=0; i<10; i++){
            s[i] = new Seat();
            a[i] = new Seat();
            b[i] = new Seat();
        }

        System.out.println("명품콘서트홀 예약 시스템입니다.");
        while(true) {
            System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4 >>");
            int select = sc.nextInt();
            switch (select) {
                case 1:
                    reserve();
                    break;
                case 2:
                    view();
                    break;
                case 3:
                    cancel();
                    break;
                case 4:
                    return;
            }
        }
    }
}
public class Exercise_4_12 {
    public static void main(String[] args){
        Reservation rv = new Reservation();
        rv.run();
    }
}
