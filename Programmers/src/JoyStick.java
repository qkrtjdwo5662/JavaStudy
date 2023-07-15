public class JoyStick {
    public static String name1 = "JAZ";
    public static String name2 = "JEROEN";
    public static String name3 = "JAN";
    public static void main(String[] args) {
        System.out.println(solution(name3));
    }

    public static int solution(String name){
        // A : 65
        // Z : 90

        int answer = 0;
        int move = name.length() - 1;
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i); // 쪼개고

            int front = (int) c - 'A';
            int back = (int) 'Z' - c + 1;

            answer = answer + Math.min(front, back);

            int index = i+1;
            while(index < name.length() && name.charAt(index) == 'A'){
                index ++;
            }

            move = Math.min(move, i+ name.length() - index + Math.min(i, name.length() - index));

        }




        return answer + move;
    }
}
