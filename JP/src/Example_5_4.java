class Human{}
class Student extends Human{}
class Researcher extends Human{}
class Professor extends Researcher {}

public class Example_5_4 {
    static void print(Human h){
        if(h instanceof Human)
            System.out.print("Person ");
        if(h instanceof Student)
            System.out.print("Person ");
        if(h instanceof Researcher)
            System.out.print("Person ");
        if(h instanceof Professor)
            System.out.print("Person ");


    }

    public static void main(String[] args) {
        System.out.print("new Student() -> \t");
        print(new Student());
        System.out.print("new Researcher() -> \t");
        print(new Researcher());
        System.out.print("new Professor() -> \t");
        print(new Professor());

    }
}
