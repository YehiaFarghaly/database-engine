package search;
import java.util.Iterator;
import java.util.Vector;

import sql.SQLTerm;
import storage.Tuple;
import validation.*;

public class Selector {

    private Vector<Tuple> FinalResult;

    public Selector(SQLTerm[] arrSQLTerms, String[] strarrOperators) {
        //for loop
        arrSQLTerms[0].isValid();
        //for loop
        Validator.validateOperatorBetween(strarrOperators[0]);
    }

    public Iterator<Tuple> getResult() {
        return FinalResult.iterator();
    }
}