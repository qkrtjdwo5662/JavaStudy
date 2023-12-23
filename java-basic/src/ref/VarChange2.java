package ref;

public class VarChange2 {
    public static void main(String[] args) {
        Data dataA = new Data();
        dataA.value = 10;
        Data dataB = dataA;

        System.out.println(dataA);
        System.out.println(dataB);

        System.out.println(dataA.value);
        System.out.println(dataB.value);

        dataB.value = 20;

        System.out.println(dataA.value);
        System.out.println(dataB.value);

        //dataA, dataB 모두 같은 인스턴스의 참조값을 갖고 있으므로
        //참조 값을 통해 인스턴스의 value 값을 변경하므로 같이 변하게 됨
    }
}
