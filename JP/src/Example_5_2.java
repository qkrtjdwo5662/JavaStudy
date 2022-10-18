class PersonE52{
    private int weight;
    int age;
    protected int height;
    public String name;

    public void setWeight(int weight){
        this.weight = weight;
    }
    public int getWeight(){
        return height;
    }
}
class StudentE52 extends PersonE52{
    public void set(){
        age = 30;
        name="홍길동";
        height = 175;
        setWeight(99);
    }
}
public class Example_5_2 {
    public static void main(String[] args){
        StudentE52 s = new StudentE52();
        s.set();
    }
}
