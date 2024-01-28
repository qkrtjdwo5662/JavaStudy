import java.util.ArrayList;

public class TestDfs {
    public static int[] arr = {1,2,3,4,5,6,7,8, 9, 10, 11, 12, 13, 14, 15};

    public static void main(String[] args) {

        long a = System.currentTimeMillis();
        dfs(new ArrayList<>(), 0);
        long b = System.currentTimeMillis();
        long diff = (b - a) /1000;
        System.out.println(diff);
    }

    static void dfs(ArrayList<Integer> list, int depth){
        if(list.size() == 3){
            System.out.println(list);
            return;
        }else if(depth == arr.length){
            return;
        }

        list.add(arr[depth]);
        dfs(list, depth + 1);

        list.remove(list.size() - 1);
        dfs(list, depth + 1);

    }
}
