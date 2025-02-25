package lang.object.equals;


import java.util.Objects;

public class UserV2 {
    String id;

    public UserV2(String id){
        this.id = id;
    }

//    @Override
//    public boolean equals(Object obj){
//        UserV2 user = (UserV2) obj;
//        return id.equals(user.id);
//    }

    // 제대로 된 equals를 구현하기
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserV2 userV2 = (UserV2) o;
        return id.equals(userV2.id);
    }
    // 반사성, 대칭성, 추이성, 일관성의 규칙을 지켜야함
    // 일단 이 규칙들은 외울 필요 없고,
    // 근데 동일성 비교가 필요한 경우가 거의 없어서 재정의해서 사용하는 경우는 거의 없음
}

