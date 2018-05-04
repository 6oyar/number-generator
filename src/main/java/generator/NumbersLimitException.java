package generator;

public class NumbersLimitException extends Exception {
    public NumbersLimitException() {
        super("The limit of issued numbers is reached");
    }
}
