package exceptions;

public class FoundIllegalRomanNumeralsException extends Exception {
    public FoundIllegalRomanNumeralsException() {
        super("throws Exception //т.к. в римской системе нет отрицательных чисел");
    }
}
