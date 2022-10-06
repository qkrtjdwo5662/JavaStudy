import java.util.Scanner;
class Day{
    private String work;
    public void set(String work){
        this.work = work;
    }
    public String get(){
        return work;
    }
    public void show(){
        if(work==null) {
            System.out.println("없습니다");
        }else System.out.println(work + "입니다.");
    }
}
class MonthSchedule{
    private Day[] days;
    private Scanner sc = new Scanner(System.in);
    MonthSchedule(int day){
        days = new Day[day+1];
        for(int i=1; i<days.length; i++){
            days[i] = new Day();
        }// 1 ~ day.length Day 객체배열 생성
    }
    void input(){
        System.out.print("날짜(1~30)?");
        int day = sc.nextInt();
        System.out.print("할일(빈칸없이 입력)?");
        String work = sc.next();

        days[day].set(work);
    }
    void view(){
        System.out.print("날짜(1~30)?");
        int day = sc.nextInt();
        System.out.print(day+"일의 할 일은 ");

        days[day].show();
    }
    void finish(){
        System.out.println("프로그래밍 종료");
    }
    void run(){
        System.out.println("이번주 스케쥴 관리 프로그램.");

        while(true) {
            System.out.print("할일(입력:1, 보기:2, 끝내기:3) >>");
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    input(); break;
                case 2:
                    view(); break;
                case 3:
                    finish(); return;
            }
        }
    }
}
public class Exercise_4_7 {
    public static void main(String[] args){
        MonthSchedule april = new MonthSchedule(30);
        april.run();
    }
}
