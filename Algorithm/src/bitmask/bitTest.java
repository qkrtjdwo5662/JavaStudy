package bitmask;

public class bitTest {
    public static void main(String[] args) {
        int x = 10;

        System.out.println("-------& 사용---------------");
        if((x & (1 << 3)) != 0){ // 3번 비트 켜져있는지 체크
            System.out.println("on");
        }

        System.out.println("-------^ 사용---------------");
        if((x & (1<< 3)) != 0){
            x = x ^ ( 1 << 3); // 3번 비트 꺼라
            System.out.println(x);
        }

        System.out.println("-------| 사용---------------");
        if((x &(1<<3)) == 0){
            x = x | (1 << 3); // 켜라
            System.out.println(x);
        }




    }
}
