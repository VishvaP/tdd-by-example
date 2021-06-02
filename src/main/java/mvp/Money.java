package mvp;

/**
 * Money class
 */
public class Money implements Expression {
    protected int amount;
    protected String currency;

    Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    String currency() {
        return currency;
    }

    public Expression times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }
    static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    @Override
    public Money reduce(Bank bank, String to) {
        int rate = bank.rate(currency, to);
        return new Money(amount / rate, to);
    }

    @Override
    public boolean equals(Object object) {
        if(object==null)
            return false;
        if(this.getClass()!=object.getClass())
            return false;
        Money money = (Money) object;

        return amount == money.amount && currency().equals(money.currency());
    }

    @Override
    public int hashCode() {
        return amount;
    }

    public String toString() {
        return amount + " " + currency;
    }

}
