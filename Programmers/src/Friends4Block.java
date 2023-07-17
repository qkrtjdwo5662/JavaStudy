import java.util.ArrayDeque;

public class Friends4Block {
    public static int m = 4;
    public static int n = 5;
    public static String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
    public static int[] rx = {0, 0, 1, 1};
    public static int[] ry = {0, 1, 0, 1};
    public static void main(String[] args) {
        System.out.println(solution(m, n, board));
    }
    public static int solution(int m, int n, String[] board) {
        int answer = 0;

        char[][] map = new char[board.length][board[0].length()];
        boolean[][] visited = new boolean[map.length][map[0].length];


        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }

        while(true){
            ArrayDeque<int[]> arrayDeque = new ArrayDeque<>();
            boolean flag = false;

            for (int i = 0; i < map.length-1; i++) {
                for (int j = 0; j < map[0].length-1; j++) {
                    if(map[i][j]!='0'&& map[i][j] == map[i][j+1] && map[i][j] == map[i+1][j] && map[i][j] == map[i+1][j+1]){
                        for (int k = 0; k < 4; k++) { // 자신, 오른쪽, 아래, 대각선
                            int r = i+ry[k];
                            int c = j+rx[k];
                            if(!visited[r][c]) {
                                visited[r][c] = true;
                                answer++;
                                flag = true; // 블록 깨짐 표시
                                arrayDeque.addLast(new int[]{r,c}); // queue에 넣어주고
                            }
                        }
                    }
                }
            }

            if(!flag) break; // 블록 안깨졌으면 탈출

            while(!arrayDeque.isEmpty()){ // 깨짐 표시
                int[] poll = arrayDeque.pollFirst();
                map[poll[0]][poll[1]] = '0';
                visited[poll[0]][poll[1]] = false;
            }

            for (int i = map.length-1; i >0 ; i--) {
                for (int j = 0; j < map[0].length; j++) {
                    if(map[i][j] == '0'){
                        for (int k = i-1; k >=0 ; k--) {
                            if(map[k][j] !='0'){
                                map[i][j] = map[k][j];
                                map[k][j] = '0';
                                break;
                            }

                        }
                    }
                }
            }

        }



        return answer;
    }
}
