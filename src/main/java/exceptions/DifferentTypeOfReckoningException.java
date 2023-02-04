package exceptions;

public class DifferentTypeOfReckoningException extends Exception {
    public DifferentTypeOfReckoningException() {
        super("throws Exception //т.к. используются одновременно разные системы счисления");
    }
}
