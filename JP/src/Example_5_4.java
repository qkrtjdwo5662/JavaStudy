class PersonE54{ }
class Student extends PersonE54{ }
class Researcher extends PersonE54{ }
class Professor extends Researcher{ }

public class Example_5_4 {
    static void print(PersonE54 p){
        if(p instanceof PersonE54)
            System.out.print("Person");
            System.out.println("");
        if(p instanceof Student)
            System.out.print("Student");
            System.out.println("");
        if(p instanceof Researcher)
            System.out.print("Researcher");
            System.out.println("");
        if(p instanceof Professor)
            System.out.print("Professor");
            System.out.println("");
    }
    public static void main(String[] args) {
        System.out.print("new Person() -> \t");
        print(new PersonE54());
        System.out.print("new Student() ->\t");
        print(new Student());
        System.out.print("new Researcher() ->\t");
        print(new Researcher());
        System.out.print("new Professor() ->\t");
        print(new Professor());
    }
}