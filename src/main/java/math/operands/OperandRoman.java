package math.operands;

import java.text.ParseException;

public class OperandRoman extends AbstractOperand {
    private int number;
    private static final String[] numbers1to10 = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

    public OperandRoman() {
    }

    public OperandRoman(String parsableString) throws ParseException {
        super(parsableString);
    }

    @Override
    public int getInt() {
        return number;
    }

    @Override
    public boolean isParsable(String number) {
        for (String num1to10 : numbers1to10) {
            if (number.equalsIgnoreCase(num1to10)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void setString(String number) {
        if (isParsable(number)) {
            int index = 0;
            for (String num : numbers1to10) {
                index++;
                if (num.equalsIgnoreCase(number)) {
                    this.number = index;
                    break;
                }
            }
        }else {
            throw new IllegalStateException("Не получилось вставить значение как строку " + number);
        }
    }

    @Override
    public void setInt(int number) {
        checkMin(number);
        this.number = number;
    }

    @Override
    public Type getType() {
        return Type.ROMAN;
    }

    @Override
    public String parse(int integer) {
        checkMin(integer);
        return RomanSerializer.toString(integer);
    }

    private void checkMin(int number){
        if (number < 1) {
            throw new IllegalArgumentException("Число в системе " + getType() + " не должно быть меньше 1");
        }
    }
}
