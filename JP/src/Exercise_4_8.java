import java.util.Scanner;

class Phone{
   private String name;
   private String tel;

   public void set(String name, String tel){
       this.name = name;
       this.tel = tel;
   }
   public String getName(){
       return name;
   }
   void show(){
       System.out.println("번호는 " + tel);
   }
}
class PhoneBook{
    private Phone[] phone;
    private Scanner sc = new Scanner(System.in);
    PhoneBook(int num){
        phone= new Phone[num];
        for(int i=0; i< phone.length; i++){
            phone[i] = new Phone();
        }
    }
    void input(){
        for(int i=0; i< phone.length; i++) {
            System.out.print("이름과 번호 입력>>");
            String name = sc.next();
            String tel = sc.next();
            phone[i].set(name, tel);
        }
        System.out.println("저장 완료");
    }
    void search(){
        int i;
        while(true) {
            System.out.print("검색할 이름>>");
            String name = sc.next();
            for (i = 0; i < phone.length; i++) {
                if (name.equals(phone[i].getName())) {
                    phone[i].show();
                    break;
                }
            }
            if(name.equals("그만")){
                return;
            }
            if(i== phone.length){
                System.out.println(name+"이 없습니다.");
            }

        }
    }
    void run(){
        input();
        search();
    }
}

public class Exercise_4_8 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("몇 명? >>");
        int num = sc.nextInt();

        PhoneBook pb = new PhoneBook(num);
        pb.run();
    }
}
