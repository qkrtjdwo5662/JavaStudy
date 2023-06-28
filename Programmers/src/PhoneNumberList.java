import java.util.Arrays;

public class PhoneNumberList {
    public static String[] phone_book = {"119", "97674223", "1195524421"};
    public static void main(String[] args) {
        System.out.println(solution(phone_book));
    }

    public static boolean solution(String[] phone_book){
        boolean answer = true;

        Arrays.sort(phone_book);
        System.out.println(Arrays.toString(phone_book));

        for (int i = 0; i < phone_book.length-1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])){
                answer = false;
                break;
            }
        }

        return answer;
    }
}
