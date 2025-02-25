package lang.object.tostring;

public class ToStringMain1 {
    public static void main(String[] args) {
        Object obj = new Object();
        String string = obj.toString();

        System.out.println(string);
        System.out.println(obj.toString());
        // 같은 값 출력
        // toString() : 객체이름 + 객체참조값(해시코드)를 16진수로 제공

        //println()은 내부적으로 toString()을 호출한다.
        System.out.println(obj);

        // toString() 만으로는 객체상태를 적절하게 나타내지 못함
        // 메서드 오버라이딩을 함


    }
}
