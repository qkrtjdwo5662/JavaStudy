package access.a;

public class AccessData {
    public int publicField;
    int defaultField;
    private int privateField;

    public void publicMethod(){
        System.out.println("public method");
    }

    void defaultMethod(){
        System.out.println("default method");
    }

    private void Method(){
        System.out.println("private method");
    }

    public void innerAccess(){
        System.out.println("내부 호출");
        privateField = 100;
        defaultField = 100;
        publicField = 100;

        //내부 호출은 접근제어자에 따르지 않고 모두 호출, 접근 가능
    }
}
