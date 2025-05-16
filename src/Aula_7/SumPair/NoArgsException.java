public class NoArgsException extends Exception{
    public NoArgsException(){
        super("correct usage: java SumPairs <entry_file> <exit_file>");
    }
}
