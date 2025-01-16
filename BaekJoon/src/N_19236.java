import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N_19236 {
    static class Fish {
        boolean isFish;
        boolean isJaws;
        int num;
        int direction;

        public Fish(boolean isFish, boolean isJaws, int num, int direction) {
            this.isFish = isFish;
            this.isJaws = isJaws;
            this.num = num;
            this.direction = direction;
        }

        public Fish(Fish other) {
            this.isFish = other.isFish;
            this.isJaws = other.isJaws;
            this.num = other.num;
            this.direction = other.direction;
        }
    }

    static int max = 0;
    static final int MAP_SIZE = 4;
    static Fish[][] MAP = new Fish[MAP_SIZE + 1][MAP_SIZE + 1];
    static List<int[]>[] fishList = new ArrayList[17];
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] jawsPos = {0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 1; i <= 16; i++) {
            fishList[i] = new ArrayList<>();
        }
        for (int i = 1; i <= MAP_SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= MAP_SIZE; j++) {
                int num = Integer.parseInt(st.nextToken());
                int direction = Integer.parseInt(st.nextToken());

                fishList[num].add(new int[]{i, j});
                Fish fish = new Fish(true, false, num, direction - 1);
                MAP[i][j] = fish;
            }
        }

        int sum = 0;
        Fish fish = MAP[1][1];
        sum += fish.num;

        fishList[fish.num].remove(0);
        MAP[1][1] = new Fish(false, true, 0, fish.direction);
        jawsPos = new int[]{1, 1};

//        moveFish();
        moveJaws(sum);
        System.out.println(max);
    }

    static void moveFish() {
        for (int num=1; num <= 16; num++) { // 물고기 탐색

            if(fishList[num].size() == 0) continue; // 물고기 죽어있으면

            int[] now = fishList[num].get(0);
            int ny = now[0];
            int nx = now[1];

            Fish nowFish = MAP[ny][nx];

            if(num != nowFish.num ) {
                System.out.println("????");
                System.out.println(num);
                System.out.println(nowFish.num);
            }

            int d = nowFish.direction;

            for (int i = 0; i < 8; i++) {
                int r = ny + dy[(d + i) % 8];
                int c = nx + dx[(d + i) % 8];

                if (r < 1 || c < 1 || r > MAP_SIZE || c > MAP_SIZE) continue;

                Fish movePositionFish = MAP[r][c];
                if (movePositionFish.isJaws) continue; // 상어면

                int tempNum = nowFish.num;
                int tempDirection = nowFish.direction;

                MAP[ny][nx].num = movePositionFish.num; // 바뀐 위치에 바꿀 fish 넣어줌
                MAP[ny][nx].direction = movePositionFish.direction; // 바뀐 위치에 바꿀 fish 넣어줌

                MAP[r][c].num = tempNum; // 바꿀 위치에 nowFish 박아줌
                MAP[r][c].direction = tempDirection;

                if(fishList[movePositionFish.num].size() == 0){ // 바꿀 위치 물고기가 죽어있으면
                    nowFish.direction = (d + i) % 8;
                    fishList[nowFish.num].get(0)[0] = r;
                    fishList[nowFish.num].get(0)[1] = c;
                    break;
                }

                nowFish.direction = (d + i) % 8;
                fishList[nowFish.num].get(0)[0] = r;
                fishList[nowFish.num].get(0)[1] = c;
                fishList[movePositionFish.num].get(0)[0] = ny;
                fishList[movePositionFish.num].get(0)[1] = nx;
                break;
            }
        }
    }

    static void moveJaws(int now) {
        moveFish(); // 물고기들 움직여 놓고

        Fish jaws = MAP[jawsPos[0]][jawsPos[1]];
        int ny = jawsPos[0];
        int nx = jawsPos[1];
        int d = jaws.direction;
        boolean flag = false; // 물고기 먹었는지 여부
        for (int step = 1; step <= MAP_SIZE; step++) {
            int r = ny + (dy[jaws.direction] * step);
            int c = nx + (dx[jaws.direction] * step);

            if( r < 1 || c < 1 || r > MAP_SIZE || c > MAP_SIZE) break; // 영역 벗어남

            Fish nowFish = MAP[r][c];
            if(fishList[nowFish.num].size() != 0){ // 해당 위치 물고기 존재하면

                jaws.direction = nowFish.direction;
                MAP[r][c] = jaws;
                MAP[ny][nx] = nowFish;

                int[] temp = fishList[nowFish.num].get(0);
                fishList[nowFish.num].remove(0);
                jawsPos[0] = r;
                jawsPos[1] = c;

                flag = true;

                moveJaws(now + nowFish.num);

                jaws.direction = d;
                MAP[r][c] = nowFish;
                MAP[ny][nx] = jaws;

                fishList[nowFish.num].add(temp);
                jawsPos[0] = ny;
                jawsPos[1] = nx;
            }
        }

        if(!flag){ // 아무것도 못먹었으면
            max = Math.max(max, now);
        }

    }
}
