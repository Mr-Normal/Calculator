package math.operands;

import java.text.ParseException;

public class OperandArabic extends AbstractOperand {
    private int number;

    public OperandArabic(){
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
        try {
            if (number.length() != 1) {
                return false;
            }
            if (Integer.parseInt(number) != 0) {
                return true;
            }
            return number.equals("0");
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public void setString(String number) {
        if (!isParsable(number)) {
            this.number = 0;
        }else {
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
