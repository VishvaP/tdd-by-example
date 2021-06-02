package mvp;

/**
 * interface created for abstraction of currency arithmetic operations
 */
public interface Expression {
    Money reduce(Bank bank, String to);

    Expression plus(Expression addend);

    Expression times(int multiplier);
}
