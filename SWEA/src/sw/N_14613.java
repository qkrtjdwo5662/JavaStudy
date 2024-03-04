package sw;

import java.util.ArrayList;
import java.util.HashMap;

public class N_14613
{
    static int MAX_LIST_SIZE = 11;

    static int[][] initList; // 원본 배열
    static HashMap<String, Integer> map; // 리스트 이름 -> 숫자로 매핑
    static HashMap<String, ArrayList<ArrayList<int[]>>> log; // 해당 리스트는 index의 원본 배열을 복사했는데, int[0]의 번째 값을 int[1]의 값으로 고침
    static int index;
    public void init()
    {
        initList = new int[MAX_LIST_SIZE][MAX_LIST_SIZE];
        map = new HashMap<>();
        index = 0;

    }
    static public String getName(char mName[]){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mName.length; i++) {
            sb.append(mName[i]);
        }

        return sb.toString();
    }
    static public void makeList(char mName[], int mLength, int mListValue[])
    {
        String name = getName(mName);
        map.put(name, ++index);
        initList[index] = mListValue;
    }

    public void copyList(char mDest[], char mSrc[], boolean mCopy)
    {
        String mDest_Name = getName(mDest);

        String mSrc_Name = getName(mSrc);
        int mSrc_Num = map.get(mSrc_Name);

        if(mCopy){ // 값 모두 복사
            map.put(mDest_Name, mSrc_Num);
        }else{ // 주소 복사
            map.put(mDest_Name, mSrc_Num);
        }
    }

    public void updateElement(char mName[], int mIndex, int mValue)
    {
        String name= getName(mName);

    }

    public int element(char mName[], int mIndex)
    {
        return 0;
    }

}