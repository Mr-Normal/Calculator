package exceptions;

public class InvalidOperationFormatException extends Exception {
    public InvalidOperationFormatException() {
        super("throws Exception //т.к. строка не является математической операцией");
    }
}
