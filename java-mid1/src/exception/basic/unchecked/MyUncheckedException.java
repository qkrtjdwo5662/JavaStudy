package exception.basic.unchecked;


/**
 * RuntimeException을 상속받은 exception은 uncheckedException이 된다.
 */
public class MyUncheckedException extends RuntimeException{
    public MyUncheckedException(String message){
        super(message);
    }
}
