package lang.wrapper;

public class MyIntegerNullMain0 {
    public static void main(String[] args) {
        int[] intArr = {-1, 0, 1, 2, 3};

        System.out.println(findValue(intArr, -1));
        System.out.println(findValue(intArr, 0));
        System.out.println(findValue(intArr, 1));
        System.out.println(findValue(intArr, 100));

        // -1을 찾았을때 -1을 반환하는 것과 target값을 배열로 부터 찾지 못했는데 -1을 반환하는 것이 어색함
        // 못찾았다라는 것 조차도 숫자로 반환함
        // 즉, 기본형의 한계다.
    }

    private static int findValue(int[] intArr, int target){
        for(int value: intArr){
            if(value == target){
                return value;
            }
        }

        return -1;
    }
}
