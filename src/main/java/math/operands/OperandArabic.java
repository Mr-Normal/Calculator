package math.operands;

import java.text.ParseException;

public class OperandArabic extends AbstractOperand {
    private int number;
    private static final String[] validInputs =
            new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

    public OperandArabic() {
    }

    public OperandArabic(String parsableString) throws ParseException {
        super(parsableString);
    }

    @Override
    public int getInt() {
        return number;
    }

    @Override
    public boolean isParsable(String number) {
        for (String validStr : validInputs) {
            if (number.equalsIgnoreCase(validStr)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void setString(String number) {
        if (!isParsable(number)) {
            this.number = 0;
        } else {
            this.number = Integer.parseInt(number);
        }
    }

    @Override
    public void setInt(int number) {
        this.number = number;
    }

    @Override
    public Type getType() {
        return Type.ARABIC;
    }

    @Override
    public String parse(int integer) {
        return String.valueOf(integer);
    }
}
