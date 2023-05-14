//CHECKSTYLE:OFF
package sql.parser;

import app.DBApp;
import exceptions.DBAppException;
import org.antlr.v4.runtime.tree.ErrorNode;
import sql.SQLTerm;
import sql.antlrfiles.SQLiteParser;
import sql.antlrfiles.SQLiteParserBaseListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static constants.Constants.*;

public class MiniDBListener extends SQLiteParserBaseListener {
    private final DBApp app;
    private Iterator result = null;

    public MiniDBListener(DBApp app) {
        this.app = app;
    }

    public Iterator getResult() {
        return result;
    }


    @Override
    public void enterInsert_stmt(SQLiteParser.Insert_stmtContext ctx) {


        result = null;

    }

    @Override
    public void enterSelect_stmt(SQLiteParser.Select_stmtContext ctx) {
//        System.out.println("Hello from SELECT FUNCTION");

        ArrayList<String> colNames = new ArrayList<>();
        ArrayList<SQLiteParser.ExprContext> conditions = new ArrayList<>();
        ArrayList<String> operators = new ArrayList<>();

        String table = ctx.select_core(0).table_or_subquery(0).getText();

        for (SQLiteParser.Result_columnContext col : ctx.select_core(0).result_column())
            colNames.add(col.getText());


        SQLiteParser.ExprContext conditionExpr = ctx.select_core(0).expr().get(0);

        parseWhereCondition(conditions, operators, conditionExpr);
        SQLTerm[] arrSQLTerms;
        try {
            arrSQLTerms = prepareSelectTerm(table, conditions);
        } catch (DBAppException e) {
            throw new RuntimeException(e);
        }
        String[] betweenConditionOperator = operators.toArray(new String[0]);
        System.out.println(Arrays.toString(betweenConditionOperator));
        try {
            result = app.selectFromTable(arrSQLTerms, betweenConditionOperator);
        } catch (DBAppException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void enterDelete_stmt(SQLiteParser.Delete_stmtContext ctx) {
        System.out.println("Hello from 2 " + this.getClass().getName());


        String tableName = ctx.qualified_table_name().getText();
        ArrayList<SQLiteParser.ExprContext> conditions = new ArrayList<>();
        parseCondition(conditions, ctx.expr());

        Hashtable<String, Object> colVal = prepareColVal(conditions);
        try {
            app.deleteFromTable(tableName, colVal);
        } catch (DBAppException e) {
            throw new RuntimeException(e);
        }
//test
//        System.out.println(conditions.stream().map(c -> c.getText()).collect(Collectors.toList()));
//   System.out.println(colVal);
//
        result = null;
    }

    private Hashtable prepareColVal(ArrayList<SQLiteParser.ExprContext> conditions) {
        Hashtable<String, Object> colVal = new Hashtable<>();
        for (SQLiteParser.ExprContext cond : conditions) {
            String col = cond.expr(0).getText();
            Object val = cond.expr(1).getText();
            colVal.put(col, val);
        }

//        System.out.println(colVal);
        return colVal;
    }

    @Override
    public void enterUpdate_stmt(SQLiteParser.Update_stmtContext ctx) {
//        System.out.println("Executing Update statement);

        String tableName = ctx.qualified_table_name().getText();

        //
        ArrayList<String> colNames = new ArrayList<>();
        ArrayList<String> colvalues = new ArrayList<>();


        Object primaryKeyValue;
        int primaryKeyValueIdx = ctx.column_name().size();
        primaryKeyValue = cleanString(ctx.expr(primaryKeyValueIdx).expr(1).getText());
//        System.out.println(" sdccvfv : "+((String) primaryKeyValue).charAt(0));

        for (SQLiteParser.Column_nameContext col : ctx.column_name())
            colNames.add(col.getText());

        Hashtable<String, Object> colVal = new Hashtable<>();

        for (int i = 0; i < primaryKeyValueIdx; i++)
            //            colvalues.add(ctx.expr(i).getText());
            colVal.put(colNames.get(i), ctx.expr(i).getText());


        try {
            app.updateTable(tableName, (String) primaryKeyValue, colVal);
        } catch (DBAppException e) {
            throw new RuntimeException(e);
        }


//test
//        System.out.println("Table : " + tableName);
//        System.out.println("colNames  : " + colNames);
//        System.out.println("colvalues : " + colvalues);
//        System.out.println("Key " + primaryKeyValue);

        result = null;
    }


    @Override
    public void enterCreate_index_stmt(SQLiteParser.Create_index_stmtContext ctx) {
        System.out.println("Hello from 4 " + this.getClass().getName());
        String tableName = ctx.table_name().getText();
        int size = ctx.indexed_column().size();
        String[] indexedCol = new String[size];

        for (int i = 0; i < size; i++)
            indexedCol[i] = ctx.indexed_column(i).getText();

        try {
            app.createIndex(tableName, indexedCol);
        } catch (DBAppException e) {
            throw new RuntimeException(e);
        }
        //test
//        System.out.println("Table : "+tableName);
//        System.out.println("IndexesColNames :  "+ Arrays.toString(indexedCol));

        result = null;
    }

    @Override
    public void enterCreate_table_stmt(SQLiteParser.Create_table_stmtContext ctx) {
        String tableName = ctx.table_name().getText();
        String primaryKeyCol = null;

        Hashtable<String, String> nameType = new Hashtable<>();
        Hashtable<String, String> colMin = new Hashtable<>();
        Hashtable<String, String> colMax = new Hashtable<>();

        for (SQLiteParser.Column_defContext col : ctx.column_def()) {
            String colName = col.column_name().getText();
            String type = chooseDataType(col.type_name());
            nameType.put(colName, type);

            try {
                colMin.put(colName, getMin(type, 1000));
                colMax.put(colName, getMax(type, 1000));
            } catch (DBAppException e) {
                throw new RuntimeException(e);
            }


            if (col.column_constraint().size() > 0 && col.column_constraint(0).getText().equalsIgnoreCase("primarykey"))
                primaryKeyCol = colName;

        }

//        System.out.println(ctx.column_def().stream().map(c -> c.column_name().getText()).collect(Collectors.toList()));


        try {
            app.createTable(tableName, primaryKeyCol, nameType, colMin, colMax);
        } catch (DBAppException e) {
            throw new RuntimeException(e);
        }

        result = null;
    }


    @Override
    public void visitErrorNode(ErrorNode errorNode) {
        try {
            throw new DBAppException("Error in sql");
        } catch (DBAppException e) {
            throw new RuntimeException(e);
        }

    }


    private boolean hasChild(SQLiteParser.ExprContext expr) {
        return expr.OR_() != null || expr.AND_() != null;
//        return expr.expr().size()>0;
    }


    private void parseWhereCondition(ArrayList<SQLiteParser.ExprContext> conditions, ArrayList<String> operators, SQLiteParser.ExprContext conditionExpr) {

        parseOperation(operators, conditionExpr);
        parseCondition(conditions, conditionExpr);
    }

    private void parseCondition(ArrayList<SQLiteParser.ExprContext> conditions, SQLiteParser.ExprContext expr) {
        if (!hasChild(expr)) {
            conditions.add(expr);
            return;
        }

        for (int i = 0; i < expr.expr().size(); i++)
            parseCondition(conditions, expr.expr(i));
    }


    private int parseOperation(ArrayList<String> operation, SQLiteParser.ExprContext expr) {
        if (!hasChild(expr)) {
            String tmp = CheckANDOrOR(expr);

            if (tmp != null) {
                operation.add(tmp);
                return 1;
            }
            return 0;

        }

        int count = 0;
        for (int i = 0; i < expr.expr().size() && i < 2; i++) {

            parseOperation(operation, expr.expr(i));

            if (i == 0) {
                String tmp = CheckANDOrOR(expr);
                if (tmp != null) operation.add(tmp);
            }
        }
        return count;
    }

    private String CheckANDOrOR(SQLiteParser.ExprContext expr) {
        if (expr.AND_() != null)
            return "and";
        else if (expr.OR_() != null)
            return "or";

        return null;
    }

    private String cleanString(String text) {
        text = text.trim();
        if (text.length() > 0 && (text.charAt(0) == '\'' || text.charAt(0) == '\"'))
            text = text.substring(1);
        if (text.length() > 0 && (text.charAt(text.length() - 1) == '\'' || text.charAt(text.length() - 1) == '\"'))
            text = text.substring(0, text.length() - 1);

        return text;
    }

    private SQLTerm[] prepareSelectTerm(String tableName, ArrayList<SQLiteParser.ExprContext> conditions) throws DBAppException {
        SQLTerm[] terms = new SQLTerm[conditions.size()];


        for (int i = 0; i < conditions.size(); i++) {
            String colName = conditions.get(i).expr(0).getText();
            Object Value = cleanString(conditions.get(i).expr(0).getText());
            String strOperator = chooseInSqlOperator(conditions.get(i));
            terms[i] = new SQLTerm(tableName, colName, strOperator, Value);
        }

        return terms;
    }

    private String chooseInSqlOperator(SQLiteParser.ExprContext cond) throws DBAppException {

        if (cond.GT() != null)
            return ">";

        else if (cond.LT() != null)
            return "<";

        else if (cond.EQ() != null || cond.ASSIGN() != null)
            return "=";

        else if (cond.GT_EQ() != null)
            return ">=";

        else if (cond.LT_EQ() != null)
            return "<=";
        else if (cond.NOT_EQ1() != null)
            return "!=";


        throw new DBAppException();


    }

    private String getString(char character, int charCount) {

        char[] ret = new char[charCount];
        Arrays.fill(ret, character);
        return new String(ret);

    }

    private String getMax(String type, int count) throws DBAppException {
        DateFormat format = new SimpleDateFormat(DATE_FORMATE);
        switch (type) {
            case INTEGER_DATA_TYPE_NAME:
                return Integer.MAX_VALUE + "";
            case DOUBLE_DATA_TYPE_NAME:
                return Double.MAX_VALUE + "";
            case STRING_DATA_TYPE_NAME:
                return getString(Character.MAX_VALUE, count);
            case DATE_DATA_TYPE_NAME:
                return format.format(new Date(Long.MAX_VALUE));
        }
        throw new DBAppException();

    }

    private String getMin(String type, int count) throws DBAppException {
        DateFormat format = new SimpleDateFormat(DATE_FORMATE);
        switch (type) {
            case INTEGER_DATA_TYPE_NAME:
                return Integer.MIN_VALUE + "";
            case DOUBLE_DATA_TYPE_NAME:
                return Double.MIN_VALUE + "";
            case STRING_DATA_TYPE_NAME:
                return getString(Character.MIN_VALUE, count);
            case DATE_DATA_TYPE_NAME:
                return format.format(new Date(Long.MIN_VALUE));
        }
        throw new DBAppException();

    }


    private String chooseDataType(SQLiteParser.Type_nameContext type_name) {
        String type = type_name.getText().trim().toLowerCase();
        if (type.equals("int")) return INTEGER_DATA_TYPE_NAME;
        else if (type.contains("varchar")) return STRING_DATA_TYPE_NAME;
        else if (type.equals("float") || type.equals("double") || type.contains("decimal"))
            return DOUBLE_DATA_TYPE_NAME;
        else if (type.equals("date")) return DATE_DATA_TYPE_NAME;

        return null;

    }

}//CHECKSTYLE:ON
