package mvp;

import java.util.HashMap;

/**
 * Bank, that takes care of exchange rate of currencies
 *
 */
public class Bank {
    private final HashMap<Pair,Integer > rates = new HashMap<>();

    public Money reduce(Expression source, String to) {
        return source.reduce(this, to);
    }

    int rate(String from, String to){
        if(from.equals(to)) return 1;
        return rates.get(new Pair(from, to));
    }

    public void addRate(String from, String to, int rate) {
        rates.put(new Pair(from, to), rate);
    }
}
