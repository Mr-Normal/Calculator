import exceptions.DifferentTypeOfReckoningException;
import exceptions.InvalidOperationFormatException;
import math.IOperand;
import math.operands.OperandArabic;
import math.operands.OperandRoman;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    void calc1Plus2IsEqual3() {
        try {
            assertEquals("3", calculator.calc("1 + 2"));
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void calcVIDivideIIIIsEqualsII() {
        try {
            assertEquals("II", calculator.calc("VI / III"));
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void calcIMinusIIThrowsException() {
        try {
            log(calculator.calc("I - II"));
            fail();
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    void calcIPlus1ThrowsException() {
        try {
            calculator.calc("I + 1");
        } catch (DifferentTypeOfReckoningException e) {
            assertTrue(true);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void calc1ThrowsException() {
        try {
            calculator.calc("1");
        } catch (InvalidOperationFormatException e) {
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void calc1Plus2Plus3ThrowsException() {
        try {
            calculator.calc("1 + 2 + 3");
        } catch (InvalidOperationFormatException e) {
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void plusRomanNotThrowExceptions() {
        customOperatorTest(new OperandRoman(), "+");
    }

    @Test
    void multiplyRomanNotThrowExceptions() {
        customOperatorTest(new OperandRoman(), "*");
    }

    @Test
    void divideRomanItoIIThrowException() {
        try {
            calculator.calc("I/II");
            fail();
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    void testIIminusIIIThrowException() {
        try {
            calculator.calc("II-III");
            fail();
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    void testXminusIV() {
        try {
            assertTrue(calculator.calc("X-IV").equalsIgnoreCase("VI"));
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    private void customOperatorTest(IOperand operand, String operator) {
        String formula = "";
        for (int aInt = 1; aInt < 11; aInt++) {
            for (int bInt = 1; bInt < 11; bInt++) {
                try {
                    formula = operand.parse(aInt) + operator + operand.parse(bInt);
                    calculator.calc(formula);
//                    log(formula + "=" + calculator.calc(formula));
                } catch (Exception e) {
                    log("failed on formula: " + formula);
                    e.printStackTrace();
                    fail();
                }
            }
        }
    }
    @Test
    void calcIplusIIEqualsIII() {
        try {
            assertTrue(calculator.calc("I+II").equalsIgnoreCase("III"));
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }
    @Test
    void calcMinus1plus1ThrowException() {
        try {
            calculator.calc("-1+1");
        } catch (Exception e) {
            assertTrue(true);
        }
    }
    @Test
    void calc1plus11ThrowException() {
        try {
            calculator.calc("1+11");
        } catch (Exception e) {
            assertTrue(true);
        }
    }
    @Test
    void plusArabicNotThrowExceptions() {
        customOperatorTest(new OperandArabic(), "+");
    }
    @Test
    void minusArabicNotThrowExceptions() {
        customOperatorTest(new OperandArabic(), "-");
    }

    @Test
    void multiplyArabicNotThrowExceptions() {
        customOperatorTest(new OperandArabic(), "*");
    }
    @Test
    void divideArabicNotThrowExceptions() {
        customOperatorTest(new OperandArabic(), "/");
    }

    private void log(String message) {
        System.out.println(message);
    }
}