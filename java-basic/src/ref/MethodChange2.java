package ref;

public class MethodChange2 {
    public static void main(String[] args) {
        Data dataA = new Data();
        dataA.value = 10;
        System.out.println(dataA.value);
        change(dataA);
        System.out.println(dataA.value);
    }

    public static void change(Data data){
        data.value = 20;
    }
}
