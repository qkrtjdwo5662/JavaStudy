package access.ex;

public class MaxCounter2 {
    private int count;
    private int max;

    public MaxCounter2(int max){
        this.max = max;
    }

    public void increment(){
        // 검증 로직
        if(count >= max){
            System.out.println("최대값 초과 불가");
            return;
        }

        // 실행 로직
        count++;
    }

    public int getCount(){
        return count;
    }
}
