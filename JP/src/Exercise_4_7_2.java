import java.util.Scanner;

class Day_E472{
    private String work;
    public void set(String work){
        this.work = work;
    }
    public String get(){
        return work;
    }
    public void show(){
        if(work == null) System.out.println("없습니다.");
        else System.out.println(work + "입니다.");
    }
}
class MonthSchedule_E472{
    private Scanner sc;
    private Day_E472[] day ;
    public MonthSchedule_E472(int days){
        day = new Day_E472[days];
        for(int i=0; i<days; i++){
            day[i] = new Day_E472();
        }
    }
    void input(){
        System.out.print("날짜(1~30)?");
        int days = sc.nextInt();
        System.out.print("할일(빈칸없이 입력)");
        String work = sc.next();
        day[days].set(work);
    }
    void view(){
        System.out.print("날짜(1~30)?");
        int days = sc.nextInt();
        day[days].show();
    }
    void finish(){
        System.out.println("종료");
    }
    void run(){
        sc = new Scanner(System.in);


        System.out.println("이번달 스케쥴 관리 프로그램");
        while(true) {
            System.out.print("입력:1, 보기:2, 끝내기:3");
            int select = sc.nextInt();
            switch (select){
                case 1: input(); break;
                case 2: view(); break;
                case 3: finish(); return;
            }

        }
    }
}
public class Exercise_4_7_2 {
    public static void main(String[] args) {
        MonthSchedule_E472 april = new MonthSchedule_E472(30);
        april.run();
    }
}
