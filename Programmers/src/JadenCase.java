public class JadenCase {
    public static String s ="  for the what 1what  ";

    public static void main(String[] args) {
        System.out.println(solution(s));
    }

    public static String solution(String s){
        StringBuilder sb = new StringBuilder();

        String[] arr = s.split(" ");
        for (int i = 0; i < arr.length; i++) {
            String[] strArr = arr[i].split("");
            for (int j = 0; j < strArr.length; j++) {
                if(j==0){
                    sb.append(strArr[j].toUpperCase());
                }else{
                    sb.append(strArr[j].toLowerCase());
                }

            }
            if(i != arr.length-1){
                sb.append(" ");
            }
        }
        if(sb.length() != s.length()){
            for (int i = sb.length(); i < s.length(); i++) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
