package storage;

import java.util.Hashtable;

public interface ITupleBuilder {

	public void buildTuple(Hashtable<String, String> colNameType);

	public Tuple getTuple();

}
