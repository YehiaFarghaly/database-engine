package util.search;

import java.util.Iterator;
import java.util.Vector;
import sql.SQLTerm;
import storage.Tuple;

public class Selector {

    private Vector<Tuple> finalResult;

    public Selector(SQLTerm[] arrSQLTerms, String[] strarrOperators) {
        
        arrSQLTerms[0].isValid();
        
       
    }

    public Iterator<Tuple> getResult() {
        return finalResult.iterator();
    }
}