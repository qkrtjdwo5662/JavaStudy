package lang.math.test;

public class LottoGeneratorMain {
    public static void main(String[] args) {
        LottoGenerator generator = new LottoGenerator();
        int[] lottoNumbers = generator.generate();

        for (int lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber);
        }
    }
}
