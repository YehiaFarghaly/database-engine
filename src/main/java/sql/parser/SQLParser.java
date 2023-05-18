//CHECKSTYLE:OFF
package sql.parser;

import app.DBApp;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import sql.antlrfiles.SQLiteLexer;
import sql.antlrfiles.SQLiteParser;

import java.util.Iterator;

public class SQLParser {
	DBApp app;

	public SQLParser(DBApp app) {
		this.app = app;
	}

	public Iterator parse(StringBuffer input) {

		CharStream stream = CharStreams.fromString(input.toString());
		SQLiteLexer lexer = new SQLiteLexer(stream);
		CommonTokenStream token = new CommonTokenStream(lexer);
		SQLiteParser parser = new SQLiteParser(token);
		ParseTree tree = parser.parse();
		MiniDBListener miniDBListener = new MiniDBListener(app);
		ParseTreeWalker.DEFAULT.walk(miniDBListener, tree);
		return miniDBListener.getResult();

	}
}// CHECKSTYLE:ON
