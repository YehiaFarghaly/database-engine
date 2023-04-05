package search;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

import exceptions.DBAppException;
import org.apache.commons.collections.functors.EqualPredicate;
import storage.Page;
import storage.Table;
import storage.Tuple;

import static Serializerium.Serializer.deserializePage;
import static constants.Constants.*;

public class TableSearch {
	private static Page currPage;

	public static int binarySearchPages(Table table, Object tuplePrimaryKey)
			throws DBAppException, ParseException, IOException, ClassNotFoundException {
		int n = table.getPagesName().size();
		int low = 0;
		int high = n - 1;

		while (low <= high) {

			int mid = low + (high - low) / 2;

            Page currPage = deserializePage(table.getName(), table.getPagesName().get(mid));

			int compareWithMin = compare(tuplePrimaryKey, currPage.getMinPK());

			int compWithMax = compare(tuplePrimaryKey, currPage.getMaxPK());

			if (compWithMax <= 0 && compareWithMin >= 0) {
				return mid;
			} else if (compWithMax < 0)
				low = mid + 1;
			else
				high = mid - 1;

		}
		return Math.min(low, n - 1);
	}

	static int compare(Object tuplePrimaryKey, Object pagePrimaryKey) {
		return ((Comparable) tuplePrimaryKey).compareTo((Comparable) pagePrimaryKey);
	}

}
