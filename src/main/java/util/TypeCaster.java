package util;

import constants.Constants;
import storage.Table;

public class TypeCaster {
	public static void castClusteringKey(Table table, Object clusteringKey,String clusteringKeyValue) {
		String primaryKeyType = table.getPrimaryKeyType();
		if (primaryKeyType.equals(Constants.INTEGER_DATA_TYPE_NAME))
			clusteringKey = Integer.parseInt(clusteringKeyValue);
		else if (primaryKeyType.equals(Constants.DOUBLE_DATA_TYPE_NAME))
			clusteringKey = Double.parseDouble(clusteringKeyValue);
	}
}
