package util;

public class Compare {

	public static int compare(Object first, Object second) {
		return ((Comparable) first).compareTo((Comparable) second); 
	}
}
