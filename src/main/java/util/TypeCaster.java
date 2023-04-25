package util;

import constants.Constants;
import storage.Table;

public class TypeCaster {
	public static Object castClusteringKey(Table table, String clusteringKeyValue) {
		String primaryKeyType = table.getPrimaryKeyType();
		if (primaryKeyType.equals(Constants.INTEGER_DATA_TYPE_NAME))
			return Integer.parseInt(clusteringKeyValue);
		else if (primaryKeyType.equals(Constants.DOUBLE_DATA_TYPE_NAME))
			return Double.parseDouble(clusteringKeyValue);
		return clusteringKeyValue;
	}
}
