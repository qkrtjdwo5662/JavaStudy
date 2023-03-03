public class RectangleDot {
    static int v[][];
    public static void main(String[] args) {
//        v = new int[][]{{1, 4}, {3, 4}, {3, 10}};
        v = new int[][]{{1, 1}, {2, 2}, {1, 2}};
        System.out.println(solution(v)[0]+" "+ solution(v)[1]);

    }
    static int[] solution(int[][] v){
        int[] answer = new int[2];
        int checkX = 0;
        int checkY = 0;
        int otherX = 0;
        int otherY = 0;
        for (int i = 1; i < v.length; i++) {
            if(v[0][0]!=v[i][0]) {
                checkX ++;
                otherX = i;
            }
        }
        for (int i = 1; i < v.length; i++) {
            if(v[0][1]!=v[i][1]) {
                checkY ++;
                otherY = i;
            }
        }

        if(checkX==2){
            answer[0] = v[0][0];
        }else answer[0] =v[otherX][0];

        if(checkY==2){
            answer[1] = v[0][1];
        }else answer[1] = v[otherY][1];

        return answer;
    }
}
