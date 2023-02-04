package math.operators;

import math.IOperand;
import math.IOperator;

public class OperatorDiv implements IOperator {
    @Override
    public int calculate(IOperand a, IOperand b) {
        return a.getInt() / b.getInt();
    }
}
