package lang.wrapper;

public class MyIntegerNullMain1 {
    public static void main(String[] args) {
        MyInteger[] intArr = {new MyInteger(-1), new MyInteger(0), new MyInteger(1)};

        System.out.println(findValue(intArr, -1));
        System.out.println(findValue(intArr, 0));
        System.out.println(findValue(intArr, 1));
        System.out.println(findValue(intArr, 100));

        // -1을 찾았을때 -1을 반환하는 것과 target값을 배열로 부터 찾지 못했는데 -1을 반환하는 것이 어색함
        // 못찾았다라는 것 조차도 숫자로 반환함
        // 즉, 기본형의 한계다.
    }

    private static MyInteger findValue(MyInteger[] intArr, int target){
        for(MyInteger myInteger: intArr){
            if(myInteger.getValue() == target){
                return myInteger;
            }
        }

        return null; // 못찾으면 null 반환
    }
}
