package search;
import java.util.Iterator;
import java.util.Vector;

import sql.SQLTerm;
import storage.Tuple;
import validation.*;

public class Selector {

    private Vector<Tuple> FinalResult;

    public Selector(SQLTerm[] arrSQLTerms, String[] strarrOperators) {
        
        arrSQLTerms[0].isValid();
        
       
    }

    public Iterator<Tuple> getResult() {
        return FinalResult.iterator();
    }
}