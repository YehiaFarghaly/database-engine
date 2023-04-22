package search;

import java.io.IOException;
import java.text.ParseException;
import exceptions.DBAppException;
import storage.Page;
import storage.Table;
import static filecontroller.Serializer.deserializePage;

public class TableSearch {

	public static int binarySearchPages(Table table, Object tuplePrimaryKey)
			throws DBAppException, ParseException, IOException, ClassNotFoundException {
		int n = table.getPagesName().size();
		int low = 0;
		int high = n - 1;

		while (low <= high) {

			int mid = (low + high)  / 2;

            Page currPage = deserializePage(table.getName(), table.getPagesName().get(mid));

			int compareWithMin = Compare.compare(tuplePrimaryKey, currPage.getMinPK());

			int compWithMax = Compare.compare(tuplePrimaryKey, currPage.getMaxPK());

			if (compWithMax <= 0 && compareWithMin >= 0) {
				return mid;
			} else if (compWithMax > 0)
				low = mid + 1;
			else
				high = mid - 1;

		}
		return Math.min(low, n - 1);
	}

	

}
