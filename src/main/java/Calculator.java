import exceptions.DifferentTypeOfReckoningException;
import exceptions.InvalidOperationFormatException;
import math.IOperand;
import math.IOperator;
import math.MathFactory;

import java.util.ArrayList;

class Calculator {
    private final MathFactory mathFactory = new MathFactory();

    String calc(String input) throws
            DifferentTypeOfReckoningException,
            InvalidOperationFormatException {
        return calcPure(input.replaceAll(" ", ""));
    }

    private String calcPure(String formulaPure) throws
            DifferentTypeOfReckoningException,
            InvalidOperationFormatException {
        ArrayList<IOperand> operands = mathFactory.getOperands(formulaPure);
        if (operands.size() != 2) {
            throw new InvalidOperationFormatException();
        }
        IOperand a = operands.get(0);
        IOperand b = operands.get(1);
        if (a.getType() != b.getType()) {
            throw new DifferentTypeOfReckoningException();
        }
        IOperator operator = mathFactory.getOperator(formulaPure);
        int result = operator.calculate(a, b);
        return a.parse(result);
    }
}
