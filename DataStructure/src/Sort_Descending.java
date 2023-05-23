import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Sort_Descending {
    public static void main(String[] args) {
        Integer [] array = {5, 4, 1, 6, 7, 8};
        Arrays.sort(array, Collections.reverseOrder());

        for(int i=0; i<array.length; i++){
            System.out.println(array[i]);
        }
    }
}
