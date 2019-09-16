public class Pair<X, Y> {
    public X key;
    public Y value;

    public Pair(X key, Y newValue) {
        this.key = key;
        value = newValue;
    }

    public String toString() {
        return "Pair(" + key + " -> " + value + ")";
    }
}