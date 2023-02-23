import java.util.Arrays;
import java.util.Objects;

public class Maraton {


    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        System.out.println(solution(participant,completion));
    }

    static String solution(String[] participant, String[] completion){
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        for(int i=0; i<participant.length; i++){
            for(int j=0; j<completion.length; j++){
                if(Objects.equals(participant[i], completion[j])){
                    participant[i] = "0";
                    completion[j] = "0";
                } else if (j== completion.length-1) {
                    answer = participant[i];
                    break;
                }
            }
        }


        return answer;
    }
}
