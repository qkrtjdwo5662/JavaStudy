package access.ex;

public class MaxCounter {
    private int count;
    private int max;

    public MaxCounter(int max) {
        this.max = max;
    }

    public void increment(){
        // 검증 로직
        if(count >= max){
            System.out.println("최댓값 도달");
            return;
        }

        // 실행 로직
        count += 1;
    }

    public int getCount(){
        return count;
    }

}
