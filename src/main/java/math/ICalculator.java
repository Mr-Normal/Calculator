package math;

import exceptions.DifferentTypeOfReckoningException;
import exceptions.FoundIllegalRomanNumeralsException;
import exceptions.InvalidOperationFormatException;

public interface ICalculator {
    String calc(String input) throws DifferentTypeOfReckoningException, FoundIllegalRomanNumeralsException, InvalidOperationFormatException;
}
