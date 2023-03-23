package search;
import validation.*;

public class Selector {

    private Vector<Tuple> FinalResult;

    public Selector(SQLTerm[] arrSQLTerms, String[] strarrOperators) {
        //for loop
        arrSQLTerms[0].isValid();
        //for loop
        validateOperatorBetween(strarrOperators[0]);
    }

    public Iterator<Tuple> getResult() {
        return FinalResult.iterator();
    }
}