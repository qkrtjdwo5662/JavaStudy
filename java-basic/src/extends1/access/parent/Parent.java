package extends1.access.parent;

public class Parent {
    public int publicValue;
    protected  int protectedValue;
    int defaultValue;
    private int privateValue;

    public void publicMethod(){
        System.out.println("public Method");
    }

    protected void protectedMethod(){
        System.out.println("private Method");
    }

    void defaultMethod(){
        System.out.println("default Method");
    }

    private void privateMethod(){
        System.out.println("private Method");
    }

    public void printParent(){
        System.out.println("------parent 메서드 -----");
        System.out.println(publicValue);
        System.out.println(protectedValue);
        System.out.println(defaultValue);
        System.out.println(privateValue);

        defaultMethod();
        privateMethod();
    }
}
