package math.operands;

public class RomanSerializer {
    private static int maxValue = 449;
    //I=1,V=5,X=10,L=50,C=100,D=500
    static RomanNumPair[] numberPairs = new RomanNumPair[]{
            new RomanNumPair("I", 1),
            new RomanNumPair("V", 5),
            new RomanNumPair("X", 10),
            new RomanNumPair("L", 50),
            new RomanNumPair("C", 100),
            new RomanNumPair("D", 500),
    };

    public static String toString(int number) {
        if (number == 0) {
            return "";
        }
        if (number == 1) {
            return primitiveIntToRomanNumStr(1);
        }
        if (number > maxValue) {
            throw new IllegalArgumentException(
                    "Римский десериализатор может принимать значения только от 1 до "
                            + maxValue + " (попытка ввести значение " + number + ")");
        }

        RomanNumPair closestPair = findClosestPair(number);
        if (closestPair.integer <= number) {
            return closestPair.numberStr + toString(number - closestPair.integer);
        } else {
            int leftOperand = closestPair.integer - closestPair.getSubtrahend();
            return primitiveIntToRomanNumStr(closestPair.getSubtrahend()) + closestPair.numberStr
                    + toString(number - leftOperand);
        }
    }

    private static String primitiveIntToRomanNumStr(int primitiveNumber) {
        for (RomanNumPair romP : numberPairs) {
            if (romP.integer == primitiveNumber) {
                return romP.numberStr;
            }
        }
        throw new IllegalStateException("Не удалось найти римский символ для примитивного числа " + primitiveNumber);
    }

    private static RomanNumPair findClosestPair(int number) {
        RomanNumPair numP;
        int leftBorder;
        int rightBorder;
        for (int index = 1; index < numberPairs.length; index++) {
            numP = numberPairs[index];
            leftBorder = numP.integer - numP.getSubtrahend();
            rightBorder = numP.integer;

            if (number < rightBorder) {
                if (leftBorder <= number) {
                    return numberPairs[index];
                } else {
                    return numberPairs[index - 1];
                }
            }
        }
        throw new IllegalStateException("Не удалось найти ближайшую римску пару для числа " + number);
    }

    static class NumberPair {
        public final String numberStr;
        public final int integer;

        public NumberPair(String numberStr, int integer) {
            this.numberStr = numberStr;
            this.integer = integer;
        }
    }

    static class RomanNumPair extends NumberPair {

        public RomanNumPair(String numberStr, int integer) {
            super(numberStr, integer);
        }

        public int getSubtrahend() {
            if (integer < 2) {
                return 1;
            }
            if (isContained5()) {
                return integer / 5;
            } else {
                return integer / 10;
            }
        }

        private boolean isContained5() {
            return String.valueOf(integer).contains("5");
        }
    }
}
