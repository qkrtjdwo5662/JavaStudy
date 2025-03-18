package lang.clazz;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassMetaMain {
    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = String.class; // 1. 클래스에서 조회
//        Class clazz1 = new String().getClass();
//        Class clazz2 = Class.forName("java.lang.String");

        // 모든 필드 조회
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields){
            System.out.println(field.getType() + " " + field.getName());
        }

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        // 상위 클래스 정보
        System.out.println(clazz.getSuperclass().getName());

        // 인터페아스
        Class[] interfaces = clazz.getInterfaces();
        for (Class i : interfaces) {
            System.out.println(i.getName());
        }


    }
}
