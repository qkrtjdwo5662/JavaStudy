package construct;

public class MemberThis {
    String nameField;

    void initMember(String nameParameter){
        nameField = nameParameter;

        // 매개변수와 인스턴스변수 이름과 다르면 this 생략 가능
    }
}
