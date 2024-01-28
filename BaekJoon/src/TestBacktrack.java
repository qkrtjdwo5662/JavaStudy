import java.util.ArrayList;

public class TestBacktrack {
    public static int[] arr = new int[1000];
    public static void main(String[] args) {

        long a = System.currentTimeMillis();
        boolean[] visited = new boolean[arr.length];
        backtrack(new ArrayList<>(), 0, visited);
        long b = System.currentTimeMillis();

        long diff = (b-a) / 1000;
        System.out.println(diff);
    }

    public static void backtrack(ArrayList<Integer> list, int index, boolean[] visited){
        if(list.size() == 3){
//            System.out.println(list);
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                list.add(arr[i]);
                backtrack(list, i, visited);
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
    }
}
