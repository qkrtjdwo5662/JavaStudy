import java.util.ArrayList;

public class ListArray {
    public static void main(String[] args) {
        ArrayList<Integer> list  = new ArrayList<>();
        int[] arr = {1,1,2,2,3,3,3,4,4};
//        for(int i=0; i<5; i++){
//            list.add(i);
//        }
//        for(int i=0; i<list.size(); i++){
//            System.out.println(list.get(i));
//        }

        for(int i=0; i< arr.length; i++){
            if(!list.contains(arr[i])){
                list.add(arr[i]);
            }
        }
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
