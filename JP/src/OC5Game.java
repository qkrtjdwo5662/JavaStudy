import java.awt.*;

public class OC5Game {
    public static final int MAX_X = 20;
    public static final int MAX_Y = 10;
    private char map[][] = new char[MAX_Y][MAX_X];
    private Openchallenge5 m[]  =new Openchallenge5[2];

    public OC5Game(){
        for(int i=0; i<MAX_Y; i++){
            for(int j=0; j<MAX_X; j++)
                map[i][j] = '-';
            m[0] = new Bear(0,0,1);
            m[1] = new Fish(5,5,2);
        }
    }
    public void draw(){
        System.out.println();
        for(int i=0; i<MAX_Y; i++) {
            for (int j = 0; j < MAX_X; j++)
                System.out.print(map[i][j]);
            System.out.println();
        }
    }

    public void start(){
        System.out.println("** Bear의 Fish 먹기 게임 시작 **");
        update();
        draw();

        while(!doesEnd()) {
            clear();
            for(int i=0; i<m.length; i++)
                m[i].move();
            update();
            draw();
        }
        System.out.println("Bear Wins!!");;

    }
    private void update() {
        for(int i=m.length-1; i>=0; i--) // Fish���� ���� �׷��� Fish�� �Դ� ��� Fish�� ������ �ʱ�
            map[m[i].getY()][m[i].getX()] = m[i].getShape();
    }
    private void clear() {
        for(int i=0; i<m.length; i++)
            map[m[i].getY()][m[i].getX()] = '-';
    }
    private boolean doesEnd() {
        if(m[0].collider(m[1])) {// Bear ate Fish
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        OC5Game game = new OC5Game();
        game.start();
    }
}
