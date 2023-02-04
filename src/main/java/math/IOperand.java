package math;

public interface IOperand {
    int getInt();

    boolean isParsable(String number);

    void setString(String number);

    void setInt(int number);

    Type getType();

    String parse(int integer);

    enum Type {
        ARABIC,
        ROMAN,
        UNKNOWN
    }

}
