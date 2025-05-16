public class OddNumberOfValuesException extends Exception {
    public OddNumberOfValuesException(int dumpedValue) {
        super("list of values provided is odd, last value (" + dumpedValue + ") dumped.");
    }
}
