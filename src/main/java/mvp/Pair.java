package mvp;

/**
 * Structure to store pair of currency and check equality
 * (In Array of two elements, equals method was not working. So, need to create this container class.)
 */
public class Pair {
    private final String from;
    private final String to;

    public Pair(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;

        Pair pair = (Pair) o;

        if (!from.equals(pair.from)) return false;
        return to.equals(pair.to);
    }

    @Override
    public int hashCode() {
        int result = from.hashCode();
        result = 31 * result + to.hashCode();
        return result;
    }
}
