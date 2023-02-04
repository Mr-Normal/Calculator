package math;

public interface IOperator {
    int calculate(IOperand a, IOperand b);
    enum Type {
        ADDITION,
        SUBTRACTION,
        MULTIPLICATION,
        DIVISION,
        UNKNOWN
    }
}
