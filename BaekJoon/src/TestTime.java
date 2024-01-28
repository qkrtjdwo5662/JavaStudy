public class TestTime {
    public static void main(String[] args) {
        long beforeTime = System.currentTimeMillis(); // 코드 실행 전에 시간 받아오기

        int sum = 0;
        for (int i = 0; i < 100000; i++) {
            for (int j = 0; j < 50000; j++) {
                sum += i * j;
            }
        }
//        System.out.println(sum);

        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long diffTimeSec = (afterTime - beforeTime) / 1000; // 두 개의 실행 시간
        System.out.println("실행 시간(sec): " + diffTimeSec); // 세컨드(초 단위 변환)
    }
}
