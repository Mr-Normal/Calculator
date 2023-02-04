package math.operands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperandRomanTest {

    @Test
    void getInt() {
    }

    @Test
    void setString() {
    }

    @Test
    void setInt() {
    }

    @Test
    void testToString() {
        OperandRoman operandRoman = new OperandRoman();
            operandRoman.setInt(40);
            System.out.println(operandRoman);
        for (int i = 1; i < 449; i++){
            operandRoman.setInt(i);
            System.out.println(operandRoman);
        }
    }
}