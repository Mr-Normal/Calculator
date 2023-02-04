package math.operands;

import math.IOperand;

import java.text.ParseException;

public abstract class AbstractOperand implements IOperand {
    public AbstractOperand(){}
    public AbstractOperand(String parsableString) throws ParseException {
        if (isParsable(parsableString)) {
            setString(parsableString);
        }else {
            throw new ParseException("Не получилось извлечь значение из текста для текущего операнда " + getType(), 0);
        }
    }

    @Override
    public String toString() {
        return parse(getInt());
    }
}
