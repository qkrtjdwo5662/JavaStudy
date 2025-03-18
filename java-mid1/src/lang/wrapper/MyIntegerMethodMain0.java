package lang.wrapper;

public class MyIntegerMethodMain0 {
    public static void main(String[] args) {
        int value = 10;
        // value와 target 비교
        int i1 = compareTo(value, 5);
        int i2 = compareTo(value, 10);
        int i3 = compareTo(value, 20);
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);
        // 외부 메서드를 만들고 이를 사용해서 비교함
        // value가 기본형 타입이기 때문에 이런 한계점이 있음

    }

    public static int compareTo(int value, int target){
        if(value < target){
            return -1;
        }else if(value > target){
            return 1;
        }else{
            return 0;
        }
    }
}
