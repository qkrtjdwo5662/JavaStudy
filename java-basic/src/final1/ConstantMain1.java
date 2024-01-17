package final1;

public class ConstantMain1 {
    public static void main(String[] args) {
        System.out.println(Constant.MAX_USERS);
        int currentUserCount = 999;

        process(currentUserCount++);
    }

    private static void process(int currentUserCount){
        System.out.println(currentUserCount);

        if(currentUserCount > Constant.MAX_USERS){
            System.out.println("대기자");
        }else{
            System.out.println("게임 참여");
        }
    }
}
