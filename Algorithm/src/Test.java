import java.util.LinkedList;

public class Test {

    public static void main(String[] args) {
        LinkedList<Integer> list= new LinkedList<>();

        list.add(1);
        list.add(2);

        System.out.println(list.size());
        System.out.println(list.get(0));
    }
}
