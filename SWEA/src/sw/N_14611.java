package sw;

import java.util.ArrayList;
import java.util.Arrays;

public class N_14611 {
    static int joker;
    static ArrayList<Integer> cardList;
    void init(int mJoker, int mNumbers[]) {
        joker = mJoker;
        cardList = new ArrayList<>();
        for (int i = 0; i < mNumbers.length; i++) {
            cardList.add(mNumbers[i]);
        }

    }

    void putCards(int mDir, int mNumbers[]) {
        if(mDir == 0){
            // 왼쪽 배치
            for (int i = 0; i < mNumbers.length; i++) {
                cardList.add(i, mNumbers[i]);
            }

        }else{
            // 오른쪽 배치

            for (int i = 0; i <mNumbers.length ; i++) {
                cardList.add(mNumbers[i]);
            }
        }
    }

    int findNumber(int mNum, int mNth, int ret[]) {
        int count = 1;
        int index = 0;
        int sum = 0;

        for (int i = index; i < index + 4; i++) {
            if(cardList.get(i) == -1){
                sum += joker;
            }else{
                sum += cardList.get(i);
            }

        }
        int num = sum % 20;

        if(num == mNum){
            if(mNth == count){
                for (int i = index + 1; i <= index + 4; i++) {
                    ret[i-index - 1] = cardList.get(i);
                }
                return 1;
            }else count ++;
        }

        while(index <= cardList.size() - 5){
            sum -= cardList.get(index);
            sum += cardList.get(index + 4);

            num = sum % 20;
            if(num == mNum){
                if(mNth == count){
                    for (int i = index + 1; i <= index + 4; i++) {
                        ret[i-index - 1] = cardList.get(i);
                    }
                    return 1;
                }else count ++;
            }

            index++;

        }


        return 0;
    }

    void changeJoker(int mValue) {
        joker = mValue;
    }
}
