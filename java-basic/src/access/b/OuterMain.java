package access.b;

import access.a.AccessData;

public class OuterMain {
    public static void main(String[] args) {
        AccessData data = new AccessData();

        data.publicField = 1;
        data.publicMethod();

        //default 패키지 호출 불가
//        data.defaultField = 1;
//        data.defaultMethod();

//        data.privateField = 1;
//        data.privateMethod();

        data.innerAccess();
    }
}
