package storage;

import java.util.*;
import java.util.Map.Entry;

public class TupleBuilder implements ITupleBuilder {

	private Tuple tuple;

	@Override
	public void buildTuple(Hashtable<String, String> colNameType) {
		tuple = new Tuple();
		for (Entry<String, String> entry : colNameType.entrySet()) {
			Cell c = new Cell(entry.getKey(), null);
			this.tuple.addCell(c);
		}
	}

	@Override
	public Tuple getTuple() {
		return tuple;
	}

}
