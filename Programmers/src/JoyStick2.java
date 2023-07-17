public class JoyStick2 {
    public static String name1 = "JAZ";
    public static String name2 = "JEROEN";
    public static String name3 = "JAN";

    public static void main(String[] args) {
        System.out.println(solution(name2));
    }

    public static int solution(String name){
        int upAndDown = 0; // 위 아래 움직임 count
        int leftAndRight = name.length()-1;
        // 'A' : 65
        // 'Z' : 90

        for (int i = 0; i < name.length(); i++) {
            upAndDown = upAndDown + Math.min(name.charAt(i) - 'A', 'Z'-name.charAt(i) + 1); // 위 아래 최소 움직임

            if(i < name.length() -1 && name.charAt(i+1) == 'A'){
                int indexA = i+1; // A위치
                while(indexA < name.length() && name.charAt(indexA) == 'A'){
                    indexA ++;
                }
                leftAndRight = Math.min(leftAndRight, Math.min((name.length() - indexA)*2 + i , i*2 + (name.length() - indexA)));
            }

        }

        return upAndDown + leftAndRight;

    }
}
