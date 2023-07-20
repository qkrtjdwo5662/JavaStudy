import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class ParkingFee {
    public static int[] fees = {180, 5000, 10, 600}; // 기본 시간, 기본 요금, 단위 시간, 단위 요금
    public static String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(fees, records)));
    }

    public static int[] solution(int[] fees, String[] records){
        HashMap<String, String> timeRecord = new HashMap<>();
        HashMap<String, Boolean> flagRecord = new HashMap<>();
        ArrayList<Integer> carNum = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" "); // 시간, 차량번호, 행휘
            String[] time = record[0].split(":");
            int hour = Integer.parseInt(time[0]);
            int minute = Integer.parseInt(time[1]);

            if(record[2].equals("IN")){ // in
                if(!timeRecord.containsKey(record[1])){
                    timeRecord.put(record[1], String.valueOf(hour * 60 + minute));
                    flagRecord.put(record[1], false);
                    carNum.add(Integer.parseInt(record[1]));
                }else{
                    timeRecord.put(record[1], timeRecord.get(record[1])+" " +(hour * 60 + minute));
                    flagRecord.put(record[1], false);
                }
            }else{ // out
                timeRecord.put(record[1], timeRecord.get(record[1])+"~" +(hour * 60 + minute));
                flagRecord.put(record[1], true);
            }
        }

        for(String key: flagRecord.keySet()){
            if(!flagRecord.get(key)) timeRecord.put(key, timeRecord.get(key) +"~"+"1439");
        }

        Collections.sort(carNum);
        for (int i = 0; i < carNum.size(); i++) {
            for(String key:timeRecord.keySet()){
                if(carNum.get(i) == Integer.parseInt(key)){ // carNum과 key와 같으면
                    //계산 시작
                    int n = 0;
                    String s = timeRecord.get(key);
                    String[] divide = s.split(" "); // 입~출 입~출 형태
                    for (int j = 0; j < divide.length; j++) {
                        String[] divide2 = divide[j].split("~"); // 입, 출 형태
                        n = n+ Integer.parseInt(divide2[1]) - Integer.parseInt(divide2[0]); // n에 넣어주고
                    }

                    if(n <= fees[0]) { // 기본 시간 보다 작으면
                        n = fees[1];// 기본 요금
                    }else{ // 기본 시간보다 크면
                        double a = (double) (n-fees[0]) / fees[2];
                        a = Math.ceil(a);
                        n = (int) (fees[1] +  (a * fees[3]));
                    }
                    result.add(n);
                }
            }
        }

        int[] answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

}
