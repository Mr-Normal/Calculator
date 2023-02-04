package math;

import math.operands.OperandArabic;
import math.operands.OperandRoman;
import math.operators.OperatorAdd;
import math.operators.OperatorDiv;
import math.operators.OperatorMulti;
import math.operators.OperatorSub;

import java.text.ParseException;
import java.util.ArrayList;

public class MathFactory {
    public IOperator getOperator(String text) {
        String operatorStr = text.replaceAll("[^" + getOperatorsRegExp() + "]", "");
        return switch (operatorStr) {
            case "+" -> new OperatorAdd();
            case "-" -> new OperatorSub();
            case "*" -> new OperatorMulti();
            case "/" -> new OperatorDiv();
            default -> throw new IllegalArgumentException("Не найден обработчик для оператора " + operatorStr);
        };
    }

    public ArrayList<IOperand> getOperands(String text) {
        String[] operandsStr = text.split("[" + getOperatorsRegExp() + "]");
        ArrayList<IOperand> operandsResult = new ArrayList<>();
        for (String opStr : operandsStr) {
            operandsResult.add(getOperand(opStr));
        }
        return operandsResult;
    }

    private IOperand getOperand(String text) {
        try {
            return new OperandRoman(text);
        } catch (ParseException eRoman) {
            try {
                return new OperandArabic(text);
            } catch (ParseException eArabic) {
                throw new IllegalStateException(eRoman.getMessage() + "; " + eArabic.getMessage());
            }
        }
    }

    private String getOperatorsRegExp() {
        return "+|\\-|\\*|/";
    }
}
