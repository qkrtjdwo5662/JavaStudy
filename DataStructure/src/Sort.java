import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] array = {3,2,1,2,3,5};

        Arrays.sort(array);

        for (int i : array) {
            System.out.println(i);
        }
    }
}
