public class OverflowException extends Exception {
    public OverflowException(String s) {
        super(s);
    }
}
// Ha nem Exception-t, hanem RuntimeException-t terjesztünk ki, akkor nem kell try-catch blokk!!
