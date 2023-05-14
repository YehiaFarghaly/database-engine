package storage.index;

import java.io.Serializable;

public class DBAppNull implements Serializable {

	private static final long serialVersionUID = 8824089905231570419L;

	public boolean equals(Object obj) {
		return obj instanceof DBAppNull;
	}
}
