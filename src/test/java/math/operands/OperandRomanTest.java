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
        try {
            OperandRoman operandRoman = new OperandRoman();
            for (int i = 1; i < 449; i++){
                operandRoman.setInt(i);
                assertNotNull(operandRoman.toString());
            }
        }catch (Exception e){
            fail();
        }
    }
}