package storage;

import java.util.Hashtable;

public class TupleDirector {

	private TupleBuilder tupleBuilder;

	public TupleDirector(TupleBuilder tupleBuilder) {
		this.tupleBuilder = tupleBuilder;
	}

	public void makeTuple(Hashtable<String, String> colNameType) {
		this.tupleBuilder.buildTuple(colNameType);
	}

	public Tuple getTuple() {
		return this.tupleBuilder.getTuple();
	}

}
