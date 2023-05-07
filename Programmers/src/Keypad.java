public class Keypad {
    public static void main(String[] args) {
        int [] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        System.out.println(solution(numbers,hand));
    }
    static public String solution(int[] numbers, String hand){
        StringBuilder sb= new StringBuilder();
        int lTemp =10;
        int RTemp =12;
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i]==1 || numbers[i]==4 || numbers[i]==7 ){ // 1, 4, 7 -> L
                sb.append("L");
                lTemp = numbers[i];
            } else if (numbers[i]==3 || numbers[i]==6 || numbers[i]==9) { // 3, 6, 9 -> R
                sb.append("R");
                lTemp = numbers[i];
            }else{ // 2, 5, 8, 0 -> l,r temp와의 거리비교
                if(numbers[i]!=0){ // 2, 5, 8
                    if()
                } else{ // 0

                }

            }
        }
        return sb.toString();
    }
}
