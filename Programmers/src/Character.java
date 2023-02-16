public class Character {
    public static void main(String[] args) {
        String[] keyinput= {"down", "down", "down", "down", "down"};
        int[] board={7,9};

        System.out.println(solution(keyinput,board)[0] +" "+ solution(keyinput,board)[1]);
    }
    static int[] solution(String[] keyinput, int[] board){
        int[] answer ={0,0};
        int x = board[0]/2;
        int y = board[1]/2;


        for (int i = 0; i < keyinput.length; i++) {
            switch (keyinput[i]){
                case "up":
                    answer[1] = answer[1]+1;
                    if(answer[1]>y){
                        answer[1]=y;
                        System.out.println("걸u");
                    }
                    break;
                case "down":
                    answer[1] = answer[1]-1;
                    if(answer[1]<-y){
                        answer[1]=-y;
                        System.out.println("걸d");
                    }
                    break;
                case "right":
                    answer[0] = answer[0]+1;
                    if(answer[0]>x){
                        answer[0]=x;
                        System.out.println("걸r");
                    }
                    break;
                case "left":
                    answer[0] = answer[0]-1;
                    if(answer[0]<-x) {
                        answer[0] = -x;
                        System.out.println("걸l");
                    }
                    break;
            }
        }
        return answer;
    }
}
