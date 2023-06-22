import java.util.Arrays;


public class PhoneNumberList_2 {
    public static String[] phone_book = {"119", "97674223", "1195524421"};
    public static String[] phone_book2 = {"12","123","1235","567","88"};
    public static void main(String[] args) {
        System.out.println(solution(phone_book));
    }
    public static boolean solution(String[] phone_book){
        boolean answer = true;

        Arrays.sort(phone_book);
        System.out.println(Arrays.toString(phone_book));
        for (int i = 0; i < phone_book.length-1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])){
                return false;
            }
        }
        // startsWith 메소드와 contains 메소드의 차이?
        // startsWith -> 해당 문자열로 시작하는지 체크
        // contains -> 특정 문자열을 포함하는지 체크
        // 이문제는 접두어로 사용되었는지에 대한 문제 이기에 startsWith가 맞음
        return answer;
    }
}
