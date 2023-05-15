//CHECKSTYLE:OFF
package sql.antlrfiles;// Generated from SQLiteParser.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SQLiteParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SCOL=1, DOT=2, OPEN_PAR=3, CLOSE_PAR=4, COMMA=5, ASSIGN=6, STAR=7, PLUS=8, 
		MINUS=9, TILDE=10, PIPE2=11, DIV=12, MOD=13, LT2=14, GT2=15, AMP=16, PIPE=17, 
		LT=18, LT_EQ=19, GT=20, GT_EQ=21, EQ=22, NOT_EQ1=23, NOT_EQ2=24, ABORT_=25, 
		ACTION_=26, ADD_=27, AFTER_=28, ALL_=29, ALTER_=30, ANALYZE_=31, AND_=32, 
		AS_=33, ASC_=34, ATTACH_=35, AUTOINCREMENT_=36, BEFORE_=37, BEGIN_=38, 
		BETWEEN_=39, BY_=40, CASCADE_=41, CASE_=42, CAST_=43, CHECK_=44, COLLATE_=45, 
		COLUMN_=46, COMMIT_=47, CONFLICT_=48, CONSTRAINT_=49, CREATE_=50, CROSS_=51, 
		CURRENT_DATE_=52, CURRENT_TIME_=53, CURRENT_TIMESTAMP_=54, DATABASE_=55, 
		DEFAULT_=56, DEFERRABLE_=57, DEFERRED_=58, DELETE_=59, DESC_=60, DETACH_=61, 
		DISTINCT_=62, DROP_=63, EACH_=64, ELSE_=65, END_=66, ESCAPE_=67, EXCEPT_=68, 
		EXCLUSIVE_=69, EXISTS_=70, EXPLAIN_=71, FAIL_=72, FOR_=73, FOREIGN_=74, 
		FROM_=75, FULL_=76, GLOB_=77, GROUP_=78, HAVING_=79, IF_=80, IGNORE_=81, 
		IMMEDIATE_=82, IN_=83, INDEX_=84, INDEXED_=85, INITIALLY_=86, INNER_=87, 
		INSERT_=88, INSTEAD_=89, INTERSECT_=90, INTO_=91, IS_=92, ISNULL_=93, 
		JOIN_=94, KEY_=95, LEFT_=96, LIKE_=97, LIMIT_=98, MATCH_=99, NATURAL_=100, 
		NO_=101, NOT_=102, NOTNULL_=103, NULL_=104, OF_=105, OFFSET_=106, ON_=107, 
		OR_=108, ORDER_=109, OUTER_=110, PLAN_=111, PRAGMA_=112, PRIMARY_=113, 
		QUERY_=114, RAISE_=115, RECURSIVE_=116, REFERENCES_=117, REGEXP_=118, 
		REINDEX_=119, RELEASE_=120, RENAME_=121, REPLACE_=122, RESTRICT_=123, 
		RIGHT_=124, ROLLBACK_=125, ROW_=126, ROWS_=127, SAVEPOINT_=128, SELECT_=129, 
		SET_=130, TABLE_=131, TEMP_=132, TEMPORARY_=133, THEN_=134, TO_=135, TRANSACTION_=136, 
		TRIGGER_=137, UNION_=138, UNIQUE_=139, UPDATE_=140, USING_=141, VACUUM_=142, 
		VALUES_=143, VIEW_=144, VIRTUAL_=145, WHEN_=146, WHERE_=147, WITH_=148, 
		WITHOUT_=149, FIRST_VALUE_=150, OVER_=151, PARTITION_=152, RANGE_=153, 
		PRECEDING_=154, UNBOUNDED_=155, CURRENT_=156, FOLLOWING_=157, CUME_DIST_=158, 
		DENSE_RANK_=159, LAG_=160, LAST_VALUE_=161, LEAD_=162, NTH_VALUE_=163, 
		NTILE_=164, PERCENT_RANK_=165, RANK_=166, ROW_NUMBER_=167, GENERATED_=168, 
		ALWAYS_=169, STORED_=170, TRUE_=171, FALSE_=172, WINDOW_=173, NULLS_=174, 
		FIRST_=175, LAST_=176, FILTER_=177, GROUPS_=178, EXCLUDE_=179, TIES_=180, 
		OTHERS_=181, DO_=182, NOTHING_=183, IDENTIFIER=184, NUMERIC_LITERAL=185, 
		BIND_PARAMETER=186, STRING_LITERAL=187, BLOB_LITERAL=188, SINGLE_LINE_COMMENT=189, 
		MULTILINE_COMMENT=190, SPACES=191, UNEXPECTED_CHAR=192;
	public static final int
		RULE_parse = 0, RULE_sql_stmt_list = 1, RULE_sql_stmt = 2, RULE_alter_table_stmt = 3, 
		RULE_analyze_stmt = 4, RULE_attach_stmt = 5, RULE_begin_stmt = 6, RULE_commit_stmt = 7, 
		RULE_rollback_stmt = 8, RULE_savepoint_stmt = 9, RULE_release_stmt = 10, 
		RULE_create_index_stmt = 11, RULE_indexed_column = 12, RULE_create_table_stmt = 13, 
		RULE_column_def = 14, RULE_type_name = 15, RULE_column_constraint = 16, 
		RULE_signed_number = 17, RULE_table_constraint = 18, RULE_foreign_key_clause = 19, 
		RULE_conflict_clause = 20, RULE_create_trigger_stmt = 21, RULE_create_view_stmt = 22, 
		RULE_create_virtual_table_stmt = 23, RULE_with_clause = 24, RULE_cte_table_name = 25, 
		RULE_recursive_cte = 26, RULE_common_table_expression = 27, RULE_delete_stmt = 28, 
		RULE_delete_stmt_limited = 29, RULE_detach_stmt = 30, RULE_drop_stmt = 31, 
		RULE_expr = 32, RULE_raise_function = 33, RULE_literal_value = 34, RULE_insert_stmt = 35, 
		RULE_upsert_clause = 36, RULE_pragma_stmt = 37, RULE_pragma_value = 38, 
		RULE_reindex_stmt = 39, RULE_select_stmt = 40, RULE_join_clause = 41, 
		RULE_select_core = 42, RULE_factored_select_stmt = 43, RULE_simple_select_stmt = 44, 
		RULE_compound_select_stmt = 45, RULE_table_or_subquery = 46, RULE_result_column = 47, 
		RULE_join_operator = 48, RULE_join_constraint = 49, RULE_compound_operator = 50, 
		RULE_update_stmt = 51, RULE_column_name_list = 52, RULE_update_stmt_limited = 53, 
		RULE_qualified_table_name = 54, RULE_vacuum_stmt = 55, RULE_filter_clause = 56, 
		RULE_window_defn = 57, RULE_over_clause = 58, RULE_frame_spec = 59, RULE_frame_clause = 60, 
		RULE_simple_function_invocation = 61, RULE_aggregate_function_invocation = 62, 
		RULE_window_function_invocation = 63, RULE_common_table_stmt = 64, RULE_order_by_stmt = 65, 
		RULE_limit_stmt = 66, RULE_ordering_term = 67, RULE_asc_desc = 68, RULE_frame_left = 69, 
		RULE_frame_right = 70, RULE_frame_single = 71, RULE_window_function = 72, 
		RULE_of_OF_fset = 73, RULE_default_DEFAULT__value = 74, RULE_partition_by = 75, 
		RULE_order_by_expr = 76, RULE_order_by_expr_asc_desc = 77, RULE_expr_asc_desc = 78, 
		RULE_initial_select = 79, RULE_recursive__select = 80, RULE_unary_operator = 81, 
		RULE_error_message = 82, RULE_module_argument = 83, RULE_column_alias = 84, 
		RULE_keyword = 85, RULE_name = 86, RULE_function_name = 87, RULE_schema_name = 88, 
		RULE_table_name = 89, RULE_table_or_index_name = 90, RULE_new_table_name = 91, 
		RULE_column_name = 92, RULE_collation_name = 93, RULE_foreign_table = 94, 
		RULE_index_name = 95, RULE_trigger_name = 96, RULE_view_name = 97, RULE_module_name = 98, 
		RULE_pragma_name = 99, RULE_savepoint_name = 100, RULE_table_alias = 101, 
		RULE_transaction_name = 102, RULE_window_name = 103, RULE_alias = 104, 
		RULE_filename = 105, RULE_base_window_name = 106, RULE_simple_func = 107, 
		RULE_aggregate_func = 108, RULE_table_function_name = 109, RULE_any_name = 110;
	private static String[] makeRuleNames() {
		return new String[] {
			"parse", "sql_stmt_list", "sql_stmt", "alter_table_stmt", "analyze_stmt", 
			"attach_stmt", "begin_stmt", "commit_stmt", "rollback_stmt", "savepoint_stmt", 
			"release_stmt", "create_index_stmt", "indexed_column", "create_table_stmt", 
			"column_def", "type_name", "column_constraint", "signed_number", "table_constraint", 
			"foreign_key_clause", "conflict_clause", "create_trigger_stmt", "create_view_stmt", 
			"create_virtual_table_stmt", "with_clause", "cte_table_name", "recursive_cte", 
			"common_table_expression", "delete_stmt", "delete_stmt_limited", "detach_stmt", 
			"drop_stmt", "expr", "raise_function", "literal_value", "insert_stmt", 
			"upsert_clause", "pragma_stmt", "pragma_value", "reindex_stmt", "select_stmt", 
			"join_clause", "select_core", "factored_select_stmt", "simple_select_stmt", 
			"compound_select_stmt", "table_or_subquery", "result_column", "join_operator", 
			"join_constraint", "compound_operator", "update_stmt", "column_name_list", 
			"update_stmt_limited", "qualified_table_name", "vacuum_stmt", "filter_clause", 
			"window_defn", "over_clause", "frame_spec", "frame_clause", "simple_function_invocation", 
			"aggregate_function_invocation", "window_function_invocation", "common_table_stmt", 
			"order_by_stmt", "limit_stmt", "ordering_term", "asc_desc", "frame_left", 
			"frame_right", "frame_single", "window_function", "of_OF_fset", "default_DEFAULT__value", 
			"partition_by", "order_by_expr", "order_by_expr_asc_desc", "expr_asc_desc", 
			"initial_select", "recursive__select", "unary_operator", "error_message", 
			"module_argument", "column_alias", "keyword", "name", "function_name", 
			"schema_name", "table_name", "table_or_index_name", "new_table_name", 
			"column_name", "collation_name", "foreign_table", "index_name", "trigger_name", 
			"view_name", "module_name", "pragma_name", "savepoint_name", "table_alias", 
			"transaction_name", "window_name", "alias", "filename", "base_window_name", 
			"simple_func", "aggregate_func", "table_function_name", "any_name"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'.'", "'('", "')'", "','", "'='", "'*'", "'+'", "'-'", 
			"'~'", "'||'", "'/'", "'%'", "'<<'", "'>>'", "'&'", "'|'", "'<'", "'<='", 
			"'>'", "'>='", "'=='", "'!='", "'<>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SCOL", "DOT", "OPEN_PAR", "CLOSE_PAR", "COMMA", "ASSIGN", "STAR", 
			"PLUS", "MINUS", "TILDE", "PIPE2", "DIV", "MOD", "LT2", "GT2", "AMP", 
			"PIPE", "LT", "LT_EQ", "GT", "GT_EQ", "EQ", "NOT_EQ1", "NOT_EQ2", "ABORT_", 
			"ACTION_", "ADD_", "AFTER_", "ALL_", "ALTER_", "ANALYZE_", "AND_", "AS_", 
			"ASC_", "ATTACH_", "AUTOINCREMENT_", "BEFORE_", "BEGIN_", "BETWEEN_", 
			"BY_", "CASCADE_", "CASE_", "CAST_", "CHECK_", "COLLATE_", "COLUMN_", 
			"COMMIT_", "CONFLICT_", "CONSTRAINT_", "CREATE_", "CROSS_", "CURRENT_DATE_", 
			"CURRENT_TIME_", "CURRENT_TIMESTAMP_", "DATABASE_", "DEFAULT_", "DEFERRABLE_", 
			"DEFERRED_", "DELETE_", "DESC_", "DETACH_", "DISTINCT_", "DROP_", "EACH_", 
			"ELSE_", "END_", "ESCAPE_", "EXCEPT_", "EXCLUSIVE_", "EXISTS_", "EXPLAIN_", 
			"FAIL_", "FOR_", "FOREIGN_", "FROM_", "FULL_", "GLOB_", "GROUP_", "HAVING_", 
			"IF_", "IGNORE_", "IMMEDIATE_", "IN_", "INDEX_", "INDEXED_", "INITIALLY_", 
			"INNER_", "INSERT_", "INSTEAD_", "INTERSECT_", "INTO_", "IS_", "ISNULL_", 
			"JOIN_", "KEY_", "LEFT_", "LIKE_", "LIMIT_", "MATCH_", "NATURAL_", "NO_", 
			"NOT_", "NOTNULL_", "NULL_", "OF_", "OFFSET_", "ON_", "OR_", "ORDER_", 
			"OUTER_", "PLAN_", "PRAGMA_", "PRIMARY_", "QUERY_", "RAISE_", "RECURSIVE_", 
			"REFERENCES_", "REGEXP_", "REINDEX_", "RELEASE_", "RENAME_", "REPLACE_", 
			"RESTRICT_", "RIGHT_", "ROLLBACK_", "ROW_", "ROWS_", "SAVEPOINT_", "SELECT_", 
			"SET_", "TABLE_", "TEMP_", "TEMPORARY_", "THEN_", "TO_", "TRANSACTION_", 
			"TRIGGER_", "UNION_", "UNIQUE_", "UPDATE_", "USING_", "VACUUM_", "VALUES_", 
			"VIEW_", "VIRTUAL_", "WHEN_", "WHERE_", "WITH_", "WITHOUT_", "FIRST_VALUE_", 
			"OVER_", "PARTITION_", "RANGE_", "PRECEDING_", "UNBOUNDED_", "CURRENT_", 
			"FOLLOWING_", "CUME_DIST_", "DENSE_RANK_", "LAG_", "LAST_VALUE_", "LEAD_", 
			"NTH_VALUE_", "NTILE_", "PERCENT_RANK_", "RANK_", "ROW_NUMBER_", "GENERATED_", 
			"ALWAYS_", "STORED_", "TRUE_", "FALSE_", "WINDOW_", "NULLS_", "FIRST_", 
			"LAST_", "FILTER_", "GROUPS_", "EXCLUDE_", "TIES_", "OTHERS_", "DO_", 
			"NOTHING_", "IDENTIFIER", "NUMERIC_LITERAL", "BIND_PARAMETER", "STRING_LITERAL", 
			"BLOB_LITERAL", "SINGLE_LINE_COMMENT", "MULTILINE_COMMENT", "SPACES", 
			"UNEXPECTED_CHAR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SQLiteParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SQLiteParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ParseContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(SQLiteParser.EOF, 0); }
		public List<Sql_stmt_listContext> sql_stmt_list() {
			return getRuleContexts(Sql_stmt_listContext.class);
		}
		public Sql_stmt_listContext sql_stmt_list(int i) {
			return getRuleContext(Sql_stmt_listContext.class,i);
		}
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterParse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitParse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitParse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SCOL) | (1L << ALTER_) | (1L << ANALYZE_) | (1L << ATTACH_) | (1L << BEGIN_) | (1L << COMMIT_) | (1L << CREATE_) | (1L << DEFAULT_) | (1L << DELETE_) | (1L << DETACH_) | (1L << DROP_))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (END_ - 66)) | (1L << (EXPLAIN_ - 66)) | (1L << (INSERT_ - 66)) | (1L << (PRAGMA_ - 66)) | (1L << (REINDEX_ - 66)) | (1L << (RELEASE_ - 66)) | (1L << (REPLACE_ - 66)) | (1L << (ROLLBACK_ - 66)) | (1L << (SAVEPOINT_ - 66)) | (1L << (SELECT_ - 66)))) != 0) || ((((_la - 140)) & ~0x3f) == 0 && ((1L << (_la - 140)) & ((1L << (UPDATE_ - 140)) | (1L << (VACUUM_ - 140)) | (1L << (VALUES_ - 140)) | (1L << (WITH_ - 140)))) != 0)) {
				{
				{
				setState(222);
				sql_stmt_list();
				}
				}
				setState(227);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(228);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sql_stmt_listContext extends ParserRuleContext {
		public List<Sql_stmtContext> sql_stmt() {
			return getRuleContexts(Sql_stmtContext.class);
		}
		public Sql_stmtContext sql_stmt(int i) {
			return getRuleContext(Sql_stmtContext.class,i);
		}
		public List<TerminalNode> SCOL() { return getTokens(SQLiteParser.SCOL); }
		public TerminalNode SCOL(int i) {
			return getToken(SQLiteParser.SCOL, i);
		}
		public Sql_stmt_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sql_stmt_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterSql_stmt_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitSql_stmt_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitSql_stmt_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sql_stmt_listContext sql_stmt_list() throws RecognitionException {
		Sql_stmt_listContext _localctx = new Sql_stmt_listContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sql_stmt_list);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SCOL) {
				{
				{
				setState(230);
				match(SCOL);
				}
				}
				setState(235);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(236);
			sql_stmt();
			setState(245);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(238); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(237);
						match(SCOL);
						}
						}
						setState(240); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SCOL );
					setState(242);
					sql_stmt();
					}
					} 
				}
				setState(247);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(251);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(248);
					match(SCOL);
					}
					} 
				}
				setState(253);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sql_stmtContext extends ParserRuleContext {
		public Alter_table_stmtContext alter_table_stmt() {
			return getRuleContext(Alter_table_stmtContext.class,0);
		}
		public Analyze_stmtContext analyze_stmt() {
			return getRuleContext(Analyze_stmtContext.class,0);
		}
		public Attach_stmtContext attach_stmt() {
			return getRuleContext(Attach_stmtContext.class,0);
		}
		public Begin_stmtContext begin_stmt() {
			return getRuleContext(Begin_stmtContext.class,0);
		}
		public Commit_stmtContext commit_stmt() {
			return getRuleContext(Commit_stmtContext.class,0);
		}
		public Create_index_stmtContext create_index_stmt() {
			return getRuleContext(Create_index_stmtContext.class,0);
		}
		public Create_table_stmtContext create_table_stmt() {
			return getRuleContext(Create_table_stmtContext.class,0);
		}
		public Create_trigger_stmtContext create_trigger_stmt() {
			return getRuleContext(Create_trigger_stmtContext.class,0);
		}
		public Create_view_stmtContext create_view_stmt() {
			return getRuleContext(Create_view_stmtContext.class,0);
		}
		public Create_virtual_table_stmtContext create_virtual_table_stmt() {
			return getRuleContext(Create_virtual_table_stmtContext.class,0);
		}
		public Delete_stmtContext delete_stmt() {
			return getRuleContext(Delete_stmtContext.class,0);
		}
		public Delete_stmt_limitedContext delete_stmt_limited() {
			return getRuleContext(Delete_stmt_limitedContext.class,0);
		}
		public Detach_stmtContext detach_stmt() {
			return getRuleContext(Detach_stmtContext.class,0);
		}
		public Drop_stmtContext drop_stmt() {
			return getRuleContext(Drop_stmtContext.class,0);
		}
		public Insert_stmtContext insert_stmt() {
			return getRuleContext(Insert_stmtContext.class,0);
		}
		public Pragma_stmtContext pragma_stmt() {
			return getRuleContext(Pragma_stmtContext.class,0);
		}
		public Reindex_stmtContext reindex_stmt() {
			return getRuleContext(Reindex_stmtContext.class,0);
		}
		public Release_stmtContext release_stmt() {
			return getRuleContext(Release_stmtContext.class,0);
		}
		public Rollback_stmtContext rollback_stmt() {
			return getRuleContext(Rollback_stmtContext.class,0);
		}
		public Savepoint_stmtContext savepoint_stmt() {
			return getRuleContext(Savepoint_stmtContext.class,0);
		}
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public Update_stmtContext update_stmt() {
			return getRuleContext(Update_stmtContext.class,0);
		}
		public Update_stmt_limitedContext update_stmt_limited() {
			return getRuleContext(Update_stmt_limitedContext.class,0);
		}
		public Vacuum_stmtContext vacuum_stmt() {
			return getRuleContext(Vacuum_stmtContext.class,0);
		}
		public TerminalNode EXPLAIN_() { return getToken(SQLiteParser.EXPLAIN_, 0); }
		public TerminalNode QUERY_() { return getToken(SQLiteParser.QUERY_, 0); }
		public TerminalNode PLAN_() { return getToken(SQLiteParser.PLAN_, 0); }
		public Sql_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sql_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterSql_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitSql_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitSql_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sql_stmtContext sql_stmt() throws RecognitionException {
		Sql_stmtContext _localctx = new Sql_stmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_sql_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXPLAIN_) {
				{
				setState(254);
				match(EXPLAIN_);
				setState(257);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==QUERY_) {
					{
					setState(255);
					match(QUERY_);
					setState(256);
					match(PLAN_);
					}
				}

				}
			}

			setState(285);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(261);
				alter_table_stmt();
				}
				break;
			case 2:
				{
				setState(262);
				analyze_stmt();
				}
				break;
			case 3:
				{
				setState(263);
				attach_stmt();
				}
				break;
			case 4:
				{
				setState(264);
				begin_stmt();
				}
				break;
			case 5:
				{
				setState(265);
				commit_stmt();
				}
				break;
			case 6:
				{
				setState(266);
				create_index_stmt();
				}
				break;
			case 7:
				{
				setState(267);
				create_table_stmt();
				}
				break;
			case 8:
				{
				setState(268);
				create_trigger_stmt();
				}
				break;
			case 9:
				{
				setState(269);
				create_view_stmt();
				}
				break;
			case 10:
				{
				setState(270);
				create_virtual_table_stmt();
				}
				break;
			case 11:
				{
				setState(271);
				delete_stmt();
				}
				break;
			case 12:
				{
				setState(272);
				delete_stmt_limited();
				}
				break;
			case 13:
				{
				setState(273);
				detach_stmt();
				}
				break;
			case 14:
				{
				setState(274);
				drop_stmt();
				}
				break;
			case 15:
				{
				setState(275);
				insert_stmt();
				}
				break;
			case 16:
				{
				setState(276);
				pragma_stmt();
				}
				break;
			case 17:
				{
				setState(277);
				reindex_stmt();
				}
				break;
			case 18:
				{
				setState(278);
				release_stmt();
				}
				break;
			case 19:
				{
				setState(279);
				rollback_stmt();
				}
				break;
			case 20:
				{
				setState(280);
				savepoint_stmt();
				}
				break;
			case 21:
				{
				setState(281);
				select_stmt();
				}
				break;
			case 22:
				{
				setState(282);
				update_stmt();
				}
				break;
			case 23:
				{
				setState(283);
				update_stmt_limited();
				}
				break;
			case 24:
				{
				setState(284);
				vacuum_stmt();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Alter_table_stmtContext extends ParserRuleContext {
		public Column_nameContext old_column_name;
		public Column_nameContext new_column_name;
		public TerminalNode ALTER_() { return getToken(SQLiteParser.ALTER_, 0); }
		public TerminalNode TABLE_() { return getToken(SQLiteParser.TABLE_, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode RENAME_() { return getToken(SQLiteParser.RENAME_, 0); }
		public TerminalNode ADD_() { return getToken(SQLiteParser.ADD_, 0); }
		public Column_defContext column_def() {
			return getRuleContext(Column_defContext.class,0);
		}
		public Schema_nameContext schema_name() {
			return getRuleContext(Schema_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public TerminalNode TO_() { return getToken(SQLiteParser.TO_, 0); }
		public New_table_nameContext new_table_name() {
			return getRuleContext(New_table_nameContext.class,0);
		}
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public TerminalNode COLUMN_() { return getToken(SQLiteParser.COLUMN_, 0); }
		public Alter_table_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alter_table_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterAlter_table_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitAlter_table_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitAlter_table_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Alter_table_stmtContext alter_table_stmt() throws RecognitionException {
		Alter_table_stmtContext _localctx = new Alter_table_stmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_alter_table_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			match(ALTER_);
			setState(288);
			match(TABLE_);
			setState(292);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(289);
				schema_name();
				setState(290);
				match(DOT);
				}
				break;
			}
			setState(294);
			table_name();
			setState(312);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RENAME_:
				{
				setState(295);
				match(RENAME_);
				setState(305);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(296);
					match(TO_);
					setState(297);
					new_table_name();
					}
					break;
				case 2:
					{
					setState(299);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						setState(298);
						match(COLUMN_);
						}
						break;
					}
					setState(301);
					((Alter_table_stmtContext)_localctx).old_column_name = column_name();
					setState(302);
					match(TO_);
					setState(303);
					((Alter_table_stmtContext)_localctx).new_column_name = column_name();
					}
					break;
				}
				}
				break;
			case ADD_:
				{
				setState(307);
				match(ADD_);
				setState(309);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(308);
					match(COLUMN_);
					}
					break;
				}
				setState(311);
				column_def();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Analyze_stmtContext extends ParserRuleContext {
		public TerminalNode ANALYZE_() { return getToken(SQLiteParser.ANALYZE_, 0); }
		public Schema_nameContext schema_name() {
			return getRuleContext(Schema_nameContext.class,0);
		}
		public Table_or_index_nameContext table_or_index_name() {
			return getRuleContext(Table_or_index_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public Analyze_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_analyze_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterAnalyze_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitAnalyze_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitAnalyze_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Analyze_stmtContext analyze_stmt() throws RecognitionException {
		Analyze_stmtContext _localctx = new Analyze_stmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_analyze_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			match(ANALYZE_);
			setState(322);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(315);
				schema_name();
				}
				break;
			case 2:
				{
				setState(319);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(316);
					schema_name();
					setState(317);
					match(DOT);
					}
					break;
				}
				setState(321);
				table_or_index_name();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Attach_stmtContext extends ParserRuleContext {
		public TerminalNode ATTACH_() { return getToken(SQLiteParser.ATTACH_, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode AS_() { return getToken(SQLiteParser.AS_, 0); }
		public Schema_nameContext schema_name() {
			return getRuleContext(Schema_nameContext.class,0);
		}
		public TerminalNode DATABASE_() { return getToken(SQLiteParser.DATABASE_, 0); }
		public Attach_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attach_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterAttach_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitAttach_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitAttach_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Attach_stmtContext attach_stmt() throws RecognitionException {
		Attach_stmtContext _localctx = new Attach_stmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_attach_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324);
			match(ATTACH_);
			setState(326);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(325);
				match(DATABASE_);
				}
				break;
			}
			setState(328);
			expr(0);
			setState(329);
			match(AS_);
			setState(330);
			schema_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Begin_stmtContext extends ParserRuleContext {
		public TerminalNode BEGIN_() { return getToken(SQLiteParser.BEGIN_, 0); }
		public TerminalNode TRANSACTION_() { return getToken(SQLiteParser.TRANSACTION_, 0); }
		public TerminalNode DEFERRED_() { return getToken(SQLiteParser.DEFERRED_, 0); }
		public TerminalNode IMMEDIATE_() { return getToken(SQLiteParser.IMMEDIATE_, 0); }
		public TerminalNode EXCLUSIVE_() { return getToken(SQLiteParser.EXCLUSIVE_, 0); }
		public Transaction_nameContext transaction_name() {
			return getRuleContext(Transaction_nameContext.class,0);
		}
		public Begin_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_begin_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterBegin_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitBegin_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitBegin_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Begin_stmtContext begin_stmt() throws RecognitionException {
		Begin_stmtContext _localctx = new Begin_stmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_begin_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			match(BEGIN_);
			setState(334);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 58)) & ~0x3f) == 0 && ((1L << (_la - 58)) & ((1L << (DEFERRED_ - 58)) | (1L << (EXCLUSIVE_ - 58)) | (1L << (IMMEDIATE_ - 58)))) != 0)) {
				{
				setState(333);
				_la = _input.LA(1);
				if ( !(((((_la - 58)) & ~0x3f) == 0 && ((1L << (_la - 58)) & ((1L << (DEFERRED_ - 58)) | (1L << (EXCLUSIVE_ - 58)) | (1L << (IMMEDIATE_ - 58)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(340);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TRANSACTION_) {
				{
				setState(336);
				match(TRANSACTION_);
				setState(338);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(337);
					transaction_name();
					}
					break;
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Commit_stmtContext extends ParserRuleContext {
		public TerminalNode COMMIT_() { return getToken(SQLiteParser.COMMIT_, 0); }
		public TerminalNode END_() { return getToken(SQLiteParser.END_, 0); }
		public TerminalNode TRANSACTION_() { return getToken(SQLiteParser.TRANSACTION_, 0); }
		public Commit_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commit_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterCommit_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitCommit_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitCommit_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Commit_stmtContext commit_stmt() throws RecognitionException {
		Commit_stmtContext _localctx = new Commit_stmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_commit_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			_la = _input.LA(1);
			if ( !(_la==COMMIT_ || _la==END_) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(344);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TRANSACTION_) {
				{
				setState(343);
				match(TRANSACTION_);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Rollback_stmtContext extends ParserRuleContext {
		public TerminalNode ROLLBACK_() { return getToken(SQLiteParser.ROLLBACK_, 0); }
		public TerminalNode TRANSACTION_() { return getToken(SQLiteParser.TRANSACTION_, 0); }
		public TerminalNode TO_() { return getToken(SQLiteParser.TO_, 0); }
		public Savepoint_nameContext savepoint_name() {
			return getRuleContext(Savepoint_nameContext.class,0);
		}
		public TerminalNode SAVEPOINT_() { return getToken(SQLiteParser.SAVEPOINT_, 0); }
		public Rollback_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rollback_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterRollback_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitRollback_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitRollback_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Rollback_stmtContext rollback_stmt() throws RecognitionException {
		Rollback_stmtContext _localctx = new Rollback_stmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_rollback_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
			match(ROLLBACK_);
			setState(348);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TRANSACTION_) {
				{
				setState(347);
				match(TRANSACTION_);
				}
			}

			setState(355);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TO_) {
				{
				setState(350);
				match(TO_);
				setState(352);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(351);
					match(SAVEPOINT_);
					}
					break;
				}
				setState(354);
				savepoint_name();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Savepoint_stmtContext extends ParserRuleContext {
		public TerminalNode SAVEPOINT_() { return getToken(SQLiteParser.SAVEPOINT_, 0); }
		public Savepoint_nameContext savepoint_name() {
			return getRuleContext(Savepoint_nameContext.class,0);
		}
		public Savepoint_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_savepoint_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterSavepoint_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitSavepoint_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitSavepoint_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Savepoint_stmtContext savepoint_stmt() throws RecognitionException {
		Savepoint_stmtContext _localctx = new Savepoint_stmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_savepoint_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(357);
			match(SAVEPOINT_);
			setState(358);
			savepoint_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Release_stmtContext extends ParserRuleContext {
		public TerminalNode RELEASE_() { return getToken(SQLiteParser.RELEASE_, 0); }
		public Savepoint_nameContext savepoint_name() {
			return getRuleContext(Savepoint_nameContext.class,0);
		}
		public TerminalNode SAVEPOINT_() { return getToken(SQLiteParser.SAVEPOINT_, 0); }
		public Release_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_release_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterRelease_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitRelease_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitRelease_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Release_stmtContext release_stmt() throws RecognitionException {
		Release_stmtContext _localctx = new Release_stmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_release_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
			match(RELEASE_);
			setState(362);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(361);
				match(SAVEPOINT_);
				}
				break;
			}
			setState(364);
			savepoint_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Create_index_stmtContext extends ParserRuleContext {
		public TerminalNode CREATE_() { return getToken(SQLiteParser.CREATE_, 0); }
		public TerminalNode INDEX_() { return getToken(SQLiteParser.INDEX_, 0); }
		public Index_nameContext index_name() {
			return getRuleContext(Index_nameContext.class,0);
		}
		public TerminalNode ON_() { return getToken(SQLiteParser.ON_, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public List<Indexed_columnContext> indexed_column() {
			return getRuleContexts(Indexed_columnContext.class);
		}
		public Indexed_columnContext indexed_column(int i) {
			return getRuleContext(Indexed_columnContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public TerminalNode UNIQUE_() { return getToken(SQLiteParser.UNIQUE_, 0); }
		public TerminalNode IF_() { return getToken(SQLiteParser.IF_, 0); }
		public TerminalNode NOT_() { return getToken(SQLiteParser.NOT_, 0); }
		public TerminalNode EXISTS_() { return getToken(SQLiteParser.EXISTS_, 0); }
		public Schema_nameContext schema_name() {
			return getRuleContext(Schema_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public TerminalNode WHERE_() { return getToken(SQLiteParser.WHERE_, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Create_index_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_index_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterCreate_index_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitCreate_index_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitCreate_index_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Create_index_stmtContext create_index_stmt() throws RecognitionException {
		Create_index_stmtContext _localctx = new Create_index_stmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_create_index_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
			match(CREATE_);
			setState(368);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==UNIQUE_) {
				{
				setState(367);
				match(UNIQUE_);
				}
			}

			setState(370);
			match(INDEX_);
			setState(374);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(371);
				match(IF_);
				setState(372);
				match(NOT_);
				setState(373);
				match(EXISTS_);
				}
				break;
			}
			setState(379);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(376);
				schema_name();
				setState(377);
				match(DOT);
				}
				break;
			}
			setState(381);
			index_name();
			setState(382);
			match(ON_);
			setState(383);
			table_name();
			setState(384);
			match(OPEN_PAR);
			setState(385);
			indexed_column();
			setState(390);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(386);
				match(COMMA);
				setState(387);
				indexed_column();
				}
				}
				setState(392);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(393);
			match(CLOSE_PAR);
			setState(396);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE_) {
				{
				setState(394);
				match(WHERE_);
				setState(395);
				expr(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Indexed_columnContext extends ParserRuleContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode COLLATE_() { return getToken(SQLiteParser.COLLATE_, 0); }
		public Collation_nameContext collation_name() {
			return getRuleContext(Collation_nameContext.class,0);
		}
		public Asc_descContext asc_desc() {
			return getRuleContext(Asc_descContext.class,0);
		}
		public Indexed_columnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexed_column; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterIndexed_column(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitIndexed_column(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitIndexed_column(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Indexed_columnContext indexed_column() throws RecognitionException {
		Indexed_columnContext _localctx = new Indexed_columnContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_indexed_column);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(400);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(398);
				column_name();
				}
				break;
			case 2:
				{
				setState(399);
				expr(0);
				}
				break;
			}
			setState(404);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLLATE_) {
				{
				setState(402);
				match(COLLATE_);
				setState(403);
				collation_name();
				}
			}

			setState(407);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASC_ || _la==DESC_) {
				{
				setState(406);
				asc_desc();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Create_table_stmtContext extends ParserRuleContext {
		public Token row_ROW_ID;
		public TerminalNode CREATE_() { return getToken(SQLiteParser.CREATE_, 0); }
		public TerminalNode TABLE_() { return getToken(SQLiteParser.TABLE_, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public List<Column_defContext> column_def() {
			return getRuleContexts(Column_defContext.class);
		}
		public Column_defContext column_def(int i) {
			return getRuleContext(Column_defContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public TerminalNode AS_() { return getToken(SQLiteParser.AS_, 0); }
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public TerminalNode IF_() { return getToken(SQLiteParser.IF_, 0); }
		public TerminalNode NOT_() { return getToken(SQLiteParser.NOT_, 0); }
		public TerminalNode EXISTS_() { return getToken(SQLiteParser.EXISTS_, 0); }
		public Schema_nameContext schema_name() {
			return getRuleContext(Schema_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public TerminalNode TEMP_() { return getToken(SQLiteParser.TEMP_, 0); }
		public TerminalNode TEMPORARY_() { return getToken(SQLiteParser.TEMPORARY_, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public List<Table_constraintContext> table_constraint() {
			return getRuleContexts(Table_constraintContext.class);
		}
		public Table_constraintContext table_constraint(int i) {
			return getRuleContext(Table_constraintContext.class,i);
		}
		public TerminalNode WITHOUT_() { return getToken(SQLiteParser.WITHOUT_, 0); }
		public TerminalNode IDENTIFIER() { return getToken(SQLiteParser.IDENTIFIER, 0); }
		public Create_table_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_table_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterCreate_table_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitCreate_table_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitCreate_table_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Create_table_stmtContext create_table_stmt() throws RecognitionException {
		Create_table_stmtContext _localctx = new Create_table_stmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_create_table_stmt);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(409);
			match(CREATE_);
			setState(411);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TEMP_ || _la==TEMPORARY_) {
				{
				setState(410);
				_la = _input.LA(1);
				if ( !(_la==TEMP_ || _la==TEMPORARY_) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(413);
			match(TABLE_);
			setState(417);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(414);
				match(IF_);
				setState(415);
				match(NOT_);
				setState(416);
				match(EXISTS_);
				}
				break;
			}
			setState(422);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(419);
				schema_name();
				setState(420);
				match(DOT);
				}
				break;
			}
			setState(424);
			table_name();
			setState(448);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_PAR:
				{
				setState(425);
				match(OPEN_PAR);
				setState(426);
				column_def();
				setState(431);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(427);
						match(COMMA);
						setState(428);
						column_def();
						}
						} 
					}
					setState(433);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
				}
				setState(438);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(434);
					match(COMMA);
					setState(435);
					table_constraint();
					}
					}
					setState(440);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(441);
				match(CLOSE_PAR);
				setState(444);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WITHOUT_) {
					{
					setState(442);
					match(WITHOUT_);
					setState(443);
					((Create_table_stmtContext)_localctx).row_ROW_ID = match(IDENTIFIER);
					}
				}

				}
				break;
			case AS_:
				{
				setState(446);
				match(AS_);
				setState(447);
				select_stmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Column_defContext extends ParserRuleContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public Type_nameContext type_name() {
			return getRuleContext(Type_nameContext.class,0);
		}
		public List<Column_constraintContext> column_constraint() {
			return getRuleContexts(Column_constraintContext.class);
		}
		public Column_constraintContext column_constraint(int i) {
			return getRuleContext(Column_constraintContext.class,i);
		}
		public Column_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterColumn_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitColumn_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitColumn_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Column_defContext column_def() throws RecognitionException {
		Column_defContext _localctx = new Column_defContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_column_def);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(450);
			column_name();
			setState(452);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				setState(451);
				type_name();
				}
				break;
			}
			setState(457);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(454);
					column_constraint();
					}
					} 
				}
				setState(459);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_nameContext extends ParserRuleContext {
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public List<Signed_numberContext> signed_number() {
			return getRuleContexts(Signed_numberContext.class);
		}
		public Signed_numberContext signed_number(int i) {
			return getRuleContext(Signed_numberContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public TerminalNode COMMA() { return getToken(SQLiteParser.COMMA, 0); }
		public Type_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterType_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitType_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitType_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_nameContext type_name() throws RecognitionException {
		Type_nameContext _localctx = new Type_nameContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_type_name);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(461); 
			_errHandler.sync(this);
			_alt = 1+1;
			do {
				switch (_alt) {
				case 1+1:
					{
					{
					setState(460);
					name();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(463); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			} while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(475);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				{
				setState(465);
				match(OPEN_PAR);
				setState(466);
				signed_number();
				setState(467);
				match(CLOSE_PAR);
				}
				break;
			case 2:
				{
				setState(469);
				match(OPEN_PAR);
				setState(470);
				signed_number();
				setState(471);
				match(COMMA);
				setState(472);
				signed_number();
				setState(473);
				match(CLOSE_PAR);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Column_constraintContext extends ParserRuleContext {
		public TerminalNode CHECK_() { return getToken(SQLiteParser.CHECK_, 0); }
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public TerminalNode DEFAULT_() { return getToken(SQLiteParser.DEFAULT_, 0); }
		public TerminalNode COLLATE_() { return getToken(SQLiteParser.COLLATE_, 0); }
		public Collation_nameContext collation_name() {
			return getRuleContext(Collation_nameContext.class,0);
		}
		public Foreign_key_clauseContext foreign_key_clause() {
			return getRuleContext(Foreign_key_clauseContext.class,0);
		}
		public TerminalNode AS_() { return getToken(SQLiteParser.AS_, 0); }
		public TerminalNode CONSTRAINT_() { return getToken(SQLiteParser.CONSTRAINT_, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode PRIMARY_() { return getToken(SQLiteParser.PRIMARY_, 0); }
		public TerminalNode KEY_() { return getToken(SQLiteParser.KEY_, 0); }
		public TerminalNode NOT_() { return getToken(SQLiteParser.NOT_, 0); }
		public TerminalNode NULL_() { return getToken(SQLiteParser.NULL_, 0); }
		public TerminalNode UNIQUE_() { return getToken(SQLiteParser.UNIQUE_, 0); }
		public Signed_numberContext signed_number() {
			return getRuleContext(Signed_numberContext.class,0);
		}
		public Literal_valueContext literal_value() {
			return getRuleContext(Literal_valueContext.class,0);
		}
		public Conflict_clauseContext conflict_clause() {
			return getRuleContext(Conflict_clauseContext.class,0);
		}
		public TerminalNode GENERATED_() { return getToken(SQLiteParser.GENERATED_, 0); }
		public TerminalNode ALWAYS_() { return getToken(SQLiteParser.ALWAYS_, 0); }
		public TerminalNode STORED_() { return getToken(SQLiteParser.STORED_, 0); }
		public TerminalNode VIRTUAL_() { return getToken(SQLiteParser.VIRTUAL_, 0); }
		public Asc_descContext asc_desc() {
			return getRuleContext(Asc_descContext.class,0);
		}
		public TerminalNode AUTOINCREMENT_() { return getToken(SQLiteParser.AUTOINCREMENT_, 0); }
		public Column_constraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_constraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterColumn_constraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitColumn_constraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitColumn_constraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Column_constraintContext column_constraint() throws RecognitionException {
		Column_constraintContext _localctx = new Column_constraintContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_column_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(479);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONSTRAINT_) {
				{
				setState(477);
				match(CONSTRAINT_);
				setState(478);
				name();
				}
			}

			setState(528);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRIMARY_:
				{
				{
				setState(481);
				match(PRIMARY_);
				setState(482);
				match(KEY_);
				setState(484);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASC_ || _la==DESC_) {
					{
					setState(483);
					asc_desc();
					}
				}

				setState(487);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ON_) {
					{
					setState(486);
					conflict_clause();
					}
				}

				setState(490);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AUTOINCREMENT_) {
					{
					setState(489);
					match(AUTOINCREMENT_);
					}
				}

				}
				}
				break;
			case NOT_:
			case UNIQUE_:
				{
				setState(495);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NOT_:
					{
					setState(492);
					match(NOT_);
					setState(493);
					match(NULL_);
					}
					break;
				case UNIQUE_:
					{
					setState(494);
					match(UNIQUE_);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(498);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ON_) {
					{
					setState(497);
					conflict_clause();
					}
				}

				}
				break;
			case CHECK_:
				{
				setState(500);
				match(CHECK_);
				setState(501);
				match(OPEN_PAR);
				setState(502);
				expr(0);
				setState(503);
				match(CLOSE_PAR);
				}
				break;
			case DEFAULT_:
				{
				setState(505);
				match(DEFAULT_);
				setState(512);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
				case 1:
					{
					setState(506);
					signed_number();
					}
					break;
				case 2:
					{
					setState(507);
					literal_value();
					}
					break;
				case 3:
					{
					setState(508);
					match(OPEN_PAR);
					setState(509);
					expr(0);
					setState(510);
					match(CLOSE_PAR);
					}
					break;
				}
				}
				break;
			case COLLATE_:
				{
				setState(514);
				match(COLLATE_);
				setState(515);
				collation_name();
				}
				break;
			case REFERENCES_:
				{
				setState(516);
				foreign_key_clause();
				}
				break;
			case AS_:
			case GENERATED_:
				{
				setState(519);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==GENERATED_) {
					{
					setState(517);
					match(GENERATED_);
					setState(518);
					match(ALWAYS_);
					}
				}

				setState(521);
				match(AS_);
				setState(522);
				match(OPEN_PAR);
				setState(523);
				expr(0);
				setState(524);
				match(CLOSE_PAR);
				setState(526);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==VIRTUAL_ || _la==STORED_) {
					{
					setState(525);
					_la = _input.LA(1);
					if ( !(_la==VIRTUAL_ || _la==STORED_) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Signed_numberContext extends ParserRuleContext {
		public TerminalNode NUMERIC_LITERAL() { return getToken(SQLiteParser.NUMERIC_LITERAL, 0); }
		public TerminalNode PLUS() { return getToken(SQLiteParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(SQLiteParser.MINUS, 0); }
		public Signed_numberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signed_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterSigned_number(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitSigned_number(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitSigned_number(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Signed_numberContext signed_number() throws RecognitionException {
		Signed_numberContext _localctx = new Signed_numberContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_signed_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(531);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(530);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(533);
			match(NUMERIC_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_constraintContext extends ParserRuleContext {
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public List<Indexed_columnContext> indexed_column() {
			return getRuleContexts(Indexed_columnContext.class);
		}
		public Indexed_columnContext indexed_column(int i) {
			return getRuleContext(Indexed_columnContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public TerminalNode CHECK_() { return getToken(SQLiteParser.CHECK_, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FOREIGN_() { return getToken(SQLiteParser.FOREIGN_, 0); }
		public TerminalNode KEY_() { return getToken(SQLiteParser.KEY_, 0); }
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public Foreign_key_clauseContext foreign_key_clause() {
			return getRuleContext(Foreign_key_clauseContext.class,0);
		}
		public TerminalNode CONSTRAINT_() { return getToken(SQLiteParser.CONSTRAINT_, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode PRIMARY_() { return getToken(SQLiteParser.PRIMARY_, 0); }
		public TerminalNode UNIQUE_() { return getToken(SQLiteParser.UNIQUE_, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Conflict_clauseContext conflict_clause() {
			return getRuleContext(Conflict_clauseContext.class,0);
		}
		public Table_constraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_constraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterTable_constraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitTable_constraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitTable_constraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Table_constraintContext table_constraint() throws RecognitionException {
		Table_constraintContext _localctx = new Table_constraintContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_table_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(537);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONSTRAINT_) {
				{
				setState(535);
				match(CONSTRAINT_);
				setState(536);
				name();
				}
			}

			setState(576);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRIMARY_:
			case UNIQUE_:
				{
				setState(542);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PRIMARY_:
					{
					setState(539);
					match(PRIMARY_);
					setState(540);
					match(KEY_);
					}
					break;
				case UNIQUE_:
					{
					setState(541);
					match(UNIQUE_);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(544);
				match(OPEN_PAR);
				setState(545);
				indexed_column();
				setState(550);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(546);
					match(COMMA);
					setState(547);
					indexed_column();
					}
					}
					setState(552);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(553);
				match(CLOSE_PAR);
				setState(555);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ON_) {
					{
					setState(554);
					conflict_clause();
					}
				}

				}
				break;
			case CHECK_:
				{
				setState(557);
				match(CHECK_);
				setState(558);
				match(OPEN_PAR);
				setState(559);
				expr(0);
				setState(560);
				match(CLOSE_PAR);
				}
				break;
			case FOREIGN_:
				{
				setState(562);
				match(FOREIGN_);
				setState(563);
				match(KEY_);
				setState(564);
				match(OPEN_PAR);
				setState(565);
				column_name();
				setState(570);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(566);
					match(COMMA);
					setState(567);
					column_name();
					}
					}
					setState(572);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(573);
				match(CLOSE_PAR);
				setState(574);
				foreign_key_clause();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Foreign_key_clauseContext extends ParserRuleContext {
		public TerminalNode REFERENCES_() { return getToken(SQLiteParser.REFERENCES_, 0); }
		public Foreign_tableContext foreign_table() {
			return getRuleContext(Foreign_tableContext.class,0);
		}
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public List<TerminalNode> ON_() { return getTokens(SQLiteParser.ON_); }
		public TerminalNode ON_(int i) {
			return getToken(SQLiteParser.ON_, i);
		}
		public List<TerminalNode> MATCH_() { return getTokens(SQLiteParser.MATCH_); }
		public TerminalNode MATCH_(int i) {
			return getToken(SQLiteParser.MATCH_, i);
		}
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public TerminalNode DEFERRABLE_() { return getToken(SQLiteParser.DEFERRABLE_, 0); }
		public List<TerminalNode> DELETE_() { return getTokens(SQLiteParser.DELETE_); }
		public TerminalNode DELETE_(int i) {
			return getToken(SQLiteParser.DELETE_, i);
		}
		public List<TerminalNode> UPDATE_() { return getTokens(SQLiteParser.UPDATE_); }
		public TerminalNode UPDATE_(int i) {
			return getToken(SQLiteParser.UPDATE_, i);
		}
		public List<TerminalNode> SET_() { return getTokens(SQLiteParser.SET_); }
		public TerminalNode SET_(int i) {
			return getToken(SQLiteParser.SET_, i);
		}
		public List<TerminalNode> CASCADE_() { return getTokens(SQLiteParser.CASCADE_); }
		public TerminalNode CASCADE_(int i) {
			return getToken(SQLiteParser.CASCADE_, i);
		}
		public List<TerminalNode> RESTRICT_() { return getTokens(SQLiteParser.RESTRICT_); }
		public TerminalNode RESTRICT_(int i) {
			return getToken(SQLiteParser.RESTRICT_, i);
		}
		public List<TerminalNode> NO_() { return getTokens(SQLiteParser.NO_); }
		public TerminalNode NO_(int i) {
			return getToken(SQLiteParser.NO_, i);
		}
		public List<TerminalNode> ACTION_() { return getTokens(SQLiteParser.ACTION_); }
		public TerminalNode ACTION_(int i) {
			return getToken(SQLiteParser.ACTION_, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public List<TerminalNode> NULL_() { return getTokens(SQLiteParser.NULL_); }
		public TerminalNode NULL_(int i) {
			return getToken(SQLiteParser.NULL_, i);
		}
		public List<TerminalNode> DEFAULT_() { return getTokens(SQLiteParser.DEFAULT_); }
		public TerminalNode DEFAULT_(int i) {
			return getToken(SQLiteParser.DEFAULT_, i);
		}
		public TerminalNode NOT_() { return getToken(SQLiteParser.NOT_, 0); }
		public TerminalNode INITIALLY_() { return getToken(SQLiteParser.INITIALLY_, 0); }
		public TerminalNode DEFERRED_() { return getToken(SQLiteParser.DEFERRED_, 0); }
		public TerminalNode IMMEDIATE_() { return getToken(SQLiteParser.IMMEDIATE_, 0); }
		public Foreign_key_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foreign_key_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterForeign_key_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitForeign_key_clause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitForeign_key_clause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Foreign_key_clauseContext foreign_key_clause() throws RecognitionException {
		Foreign_key_clauseContext _localctx = new Foreign_key_clauseContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_foreign_key_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(578);
			match(REFERENCES_);
			setState(579);
			foreign_table();
			setState(591);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_PAR) {
				{
				setState(580);
				match(OPEN_PAR);
				setState(581);
				column_name();
				setState(586);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(582);
					match(COMMA);
					setState(583);
					column_name();
					}
					}
					setState(588);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(589);
				match(CLOSE_PAR);
				}
			}

			setState(607);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MATCH_ || _la==ON_) {
				{
				setState(605);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ON_:
					{
					setState(593);
					match(ON_);
					setState(594);
					_la = _input.LA(1);
					if ( !(_la==DELETE_ || _la==UPDATE_) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(601);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case SET_:
						{
						setState(595);
						match(SET_);
						setState(596);
						_la = _input.LA(1);
						if ( !(_la==DEFAULT_ || _la==NULL_) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					case CASCADE_:
						{
						setState(597);
						match(CASCADE_);
						}
						break;
					case RESTRICT_:
						{
						setState(598);
						match(RESTRICT_);
						}
						break;
					case NO_:
						{
						setState(599);
						match(NO_);
						setState(600);
						match(ACTION_);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				case MATCH_:
					{
					setState(603);
					match(MATCH_);
					setState(604);
					name();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(609);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(618);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
			case 1:
				{
				setState(611);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT_) {
					{
					setState(610);
					match(NOT_);
					}
				}

				setState(613);
				match(DEFERRABLE_);
				setState(616);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INITIALLY_) {
					{
					setState(614);
					match(INITIALLY_);
					setState(615);
					_la = _input.LA(1);
					if ( !(_la==DEFERRED_ || _la==IMMEDIATE_) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Conflict_clauseContext extends ParserRuleContext {
		public TerminalNode ON_() { return getToken(SQLiteParser.ON_, 0); }
		public TerminalNode CONFLICT_() { return getToken(SQLiteParser.CONFLICT_, 0); }
		public TerminalNode ROLLBACK_() { return getToken(SQLiteParser.ROLLBACK_, 0); }
		public TerminalNode ABORT_() { return getToken(SQLiteParser.ABORT_, 0); }
		public TerminalNode FAIL_() { return getToken(SQLiteParser.FAIL_, 0); }
		public TerminalNode IGNORE_() { return getToken(SQLiteParser.IGNORE_, 0); }
		public TerminalNode REPLACE_() { return getToken(SQLiteParser.REPLACE_, 0); }
		public Conflict_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conflict_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterConflict_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitConflict_clause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitConflict_clause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Conflict_clauseContext conflict_clause() throws RecognitionException {
		Conflict_clauseContext _localctx = new Conflict_clauseContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_conflict_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(620);
			match(ON_);
			setState(621);
			match(CONFLICT_);
			setState(622);
			_la = _input.LA(1);
			if ( !(_la==ABORT_ || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (FAIL_ - 72)) | (1L << (IGNORE_ - 72)) | (1L << (REPLACE_ - 72)) | (1L << (ROLLBACK_ - 72)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Create_trigger_stmtContext extends ParserRuleContext {
		public TerminalNode CREATE_() { return getToken(SQLiteParser.CREATE_, 0); }
		public TerminalNode TRIGGER_() { return getToken(SQLiteParser.TRIGGER_, 0); }
		public Trigger_nameContext trigger_name() {
			return getRuleContext(Trigger_nameContext.class,0);
		}
		public TerminalNode ON_() { return getToken(SQLiteParser.ON_, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode BEGIN_() { return getToken(SQLiteParser.BEGIN_, 0); }
		public TerminalNode END_() { return getToken(SQLiteParser.END_, 0); }
		public TerminalNode DELETE_() { return getToken(SQLiteParser.DELETE_, 0); }
		public TerminalNode INSERT_() { return getToken(SQLiteParser.INSERT_, 0); }
		public TerminalNode UPDATE_() { return getToken(SQLiteParser.UPDATE_, 0); }
		public TerminalNode IF_() { return getToken(SQLiteParser.IF_, 0); }
		public TerminalNode NOT_() { return getToken(SQLiteParser.NOT_, 0); }
		public TerminalNode EXISTS_() { return getToken(SQLiteParser.EXISTS_, 0); }
		public Schema_nameContext schema_name() {
			return getRuleContext(Schema_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public TerminalNode BEFORE_() { return getToken(SQLiteParser.BEFORE_, 0); }
		public TerminalNode AFTER_() { return getToken(SQLiteParser.AFTER_, 0); }
		public TerminalNode INSTEAD_() { return getToken(SQLiteParser.INSTEAD_, 0); }
		public List<TerminalNode> OF_() { return getTokens(SQLiteParser.OF_); }
		public TerminalNode OF_(int i) {
			return getToken(SQLiteParser.OF_, i);
		}
		public TerminalNode FOR_() { return getToken(SQLiteParser.FOR_, 0); }
		public TerminalNode EACH_() { return getToken(SQLiteParser.EACH_, 0); }
		public TerminalNode ROW_() { return getToken(SQLiteParser.ROW_, 0); }
		public TerminalNode WHEN_() { return getToken(SQLiteParser.WHEN_, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> SCOL() { return getTokens(SQLiteParser.SCOL); }
		public TerminalNode SCOL(int i) {
			return getToken(SQLiteParser.SCOL, i);
		}
		public TerminalNode TEMP_() { return getToken(SQLiteParser.TEMP_, 0); }
		public TerminalNode TEMPORARY_() { return getToken(SQLiteParser.TEMPORARY_, 0); }
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public List<Update_stmtContext> update_stmt() {
			return getRuleContexts(Update_stmtContext.class);
		}
		public Update_stmtContext update_stmt(int i) {
			return getRuleContext(Update_stmtContext.class,i);
		}
		public List<Insert_stmtContext> insert_stmt() {
			return getRuleContexts(Insert_stmtContext.class);
		}
		public Insert_stmtContext insert_stmt(int i) {
			return getRuleContext(Insert_stmtContext.class,i);
		}
		public List<Delete_stmtContext> delete_stmt() {
			return getRuleContexts(Delete_stmtContext.class);
		}
		public Delete_stmtContext delete_stmt(int i) {
			return getRuleContext(Delete_stmtContext.class,i);
		}
		public List<Select_stmtContext> select_stmt() {
			return getRuleContexts(Select_stmtContext.class);
		}
		public Select_stmtContext select_stmt(int i) {
			return getRuleContext(Select_stmtContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Create_trigger_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_trigger_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterCreate_trigger_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitCreate_trigger_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitCreate_trigger_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Create_trigger_stmtContext create_trigger_stmt() throws RecognitionException {
		Create_trigger_stmtContext _localctx = new Create_trigger_stmtContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_create_trigger_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(624);
			match(CREATE_);
			setState(626);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TEMP_ || _la==TEMPORARY_) {
				{
				setState(625);
				_la = _input.LA(1);
				if ( !(_la==TEMP_ || _la==TEMPORARY_) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(628);
			match(TRIGGER_);
			setState(632);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
			case 1:
				{
				setState(629);
				match(IF_);
				setState(630);
				match(NOT_);
				setState(631);
				match(EXISTS_);
				}
				break;
			}
			setState(637);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				{
				setState(634);
				schema_name();
				setState(635);
				match(DOT);
				}
				break;
			}
			setState(639);
			trigger_name();
			setState(644);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BEFORE_:
				{
				setState(640);
				match(BEFORE_);
				}
				break;
			case AFTER_:
				{
				setState(641);
				match(AFTER_);
				}
				break;
			case INSTEAD_:
				{
				setState(642);
				match(INSTEAD_);
				setState(643);
				match(OF_);
				}
				break;
			case DELETE_:
			case INSERT_:
			case UPDATE_:
				break;
			default:
				break;
			}
			setState(660);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DELETE_:
				{
				setState(646);
				match(DELETE_);
				}
				break;
			case INSERT_:
				{
				setState(647);
				match(INSERT_);
				}
				break;
			case UPDATE_:
				{
				setState(648);
				match(UPDATE_);
				setState(658);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OF_) {
					{
					setState(649);
					match(OF_);
					setState(650);
					column_name();
					setState(655);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(651);
						match(COMMA);
						setState(652);
						column_name();
						}
						}
						setState(657);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(662);
			match(ON_);
			setState(663);
			table_name();
			setState(667);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FOR_) {
				{
				setState(664);
				match(FOR_);
				setState(665);
				match(EACH_);
				setState(666);
				match(ROW_);
				}
			}

			setState(671);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHEN_) {
				{
				setState(669);
				match(WHEN_);
				setState(670);
				expr(0);
				}
			}

			setState(673);
			match(BEGIN_);
			setState(682); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(678);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
				case 1:
					{
					setState(674);
					update_stmt();
					}
					break;
				case 2:
					{
					setState(675);
					insert_stmt();
					}
					break;
				case 3:
					{
					setState(676);
					delete_stmt();
					}
					break;
				case 4:
					{
					setState(677);
					select_stmt();
					}
					break;
				}
				setState(680);
				match(SCOL);
				}
				}
				setState(684); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DEFAULT_ || _la==DELETE_ || ((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & ((1L << (INSERT_ - 88)) | (1L << (REPLACE_ - 88)) | (1L << (SELECT_ - 88)) | (1L << (UPDATE_ - 88)) | (1L << (VALUES_ - 88)) | (1L << (WITH_ - 88)))) != 0) );
			setState(686);
			match(END_);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Create_view_stmtContext extends ParserRuleContext {
		public TerminalNode CREATE_() { return getToken(SQLiteParser.CREATE_, 0); }
		public TerminalNode VIEW_() { return getToken(SQLiteParser.VIEW_, 0); }
		public View_nameContext view_name() {
			return getRuleContext(View_nameContext.class,0);
		}
		public TerminalNode AS_() { return getToken(SQLiteParser.AS_, 0); }
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public TerminalNode IF_() { return getToken(SQLiteParser.IF_, 0); }
		public TerminalNode NOT_() { return getToken(SQLiteParser.NOT_, 0); }
		public TerminalNode EXISTS_() { return getToken(SQLiteParser.EXISTS_, 0); }
		public Schema_nameContext schema_name() {
			return getRuleContext(Schema_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public TerminalNode TEMP_() { return getToken(SQLiteParser.TEMP_, 0); }
		public TerminalNode TEMPORARY_() { return getToken(SQLiteParser.TEMPORARY_, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Create_view_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_view_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterCreate_view_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitCreate_view_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitCreate_view_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Create_view_stmtContext create_view_stmt() throws RecognitionException {
		Create_view_stmtContext _localctx = new Create_view_stmtContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_create_view_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(688);
			match(CREATE_);
			setState(690);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TEMP_ || _la==TEMPORARY_) {
				{
				setState(689);
				_la = _input.LA(1);
				if ( !(_la==TEMP_ || _la==TEMPORARY_) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(692);
			match(VIEW_);
			setState(696);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,80,_ctx) ) {
			case 1:
				{
				setState(693);
				match(IF_);
				setState(694);
				match(NOT_);
				setState(695);
				match(EXISTS_);
				}
				break;
			}
			setState(701);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,81,_ctx) ) {
			case 1:
				{
				setState(698);
				schema_name();
				setState(699);
				match(DOT);
				}
				break;
			}
			setState(703);
			view_name();
			setState(715);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_PAR) {
				{
				setState(704);
				match(OPEN_PAR);
				setState(705);
				column_name();
				setState(710);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(706);
					match(COMMA);
					setState(707);
					column_name();
					}
					}
					setState(712);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(713);
				match(CLOSE_PAR);
				}
			}

			setState(717);
			match(AS_);
			setState(718);
			select_stmt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Create_virtual_table_stmtContext extends ParserRuleContext {
		public TerminalNode CREATE_() { return getToken(SQLiteParser.CREATE_, 0); }
		public TerminalNode VIRTUAL_() { return getToken(SQLiteParser.VIRTUAL_, 0); }
		public TerminalNode TABLE_() { return getToken(SQLiteParser.TABLE_, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode USING_() { return getToken(SQLiteParser.USING_, 0); }
		public Module_nameContext module_name() {
			return getRuleContext(Module_nameContext.class,0);
		}
		public TerminalNode IF_() { return getToken(SQLiteParser.IF_, 0); }
		public TerminalNode NOT_() { return getToken(SQLiteParser.NOT_, 0); }
		public TerminalNode EXISTS_() { return getToken(SQLiteParser.EXISTS_, 0); }
		public Schema_nameContext schema_name() {
			return getRuleContext(Schema_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public List<Module_argumentContext> module_argument() {
			return getRuleContexts(Module_argumentContext.class);
		}
		public Module_argumentContext module_argument(int i) {
			return getRuleContext(Module_argumentContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Create_virtual_table_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_virtual_table_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterCreate_virtual_table_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitCreate_virtual_table_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitCreate_virtual_table_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Create_virtual_table_stmtContext create_virtual_table_stmt() throws RecognitionException {
		Create_virtual_table_stmtContext _localctx = new Create_virtual_table_stmtContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_create_virtual_table_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(720);
			match(CREATE_);
			setState(721);
			match(VIRTUAL_);
			setState(722);
			match(TABLE_);
			setState(726);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,84,_ctx) ) {
			case 1:
				{
				setState(723);
				match(IF_);
				setState(724);
				match(NOT_);
				setState(725);
				match(EXISTS_);
				}
				break;
			}
			setState(731);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,85,_ctx) ) {
			case 1:
				{
				setState(728);
				schema_name();
				setState(729);
				match(DOT);
				}
				break;
			}
			setState(733);
			table_name();
			setState(734);
			match(USING_);
			setState(735);
			module_name();
			setState(747);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_PAR) {
				{
				setState(736);
				match(OPEN_PAR);
				setState(737);
				module_argument();
				setState(742);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(738);
					match(COMMA);
					setState(739);
					module_argument();
					}
					}
					setState(744);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(745);
				match(CLOSE_PAR);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class With_clauseContext extends ParserRuleContext {
		public TerminalNode WITH_() { return getToken(SQLiteParser.WITH_, 0); }
		public List<Cte_table_nameContext> cte_table_name() {
			return getRuleContexts(Cte_table_nameContext.class);
		}
		public Cte_table_nameContext cte_table_name(int i) {
			return getRuleContext(Cte_table_nameContext.class,i);
		}
		public List<TerminalNode> AS_() { return getTokens(SQLiteParser.AS_); }
		public TerminalNode AS_(int i) {
			return getToken(SQLiteParser.AS_, i);
		}
		public List<TerminalNode> OPEN_PAR() { return getTokens(SQLiteParser.OPEN_PAR); }
		public TerminalNode OPEN_PAR(int i) {
			return getToken(SQLiteParser.OPEN_PAR, i);
		}
		public List<Select_stmtContext> select_stmt() {
			return getRuleContexts(Select_stmtContext.class);
		}
		public Select_stmtContext select_stmt(int i) {
			return getRuleContext(Select_stmtContext.class,i);
		}
		public List<TerminalNode> CLOSE_PAR() { return getTokens(SQLiteParser.CLOSE_PAR); }
		public TerminalNode CLOSE_PAR(int i) {
			return getToken(SQLiteParser.CLOSE_PAR, i);
		}
		public TerminalNode RECURSIVE_() { return getToken(SQLiteParser.RECURSIVE_, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public With_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_with_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterWith_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitWith_clause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitWith_clause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final With_clauseContext with_clause() throws RecognitionException {
		With_clauseContext _localctx = new With_clauseContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_with_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(749);
			match(WITH_);
			setState(751);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,88,_ctx) ) {
			case 1:
				{
				setState(750);
				match(RECURSIVE_);
				}
				break;
			}
			setState(753);
			cte_table_name();
			setState(754);
			match(AS_);
			setState(755);
			match(OPEN_PAR);
			setState(756);
			select_stmt();
			setState(757);
			match(CLOSE_PAR);
			setState(767);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(758);
				match(COMMA);
				setState(759);
				cte_table_name();
				setState(760);
				match(AS_);
				setState(761);
				match(OPEN_PAR);
				setState(762);
				select_stmt();
				setState(763);
				match(CLOSE_PAR);
				}
				}
				setState(769);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Cte_table_nameContext extends ParserRuleContext {
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Cte_table_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cte_table_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterCte_table_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitCte_table_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitCte_table_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Cte_table_nameContext cte_table_name() throws RecognitionException {
		Cte_table_nameContext _localctx = new Cte_table_nameContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_cte_table_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(770);
			table_name();
			setState(782);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_PAR) {
				{
				setState(771);
				match(OPEN_PAR);
				setState(772);
				column_name();
				setState(777);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(773);
					match(COMMA);
					setState(774);
					column_name();
					}
					}
					setState(779);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(780);
				match(CLOSE_PAR);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Recursive_cteContext extends ParserRuleContext {
		public Cte_table_nameContext cte_table_name() {
			return getRuleContext(Cte_table_nameContext.class,0);
		}
		public TerminalNode AS_() { return getToken(SQLiteParser.AS_, 0); }
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public Initial_selectContext initial_select() {
			return getRuleContext(Initial_selectContext.class,0);
		}
		public TerminalNode UNION_() { return getToken(SQLiteParser.UNION_, 0); }
		public Recursive__selectContext recursive__select() {
			return getRuleContext(Recursive__selectContext.class,0);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public TerminalNode ALL_() { return getToken(SQLiteParser.ALL_, 0); }
		public Recursive_cteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recursive_cte; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterRecursive_cte(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitRecursive_cte(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitRecursive_cte(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Recursive_cteContext recursive_cte() throws RecognitionException {
		Recursive_cteContext _localctx = new Recursive_cteContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_recursive_cte);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(784);
			cte_table_name();
			setState(785);
			match(AS_);
			setState(786);
			match(OPEN_PAR);
			setState(787);
			initial_select();
			setState(788);
			match(UNION_);
			setState(790);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ALL_) {
				{
				setState(789);
				match(ALL_);
				}
			}

			setState(792);
			recursive__select();
			setState(793);
			match(CLOSE_PAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Common_table_expressionContext extends ParserRuleContext {
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode AS_() { return getToken(SQLiteParser.AS_, 0); }
		public List<TerminalNode> OPEN_PAR() { return getTokens(SQLiteParser.OPEN_PAR); }
		public TerminalNode OPEN_PAR(int i) {
			return getToken(SQLiteParser.OPEN_PAR, i);
		}
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public List<TerminalNode> CLOSE_PAR() { return getTokens(SQLiteParser.CLOSE_PAR); }
		public TerminalNode CLOSE_PAR(int i) {
			return getToken(SQLiteParser.CLOSE_PAR, i);
		}
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Common_table_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_common_table_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterCommon_table_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitCommon_table_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitCommon_table_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Common_table_expressionContext common_table_expression() throws RecognitionException {
		Common_table_expressionContext _localctx = new Common_table_expressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_common_table_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(795);
			table_name();
			setState(807);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_PAR) {
				{
				setState(796);
				match(OPEN_PAR);
				setState(797);
				column_name();
				setState(802);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(798);
					match(COMMA);
					setState(799);
					column_name();
					}
					}
					setState(804);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(805);
				match(CLOSE_PAR);
				}
			}

			setState(809);
			match(AS_);
			setState(810);
			match(OPEN_PAR);
			setState(811);
			select_stmt();
			setState(812);
			match(CLOSE_PAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Delete_stmtContext extends ParserRuleContext {
		public TerminalNode DELETE_() { return getToken(SQLiteParser.DELETE_, 0); }
		public TerminalNode FROM_() { return getToken(SQLiteParser.FROM_, 0); }
		public Qualified_table_nameContext qualified_table_name() {
			return getRuleContext(Qualified_table_nameContext.class,0);
		}
		public With_clauseContext with_clause() {
			return getRuleContext(With_clauseContext.class,0);
		}
		public TerminalNode WHERE_() { return getToken(SQLiteParser.WHERE_, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Delete_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delete_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterDelete_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitDelete_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitDelete_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Delete_stmtContext delete_stmt() throws RecognitionException {
		Delete_stmtContext _localctx = new Delete_stmtContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_delete_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(815);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WITH_) {
				{
				setState(814);
				with_clause();
				}
			}

			setState(817);
			match(DELETE_);
			setState(818);
			match(FROM_);
			setState(819);
			qualified_table_name();
			setState(822);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE_) {
				{
				setState(820);
				match(WHERE_);
				setState(821);
				expr(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Delete_stmt_limitedContext extends ParserRuleContext {
		public TerminalNode DELETE_() { return getToken(SQLiteParser.DELETE_, 0); }
		public TerminalNode FROM_() { return getToken(SQLiteParser.FROM_, 0); }
		public Qualified_table_nameContext qualified_table_name() {
			return getRuleContext(Qualified_table_nameContext.class,0);
		}
		public With_clauseContext with_clause() {
			return getRuleContext(With_clauseContext.class,0);
		}
		public TerminalNode WHERE_() { return getToken(SQLiteParser.WHERE_, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Limit_stmtContext limit_stmt() {
			return getRuleContext(Limit_stmtContext.class,0);
		}
		public Order_by_stmtContext order_by_stmt() {
			return getRuleContext(Order_by_stmtContext.class,0);
		}
		public Delete_stmt_limitedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delete_stmt_limited; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterDelete_stmt_limited(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitDelete_stmt_limited(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitDelete_stmt_limited(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Delete_stmt_limitedContext delete_stmt_limited() throws RecognitionException {
		Delete_stmt_limitedContext _localctx = new Delete_stmt_limitedContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_delete_stmt_limited);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(825);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WITH_) {
				{
				setState(824);
				with_clause();
				}
			}

			setState(827);
			match(DELETE_);
			setState(828);
			match(FROM_);
			setState(829);
			qualified_table_name();
			setState(832);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE_) {
				{
				setState(830);
				match(WHERE_);
				setState(831);
				expr(0);
				}
			}

			setState(838);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LIMIT_ || _la==ORDER_) {
				{
				setState(835);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ORDER_) {
					{
					setState(834);
					order_by_stmt();
					}
				}

				setState(837);
				limit_stmt();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Detach_stmtContext extends ParserRuleContext {
		public TerminalNode DETACH_() { return getToken(SQLiteParser.DETACH_, 0); }
		public Schema_nameContext schema_name() {
			return getRuleContext(Schema_nameContext.class,0);
		}
		public TerminalNode DATABASE_() { return getToken(SQLiteParser.DATABASE_, 0); }
		public Detach_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_detach_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterDetach_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitDetach_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitDetach_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Detach_stmtContext detach_stmt() throws RecognitionException {
		Detach_stmtContext _localctx = new Detach_stmtContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_detach_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(840);
			match(DETACH_);
			setState(842);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,101,_ctx) ) {
			case 1:
				{
				setState(841);
				match(DATABASE_);
				}
				break;
			}
			setState(844);
			schema_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Drop_stmtContext extends ParserRuleContext {
		public Token object;
		public TerminalNode DROP_() { return getToken(SQLiteParser.DROP_, 0); }
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public TerminalNode INDEX_() { return getToken(SQLiteParser.INDEX_, 0); }
		public TerminalNode TABLE_() { return getToken(SQLiteParser.TABLE_, 0); }
		public TerminalNode TRIGGER_() { return getToken(SQLiteParser.TRIGGER_, 0); }
		public TerminalNode VIEW_() { return getToken(SQLiteParser.VIEW_, 0); }
		public TerminalNode IF_() { return getToken(SQLiteParser.IF_, 0); }
		public TerminalNode EXISTS_() { return getToken(SQLiteParser.EXISTS_, 0); }
		public Schema_nameContext schema_name() {
			return getRuleContext(Schema_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public Drop_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterDrop_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitDrop_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitDrop_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Drop_stmtContext drop_stmt() throws RecognitionException {
		Drop_stmtContext _localctx = new Drop_stmtContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_drop_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(846);
			match(DROP_);
			setState(847);
			((Drop_stmtContext)_localctx).object = _input.LT(1);
			_la = _input.LA(1);
			if ( !(((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (INDEX_ - 84)) | (1L << (TABLE_ - 84)) | (1L << (TRIGGER_ - 84)) | (1L << (VIEW_ - 84)))) != 0)) ) {
				((Drop_stmtContext)_localctx).object = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(850);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,102,_ctx) ) {
			case 1:
				{
				setState(848);
				match(IF_);
				setState(849);
				match(EXISTS_);
				}
				break;
			}
			setState(855);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,103,_ctx) ) {
			case 1:
				{
				setState(852);
				schema_name();
				setState(853);
				match(DOT);
				}
				break;
			}
			setState(857);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public Literal_valueContext literal_value() {
			return getRuleContext(Literal_valueContext.class,0);
		}
		public TerminalNode BIND_PARAMETER() { return getToken(SQLiteParser.BIND_PARAMETER, 0); }
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public List<TerminalNode> DOT() { return getTokens(SQLiteParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(SQLiteParser.DOT, i);
		}
		public Schema_nameContext schema_name() {
			return getRuleContext(Schema_nameContext.class,0);
		}
		public Unary_operatorContext unary_operator() {
			return getRuleContext(Unary_operatorContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Function_nameContext function_name() {
			return getRuleContext(Function_nameContext.class,0);
		}
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public TerminalNode STAR() { return getToken(SQLiteParser.STAR, 0); }
		public Filter_clauseContext filter_clause() {
			return getRuleContext(Filter_clauseContext.class,0);
		}
		public Over_clauseContext over_clause() {
			return getRuleContext(Over_clauseContext.class,0);
		}
		public TerminalNode DISTINCT_() { return getToken(SQLiteParser.DISTINCT_, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public TerminalNode CAST_() { return getToken(SQLiteParser.CAST_, 0); }
		public TerminalNode AS_() { return getToken(SQLiteParser.AS_, 0); }
		public Type_nameContext type_name() {
			return getRuleContext(Type_nameContext.class,0);
		}
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public TerminalNode EXISTS_() { return getToken(SQLiteParser.EXISTS_, 0); }
		public TerminalNode NOT_() { return getToken(SQLiteParser.NOT_, 0); }
		public TerminalNode CASE_() { return getToken(SQLiteParser.CASE_, 0); }
		public TerminalNode END_() { return getToken(SQLiteParser.END_, 0); }
		public List<TerminalNode> WHEN_() { return getTokens(SQLiteParser.WHEN_); }
		public TerminalNode WHEN_(int i) {
			return getToken(SQLiteParser.WHEN_, i);
		}
		public List<TerminalNode> THEN_() { return getTokens(SQLiteParser.THEN_); }
		public TerminalNode THEN_(int i) {
			return getToken(SQLiteParser.THEN_, i);
		}
		public TerminalNode ELSE_() { return getToken(SQLiteParser.ELSE_, 0); }
		public Raise_functionContext raise_function() {
			return getRuleContext(Raise_functionContext.class,0);
		}
		public TerminalNode PIPE2() { return getToken(SQLiteParser.PIPE2, 0); }
		public TerminalNode DIV() { return getToken(SQLiteParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(SQLiteParser.MOD, 0); }
		public TerminalNode PLUS() { return getToken(SQLiteParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(SQLiteParser.MINUS, 0); }
		public TerminalNode LT2() { return getToken(SQLiteParser.LT2, 0); }
		public TerminalNode GT2() { return getToken(SQLiteParser.GT2, 0); }
		public TerminalNode AMP() { return getToken(SQLiteParser.AMP, 0); }
		public TerminalNode PIPE() { return getToken(SQLiteParser.PIPE, 0); }
		public TerminalNode LT() { return getToken(SQLiteParser.LT, 0); }
		public TerminalNode LT_EQ() { return getToken(SQLiteParser.LT_EQ, 0); }
		public TerminalNode GT() { return getToken(SQLiteParser.GT, 0); }
		public TerminalNode GT_EQ() { return getToken(SQLiteParser.GT_EQ, 0); }
		public TerminalNode ASSIGN() { return getToken(SQLiteParser.ASSIGN, 0); }
		public TerminalNode EQ() { return getToken(SQLiteParser.EQ, 0); }
		public TerminalNode NOT_EQ1() { return getToken(SQLiteParser.NOT_EQ1, 0); }
		public TerminalNode NOT_EQ2() { return getToken(SQLiteParser.NOT_EQ2, 0); }
		public TerminalNode IS_() { return getToken(SQLiteParser.IS_, 0); }
		public TerminalNode IN_() { return getToken(SQLiteParser.IN_, 0); }
		public TerminalNode LIKE_() { return getToken(SQLiteParser.LIKE_, 0); }
		public TerminalNode GLOB_() { return getToken(SQLiteParser.GLOB_, 0); }
		public TerminalNode MATCH_() { return getToken(SQLiteParser.MATCH_, 0); }
		public TerminalNode REGEXP_() { return getToken(SQLiteParser.REGEXP_, 0); }
		public TerminalNode AND_() { return getToken(SQLiteParser.AND_, 0); }
		public TerminalNode OR_() { return getToken(SQLiteParser.OR_, 0); }
		public TerminalNode BETWEEN_() { return getToken(SQLiteParser.BETWEEN_, 0); }
		public TerminalNode COLLATE_() { return getToken(SQLiteParser.COLLATE_, 0); }
		public Collation_nameContext collation_name() {
			return getRuleContext(Collation_nameContext.class,0);
		}
		public TerminalNode ESCAPE_() { return getToken(SQLiteParser.ESCAPE_, 0); }
		public TerminalNode ISNULL_() { return getToken(SQLiteParser.ISNULL_, 0); }
		public TerminalNode NOTNULL_() { return getToken(SQLiteParser.NOTNULL_, 0); }
		public TerminalNode NULL_() { return getToken(SQLiteParser.NULL_, 0); }
		public Table_function_nameContext table_function_name() {
			return getRuleContext(Table_function_nameContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 64;
		enterRecursionRule(_localctx, 64, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(947);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,117,_ctx) ) {
			case 1:
				{
				setState(860);
				literal_value();
				}
				break;
			case 2:
				{
				setState(861);
				match(BIND_PARAMETER);
				}
				break;
			case 3:
				{
				setState(870);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,105,_ctx) ) {
				case 1:
					{
					setState(865);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,104,_ctx) ) {
					case 1:
						{
						setState(862);
						schema_name();
						setState(863);
						match(DOT);
						}
						break;
					}
					setState(867);
					table_name();
					setState(868);
					match(DOT);
					}
					break;
				}
				setState(872);
				column_name();
				}
				break;
			case 4:
				{
				setState(873);
				unary_operator();
				setState(874);
				expr(21);
				}
				break;
			case 5:
				{
				setState(876);
				function_name();
				setState(877);
				match(OPEN_PAR);
				setState(890);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case OPEN_PAR:
				case PLUS:
				case MINUS:
				case TILDE:
				case ABORT_:
				case ACTION_:
				case ADD_:
				case AFTER_:
				case ALL_:
				case ALTER_:
				case ANALYZE_:
				case AND_:
				case AS_:
				case ASC_:
				case ATTACH_:
				case AUTOINCREMENT_:
				case BEFORE_:
				case BEGIN_:
				case BETWEEN_:
				case BY_:
				case CASCADE_:
				case CASE_:
				case CAST_:
				case CHECK_:
				case COLLATE_:
				case COLUMN_:
				case COMMIT_:
				case CONFLICT_:
				case CONSTRAINT_:
				case CREATE_:
				case CROSS_:
				case CURRENT_DATE_:
				case CURRENT_TIME_:
				case CURRENT_TIMESTAMP_:
				case DATABASE_:
				case DEFAULT_:
				case DEFERRABLE_:
				case DEFERRED_:
				case DELETE_:
				case DESC_:
				case DETACH_:
				case DISTINCT_:
				case DROP_:
				case EACH_:
				case ELSE_:
				case END_:
				case ESCAPE_:
				case EXCEPT_:
				case EXCLUSIVE_:
				case EXISTS_:
				case EXPLAIN_:
				case FAIL_:
				case FOR_:
				case FOREIGN_:
				case FROM_:
				case FULL_:
				case GLOB_:
				case GROUP_:
				case HAVING_:
				case IF_:
				case IGNORE_:
				case IMMEDIATE_:
				case IN_:
				case INDEX_:
				case INDEXED_:
				case INITIALLY_:
				case INNER_:
				case INSERT_:
				case INSTEAD_:
				case INTERSECT_:
				case INTO_:
				case IS_:
				case ISNULL_:
				case JOIN_:
				case KEY_:
				case LEFT_:
				case LIKE_:
				case LIMIT_:
				case MATCH_:
				case NATURAL_:
				case NO_:
				case NOT_:
				case NOTNULL_:
				case NULL_:
				case OF_:
				case OFFSET_:
				case ON_:
				case OR_:
				case ORDER_:
				case OUTER_:
				case PLAN_:
				case PRAGMA_:
				case PRIMARY_:
				case QUERY_:
				case RAISE_:
				case RECURSIVE_:
				case REFERENCES_:
				case REGEXP_:
				case REINDEX_:
				case RELEASE_:
				case RENAME_:
				case REPLACE_:
				case RESTRICT_:
				case RIGHT_:
				case ROLLBACK_:
				case ROW_:
				case ROWS_:
				case SAVEPOINT_:
				case SELECT_:
				case SET_:
				case TABLE_:
				case TEMP_:
				case TEMPORARY_:
				case THEN_:
				case TO_:
				case TRANSACTION_:
				case TRIGGER_:
				case UNION_:
				case UNIQUE_:
				case UPDATE_:
				case USING_:
				case VACUUM_:
				case VALUES_:
				case VIEW_:
				case VIRTUAL_:
				case WHEN_:
				case WHERE_:
				case WITH_:
				case WITHOUT_:
				case FIRST_VALUE_:
				case OVER_:
				case PARTITION_:
				case RANGE_:
				case PRECEDING_:
				case UNBOUNDED_:
				case CURRENT_:
				case FOLLOWING_:
				case CUME_DIST_:
				case DENSE_RANK_:
				case LAG_:
				case LAST_VALUE_:
				case LEAD_:
				case NTH_VALUE_:
				case NTILE_:
				case PERCENT_RANK_:
				case RANK_:
				case ROW_NUMBER_:
				case GENERATED_:
				case ALWAYS_:
				case STORED_:
				case TRUE_:
				case FALSE_:
				case WINDOW_:
				case NULLS_:
				case FIRST_:
				case LAST_:
				case FILTER_:
				case GROUPS_:
				case EXCLUDE_:
				case IDENTIFIER:
				case NUMERIC_LITERAL:
				case BIND_PARAMETER:
				case STRING_LITERAL:
				case BLOB_LITERAL:
					{
					{
					setState(879);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,106,_ctx) ) {
					case 1:
						{
						setState(878);
						match(DISTINCT_);
						}
						break;
					}
					setState(881);
					expr(0);
					setState(886);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(882);
						match(COMMA);
						setState(883);
						expr(0);
						}
						}
						setState(888);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					break;
				case STAR:
					{
					setState(889);
					match(STAR);
					}
					break;
				case CLOSE_PAR:
					break;
				default:
					break;
				}
				setState(892);
				match(CLOSE_PAR);
				setState(894);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,109,_ctx) ) {
				case 1:
					{
					setState(893);
					filter_clause();
					}
					break;
				}
				setState(897);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,110,_ctx) ) {
				case 1:
					{
					setState(896);
					over_clause();
					}
					break;
				}
				}
				break;
			case 6:
				{
				setState(899);
				match(OPEN_PAR);
				setState(900);
				expr(0);
				setState(905);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(901);
					match(COMMA);
					setState(902);
					expr(0);
					}
					}
					setState(907);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(908);
				match(CLOSE_PAR);
				}
				break;
			case 7:
				{
				setState(910);
				match(CAST_);
				setState(911);
				match(OPEN_PAR);
				setState(912);
				expr(0);
				setState(913);
				match(AS_);
				setState(914);
				type_name();
				setState(915);
				match(CLOSE_PAR);
				}
				break;
			case 8:
				{
				setState(921);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EXISTS_ || _la==NOT_) {
					{
					setState(918);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==NOT_) {
						{
						setState(917);
						match(NOT_);
						}
					}

					setState(920);
					match(EXISTS_);
					}
				}

				setState(923);
				match(OPEN_PAR);
				setState(924);
				select_stmt();
				setState(925);
				match(CLOSE_PAR);
				}
				break;
			case 9:
				{
				setState(927);
				match(CASE_);
				setState(929);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
				case 1:
					{
					setState(928);
					expr(0);
					}
					break;
				}
				setState(936); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(931);
					match(WHEN_);
					setState(932);
					expr(0);
					setState(933);
					match(THEN_);
					setState(934);
					expr(0);
					}
					}
					setState(938); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WHEN_ );
				setState(942);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE_) {
					{
					setState(940);
					match(ELSE_);
					setState(941);
					expr(0);
					}
				}

				setState(944);
				match(END_);
				}
				break;
			case 10:
				{
				setState(946);
				raise_function();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1068);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,133,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1066);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,132,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(949);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(950);
						match(PIPE2);
						setState(951);
						expr(21);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(952);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(953);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STAR) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(954);
						expr(20);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(955);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(956);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(957);
						expr(19);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(958);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(959);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LT2) | (1L << GT2) | (1L << AMP) | (1L << PIPE))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(960);
						expr(18);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(961);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(962);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LT) | (1L << LT_EQ) | (1L << GT) | (1L << GT_EQ))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(963);
						expr(17);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(964);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(977);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,118,_ctx) ) {
						case 1:
							{
							setState(965);
							match(ASSIGN);
							}
							break;
						case 2:
							{
							setState(966);
							match(EQ);
							}
							break;
						case 3:
							{
							setState(967);
							match(NOT_EQ1);
							}
							break;
						case 4:
							{
							setState(968);
							match(NOT_EQ2);
							}
							break;
						case 5:
							{
							setState(969);
							match(IS_);
							}
							break;
						case 6:
							{
							setState(970);
							match(IS_);
							setState(971);
							match(NOT_);
							}
							break;
						case 7:
							{
							setState(972);
							match(IN_);
							}
							break;
						case 8:
							{
							setState(973);
							match(LIKE_);
							}
							break;
						case 9:
							{
							setState(974);
							match(GLOB_);
							}
							break;
						case 10:
							{
							setState(975);
							match(MATCH_);
							}
							break;
						case 11:
							{
							setState(976);
							match(REGEXP_);
							}
							break;
						}
						setState(979);
						expr(16);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(980);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(981);
						match(AND_);
						setState(982);
						expr(15);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(983);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(984);
						match(OR_);
						setState(985);
						expr(14);
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(986);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(987);
						match(IS_);
						setState(989);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,119,_ctx) ) {
						case 1:
							{
							setState(988);
							match(NOT_);
							}
							break;
						}
						setState(991);
						expr(7);
						}
						break;
					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(992);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(994);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NOT_) {
							{
							setState(993);
							match(NOT_);
							}
						}

						setState(996);
						match(BETWEEN_);
						setState(997);
						expr(0);
						setState(998);
						match(AND_);
						setState(999);
						expr(6);
						}
						break;
					case 11:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1001);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(1002);
						match(COLLATE_);
						setState(1003);
						collation_name();
						}
						break;
					case 12:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1004);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(1006);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NOT_) {
							{
							setState(1005);
							match(NOT_);
							}
						}

						setState(1008);
						_la = _input.LA(1);
						if ( !(((((_la - 77)) & ~0x3f) == 0 && ((1L << (_la - 77)) & ((1L << (GLOB_ - 77)) | (1L << (LIKE_ - 77)) | (1L << (MATCH_ - 77)) | (1L << (REGEXP_ - 77)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1009);
						expr(0);
						setState(1012);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,122,_ctx) ) {
						case 1:
							{
							setState(1010);
							match(ESCAPE_);
							setState(1011);
							expr(0);
							}
							break;
						}
						}
						break;
					case 13:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1014);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(1019);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case ISNULL_:
							{
							setState(1015);
							match(ISNULL_);
							}
							break;
						case NOTNULL_:
							{
							setState(1016);
							match(NOTNULL_);
							}
							break;
						case NOT_:
							{
							setState(1017);
							match(NOT_);
							setState(1018);
							match(NULL_);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						break;
					case 14:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1021);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(1023);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NOT_) {
							{
							setState(1022);
							match(NOT_);
							}
						}

						setState(1025);
						match(IN_);
						setState(1064);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,131,_ctx) ) {
						case 1:
							{
							setState(1026);
							match(OPEN_PAR);
							setState(1036);
							_errHandler.sync(this);
							switch ( getInterpreter().adaptivePredict(_input,126,_ctx) ) {
							case 1:
								{
								setState(1027);
								select_stmt();
								}
								break;
							case 2:
								{
								setState(1028);
								expr(0);
								setState(1033);
								_errHandler.sync(this);
								_la = _input.LA(1);
								while (_la==COMMA) {
									{
									{
									setState(1029);
									match(COMMA);
									setState(1030);
									expr(0);
									}
									}
									setState(1035);
									_errHandler.sync(this);
									_la = _input.LA(1);
								}
								}
								break;
							}
							setState(1038);
							match(CLOSE_PAR);
							}
							break;
						case 2:
							{
							setState(1042);
							_errHandler.sync(this);
							switch ( getInterpreter().adaptivePredict(_input,127,_ctx) ) {
							case 1:
								{
								setState(1039);
								schema_name();
								setState(1040);
								match(DOT);
								}
								break;
							}
							setState(1044);
							table_name();
							}
							break;
						case 3:
							{
							setState(1048);
							_errHandler.sync(this);
							switch ( getInterpreter().adaptivePredict(_input,128,_ctx) ) {
							case 1:
								{
								setState(1045);
								schema_name();
								setState(1046);
								match(DOT);
								}
								break;
							}
							setState(1050);
							table_function_name();
							setState(1051);
							match(OPEN_PAR);
							setState(1060);
							_errHandler.sync(this);
							_la = _input.LA(1);
							if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN_PAR) | (1L << PLUS) | (1L << MINUS) | (1L << TILDE) | (1L << ABORT_) | (1L << ACTION_) | (1L << ADD_) | (1L << AFTER_) | (1L << ALL_) | (1L << ALTER_) | (1L << ANALYZE_) | (1L << AND_) | (1L << AS_) | (1L << ASC_) | (1L << ATTACH_) | (1L << AUTOINCREMENT_) | (1L << BEFORE_) | (1L << BEGIN_) | (1L << BETWEEN_) | (1L << BY_) | (1L << CASCADE_) | (1L << CASE_) | (1L << CAST_) | (1L << CHECK_) | (1L << COLLATE_) | (1L << COLUMN_) | (1L << COMMIT_) | (1L << CONFLICT_) | (1L << CONSTRAINT_) | (1L << CREATE_) | (1L << CROSS_) | (1L << CURRENT_DATE_) | (1L << CURRENT_TIME_) | (1L << CURRENT_TIMESTAMP_) | (1L << DATABASE_) | (1L << DEFAULT_) | (1L << DEFERRABLE_) | (1L << DEFERRED_) | (1L << DELETE_) | (1L << DESC_) | (1L << DETACH_) | (1L << DISTINCT_) | (1L << DROP_))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (EACH_ - 64)) | (1L << (ELSE_ - 64)) | (1L << (END_ - 64)) | (1L << (ESCAPE_ - 64)) | (1L << (EXCEPT_ - 64)) | (1L << (EXCLUSIVE_ - 64)) | (1L << (EXISTS_ - 64)) | (1L << (EXPLAIN_ - 64)) | (1L << (FAIL_ - 64)) | (1L << (FOR_ - 64)) | (1L << (FOREIGN_ - 64)) | (1L << (FROM_ - 64)) | (1L << (FULL_ - 64)) | (1L << (GLOB_ - 64)) | (1L << (GROUP_ - 64)) | (1L << (HAVING_ - 64)) | (1L << (IF_ - 64)) | (1L << (IGNORE_ - 64)) | (1L << (IMMEDIATE_ - 64)) | (1L << (IN_ - 64)) | (1L << (INDEX_ - 64)) | (1L << (INDEXED_ - 64)) | (1L << (INITIALLY_ - 64)) | (1L << (INNER_ - 64)) | (1L << (INSERT_ - 64)) | (1L << (INSTEAD_ - 64)) | (1L << (INTERSECT_ - 64)) | (1L << (INTO_ - 64)) | (1L << (IS_ - 64)) | (1L << (ISNULL_ - 64)) | (1L << (JOIN_ - 64)) | (1L << (KEY_ - 64)) | (1L << (LEFT_ - 64)) | (1L << (LIKE_ - 64)) | (1L << (LIMIT_ - 64)) | (1L << (MATCH_ - 64)) | (1L << (NATURAL_ - 64)) | (1L << (NO_ - 64)) | (1L << (NOT_ - 64)) | (1L << (NOTNULL_ - 64)) | (1L << (NULL_ - 64)) | (1L << (OF_ - 64)) | (1L << (OFFSET_ - 64)) | (1L << (ON_ - 64)) | (1L << (OR_ - 64)) | (1L << (ORDER_ - 64)) | (1L << (OUTER_ - 64)) | (1L << (PLAN_ - 64)) | (1L << (PRAGMA_ - 64)) | (1L << (PRIMARY_ - 64)) | (1L << (QUERY_ - 64)) | (1L << (RAISE_ - 64)) | (1L << (RECURSIVE_ - 64)) | (1L << (REFERENCES_ - 64)) | (1L << (REGEXP_ - 64)) | (1L << (REINDEX_ - 64)) | (1L << (RELEASE_ - 64)) | (1L << (RENAME_ - 64)) | (1L << (REPLACE_ - 64)) | (1L << (RESTRICT_ - 64)) | (1L << (RIGHT_ - 64)) | (1L << (ROLLBACK_ - 64)) | (1L << (ROW_ - 64)) | (1L << (ROWS_ - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (SAVEPOINT_ - 128)) | (1L << (SELECT_ - 128)) | (1L << (SET_ - 128)) | (1L << (TABLE_ - 128)) | (1L << (TEMP_ - 128)) | (1L << (TEMPORARY_ - 128)) | (1L << (THEN_ - 128)) | (1L << (TO_ - 128)) | (1L << (TRANSACTION_ - 128)) | (1L << (TRIGGER_ - 128)) | (1L << (UNION_ - 128)) | (1L << (UNIQUE_ - 128)) | (1L << (UPDATE_ - 128)) | (1L << (USING_ - 128)) | (1L << (VACUUM_ - 128)) | (1L << (VALUES_ - 128)) | (1L << (VIEW_ - 128)) | (1L << (VIRTUAL_ - 128)) | (1L << (WHEN_ - 128)) | (1L << (WHERE_ - 128)) | (1L << (WITH_ - 128)) | (1L << (WITHOUT_ - 128)) | (1L << (FIRST_VALUE_ - 128)) | (1L << (OVER_ - 128)) | (1L << (PARTITION_ - 128)) | (1L << (RANGE_ - 128)) | (1L << (PRECEDING_ - 128)) | (1L << (UNBOUNDED_ - 128)) | (1L << (CURRENT_ - 128)) | (1L << (FOLLOWING_ - 128)) | (1L << (CUME_DIST_ - 128)) | (1L << (DENSE_RANK_ - 128)) | (1L << (LAG_ - 128)) | (1L << (LAST_VALUE_ - 128)) | (1L << (LEAD_ - 128)) | (1L << (NTH_VALUE_ - 128)) | (1L << (NTILE_ - 128)) | (1L << (PERCENT_RANK_ - 128)) | (1L << (RANK_ - 128)) | (1L << (ROW_NUMBER_ - 128)) | (1L << (GENERATED_ - 128)) | (1L << (ALWAYS_ - 128)) | (1L << (STORED_ - 128)) | (1L << (TRUE_ - 128)) | (1L << (FALSE_ - 128)) | (1L << (WINDOW_ - 128)) | (1L << (NULLS_ - 128)) | (1L << (FIRST_ - 128)) | (1L << (LAST_ - 128)) | (1L << (FILTER_ - 128)) | (1L << (GROUPS_ - 128)) | (1L << (EXCLUDE_ - 128)) | (1L << (IDENTIFIER - 128)) | (1L << (NUMERIC_LITERAL - 128)) | (1L << (BIND_PARAMETER - 128)) | (1L << (STRING_LITERAL - 128)) | (1L << (BLOB_LITERAL - 128)))) != 0)) {
								{
								setState(1052);
								expr(0);
								setState(1057);
								_errHandler.sync(this);
								_la = _input.LA(1);
								while (_la==COMMA) {
									{
									{
									setState(1053);
									match(COMMA);
									setState(1054);
									expr(0);
									}
									}
									setState(1059);
									_errHandler.sync(this);
									_la = _input.LA(1);
								}
								}
							}

							setState(1062);
							match(CLOSE_PAR);
							}
							break;
						}
						}
						break;
					}
					} 
				}
				setState(1070);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,133,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Raise_functionContext extends ParserRuleContext {
		public TerminalNode RAISE_() { return getToken(SQLiteParser.RAISE_, 0); }
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public TerminalNode IGNORE_() { return getToken(SQLiteParser.IGNORE_, 0); }
		public TerminalNode COMMA() { return getToken(SQLiteParser.COMMA, 0); }
		public Error_messageContext error_message() {
			return getRuleContext(Error_messageContext.class,0);
		}
		public TerminalNode ROLLBACK_() { return getToken(SQLiteParser.ROLLBACK_, 0); }
		public TerminalNode ABORT_() { return getToken(SQLiteParser.ABORT_, 0); }
		public TerminalNode FAIL_() { return getToken(SQLiteParser.FAIL_, 0); }
		public Raise_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_raise_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterRaise_function(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitRaise_function(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitRaise_function(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Raise_functionContext raise_function() throws RecognitionException {
		Raise_functionContext _localctx = new Raise_functionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_raise_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1071);
			match(RAISE_);
			setState(1072);
			match(OPEN_PAR);
			setState(1077);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IGNORE_:
				{
				setState(1073);
				match(IGNORE_);
				}
				break;
			case ABORT_:
			case FAIL_:
			case ROLLBACK_:
				{
				setState(1074);
				_la = _input.LA(1);
				if ( !(_la==ABORT_ || _la==FAIL_ || _la==ROLLBACK_) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1075);
				match(COMMA);
				setState(1076);
				error_message();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1079);
			match(CLOSE_PAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Literal_valueContext extends ParserRuleContext {
		public TerminalNode NUMERIC_LITERAL() { return getToken(SQLiteParser.NUMERIC_LITERAL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(SQLiteParser.STRING_LITERAL, 0); }
		public TerminalNode BLOB_LITERAL() { return getToken(SQLiteParser.BLOB_LITERAL, 0); }
		public TerminalNode NULL_() { return getToken(SQLiteParser.NULL_, 0); }
		public TerminalNode TRUE_() { return getToken(SQLiteParser.TRUE_, 0); }
		public TerminalNode FALSE_() { return getToken(SQLiteParser.FALSE_, 0); }
		public TerminalNode CURRENT_TIME_() { return getToken(SQLiteParser.CURRENT_TIME_, 0); }
		public TerminalNode CURRENT_DATE_() { return getToken(SQLiteParser.CURRENT_DATE_, 0); }
		public TerminalNode CURRENT_TIMESTAMP_() { return getToken(SQLiteParser.CURRENT_TIMESTAMP_, 0); }
		public Literal_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterLiteral_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitLiteral_value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitLiteral_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Literal_valueContext literal_value() throws RecognitionException {
		Literal_valueContext _localctx = new Literal_valueContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_literal_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1081);
			_la = _input.LA(1);
			if ( !(((((_la - 52)) & ~0x3f) == 0 && ((1L << (_la - 52)) & ((1L << (CURRENT_DATE_ - 52)) | (1L << (CURRENT_TIME_ - 52)) | (1L << (CURRENT_TIMESTAMP_ - 52)) | (1L << (NULL_ - 52)))) != 0) || ((((_la - 171)) & ~0x3f) == 0 && ((1L << (_la - 171)) & ((1L << (TRUE_ - 171)) | (1L << (FALSE_ - 171)) | (1L << (NUMERIC_LITERAL - 171)) | (1L << (STRING_LITERAL - 171)) | (1L << (BLOB_LITERAL - 171)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Insert_stmtContext extends ParserRuleContext {
		public TerminalNode INTO_() { return getToken(SQLiteParser.INTO_, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode INSERT_() { return getToken(SQLiteParser.INSERT_, 0); }
		public TerminalNode REPLACE_() { return getToken(SQLiteParser.REPLACE_, 0); }
		public TerminalNode OR_() { return getToken(SQLiteParser.OR_, 0); }
		public With_clauseContext with_clause() {
			return getRuleContext(With_clauseContext.class,0);
		}
		public TerminalNode ROLLBACK_() { return getToken(SQLiteParser.ROLLBACK_, 0); }
		public TerminalNode ABORT_() { return getToken(SQLiteParser.ABORT_, 0); }
		public TerminalNode FAIL_() { return getToken(SQLiteParser.FAIL_, 0); }
		public TerminalNode IGNORE_() { return getToken(SQLiteParser.IGNORE_, 0); }
		public Schema_nameContext schema_name() {
			return getRuleContext(Schema_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public TerminalNode AS_() { return getToken(SQLiteParser.AS_, 0); }
		public Table_aliasContext table_alias() {
			return getRuleContext(Table_aliasContext.class,0);
		}
		public List<TerminalNode> OPEN_PAR() { return getTokens(SQLiteParser.OPEN_PAR); }
		public TerminalNode OPEN_PAR(int i) {
			return getToken(SQLiteParser.OPEN_PAR, i);
		}
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public List<TerminalNode> CLOSE_PAR() { return getTokens(SQLiteParser.CLOSE_PAR); }
		public TerminalNode CLOSE_PAR(int i) {
			return getToken(SQLiteParser.CLOSE_PAR, i);
		}
		public TerminalNode VALUES_() { return getToken(SQLiteParser.VALUES_, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public Upsert_clauseContext upsert_clause() {
			return getRuleContext(Upsert_clauseContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public TerminalNode DEFAULT_() { return getToken(SQLiteParser.DEFAULT_, 0); }
		public Insert_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insert_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterInsert_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitInsert_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitInsert_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Insert_stmtContext insert_stmt() throws RecognitionException {
		Insert_stmtContext _localctx = new Insert_stmtContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_insert_stmt);
		int _la;
		try {
			setState(1153);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INSERT_:
			case REPLACE_:
			case WITH_:
				enterOuterAlt(_localctx, 1);
				{
				setState(1084);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WITH_) {
					{
					setState(1083);
					with_clause();
					}
				}

				setState(1091);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,136,_ctx) ) {
				case 1:
					{
					setState(1086);
					match(INSERT_);
					}
					break;
				case 2:
					{
					setState(1087);
					match(REPLACE_);
					}
					break;
				case 3:
					{
					setState(1088);
					match(INSERT_);
					setState(1089);
					match(OR_);
					setState(1090);
					_la = _input.LA(1);
					if ( !(_la==ABORT_ || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (FAIL_ - 72)) | (1L << (IGNORE_ - 72)) | (1L << (REPLACE_ - 72)) | (1L << (ROLLBACK_ - 72)))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				}
				setState(1093);
				match(INTO_);
				setState(1097);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,137,_ctx) ) {
				case 1:
					{
					setState(1094);
					schema_name();
					setState(1095);
					match(DOT);
					}
					break;
				}
				setState(1099);
				table_name();
				setState(1102);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AS_) {
					{
					setState(1100);
					match(AS_);
					setState(1101);
					table_alias();
					}
				}

				setState(1115);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPEN_PAR) {
					{
					setState(1104);
					match(OPEN_PAR);
					setState(1105);
					column_name();
					setState(1110);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1106);
						match(COMMA);
						setState(1107);
						column_name();
						}
						}
						setState(1112);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1113);
					match(CLOSE_PAR);
					}
				}

				{
				setState(1146);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,144,_ctx) ) {
				case 1:
					{
					setState(1117);
					match(VALUES_);
					setState(1118);
					match(OPEN_PAR);
					setState(1119);
					expr(0);
					setState(1124);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1120);
						match(COMMA);
						setState(1121);
						expr(0);
						}
						}
						setState(1126);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1127);
					match(CLOSE_PAR);
					setState(1142);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1128);
						match(COMMA);
						setState(1129);
						match(OPEN_PAR);
						setState(1130);
						expr(0);
						setState(1135);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(1131);
							match(COMMA);
							setState(1132);
							expr(0);
							}
							}
							setState(1137);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(1138);
						match(CLOSE_PAR);
						}
						}
						setState(1144);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case 2:
					{
					setState(1145);
					select_stmt();
					}
					break;
				}
				setState(1149);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ON_) {
					{
					setState(1148);
					upsert_clause();
					}
				}

				}
				}
				break;
			case DEFAULT_:
				enterOuterAlt(_localctx, 2);
				{
				setState(1151);
				match(DEFAULT_);
				setState(1152);
				match(VALUES_);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Upsert_clauseContext extends ParserRuleContext {
		public TerminalNode ON_() { return getToken(SQLiteParser.ON_, 0); }
		public TerminalNode CONFLICT_() { return getToken(SQLiteParser.CONFLICT_, 0); }
		public TerminalNode DO_() { return getToken(SQLiteParser.DO_, 0); }
		public TerminalNode NOTHING_() { return getToken(SQLiteParser.NOTHING_, 0); }
		public TerminalNode UPDATE_() { return getToken(SQLiteParser.UPDATE_, 0); }
		public TerminalNode SET_() { return getToken(SQLiteParser.SET_, 0); }
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public List<Indexed_columnContext> indexed_column() {
			return getRuleContexts(Indexed_columnContext.class);
		}
		public Indexed_columnContext indexed_column(int i) {
			return getRuleContext(Indexed_columnContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public List<TerminalNode> EQ() { return getTokens(SQLiteParser.EQ); }
		public TerminalNode EQ(int i) {
			return getToken(SQLiteParser.EQ, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public List<TerminalNode> WHERE_() { return getTokens(SQLiteParser.WHERE_); }
		public TerminalNode WHERE_(int i) {
			return getToken(SQLiteParser.WHERE_, i);
		}
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public List<Column_name_listContext> column_name_list() {
			return getRuleContexts(Column_name_listContext.class);
		}
		public Column_name_listContext column_name_list(int i) {
			return getRuleContext(Column_name_listContext.class,i);
		}
		public Upsert_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_upsert_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterUpsert_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitUpsert_clause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitUpsert_clause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Upsert_clauseContext upsert_clause() throws RecognitionException {
		Upsert_clauseContext _localctx = new Upsert_clauseContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_upsert_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1155);
			match(ON_);
			setState(1156);
			match(CONFLICT_);
			setState(1171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_PAR) {
				{
				setState(1157);
				match(OPEN_PAR);
				setState(1158);
				indexed_column();
				setState(1163);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1159);
					match(COMMA);
					setState(1160);
					indexed_column();
					}
					}
					setState(1165);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1166);
				match(CLOSE_PAR);
				setState(1169);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WHERE_) {
					{
					setState(1167);
					match(WHERE_);
					setState(1168);
					expr(0);
					}
				}

				}
			}

			setState(1173);
			match(DO_);
			setState(1200);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOTHING_:
				{
				setState(1174);
				match(NOTHING_);
				}
				break;
			case UPDATE_:
				{
				setState(1175);
				match(UPDATE_);
				setState(1176);
				match(SET_);
				{
				setState(1179);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,150,_ctx) ) {
				case 1:
					{
					setState(1177);
					column_name();
					}
					break;
				case 2:
					{
					setState(1178);
					column_name_list();
					}
					break;
				}
				setState(1181);
				match(EQ);
				setState(1182);
				expr(0);
				setState(1193);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1183);
					match(COMMA);
					setState(1186);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,151,_ctx) ) {
					case 1:
						{
						setState(1184);
						column_name();
						}
						break;
					case 2:
						{
						setState(1185);
						column_name_list();
						}
						break;
					}
					setState(1188);
					match(EQ);
					setState(1189);
					expr(0);
					}
					}
					setState(1195);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1198);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WHERE_) {
					{
					setState(1196);
					match(WHERE_);
					setState(1197);
					expr(0);
					}
				}

				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Pragma_stmtContext extends ParserRuleContext {
		public TerminalNode PRAGMA_() { return getToken(SQLiteParser.PRAGMA_, 0); }
		public Pragma_nameContext pragma_name() {
			return getRuleContext(Pragma_nameContext.class,0);
		}
		public Schema_nameContext schema_name() {
			return getRuleContext(Schema_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public TerminalNode ASSIGN() { return getToken(SQLiteParser.ASSIGN, 0); }
		public Pragma_valueContext pragma_value() {
			return getRuleContext(Pragma_valueContext.class,0);
		}
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public Pragma_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pragma_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterPragma_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitPragma_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitPragma_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pragma_stmtContext pragma_stmt() throws RecognitionException {
		Pragma_stmtContext _localctx = new Pragma_stmtContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_pragma_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1202);
			match(PRAGMA_);
			setState(1206);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,155,_ctx) ) {
			case 1:
				{
				setState(1203);
				schema_name();
				setState(1204);
				match(DOT);
				}
				break;
			}
			setState(1208);
			pragma_name();
			setState(1215);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ASSIGN:
				{
				setState(1209);
				match(ASSIGN);
				setState(1210);
				pragma_value();
				}
				break;
			case OPEN_PAR:
				{
				setState(1211);
				match(OPEN_PAR);
				setState(1212);
				pragma_value();
				setState(1213);
				match(CLOSE_PAR);
				}
				break;
			case EOF:
			case SCOL:
			case ALTER_:
			case ANALYZE_:
			case ATTACH_:
			case BEGIN_:
			case COMMIT_:
			case CREATE_:
			case DEFAULT_:
			case DELETE_:
			case DETACH_:
			case DROP_:
			case END_:
			case EXPLAIN_:
			case INSERT_:
			case PRAGMA_:
			case REINDEX_:
			case RELEASE_:
			case REPLACE_:
			case ROLLBACK_:
			case SAVEPOINT_:
			case SELECT_:
			case UPDATE_:
			case VACUUM_:
			case VALUES_:
			case WITH_:
				break;
			default:
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Pragma_valueContext extends ParserRuleContext {
		public Signed_numberContext signed_number() {
			return getRuleContext(Signed_numberContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode STRING_LITERAL() { return getToken(SQLiteParser.STRING_LITERAL, 0); }
		public Pragma_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pragma_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterPragma_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitPragma_value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitPragma_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pragma_valueContext pragma_value() throws RecognitionException {
		Pragma_valueContext _localctx = new Pragma_valueContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_pragma_value);
		try {
			setState(1220);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,157,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1217);
				signed_number();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1218);
				name();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1219);
				match(STRING_LITERAL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Reindex_stmtContext extends ParserRuleContext {
		public TerminalNode REINDEX_() { return getToken(SQLiteParser.REINDEX_, 0); }
		public Collation_nameContext collation_name() {
			return getRuleContext(Collation_nameContext.class,0);
		}
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public Index_nameContext index_name() {
			return getRuleContext(Index_nameContext.class,0);
		}
		public Schema_nameContext schema_name() {
			return getRuleContext(Schema_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public Reindex_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reindex_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterReindex_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitReindex_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitReindex_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Reindex_stmtContext reindex_stmt() throws RecognitionException {
		Reindex_stmtContext _localctx = new Reindex_stmtContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_reindex_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1222);
			match(REINDEX_);
			setState(1233);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,160,_ctx) ) {
			case 1:
				{
				setState(1223);
				collation_name();
				}
				break;
			case 2:
				{
				setState(1227);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,158,_ctx) ) {
				case 1:
					{
					setState(1224);
					schema_name();
					setState(1225);
					match(DOT);
					}
					break;
				}
				setState(1231);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,159,_ctx) ) {
				case 1:
					{
					setState(1229);
					table_name();
					}
					break;
				case 2:
					{
					setState(1230);
					index_name();
					}
					break;
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Select_stmtContext extends ParserRuleContext {
		public List<Select_coreContext> select_core() {
			return getRuleContexts(Select_coreContext.class);
		}
		public Select_coreContext select_core(int i) {
			return getRuleContext(Select_coreContext.class,i);
		}
		public Common_table_stmtContext common_table_stmt() {
			return getRuleContext(Common_table_stmtContext.class,0);
		}
		public List<Compound_operatorContext> compound_operator() {
			return getRuleContexts(Compound_operatorContext.class);
		}
		public Compound_operatorContext compound_operator(int i) {
			return getRuleContext(Compound_operatorContext.class,i);
		}
		public Order_by_stmtContext order_by_stmt() {
			return getRuleContext(Order_by_stmtContext.class,0);
		}
		public Limit_stmtContext limit_stmt() {
			return getRuleContext(Limit_stmtContext.class,0);
		}
		public Select_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterSelect_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitSelect_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitSelect_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Select_stmtContext select_stmt() throws RecognitionException {
		Select_stmtContext _localctx = new Select_stmtContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_select_stmt);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WITH_) {
				{
				setState(1235);
				common_table_stmt();
				}
			}

			setState(1238);
			select_core();
			setState(1244);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,162,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1239);
					compound_operator();
					setState(1240);
					select_core();
					}
					} 
				}
				setState(1246);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,162,_ctx);
			}
			setState(1248);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ORDER_) {
				{
				setState(1247);
				order_by_stmt();
				}
			}

			setState(1251);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LIMIT_) {
				{
				setState(1250);
				limit_stmt();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Join_clauseContext extends ParserRuleContext {
		public List<Table_or_subqueryContext> table_or_subquery() {
			return getRuleContexts(Table_or_subqueryContext.class);
		}
		public Table_or_subqueryContext table_or_subquery(int i) {
			return getRuleContext(Table_or_subqueryContext.class,i);
		}
		public List<Join_operatorContext> join_operator() {
			return getRuleContexts(Join_operatorContext.class);
		}
		public Join_operatorContext join_operator(int i) {
			return getRuleContext(Join_operatorContext.class,i);
		}
		public List<Join_constraintContext> join_constraint() {
			return getRuleContexts(Join_constraintContext.class);
		}
		public Join_constraintContext join_constraint(int i) {
			return getRuleContext(Join_constraintContext.class,i);
		}
		public Join_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_join_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterJoin_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitJoin_clause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitJoin_clause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Join_clauseContext join_clause() throws RecognitionException {
		Join_clauseContext _localctx = new Join_clauseContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_join_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1253);
			table_or_subquery();
			setState(1261);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA || _la==CROSS_ || ((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & ((1L << (INNER_ - 87)) | (1L << (JOIN_ - 87)) | (1L << (LEFT_ - 87)) | (1L << (NATURAL_ - 87)))) != 0)) {
				{
				{
				setState(1254);
				join_operator();
				setState(1255);
				table_or_subquery();
				setState(1257);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,165,_ctx) ) {
				case 1:
					{
					setState(1256);
					join_constraint();
					}
					break;
				}
				}
				}
				setState(1263);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Select_coreContext extends ParserRuleContext {
		public TerminalNode SELECT_() { return getToken(SQLiteParser.SELECT_, 0); }
		public List<Result_columnContext> result_column() {
			return getRuleContexts(Result_columnContext.class);
		}
		public Result_columnContext result_column(int i) {
			return getRuleContext(Result_columnContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public TerminalNode FROM_() { return getToken(SQLiteParser.FROM_, 0); }
		public TerminalNode WHERE_() { return getToken(SQLiteParser.WHERE_, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode GROUP_() { return getToken(SQLiteParser.GROUP_, 0); }
		public TerminalNode BY_() { return getToken(SQLiteParser.BY_, 0); }
		public TerminalNode WINDOW_() { return getToken(SQLiteParser.WINDOW_, 0); }
		public List<Window_nameContext> window_name() {
			return getRuleContexts(Window_nameContext.class);
		}
		public Window_nameContext window_name(int i) {
			return getRuleContext(Window_nameContext.class,i);
		}
		public List<TerminalNode> AS_() { return getTokens(SQLiteParser.AS_); }
		public TerminalNode AS_(int i) {
			return getToken(SQLiteParser.AS_, i);
		}
		public List<Window_defnContext> window_defn() {
			return getRuleContexts(Window_defnContext.class);
		}
		public Window_defnContext window_defn(int i) {
			return getRuleContext(Window_defnContext.class,i);
		}
		public TerminalNode DISTINCT_() { return getToken(SQLiteParser.DISTINCT_, 0); }
		public TerminalNode ALL_() { return getToken(SQLiteParser.ALL_, 0); }
		public List<Table_or_subqueryContext> table_or_subquery() {
			return getRuleContexts(Table_or_subqueryContext.class);
		}
		public Table_or_subqueryContext table_or_subquery(int i) {
			return getRuleContext(Table_or_subqueryContext.class,i);
		}
		public Join_clauseContext join_clause() {
			return getRuleContext(Join_clauseContext.class,0);
		}
		public TerminalNode HAVING_() { return getToken(SQLiteParser.HAVING_, 0); }
		public TerminalNode VALUES_() { return getToken(SQLiteParser.VALUES_, 0); }
		public List<TerminalNode> OPEN_PAR() { return getTokens(SQLiteParser.OPEN_PAR); }
		public TerminalNode OPEN_PAR(int i) {
			return getToken(SQLiteParser.OPEN_PAR, i);
		}
		public List<TerminalNode> CLOSE_PAR() { return getTokens(SQLiteParser.CLOSE_PAR); }
		public TerminalNode CLOSE_PAR(int i) {
			return getToken(SQLiteParser.CLOSE_PAR, i);
		}
		public Select_coreContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_core; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterSelect_core(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitSelect_core(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitSelect_core(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Select_coreContext select_core() throws RecognitionException {
		Select_coreContext _localctx = new Select_coreContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_select_core);
		int _la;
		try {
			setState(1354);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SELECT_:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(1264);
				match(SELECT_);
				setState(1266);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,167,_ctx) ) {
				case 1:
					{
					setState(1265);
					_la = _input.LA(1);
					if ( !(_la==ALL_ || _la==DISTINCT_) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				}
				setState(1268);
				result_column();
				setState(1273);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1269);
					match(COMMA);
					setState(1270);
					result_column();
					}
					}
					setState(1275);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1288);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FROM_) {
					{
					setState(1276);
					match(FROM_);
					setState(1286);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,170,_ctx) ) {
					case 1:
						{
						setState(1277);
						table_or_subquery();
						setState(1282);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(1278);
							match(COMMA);
							setState(1279);
							table_or_subquery();
							}
							}
							setState(1284);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
						break;
					case 2:
						{
						setState(1285);
						join_clause();
						}
						break;
					}
					}
				}

				setState(1292);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WHERE_) {
					{
					setState(1290);
					match(WHERE_);
					setState(1291);
					expr(0);
					}
				}

				setState(1308);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==GROUP_) {
					{
					setState(1294);
					match(GROUP_);
					setState(1295);
					match(BY_);
					setState(1296);
					expr(0);
					setState(1301);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1297);
						match(COMMA);
						setState(1298);
						expr(0);
						}
						}
						setState(1303);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1306);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==HAVING_) {
						{
						setState(1304);
						match(HAVING_);
						setState(1305);
						expr(0);
						}
					}

					}
				}

				setState(1324);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WINDOW_) {
					{
					setState(1310);
					match(WINDOW_);
					setState(1311);
					window_name();
					setState(1312);
					match(AS_);
					setState(1313);
					window_defn();
					setState(1321);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1314);
						match(COMMA);
						setState(1315);
						window_name();
						setState(1316);
						match(AS_);
						setState(1317);
						window_defn();
						}
						}
						setState(1323);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				}
				}
				break;
			case VALUES_:
				enterOuterAlt(_localctx, 2);
				{
				setState(1326);
				match(VALUES_);
				setState(1327);
				match(OPEN_PAR);
				setState(1328);
				expr(0);
				setState(1333);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1329);
					match(COMMA);
					setState(1330);
					expr(0);
					}
					}
					setState(1335);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1336);
				match(CLOSE_PAR);
				setState(1351);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1337);
					match(COMMA);
					setState(1338);
					match(OPEN_PAR);
					setState(1339);
					expr(0);
					setState(1344);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1340);
						match(COMMA);
						setState(1341);
						expr(0);
						}
						}
						setState(1346);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1347);
					match(CLOSE_PAR);
					}
					}
					setState(1353);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Factored_select_stmtContext extends ParserRuleContext {
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public Factored_select_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factored_select_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterFactored_select_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitFactored_select_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitFactored_select_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Factored_select_stmtContext factored_select_stmt() throws RecognitionException {
		Factored_select_stmtContext _localctx = new Factored_select_stmtContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_factored_select_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1356);
			select_stmt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Simple_select_stmtContext extends ParserRuleContext {
		public Select_coreContext select_core() {
			return getRuleContext(Select_coreContext.class,0);
		}
		public Common_table_stmtContext common_table_stmt() {
			return getRuleContext(Common_table_stmtContext.class,0);
		}
		public Order_by_stmtContext order_by_stmt() {
			return getRuleContext(Order_by_stmtContext.class,0);
		}
		public Limit_stmtContext limit_stmt() {
			return getRuleContext(Limit_stmtContext.class,0);
		}
		public Simple_select_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_select_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterSimple_select_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitSimple_select_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitSimple_select_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Simple_select_stmtContext simple_select_stmt() throws RecognitionException {
		Simple_select_stmtContext _localctx = new Simple_select_stmtContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_simple_select_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1359);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WITH_) {
				{
				setState(1358);
				common_table_stmt();
				}
			}

			setState(1361);
			select_core();
			setState(1363);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ORDER_) {
				{
				setState(1362);
				order_by_stmt();
				}
			}

			setState(1366);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LIMIT_) {
				{
				setState(1365);
				limit_stmt();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Compound_select_stmtContext extends ParserRuleContext {
		public List<Select_coreContext> select_core() {
			return getRuleContexts(Select_coreContext.class);
		}
		public Select_coreContext select_core(int i) {
			return getRuleContext(Select_coreContext.class,i);
		}
		public Common_table_stmtContext common_table_stmt() {
			return getRuleContext(Common_table_stmtContext.class,0);
		}
		public Order_by_stmtContext order_by_stmt() {
			return getRuleContext(Order_by_stmtContext.class,0);
		}
		public Limit_stmtContext limit_stmt() {
			return getRuleContext(Limit_stmtContext.class,0);
		}
		public List<TerminalNode> UNION_() { return getTokens(SQLiteParser.UNION_); }
		public TerminalNode UNION_(int i) {
			return getToken(SQLiteParser.UNION_, i);
		}
		public List<TerminalNode> INTERSECT_() { return getTokens(SQLiteParser.INTERSECT_); }
		public TerminalNode INTERSECT_(int i) {
			return getToken(SQLiteParser.INTERSECT_, i);
		}
		public List<TerminalNode> EXCEPT_() { return getTokens(SQLiteParser.EXCEPT_); }
		public TerminalNode EXCEPT_(int i) {
			return getToken(SQLiteParser.EXCEPT_, i);
		}
		public List<TerminalNode> ALL_() { return getTokens(SQLiteParser.ALL_); }
		public TerminalNode ALL_(int i) {
			return getToken(SQLiteParser.ALL_, i);
		}
		public Compound_select_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_select_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterCompound_select_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitCompound_select_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitCompound_select_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Compound_select_stmtContext compound_select_stmt() throws RecognitionException {
		Compound_select_stmtContext _localctx = new Compound_select_stmtContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_compound_select_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1369);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WITH_) {
				{
				setState(1368);
				common_table_stmt();
				}
			}

			setState(1371);
			select_core();
			setState(1381); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1378);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case UNION_:
					{
					setState(1372);
					match(UNION_);
					setState(1374);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ALL_) {
						{
						setState(1373);
						match(ALL_);
						}
					}

					}
					break;
				case INTERSECT_:
					{
					setState(1376);
					match(INTERSECT_);
					}
					break;
				case EXCEPT_:
					{
					setState(1377);
					match(EXCEPT_);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1380);
				select_core();
				}
				}
				setState(1383); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==EXCEPT_ || _la==INTERSECT_ || _la==UNION_ );
			setState(1386);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ORDER_) {
				{
				setState(1385);
				order_by_stmt();
				}
			}

			setState(1389);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LIMIT_) {
				{
				setState(1388);
				limit_stmt();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_or_subqueryContext extends ParserRuleContext {
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public Schema_nameContext schema_name() {
			return getRuleContext(Schema_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public Table_aliasContext table_alias() {
			return getRuleContext(Table_aliasContext.class,0);
		}
		public TerminalNode INDEXED_() { return getToken(SQLiteParser.INDEXED_, 0); }
		public TerminalNode BY_() { return getToken(SQLiteParser.BY_, 0); }
		public Index_nameContext index_name() {
			return getRuleContext(Index_nameContext.class,0);
		}
		public TerminalNode NOT_() { return getToken(SQLiteParser.NOT_, 0); }
		public TerminalNode AS_() { return getToken(SQLiteParser.AS_, 0); }
		public Table_function_nameContext table_function_name() {
			return getRuleContext(Table_function_nameContext.class,0);
		}
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public List<Table_or_subqueryContext> table_or_subquery() {
			return getRuleContexts(Table_or_subqueryContext.class);
		}
		public Table_or_subqueryContext table_or_subquery(int i) {
			return getRuleContext(Table_or_subqueryContext.class,i);
		}
		public Join_clauseContext join_clause() {
			return getRuleContext(Join_clauseContext.class,0);
		}
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public Table_or_subqueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_or_subquery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterTable_or_subquery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitTable_or_subquery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitTable_or_subquery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Table_or_subqueryContext table_or_subquery() throws RecognitionException {
		Table_or_subqueryContext _localctx = new Table_or_subqueryContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_table_or_subquery);
		int _la;
		try {
			setState(1455);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,203,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(1394);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,191,_ctx) ) {
				case 1:
					{
					setState(1391);
					schema_name();
					setState(1392);
					match(DOT);
					}
					break;
				}
				setState(1396);
				table_name();
				setState(1401);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,193,_ctx) ) {
				case 1:
					{
					setState(1398);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,192,_ctx) ) {
					case 1:
						{
						setState(1397);
						match(AS_);
						}
						break;
					}
					setState(1400);
					table_alias();
					}
					break;
				}
				setState(1408);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INDEXED_:
					{
					setState(1403);
					match(INDEXED_);
					setState(1404);
					match(BY_);
					setState(1405);
					index_name();
					}
					break;
				case NOT_:
					{
					setState(1406);
					match(NOT_);
					setState(1407);
					match(INDEXED_);
					}
					break;
				case EOF:
				case SCOL:
				case CLOSE_PAR:
				case COMMA:
				case ALTER_:
				case ANALYZE_:
				case ATTACH_:
				case BEGIN_:
				case COMMIT_:
				case CREATE_:
				case CROSS_:
				case DEFAULT_:
				case DELETE_:
				case DETACH_:
				case DROP_:
				case END_:
				case EXCEPT_:
				case EXPLAIN_:
				case GROUP_:
				case INNER_:
				case INSERT_:
				case INTERSECT_:
				case JOIN_:
				case LEFT_:
				case LIMIT_:
				case NATURAL_:
				case ON_:
				case ORDER_:
				case PRAGMA_:
				case REINDEX_:
				case RELEASE_:
				case REPLACE_:
				case ROLLBACK_:
				case SAVEPOINT_:
				case SELECT_:
				case UNION_:
				case UPDATE_:
				case USING_:
				case VACUUM_:
				case VALUES_:
				case WHERE_:
				case WITH_:
				case WINDOW_:
					break;
				default:
					break;
				}
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1413);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,195,_ctx) ) {
				case 1:
					{
					setState(1410);
					schema_name();
					setState(1411);
					match(DOT);
					}
					break;
				}
				setState(1415);
				table_function_name();
				setState(1416);
				match(OPEN_PAR);
				setState(1417);
				expr(0);
				setState(1422);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1418);
					match(COMMA);
					setState(1419);
					expr(0);
					}
					}
					setState(1424);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1425);
				match(CLOSE_PAR);
				setState(1430);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,198,_ctx) ) {
				case 1:
					{
					setState(1427);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,197,_ctx) ) {
					case 1:
						{
						setState(1426);
						match(AS_);
						}
						break;
					}
					setState(1429);
					table_alias();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1432);
				match(OPEN_PAR);
				setState(1442);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,200,_ctx) ) {
				case 1:
					{
					setState(1433);
					table_or_subquery();
					setState(1438);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1434);
						match(COMMA);
						setState(1435);
						table_or_subquery();
						}
						}
						setState(1440);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case 2:
					{
					setState(1441);
					join_clause();
					}
					break;
				}
				setState(1444);
				match(CLOSE_PAR);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1446);
				match(OPEN_PAR);
				setState(1447);
				select_stmt();
				setState(1448);
				match(CLOSE_PAR);
				setState(1453);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,202,_ctx) ) {
				case 1:
					{
					setState(1450);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,201,_ctx) ) {
					case 1:
						{
						setState(1449);
						match(AS_);
						}
						break;
					}
					setState(1452);
					table_alias();
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Result_columnContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(SQLiteParser.STAR, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Column_aliasContext column_alias() {
			return getRuleContext(Column_aliasContext.class,0);
		}
		public TerminalNode AS_() { return getToken(SQLiteParser.AS_, 0); }
		public Result_columnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_result_column; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterResult_column(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitResult_column(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitResult_column(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Result_columnContext result_column() throws RecognitionException {
		Result_columnContext _localctx = new Result_columnContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_result_column);
		int _la;
		try {
			setState(1469);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,206,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1457);
				match(STAR);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1458);
				table_name();
				setState(1459);
				match(DOT);
				setState(1460);
				match(STAR);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1462);
				expr(0);
				setState(1467);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AS_ || _la==IDENTIFIER || _la==STRING_LITERAL) {
					{
					setState(1464);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==AS_) {
						{
						setState(1463);
						match(AS_);
						}
					}

					setState(1466);
					column_alias();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Join_operatorContext extends ParserRuleContext {
		public TerminalNode COMMA() { return getToken(SQLiteParser.COMMA, 0); }
		public TerminalNode JOIN_() { return getToken(SQLiteParser.JOIN_, 0); }
		public TerminalNode NATURAL_() { return getToken(SQLiteParser.NATURAL_, 0); }
		public TerminalNode LEFT_() { return getToken(SQLiteParser.LEFT_, 0); }
		public TerminalNode INNER_() { return getToken(SQLiteParser.INNER_, 0); }
		public TerminalNode CROSS_() { return getToken(SQLiteParser.CROSS_, 0); }
		public TerminalNode OUTER_() { return getToken(SQLiteParser.OUTER_, 0); }
		public Join_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_join_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterJoin_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitJoin_operator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitJoin_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Join_operatorContext join_operator() throws RecognitionException {
		Join_operatorContext _localctx = new Join_operatorContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_join_operator);
		int _la;
		try {
			setState(1484);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMMA:
				enterOuterAlt(_localctx, 1);
				{
				setState(1471);
				match(COMMA);
				}
				break;
			case CROSS_:
			case INNER_:
			case JOIN_:
			case LEFT_:
			case NATURAL_:
				enterOuterAlt(_localctx, 2);
				{
				setState(1473);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NATURAL_) {
					{
					setState(1472);
					match(NATURAL_);
					}
				}

				setState(1481);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LEFT_:
					{
					setState(1475);
					match(LEFT_);
					setState(1477);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==OUTER_) {
						{
						setState(1476);
						match(OUTER_);
						}
					}

					}
					break;
				case INNER_:
					{
					setState(1479);
					match(INNER_);
					}
					break;
				case CROSS_:
					{
					setState(1480);
					match(CROSS_);
					}
					break;
				case JOIN_:
					break;
				default:
					break;
				}
				setState(1483);
				match(JOIN_);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Join_constraintContext extends ParserRuleContext {
		public TerminalNode ON_() { return getToken(SQLiteParser.ON_, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode USING_() { return getToken(SQLiteParser.USING_, 0); }
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Join_constraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_join_constraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterJoin_constraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitJoin_constraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitJoin_constraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Join_constraintContext join_constraint() throws RecognitionException {
		Join_constraintContext _localctx = new Join_constraintContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_join_constraint);
		int _la;
		try {
			setState(1500);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ON_:
				enterOuterAlt(_localctx, 1);
				{
				setState(1486);
				match(ON_);
				setState(1487);
				expr(0);
				}
				break;
			case USING_:
				enterOuterAlt(_localctx, 2);
				{
				setState(1488);
				match(USING_);
				setState(1489);
				match(OPEN_PAR);
				setState(1490);
				column_name();
				setState(1495);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1491);
					match(COMMA);
					setState(1492);
					column_name();
					}
					}
					setState(1497);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1498);
				match(CLOSE_PAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Compound_operatorContext extends ParserRuleContext {
		public TerminalNode UNION_() { return getToken(SQLiteParser.UNION_, 0); }
		public TerminalNode ALL_() { return getToken(SQLiteParser.ALL_, 0); }
		public TerminalNode INTERSECT_() { return getToken(SQLiteParser.INTERSECT_, 0); }
		public TerminalNode EXCEPT_() { return getToken(SQLiteParser.EXCEPT_, 0); }
		public Compound_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterCompound_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitCompound_operator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitCompound_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Compound_operatorContext compound_operator() throws RecognitionException {
		Compound_operatorContext _localctx = new Compound_operatorContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_compound_operator);
		int _la;
		try {
			setState(1508);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case UNION_:
				enterOuterAlt(_localctx, 1);
				{
				setState(1502);
				match(UNION_);
				setState(1504);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ALL_) {
					{
					setState(1503);
					match(ALL_);
					}
				}

				}
				break;
			case INTERSECT_:
				enterOuterAlt(_localctx, 2);
				{
				setState(1506);
				match(INTERSECT_);
				}
				break;
			case EXCEPT_:
				enterOuterAlt(_localctx, 3);
				{
				setState(1507);
				match(EXCEPT_);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Update_stmtContext extends ParserRuleContext {
		public TerminalNode UPDATE_() { return getToken(SQLiteParser.UPDATE_, 0); }
		public Qualified_table_nameContext qualified_table_name() {
			return getRuleContext(Qualified_table_nameContext.class,0);
		}
		public TerminalNode SET_() { return getToken(SQLiteParser.SET_, 0); }
		public List<TerminalNode> ASSIGN() { return getTokens(SQLiteParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(SQLiteParser.ASSIGN, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public List<Column_name_listContext> column_name_list() {
			return getRuleContexts(Column_name_listContext.class);
		}
		public Column_name_listContext column_name_list(int i) {
			return getRuleContext(Column_name_listContext.class,i);
		}
		public With_clauseContext with_clause() {
			return getRuleContext(With_clauseContext.class,0);
		}
		public TerminalNode OR_() { return getToken(SQLiteParser.OR_, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public TerminalNode WHERE_() { return getToken(SQLiteParser.WHERE_, 0); }
		public TerminalNode ROLLBACK_() { return getToken(SQLiteParser.ROLLBACK_, 0); }
		public TerminalNode ABORT_() { return getToken(SQLiteParser.ABORT_, 0); }
		public TerminalNode REPLACE_() { return getToken(SQLiteParser.REPLACE_, 0); }
		public TerminalNode FAIL_() { return getToken(SQLiteParser.FAIL_, 0); }
		public TerminalNode IGNORE_() { return getToken(SQLiteParser.IGNORE_, 0); }
		public Update_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_update_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterUpdate_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitUpdate_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitUpdate_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Update_stmtContext update_stmt() throws RecognitionException {
		Update_stmtContext _localctx = new Update_stmtContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_update_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1511);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WITH_) {
				{
				setState(1510);
				with_clause();
				}
			}

			setState(1513);
			match(UPDATE_);
			setState(1516);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,216,_ctx) ) {
			case 1:
				{
				setState(1514);
				match(OR_);
				setState(1515);
				_la = _input.LA(1);
				if ( !(_la==ABORT_ || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (FAIL_ - 72)) | (1L << (IGNORE_ - 72)) | (1L << (REPLACE_ - 72)) | (1L << (ROLLBACK_ - 72)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
			setState(1518);
			qualified_table_name();
			setState(1519);
			match(SET_);
			setState(1522);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,217,_ctx) ) {
			case 1:
				{
				setState(1520);
				column_name();
				}
				break;
			case 2:
				{
				setState(1521);
				column_name_list();
				}
				break;
			}
			setState(1524);
			match(ASSIGN);
			setState(1525);
			expr(0);
			setState(1536);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1526);
				match(COMMA);
				setState(1529);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,218,_ctx) ) {
				case 1:
					{
					setState(1527);
					column_name();
					}
					break;
				case 2:
					{
					setState(1528);
					column_name_list();
					}
					break;
				}
				setState(1531);
				match(ASSIGN);
				setState(1532);
				expr(0);
				}
				}
				setState(1538);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1541);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE_) {
				{
				setState(1539);
				match(WHERE_);
				setState(1540);
				expr(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Column_name_listContext extends ParserRuleContext {
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Column_name_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_name_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterColumn_name_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitColumn_name_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitColumn_name_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Column_name_listContext column_name_list() throws RecognitionException {
		Column_name_listContext _localctx = new Column_name_listContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_column_name_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1543);
			match(OPEN_PAR);
			setState(1544);
			column_name();
			setState(1549);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1545);
				match(COMMA);
				setState(1546);
				column_name();
				}
				}
				setState(1551);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1552);
			match(CLOSE_PAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Update_stmt_limitedContext extends ParserRuleContext {
		public TerminalNode UPDATE_() { return getToken(SQLiteParser.UPDATE_, 0); }
		public Qualified_table_nameContext qualified_table_name() {
			return getRuleContext(Qualified_table_nameContext.class,0);
		}
		public TerminalNode SET_() { return getToken(SQLiteParser.SET_, 0); }
		public List<TerminalNode> ASSIGN() { return getTokens(SQLiteParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(SQLiteParser.ASSIGN, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public List<Column_name_listContext> column_name_list() {
			return getRuleContexts(Column_name_listContext.class);
		}
		public Column_name_listContext column_name_list(int i) {
			return getRuleContext(Column_name_listContext.class,i);
		}
		public With_clauseContext with_clause() {
			return getRuleContext(With_clauseContext.class,0);
		}
		public TerminalNode OR_() { return getToken(SQLiteParser.OR_, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public TerminalNode WHERE_() { return getToken(SQLiteParser.WHERE_, 0); }
		public Limit_stmtContext limit_stmt() {
			return getRuleContext(Limit_stmtContext.class,0);
		}
		public TerminalNode ROLLBACK_() { return getToken(SQLiteParser.ROLLBACK_, 0); }
		public TerminalNode ABORT_() { return getToken(SQLiteParser.ABORT_, 0); }
		public TerminalNode REPLACE_() { return getToken(SQLiteParser.REPLACE_, 0); }
		public TerminalNode FAIL_() { return getToken(SQLiteParser.FAIL_, 0); }
		public TerminalNode IGNORE_() { return getToken(SQLiteParser.IGNORE_, 0); }
		public Order_by_stmtContext order_by_stmt() {
			return getRuleContext(Order_by_stmtContext.class,0);
		}
		public Update_stmt_limitedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_update_stmt_limited; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterUpdate_stmt_limited(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitUpdate_stmt_limited(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitUpdate_stmt_limited(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Update_stmt_limitedContext update_stmt_limited() throws RecognitionException {
		Update_stmt_limitedContext _localctx = new Update_stmt_limitedContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_update_stmt_limited);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1555);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WITH_) {
				{
				setState(1554);
				with_clause();
				}
			}

			setState(1557);
			match(UPDATE_);
			setState(1560);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,223,_ctx) ) {
			case 1:
				{
				setState(1558);
				match(OR_);
				setState(1559);
				_la = _input.LA(1);
				if ( !(_la==ABORT_ || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (FAIL_ - 72)) | (1L << (IGNORE_ - 72)) | (1L << (REPLACE_ - 72)) | (1L << (ROLLBACK_ - 72)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
			setState(1562);
			qualified_table_name();
			setState(1563);
			match(SET_);
			setState(1566);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,224,_ctx) ) {
			case 1:
				{
				setState(1564);
				column_name();
				}
				break;
			case 2:
				{
				setState(1565);
				column_name_list();
				}
				break;
			}
			setState(1568);
			match(ASSIGN);
			setState(1569);
			expr(0);
			setState(1580);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1570);
				match(COMMA);
				setState(1573);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,225,_ctx) ) {
				case 1:
					{
					setState(1571);
					column_name();
					}
					break;
				case 2:
					{
					setState(1572);
					column_name_list();
					}
					break;
				}
				setState(1575);
				match(ASSIGN);
				setState(1576);
				expr(0);
				}
				}
				setState(1582);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1585);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE_) {
				{
				setState(1583);
				match(WHERE_);
				setState(1584);
				expr(0);
				}
			}

			setState(1591);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LIMIT_ || _la==ORDER_) {
				{
				setState(1588);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ORDER_) {
					{
					setState(1587);
					order_by_stmt();
					}
				}

				setState(1590);
				limit_stmt();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Qualified_table_nameContext extends ParserRuleContext {
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public Schema_nameContext schema_name() {
			return getRuleContext(Schema_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public TerminalNode AS_() { return getToken(SQLiteParser.AS_, 0); }
		public AliasContext alias() {
			return getRuleContext(AliasContext.class,0);
		}
		public TerminalNode INDEXED_() { return getToken(SQLiteParser.INDEXED_, 0); }
		public TerminalNode BY_() { return getToken(SQLiteParser.BY_, 0); }
		public Index_nameContext index_name() {
			return getRuleContext(Index_nameContext.class,0);
		}
		public TerminalNode NOT_() { return getToken(SQLiteParser.NOT_, 0); }
		public Qualified_table_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualified_table_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterQualified_table_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitQualified_table_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitQualified_table_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Qualified_table_nameContext qualified_table_name() throws RecognitionException {
		Qualified_table_nameContext _localctx = new Qualified_table_nameContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_qualified_table_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1596);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,230,_ctx) ) {
			case 1:
				{
				setState(1593);
				schema_name();
				setState(1594);
				match(DOT);
				}
				break;
			}
			setState(1598);
			table_name();
			setState(1601);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS_) {
				{
				setState(1599);
				match(AS_);
				setState(1600);
				alias();
				}
			}

			setState(1608);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INDEXED_:
				{
				setState(1603);
				match(INDEXED_);
				setState(1604);
				match(BY_);
				setState(1605);
				index_name();
				}
				break;
			case NOT_:
				{
				setState(1606);
				match(NOT_);
				setState(1607);
				match(INDEXED_);
				}
				break;
			case EOF:
			case SCOL:
			case ALTER_:
			case ANALYZE_:
			case ATTACH_:
			case BEGIN_:
			case COMMIT_:
			case CREATE_:
			case DEFAULT_:
			case DELETE_:
			case DETACH_:
			case DROP_:
			case END_:
			case EXPLAIN_:
			case INSERT_:
			case LIMIT_:
			case ORDER_:
			case PRAGMA_:
			case REINDEX_:
			case RELEASE_:
			case REPLACE_:
			case ROLLBACK_:
			case SAVEPOINT_:
			case SELECT_:
			case SET_:
			case UPDATE_:
			case VACUUM_:
			case VALUES_:
			case WHERE_:
			case WITH_:
				break;
			default:
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Vacuum_stmtContext extends ParserRuleContext {
		public TerminalNode VACUUM_() { return getToken(SQLiteParser.VACUUM_, 0); }
		public Schema_nameContext schema_name() {
			return getRuleContext(Schema_nameContext.class,0);
		}
		public TerminalNode INTO_() { return getToken(SQLiteParser.INTO_, 0); }
		public FilenameContext filename() {
			return getRuleContext(FilenameContext.class,0);
		}
		public Vacuum_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vacuum_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterVacuum_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitVacuum_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitVacuum_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Vacuum_stmtContext vacuum_stmt() throws RecognitionException {
		Vacuum_stmtContext _localctx = new Vacuum_stmtContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_vacuum_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1610);
			match(VACUUM_);
			setState(1612);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,233,_ctx) ) {
			case 1:
				{
				setState(1611);
				schema_name();
				}
				break;
			}
			setState(1616);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INTO_) {
				{
				setState(1614);
				match(INTO_);
				setState(1615);
				filename();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Filter_clauseContext extends ParserRuleContext {
		public TerminalNode FILTER_() { return getToken(SQLiteParser.FILTER_, 0); }
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public TerminalNode WHERE_() { return getToken(SQLiteParser.WHERE_, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public Filter_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filter_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterFilter_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitFilter_clause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitFilter_clause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Filter_clauseContext filter_clause() throws RecognitionException {
		Filter_clauseContext _localctx = new Filter_clauseContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_filter_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1618);
			match(FILTER_);
			setState(1619);
			match(OPEN_PAR);
			setState(1620);
			match(WHERE_);
			setState(1621);
			expr(0);
			setState(1622);
			match(CLOSE_PAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Window_defnContext extends ParserRuleContext {
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public TerminalNode ORDER_() { return getToken(SQLiteParser.ORDER_, 0); }
		public List<TerminalNode> BY_() { return getTokens(SQLiteParser.BY_); }
		public TerminalNode BY_(int i) {
			return getToken(SQLiteParser.BY_, i);
		}
		public List<Ordering_termContext> ordering_term() {
			return getRuleContexts(Ordering_termContext.class);
		}
		public Ordering_termContext ordering_term(int i) {
			return getRuleContext(Ordering_termContext.class,i);
		}
		public Base_window_nameContext base_window_name() {
			return getRuleContext(Base_window_nameContext.class,0);
		}
		public TerminalNode PARTITION_() { return getToken(SQLiteParser.PARTITION_, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Frame_specContext frame_spec() {
			return getRuleContext(Frame_specContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Window_defnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_window_defn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterWindow_defn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitWindow_defn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitWindow_defn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Window_defnContext window_defn() throws RecognitionException {
		Window_defnContext _localctx = new Window_defnContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_window_defn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1624);
			match(OPEN_PAR);
			setState(1626);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,235,_ctx) ) {
			case 1:
				{
				setState(1625);
				base_window_name();
				}
				break;
			}
			setState(1638);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PARTITION_) {
				{
				setState(1628);
				match(PARTITION_);
				setState(1629);
				match(BY_);
				setState(1630);
				expr(0);
				setState(1635);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1631);
					match(COMMA);
					setState(1632);
					expr(0);
					}
					}
					setState(1637);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			{
			setState(1640);
			match(ORDER_);
			setState(1641);
			match(BY_);
			setState(1642);
			ordering_term();
			setState(1647);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1643);
				match(COMMA);
				setState(1644);
				ordering_term();
				}
				}
				setState(1649);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(1651);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 127)) & ~0x3f) == 0 && ((1L << (_la - 127)) & ((1L << (ROWS_ - 127)) | (1L << (RANGE_ - 127)) | (1L << (GROUPS_ - 127)))) != 0)) {
				{
				setState(1650);
				frame_spec();
				}
			}

			setState(1653);
			match(CLOSE_PAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Over_clauseContext extends ParserRuleContext {
		public TerminalNode OVER_() { return getToken(SQLiteParser.OVER_, 0); }
		public Window_nameContext window_name() {
			return getRuleContext(Window_nameContext.class,0);
		}
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public Base_window_nameContext base_window_name() {
			return getRuleContext(Base_window_nameContext.class,0);
		}
		public TerminalNode PARTITION_() { return getToken(SQLiteParser.PARTITION_, 0); }
		public List<TerminalNode> BY_() { return getTokens(SQLiteParser.BY_); }
		public TerminalNode BY_(int i) {
			return getToken(SQLiteParser.BY_, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ORDER_() { return getToken(SQLiteParser.ORDER_, 0); }
		public List<Ordering_termContext> ordering_term() {
			return getRuleContexts(Ordering_termContext.class);
		}
		public Ordering_termContext ordering_term(int i) {
			return getRuleContext(Ordering_termContext.class,i);
		}
		public Frame_specContext frame_spec() {
			return getRuleContext(Frame_specContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Over_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_over_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterOver_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitOver_clause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitOver_clause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Over_clauseContext over_clause() throws RecognitionException {
		Over_clauseContext _localctx = new Over_clauseContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_over_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1655);
			match(OVER_);
			setState(1689);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,246,_ctx) ) {
			case 1:
				{
				setState(1656);
				window_name();
				}
				break;
			case 2:
				{
				setState(1657);
				match(OPEN_PAR);
				setState(1659);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,240,_ctx) ) {
				case 1:
					{
					setState(1658);
					base_window_name();
					}
					break;
				}
				setState(1671);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION_) {
					{
					setState(1661);
					match(PARTITION_);
					setState(1662);
					match(BY_);
					setState(1663);
					expr(0);
					setState(1668);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1664);
						match(COMMA);
						setState(1665);
						expr(0);
						}
						}
						setState(1670);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(1683);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ORDER_) {
					{
					setState(1673);
					match(ORDER_);
					setState(1674);
					match(BY_);
					setState(1675);
					ordering_term();
					setState(1680);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1676);
						match(COMMA);
						setState(1677);
						ordering_term();
						}
						}
						setState(1682);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(1686);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 127)) & ~0x3f) == 0 && ((1L << (_la - 127)) & ((1L << (ROWS_ - 127)) | (1L << (RANGE_ - 127)) | (1L << (GROUPS_ - 127)))) != 0)) {
					{
					setState(1685);
					frame_spec();
					}
				}

				setState(1688);
				match(CLOSE_PAR);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Frame_specContext extends ParserRuleContext {
		public Frame_clauseContext frame_clause() {
			return getRuleContext(Frame_clauseContext.class,0);
		}
		public TerminalNode EXCLUDE_() { return getToken(SQLiteParser.EXCLUDE_, 0); }
		public TerminalNode CURRENT_() { return getToken(SQLiteParser.CURRENT_, 0); }
		public TerminalNode ROW_() { return getToken(SQLiteParser.ROW_, 0); }
		public TerminalNode GROUP_() { return getToken(SQLiteParser.GROUP_, 0); }
		public TerminalNode TIES_() { return getToken(SQLiteParser.TIES_, 0); }
		public TerminalNode NO_() { return getToken(SQLiteParser.NO_, 0); }
		public TerminalNode OTHERS_() { return getToken(SQLiteParser.OTHERS_, 0); }
		public Frame_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_frame_spec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterFrame_spec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitFrame_spec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitFrame_spec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Frame_specContext frame_spec() throws RecognitionException {
		Frame_specContext _localctx = new Frame_specContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_frame_spec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1691);
			frame_clause();
			setState(1699);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EXCLUDE_:
				{
				setState(1692);
				match(EXCLUDE_);
				{
				setState(1693);
				match(NO_);
				setState(1694);
				match(OTHERS_);
				}
				}
				break;
			case CURRENT_:
				{
				setState(1695);
				match(CURRENT_);
				setState(1696);
				match(ROW_);
				}
				break;
			case GROUP_:
				{
				setState(1697);
				match(GROUP_);
				}
				break;
			case TIES_:
				{
				setState(1698);
				match(TIES_);
				}
				break;
			case CLOSE_PAR:
				break;
			default:
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Frame_clauseContext extends ParserRuleContext {
		public TerminalNode RANGE_() { return getToken(SQLiteParser.RANGE_, 0); }
		public TerminalNode ROWS_() { return getToken(SQLiteParser.ROWS_, 0); }
		public TerminalNode GROUPS_() { return getToken(SQLiteParser.GROUPS_, 0); }
		public Frame_singleContext frame_single() {
			return getRuleContext(Frame_singleContext.class,0);
		}
		public TerminalNode BETWEEN_() { return getToken(SQLiteParser.BETWEEN_, 0); }
		public Frame_leftContext frame_left() {
			return getRuleContext(Frame_leftContext.class,0);
		}
		public TerminalNode AND_() { return getToken(SQLiteParser.AND_, 0); }
		public Frame_rightContext frame_right() {
			return getRuleContext(Frame_rightContext.class,0);
		}
		public Frame_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_frame_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterFrame_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitFrame_clause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitFrame_clause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Frame_clauseContext frame_clause() throws RecognitionException {
		Frame_clauseContext _localctx = new Frame_clauseContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_frame_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1701);
			_la = _input.LA(1);
			if ( !(((((_la - 127)) & ~0x3f) == 0 && ((1L << (_la - 127)) & ((1L << (ROWS_ - 127)) | (1L << (RANGE_ - 127)) | (1L << (GROUPS_ - 127)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(1708);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,248,_ctx) ) {
			case 1:
				{
				setState(1702);
				frame_single();
				}
				break;
			case 2:
				{
				setState(1703);
				match(BETWEEN_);
				setState(1704);
				frame_left();
				setState(1705);
				match(AND_);
				setState(1706);
				frame_right();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Simple_function_invocationContext extends ParserRuleContext {
		public Simple_funcContext simple_func() {
			return getRuleContext(Simple_funcContext.class,0);
		}
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode STAR() { return getToken(SQLiteParser.STAR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Simple_function_invocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_function_invocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterSimple_function_invocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitSimple_function_invocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitSimple_function_invocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Simple_function_invocationContext simple_function_invocation() throws RecognitionException {
		Simple_function_invocationContext _localctx = new Simple_function_invocationContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_simple_function_invocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1710);
			simple_func();
			setState(1711);
			match(OPEN_PAR);
			setState(1721);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_PAR:
			case PLUS:
			case MINUS:
			case TILDE:
			case ABORT_:
			case ACTION_:
			case ADD_:
			case AFTER_:
			case ALL_:
			case ALTER_:
			case ANALYZE_:
			case AND_:
			case AS_:
			case ASC_:
			case ATTACH_:
			case AUTOINCREMENT_:
			case BEFORE_:
			case BEGIN_:
			case BETWEEN_:
			case BY_:
			case CASCADE_:
			case CASE_:
			case CAST_:
			case CHECK_:
			case COLLATE_:
			case COLUMN_:
			case COMMIT_:
			case CONFLICT_:
			case CONSTRAINT_:
			case CREATE_:
			case CROSS_:
			case CURRENT_DATE_:
			case CURRENT_TIME_:
			case CURRENT_TIMESTAMP_:
			case DATABASE_:
			case DEFAULT_:
			case DEFERRABLE_:
			case DEFERRED_:
			case DELETE_:
			case DESC_:
			case DETACH_:
			case DISTINCT_:
			case DROP_:
			case EACH_:
			case ELSE_:
			case END_:
			case ESCAPE_:
			case EXCEPT_:
			case EXCLUSIVE_:
			case EXISTS_:
			case EXPLAIN_:
			case FAIL_:
			case FOR_:
			case FOREIGN_:
			case FROM_:
			case FULL_:
			case GLOB_:
			case GROUP_:
			case HAVING_:
			case IF_:
			case IGNORE_:
			case IMMEDIATE_:
			case IN_:
			case INDEX_:
			case INDEXED_:
			case INITIALLY_:
			case INNER_:
			case INSERT_:
			case INSTEAD_:
			case INTERSECT_:
			case INTO_:
			case IS_:
			case ISNULL_:
			case JOIN_:
			case KEY_:
			case LEFT_:
			case LIKE_:
			case LIMIT_:
			case MATCH_:
			case NATURAL_:
			case NO_:
			case NOT_:
			case NOTNULL_:
			case NULL_:
			case OF_:
			case OFFSET_:
			case ON_:
			case OR_:
			case ORDER_:
			case OUTER_:
			case PLAN_:
			case PRAGMA_:
			case PRIMARY_:
			case QUERY_:
			case RAISE_:
			case RECURSIVE_:
			case REFERENCES_:
			case REGEXP_:
			case REINDEX_:
			case RELEASE_:
			case RENAME_:
			case REPLACE_:
			case RESTRICT_:
			case RIGHT_:
			case ROLLBACK_:
			case ROW_:
			case ROWS_:
			case SAVEPOINT_:
			case SELECT_:
			case SET_:
			case TABLE_:
			case TEMP_:
			case TEMPORARY_:
			case THEN_:
			case TO_:
			case TRANSACTION_:
			case TRIGGER_:
			case UNION_:
			case UNIQUE_:
			case UPDATE_:
			case USING_:
			case VACUUM_:
			case VALUES_:
			case VIEW_:
			case VIRTUAL_:
			case WHEN_:
			case WHERE_:
			case WITH_:
			case WITHOUT_:
			case FIRST_VALUE_:
			case OVER_:
			case PARTITION_:
			case RANGE_:
			case PRECEDING_:
			case UNBOUNDED_:
			case CURRENT_:
			case FOLLOWING_:
			case CUME_DIST_:
			case DENSE_RANK_:
			case LAG_:
			case LAST_VALUE_:
			case LEAD_:
			case NTH_VALUE_:
			case NTILE_:
			case PERCENT_RANK_:
			case RANK_:
			case ROW_NUMBER_:
			case GENERATED_:
			case ALWAYS_:
			case STORED_:
			case TRUE_:
			case FALSE_:
			case WINDOW_:
			case NULLS_:
			case FIRST_:
			case LAST_:
			case FILTER_:
			case GROUPS_:
			case EXCLUDE_:
			case IDENTIFIER:
			case NUMERIC_LITERAL:
			case BIND_PARAMETER:
			case STRING_LITERAL:
			case BLOB_LITERAL:
				{
				setState(1712);
				expr(0);
				setState(1717);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1713);
					match(COMMA);
					setState(1714);
					expr(0);
					}
					}
					setState(1719);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case STAR:
				{
				setState(1720);
				match(STAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1723);
			match(CLOSE_PAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Aggregate_function_invocationContext extends ParserRuleContext {
		public Aggregate_funcContext aggregate_func() {
			return getRuleContext(Aggregate_funcContext.class,0);
		}
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode STAR() { return getToken(SQLiteParser.STAR, 0); }
		public Filter_clauseContext filter_clause() {
			return getRuleContext(Filter_clauseContext.class,0);
		}
		public TerminalNode DISTINCT_() { return getToken(SQLiteParser.DISTINCT_, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Aggregate_function_invocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregate_function_invocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterAggregate_function_invocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitAggregate_function_invocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitAggregate_function_invocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Aggregate_function_invocationContext aggregate_function_invocation() throws RecognitionException {
		Aggregate_function_invocationContext _localctx = new Aggregate_function_invocationContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_aggregate_function_invocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1725);
			aggregate_func();
			setState(1726);
			match(OPEN_PAR);
			setState(1739);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_PAR:
			case PLUS:
			case MINUS:
			case TILDE:
			case ABORT_:
			case ACTION_:
			case ADD_:
			case AFTER_:
			case ALL_:
			case ALTER_:
			case ANALYZE_:
			case AND_:
			case AS_:
			case ASC_:
			case ATTACH_:
			case AUTOINCREMENT_:
			case BEFORE_:
			case BEGIN_:
			case BETWEEN_:
			case BY_:
			case CASCADE_:
			case CASE_:
			case CAST_:
			case CHECK_:
			case COLLATE_:
			case COLUMN_:
			case COMMIT_:
			case CONFLICT_:
			case CONSTRAINT_:
			case CREATE_:
			case CROSS_:
			case CURRENT_DATE_:
			case CURRENT_TIME_:
			case CURRENT_TIMESTAMP_:
			case DATABASE_:
			case DEFAULT_:
			case DEFERRABLE_:
			case DEFERRED_:
			case DELETE_:
			case DESC_:
			case DETACH_:
			case DISTINCT_:
			case DROP_:
			case EACH_:
			case ELSE_:
			case END_:
			case ESCAPE_:
			case EXCEPT_:
			case EXCLUSIVE_:
			case EXISTS_:
			case EXPLAIN_:
			case FAIL_:
			case FOR_:
			case FOREIGN_:
			case FROM_:
			case FULL_:
			case GLOB_:
			case GROUP_:
			case HAVING_:
			case IF_:
			case IGNORE_:
			case IMMEDIATE_:
			case IN_:
			case INDEX_:
			case INDEXED_:
			case INITIALLY_:
			case INNER_:
			case INSERT_:
			case INSTEAD_:
			case INTERSECT_:
			case INTO_:
			case IS_:
			case ISNULL_:
			case JOIN_:
			case KEY_:
			case LEFT_:
			case LIKE_:
			case LIMIT_:
			case MATCH_:
			case NATURAL_:
			case NO_:
			case NOT_:
			case NOTNULL_:
			case NULL_:
			case OF_:
			case OFFSET_:
			case ON_:
			case OR_:
			case ORDER_:
			case OUTER_:
			case PLAN_:
			case PRAGMA_:
			case PRIMARY_:
			case QUERY_:
			case RAISE_:
			case RECURSIVE_:
			case REFERENCES_:
			case REGEXP_:
			case REINDEX_:
			case RELEASE_:
			case RENAME_:
			case REPLACE_:
			case RESTRICT_:
			case RIGHT_:
			case ROLLBACK_:
			case ROW_:
			case ROWS_:
			case SAVEPOINT_:
			case SELECT_:
			case SET_:
			case TABLE_:
			case TEMP_:
			case TEMPORARY_:
			case THEN_:
			case TO_:
			case TRANSACTION_:
			case TRIGGER_:
			case UNION_:
			case UNIQUE_:
			case UPDATE_:
			case USING_:
			case VACUUM_:
			case VALUES_:
			case VIEW_:
			case VIRTUAL_:
			case WHEN_:
			case WHERE_:
			case WITH_:
			case WITHOUT_:
			case FIRST_VALUE_:
			case OVER_:
			case PARTITION_:
			case RANGE_:
			case PRECEDING_:
			case UNBOUNDED_:
			case CURRENT_:
			case FOLLOWING_:
			case CUME_DIST_:
			case DENSE_RANK_:
			case LAG_:
			case LAST_VALUE_:
			case LEAD_:
			case NTH_VALUE_:
			case NTILE_:
			case PERCENT_RANK_:
			case RANK_:
			case ROW_NUMBER_:
			case GENERATED_:
			case ALWAYS_:
			case STORED_:
			case TRUE_:
			case FALSE_:
			case WINDOW_:
			case NULLS_:
			case FIRST_:
			case LAST_:
			case FILTER_:
			case GROUPS_:
			case EXCLUDE_:
			case IDENTIFIER:
			case NUMERIC_LITERAL:
			case BIND_PARAMETER:
			case STRING_LITERAL:
			case BLOB_LITERAL:
				{
				setState(1728);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,251,_ctx) ) {
				case 1:
					{
					setState(1727);
					match(DISTINCT_);
					}
					break;
				}
				setState(1730);
				expr(0);
				setState(1735);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1731);
					match(COMMA);
					setState(1732);
					expr(0);
					}
					}
					setState(1737);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case STAR:
				{
				setState(1738);
				match(STAR);
				}
				break;
			case CLOSE_PAR:
				break;
			default:
				break;
			}
			setState(1741);
			match(CLOSE_PAR);
			setState(1743);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FILTER_) {
				{
				setState(1742);
				filter_clause();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Window_function_invocationContext extends ParserRuleContext {
		public Window_functionContext window_function() {
			return getRuleContext(Window_functionContext.class,0);
		}
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public TerminalNode OVER_() { return getToken(SQLiteParser.OVER_, 0); }
		public Window_defnContext window_defn() {
			return getRuleContext(Window_defnContext.class,0);
		}
		public Window_nameContext window_name() {
			return getRuleContext(Window_nameContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode STAR() { return getToken(SQLiteParser.STAR, 0); }
		public Filter_clauseContext filter_clause() {
			return getRuleContext(Filter_clauseContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Window_function_invocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_window_function_invocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterWindow_function_invocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitWindow_function_invocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitWindow_function_invocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Window_function_invocationContext window_function_invocation() throws RecognitionException {
		Window_function_invocationContext _localctx = new Window_function_invocationContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_window_function_invocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1745);
			window_function();
			setState(1746);
			match(OPEN_PAR);
			setState(1756);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_PAR:
			case PLUS:
			case MINUS:
			case TILDE:
			case ABORT_:
			case ACTION_:
			case ADD_:
			case AFTER_:
			case ALL_:
			case ALTER_:
			case ANALYZE_:
			case AND_:
			case AS_:
			case ASC_:
			case ATTACH_:
			case AUTOINCREMENT_:
			case BEFORE_:
			case BEGIN_:
			case BETWEEN_:
			case BY_:
			case CASCADE_:
			case CASE_:
			case CAST_:
			case CHECK_:
			case COLLATE_:
			case COLUMN_:
			case COMMIT_:
			case CONFLICT_:
			case CONSTRAINT_:
			case CREATE_:
			case CROSS_:
			case CURRENT_DATE_:
			case CURRENT_TIME_:
			case CURRENT_TIMESTAMP_:
			case DATABASE_:
			case DEFAULT_:
			case DEFERRABLE_:
			case DEFERRED_:
			case DELETE_:
			case DESC_:
			case DETACH_:
			case DISTINCT_:
			case DROP_:
			case EACH_:
			case ELSE_:
			case END_:
			case ESCAPE_:
			case EXCEPT_:
			case EXCLUSIVE_:
			case EXISTS_:
			case EXPLAIN_:
			case FAIL_:
			case FOR_:
			case FOREIGN_:
			case FROM_:
			case FULL_:
			case GLOB_:
			case GROUP_:
			case HAVING_:
			case IF_:
			case IGNORE_:
			case IMMEDIATE_:
			case IN_:
			case INDEX_:
			case INDEXED_:
			case INITIALLY_:
			case INNER_:
			case INSERT_:
			case INSTEAD_:
			case INTERSECT_:
			case INTO_:
			case IS_:
			case ISNULL_:
			case JOIN_:
			case KEY_:
			case LEFT_:
			case LIKE_:
			case LIMIT_:
			case MATCH_:
			case NATURAL_:
			case NO_:
			case NOT_:
			case NOTNULL_:
			case NULL_:
			case OF_:
			case OFFSET_:
			case ON_:
			case OR_:
			case ORDER_:
			case OUTER_:
			case PLAN_:
			case PRAGMA_:
			case PRIMARY_:
			case QUERY_:
			case RAISE_:
			case RECURSIVE_:
			case REFERENCES_:
			case REGEXP_:
			case REINDEX_:
			case RELEASE_:
			case RENAME_:
			case REPLACE_:
			case RESTRICT_:
			case RIGHT_:
			case ROLLBACK_:
			case ROW_:
			case ROWS_:
			case SAVEPOINT_:
			case SELECT_:
			case SET_:
			case TABLE_:
			case TEMP_:
			case TEMPORARY_:
			case THEN_:
			case TO_:
			case TRANSACTION_:
			case TRIGGER_:
			case UNION_:
			case UNIQUE_:
			case UPDATE_:
			case USING_:
			case VACUUM_:
			case VALUES_:
			case VIEW_:
			case VIRTUAL_:
			case WHEN_:
			case WHERE_:
			case WITH_:
			case WITHOUT_:
			case FIRST_VALUE_:
			case OVER_:
			case PARTITION_:
			case RANGE_:
			case PRECEDING_:
			case UNBOUNDED_:
			case CURRENT_:
			case FOLLOWING_:
			case CUME_DIST_:
			case DENSE_RANK_:
			case LAG_:
			case LAST_VALUE_:
			case LEAD_:
			case NTH_VALUE_:
			case NTILE_:
			case PERCENT_RANK_:
			case RANK_:
			case ROW_NUMBER_:
			case GENERATED_:
			case ALWAYS_:
			case STORED_:
			case TRUE_:
			case FALSE_:
			case WINDOW_:
			case NULLS_:
			case FIRST_:
			case LAST_:
			case FILTER_:
			case GROUPS_:
			case EXCLUDE_:
			case IDENTIFIER:
			case NUMERIC_LITERAL:
			case BIND_PARAMETER:
			case STRING_LITERAL:
			case BLOB_LITERAL:
				{
				setState(1747);
				expr(0);
				setState(1752);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1748);
					match(COMMA);
					setState(1749);
					expr(0);
					}
					}
					setState(1754);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case STAR:
				{
				setState(1755);
				match(STAR);
				}
				break;
			case CLOSE_PAR:
				break;
			default:
				break;
			}
			setState(1758);
			match(CLOSE_PAR);
			setState(1760);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FILTER_) {
				{
				setState(1759);
				filter_clause();
				}
			}

			setState(1762);
			match(OVER_);
			setState(1765);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,258,_ctx) ) {
			case 1:
				{
				setState(1763);
				window_defn();
				}
				break;
			case 2:
				{
				setState(1764);
				window_name();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Common_table_stmtContext extends ParserRuleContext {
		public TerminalNode WITH_() { return getToken(SQLiteParser.WITH_, 0); }
		public List<Common_table_expressionContext> common_table_expression() {
			return getRuleContexts(Common_table_expressionContext.class);
		}
		public Common_table_expressionContext common_table_expression(int i) {
			return getRuleContext(Common_table_expressionContext.class,i);
		}
		public TerminalNode RECURSIVE_() { return getToken(SQLiteParser.RECURSIVE_, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Common_table_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_common_table_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterCommon_table_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitCommon_table_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitCommon_table_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Common_table_stmtContext common_table_stmt() throws RecognitionException {
		Common_table_stmtContext _localctx = new Common_table_stmtContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_common_table_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1767);
			match(WITH_);
			setState(1769);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,259,_ctx) ) {
			case 1:
				{
				setState(1768);
				match(RECURSIVE_);
				}
				break;
			}
			setState(1771);
			common_table_expression();
			setState(1776);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1772);
				match(COMMA);
				setState(1773);
				common_table_expression();
				}
				}
				setState(1778);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Order_by_stmtContext extends ParserRuleContext {
		public TerminalNode ORDER_() { return getToken(SQLiteParser.ORDER_, 0); }
		public TerminalNode BY_() { return getToken(SQLiteParser.BY_, 0); }
		public List<Ordering_termContext> ordering_term() {
			return getRuleContexts(Ordering_termContext.class);
		}
		public Ordering_termContext ordering_term(int i) {
			return getRuleContext(Ordering_termContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Order_by_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_order_by_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterOrder_by_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitOrder_by_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitOrder_by_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Order_by_stmtContext order_by_stmt() throws RecognitionException {
		Order_by_stmtContext _localctx = new Order_by_stmtContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_order_by_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1779);
			match(ORDER_);
			setState(1780);
			match(BY_);
			setState(1781);
			ordering_term();
			setState(1786);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1782);
				match(COMMA);
				setState(1783);
				ordering_term();
				}
				}
				setState(1788);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Limit_stmtContext extends ParserRuleContext {
		public TerminalNode LIMIT_() { return getToken(SQLiteParser.LIMIT_, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OFFSET_() { return getToken(SQLiteParser.OFFSET_, 0); }
		public TerminalNode COMMA() { return getToken(SQLiteParser.COMMA, 0); }
		public Limit_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_limit_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterLimit_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitLimit_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitLimit_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Limit_stmtContext limit_stmt() throws RecognitionException {
		Limit_stmtContext _localctx = new Limit_stmtContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_limit_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1789);
			match(LIMIT_);
			setState(1790);
			expr(0);
			setState(1793);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA || _la==OFFSET_) {
				{
				setState(1791);
				_la = _input.LA(1);
				if ( !(_la==COMMA || _la==OFFSET_) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1792);
				expr(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ordering_termContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode COLLATE_() { return getToken(SQLiteParser.COLLATE_, 0); }
		public Collation_nameContext collation_name() {
			return getRuleContext(Collation_nameContext.class,0);
		}
		public Asc_descContext asc_desc() {
			return getRuleContext(Asc_descContext.class,0);
		}
		public TerminalNode NULLS_() { return getToken(SQLiteParser.NULLS_, 0); }
		public TerminalNode FIRST_() { return getToken(SQLiteParser.FIRST_, 0); }
		public TerminalNode LAST_() { return getToken(SQLiteParser.LAST_, 0); }
		public Ordering_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ordering_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterOrdering_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitOrdering_term(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitOrdering_term(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ordering_termContext ordering_term() throws RecognitionException {
		Ordering_termContext _localctx = new Ordering_termContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_ordering_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1795);
			expr(0);
			setState(1798);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLLATE_) {
				{
				setState(1796);
				match(COLLATE_);
				setState(1797);
				collation_name();
				}
			}

			setState(1801);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASC_ || _la==DESC_) {
				{
				setState(1800);
				asc_desc();
				}
			}

			setState(1805);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NULLS_) {
				{
				setState(1803);
				match(NULLS_);
				setState(1804);
				_la = _input.LA(1);
				if ( !(_la==FIRST_ || _la==LAST_) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Asc_descContext extends ParserRuleContext {
		public TerminalNode ASC_() { return getToken(SQLiteParser.ASC_, 0); }
		public TerminalNode DESC_() { return getToken(SQLiteParser.DESC_, 0); }
		public Asc_descContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asc_desc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterAsc_desc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitAsc_desc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitAsc_desc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Asc_descContext asc_desc() throws RecognitionException {
		Asc_descContext _localctx = new Asc_descContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_asc_desc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1807);
			_la = _input.LA(1);
			if ( !(_la==ASC_ || _la==DESC_) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Frame_leftContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PRECEDING_() { return getToken(SQLiteParser.PRECEDING_, 0); }
		public TerminalNode FOLLOWING_() { return getToken(SQLiteParser.FOLLOWING_, 0); }
		public TerminalNode CURRENT_() { return getToken(SQLiteParser.CURRENT_, 0); }
		public TerminalNode ROW_() { return getToken(SQLiteParser.ROW_, 0); }
		public TerminalNode UNBOUNDED_() { return getToken(SQLiteParser.UNBOUNDED_, 0); }
		public Frame_leftContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_frame_left; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterFrame_left(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitFrame_left(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitFrame_left(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Frame_leftContext frame_left() throws RecognitionException {
		Frame_leftContext _localctx = new Frame_leftContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_frame_left);
		try {
			setState(1819);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,266,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1809);
				expr(0);
				setState(1810);
				match(PRECEDING_);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1812);
				expr(0);
				setState(1813);
				match(FOLLOWING_);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1815);
				match(CURRENT_);
				setState(1816);
				match(ROW_);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1817);
				match(UNBOUNDED_);
				setState(1818);
				match(PRECEDING_);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Frame_rightContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PRECEDING_() { return getToken(SQLiteParser.PRECEDING_, 0); }
		public TerminalNode FOLLOWING_() { return getToken(SQLiteParser.FOLLOWING_, 0); }
		public TerminalNode CURRENT_() { return getToken(SQLiteParser.CURRENT_, 0); }
		public TerminalNode ROW_() { return getToken(SQLiteParser.ROW_, 0); }
		public TerminalNode UNBOUNDED_() { return getToken(SQLiteParser.UNBOUNDED_, 0); }
		public Frame_rightContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_frame_right; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterFrame_right(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitFrame_right(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitFrame_right(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Frame_rightContext frame_right() throws RecognitionException {
		Frame_rightContext _localctx = new Frame_rightContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_frame_right);
		try {
			setState(1831);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,267,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1821);
				expr(0);
				setState(1822);
				match(PRECEDING_);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1824);
				expr(0);
				setState(1825);
				match(FOLLOWING_);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1827);
				match(CURRENT_);
				setState(1828);
				match(ROW_);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1829);
				match(UNBOUNDED_);
				setState(1830);
				match(FOLLOWING_);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Frame_singleContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PRECEDING_() { return getToken(SQLiteParser.PRECEDING_, 0); }
		public TerminalNode UNBOUNDED_() { return getToken(SQLiteParser.UNBOUNDED_, 0); }
		public TerminalNode CURRENT_() { return getToken(SQLiteParser.CURRENT_, 0); }
		public TerminalNode ROW_() { return getToken(SQLiteParser.ROW_, 0); }
		public Frame_singleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_frame_single; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterFrame_single(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitFrame_single(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitFrame_single(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Frame_singleContext frame_single() throws RecognitionException {
		Frame_singleContext _localctx = new Frame_singleContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_frame_single);
		try {
			setState(1840);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,268,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1833);
				expr(0);
				setState(1834);
				match(PRECEDING_);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1836);
				match(UNBOUNDED_);
				setState(1837);
				match(PRECEDING_);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1838);
				match(CURRENT_);
				setState(1839);
				match(ROW_);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Window_functionContext extends ParserRuleContext {
		public List<TerminalNode> OPEN_PAR() { return getTokens(SQLiteParser.OPEN_PAR); }
		public TerminalNode OPEN_PAR(int i) {
			return getToken(SQLiteParser.OPEN_PAR, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> CLOSE_PAR() { return getTokens(SQLiteParser.CLOSE_PAR); }
		public TerminalNode CLOSE_PAR(int i) {
			return getToken(SQLiteParser.CLOSE_PAR, i);
		}
		public TerminalNode OVER_() { return getToken(SQLiteParser.OVER_, 0); }
		public Order_by_expr_asc_descContext order_by_expr_asc_desc() {
			return getRuleContext(Order_by_expr_asc_descContext.class,0);
		}
		public TerminalNode FIRST_VALUE_() { return getToken(SQLiteParser.FIRST_VALUE_, 0); }
		public TerminalNode LAST_VALUE_() { return getToken(SQLiteParser.LAST_VALUE_, 0); }
		public Partition_byContext partition_by() {
			return getRuleContext(Partition_byContext.class,0);
		}
		public Frame_clauseContext frame_clause() {
			return getRuleContext(Frame_clauseContext.class,0);
		}
		public TerminalNode CUME_DIST_() { return getToken(SQLiteParser.CUME_DIST_, 0); }
		public TerminalNode PERCENT_RANK_() { return getToken(SQLiteParser.PERCENT_RANK_, 0); }
		public Order_by_exprContext order_by_expr() {
			return getRuleContext(Order_by_exprContext.class,0);
		}
		public TerminalNode DENSE_RANK_() { return getToken(SQLiteParser.DENSE_RANK_, 0); }
		public TerminalNode RANK_() { return getToken(SQLiteParser.RANK_, 0); }
		public TerminalNode ROW_NUMBER_() { return getToken(SQLiteParser.ROW_NUMBER_, 0); }
		public TerminalNode LAG_() { return getToken(SQLiteParser.LAG_, 0); }
		public TerminalNode LEAD_() { return getToken(SQLiteParser.LEAD_, 0); }
		public Of_OF_fsetContext of_OF_fset() {
			return getRuleContext(Of_OF_fsetContext.class,0);
		}
		public Default_DEFAULT__valueContext default_DEFAULT__value() {
			return getRuleContext(Default_DEFAULT__valueContext.class,0);
		}
		public TerminalNode NTH_VALUE_() { return getToken(SQLiteParser.NTH_VALUE_, 0); }
		public TerminalNode COMMA() { return getToken(SQLiteParser.COMMA, 0); }
		public Signed_numberContext signed_number() {
			return getRuleContext(Signed_numberContext.class,0);
		}
		public TerminalNode NTILE_() { return getToken(SQLiteParser.NTILE_, 0); }
		public Window_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_window_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterWindow_function(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitWindow_function(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitWindow_function(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Window_functionContext window_function() throws RecognitionException {
		Window_functionContext _localctx = new Window_functionContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_window_function);
		int _la;
		try {
			setState(1927);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FIRST_VALUE_:
			case LAST_VALUE_:
				enterOuterAlt(_localctx, 1);
				{
				setState(1842);
				_la = _input.LA(1);
				if ( !(_la==FIRST_VALUE_ || _la==LAST_VALUE_) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1843);
				match(OPEN_PAR);
				setState(1844);
				expr(0);
				setState(1845);
				match(CLOSE_PAR);
				setState(1846);
				match(OVER_);
				setState(1847);
				match(OPEN_PAR);
				setState(1849);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION_) {
					{
					setState(1848);
					partition_by();
					}
				}

				setState(1851);
				order_by_expr_asc_desc();
				setState(1853);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 127)) & ~0x3f) == 0 && ((1L << (_la - 127)) & ((1L << (ROWS_ - 127)) | (1L << (RANGE_ - 127)) | (1L << (GROUPS_ - 127)))) != 0)) {
					{
					setState(1852);
					frame_clause();
					}
				}

				setState(1855);
				match(CLOSE_PAR);
				}
				break;
			case CUME_DIST_:
			case PERCENT_RANK_:
				enterOuterAlt(_localctx, 2);
				{
				setState(1857);
				_la = _input.LA(1);
				if ( !(_la==CUME_DIST_ || _la==PERCENT_RANK_) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1858);
				match(OPEN_PAR);
				setState(1859);
				match(CLOSE_PAR);
				setState(1860);
				match(OVER_);
				setState(1861);
				match(OPEN_PAR);
				setState(1863);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION_) {
					{
					setState(1862);
					partition_by();
					}
				}

				setState(1866);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ORDER_) {
					{
					setState(1865);
					order_by_expr();
					}
				}

				setState(1868);
				match(CLOSE_PAR);
				}
				break;
			case DENSE_RANK_:
			case RANK_:
			case ROW_NUMBER_:
				enterOuterAlt(_localctx, 3);
				{
				setState(1869);
				_la = _input.LA(1);
				if ( !(((((_la - 159)) & ~0x3f) == 0 && ((1L << (_la - 159)) & ((1L << (DENSE_RANK_ - 159)) | (1L << (RANK_ - 159)) | (1L << (ROW_NUMBER_ - 159)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1870);
				match(OPEN_PAR);
				setState(1871);
				match(CLOSE_PAR);
				setState(1872);
				match(OVER_);
				setState(1873);
				match(OPEN_PAR);
				setState(1875);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION_) {
					{
					setState(1874);
					partition_by();
					}
				}

				setState(1877);
				order_by_expr_asc_desc();
				setState(1878);
				match(CLOSE_PAR);
				}
				break;
			case LAG_:
			case LEAD_:
				enterOuterAlt(_localctx, 4);
				{
				setState(1880);
				_la = _input.LA(1);
				if ( !(_la==LAG_ || _la==LEAD_) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1881);
				match(OPEN_PAR);
				setState(1882);
				expr(0);
				setState(1884);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,274,_ctx) ) {
				case 1:
					{
					setState(1883);
					of_OF_fset();
					}
					break;
				}
				setState(1887);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1886);
					default_DEFAULT__value();
					}
				}

				setState(1889);
				match(CLOSE_PAR);
				setState(1890);
				match(OVER_);
				setState(1891);
				match(OPEN_PAR);
				setState(1893);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION_) {
					{
					setState(1892);
					partition_by();
					}
				}

				setState(1895);
				order_by_expr_asc_desc();
				setState(1896);
				match(CLOSE_PAR);
				}
				break;
			case NTH_VALUE_:
				enterOuterAlt(_localctx, 5);
				{
				setState(1898);
				match(NTH_VALUE_);
				setState(1899);
				match(OPEN_PAR);
				setState(1900);
				expr(0);
				setState(1901);
				match(COMMA);
				setState(1902);
				signed_number();
				setState(1903);
				match(CLOSE_PAR);
				setState(1904);
				match(OVER_);
				setState(1905);
				match(OPEN_PAR);
				setState(1907);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION_) {
					{
					setState(1906);
					partition_by();
					}
				}

				setState(1909);
				order_by_expr_asc_desc();
				setState(1911);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 127)) & ~0x3f) == 0 && ((1L << (_la - 127)) & ((1L << (ROWS_ - 127)) | (1L << (RANGE_ - 127)) | (1L << (GROUPS_ - 127)))) != 0)) {
					{
					setState(1910);
					frame_clause();
					}
				}

				setState(1913);
				match(CLOSE_PAR);
				}
				break;
			case NTILE_:
				enterOuterAlt(_localctx, 6);
				{
				setState(1915);
				match(NTILE_);
				setState(1916);
				match(OPEN_PAR);
				setState(1917);
				expr(0);
				setState(1918);
				match(CLOSE_PAR);
				setState(1919);
				match(OVER_);
				setState(1920);
				match(OPEN_PAR);
				setState(1922);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION_) {
					{
					setState(1921);
					partition_by();
					}
				}

				setState(1924);
				order_by_expr_asc_desc();
				setState(1925);
				match(CLOSE_PAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Of_OF_fsetContext extends ParserRuleContext {
		public TerminalNode COMMA() { return getToken(SQLiteParser.COMMA, 0); }
		public Signed_numberContext signed_number() {
			return getRuleContext(Signed_numberContext.class,0);
		}
		public Of_OF_fsetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_of_OF_fset; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterOf_OF_fset(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitOf_OF_fset(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitOf_OF_fset(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Of_OF_fsetContext of_OF_fset() throws RecognitionException {
		Of_OF_fsetContext _localctx = new Of_OF_fsetContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_of_OF_fset);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1929);
			match(COMMA);
			setState(1930);
			signed_number();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Default_DEFAULT__valueContext extends ParserRuleContext {
		public TerminalNode COMMA() { return getToken(SQLiteParser.COMMA, 0); }
		public Signed_numberContext signed_number() {
			return getRuleContext(Signed_numberContext.class,0);
		}
		public Default_DEFAULT__valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_default_DEFAULT__value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterDefault_DEFAULT__value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitDefault_DEFAULT__value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitDefault_DEFAULT__value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Default_DEFAULT__valueContext default_DEFAULT__value() throws RecognitionException {
		Default_DEFAULT__valueContext _localctx = new Default_DEFAULT__valueContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_default_DEFAULT__value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1932);
			match(COMMA);
			setState(1933);
			signed_number();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Partition_byContext extends ParserRuleContext {
		public TerminalNode PARTITION_() { return getToken(SQLiteParser.PARTITION_, 0); }
		public TerminalNode BY_() { return getToken(SQLiteParser.BY_, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Partition_byContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partition_by; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterPartition_by(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitPartition_by(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitPartition_by(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Partition_byContext partition_by() throws RecognitionException {
		Partition_byContext _localctx = new Partition_byContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_partition_by);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1935);
			match(PARTITION_);
			setState(1936);
			match(BY_);
			setState(1938); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1937);
					expr(0);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1940); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,281,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Order_by_exprContext extends ParserRuleContext {
		public TerminalNode ORDER_() { return getToken(SQLiteParser.ORDER_, 0); }
		public TerminalNode BY_() { return getToken(SQLiteParser.BY_, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Order_by_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_order_by_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterOrder_by_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitOrder_by_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitOrder_by_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Order_by_exprContext order_by_expr() throws RecognitionException {
		Order_by_exprContext _localctx = new Order_by_exprContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_order_by_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1942);
			match(ORDER_);
			setState(1943);
			match(BY_);
			setState(1945); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1944);
				expr(0);
				}
				}
				setState(1947); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN_PAR) | (1L << PLUS) | (1L << MINUS) | (1L << TILDE) | (1L << ABORT_) | (1L << ACTION_) | (1L << ADD_) | (1L << AFTER_) | (1L << ALL_) | (1L << ALTER_) | (1L << ANALYZE_) | (1L << AND_) | (1L << AS_) | (1L << ASC_) | (1L << ATTACH_) | (1L << AUTOINCREMENT_) | (1L << BEFORE_) | (1L << BEGIN_) | (1L << BETWEEN_) | (1L << BY_) | (1L << CASCADE_) | (1L << CASE_) | (1L << CAST_) | (1L << CHECK_) | (1L << COLLATE_) | (1L << COLUMN_) | (1L << COMMIT_) | (1L << CONFLICT_) | (1L << CONSTRAINT_) | (1L << CREATE_) | (1L << CROSS_) | (1L << CURRENT_DATE_) | (1L << CURRENT_TIME_) | (1L << CURRENT_TIMESTAMP_) | (1L << DATABASE_) | (1L << DEFAULT_) | (1L << DEFERRABLE_) | (1L << DEFERRED_) | (1L << DELETE_) | (1L << DESC_) | (1L << DETACH_) | (1L << DISTINCT_) | (1L << DROP_))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (EACH_ - 64)) | (1L << (ELSE_ - 64)) | (1L << (END_ - 64)) | (1L << (ESCAPE_ - 64)) | (1L << (EXCEPT_ - 64)) | (1L << (EXCLUSIVE_ - 64)) | (1L << (EXISTS_ - 64)) | (1L << (EXPLAIN_ - 64)) | (1L << (FAIL_ - 64)) | (1L << (FOR_ - 64)) | (1L << (FOREIGN_ - 64)) | (1L << (FROM_ - 64)) | (1L << (FULL_ - 64)) | (1L << (GLOB_ - 64)) | (1L << (GROUP_ - 64)) | (1L << (HAVING_ - 64)) | (1L << (IF_ - 64)) | (1L << (IGNORE_ - 64)) | (1L << (IMMEDIATE_ - 64)) | (1L << (IN_ - 64)) | (1L << (INDEX_ - 64)) | (1L << (INDEXED_ - 64)) | (1L << (INITIALLY_ - 64)) | (1L << (INNER_ - 64)) | (1L << (INSERT_ - 64)) | (1L << (INSTEAD_ - 64)) | (1L << (INTERSECT_ - 64)) | (1L << (INTO_ - 64)) | (1L << (IS_ - 64)) | (1L << (ISNULL_ - 64)) | (1L << (JOIN_ - 64)) | (1L << (KEY_ - 64)) | (1L << (LEFT_ - 64)) | (1L << (LIKE_ - 64)) | (1L << (LIMIT_ - 64)) | (1L << (MATCH_ - 64)) | (1L << (NATURAL_ - 64)) | (1L << (NO_ - 64)) | (1L << (NOT_ - 64)) | (1L << (NOTNULL_ - 64)) | (1L << (NULL_ - 64)) | (1L << (OF_ - 64)) | (1L << (OFFSET_ - 64)) | (1L << (ON_ - 64)) | (1L << (OR_ - 64)) | (1L << (ORDER_ - 64)) | (1L << (OUTER_ - 64)) | (1L << (PLAN_ - 64)) | (1L << (PRAGMA_ - 64)) | (1L << (PRIMARY_ - 64)) | (1L << (QUERY_ - 64)) | (1L << (RAISE_ - 64)) | (1L << (RECURSIVE_ - 64)) | (1L << (REFERENCES_ - 64)) | (1L << (REGEXP_ - 64)) | (1L << (REINDEX_ - 64)) | (1L << (RELEASE_ - 64)) | (1L << (RENAME_ - 64)) | (1L << (REPLACE_ - 64)) | (1L << (RESTRICT_ - 64)) | (1L << (RIGHT_ - 64)) | (1L << (ROLLBACK_ - 64)) | (1L << (ROW_ - 64)) | (1L << (ROWS_ - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (SAVEPOINT_ - 128)) | (1L << (SELECT_ - 128)) | (1L << (SET_ - 128)) | (1L << (TABLE_ - 128)) | (1L << (TEMP_ - 128)) | (1L << (TEMPORARY_ - 128)) | (1L << (THEN_ - 128)) | (1L << (TO_ - 128)) | (1L << (TRANSACTION_ - 128)) | (1L << (TRIGGER_ - 128)) | (1L << (UNION_ - 128)) | (1L << (UNIQUE_ - 128)) | (1L << (UPDATE_ - 128)) | (1L << (USING_ - 128)) | (1L << (VACUUM_ - 128)) | (1L << (VALUES_ - 128)) | (1L << (VIEW_ - 128)) | (1L << (VIRTUAL_ - 128)) | (1L << (WHEN_ - 128)) | (1L << (WHERE_ - 128)) | (1L << (WITH_ - 128)) | (1L << (WITHOUT_ - 128)) | (1L << (FIRST_VALUE_ - 128)) | (1L << (OVER_ - 128)) | (1L << (PARTITION_ - 128)) | (1L << (RANGE_ - 128)) | (1L << (PRECEDING_ - 128)) | (1L << (UNBOUNDED_ - 128)) | (1L << (CURRENT_ - 128)) | (1L << (FOLLOWING_ - 128)) | (1L << (CUME_DIST_ - 128)) | (1L << (DENSE_RANK_ - 128)) | (1L << (LAG_ - 128)) | (1L << (LAST_VALUE_ - 128)) | (1L << (LEAD_ - 128)) | (1L << (NTH_VALUE_ - 128)) | (1L << (NTILE_ - 128)) | (1L << (PERCENT_RANK_ - 128)) | (1L << (RANK_ - 128)) | (1L << (ROW_NUMBER_ - 128)) | (1L << (GENERATED_ - 128)) | (1L << (ALWAYS_ - 128)) | (1L << (STORED_ - 128)) | (1L << (TRUE_ - 128)) | (1L << (FALSE_ - 128)) | (1L << (WINDOW_ - 128)) | (1L << (NULLS_ - 128)) | (1L << (FIRST_ - 128)) | (1L << (LAST_ - 128)) | (1L << (FILTER_ - 128)) | (1L << (GROUPS_ - 128)) | (1L << (EXCLUDE_ - 128)) | (1L << (IDENTIFIER - 128)) | (1L << (NUMERIC_LITERAL - 128)) | (1L << (BIND_PARAMETER - 128)) | (1L << (STRING_LITERAL - 128)) | (1L << (BLOB_LITERAL - 128)))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Order_by_expr_asc_descContext extends ParserRuleContext {
		public TerminalNode ORDER_() { return getToken(SQLiteParser.ORDER_, 0); }
		public TerminalNode BY_() { return getToken(SQLiteParser.BY_, 0); }
		public Order_by_expr_asc_descContext order_by_expr_asc_desc() {
			return getRuleContext(Order_by_expr_asc_descContext.class,0);
		}
		public Order_by_expr_asc_descContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_order_by_expr_asc_desc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterOrder_by_expr_asc_desc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitOrder_by_expr_asc_desc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitOrder_by_expr_asc_desc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Order_by_expr_asc_descContext order_by_expr_asc_desc() throws RecognitionException {
		Order_by_expr_asc_descContext _localctx = new Order_by_expr_asc_descContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_order_by_expr_asc_desc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1949);
			match(ORDER_);
			setState(1950);
			match(BY_);
			setState(1951);
			order_by_expr_asc_desc();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr_asc_descContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<Asc_descContext> asc_desc() {
			return getRuleContexts(Asc_descContext.class);
		}
		public Asc_descContext asc_desc(int i) {
			return getRuleContext(Asc_descContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Expr_asc_descContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_asc_desc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterExpr_asc_desc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitExpr_asc_desc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitExpr_asc_desc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_asc_descContext expr_asc_desc() throws RecognitionException {
		Expr_asc_descContext _localctx = new Expr_asc_descContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_expr_asc_desc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1953);
			expr(0);
			setState(1955);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASC_ || _la==DESC_) {
				{
				setState(1954);
				asc_desc();
				}
			}

			setState(1964);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1957);
				match(COMMA);
				setState(1958);
				expr(0);
				setState(1960);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASC_ || _la==DESC_) {
					{
					setState(1959);
					asc_desc();
					}
				}

				}
				}
				setState(1966);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Initial_selectContext extends ParserRuleContext {
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public Initial_selectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initial_select; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterInitial_select(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitInitial_select(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitInitial_select(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Initial_selectContext initial_select() throws RecognitionException {
		Initial_selectContext _localctx = new Initial_selectContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_initial_select);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1967);
			select_stmt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Recursive__selectContext extends ParserRuleContext {
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public Recursive__selectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recursive__select; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterRecursive__select(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitRecursive__select(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitRecursive__select(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Recursive__selectContext recursive__select() throws RecognitionException {
		Recursive__selectContext _localctx = new Recursive__selectContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_recursive__select);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1969);
			select_stmt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Unary_operatorContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(SQLiteParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(SQLiteParser.PLUS, 0); }
		public TerminalNode TILDE() { return getToken(SQLiteParser.TILDE, 0); }
		public TerminalNode NOT_() { return getToken(SQLiteParser.NOT_, 0); }
		public Unary_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterUnary_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitUnary_operator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitUnary_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unary_operatorContext unary_operator() throws RecognitionException {
		Unary_operatorContext _localctx = new Unary_operatorContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_unary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1971);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << TILDE))) != 0) || _la==NOT_) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Error_messageContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(SQLiteParser.STRING_LITERAL, 0); }
		public Error_messageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_error_message; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterError_message(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitError_message(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitError_message(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Error_messageContext error_message() throws RecognitionException {
		Error_messageContext _localctx = new Error_messageContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_error_message);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1973);
			match(STRING_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Module_argumentContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Column_defContext column_def() {
			return getRuleContext(Column_defContext.class,0);
		}
		public Module_argumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterModule_argument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitModule_argument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitModule_argument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Module_argumentContext module_argument() throws RecognitionException {
		Module_argumentContext _localctx = new Module_argumentContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_module_argument);
		try {
			setState(1977);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,286,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1975);
				expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1976);
				column_def();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Column_aliasContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SQLiteParser.IDENTIFIER, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(SQLiteParser.STRING_LITERAL, 0); }
		public Column_aliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_alias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterColumn_alias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitColumn_alias(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitColumn_alias(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Column_aliasContext column_alias() throws RecognitionException {
		Column_aliasContext _localctx = new Column_aliasContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_column_alias);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1979);
			_la = _input.LA(1);
			if ( !(_la==IDENTIFIER || _la==STRING_LITERAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeywordContext extends ParserRuleContext {
		public TerminalNode ABORT_() { return getToken(SQLiteParser.ABORT_, 0); }
		public TerminalNode ACTION_() { return getToken(SQLiteParser.ACTION_, 0); }
		public TerminalNode ADD_() { return getToken(SQLiteParser.ADD_, 0); }
		public TerminalNode AFTER_() { return getToken(SQLiteParser.AFTER_, 0); }
		public TerminalNode ALL_() { return getToken(SQLiteParser.ALL_, 0); }
		public TerminalNode ALTER_() { return getToken(SQLiteParser.ALTER_, 0); }
		public TerminalNode ANALYZE_() { return getToken(SQLiteParser.ANALYZE_, 0); }
		public TerminalNode AND_() { return getToken(SQLiteParser.AND_, 0); }
		public TerminalNode AS_() { return getToken(SQLiteParser.AS_, 0); }
		public TerminalNode ASC_() { return getToken(SQLiteParser.ASC_, 0); }
		public TerminalNode ATTACH_() { return getToken(SQLiteParser.ATTACH_, 0); }
		public TerminalNode AUTOINCREMENT_() { return getToken(SQLiteParser.AUTOINCREMENT_, 0); }
		public TerminalNode BEFORE_() { return getToken(SQLiteParser.BEFORE_, 0); }
		public TerminalNode BEGIN_() { return getToken(SQLiteParser.BEGIN_, 0); }
		public TerminalNode BETWEEN_() { return getToken(SQLiteParser.BETWEEN_, 0); }
		public TerminalNode BY_() { return getToken(SQLiteParser.BY_, 0); }
		public TerminalNode CASCADE_() { return getToken(SQLiteParser.CASCADE_, 0); }
		public TerminalNode CASE_() { return getToken(SQLiteParser.CASE_, 0); }
		public TerminalNode CAST_() { return getToken(SQLiteParser.CAST_, 0); }
		public TerminalNode CHECK_() { return getToken(SQLiteParser.CHECK_, 0); }
		public TerminalNode COLLATE_() { return getToken(SQLiteParser.COLLATE_, 0); }
		public TerminalNode COLUMN_() { return getToken(SQLiteParser.COLUMN_, 0); }
		public TerminalNode COMMIT_() { return getToken(SQLiteParser.COMMIT_, 0); }
		public TerminalNode CONFLICT_() { return getToken(SQLiteParser.CONFLICT_, 0); }
		public TerminalNode CONSTRAINT_() { return getToken(SQLiteParser.CONSTRAINT_, 0); }
		public TerminalNode CREATE_() { return getToken(SQLiteParser.CREATE_, 0); }
		public TerminalNode CROSS_() { return getToken(SQLiteParser.CROSS_, 0); }
		public TerminalNode CURRENT_DATE_() { return getToken(SQLiteParser.CURRENT_DATE_, 0); }
		public TerminalNode CURRENT_TIME_() { return getToken(SQLiteParser.CURRENT_TIME_, 0); }
		public TerminalNode CURRENT_TIMESTAMP_() { return getToken(SQLiteParser.CURRENT_TIMESTAMP_, 0); }
		public TerminalNode DATABASE_() { return getToken(SQLiteParser.DATABASE_, 0); }
		public TerminalNode DEFAULT_() { return getToken(SQLiteParser.DEFAULT_, 0); }
		public TerminalNode DEFERRABLE_() { return getToken(SQLiteParser.DEFERRABLE_, 0); }
		public TerminalNode DEFERRED_() { return getToken(SQLiteParser.DEFERRED_, 0); }
		public TerminalNode DELETE_() { return getToken(SQLiteParser.DELETE_, 0); }
		public TerminalNode DESC_() { return getToken(SQLiteParser.DESC_, 0); }
		public TerminalNode DETACH_() { return getToken(SQLiteParser.DETACH_, 0); }
		public TerminalNode DISTINCT_() { return getToken(SQLiteParser.DISTINCT_, 0); }
		public TerminalNode DROP_() { return getToken(SQLiteParser.DROP_, 0); }
		public TerminalNode EACH_() { return getToken(SQLiteParser.EACH_, 0); }
		public TerminalNode ELSE_() { return getToken(SQLiteParser.ELSE_, 0); }
		public TerminalNode END_() { return getToken(SQLiteParser.END_, 0); }
		public TerminalNode ESCAPE_() { return getToken(SQLiteParser.ESCAPE_, 0); }
		public TerminalNode EXCEPT_() { return getToken(SQLiteParser.EXCEPT_, 0); }
		public TerminalNode EXCLUSIVE_() { return getToken(SQLiteParser.EXCLUSIVE_, 0); }
		public TerminalNode EXISTS_() { return getToken(SQLiteParser.EXISTS_, 0); }
		public TerminalNode EXPLAIN_() { return getToken(SQLiteParser.EXPLAIN_, 0); }
		public TerminalNode FAIL_() { return getToken(SQLiteParser.FAIL_, 0); }
		public TerminalNode FOR_() { return getToken(SQLiteParser.FOR_, 0); }
		public TerminalNode FOREIGN_() { return getToken(SQLiteParser.FOREIGN_, 0); }
		public TerminalNode FROM_() { return getToken(SQLiteParser.FROM_, 0); }
		public TerminalNode FULL_() { return getToken(SQLiteParser.FULL_, 0); }
		public TerminalNode GLOB_() { return getToken(SQLiteParser.GLOB_, 0); }
		public TerminalNode GROUP_() { return getToken(SQLiteParser.GROUP_, 0); }
		public TerminalNode HAVING_() { return getToken(SQLiteParser.HAVING_, 0); }
		public TerminalNode IF_() { return getToken(SQLiteParser.IF_, 0); }
		public TerminalNode IGNORE_() { return getToken(SQLiteParser.IGNORE_, 0); }
		public TerminalNode IMMEDIATE_() { return getToken(SQLiteParser.IMMEDIATE_, 0); }
		public TerminalNode IN_() { return getToken(SQLiteParser.IN_, 0); }
		public TerminalNode INDEX_() { return getToken(SQLiteParser.INDEX_, 0); }
		public TerminalNode INDEXED_() { return getToken(SQLiteParser.INDEXED_, 0); }
		public TerminalNode INITIALLY_() { return getToken(SQLiteParser.INITIALLY_, 0); }
		public TerminalNode INNER_() { return getToken(SQLiteParser.INNER_, 0); }
		public TerminalNode INSERT_() { return getToken(SQLiteParser.INSERT_, 0); }
		public TerminalNode INSTEAD_() { return getToken(SQLiteParser.INSTEAD_, 0); }
		public TerminalNode INTERSECT_() { return getToken(SQLiteParser.INTERSECT_, 0); }
		public TerminalNode INTO_() { return getToken(SQLiteParser.INTO_, 0); }
		public TerminalNode IS_() { return getToken(SQLiteParser.IS_, 0); }
		public TerminalNode ISNULL_() { return getToken(SQLiteParser.ISNULL_, 0); }
		public TerminalNode JOIN_() { return getToken(SQLiteParser.JOIN_, 0); }
		public TerminalNode KEY_() { return getToken(SQLiteParser.KEY_, 0); }
		public TerminalNode LEFT_() { return getToken(SQLiteParser.LEFT_, 0); }
		public TerminalNode LIKE_() { return getToken(SQLiteParser.LIKE_, 0); }
		public TerminalNode LIMIT_() { return getToken(SQLiteParser.LIMIT_, 0); }
		public TerminalNode MATCH_() { return getToken(SQLiteParser.MATCH_, 0); }
		public TerminalNode NATURAL_() { return getToken(SQLiteParser.NATURAL_, 0); }
		public TerminalNode NO_() { return getToken(SQLiteParser.NO_, 0); }
		public TerminalNode NOT_() { return getToken(SQLiteParser.NOT_, 0); }
		public TerminalNode NOTNULL_() { return getToken(SQLiteParser.NOTNULL_, 0); }
		public TerminalNode NULL_() { return getToken(SQLiteParser.NULL_, 0); }
		public TerminalNode OF_() { return getToken(SQLiteParser.OF_, 0); }
		public TerminalNode OFFSET_() { return getToken(SQLiteParser.OFFSET_, 0); }
		public TerminalNode ON_() { return getToken(SQLiteParser.ON_, 0); }
		public TerminalNode OR_() { return getToken(SQLiteParser.OR_, 0); }
		public TerminalNode ORDER_() { return getToken(SQLiteParser.ORDER_, 0); }
		public TerminalNode OUTER_() { return getToken(SQLiteParser.OUTER_, 0); }
		public TerminalNode PLAN_() { return getToken(SQLiteParser.PLAN_, 0); }
		public TerminalNode PRAGMA_() { return getToken(SQLiteParser.PRAGMA_, 0); }
		public TerminalNode PRIMARY_() { return getToken(SQLiteParser.PRIMARY_, 0); }
		public TerminalNode QUERY_() { return getToken(SQLiteParser.QUERY_, 0); }
		public TerminalNode RAISE_() { return getToken(SQLiteParser.RAISE_, 0); }
		public TerminalNode RECURSIVE_() { return getToken(SQLiteParser.RECURSIVE_, 0); }
		public TerminalNode REFERENCES_() { return getToken(SQLiteParser.REFERENCES_, 0); }
		public TerminalNode REGEXP_() { return getToken(SQLiteParser.REGEXP_, 0); }
		public TerminalNode REINDEX_() { return getToken(SQLiteParser.REINDEX_, 0); }
		public TerminalNode RELEASE_() { return getToken(SQLiteParser.RELEASE_, 0); }
		public TerminalNode RENAME_() { return getToken(SQLiteParser.RENAME_, 0); }
		public TerminalNode REPLACE_() { return getToken(SQLiteParser.REPLACE_, 0); }
		public TerminalNode RESTRICT_() { return getToken(SQLiteParser.RESTRICT_, 0); }
		public TerminalNode RIGHT_() { return getToken(SQLiteParser.RIGHT_, 0); }
		public TerminalNode ROLLBACK_() { return getToken(SQLiteParser.ROLLBACK_, 0); }
		public TerminalNode ROW_() { return getToken(SQLiteParser.ROW_, 0); }
		public TerminalNode ROWS_() { return getToken(SQLiteParser.ROWS_, 0); }
		public TerminalNode SAVEPOINT_() { return getToken(SQLiteParser.SAVEPOINT_, 0); }
		public TerminalNode SELECT_() { return getToken(SQLiteParser.SELECT_, 0); }
		public TerminalNode SET_() { return getToken(SQLiteParser.SET_, 0); }
		public TerminalNode TABLE_() { return getToken(SQLiteParser.TABLE_, 0); }
		public TerminalNode TEMP_() { return getToken(SQLiteParser.TEMP_, 0); }
		public TerminalNode TEMPORARY_() { return getToken(SQLiteParser.TEMPORARY_, 0); }
		public TerminalNode THEN_() { return getToken(SQLiteParser.THEN_, 0); }
		public TerminalNode TO_() { return getToken(SQLiteParser.TO_, 0); }
		public TerminalNode TRANSACTION_() { return getToken(SQLiteParser.TRANSACTION_, 0); }
		public TerminalNode TRIGGER_() { return getToken(SQLiteParser.TRIGGER_, 0); }
		public TerminalNode UNION_() { return getToken(SQLiteParser.UNION_, 0); }
		public TerminalNode UNIQUE_() { return getToken(SQLiteParser.UNIQUE_, 0); }
		public TerminalNode UPDATE_() { return getToken(SQLiteParser.UPDATE_, 0); }
		public TerminalNode USING_() { return getToken(SQLiteParser.USING_, 0); }
		public TerminalNode VACUUM_() { return getToken(SQLiteParser.VACUUM_, 0); }
		public TerminalNode VALUES_() { return getToken(SQLiteParser.VALUES_, 0); }
		public TerminalNode VIEW_() { return getToken(SQLiteParser.VIEW_, 0); }
		public TerminalNode VIRTUAL_() { return getToken(SQLiteParser.VIRTUAL_, 0); }
		public TerminalNode WHEN_() { return getToken(SQLiteParser.WHEN_, 0); }
		public TerminalNode WHERE_() { return getToken(SQLiteParser.WHERE_, 0); }
		public TerminalNode WITH_() { return getToken(SQLiteParser.WITH_, 0); }
		public TerminalNode WITHOUT_() { return getToken(SQLiteParser.WITHOUT_, 0); }
		public TerminalNode FIRST_VALUE_() { return getToken(SQLiteParser.FIRST_VALUE_, 0); }
		public TerminalNode OVER_() { return getToken(SQLiteParser.OVER_, 0); }
		public TerminalNode PARTITION_() { return getToken(SQLiteParser.PARTITION_, 0); }
		public TerminalNode RANGE_() { return getToken(SQLiteParser.RANGE_, 0); }
		public TerminalNode PRECEDING_() { return getToken(SQLiteParser.PRECEDING_, 0); }
		public TerminalNode UNBOUNDED_() { return getToken(SQLiteParser.UNBOUNDED_, 0); }
		public TerminalNode CURRENT_() { return getToken(SQLiteParser.CURRENT_, 0); }
		public TerminalNode FOLLOWING_() { return getToken(SQLiteParser.FOLLOWING_, 0); }
		public TerminalNode CUME_DIST_() { return getToken(SQLiteParser.CUME_DIST_, 0); }
		public TerminalNode DENSE_RANK_() { return getToken(SQLiteParser.DENSE_RANK_, 0); }
		public TerminalNode LAG_() { return getToken(SQLiteParser.LAG_, 0); }
		public TerminalNode LAST_VALUE_() { return getToken(SQLiteParser.LAST_VALUE_, 0); }
		public TerminalNode LEAD_() { return getToken(SQLiteParser.LEAD_, 0); }
		public TerminalNode NTH_VALUE_() { return getToken(SQLiteParser.NTH_VALUE_, 0); }
		public TerminalNode NTILE_() { return getToken(SQLiteParser.NTILE_, 0); }
		public TerminalNode PERCENT_RANK_() { return getToken(SQLiteParser.PERCENT_RANK_, 0); }
		public TerminalNode RANK_() { return getToken(SQLiteParser.RANK_, 0); }
		public TerminalNode ROW_NUMBER_() { return getToken(SQLiteParser.ROW_NUMBER_, 0); }
		public TerminalNode GENERATED_() { return getToken(SQLiteParser.GENERATED_, 0); }
		public TerminalNode ALWAYS_() { return getToken(SQLiteParser.ALWAYS_, 0); }
		public TerminalNode STORED_() { return getToken(SQLiteParser.STORED_, 0); }
		public TerminalNode TRUE_() { return getToken(SQLiteParser.TRUE_, 0); }
		public TerminalNode FALSE_() { return getToken(SQLiteParser.FALSE_, 0); }
		public TerminalNode WINDOW_() { return getToken(SQLiteParser.WINDOW_, 0); }
		public TerminalNode NULLS_() { return getToken(SQLiteParser.NULLS_, 0); }
		public TerminalNode FIRST_() { return getToken(SQLiteParser.FIRST_, 0); }
		public TerminalNode LAST_() { return getToken(SQLiteParser.LAST_, 0); }
		public TerminalNode FILTER_() { return getToken(SQLiteParser.FILTER_, 0); }
		public TerminalNode GROUPS_() { return getToken(SQLiteParser.GROUPS_, 0); }
		public TerminalNode EXCLUDE_() { return getToken(SQLiteParser.EXCLUDE_, 0); }
		public KeywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterKeyword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitKeyword(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitKeyword(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeywordContext keyword() throws RecognitionException {
		KeywordContext _localctx = new KeywordContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_keyword);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1981);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABORT_) | (1L << ACTION_) | (1L << ADD_) | (1L << AFTER_) | (1L << ALL_) | (1L << ALTER_) | (1L << ANALYZE_) | (1L << AND_) | (1L << AS_) | (1L << ASC_) | (1L << ATTACH_) | (1L << AUTOINCREMENT_) | (1L << BEFORE_) | (1L << BEGIN_) | (1L << BETWEEN_) | (1L << BY_) | (1L << CASCADE_) | (1L << CASE_) | (1L << CAST_) | (1L << CHECK_) | (1L << COLLATE_) | (1L << COLUMN_) | (1L << COMMIT_) | (1L << CONFLICT_) | (1L << CONSTRAINT_) | (1L << CREATE_) | (1L << CROSS_) | (1L << CURRENT_DATE_) | (1L << CURRENT_TIME_) | (1L << CURRENT_TIMESTAMP_) | (1L << DATABASE_) | (1L << DEFAULT_) | (1L << DEFERRABLE_) | (1L << DEFERRED_) | (1L << DELETE_) | (1L << DESC_) | (1L << DETACH_) | (1L << DISTINCT_) | (1L << DROP_))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (EACH_ - 64)) | (1L << (ELSE_ - 64)) | (1L << (END_ - 64)) | (1L << (ESCAPE_ - 64)) | (1L << (EXCEPT_ - 64)) | (1L << (EXCLUSIVE_ - 64)) | (1L << (EXISTS_ - 64)) | (1L << (EXPLAIN_ - 64)) | (1L << (FAIL_ - 64)) | (1L << (FOR_ - 64)) | (1L << (FOREIGN_ - 64)) | (1L << (FROM_ - 64)) | (1L << (FULL_ - 64)) | (1L << (GLOB_ - 64)) | (1L << (GROUP_ - 64)) | (1L << (HAVING_ - 64)) | (1L << (IF_ - 64)) | (1L << (IGNORE_ - 64)) | (1L << (IMMEDIATE_ - 64)) | (1L << (IN_ - 64)) | (1L << (INDEX_ - 64)) | (1L << (INDEXED_ - 64)) | (1L << (INITIALLY_ - 64)) | (1L << (INNER_ - 64)) | (1L << (INSERT_ - 64)) | (1L << (INSTEAD_ - 64)) | (1L << (INTERSECT_ - 64)) | (1L << (INTO_ - 64)) | (1L << (IS_ - 64)) | (1L << (ISNULL_ - 64)) | (1L << (JOIN_ - 64)) | (1L << (KEY_ - 64)) | (1L << (LEFT_ - 64)) | (1L << (LIKE_ - 64)) | (1L << (LIMIT_ - 64)) | (1L << (MATCH_ - 64)) | (1L << (NATURAL_ - 64)) | (1L << (NO_ - 64)) | (1L << (NOT_ - 64)) | (1L << (NOTNULL_ - 64)) | (1L << (NULL_ - 64)) | (1L << (OF_ - 64)) | (1L << (OFFSET_ - 64)) | (1L << (ON_ - 64)) | (1L << (OR_ - 64)) | (1L << (ORDER_ - 64)) | (1L << (OUTER_ - 64)) | (1L << (PLAN_ - 64)) | (1L << (PRAGMA_ - 64)) | (1L << (PRIMARY_ - 64)) | (1L << (QUERY_ - 64)) | (1L << (RAISE_ - 64)) | (1L << (RECURSIVE_ - 64)) | (1L << (REFERENCES_ - 64)) | (1L << (REGEXP_ - 64)) | (1L << (REINDEX_ - 64)) | (1L << (RELEASE_ - 64)) | (1L << (RENAME_ - 64)) | (1L << (REPLACE_ - 64)) | (1L << (RESTRICT_ - 64)) | (1L << (RIGHT_ - 64)) | (1L << (ROLLBACK_ - 64)) | (1L << (ROW_ - 64)) | (1L << (ROWS_ - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (SAVEPOINT_ - 128)) | (1L << (SELECT_ - 128)) | (1L << (SET_ - 128)) | (1L << (TABLE_ - 128)) | (1L << (TEMP_ - 128)) | (1L << (TEMPORARY_ - 128)) | (1L << (THEN_ - 128)) | (1L << (TO_ - 128)) | (1L << (TRANSACTION_ - 128)) | (1L << (TRIGGER_ - 128)) | (1L << (UNION_ - 128)) | (1L << (UNIQUE_ - 128)) | (1L << (UPDATE_ - 128)) | (1L << (USING_ - 128)) | (1L << (VACUUM_ - 128)) | (1L << (VALUES_ - 128)) | (1L << (VIEW_ - 128)) | (1L << (VIRTUAL_ - 128)) | (1L << (WHEN_ - 128)) | (1L << (WHERE_ - 128)) | (1L << (WITH_ - 128)) | (1L << (WITHOUT_ - 128)) | (1L << (FIRST_VALUE_ - 128)) | (1L << (OVER_ - 128)) | (1L << (PARTITION_ - 128)) | (1L << (RANGE_ - 128)) | (1L << (PRECEDING_ - 128)) | (1L << (UNBOUNDED_ - 128)) | (1L << (CURRENT_ - 128)) | (1L << (FOLLOWING_ - 128)) | (1L << (CUME_DIST_ - 128)) | (1L << (DENSE_RANK_ - 128)) | (1L << (LAG_ - 128)) | (1L << (LAST_VALUE_ - 128)) | (1L << (LEAD_ - 128)) | (1L << (NTH_VALUE_ - 128)) | (1L << (NTILE_ - 128)) | (1L << (PERCENT_RANK_ - 128)) | (1L << (RANK_ - 128)) | (1L << (ROW_NUMBER_ - 128)) | (1L << (GENERATED_ - 128)) | (1L << (ALWAYS_ - 128)) | (1L << (STORED_ - 128)) | (1L << (TRUE_ - 128)) | (1L << (FALSE_ - 128)) | (1L << (WINDOW_ - 128)) | (1L << (NULLS_ - 128)) | (1L << (FIRST_ - 128)) | (1L << (LAST_ - 128)) | (1L << (FILTER_ - 128)) | (1L << (GROUPS_ - 128)) | (1L << (EXCLUDE_ - 128)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1983);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Function_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterFunction_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitFunction_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitFunction_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_nameContext function_name() throws RecognitionException {
		Function_nameContext _localctx = new Function_nameContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_function_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1985);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Schema_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Schema_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_schema_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterSchema_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitSchema_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitSchema_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Schema_nameContext schema_name() throws RecognitionException {
		Schema_nameContext _localctx = new Schema_nameContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_schema_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1987);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Table_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterTable_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitTable_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitTable_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Table_nameContext table_name() throws RecognitionException {
		Table_nameContext _localctx = new Table_nameContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_table_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1989);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_or_index_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Table_or_index_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_or_index_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterTable_or_index_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitTable_or_index_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitTable_or_index_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Table_or_index_nameContext table_or_index_name() throws RecognitionException {
		Table_or_index_nameContext _localctx = new Table_or_index_nameContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_table_or_index_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1991);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class New_table_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public New_table_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_new_table_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterNew_table_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitNew_table_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitNew_table_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final New_table_nameContext new_table_name() throws RecognitionException {
		New_table_nameContext _localctx = new New_table_nameContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_new_table_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1993);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Column_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Column_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterColumn_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitColumn_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitColumn_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Column_nameContext column_name() throws RecognitionException {
		Column_nameContext _localctx = new Column_nameContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_column_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1995);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Collation_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Collation_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_collation_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterCollation_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitCollation_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitCollation_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Collation_nameContext collation_name() throws RecognitionException {
		Collation_nameContext _localctx = new Collation_nameContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_collation_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1997);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Foreign_tableContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Foreign_tableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foreign_table; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterForeign_table(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitForeign_table(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitForeign_table(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Foreign_tableContext foreign_table() throws RecognitionException {
		Foreign_tableContext _localctx = new Foreign_tableContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_foreign_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1999);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Index_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Index_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_index_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterIndex_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitIndex_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitIndex_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Index_nameContext index_name() throws RecognitionException {
		Index_nameContext _localctx = new Index_nameContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_index_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2001);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Trigger_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Trigger_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trigger_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterTrigger_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitTrigger_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitTrigger_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Trigger_nameContext trigger_name() throws RecognitionException {
		Trigger_nameContext _localctx = new Trigger_nameContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_trigger_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2003);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class View_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public View_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_view_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterView_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitView_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitView_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final View_nameContext view_name() throws RecognitionException {
		View_nameContext _localctx = new View_nameContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_view_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2005);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Module_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Module_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterModule_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitModule_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitModule_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Module_nameContext module_name() throws RecognitionException {
		Module_nameContext _localctx = new Module_nameContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_module_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2007);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Pragma_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Pragma_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pragma_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterPragma_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitPragma_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitPragma_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pragma_nameContext pragma_name() throws RecognitionException {
		Pragma_nameContext _localctx = new Pragma_nameContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_pragma_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2009);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Savepoint_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Savepoint_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_savepoint_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterSavepoint_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitSavepoint_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitSavepoint_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Savepoint_nameContext savepoint_name() throws RecognitionException {
		Savepoint_nameContext _localctx = new Savepoint_nameContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_savepoint_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2011);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_aliasContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Table_aliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_alias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterTable_alias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitTable_alias(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitTable_alias(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Table_aliasContext table_alias() throws RecognitionException {
		Table_aliasContext _localctx = new Table_aliasContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_table_alias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2013);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Transaction_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Transaction_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transaction_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterTransaction_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitTransaction_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitTransaction_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Transaction_nameContext transaction_name() throws RecognitionException {
		Transaction_nameContext _localctx = new Transaction_nameContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_transaction_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2015);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Window_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Window_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_window_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterWindow_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitWindow_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitWindow_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Window_nameContext window_name() throws RecognitionException {
		Window_nameContext _localctx = new Window_nameContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_window_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2017);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AliasContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public AliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterAlias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitAlias(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitAlias(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AliasContext alias() throws RecognitionException {
		AliasContext _localctx = new AliasContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_alias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2019);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FilenameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public FilenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filename; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterFilename(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitFilename(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitFilename(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FilenameContext filename() throws RecognitionException {
		FilenameContext _localctx = new FilenameContext(_ctx, getState());
		enterRule(_localctx, 210, RULE_filename);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2021);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Base_window_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Base_window_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_window_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterBase_window_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitBase_window_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitBase_window_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Base_window_nameContext base_window_name() throws RecognitionException {
		Base_window_nameContext _localctx = new Base_window_nameContext(_ctx, getState());
		enterRule(_localctx, 212, RULE_base_window_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2023);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Simple_funcContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Simple_funcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_func; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterSimple_func(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitSimple_func(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitSimple_func(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Simple_funcContext simple_func() throws RecognitionException {
		Simple_funcContext _localctx = new Simple_funcContext(_ctx, getState());
		enterRule(_localctx, 214, RULE_simple_func);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2025);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Aggregate_funcContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Aggregate_funcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregate_func; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterAggregate_func(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitAggregate_func(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitAggregate_func(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Aggregate_funcContext aggregate_func() throws RecognitionException {
		Aggregate_funcContext _localctx = new Aggregate_funcContext(_ctx, getState());
		enterRule(_localctx, 216, RULE_aggregate_func);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2027);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_function_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Table_function_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_function_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterTable_function_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitTable_function_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitTable_function_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Table_function_nameContext table_function_name() throws RecognitionException {
		Table_function_nameContext _localctx = new Table_function_nameContext(_ctx, getState());
		enterRule(_localctx, 218, RULE_table_function_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2029);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Any_nameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SQLiteParser.IDENTIFIER, 0); }
		public KeywordContext keyword() {
			return getRuleContext(KeywordContext.class,0);
		}
		public TerminalNode STRING_LITERAL() { return getToken(SQLiteParser.STRING_LITERAL, 0); }
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public Any_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_any_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).enterAny_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteParserListener ) ((SQLiteParserListener)listener).exitAny_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteParserVisitor ) return ((SQLiteParserVisitor<? extends T>)visitor).visitAny_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Any_nameContext any_name() throws RecognitionException {
		Any_nameContext _localctx = new Any_nameContext(_ctx, getState());
		enterRule(_localctx, 220, RULE_any_name);
		try {
			setState(2038);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(2031);
				match(IDENTIFIER);
				}
				break;
			case ABORT_:
			case ACTION_:
			case ADD_:
			case AFTER_:
			case ALL_:
			case ALTER_:
			case ANALYZE_:
			case AND_:
			case AS_:
			case ASC_:
			case ATTACH_:
			case AUTOINCREMENT_:
			case BEFORE_:
			case BEGIN_:
			case BETWEEN_:
			case BY_:
			case CASCADE_:
			case CASE_:
			case CAST_:
			case CHECK_:
			case COLLATE_:
			case COLUMN_:
			case COMMIT_:
			case CONFLICT_:
			case CONSTRAINT_:
			case CREATE_:
			case CROSS_:
			case CURRENT_DATE_:
			case CURRENT_TIME_:
			case CURRENT_TIMESTAMP_:
			case DATABASE_:
			case DEFAULT_:
			case DEFERRABLE_:
			case DEFERRED_:
			case DELETE_:
			case DESC_:
			case DETACH_:
			case DISTINCT_:
			case DROP_:
			case EACH_:
			case ELSE_:
			case END_:
			case ESCAPE_:
			case EXCEPT_:
			case EXCLUSIVE_:
			case EXISTS_:
			case EXPLAIN_:
			case FAIL_:
			case FOR_:
			case FOREIGN_:
			case FROM_:
			case FULL_:
			case GLOB_:
			case GROUP_:
			case HAVING_:
			case IF_:
			case IGNORE_:
			case IMMEDIATE_:
			case IN_:
			case INDEX_:
			case INDEXED_:
			case INITIALLY_:
			case INNER_:
			case INSERT_:
			case INSTEAD_:
			case INTERSECT_:
			case INTO_:
			case IS_:
			case ISNULL_:
			case JOIN_:
			case KEY_:
			case LEFT_:
			case LIKE_:
			case LIMIT_:
			case MATCH_:
			case NATURAL_:
			case NO_:
			case NOT_:
			case NOTNULL_:
			case NULL_:
			case OF_:
			case OFFSET_:
			case ON_:
			case OR_:
			case ORDER_:
			case OUTER_:
			case PLAN_:
			case PRAGMA_:
			case PRIMARY_:
			case QUERY_:
			case RAISE_:
			case RECURSIVE_:
			case REFERENCES_:
			case REGEXP_:
			case REINDEX_:
			case RELEASE_:
			case RENAME_:
			case REPLACE_:
			case RESTRICT_:
			case RIGHT_:
			case ROLLBACK_:
			case ROW_:
			case ROWS_:
			case SAVEPOINT_:
			case SELECT_:
			case SET_:
			case TABLE_:
			case TEMP_:
			case TEMPORARY_:
			case THEN_:
			case TO_:
			case TRANSACTION_:
			case TRIGGER_:
			case UNION_:
			case UNIQUE_:
			case UPDATE_:
			case USING_:
			case VACUUM_:
			case VALUES_:
			case VIEW_:
			case VIRTUAL_:
			case WHEN_:
			case WHERE_:
			case WITH_:
			case WITHOUT_:
			case FIRST_VALUE_:
			case OVER_:
			case PARTITION_:
			case RANGE_:
			case PRECEDING_:
			case UNBOUNDED_:
			case CURRENT_:
			case FOLLOWING_:
			case CUME_DIST_:
			case DENSE_RANK_:
			case LAG_:
			case LAST_VALUE_:
			case LEAD_:
			case NTH_VALUE_:
			case NTILE_:
			case PERCENT_RANK_:
			case RANK_:
			case ROW_NUMBER_:
			case GENERATED_:
			case ALWAYS_:
			case STORED_:
			case TRUE_:
			case FALSE_:
			case WINDOW_:
			case NULLS_:
			case FIRST_:
			case LAST_:
			case FILTER_:
			case GROUPS_:
			case EXCLUDE_:
				enterOuterAlt(_localctx, 2);
				{
				setState(2032);
				keyword();
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(2033);
				match(STRING_LITERAL);
				}
				break;
			case OPEN_PAR:
				enterOuterAlt(_localctx, 4);
				{
				setState(2034);
				match(OPEN_PAR);
				setState(2035);
				any_name();
				setState(2036);
				match(CLOSE_PAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 32:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 20);
		case 1:
			return precpred(_ctx, 19);
		case 2:
			return precpred(_ctx, 18);
		case 3:
			return precpred(_ctx, 17);
		case 4:
			return precpred(_ctx, 16);
		case 5:
			return precpred(_ctx, 15);
		case 6:
			return precpred(_ctx, 14);
		case 7:
			return precpred(_ctx, 13);
		case 8:
			return precpred(_ctx, 6);
		case 9:
			return precpred(_ctx, 5);
		case 10:
			return precpred(_ctx, 9);
		case 11:
			return precpred(_ctx, 8);
		case 12:
			return precpred(_ctx, 7);
		case 13:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u00c2\u07fb\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"+
		"k\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\3\2\7\2\u00e2\n\2\f\2\16\2\u00e5\13\2"+
		"\3\2\3\2\3\3\7\3\u00ea\n\3\f\3\16\3\u00ed\13\3\3\3\3\3\6\3\u00f1\n\3\r"+
		"\3\16\3\u00f2\3\3\7\3\u00f6\n\3\f\3\16\3\u00f9\13\3\3\3\7\3\u00fc\n\3"+
		"\f\3\16\3\u00ff\13\3\3\4\3\4\3\4\5\4\u0104\n\4\5\4\u0106\n\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\5\4\u0120\n\4\3\5\3\5\3\5\3\5\3\5\5\5\u0127\n\5\3\5\3"+
		"\5\3\5\3\5\3\5\5\5\u012e\n\5\3\5\3\5\3\5\3\5\5\5\u0134\n\5\3\5\3\5\5\5"+
		"\u0138\n\5\3\5\5\5\u013b\n\5\3\6\3\6\3\6\3\6\3\6\5\6\u0142\n\6\3\6\5\6"+
		"\u0145\n\6\3\7\3\7\5\7\u0149\n\7\3\7\3\7\3\7\3\7\3\b\3\b\5\b\u0151\n\b"+
		"\3\b\3\b\5\b\u0155\n\b\5\b\u0157\n\b\3\t\3\t\5\t\u015b\n\t\3\n\3\n\5\n"+
		"\u015f\n\n\3\n\3\n\5\n\u0163\n\n\3\n\5\n\u0166\n\n\3\13\3\13\3\13\3\f"+
		"\3\f\5\f\u016d\n\f\3\f\3\f\3\r\3\r\5\r\u0173\n\r\3\r\3\r\3\r\3\r\5\r\u0179"+
		"\n\r\3\r\3\r\3\r\5\r\u017e\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u0187\n"+
		"\r\f\r\16\r\u018a\13\r\3\r\3\r\3\r\5\r\u018f\n\r\3\16\3\16\5\16\u0193"+
		"\n\16\3\16\3\16\5\16\u0197\n\16\3\16\5\16\u019a\n\16\3\17\3\17\5\17\u019e"+
		"\n\17\3\17\3\17\3\17\3\17\5\17\u01a4\n\17\3\17\3\17\3\17\5\17\u01a9\n"+
		"\17\3\17\3\17\3\17\3\17\3\17\7\17\u01b0\n\17\f\17\16\17\u01b3\13\17\3"+
		"\17\3\17\7\17\u01b7\n\17\f\17\16\17\u01ba\13\17\3\17\3\17\3\17\5\17\u01bf"+
		"\n\17\3\17\3\17\5\17\u01c3\n\17\3\20\3\20\5\20\u01c7\n\20\3\20\7\20\u01ca"+
		"\n\20\f\20\16\20\u01cd\13\20\3\21\6\21\u01d0\n\21\r\21\16\21\u01d1\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u01de\n\21\3\22\3\22"+
		"\5\22\u01e2\n\22\3\22\3\22\3\22\5\22\u01e7\n\22\3\22\5\22\u01ea\n\22\3"+
		"\22\5\22\u01ed\n\22\3\22\3\22\3\22\5\22\u01f2\n\22\3\22\5\22\u01f5\n\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0203"+
		"\n\22\3\22\3\22\3\22\3\22\3\22\5\22\u020a\n\22\3\22\3\22\3\22\3\22\3\22"+
		"\5\22\u0211\n\22\5\22\u0213\n\22\3\23\5\23\u0216\n\23\3\23\3\23\3\24\3"+
		"\24\5\24\u021c\n\24\3\24\3\24\3\24\5\24\u0221\n\24\3\24\3\24\3\24\3\24"+
		"\7\24\u0227\n\24\f\24\16\24\u022a\13\24\3\24\3\24\5\24\u022e\n\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u023b\n\24\f\24"+
		"\16\24\u023e\13\24\3\24\3\24\3\24\5\24\u0243\n\24\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\7\25\u024b\n\25\f\25\16\25\u024e\13\25\3\25\3\25\5\25\u0252"+
		"\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u025c\n\25\3\25\3\25"+
		"\7\25\u0260\n\25\f\25\16\25\u0263\13\25\3\25\5\25\u0266\n\25\3\25\3\25"+
		"\3\25\5\25\u026b\n\25\5\25\u026d\n\25\3\26\3\26\3\26\3\26\3\27\3\27\5"+
		"\27\u0275\n\27\3\27\3\27\3\27\3\27\5\27\u027b\n\27\3\27\3\27\3\27\5\27"+
		"\u0280\n\27\3\27\3\27\3\27\3\27\3\27\5\27\u0287\n\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\7\27\u0290\n\27\f\27\16\27\u0293\13\27\5\27\u0295\n"+
		"\27\5\27\u0297\n\27\3\27\3\27\3\27\3\27\3\27\5\27\u029e\n\27\3\27\3\27"+
		"\5\27\u02a2\n\27\3\27\3\27\3\27\3\27\3\27\5\27\u02a9\n\27\3\27\3\27\6"+
		"\27\u02ad\n\27\r\27\16\27\u02ae\3\27\3\27\3\30\3\30\5\30\u02b5\n\30\3"+
		"\30\3\30\3\30\3\30\5\30\u02bb\n\30\3\30\3\30\3\30\5\30\u02c0\n\30\3\30"+
		"\3\30\3\30\3\30\3\30\7\30\u02c7\n\30\f\30\16\30\u02ca\13\30\3\30\3\30"+
		"\5\30\u02ce\n\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u02d9"+
		"\n\31\3\31\3\31\3\31\5\31\u02de\n\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\7\31\u02e7\n\31\f\31\16\31\u02ea\13\31\3\31\3\31\5\31\u02ee\n\31\3\32"+
		"\3\32\5\32\u02f2\n\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\7\32\u0300\n\32\f\32\16\32\u0303\13\32\3\33\3\33\3\33\3\33"+
		"\3\33\7\33\u030a\n\33\f\33\16\33\u030d\13\33\3\33\3\33\5\33\u0311\n\33"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u0319\n\34\3\34\3\34\3\34\3\35\3\35"+
		"\3\35\3\35\3\35\7\35\u0323\n\35\f\35\16\35\u0326\13\35\3\35\3\35\5\35"+
		"\u032a\n\35\3\35\3\35\3\35\3\35\3\35\3\36\5\36\u0332\n\36\3\36\3\36\3"+
		"\36\3\36\3\36\5\36\u0339\n\36\3\37\5\37\u033c\n\37\3\37\3\37\3\37\3\37"+
		"\3\37\5\37\u0343\n\37\3\37\5\37\u0346\n\37\3\37\5\37\u0349\n\37\3 \3 "+
		"\5 \u034d\n \3 \3 \3!\3!\3!\3!\5!\u0355\n!\3!\3!\3!\5!\u035a\n!\3!\3!"+
		"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u0364\n\"\3\"\3\"\3\"\5\"\u0369\n\"\3\"\3"+
		"\"\3\"\3\"\3\"\3\"\3\"\5\"\u0372\n\"\3\"\3\"\3\"\7\"\u0377\n\"\f\"\16"+
		"\"\u037a\13\"\3\"\5\"\u037d\n\"\3\"\3\"\5\"\u0381\n\"\3\"\5\"\u0384\n"+
		"\"\3\"\3\"\3\"\3\"\7\"\u038a\n\"\f\"\16\"\u038d\13\"\3\"\3\"\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\3\"\3\"\5\"\u0399\n\"\3\"\5\"\u039c\n\"\3\"\3\"\3\"\3\""+
		"\3\"\3\"\5\"\u03a4\n\"\3\"\3\"\3\"\3\"\3\"\6\"\u03ab\n\"\r\"\16\"\u03ac"+
		"\3\"\3\"\5\"\u03b1\n\"\3\"\3\"\3\"\5\"\u03b6\n\"\3\"\3\"\3\"\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\""+
		"\3\"\3\"\3\"\3\"\3\"\5\"\u03d4\n\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\""+
		"\3\"\5\"\u03e0\n\"\3\"\3\"\3\"\5\"\u03e5\n\"\3\"\3\"\3\"\3\"\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\5\"\u03f1\n\"\3\"\3\"\3\"\3\"\5\"\u03f7\n\"\3\"\3\"\3\""+
		"\3\"\3\"\5\"\u03fe\n\"\3\"\3\"\5\"\u0402\n\"\3\"\3\"\3\"\3\"\3\"\3\"\7"+
		"\"\u040a\n\"\f\"\16\"\u040d\13\"\5\"\u040f\n\"\3\"\3\"\3\"\3\"\5\"\u0415"+
		"\n\"\3\"\3\"\3\"\3\"\5\"\u041b\n\"\3\"\3\"\3\"\3\"\3\"\7\"\u0422\n\"\f"+
		"\"\16\"\u0425\13\"\5\"\u0427\n\"\3\"\3\"\5\"\u042b\n\"\7\"\u042d\n\"\f"+
		"\"\16\"\u0430\13\"\3#\3#\3#\3#\3#\3#\5#\u0438\n#\3#\3#\3$\3$\3%\5%\u043f"+
		"\n%\3%\3%\3%\3%\3%\5%\u0446\n%\3%\3%\3%\3%\5%\u044c\n%\3%\3%\3%\5%\u0451"+
		"\n%\3%\3%\3%\3%\7%\u0457\n%\f%\16%\u045a\13%\3%\3%\5%\u045e\n%\3%\3%\3"+
		"%\3%\3%\7%\u0465\n%\f%\16%\u0468\13%\3%\3%\3%\3%\3%\3%\7%\u0470\n%\f%"+
		"\16%\u0473\13%\3%\3%\7%\u0477\n%\f%\16%\u047a\13%\3%\5%\u047d\n%\3%\5"+
		"%\u0480\n%\3%\3%\5%\u0484\n%\3&\3&\3&\3&\3&\3&\7&\u048c\n&\f&\16&\u048f"+
		"\13&\3&\3&\3&\5&\u0494\n&\5&\u0496\n&\3&\3&\3&\3&\3&\3&\5&\u049e\n&\3"+
		"&\3&\3&\3&\3&\5&\u04a5\n&\3&\3&\3&\7&\u04aa\n&\f&\16&\u04ad\13&\3&\3&"+
		"\5&\u04b1\n&\5&\u04b3\n&\3\'\3\'\3\'\3\'\5\'\u04b9\n\'\3\'\3\'\3\'\3\'"+
		"\3\'\3\'\3\'\5\'\u04c2\n\'\3(\3(\3(\5(\u04c7\n(\3)\3)\3)\3)\3)\5)\u04ce"+
		"\n)\3)\3)\5)\u04d2\n)\5)\u04d4\n)\3*\5*\u04d7\n*\3*\3*\3*\3*\7*\u04dd"+
		"\n*\f*\16*\u04e0\13*\3*\5*\u04e3\n*\3*\5*\u04e6\n*\3+\3+\3+\3+\5+\u04ec"+
		"\n+\7+\u04ee\n+\f+\16+\u04f1\13+\3,\3,\5,\u04f5\n,\3,\3,\3,\7,\u04fa\n"+
		",\f,\16,\u04fd\13,\3,\3,\3,\3,\7,\u0503\n,\f,\16,\u0506\13,\3,\5,\u0509"+
		"\n,\5,\u050b\n,\3,\3,\5,\u050f\n,\3,\3,\3,\3,\3,\7,\u0516\n,\f,\16,\u0519"+
		"\13,\3,\3,\5,\u051d\n,\5,\u051f\n,\3,\3,\3,\3,\3,\3,\3,\3,\3,\7,\u052a"+
		"\n,\f,\16,\u052d\13,\5,\u052f\n,\3,\3,\3,\3,\3,\7,\u0536\n,\f,\16,\u0539"+
		"\13,\3,\3,\3,\3,\3,\3,\7,\u0541\n,\f,\16,\u0544\13,\3,\3,\7,\u0548\n,"+
		"\f,\16,\u054b\13,\5,\u054d\n,\3-\3-\3.\5.\u0552\n.\3.\3.\5.\u0556\n.\3"+
		".\5.\u0559\n.\3/\5/\u055c\n/\3/\3/\3/\5/\u0561\n/\3/\3/\5/\u0565\n/\3"+
		"/\6/\u0568\n/\r/\16/\u0569\3/\5/\u056d\n/\3/\5/\u0570\n/\3\60\3\60\3\60"+
		"\5\60\u0575\n\60\3\60\3\60\5\60\u0579\n\60\3\60\5\60\u057c\n\60\3\60\3"+
		"\60\3\60\3\60\3\60\5\60\u0583\n\60\3\60\3\60\3\60\5\60\u0588\n\60\3\60"+
		"\3\60\3\60\3\60\3\60\7\60\u058f\n\60\f\60\16\60\u0592\13\60\3\60\3\60"+
		"\5\60\u0596\n\60\3\60\5\60\u0599\n\60\3\60\3\60\3\60\3\60\7\60\u059f\n"+
		"\60\f\60\16\60\u05a2\13\60\3\60\5\60\u05a5\n\60\3\60\3\60\3\60\3\60\3"+
		"\60\3\60\5\60\u05ad\n\60\3\60\5\60\u05b0\n\60\5\60\u05b2\n\60\3\61\3\61"+
		"\3\61\3\61\3\61\3\61\3\61\5\61\u05bb\n\61\3\61\5\61\u05be\n\61\5\61\u05c0"+
		"\n\61\3\62\3\62\5\62\u05c4\n\62\3\62\3\62\5\62\u05c8\n\62\3\62\3\62\5"+
		"\62\u05cc\n\62\3\62\5\62\u05cf\n\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63"+
		"\7\63\u05d8\n\63\f\63\16\63\u05db\13\63\3\63\3\63\5\63\u05df\n\63\3\64"+
		"\3\64\5\64\u05e3\n\64\3\64\3\64\5\64\u05e7\n\64\3\65\5\65\u05ea\n\65\3"+
		"\65\3\65\3\65\5\65\u05ef\n\65\3\65\3\65\3\65\3\65\5\65\u05f5\n\65\3\65"+
		"\3\65\3\65\3\65\3\65\5\65\u05fc\n\65\3\65\3\65\3\65\7\65\u0601\n\65\f"+
		"\65\16\65\u0604\13\65\3\65\3\65\5\65\u0608\n\65\3\66\3\66\3\66\3\66\7"+
		"\66\u060e\n\66\f\66\16\66\u0611\13\66\3\66\3\66\3\67\5\67\u0616\n\67\3"+
		"\67\3\67\3\67\5\67\u061b\n\67\3\67\3\67\3\67\3\67\5\67\u0621\n\67\3\67"+
		"\3\67\3\67\3\67\3\67\5\67\u0628\n\67\3\67\3\67\3\67\7\67\u062d\n\67\f"+
		"\67\16\67\u0630\13\67\3\67\3\67\5\67\u0634\n\67\3\67\5\67\u0637\n\67\3"+
		"\67\5\67\u063a\n\67\38\38\38\58\u063f\n8\38\38\38\58\u0644\n8\38\38\3"+
		"8\38\38\58\u064b\n8\39\39\59\u064f\n9\39\39\59\u0653\n9\3:\3:\3:\3:\3"+
		":\3:\3;\3;\5;\u065d\n;\3;\3;\3;\3;\3;\7;\u0664\n;\f;\16;\u0667\13;\5;"+
		"\u0669\n;\3;\3;\3;\3;\3;\7;\u0670\n;\f;\16;\u0673\13;\3;\5;\u0676\n;\3"+
		";\3;\3<\3<\3<\3<\5<\u067e\n<\3<\3<\3<\3<\3<\7<\u0685\n<\f<\16<\u0688\13"+
		"<\5<\u068a\n<\3<\3<\3<\3<\3<\7<\u0691\n<\f<\16<\u0694\13<\5<\u0696\n<"+
		"\3<\5<\u0699\n<\3<\5<\u069c\n<\3=\3=\3=\3=\3=\3=\3=\3=\5=\u06a6\n=\3>"+
		"\3>\3>\3>\3>\3>\3>\5>\u06af\n>\3?\3?\3?\3?\3?\7?\u06b6\n?\f?\16?\u06b9"+
		"\13?\3?\5?\u06bc\n?\3?\3?\3@\3@\3@\5@\u06c3\n@\3@\3@\3@\7@\u06c8\n@\f"+
		"@\16@\u06cb\13@\3@\5@\u06ce\n@\3@\3@\5@\u06d2\n@\3A\3A\3A\3A\3A\7A\u06d9"+
		"\nA\fA\16A\u06dc\13A\3A\5A\u06df\nA\3A\3A\5A\u06e3\nA\3A\3A\3A\5A\u06e8"+
		"\nA\3B\3B\5B\u06ec\nB\3B\3B\3B\7B\u06f1\nB\fB\16B\u06f4\13B\3C\3C\3C\3"+
		"C\3C\7C\u06fb\nC\fC\16C\u06fe\13C\3D\3D\3D\3D\5D\u0704\nD\3E\3E\3E\5E"+
		"\u0709\nE\3E\5E\u070c\nE\3E\3E\5E\u0710\nE\3F\3F\3G\3G\3G\3G\3G\3G\3G"+
		"\3G\3G\3G\5G\u071e\nG\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\5H\u072a\nH\3I\3I"+
		"\3I\3I\3I\3I\3I\5I\u0733\nI\3J\3J\3J\3J\3J\3J\3J\5J\u073c\nJ\3J\3J\5J"+
		"\u0740\nJ\3J\3J\3J\3J\3J\3J\3J\3J\5J\u074a\nJ\3J\5J\u074d\nJ\3J\3J\3J"+
		"\3J\3J\3J\3J\5J\u0756\nJ\3J\3J\3J\3J\3J\3J\3J\5J\u075f\nJ\3J\5J\u0762"+
		"\nJ\3J\3J\3J\3J\5J\u0768\nJ\3J\3J\3J\3J\3J\3J\3J\3J\3J\3J\3J\3J\5J\u0776"+
		"\nJ\3J\3J\5J\u077a\nJ\3J\3J\3J\3J\3J\3J\3J\3J\3J\5J\u0785\nJ\3J\3J\3J"+
		"\5J\u078a\nJ\3K\3K\3K\3L\3L\3L\3M\3M\3M\6M\u0795\nM\rM\16M\u0796\3N\3"+
		"N\3N\6N\u079c\nN\rN\16N\u079d\3O\3O\3O\3O\3P\3P\5P\u07a6\nP\3P\3P\3P\5"+
		"P\u07ab\nP\7P\u07ad\nP\fP\16P\u07b0\13P\3Q\3Q\3R\3R\3S\3S\3T\3T\3U\3U"+
		"\5U\u07bc\nU\3V\3V\3W\3W\3X\3X\3Y\3Y\3Z\3Z\3[\3[\3\\\3\\\3]\3]\3^\3^\3"+
		"_\3_\3`\3`\3a\3a\3b\3b\3c\3c\3d\3d\3e\3e\3f\3f\3g\3g\3h\3h\3i\3i\3j\3"+
		"j\3k\3k\3l\3l\3m\3m\3n\3n\3o\3o\3p\3p\3p\3p\3p\3p\3p\5p\u07f9\np\3p\4"+
		"\u01b1\u01d1\3Bq\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62"+
		"\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088"+
		"\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0"+
		"\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8"+
		"\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\u00c8\u00ca\u00cc\u00ce\u00d0"+
		"\u00d2\u00d4\u00d6\u00d8\u00da\u00dc\u00de\2\36\5\2<<GGTT\4\2\61\61DD"+
		"\3\2\u0086\u0087\4\2\u0093\u0093\u00ac\u00ac\3\2\n\13\4\2==\u008e\u008e"+
		"\4\2::jj\4\2<<TT\7\2\33\33JJSS||\177\177\6\2VV\u0085\u0085\u008b\u008b"+
		"\u0092\u0092\4\2\t\t\16\17\3\2\20\23\3\2\24\27\6\2OOcceexx\5\2\33\33J"+
		"J\177\177\7\2\668jj\u00ad\u00ae\u00bb\u00bb\u00bd\u00be\4\2\37\37@@\5"+
		"\2\u0081\u0081\u009b\u009b\u00b4\u00b4\4\2\7\7ll\3\2\u00b1\u00b2\4\2$"+
		"$>>\4\2\u0098\u0098\u00a3\u00a3\4\2\u00a0\u00a0\u00a7\u00a7\4\2\u00a1"+
		"\u00a1\u00a8\u00a9\4\2\u00a2\u00a2\u00a4\u00a4\4\2\n\fhh\4\2\u00ba\u00ba"+
		"\u00bd\u00bd\3\2\33\u00b5\2\u090f\2\u00e3\3\2\2\2\4\u00eb\3\2\2\2\6\u0105"+
		"\3\2\2\2\b\u0121\3\2\2\2\n\u013c\3\2\2\2\f\u0146\3\2\2\2\16\u014e\3\2"+
		"\2\2\20\u0158\3\2\2\2\22\u015c\3\2\2\2\24\u0167\3\2\2\2\26\u016a\3\2\2"+
		"\2\30\u0170\3\2\2\2\32\u0192\3\2\2\2\34\u019b\3\2\2\2\36\u01c4\3\2\2\2"+
		" \u01cf\3\2\2\2\"\u01e1\3\2\2\2$\u0215\3\2\2\2&\u021b\3\2\2\2(\u0244\3"+
		"\2\2\2*\u026e\3\2\2\2,\u0272\3\2\2\2.\u02b2\3\2\2\2\60\u02d2\3\2\2\2\62"+
		"\u02ef\3\2\2\2\64\u0304\3\2\2\2\66\u0312\3\2\2\28\u031d\3\2\2\2:\u0331"+
		"\3\2\2\2<\u033b\3\2\2\2>\u034a\3\2\2\2@\u0350\3\2\2\2B\u03b5\3\2\2\2D"+
		"\u0431\3\2\2\2F\u043b\3\2\2\2H\u0483\3\2\2\2J\u0485\3\2\2\2L\u04b4\3\2"+
		"\2\2N\u04c6\3\2\2\2P\u04c8\3\2\2\2R\u04d6\3\2\2\2T\u04e7\3\2\2\2V\u054c"+
		"\3\2\2\2X\u054e\3\2\2\2Z\u0551\3\2\2\2\\\u055b\3\2\2\2^\u05b1\3\2\2\2"+
		"`\u05bf\3\2\2\2b\u05ce\3\2\2\2d\u05de\3\2\2\2f\u05e6\3\2\2\2h\u05e9\3"+
		"\2\2\2j\u0609\3\2\2\2l\u0615\3\2\2\2n\u063e\3\2\2\2p\u064c\3\2\2\2r\u0654"+
		"\3\2\2\2t\u065a\3\2\2\2v\u0679\3\2\2\2x\u069d\3\2\2\2z\u06a7\3\2\2\2|"+
		"\u06b0\3\2\2\2~\u06bf\3\2\2\2\u0080\u06d3\3\2\2\2\u0082\u06e9\3\2\2\2"+
		"\u0084\u06f5\3\2\2\2\u0086\u06ff\3\2\2\2\u0088\u0705\3\2\2\2\u008a\u0711"+
		"\3\2\2\2\u008c\u071d\3\2\2\2\u008e\u0729\3\2\2\2\u0090\u0732\3\2\2\2\u0092"+
		"\u0789\3\2\2\2\u0094\u078b\3\2\2\2\u0096\u078e\3\2\2\2\u0098\u0791\3\2"+
		"\2\2\u009a\u0798\3\2\2\2\u009c\u079f\3\2\2\2\u009e\u07a3\3\2\2\2\u00a0"+
		"\u07b1\3\2\2\2\u00a2\u07b3\3\2\2\2\u00a4\u07b5\3\2\2\2\u00a6\u07b7\3\2"+
		"\2\2\u00a8\u07bb\3\2\2\2\u00aa\u07bd\3\2\2\2\u00ac\u07bf\3\2\2\2\u00ae"+
		"\u07c1\3\2\2\2\u00b0\u07c3\3\2\2\2\u00b2\u07c5\3\2\2\2\u00b4\u07c7\3\2"+
		"\2\2\u00b6\u07c9\3\2\2\2\u00b8\u07cb\3\2\2\2\u00ba\u07cd\3\2\2\2\u00bc"+
		"\u07cf\3\2\2\2\u00be\u07d1\3\2\2\2\u00c0\u07d3\3\2\2\2\u00c2\u07d5\3\2"+
		"\2\2\u00c4\u07d7\3\2\2\2\u00c6\u07d9\3\2\2\2\u00c8\u07db\3\2\2\2\u00ca"+
		"\u07dd\3\2\2\2\u00cc\u07df\3\2\2\2\u00ce\u07e1\3\2\2\2\u00d0\u07e3\3\2"+
		"\2\2\u00d2\u07e5\3\2\2\2\u00d4\u07e7\3\2\2\2\u00d6\u07e9\3\2\2\2\u00d8"+
		"\u07eb\3\2\2\2\u00da\u07ed\3\2\2\2\u00dc\u07ef\3\2\2\2\u00de\u07f8\3\2"+
		"\2\2\u00e0\u00e2\5\4\3\2\u00e1\u00e0\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3"+
		"\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e6\3\2\2\2\u00e5\u00e3\3\2"+
		"\2\2\u00e6\u00e7\7\2\2\3\u00e7\3\3\2\2\2\u00e8\u00ea\7\3\2\2\u00e9\u00e8"+
		"\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec"+
		"\u00ee\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee\u00f7\5\6\4\2\u00ef\u00f1\7\3"+
		"\2\2\u00f0\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2"+
		"\u00f3\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f6\5\6\4\2\u00f5\u00f0\3\2"+
		"\2\2\u00f6\u00f9\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8"+
		"\u00fd\3\2\2\2\u00f9\u00f7\3\2\2\2\u00fa\u00fc\7\3\2\2\u00fb\u00fa\3\2"+
		"\2\2\u00fc\u00ff\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe"+
		"\5\3\2\2\2\u00ff\u00fd\3\2\2\2\u0100\u0103\7I\2\2\u0101\u0102\7t\2\2\u0102"+
		"\u0104\7q\2\2\u0103\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0106\3\2"+
		"\2\2\u0105\u0100\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u011f\3\2\2\2\u0107"+
		"\u0120\5\b\5\2\u0108\u0120\5\n\6\2\u0109\u0120\5\f\7\2\u010a\u0120\5\16"+
		"\b\2\u010b\u0120\5\20\t\2\u010c\u0120\5\30\r\2\u010d\u0120\5\34\17\2\u010e"+
		"\u0120\5,\27\2\u010f\u0120\5.\30\2\u0110\u0120\5\60\31\2\u0111\u0120\5"+
		":\36\2\u0112\u0120\5<\37\2\u0113\u0120\5> \2\u0114\u0120\5@!\2\u0115\u0120"+
		"\5H%\2\u0116\u0120\5L\'\2\u0117\u0120\5P)\2\u0118\u0120\5\26\f\2\u0119"+
		"\u0120\5\22\n\2\u011a\u0120\5\24\13\2\u011b\u0120\5R*\2\u011c\u0120\5"+
		"h\65\2\u011d\u0120\5l\67\2\u011e\u0120\5p9\2\u011f\u0107\3\2\2\2\u011f"+
		"\u0108\3\2\2\2\u011f\u0109\3\2\2\2\u011f\u010a\3\2\2\2\u011f\u010b\3\2"+
		"\2\2\u011f\u010c\3\2\2\2\u011f\u010d\3\2\2\2\u011f\u010e\3\2\2\2\u011f"+
		"\u010f\3\2\2\2\u011f\u0110\3\2\2\2\u011f\u0111\3\2\2\2\u011f\u0112\3\2"+
		"\2\2\u011f\u0113\3\2\2\2\u011f\u0114\3\2\2\2\u011f\u0115\3\2\2\2\u011f"+
		"\u0116\3\2\2\2\u011f\u0117\3\2\2\2\u011f\u0118\3\2\2\2\u011f\u0119\3\2"+
		"\2\2\u011f\u011a\3\2\2\2\u011f\u011b\3\2\2\2\u011f\u011c\3\2\2\2\u011f"+
		"\u011d\3\2\2\2\u011f\u011e\3\2\2\2\u0120\7\3\2\2\2\u0121\u0122\7 \2\2"+
		"\u0122\u0126\7\u0085\2\2\u0123\u0124\5\u00b2Z\2\u0124\u0125\7\4\2\2\u0125"+
		"\u0127\3\2\2\2\u0126\u0123\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0128\3\2"+
		"\2\2\u0128\u013a\5\u00b4[\2\u0129\u0133\7{\2\2\u012a\u012b\7\u0089\2\2"+
		"\u012b\u0134\5\u00b8]\2\u012c\u012e\7\60\2\2\u012d\u012c\3\2\2\2\u012d"+
		"\u012e\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0130\5\u00ba^\2\u0130\u0131"+
		"\7\u0089\2\2\u0131\u0132\5\u00ba^\2\u0132\u0134\3\2\2\2\u0133\u012a\3"+
		"\2\2\2\u0133\u012d\3\2\2\2\u0134\u013b\3\2\2\2\u0135\u0137\7\35\2\2\u0136"+
		"\u0138\7\60\2\2\u0137\u0136\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u0139\3"+
		"\2\2\2\u0139\u013b\5\36\20\2\u013a\u0129\3\2\2\2\u013a\u0135\3\2\2\2\u013b"+
		"\t\3\2\2\2\u013c\u0144\7!\2\2\u013d\u0145\5\u00b2Z\2\u013e\u013f\5\u00b2"+
		"Z\2\u013f\u0140\7\4\2\2\u0140\u0142\3\2\2\2\u0141\u013e\3\2\2\2\u0141"+
		"\u0142\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u0145\5\u00b6\\\2\u0144\u013d"+
		"\3\2\2\2\u0144\u0141\3\2\2\2\u0144\u0145\3\2\2\2\u0145\13\3\2\2\2\u0146"+
		"\u0148\7%\2\2\u0147\u0149\79\2\2\u0148\u0147\3\2\2\2\u0148\u0149\3\2\2"+
		"\2\u0149\u014a\3\2\2\2\u014a\u014b\5B\"\2\u014b\u014c\7#\2\2\u014c\u014d"+
		"\5\u00b2Z\2\u014d\r\3\2\2\2\u014e\u0150\7(\2\2\u014f\u0151\t\2\2\2\u0150"+
		"\u014f\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u0156\3\2\2\2\u0152\u0154\7\u008a"+
		"\2\2\u0153\u0155\5\u00ceh\2\u0154\u0153\3\2\2\2\u0154\u0155\3\2\2\2\u0155"+
		"\u0157\3\2\2\2\u0156\u0152\3\2\2\2\u0156\u0157\3\2\2\2\u0157\17\3\2\2"+
		"\2\u0158\u015a\t\3\2\2\u0159\u015b\7\u008a\2\2\u015a\u0159\3\2\2\2\u015a"+
		"\u015b\3\2\2\2\u015b\21\3\2\2\2\u015c\u015e\7\177\2\2\u015d\u015f\7\u008a"+
		"\2\2\u015e\u015d\3\2\2\2\u015e\u015f\3\2\2\2\u015f\u0165\3\2\2\2\u0160"+
		"\u0162\7\u0089\2\2\u0161\u0163\7\u0082\2\2\u0162\u0161\3\2\2\2\u0162\u0163"+
		"\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0166\5\u00caf\2\u0165\u0160\3\2\2"+
		"\2\u0165\u0166\3\2\2\2\u0166\23\3\2\2\2\u0167\u0168\7\u0082\2\2\u0168"+
		"\u0169\5\u00caf\2\u0169\25\3\2\2\2\u016a\u016c\7z\2\2\u016b\u016d\7\u0082"+
		"\2\2\u016c\u016b\3\2\2\2\u016c\u016d\3\2\2\2\u016d\u016e\3\2\2\2\u016e"+
		"\u016f\5\u00caf\2\u016f\27\3\2\2\2\u0170\u0172\7\64\2\2\u0171\u0173\7"+
		"\u008d\2\2\u0172\u0171\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0174\3\2\2\2"+
		"\u0174\u0178\7V\2\2\u0175\u0176\7R\2\2\u0176\u0177\7h\2\2\u0177\u0179"+
		"\7H\2\2\u0178\u0175\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u017d\3\2\2\2\u017a"+
		"\u017b\5\u00b2Z\2\u017b\u017c\7\4\2\2\u017c\u017e\3\2\2\2\u017d\u017a"+
		"\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u0180\5\u00c0a"+
		"\2\u0180\u0181\7m\2\2\u0181\u0182\5\u00b4[\2\u0182\u0183\7\5\2\2\u0183"+
		"\u0188\5\32\16\2\u0184\u0185\7\7\2\2\u0185\u0187\5\32\16\2\u0186\u0184"+
		"\3\2\2\2\u0187\u018a\3\2\2\2\u0188\u0186\3\2\2\2\u0188\u0189\3\2\2\2\u0189"+
		"\u018b\3\2\2\2\u018a\u0188\3\2\2\2\u018b\u018e\7\6\2\2\u018c\u018d\7\u0095"+
		"\2\2\u018d\u018f\5B\"\2\u018e\u018c\3\2\2\2\u018e\u018f\3\2\2\2\u018f"+
		"\31\3\2\2\2\u0190\u0193\5\u00ba^\2\u0191\u0193\5B\"\2\u0192\u0190\3\2"+
		"\2\2\u0192\u0191\3\2\2\2\u0193\u0196\3\2\2\2\u0194\u0195\7/\2\2\u0195"+
		"\u0197\5\u00bc_\2\u0196\u0194\3\2\2\2\u0196\u0197\3\2\2\2\u0197\u0199"+
		"\3\2\2\2\u0198\u019a\5\u008aF\2\u0199\u0198\3\2\2\2\u0199\u019a\3\2\2"+
		"\2\u019a\33\3\2\2\2\u019b\u019d\7\64\2\2\u019c\u019e\t\4\2\2\u019d\u019c"+
		"\3\2\2\2\u019d\u019e\3\2\2\2\u019e\u019f\3\2\2\2\u019f\u01a3\7\u0085\2"+
		"\2\u01a0\u01a1\7R\2\2\u01a1\u01a2\7h\2\2\u01a2\u01a4\7H\2\2\u01a3\u01a0"+
		"\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4\u01a8\3\2\2\2\u01a5\u01a6\5\u00b2Z"+
		"\2\u01a6\u01a7\7\4\2\2\u01a7\u01a9\3\2\2\2\u01a8\u01a5\3\2\2\2\u01a8\u01a9"+
		"\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01c2\5\u00b4[\2\u01ab\u01ac\7\5\2"+
		"\2\u01ac\u01b1\5\36\20\2\u01ad\u01ae\7\7\2\2\u01ae\u01b0\5\36\20\2\u01af"+
		"\u01ad\3\2\2\2\u01b0\u01b3\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b1\u01af\3\2"+
		"\2\2\u01b2\u01b8\3\2\2\2\u01b3\u01b1\3\2\2\2\u01b4\u01b5\7\7\2\2\u01b5"+
		"\u01b7\5&\24\2\u01b6\u01b4\3\2\2\2\u01b7\u01ba\3\2\2\2\u01b8\u01b6\3\2"+
		"\2\2\u01b8\u01b9\3\2\2\2\u01b9\u01bb\3\2\2\2\u01ba\u01b8\3\2\2\2\u01bb"+
		"\u01be\7\6\2\2\u01bc\u01bd\7\u0097\2\2\u01bd\u01bf\7\u00ba\2\2\u01be\u01bc"+
		"\3\2\2\2\u01be\u01bf\3\2\2\2\u01bf\u01c3\3\2\2\2\u01c0\u01c1\7#\2\2\u01c1"+
		"\u01c3\5R*\2\u01c2\u01ab\3\2\2\2\u01c2\u01c0\3\2\2\2\u01c3\35\3\2\2\2"+
		"\u01c4\u01c6\5\u00ba^\2\u01c5\u01c7\5 \21\2\u01c6\u01c5\3\2\2\2\u01c6"+
		"\u01c7\3\2\2\2\u01c7\u01cb\3\2\2\2\u01c8\u01ca\5\"\22\2\u01c9\u01c8\3"+
		"\2\2\2\u01ca\u01cd\3\2\2\2\u01cb\u01c9\3\2\2\2\u01cb\u01cc\3\2\2\2\u01cc"+
		"\37\3\2\2\2\u01cd\u01cb\3\2\2\2\u01ce\u01d0\5\u00aeX\2\u01cf\u01ce\3\2"+
		"\2\2\u01d0\u01d1\3\2\2\2\u01d1\u01d2\3\2\2\2\u01d1\u01cf\3\2\2\2\u01d2"+
		"\u01dd\3\2\2\2\u01d3\u01d4\7\5\2\2\u01d4\u01d5\5$\23\2\u01d5\u01d6\7\6"+
		"\2\2\u01d6\u01de\3\2\2\2\u01d7\u01d8\7\5\2\2\u01d8\u01d9\5$\23\2\u01d9"+
		"\u01da\7\7\2\2\u01da\u01db\5$\23\2\u01db\u01dc\7\6\2\2\u01dc\u01de\3\2"+
		"\2\2\u01dd\u01d3\3\2\2\2\u01dd\u01d7\3\2\2\2\u01dd\u01de\3\2\2\2\u01de"+
		"!\3\2\2\2\u01df\u01e0\7\63\2\2\u01e0\u01e2\5\u00aeX\2\u01e1\u01df\3\2"+
		"\2\2\u01e1\u01e2\3\2\2\2\u01e2\u0212\3\2\2\2\u01e3\u01e4\7s\2\2\u01e4"+
		"\u01e6\7a\2\2\u01e5\u01e7\5\u008aF\2\u01e6\u01e5\3\2\2\2\u01e6\u01e7\3"+
		"\2\2\2\u01e7\u01e9\3\2\2\2\u01e8\u01ea\5*\26\2\u01e9\u01e8\3\2\2\2\u01e9"+
		"\u01ea\3\2\2\2\u01ea\u01ec\3\2\2\2\u01eb\u01ed\7&\2\2\u01ec\u01eb\3\2"+
		"\2\2\u01ec\u01ed\3\2\2\2\u01ed\u0213\3\2\2\2\u01ee\u01ef\7h\2\2\u01ef"+
		"\u01f2\7j\2\2\u01f0\u01f2\7\u008d\2\2\u01f1\u01ee\3\2\2\2\u01f1\u01f0"+
		"\3\2\2\2\u01f2\u01f4\3\2\2\2\u01f3\u01f5\5*\26\2\u01f4\u01f3\3\2\2\2\u01f4"+
		"\u01f5\3\2\2\2\u01f5\u0213\3\2\2\2\u01f6\u01f7\7.\2\2\u01f7\u01f8\7\5"+
		"\2\2\u01f8\u01f9\5B\"\2\u01f9\u01fa\7\6\2\2\u01fa\u0213\3\2\2\2\u01fb"+
		"\u0202\7:\2\2\u01fc\u0203\5$\23\2\u01fd\u0203\5F$\2\u01fe\u01ff\7\5\2"+
		"\2\u01ff\u0200\5B\"\2\u0200\u0201\7\6\2\2\u0201\u0203\3\2\2\2\u0202\u01fc"+
		"\3\2\2\2\u0202\u01fd\3\2\2\2\u0202\u01fe\3\2\2\2\u0203\u0213\3\2\2\2\u0204"+
		"\u0205\7/\2\2\u0205\u0213\5\u00bc_\2\u0206\u0213\5(\25\2\u0207\u0208\7"+
		"\u00aa\2\2\u0208\u020a\7\u00ab\2\2\u0209\u0207\3\2\2\2\u0209\u020a\3\2"+
		"\2\2\u020a\u020b\3\2\2\2\u020b\u020c\7#\2\2\u020c\u020d\7\5\2\2\u020d"+
		"\u020e\5B\"\2\u020e\u0210\7\6\2\2\u020f\u0211\t\5\2\2\u0210\u020f\3\2"+
		"\2\2\u0210\u0211\3\2\2\2\u0211\u0213\3\2\2\2\u0212\u01e3\3\2\2\2\u0212"+
		"\u01f1\3\2\2\2\u0212\u01f6\3\2\2\2\u0212\u01fb\3\2\2\2\u0212\u0204\3\2"+
		"\2\2\u0212\u0206\3\2\2\2\u0212\u0209\3\2\2\2\u0213#\3\2\2\2\u0214\u0216"+
		"\t\6\2\2\u0215\u0214\3\2\2\2\u0215\u0216\3\2\2\2\u0216\u0217\3\2\2\2\u0217"+
		"\u0218\7\u00bb\2\2\u0218%\3\2\2\2\u0219\u021a\7\63\2\2\u021a\u021c\5\u00ae"+
		"X\2\u021b\u0219\3\2\2\2\u021b\u021c\3\2\2\2\u021c\u0242\3\2\2\2\u021d"+
		"\u021e\7s\2\2\u021e\u0221\7a\2\2\u021f\u0221\7\u008d\2\2\u0220\u021d\3"+
		"\2\2\2\u0220\u021f\3\2\2\2\u0221\u0222\3\2\2\2\u0222\u0223\7\5\2\2\u0223"+
		"\u0228\5\32\16\2\u0224\u0225\7\7\2\2\u0225\u0227\5\32\16\2\u0226\u0224"+
		"\3\2\2\2\u0227\u022a\3\2\2\2\u0228\u0226\3\2\2\2\u0228\u0229\3\2\2\2\u0229"+
		"\u022b\3\2\2\2\u022a\u0228\3\2\2\2\u022b\u022d\7\6\2\2\u022c\u022e\5*"+
		"\26\2\u022d\u022c\3\2\2\2\u022d\u022e\3\2\2\2\u022e\u0243\3\2\2\2\u022f"+
		"\u0230\7.\2\2\u0230\u0231\7\5\2\2\u0231\u0232\5B\"\2\u0232\u0233\7\6\2"+
		"\2\u0233\u0243\3\2\2\2\u0234\u0235\7L\2\2\u0235\u0236\7a\2\2\u0236\u0237"+
		"\7\5\2\2\u0237\u023c\5\u00ba^\2\u0238\u0239\7\7\2\2\u0239\u023b\5\u00ba"+
		"^\2\u023a\u0238\3\2\2\2\u023b\u023e\3\2\2\2\u023c\u023a\3\2\2\2\u023c"+
		"\u023d\3\2\2\2\u023d\u023f\3\2\2\2\u023e\u023c\3\2\2\2\u023f\u0240\7\6"+
		"\2\2\u0240\u0241\5(\25\2\u0241\u0243\3\2\2\2\u0242\u0220\3\2\2\2\u0242"+
		"\u022f\3\2\2\2\u0242\u0234\3\2\2\2\u0243\'\3\2\2\2\u0244\u0245\7w\2\2"+
		"\u0245\u0251\5\u00be`\2\u0246\u0247\7\5\2\2\u0247\u024c\5\u00ba^\2\u0248"+
		"\u0249\7\7\2\2\u0249\u024b\5\u00ba^\2\u024a\u0248\3\2\2\2\u024b\u024e"+
		"\3\2\2\2\u024c\u024a\3\2\2\2\u024c\u024d\3\2\2\2\u024d\u024f\3\2\2\2\u024e"+
		"\u024c\3\2\2\2\u024f\u0250\7\6\2\2\u0250\u0252\3\2\2\2\u0251\u0246\3\2"+
		"\2\2\u0251\u0252\3\2\2\2\u0252\u0261\3\2\2\2\u0253\u0254\7m\2\2\u0254"+
		"\u025b\t\7\2\2\u0255\u0256\7\u0084\2\2\u0256\u025c\t\b\2\2\u0257\u025c"+
		"\7+\2\2\u0258\u025c\7}\2\2\u0259\u025a\7g\2\2\u025a\u025c\7\34\2\2\u025b"+
		"\u0255\3\2\2\2\u025b\u0257\3\2\2\2\u025b\u0258\3\2\2\2\u025b\u0259\3\2"+
		"\2\2\u025c\u0260\3\2\2\2\u025d\u025e\7e\2\2\u025e\u0260\5\u00aeX\2\u025f"+
		"\u0253\3\2\2\2\u025f\u025d\3\2\2\2\u0260\u0263\3\2\2\2\u0261\u025f\3\2"+
		"\2\2\u0261\u0262\3\2\2\2\u0262\u026c\3\2\2\2\u0263\u0261\3\2\2\2\u0264"+
		"\u0266\7h\2\2\u0265\u0264\3\2\2\2\u0265\u0266\3\2\2\2\u0266\u0267\3\2"+
		"\2\2\u0267\u026a\7;\2\2\u0268\u0269\7X\2\2\u0269\u026b\t\t\2\2\u026a\u0268"+
		"\3\2\2\2\u026a\u026b\3\2\2\2\u026b\u026d\3\2\2\2\u026c\u0265\3\2\2\2\u026c"+
		"\u026d\3\2\2\2\u026d)\3\2\2\2\u026e\u026f\7m\2\2\u026f\u0270\7\62\2\2"+
		"\u0270\u0271\t\n\2\2\u0271+\3\2\2\2\u0272\u0274\7\64\2\2\u0273\u0275\t"+
		"\4\2\2\u0274\u0273\3\2\2\2\u0274\u0275\3\2\2\2\u0275\u0276\3\2\2\2\u0276"+
		"\u027a\7\u008b\2\2\u0277\u0278\7R\2\2\u0278\u0279\7h\2\2\u0279\u027b\7"+
		"H\2\2\u027a\u0277\3\2\2\2\u027a\u027b\3\2\2\2\u027b\u027f\3\2\2\2\u027c"+
		"\u027d\5\u00b2Z\2\u027d\u027e\7\4\2\2\u027e\u0280\3\2\2\2\u027f\u027c"+
		"\3\2\2\2\u027f\u0280\3\2\2\2\u0280\u0281\3\2\2\2\u0281\u0286\5\u00c2b"+
		"\2\u0282\u0287\7\'\2\2\u0283\u0287\7\36\2\2\u0284\u0285\7[\2\2\u0285\u0287"+
		"\7k\2\2\u0286\u0282\3\2\2\2\u0286\u0283\3\2\2\2\u0286\u0284\3\2\2\2\u0286"+
		"\u0287\3\2\2\2\u0287\u0296\3\2\2\2\u0288\u0297\7=\2\2\u0289\u0297\7Z\2"+
		"\2\u028a\u0294\7\u008e\2\2\u028b\u028c\7k\2\2\u028c\u0291\5\u00ba^\2\u028d"+
		"\u028e\7\7\2\2\u028e\u0290\5\u00ba^\2\u028f\u028d\3\2\2\2\u0290\u0293"+
		"\3\2\2\2\u0291\u028f\3\2\2\2\u0291\u0292\3\2\2\2\u0292\u0295\3\2\2\2\u0293"+
		"\u0291\3\2\2\2\u0294\u028b\3\2\2\2\u0294\u0295\3\2\2\2\u0295\u0297\3\2"+
		"\2\2\u0296\u0288\3\2\2\2\u0296\u0289\3\2\2\2\u0296\u028a\3\2\2\2\u0297"+
		"\u0298\3\2\2\2\u0298\u0299\7m\2\2\u0299\u029d\5\u00b4[\2\u029a\u029b\7"+
		"K\2\2\u029b\u029c\7B\2\2\u029c\u029e\7\u0080\2\2\u029d\u029a\3\2\2\2\u029d"+
		"\u029e\3\2\2\2\u029e\u02a1\3\2\2\2\u029f\u02a0\7\u0094\2\2\u02a0\u02a2"+
		"\5B\"\2\u02a1\u029f\3\2\2\2\u02a1\u02a2\3\2\2\2\u02a2\u02a3\3\2\2\2\u02a3"+
		"\u02ac\7(\2\2\u02a4\u02a9\5h\65\2\u02a5\u02a9\5H%\2\u02a6\u02a9\5:\36"+
		"\2\u02a7\u02a9\5R*\2\u02a8\u02a4\3\2\2\2\u02a8\u02a5\3\2\2\2\u02a8\u02a6"+
		"\3\2\2\2\u02a8\u02a7\3\2\2\2\u02a9\u02aa\3\2\2\2\u02aa\u02ab\7\3\2\2\u02ab"+
		"\u02ad\3\2\2\2\u02ac\u02a8\3\2\2\2\u02ad\u02ae\3\2\2\2\u02ae\u02ac\3\2"+
		"\2\2\u02ae\u02af\3\2\2\2\u02af\u02b0\3\2\2\2\u02b0\u02b1\7D\2\2\u02b1"+
		"-\3\2\2\2\u02b2\u02b4\7\64\2\2\u02b3\u02b5\t\4\2\2\u02b4\u02b3\3\2\2\2"+
		"\u02b4\u02b5\3\2\2\2\u02b5\u02b6\3\2\2\2\u02b6\u02ba\7\u0092\2\2\u02b7"+
		"\u02b8\7R\2\2\u02b8\u02b9\7h\2\2\u02b9\u02bb\7H\2\2\u02ba\u02b7\3\2\2"+
		"\2\u02ba\u02bb\3\2\2\2\u02bb\u02bf\3\2\2\2\u02bc\u02bd\5\u00b2Z\2\u02bd"+
		"\u02be\7\4\2\2\u02be\u02c0\3\2\2\2\u02bf\u02bc\3\2\2\2\u02bf\u02c0\3\2"+
		"\2\2\u02c0\u02c1\3\2\2\2\u02c1\u02cd\5\u00c4c\2\u02c2\u02c3\7\5\2\2\u02c3"+
		"\u02c8\5\u00ba^\2\u02c4\u02c5\7\7\2\2\u02c5\u02c7\5\u00ba^\2\u02c6\u02c4"+
		"\3\2\2\2\u02c7\u02ca\3\2\2\2\u02c8\u02c6\3\2\2\2\u02c8\u02c9\3\2\2\2\u02c9"+
		"\u02cb\3\2\2\2\u02ca\u02c8\3\2\2\2\u02cb\u02cc\7\6\2\2\u02cc\u02ce\3\2"+
		"\2\2\u02cd\u02c2\3\2\2\2\u02cd\u02ce\3\2\2\2\u02ce\u02cf\3\2\2\2\u02cf"+
		"\u02d0\7#\2\2\u02d0\u02d1\5R*\2\u02d1/\3\2\2\2\u02d2\u02d3\7\64\2\2\u02d3"+
		"\u02d4\7\u0093\2\2\u02d4\u02d8\7\u0085\2\2\u02d5\u02d6\7R\2\2\u02d6\u02d7"+
		"\7h\2\2\u02d7\u02d9\7H\2\2\u02d8\u02d5\3\2\2\2\u02d8\u02d9\3\2\2\2\u02d9"+
		"\u02dd\3\2\2\2\u02da\u02db\5\u00b2Z\2\u02db\u02dc\7\4\2\2\u02dc\u02de"+
		"\3\2\2\2\u02dd\u02da\3\2\2\2\u02dd\u02de\3\2\2\2\u02de\u02df\3\2\2\2\u02df"+
		"\u02e0\5\u00b4[\2\u02e0\u02e1\7\u008f\2\2\u02e1\u02ed\5\u00c6d\2\u02e2"+
		"\u02e3\7\5\2\2\u02e3\u02e8\5\u00a8U\2\u02e4\u02e5\7\7\2\2\u02e5\u02e7"+
		"\5\u00a8U\2\u02e6\u02e4\3\2\2\2\u02e7\u02ea\3\2\2\2\u02e8\u02e6\3\2\2"+
		"\2\u02e8\u02e9\3\2\2\2\u02e9\u02eb\3\2\2\2\u02ea\u02e8\3\2\2\2\u02eb\u02ec"+
		"\7\6\2\2\u02ec\u02ee\3\2\2\2\u02ed\u02e2\3\2\2\2\u02ed\u02ee\3\2\2\2\u02ee"+
		"\61\3\2\2\2\u02ef\u02f1\7\u0096\2\2\u02f0\u02f2\7v\2\2\u02f1\u02f0\3\2"+
		"\2\2\u02f1\u02f2\3\2\2\2\u02f2\u02f3\3\2\2\2\u02f3\u02f4\5\64\33\2\u02f4"+
		"\u02f5\7#\2\2\u02f5\u02f6\7\5\2\2\u02f6\u02f7\5R*\2\u02f7\u0301\7\6\2"+
		"\2\u02f8\u02f9\7\7\2\2\u02f9\u02fa\5\64\33\2\u02fa\u02fb\7#\2\2\u02fb"+
		"\u02fc\7\5\2\2\u02fc\u02fd\5R*\2\u02fd\u02fe\7\6\2\2\u02fe\u0300\3\2\2"+
		"\2\u02ff\u02f8\3\2\2\2\u0300\u0303\3\2\2\2\u0301\u02ff\3\2\2\2\u0301\u0302"+
		"\3\2\2\2\u0302\63\3\2\2\2\u0303\u0301\3\2\2\2\u0304\u0310\5\u00b4[\2\u0305"+
		"\u0306\7\5\2\2\u0306\u030b\5\u00ba^\2\u0307\u0308\7\7\2\2\u0308\u030a"+
		"\5\u00ba^\2\u0309\u0307\3\2\2\2\u030a\u030d\3\2\2\2\u030b\u0309\3\2\2"+
		"\2\u030b\u030c\3\2\2\2\u030c\u030e\3\2\2\2\u030d\u030b\3\2\2\2\u030e\u030f"+
		"\7\6\2\2\u030f\u0311\3\2\2\2\u0310\u0305\3\2\2\2\u0310\u0311\3\2\2\2\u0311"+
		"\65\3\2\2\2\u0312\u0313\5\64\33\2\u0313\u0314\7#\2\2\u0314\u0315\7\5\2"+
		"\2\u0315\u0316\5\u00a0Q\2\u0316\u0318\7\u008c\2\2\u0317\u0319\7\37\2\2"+
		"\u0318\u0317\3\2\2\2\u0318\u0319\3\2\2\2\u0319\u031a\3\2\2\2\u031a\u031b"+
		"\5\u00a2R\2\u031b\u031c\7\6\2\2\u031c\67\3\2\2\2\u031d\u0329\5\u00b4["+
		"\2\u031e\u031f\7\5\2\2\u031f\u0324\5\u00ba^\2\u0320\u0321\7\7\2\2\u0321"+
		"\u0323\5\u00ba^\2\u0322\u0320\3\2\2\2\u0323\u0326\3\2\2\2\u0324\u0322"+
		"\3\2\2\2\u0324\u0325\3\2\2\2\u0325\u0327\3\2\2\2\u0326\u0324\3\2\2\2\u0327"+
		"\u0328\7\6\2\2\u0328\u032a\3\2\2\2\u0329\u031e\3\2\2\2\u0329\u032a\3\2"+
		"\2\2\u032a\u032b\3\2\2\2\u032b\u032c\7#\2\2\u032c\u032d\7\5\2\2\u032d"+
		"\u032e\5R*\2\u032e\u032f\7\6\2\2\u032f9\3\2\2\2\u0330\u0332\5\62\32\2"+
		"\u0331\u0330\3\2\2\2\u0331\u0332\3\2\2\2\u0332\u0333\3\2\2\2\u0333\u0334"+
		"\7=\2\2\u0334\u0335\7M\2\2\u0335\u0338\5n8\2\u0336\u0337\7\u0095\2\2\u0337"+
		"\u0339\5B\"\2\u0338\u0336\3\2\2\2\u0338\u0339\3\2\2\2\u0339;\3\2\2\2\u033a"+
		"\u033c\5\62\32\2\u033b\u033a\3\2\2\2\u033b\u033c\3\2\2\2\u033c\u033d\3"+
		"\2\2\2\u033d\u033e\7=\2\2\u033e\u033f\7M\2\2\u033f\u0342\5n8\2\u0340\u0341"+
		"\7\u0095\2\2\u0341\u0343\5B\"\2\u0342\u0340\3\2\2\2\u0342\u0343\3\2\2"+
		"\2\u0343\u0348\3\2\2\2\u0344\u0346\5\u0084C\2\u0345\u0344\3\2\2\2\u0345"+
		"\u0346\3\2\2\2\u0346\u0347\3\2\2\2\u0347\u0349\5\u0086D\2\u0348\u0345"+
		"\3\2\2\2\u0348\u0349\3\2\2\2\u0349=\3\2\2\2\u034a\u034c\7?\2\2\u034b\u034d"+
		"\79\2\2\u034c\u034b\3\2\2\2\u034c\u034d\3\2\2\2\u034d\u034e\3\2\2\2\u034e"+
		"\u034f\5\u00b2Z\2\u034f?\3\2\2\2\u0350\u0351\7A\2\2\u0351\u0354\t\13\2"+
		"\2\u0352\u0353\7R\2\2\u0353\u0355\7H\2\2\u0354\u0352\3\2\2\2\u0354\u0355"+
		"\3\2\2\2\u0355\u0359\3\2\2\2\u0356\u0357\5\u00b2Z\2\u0357\u0358\7\4\2"+
		"\2\u0358\u035a\3\2\2\2\u0359\u0356\3\2\2\2\u0359\u035a\3\2\2\2\u035a\u035b"+
		"\3\2\2\2\u035b\u035c\5\u00dep\2\u035cA\3\2\2\2\u035d\u035e\b\"\1\2\u035e"+
		"\u03b6\5F$\2\u035f\u03b6\7\u00bc\2\2\u0360\u0361\5\u00b2Z\2\u0361\u0362"+
		"\7\4\2\2\u0362\u0364\3\2\2\2\u0363\u0360\3\2\2\2\u0363\u0364\3\2\2\2\u0364"+
		"\u0365\3\2\2\2\u0365\u0366\5\u00b4[\2\u0366\u0367\7\4\2\2\u0367\u0369"+
		"\3\2\2\2\u0368\u0363\3\2\2\2\u0368\u0369\3\2\2\2\u0369\u036a\3\2\2\2\u036a"+
		"\u03b6\5\u00ba^\2\u036b\u036c\5\u00a4S\2\u036c\u036d\5B\"\27\u036d\u03b6"+
		"\3\2\2\2\u036e\u036f\5\u00b0Y\2\u036f\u037c\7\5\2\2\u0370\u0372\7@\2\2"+
		"\u0371\u0370\3\2\2\2\u0371\u0372\3\2\2\2\u0372\u0373\3\2\2\2\u0373\u0378"+
		"\5B\"\2\u0374\u0375\7\7\2\2\u0375\u0377\5B\"\2\u0376\u0374\3\2\2\2\u0377"+
		"\u037a\3\2\2\2\u0378\u0376\3\2\2\2\u0378\u0379\3\2\2\2\u0379\u037d\3\2"+
		"\2\2\u037a\u0378\3\2\2\2\u037b\u037d\7\t\2\2\u037c\u0371\3\2\2\2\u037c"+
		"\u037b\3\2\2\2\u037c\u037d\3\2\2\2\u037d\u037e\3\2\2\2\u037e\u0380\7\6"+
		"\2\2\u037f\u0381\5r:\2\u0380\u037f\3\2\2\2\u0380\u0381\3\2\2\2\u0381\u0383"+
		"\3\2\2\2\u0382\u0384\5v<\2\u0383\u0382\3\2\2\2\u0383\u0384\3\2\2\2\u0384"+
		"\u03b6\3\2\2\2\u0385\u0386\7\5\2\2\u0386\u038b\5B\"\2\u0387\u0388\7\7"+
		"\2\2\u0388\u038a\5B\"\2\u0389\u0387\3\2\2\2\u038a\u038d\3\2\2\2\u038b"+
		"\u0389\3\2\2\2\u038b\u038c\3\2\2\2\u038c\u038e\3\2\2\2\u038d\u038b\3\2"+
		"\2\2\u038e\u038f\7\6\2\2\u038f\u03b6\3\2\2\2\u0390\u0391\7-\2\2\u0391"+
		"\u0392\7\5\2\2\u0392\u0393\5B\"\2\u0393\u0394\7#\2\2\u0394\u0395\5 \21"+
		"\2\u0395\u0396\7\6\2\2\u0396\u03b6\3\2\2\2\u0397\u0399\7h\2\2\u0398\u0397"+
		"\3\2\2\2\u0398\u0399\3\2\2\2\u0399\u039a\3\2\2\2\u039a\u039c\7H\2\2\u039b"+
		"\u0398\3\2\2\2\u039b\u039c\3\2\2\2\u039c\u039d\3\2\2\2\u039d\u039e\7\5"+
		"\2\2\u039e\u039f\5R*\2\u039f\u03a0\7\6\2\2\u03a0\u03b6\3\2\2\2\u03a1\u03a3"+
		"\7,\2\2\u03a2\u03a4\5B\"\2\u03a3\u03a2\3\2\2\2\u03a3\u03a4\3\2\2\2\u03a4"+
		"\u03aa\3\2\2\2\u03a5\u03a6\7\u0094\2\2\u03a6\u03a7\5B\"\2\u03a7\u03a8"+
		"\7\u0088\2\2\u03a8\u03a9\5B\"\2\u03a9\u03ab\3\2\2\2\u03aa\u03a5\3\2\2"+
		"\2\u03ab\u03ac\3\2\2\2\u03ac\u03aa\3\2\2\2\u03ac\u03ad\3\2\2\2\u03ad\u03b0"+
		"\3\2\2\2\u03ae\u03af\7C\2\2\u03af\u03b1\5B\"\2\u03b0\u03ae\3\2\2\2\u03b0"+
		"\u03b1\3\2\2\2\u03b1\u03b2\3\2\2\2\u03b2\u03b3\7D\2\2\u03b3\u03b6\3\2"+
		"\2\2\u03b4\u03b6\5D#\2\u03b5\u035d\3\2\2\2\u03b5\u035f\3\2\2\2\u03b5\u0368"+
		"\3\2\2\2\u03b5\u036b\3\2\2\2\u03b5\u036e\3\2\2\2\u03b5\u0385\3\2\2\2\u03b5"+
		"\u0390\3\2\2\2\u03b5\u039b\3\2\2\2\u03b5\u03a1\3\2\2\2\u03b5\u03b4\3\2"+
		"\2\2\u03b6\u042e\3\2\2\2\u03b7\u03b8\f\26\2\2\u03b8\u03b9\7\r\2\2\u03b9"+
		"\u042d\5B\"\27\u03ba\u03bb\f\25\2\2\u03bb\u03bc\t\f\2\2\u03bc\u042d\5"+
		"B\"\26\u03bd\u03be\f\24\2\2\u03be\u03bf\t\6\2\2\u03bf\u042d\5B\"\25\u03c0"+
		"\u03c1\f\23\2\2\u03c1\u03c2\t\r\2\2\u03c2\u042d\5B\"\24\u03c3\u03c4\f"+
		"\22\2\2\u03c4\u03c5\t\16\2\2\u03c5\u042d\5B\"\23\u03c6\u03d3\f\21\2\2"+
		"\u03c7\u03d4\7\b\2\2\u03c8\u03d4\7\30\2\2\u03c9\u03d4\7\31\2\2\u03ca\u03d4"+
		"\7\32\2\2\u03cb\u03d4\7^\2\2\u03cc\u03cd\7^\2\2\u03cd\u03d4\7h\2\2\u03ce"+
		"\u03d4\7U\2\2\u03cf\u03d4\7c\2\2\u03d0\u03d4\7O\2\2\u03d1\u03d4\7e\2\2"+
		"\u03d2\u03d4\7x\2\2\u03d3\u03c7\3\2\2\2\u03d3\u03c8\3\2\2\2\u03d3\u03c9"+
		"\3\2\2\2\u03d3\u03ca\3\2\2\2\u03d3\u03cb\3\2\2\2\u03d3\u03cc\3\2\2\2\u03d3"+
		"\u03ce\3\2\2\2\u03d3\u03cf\3\2\2\2\u03d3\u03d0\3\2\2\2\u03d3\u03d1\3\2"+
		"\2\2\u03d3\u03d2\3\2\2\2\u03d4\u03d5\3\2\2\2\u03d5\u042d\5B\"\22\u03d6"+
		"\u03d7\f\20\2\2\u03d7\u03d8\7\"\2\2\u03d8\u042d\5B\"\21\u03d9\u03da\f"+
		"\17\2\2\u03da\u03db\7n\2\2\u03db\u042d\5B\"\20\u03dc\u03dd\f\b\2\2\u03dd"+
		"\u03df\7^\2\2\u03de\u03e0\7h\2\2\u03df\u03de\3\2\2\2\u03df\u03e0\3\2\2"+
		"\2\u03e0\u03e1\3\2\2\2\u03e1\u042d\5B\"\t\u03e2\u03e4\f\7\2\2\u03e3\u03e5"+
		"\7h\2\2\u03e4\u03e3\3\2\2\2\u03e4\u03e5\3\2\2\2\u03e5\u03e6\3\2\2\2\u03e6"+
		"\u03e7\7)\2\2\u03e7\u03e8\5B\"\2\u03e8\u03e9\7\"\2\2\u03e9\u03ea\5B\""+
		"\b\u03ea\u042d\3\2\2\2\u03eb\u03ec\f\13\2\2\u03ec\u03ed\7/\2\2\u03ed\u042d"+
		"\5\u00bc_\2\u03ee\u03f0\f\n\2\2\u03ef\u03f1\7h\2\2\u03f0\u03ef\3\2\2\2"+
		"\u03f0\u03f1\3\2\2\2\u03f1\u03f2\3\2\2\2\u03f2\u03f3\t\17\2\2\u03f3\u03f6"+
		"\5B\"\2\u03f4\u03f5\7E\2\2\u03f5\u03f7\5B\"\2\u03f6\u03f4\3\2\2\2\u03f6"+
		"\u03f7\3\2\2\2\u03f7\u042d\3\2\2\2\u03f8\u03fd\f\t\2\2\u03f9\u03fe\7_"+
		"\2\2\u03fa\u03fe\7i\2\2\u03fb\u03fc\7h\2\2\u03fc\u03fe\7j\2\2\u03fd\u03f9"+
		"\3\2\2\2\u03fd\u03fa\3\2\2\2\u03fd\u03fb\3\2\2\2\u03fe\u042d\3\2\2\2\u03ff"+
		"\u0401\f\6\2\2\u0400\u0402\7h\2\2\u0401\u0400\3\2\2\2\u0401\u0402\3\2"+
		"\2\2\u0402\u0403\3\2\2\2\u0403\u042a\7U\2\2\u0404\u040e\7\5\2\2\u0405"+
		"\u040f\5R*\2\u0406\u040b\5B\"\2\u0407\u0408\7\7\2\2\u0408\u040a\5B\"\2"+
		"\u0409\u0407\3\2\2\2\u040a\u040d\3\2\2\2\u040b\u0409\3\2\2\2\u040b\u040c"+
		"\3\2\2\2\u040c\u040f\3\2\2\2\u040d\u040b\3\2\2\2\u040e\u0405\3\2\2\2\u040e"+
		"\u0406\3\2\2\2\u040e\u040f\3\2\2\2\u040f\u0410\3\2\2\2\u0410\u042b\7\6"+
		"\2\2\u0411\u0412\5\u00b2Z\2\u0412\u0413\7\4\2\2\u0413\u0415\3\2\2\2\u0414"+
		"\u0411\3\2\2\2\u0414\u0415\3\2\2\2\u0415\u0416\3\2\2\2\u0416\u042b\5\u00b4"+
		"[\2\u0417\u0418\5\u00b2Z\2\u0418\u0419\7\4\2\2\u0419\u041b\3\2\2\2\u041a"+
		"\u0417\3\2\2\2\u041a\u041b\3\2\2\2\u041b\u041c\3\2\2\2\u041c\u041d\5\u00dc"+
		"o\2\u041d\u0426\7\5\2\2\u041e\u0423\5B\"\2\u041f\u0420\7\7\2\2\u0420\u0422"+
		"\5B\"\2\u0421\u041f\3\2\2\2\u0422\u0425\3\2\2\2\u0423\u0421\3\2\2\2\u0423"+
		"\u0424\3\2\2\2\u0424\u0427\3\2\2\2\u0425\u0423\3\2\2\2\u0426\u041e\3\2"+
		"\2\2\u0426\u0427\3\2\2\2\u0427\u0428\3\2\2\2\u0428\u0429\7\6\2\2\u0429"+
		"\u042b\3\2\2\2\u042a\u0404\3\2\2\2\u042a\u0414\3\2\2\2\u042a\u041a\3\2"+
		"\2\2\u042b\u042d\3\2\2\2\u042c\u03b7\3\2\2\2\u042c\u03ba\3\2\2\2\u042c"+
		"\u03bd\3\2\2\2\u042c\u03c0\3\2\2\2\u042c\u03c3\3\2\2\2\u042c\u03c6\3\2"+
		"\2\2\u042c\u03d6\3\2\2\2\u042c\u03d9\3\2\2\2\u042c\u03dc\3\2\2\2\u042c"+
		"\u03e2\3\2\2\2\u042c\u03eb\3\2\2\2\u042c\u03ee\3\2\2\2\u042c\u03f8\3\2"+
		"\2\2\u042c\u03ff\3\2\2\2\u042d\u0430\3\2\2\2\u042e\u042c\3\2\2\2\u042e"+
		"\u042f\3\2\2\2\u042fC\3\2\2\2\u0430\u042e\3\2\2\2\u0431\u0432\7u\2\2\u0432"+
		"\u0437\7\5\2\2\u0433\u0438\7S\2\2\u0434\u0435\t\20\2\2\u0435\u0436\7\7"+
		"\2\2\u0436\u0438\5\u00a6T\2\u0437\u0433\3\2\2\2\u0437\u0434\3\2\2\2\u0438"+
		"\u0439\3\2\2\2\u0439\u043a\7\6\2\2\u043aE\3\2\2\2\u043b\u043c\t\21\2\2"+
		"\u043cG\3\2\2\2\u043d\u043f\5\62\32\2\u043e\u043d\3\2\2\2\u043e\u043f"+
		"\3\2\2\2\u043f\u0445\3\2\2\2\u0440\u0446\7Z\2\2\u0441\u0446\7|\2\2\u0442"+
		"\u0443\7Z\2\2\u0443\u0444\7n\2\2\u0444\u0446\t\n\2\2\u0445\u0440\3\2\2"+
		"\2\u0445\u0441\3\2\2\2\u0445\u0442\3\2\2\2\u0446\u0447\3\2\2\2\u0447\u044b"+
		"\7]\2\2\u0448\u0449\5\u00b2Z\2\u0449\u044a\7\4\2\2\u044a\u044c\3\2\2\2"+
		"\u044b\u0448\3\2\2\2\u044b\u044c\3\2\2\2\u044c\u044d\3\2\2\2\u044d\u0450"+
		"\5\u00b4[\2\u044e\u044f\7#\2\2\u044f\u0451\5\u00ccg\2\u0450\u044e\3\2"+
		"\2\2\u0450\u0451\3\2\2\2\u0451\u045d\3\2\2\2\u0452\u0453\7\5\2\2\u0453"+
		"\u0458\5\u00ba^\2\u0454\u0455\7\7\2\2\u0455\u0457\5\u00ba^\2\u0456\u0454"+
		"\3\2\2\2\u0457\u045a\3\2\2\2\u0458\u0456\3\2\2\2\u0458\u0459\3\2\2\2\u0459"+
		"\u045b\3\2\2\2\u045a\u0458\3\2\2\2\u045b\u045c\7\6\2\2\u045c\u045e\3\2"+
		"\2\2\u045d\u0452\3\2\2\2\u045d\u045e\3\2\2\2\u045e\u047c\3\2\2\2\u045f"+
		"\u0460\7\u0091\2\2\u0460\u0461\7\5\2\2\u0461\u0466\5B\"\2\u0462\u0463"+
		"\7\7\2\2\u0463\u0465\5B\"\2\u0464\u0462\3\2\2\2\u0465\u0468\3\2\2\2\u0466"+
		"\u0464\3\2\2\2\u0466\u0467\3\2\2\2\u0467\u0469\3\2\2\2\u0468\u0466\3\2"+
		"\2\2\u0469\u0478\7\6\2\2\u046a\u046b\7\7\2\2\u046b\u046c\7\5\2\2\u046c"+
		"\u0471\5B\"\2\u046d\u046e\7\7\2\2\u046e\u0470\5B\"\2\u046f\u046d\3\2\2"+
		"\2\u0470\u0473\3\2\2\2\u0471\u046f\3\2\2\2\u0471\u0472\3\2\2\2\u0472\u0474"+
		"\3\2\2\2\u0473\u0471\3\2\2\2\u0474\u0475\7\6\2\2\u0475\u0477\3\2\2\2\u0476"+
		"\u046a\3\2\2\2\u0477\u047a\3\2\2\2\u0478\u0476\3\2\2\2\u0478\u0479\3\2"+
		"\2\2\u0479\u047d\3\2\2\2\u047a\u0478\3\2\2\2\u047b\u047d\5R*\2\u047c\u045f"+
		"\3\2\2\2\u047c\u047b\3\2\2\2\u047d\u047f\3\2\2\2\u047e\u0480\5J&\2\u047f"+
		"\u047e\3\2\2\2\u047f\u0480\3\2\2\2\u0480\u0484\3\2\2\2\u0481\u0482\7:"+
		"\2\2\u0482\u0484\7\u0091\2\2\u0483\u043e\3\2\2\2\u0483\u0481\3\2\2\2\u0484"+
		"I\3\2\2\2\u0485\u0486\7m\2\2\u0486\u0495\7\62\2\2\u0487\u0488\7\5\2\2"+
		"\u0488\u048d\5\32\16\2\u0489\u048a\7\7\2\2\u048a\u048c\5\32\16\2\u048b"+
		"\u0489\3\2\2\2\u048c\u048f\3\2\2\2\u048d\u048b\3\2\2\2\u048d\u048e\3\2"+
		"\2\2\u048e\u0490\3\2\2\2\u048f\u048d\3\2\2\2\u0490\u0493\7\6\2\2\u0491"+
		"\u0492\7\u0095\2\2\u0492\u0494\5B\"\2\u0493\u0491\3\2\2\2\u0493\u0494"+
		"\3\2\2\2\u0494\u0496\3\2\2\2\u0495\u0487\3\2\2\2\u0495\u0496\3\2\2\2\u0496"+
		"\u0497\3\2\2\2\u0497\u04b2\7\u00b8\2\2\u0498\u04b3\7\u00b9\2\2\u0499\u049a"+
		"\7\u008e\2\2\u049a\u049d\7\u0084\2\2\u049b\u049e\5\u00ba^\2\u049c\u049e"+
		"\5j\66\2\u049d\u049b\3\2\2\2\u049d\u049c\3\2\2\2\u049e\u049f\3\2\2\2\u049f"+
		"\u04a0\7\30\2\2\u04a0\u04ab\5B\"\2\u04a1\u04a4\7\7\2\2\u04a2\u04a5\5\u00ba"+
		"^\2\u04a3\u04a5\5j\66\2\u04a4\u04a2\3\2\2\2\u04a4\u04a3\3\2\2\2\u04a5"+
		"\u04a6\3\2\2\2\u04a6\u04a7\7\30\2\2\u04a7\u04a8\5B\"\2\u04a8\u04aa\3\2"+
		"\2\2\u04a9\u04a1\3\2\2\2\u04aa\u04ad\3\2\2\2\u04ab\u04a9\3\2\2\2\u04ab"+
		"\u04ac\3\2\2\2\u04ac\u04b0\3\2\2\2\u04ad\u04ab\3\2\2\2\u04ae\u04af\7\u0095"+
		"\2\2\u04af\u04b1\5B\"\2\u04b0\u04ae\3\2\2\2\u04b0\u04b1\3\2\2\2\u04b1"+
		"\u04b3\3\2\2\2\u04b2\u0498\3\2\2\2\u04b2\u0499\3\2\2\2\u04b3K\3\2\2\2"+
		"\u04b4\u04b8\7r\2\2\u04b5\u04b6\5\u00b2Z\2\u04b6\u04b7\7\4\2\2\u04b7\u04b9"+
		"\3\2\2\2\u04b8\u04b5\3\2\2\2\u04b8\u04b9\3\2\2\2\u04b9\u04ba\3\2\2\2\u04ba"+
		"\u04c1\5\u00c8e\2\u04bb\u04bc\7\b\2\2\u04bc\u04c2\5N(\2\u04bd\u04be\7"+
		"\5\2\2\u04be\u04bf\5N(\2\u04bf\u04c0\7\6\2\2\u04c0\u04c2\3\2\2\2\u04c1"+
		"\u04bb\3\2\2\2\u04c1\u04bd\3\2\2\2\u04c1\u04c2\3\2\2\2\u04c2M\3\2\2\2"+
		"\u04c3\u04c7\5$\23\2\u04c4\u04c7\5\u00aeX\2\u04c5\u04c7\7\u00bd\2\2\u04c6"+
		"\u04c3\3\2\2\2\u04c6\u04c4\3\2\2\2\u04c6\u04c5\3\2\2\2\u04c7O\3\2\2\2"+
		"\u04c8\u04d3\7y\2\2\u04c9\u04d4\5\u00bc_\2\u04ca\u04cb\5\u00b2Z\2\u04cb"+
		"\u04cc\7\4\2\2\u04cc\u04ce\3\2\2\2\u04cd\u04ca\3\2\2\2\u04cd\u04ce\3\2"+
		"\2\2\u04ce\u04d1\3\2\2\2\u04cf\u04d2\5\u00b4[\2\u04d0\u04d2\5\u00c0a\2"+
		"\u04d1\u04cf\3\2\2\2\u04d1\u04d0\3\2\2\2\u04d2\u04d4\3\2\2\2\u04d3\u04c9"+
		"\3\2\2\2\u04d3\u04cd\3\2\2\2\u04d3\u04d4\3\2\2\2\u04d4Q\3\2\2\2\u04d5"+
		"\u04d7\5\u0082B\2\u04d6\u04d5\3\2\2\2\u04d6\u04d7\3\2\2\2\u04d7\u04d8"+
		"\3\2\2\2\u04d8\u04de\5V,\2\u04d9\u04da\5f\64\2\u04da\u04db\5V,\2\u04db"+
		"\u04dd\3\2\2\2\u04dc\u04d9\3\2\2\2\u04dd\u04e0\3\2\2\2\u04de\u04dc\3\2"+
		"\2\2\u04de\u04df\3\2\2\2\u04df\u04e2\3\2\2\2\u04e0\u04de\3\2\2\2\u04e1"+
		"\u04e3\5\u0084C\2\u04e2\u04e1\3\2\2\2\u04e2\u04e3\3\2\2\2\u04e3\u04e5"+
		"\3\2\2\2\u04e4\u04e6\5\u0086D\2\u04e5\u04e4\3\2\2\2\u04e5\u04e6\3\2\2"+
		"\2\u04e6S\3\2\2\2\u04e7\u04ef\5^\60\2\u04e8\u04e9\5b\62\2\u04e9\u04eb"+
		"\5^\60\2\u04ea\u04ec\5d\63\2\u04eb\u04ea\3\2\2\2\u04eb\u04ec\3\2\2\2\u04ec"+
		"\u04ee\3\2\2\2\u04ed\u04e8\3\2\2\2\u04ee\u04f1\3\2\2\2\u04ef\u04ed\3\2"+
		"\2\2\u04ef\u04f0\3\2\2\2\u04f0U\3\2\2\2\u04f1\u04ef\3\2\2\2\u04f2\u04f4"+
		"\7\u0083\2\2\u04f3\u04f5\t\22\2\2\u04f4\u04f3\3\2\2\2\u04f4\u04f5\3\2"+
		"\2\2\u04f5\u04f6\3\2\2\2\u04f6\u04fb\5`\61\2\u04f7\u04f8\7\7\2\2\u04f8"+
		"\u04fa\5`\61\2\u04f9\u04f7\3\2\2\2\u04fa\u04fd\3\2\2\2\u04fb\u04f9\3\2"+
		"\2\2\u04fb\u04fc\3\2\2\2\u04fc\u050a\3\2\2\2\u04fd\u04fb\3\2\2\2\u04fe"+
		"\u0508\7M\2\2\u04ff\u0504\5^\60\2\u0500\u0501\7\7\2\2\u0501\u0503\5^\60"+
		"\2\u0502\u0500\3\2\2\2\u0503\u0506\3\2\2\2\u0504\u0502\3\2\2\2\u0504\u0505"+
		"\3\2\2\2\u0505\u0509\3\2\2\2\u0506\u0504\3\2\2\2\u0507\u0509\5T+\2\u0508"+
		"\u04ff\3\2\2\2\u0508\u0507\3\2\2\2\u0509\u050b\3\2\2\2\u050a\u04fe\3\2"+
		"\2\2\u050a\u050b\3\2\2\2\u050b\u050e\3\2\2\2\u050c\u050d\7\u0095\2\2\u050d"+
		"\u050f\5B\"\2\u050e\u050c\3\2\2\2\u050e\u050f\3\2\2\2\u050f\u051e\3\2"+
		"\2\2\u0510\u0511\7P\2\2\u0511\u0512\7*\2\2\u0512\u0517\5B\"\2\u0513\u0514"+
		"\7\7\2\2\u0514\u0516\5B\"\2\u0515\u0513\3\2\2\2\u0516\u0519\3\2\2\2\u0517"+
		"\u0515\3\2\2\2\u0517\u0518\3\2\2\2\u0518\u051c\3\2\2\2\u0519\u0517\3\2"+
		"\2\2\u051a\u051b\7Q\2\2\u051b\u051d\5B\"\2\u051c\u051a\3\2\2\2\u051c\u051d"+
		"\3\2\2\2\u051d\u051f\3\2\2\2\u051e\u0510\3\2\2\2\u051e\u051f\3\2\2\2\u051f"+
		"\u052e\3\2\2\2\u0520\u0521\7\u00af\2\2\u0521\u0522\5\u00d0i\2\u0522\u0523"+
		"\7#\2\2\u0523\u052b\5t;\2\u0524\u0525\7\7\2\2\u0525\u0526\5\u00d0i\2\u0526"+
		"\u0527\7#\2\2\u0527\u0528\5t;\2\u0528\u052a\3\2\2\2\u0529\u0524\3\2\2"+
		"\2\u052a\u052d\3\2\2\2\u052b\u0529\3\2\2\2\u052b\u052c\3\2\2\2\u052c\u052f"+
		"\3\2\2\2\u052d\u052b\3\2\2\2\u052e\u0520\3\2\2\2\u052e\u052f\3\2\2\2\u052f"+
		"\u054d\3\2\2\2\u0530\u0531\7\u0091\2\2\u0531\u0532\7\5\2\2\u0532\u0537"+
		"\5B\"\2\u0533\u0534\7\7\2\2\u0534\u0536\5B\"\2\u0535\u0533\3\2\2\2\u0536"+
		"\u0539\3\2\2\2\u0537\u0535\3\2\2\2\u0537\u0538\3\2\2\2\u0538\u053a\3\2"+
		"\2\2\u0539\u0537\3\2\2\2\u053a\u0549\7\6\2\2\u053b\u053c\7\7\2\2\u053c"+
		"\u053d\7\5\2\2\u053d\u0542\5B\"\2\u053e\u053f\7\7\2\2\u053f\u0541\5B\""+
		"\2\u0540\u053e\3\2\2\2\u0541\u0544\3\2\2\2\u0542\u0540\3\2\2\2\u0542\u0543"+
		"\3\2\2\2\u0543\u0545\3\2\2\2\u0544\u0542\3\2\2\2\u0545\u0546\7\6\2\2\u0546"+
		"\u0548\3\2\2\2\u0547\u053b\3\2\2\2\u0548\u054b\3\2\2\2\u0549\u0547\3\2"+
		"\2\2\u0549\u054a\3\2\2\2\u054a\u054d\3\2\2\2\u054b\u0549\3\2\2\2\u054c"+
		"\u04f2\3\2\2\2\u054c\u0530\3\2\2\2\u054dW\3\2\2\2\u054e\u054f\5R*\2\u054f"+
		"Y\3\2\2\2\u0550\u0552\5\u0082B\2\u0551\u0550\3\2\2\2\u0551\u0552\3\2\2"+
		"\2\u0552\u0553\3\2\2\2\u0553\u0555\5V,\2\u0554\u0556\5\u0084C\2\u0555"+
		"\u0554\3\2\2\2\u0555\u0556\3\2\2\2\u0556\u0558\3\2\2\2\u0557\u0559\5\u0086"+
		"D\2\u0558\u0557\3\2\2\2\u0558\u0559\3\2\2\2\u0559[\3\2\2\2\u055a\u055c"+
		"\5\u0082B\2\u055b\u055a\3\2\2\2\u055b\u055c\3\2\2\2\u055c\u055d\3\2\2"+
		"\2\u055d\u0567\5V,\2\u055e\u0560\7\u008c\2\2\u055f\u0561\7\37\2\2\u0560"+
		"\u055f\3\2\2\2\u0560\u0561\3\2\2\2\u0561\u0565\3\2\2\2\u0562\u0565\7\\"+
		"\2\2\u0563\u0565\7F\2\2\u0564\u055e\3\2\2\2\u0564\u0562\3\2\2\2\u0564"+
		"\u0563\3\2\2\2\u0565\u0566\3\2\2\2\u0566\u0568\5V,\2\u0567\u0564\3\2\2"+
		"\2\u0568\u0569\3\2\2\2\u0569\u0567\3\2\2\2\u0569\u056a\3\2\2\2\u056a\u056c"+
		"\3\2\2\2\u056b\u056d\5\u0084C\2\u056c\u056b\3\2\2\2\u056c\u056d\3\2\2"+
		"\2\u056d\u056f\3\2\2\2\u056e\u0570\5\u0086D\2\u056f\u056e\3\2\2\2\u056f"+
		"\u0570\3\2\2\2\u0570]\3\2\2\2\u0571\u0572\5\u00b2Z\2\u0572\u0573\7\4\2"+
		"\2\u0573\u0575\3\2\2\2\u0574\u0571\3\2\2\2\u0574\u0575\3\2\2\2\u0575\u0576"+
		"\3\2\2\2\u0576\u057b\5\u00b4[\2\u0577\u0579\7#\2\2\u0578\u0577\3\2\2\2"+
		"\u0578\u0579\3\2\2\2\u0579\u057a\3\2\2\2\u057a\u057c\5\u00ccg\2\u057b"+
		"\u0578\3\2\2\2\u057b\u057c\3\2\2\2\u057c\u0582\3\2\2\2\u057d\u057e\7W"+
		"\2\2\u057e\u057f\7*\2\2\u057f\u0583\5\u00c0a\2\u0580\u0581\7h\2\2\u0581"+
		"\u0583\7W\2\2\u0582\u057d\3\2\2\2\u0582\u0580\3\2\2\2\u0582\u0583\3\2"+
		"\2\2\u0583\u05b2\3\2\2\2\u0584\u0585\5\u00b2Z\2\u0585\u0586\7\4\2\2\u0586"+
		"\u0588\3\2\2\2\u0587\u0584\3\2\2\2\u0587\u0588\3\2\2\2\u0588\u0589\3\2"+
		"\2\2\u0589\u058a\5\u00dco\2\u058a\u058b\7\5\2\2\u058b\u0590\5B\"\2\u058c"+
		"\u058d\7\7\2\2\u058d\u058f\5B\"\2\u058e\u058c\3\2\2\2\u058f\u0592\3\2"+
		"\2\2\u0590\u058e\3\2\2\2\u0590\u0591\3\2\2\2\u0591\u0593\3\2\2\2\u0592"+
		"\u0590\3\2\2\2\u0593\u0598\7\6\2\2\u0594\u0596\7#\2\2\u0595\u0594\3\2"+
		"\2\2\u0595\u0596\3\2\2\2\u0596\u0597\3\2\2\2\u0597\u0599\5\u00ccg\2\u0598"+
		"\u0595\3\2\2\2\u0598\u0599\3\2\2\2\u0599\u05b2\3\2\2\2\u059a\u05a4\7\5"+
		"\2\2\u059b\u05a0\5^\60\2\u059c\u059d\7\7\2\2\u059d\u059f\5^\60\2\u059e"+
		"\u059c\3\2\2\2\u059f\u05a2\3\2\2\2\u05a0\u059e\3\2\2\2\u05a0\u05a1\3\2"+
		"\2\2\u05a1\u05a5\3\2\2\2\u05a2\u05a0\3\2\2\2\u05a3\u05a5\5T+\2\u05a4\u059b"+
		"\3\2\2\2\u05a4\u05a3\3\2\2\2\u05a5\u05a6\3\2\2\2\u05a6\u05a7\7\6\2\2\u05a7"+
		"\u05b2\3\2\2\2\u05a8\u05a9\7\5\2\2\u05a9\u05aa\5R*\2\u05aa\u05af\7\6\2"+
		"\2\u05ab\u05ad\7#\2\2\u05ac\u05ab\3\2\2\2\u05ac\u05ad\3\2\2\2\u05ad\u05ae"+
		"\3\2\2\2\u05ae\u05b0\5\u00ccg\2\u05af\u05ac\3\2\2\2\u05af\u05b0\3\2\2"+
		"\2\u05b0\u05b2\3\2\2\2\u05b1\u0574\3\2\2\2\u05b1\u0587\3\2\2\2\u05b1\u059a"+
		"\3\2\2\2\u05b1\u05a8\3\2\2\2\u05b2_\3\2\2\2\u05b3\u05c0\7\t\2\2\u05b4"+
		"\u05b5\5\u00b4[\2\u05b5\u05b6\7\4\2\2\u05b6\u05b7\7\t\2\2\u05b7\u05c0"+
		"\3\2\2\2\u05b8\u05bd\5B\"\2\u05b9\u05bb\7#\2\2\u05ba\u05b9\3\2\2\2\u05ba"+
		"\u05bb\3\2\2\2\u05bb\u05bc\3\2\2\2\u05bc\u05be\5\u00aaV\2\u05bd\u05ba"+
		"\3\2\2\2\u05bd\u05be\3\2\2\2\u05be\u05c0\3\2\2\2\u05bf\u05b3\3\2\2\2\u05bf"+
		"\u05b4\3\2\2\2\u05bf\u05b8\3\2\2\2\u05c0a\3\2\2\2\u05c1\u05cf\7\7\2\2"+
		"\u05c2\u05c4\7f\2\2\u05c3\u05c2\3\2\2\2\u05c3\u05c4\3\2\2\2\u05c4\u05cb"+
		"\3\2\2\2\u05c5\u05c7\7b\2\2\u05c6\u05c8\7p\2\2\u05c7\u05c6\3\2\2\2\u05c7"+
		"\u05c8\3\2\2\2\u05c8\u05cc\3\2\2\2\u05c9\u05cc\7Y\2\2\u05ca\u05cc\7\65"+
		"\2\2\u05cb\u05c5\3\2\2\2\u05cb\u05c9\3\2\2\2\u05cb\u05ca\3\2\2\2\u05cb"+
		"\u05cc\3\2\2\2\u05cc\u05cd\3\2\2\2\u05cd\u05cf\7`\2\2\u05ce\u05c1\3\2"+
		"\2\2\u05ce\u05c3\3\2\2\2\u05cfc\3\2\2\2\u05d0\u05d1\7m\2\2\u05d1\u05df"+
		"\5B\"\2\u05d2\u05d3\7\u008f\2\2\u05d3\u05d4\7\5\2\2\u05d4\u05d9\5\u00ba"+
		"^\2\u05d5\u05d6\7\7\2\2\u05d6\u05d8\5\u00ba^\2\u05d7\u05d5\3\2\2\2\u05d8"+
		"\u05db\3\2\2\2\u05d9\u05d7\3\2\2\2\u05d9\u05da\3\2\2\2\u05da\u05dc\3\2"+
		"\2\2\u05db\u05d9\3\2\2\2\u05dc\u05dd\7\6\2\2\u05dd\u05df\3\2\2\2\u05de"+
		"\u05d0\3\2\2\2\u05de\u05d2\3\2\2\2\u05dfe\3\2\2\2\u05e0\u05e2\7\u008c"+
		"\2\2\u05e1\u05e3\7\37\2\2\u05e2\u05e1\3\2\2\2\u05e2\u05e3\3\2\2\2\u05e3"+
		"\u05e7\3\2\2\2\u05e4\u05e7\7\\\2\2\u05e5\u05e7\7F\2\2\u05e6\u05e0\3\2"+
		"\2\2\u05e6\u05e4\3\2\2\2\u05e6\u05e5\3\2\2\2\u05e7g\3\2\2\2\u05e8\u05ea"+
		"\5\62\32\2\u05e9\u05e8\3\2\2\2\u05e9\u05ea\3\2\2\2\u05ea\u05eb\3\2\2\2"+
		"\u05eb\u05ee\7\u008e\2\2\u05ec\u05ed\7n\2\2\u05ed\u05ef\t\n\2\2\u05ee"+
		"\u05ec\3\2\2\2\u05ee\u05ef\3\2\2\2\u05ef\u05f0\3\2\2\2\u05f0\u05f1\5n"+
		"8\2\u05f1\u05f4\7\u0084\2\2\u05f2\u05f5\5\u00ba^\2\u05f3\u05f5\5j\66\2"+
		"\u05f4\u05f2\3\2\2\2\u05f4\u05f3\3\2\2\2\u05f5\u05f6\3\2\2\2\u05f6\u05f7"+
		"\7\b\2\2\u05f7\u0602\5B\"\2\u05f8\u05fb\7\7\2\2\u05f9\u05fc\5\u00ba^\2"+
		"\u05fa\u05fc\5j\66\2\u05fb\u05f9\3\2\2\2\u05fb\u05fa\3\2\2\2\u05fc\u05fd"+
		"\3\2\2\2\u05fd\u05fe\7\b\2\2\u05fe\u05ff\5B\"\2\u05ff\u0601\3\2\2\2\u0600"+
		"\u05f8\3\2\2\2\u0601\u0604\3\2\2\2\u0602\u0600\3\2\2\2\u0602\u0603\3\2"+
		"\2\2\u0603\u0607\3\2\2\2\u0604\u0602\3\2\2\2\u0605\u0606\7\u0095\2\2\u0606"+
		"\u0608\5B\"\2\u0607\u0605\3\2\2\2\u0607\u0608\3\2\2\2\u0608i\3\2\2\2\u0609"+
		"\u060a\7\5\2\2\u060a\u060f\5\u00ba^\2\u060b\u060c\7\7\2\2\u060c\u060e"+
		"\5\u00ba^\2\u060d\u060b\3\2\2\2\u060e\u0611\3\2\2\2\u060f\u060d\3\2\2"+
		"\2\u060f\u0610\3\2\2\2\u0610\u0612\3\2\2\2\u0611\u060f\3\2\2\2\u0612\u0613"+
		"\7\6\2\2\u0613k\3\2\2\2\u0614\u0616\5\62\32\2\u0615\u0614\3\2\2\2\u0615"+
		"\u0616\3\2\2\2\u0616\u0617\3\2\2\2\u0617\u061a\7\u008e\2\2\u0618\u0619"+
		"\7n\2\2\u0619\u061b\t\n\2\2\u061a\u0618\3\2\2\2\u061a\u061b\3\2\2\2\u061b"+
		"\u061c\3\2\2\2\u061c\u061d\5n8\2\u061d\u0620\7\u0084\2\2\u061e\u0621\5"+
		"\u00ba^\2\u061f\u0621\5j\66\2\u0620\u061e\3\2\2\2\u0620\u061f\3\2\2\2"+
		"\u0621\u0622\3\2\2\2\u0622\u0623\7\b\2\2\u0623\u062e\5B\"\2\u0624\u0627"+
		"\7\7\2\2\u0625\u0628\5\u00ba^\2\u0626\u0628\5j\66\2\u0627\u0625\3\2\2"+
		"\2\u0627\u0626\3\2\2\2\u0628\u0629\3\2\2\2\u0629\u062a\7\b\2\2\u062a\u062b"+
		"\5B\"\2\u062b\u062d\3\2\2\2\u062c\u0624\3\2\2\2\u062d\u0630\3\2\2\2\u062e"+
		"\u062c\3\2\2\2\u062e\u062f\3\2\2\2\u062f\u0633\3\2\2\2\u0630\u062e\3\2"+
		"\2\2\u0631\u0632\7\u0095\2\2\u0632\u0634\5B\"\2\u0633\u0631\3\2\2\2\u0633"+
		"\u0634\3\2\2\2\u0634\u0639\3\2\2\2\u0635\u0637\5\u0084C\2\u0636\u0635"+
		"\3\2\2\2\u0636\u0637\3\2\2\2\u0637\u0638\3\2\2\2\u0638\u063a\5\u0086D"+
		"\2\u0639\u0636\3\2\2\2\u0639\u063a\3\2\2\2\u063am\3\2\2\2\u063b\u063c"+
		"\5\u00b2Z\2\u063c\u063d\7\4\2\2\u063d\u063f\3\2\2\2\u063e\u063b\3\2\2"+
		"\2\u063e\u063f\3\2\2\2\u063f\u0640\3\2\2\2\u0640\u0643\5\u00b4[\2\u0641"+
		"\u0642\7#\2\2\u0642\u0644\5\u00d2j\2\u0643\u0641\3\2\2\2\u0643\u0644\3"+
		"\2\2\2\u0644\u064a\3\2\2\2\u0645\u0646\7W\2\2\u0646\u0647\7*\2\2\u0647"+
		"\u064b\5\u00c0a\2\u0648\u0649\7h\2\2\u0649\u064b\7W\2\2\u064a\u0645\3"+
		"\2\2\2\u064a\u0648\3\2\2\2\u064a\u064b\3\2\2\2\u064bo\3\2\2\2\u064c\u064e"+
		"\7\u0090\2\2\u064d\u064f\5\u00b2Z\2\u064e\u064d\3\2\2\2\u064e\u064f\3"+
		"\2\2\2\u064f\u0652\3\2\2\2\u0650\u0651\7]\2\2\u0651\u0653\5\u00d4k\2\u0652"+
		"\u0650\3\2\2\2\u0652\u0653\3\2\2\2\u0653q\3\2\2\2\u0654\u0655\7\u00b3"+
		"\2\2\u0655\u0656\7\5\2\2\u0656\u0657\7\u0095\2\2\u0657\u0658\5B\"\2\u0658"+
		"\u0659\7\6\2\2\u0659s\3\2\2\2\u065a\u065c\7\5\2\2\u065b\u065d\5\u00d6"+
		"l\2\u065c\u065b\3\2\2\2\u065c\u065d\3\2\2\2\u065d\u0668\3\2\2\2\u065e"+
		"\u065f\7\u009a\2\2\u065f\u0660\7*\2\2\u0660\u0665\5B\"\2\u0661\u0662\7"+
		"\7\2\2\u0662\u0664\5B\"\2\u0663\u0661\3\2\2\2\u0664\u0667\3\2\2\2\u0665"+
		"\u0663\3\2\2\2\u0665\u0666\3\2\2\2\u0666\u0669\3\2\2\2\u0667\u0665\3\2"+
		"\2\2\u0668\u065e\3\2\2\2\u0668\u0669\3\2\2\2\u0669\u066a\3\2\2\2\u066a"+
		"\u066b\7o\2\2\u066b\u066c\7*\2\2\u066c\u0671\5\u0088E\2\u066d\u066e\7"+
		"\7\2\2\u066e\u0670\5\u0088E\2\u066f\u066d\3\2\2\2\u0670\u0673\3\2\2\2"+
		"\u0671\u066f\3\2\2\2\u0671\u0672\3\2\2\2\u0672\u0675\3\2\2\2\u0673\u0671"+
		"\3\2\2\2\u0674\u0676\5x=\2\u0675\u0674\3\2\2\2\u0675\u0676\3\2\2\2\u0676"+
		"\u0677\3\2\2\2\u0677\u0678\7\6\2\2\u0678u\3\2\2\2\u0679\u069b\7\u0099"+
		"\2\2\u067a\u069c\5\u00d0i\2\u067b\u067d\7\5\2\2\u067c\u067e\5\u00d6l\2"+
		"\u067d\u067c\3\2\2\2\u067d\u067e\3\2\2\2\u067e\u0689\3\2\2\2\u067f\u0680"+
		"\7\u009a\2\2\u0680\u0681\7*\2\2\u0681\u0686\5B\"\2\u0682\u0683\7\7\2\2"+
		"\u0683\u0685\5B\"\2\u0684\u0682\3\2\2\2\u0685\u0688\3\2\2\2\u0686\u0684"+
		"\3\2\2\2\u0686\u0687\3\2\2\2\u0687\u068a\3\2\2\2\u0688\u0686\3\2\2\2\u0689"+
		"\u067f\3\2\2\2\u0689\u068a\3\2\2\2\u068a\u0695\3\2\2\2\u068b\u068c\7o"+
		"\2\2\u068c\u068d\7*\2\2\u068d\u0692\5\u0088E\2\u068e\u068f\7\7\2\2\u068f"+
		"\u0691\5\u0088E\2\u0690\u068e\3\2\2\2\u0691\u0694\3\2\2\2\u0692\u0690"+
		"\3\2\2\2\u0692\u0693\3\2\2\2\u0693\u0696\3\2\2\2\u0694\u0692\3\2\2\2\u0695"+
		"\u068b\3\2\2\2\u0695\u0696\3\2\2\2\u0696\u0698\3\2\2\2\u0697\u0699\5x"+
		"=\2\u0698\u0697\3\2\2\2\u0698\u0699\3\2\2\2\u0699\u069a\3\2\2\2\u069a"+
		"\u069c\7\6\2\2\u069b\u067a\3\2\2\2\u069b\u067b\3\2\2\2\u069cw\3\2\2\2"+
		"\u069d\u06a5\5z>\2\u069e\u069f\7\u00b5\2\2\u069f\u06a0\7g\2\2\u06a0\u06a6"+
		"\7\u00b7\2\2\u06a1\u06a2\7\u009e\2\2\u06a2\u06a6\7\u0080\2\2\u06a3\u06a6"+
		"\7P\2\2\u06a4\u06a6\7\u00b6\2\2\u06a5\u069e\3\2\2\2\u06a5\u06a1\3\2\2"+
		"\2\u06a5\u06a3\3\2\2\2\u06a5\u06a4\3\2\2\2\u06a5\u06a6\3\2\2\2\u06a6y"+
		"\3\2\2\2\u06a7\u06ae\t\23\2\2\u06a8\u06af\5\u0090I\2\u06a9\u06aa\7)\2"+
		"\2\u06aa\u06ab\5\u008cG\2\u06ab\u06ac\7\"\2\2\u06ac\u06ad\5\u008eH\2\u06ad"+
		"\u06af\3\2\2\2\u06ae\u06a8\3\2\2\2\u06ae\u06a9\3\2\2\2\u06af{\3\2\2\2"+
		"\u06b0\u06b1\5\u00d8m\2\u06b1\u06bb\7\5\2\2\u06b2\u06b7\5B\"\2\u06b3\u06b4"+
		"\7\7\2\2\u06b4\u06b6\5B\"\2\u06b5\u06b3\3\2\2\2\u06b6\u06b9\3\2\2\2\u06b7"+
		"\u06b5\3\2\2\2\u06b7\u06b8\3\2\2\2\u06b8\u06bc\3\2\2\2\u06b9\u06b7\3\2"+
		"\2\2\u06ba\u06bc\7\t\2\2\u06bb\u06b2\3\2\2\2\u06bb\u06ba\3\2\2\2\u06bc"+
		"\u06bd\3\2\2\2\u06bd\u06be\7\6\2\2\u06be}\3\2\2\2\u06bf\u06c0\5\u00da"+
		"n\2\u06c0\u06cd\7\5\2\2\u06c1\u06c3\7@\2\2\u06c2\u06c1\3\2\2\2\u06c2\u06c3"+
		"\3\2\2\2\u06c3\u06c4\3\2\2\2\u06c4\u06c9\5B\"\2\u06c5\u06c6\7\7\2\2\u06c6"+
		"\u06c8\5B\"\2\u06c7\u06c5\3\2\2\2\u06c8\u06cb\3\2\2\2\u06c9\u06c7\3\2"+
		"\2\2\u06c9\u06ca\3\2\2\2\u06ca\u06ce\3\2\2\2\u06cb\u06c9\3\2\2\2\u06cc"+
		"\u06ce\7\t\2\2\u06cd\u06c2\3\2\2\2\u06cd\u06cc\3\2\2\2\u06cd\u06ce\3\2"+
		"\2\2\u06ce\u06cf\3\2\2\2\u06cf\u06d1\7\6\2\2\u06d0\u06d2\5r:\2\u06d1\u06d0"+
		"\3\2\2\2\u06d1\u06d2\3\2\2\2\u06d2\177\3\2\2\2\u06d3\u06d4\5\u0092J\2"+
		"\u06d4\u06de\7\5\2\2\u06d5\u06da\5B\"\2\u06d6\u06d7\7\7\2\2\u06d7\u06d9"+
		"\5B\"\2\u06d8\u06d6\3\2\2\2\u06d9\u06dc\3\2\2\2\u06da\u06d8\3\2\2\2\u06da"+
		"\u06db\3\2\2\2\u06db\u06df\3\2\2\2\u06dc\u06da\3\2\2\2\u06dd\u06df\7\t"+
		"\2\2\u06de\u06d5\3\2\2\2\u06de\u06dd\3\2\2\2\u06de\u06df\3\2\2\2\u06df"+
		"\u06e0\3\2\2\2\u06e0\u06e2\7\6\2\2\u06e1\u06e3\5r:\2\u06e2\u06e1\3\2\2"+
		"\2\u06e2\u06e3\3\2\2\2\u06e3\u06e4\3\2\2\2\u06e4\u06e7\7\u0099\2\2\u06e5"+
		"\u06e8\5t;\2\u06e6\u06e8\5\u00d0i\2\u06e7\u06e5\3\2\2\2\u06e7\u06e6\3"+
		"\2\2\2\u06e8\u0081\3\2\2\2\u06e9\u06eb\7\u0096\2\2\u06ea\u06ec\7v\2\2"+
		"\u06eb\u06ea\3\2\2\2\u06eb\u06ec\3\2\2\2\u06ec\u06ed\3\2\2\2\u06ed\u06f2"+
		"\58\35\2\u06ee\u06ef\7\7\2\2\u06ef\u06f1\58\35\2\u06f0\u06ee\3\2\2\2\u06f1"+
		"\u06f4\3\2\2\2\u06f2\u06f0\3\2\2\2\u06f2\u06f3\3\2\2\2\u06f3\u0083\3\2"+
		"\2\2\u06f4\u06f2\3\2\2\2\u06f5\u06f6\7o\2\2\u06f6\u06f7\7*\2\2\u06f7\u06fc"+
		"\5\u0088E\2\u06f8\u06f9\7\7\2\2\u06f9\u06fb\5\u0088E\2\u06fa\u06f8\3\2"+
		"\2\2\u06fb\u06fe\3\2\2\2\u06fc\u06fa\3\2\2\2\u06fc\u06fd\3\2\2\2\u06fd"+
		"\u0085\3\2\2\2\u06fe\u06fc\3\2\2\2\u06ff\u0700\7d\2\2\u0700\u0703\5B\""+
		"\2\u0701\u0702\t\24\2\2\u0702\u0704\5B\"\2\u0703\u0701\3\2\2\2\u0703\u0704"+
		"\3\2\2\2\u0704\u0087\3\2\2\2\u0705\u0708\5B\"\2\u0706\u0707\7/\2\2\u0707"+
		"\u0709\5\u00bc_\2\u0708\u0706\3\2\2\2\u0708\u0709\3\2\2\2\u0709\u070b"+
		"\3\2\2\2\u070a\u070c\5\u008aF\2\u070b\u070a\3\2\2\2\u070b\u070c\3\2\2"+
		"\2\u070c\u070f\3\2\2\2\u070d\u070e\7\u00b0\2\2\u070e\u0710\t\25\2\2\u070f"+
		"\u070d\3\2\2\2\u070f\u0710\3\2\2\2\u0710\u0089\3\2\2\2\u0711\u0712\t\26"+
		"\2\2\u0712\u008b\3\2\2\2\u0713\u0714\5B\"\2\u0714\u0715\7\u009c\2\2\u0715"+
		"\u071e\3\2\2\2\u0716\u0717\5B\"\2\u0717\u0718\7\u009f\2\2\u0718\u071e"+
		"\3\2\2\2\u0719\u071a\7\u009e\2\2\u071a\u071e\7\u0080\2\2\u071b\u071c\7"+
		"\u009d\2\2\u071c\u071e\7\u009c\2\2\u071d\u0713\3\2\2\2\u071d\u0716\3\2"+
		"\2\2\u071d\u0719\3\2\2\2\u071d\u071b\3\2\2\2\u071e\u008d\3\2\2\2\u071f"+
		"\u0720\5B\"\2\u0720\u0721\7\u009c\2\2\u0721\u072a\3\2\2\2\u0722\u0723"+
		"\5B\"\2\u0723\u0724\7\u009f\2\2\u0724\u072a\3\2\2\2\u0725\u0726\7\u009e"+
		"\2\2\u0726\u072a\7\u0080\2\2\u0727\u0728\7\u009d\2\2\u0728\u072a\7\u009f"+
		"\2\2\u0729\u071f\3\2\2\2\u0729\u0722\3\2\2\2\u0729\u0725\3\2\2\2\u0729"+
		"\u0727\3\2\2\2\u072a\u008f\3\2\2\2\u072b\u072c\5B\"\2\u072c\u072d\7\u009c"+
		"\2\2\u072d\u0733\3\2\2\2\u072e\u072f\7\u009d\2\2\u072f\u0733\7\u009c\2"+
		"\2\u0730\u0731\7\u009e\2\2\u0731\u0733\7\u0080\2\2\u0732\u072b\3\2\2\2"+
		"\u0732\u072e\3\2\2\2\u0732\u0730\3\2\2\2\u0733\u0091\3\2\2\2\u0734\u0735"+
		"\t\27\2\2\u0735\u0736\7\5\2\2\u0736\u0737\5B\"\2\u0737\u0738\7\6\2\2\u0738"+
		"\u0739\7\u0099\2\2\u0739\u073b\7\5\2\2\u073a\u073c\5\u0098M\2\u073b\u073a"+
		"\3\2\2\2\u073b\u073c\3\2\2\2\u073c\u073d\3\2\2\2\u073d\u073f\5\u009cO"+
		"\2\u073e\u0740\5z>\2\u073f\u073e\3\2\2\2\u073f\u0740\3\2\2\2\u0740\u0741"+
		"\3\2\2\2\u0741\u0742\7\6\2\2\u0742\u078a\3\2\2\2\u0743\u0744\t\30\2\2"+
		"\u0744\u0745\7\5\2\2\u0745\u0746\7\6\2\2\u0746\u0747\7\u0099\2\2\u0747"+
		"\u0749\7\5\2\2\u0748\u074a\5\u0098M\2\u0749\u0748\3\2\2\2\u0749\u074a"+
		"\3\2\2\2\u074a\u074c\3\2\2\2\u074b\u074d\5\u009aN\2\u074c\u074b\3\2\2"+
		"\2\u074c\u074d\3\2\2\2\u074d\u074e\3\2\2\2\u074e\u078a\7\6\2\2\u074f\u0750"+
		"\t\31\2\2\u0750\u0751\7\5\2\2\u0751\u0752\7\6\2\2\u0752\u0753\7\u0099"+
		"\2\2\u0753\u0755\7\5\2\2\u0754\u0756\5\u0098M\2\u0755\u0754\3\2\2\2\u0755"+
		"\u0756\3\2\2\2\u0756\u0757\3\2\2\2\u0757\u0758\5\u009cO\2\u0758\u0759"+
		"\7\6\2\2\u0759\u078a\3\2\2\2\u075a\u075b\t\32\2\2\u075b\u075c\7\5\2\2"+
		"\u075c\u075e\5B\"\2\u075d\u075f\5\u0094K\2\u075e\u075d\3\2\2\2\u075e\u075f"+
		"\3\2\2\2\u075f\u0761\3\2\2\2\u0760\u0762\5\u0096L\2\u0761\u0760\3\2\2"+
		"\2\u0761\u0762\3\2\2\2\u0762\u0763\3\2\2\2\u0763\u0764\7\6\2\2\u0764\u0765"+
		"\7\u0099\2\2\u0765\u0767\7\5\2\2\u0766\u0768\5\u0098M\2\u0767\u0766\3"+
		"\2\2\2\u0767\u0768\3\2\2\2\u0768\u0769\3\2\2\2\u0769\u076a\5\u009cO\2"+
		"\u076a\u076b\7\6\2\2\u076b\u078a\3\2\2\2\u076c\u076d\7\u00a5\2\2\u076d"+
		"\u076e\7\5\2\2\u076e\u076f\5B\"\2\u076f\u0770\7\7\2\2\u0770\u0771\5$\23"+
		"\2\u0771\u0772\7\6\2\2\u0772\u0773\7\u0099\2\2\u0773\u0775\7\5\2\2\u0774"+
		"\u0776\5\u0098M\2\u0775\u0774\3\2\2\2\u0775\u0776\3\2\2\2\u0776\u0777"+
		"\3\2\2\2\u0777\u0779\5\u009cO\2\u0778\u077a\5z>\2\u0779\u0778\3\2\2\2"+
		"\u0779\u077a\3\2\2\2\u077a\u077b\3\2\2\2\u077b\u077c\7\6\2\2\u077c\u078a"+
		"\3\2\2\2\u077d\u077e\7\u00a6\2\2\u077e\u077f\7\5\2\2\u077f\u0780\5B\""+
		"\2\u0780\u0781\7\6\2\2\u0781\u0782\7\u0099\2\2\u0782\u0784\7\5\2\2\u0783"+
		"\u0785\5\u0098M\2\u0784\u0783\3\2\2\2\u0784\u0785\3\2\2\2\u0785\u0786"+
		"\3\2\2\2\u0786\u0787\5\u009cO\2\u0787\u0788\7\6\2\2\u0788\u078a\3\2\2"+
		"\2\u0789\u0734\3\2\2\2\u0789\u0743\3\2\2\2\u0789\u074f\3\2\2\2\u0789\u075a"+
		"\3\2\2\2\u0789\u076c\3\2\2\2\u0789\u077d\3\2\2\2\u078a\u0093\3\2\2\2\u078b"+
		"\u078c\7\7\2\2\u078c\u078d\5$\23\2\u078d\u0095\3\2\2\2\u078e\u078f\7\7"+
		"\2\2\u078f\u0790\5$\23\2\u0790\u0097\3\2\2\2\u0791\u0792\7\u009a\2\2\u0792"+
		"\u0794\7*\2\2\u0793\u0795\5B\"\2\u0794\u0793\3\2\2\2\u0795\u0796\3\2\2"+
		"\2\u0796\u0794\3\2\2\2\u0796\u0797\3\2\2\2\u0797\u0099\3\2\2\2\u0798\u0799"+
		"\7o\2\2\u0799\u079b\7*\2\2\u079a\u079c\5B\"\2\u079b\u079a\3\2\2\2\u079c"+
		"\u079d\3\2\2\2\u079d\u079b\3\2\2\2\u079d\u079e\3\2\2\2\u079e\u009b\3\2"+
		"\2\2\u079f\u07a0\7o\2\2\u07a0\u07a1\7*\2\2\u07a1\u07a2\5\u009cO\2\u07a2"+
		"\u009d\3\2\2\2\u07a3\u07a5\5B\"\2\u07a4\u07a6\5\u008aF\2\u07a5\u07a4\3"+
		"\2\2\2\u07a5\u07a6\3\2\2\2\u07a6\u07ae\3\2\2\2\u07a7\u07a8\7\7\2\2\u07a8"+
		"\u07aa\5B\"\2\u07a9\u07ab\5\u008aF\2\u07aa\u07a9\3\2\2\2\u07aa\u07ab\3"+
		"\2\2\2\u07ab\u07ad\3\2\2\2\u07ac\u07a7\3\2\2\2\u07ad\u07b0\3\2\2\2\u07ae"+
		"\u07ac\3\2\2\2\u07ae\u07af\3\2\2\2\u07af\u009f\3\2\2\2\u07b0\u07ae\3\2"+
		"\2\2\u07b1\u07b2\5R*\2\u07b2\u00a1\3\2\2\2\u07b3\u07b4\5R*\2\u07b4\u00a3"+
		"\3\2\2\2\u07b5\u07b6\t\33\2\2\u07b6\u00a5\3\2\2\2\u07b7\u07b8\7\u00bd"+
		"\2\2\u07b8\u00a7\3\2\2\2\u07b9\u07bc\5B\"\2\u07ba\u07bc\5\36\20\2\u07bb"+
		"\u07b9\3\2\2\2\u07bb\u07ba\3\2\2\2\u07bc\u00a9\3\2\2\2\u07bd\u07be\t\34"+
		"\2\2\u07be\u00ab\3\2\2\2\u07bf\u07c0\t\35\2\2\u07c0\u00ad\3\2\2\2\u07c1"+
		"\u07c2\5\u00dep\2\u07c2\u00af\3\2\2\2\u07c3\u07c4\5\u00dep\2\u07c4\u00b1"+
		"\3\2\2\2\u07c5\u07c6\5\u00dep\2\u07c6\u00b3\3\2\2\2\u07c7\u07c8\5\u00de"+
		"p\2\u07c8\u00b5\3\2\2\2\u07c9\u07ca\5\u00dep\2\u07ca\u00b7\3\2\2\2\u07cb"+
		"\u07cc\5\u00dep\2\u07cc\u00b9\3\2\2\2\u07cd\u07ce\5\u00dep\2\u07ce\u00bb"+
		"\3\2\2\2\u07cf\u07d0\5\u00dep\2\u07d0\u00bd\3\2\2\2\u07d1\u07d2\5\u00de"+
		"p\2\u07d2\u00bf\3\2\2\2\u07d3\u07d4\5\u00dep\2\u07d4\u00c1\3\2\2\2\u07d5"+
		"\u07d6\5\u00dep\2\u07d6\u00c3\3\2\2\2\u07d7\u07d8\5\u00dep\2\u07d8\u00c5"+
		"\3\2\2\2\u07d9\u07da\5\u00dep\2\u07da\u00c7\3\2\2\2\u07db\u07dc\5\u00de"+
		"p\2\u07dc\u00c9\3\2\2\2\u07dd\u07de\5\u00dep\2\u07de\u00cb\3\2\2\2\u07df"+
		"\u07e0\5\u00dep\2\u07e0\u00cd\3\2\2\2\u07e1\u07e2\5\u00dep\2\u07e2\u00cf"+
		"\3\2\2\2\u07e3\u07e4\5\u00dep\2\u07e4\u00d1\3\2\2\2\u07e5\u07e6\5\u00de"+
		"p\2\u07e6\u00d3\3\2\2\2\u07e7\u07e8\5\u00dep\2\u07e8\u00d5\3\2\2\2\u07e9"+
		"\u07ea\5\u00dep\2\u07ea\u00d7\3\2\2\2\u07eb\u07ec\5\u00dep\2\u07ec\u00d9"+
		"\3\2\2\2\u07ed\u07ee\5\u00dep\2\u07ee\u00db\3\2\2\2\u07ef\u07f0\5\u00de"+
		"p\2\u07f0\u00dd\3\2\2\2\u07f1\u07f9\7\u00ba\2\2\u07f2\u07f9\5\u00acW\2"+
		"\u07f3\u07f9\7\u00bd\2\2\u07f4\u07f5\7\5\2\2\u07f5\u07f6\5\u00dep\2\u07f6"+
		"\u07f7\7\6\2\2\u07f7\u07f9\3\2\2\2\u07f8\u07f1\3\2\2\2\u07f8\u07f2\3\2"+
		"\2\2\u07f8\u07f3\3\2\2\2\u07f8\u07f4\3\2\2\2\u07f9\u00df\3\2\2\2\u0122"+
		"\u00e3\u00eb\u00f2\u00f7\u00fd\u0103\u0105\u011f\u0126\u012d\u0133\u0137"+
		"\u013a\u0141\u0144\u0148\u0150\u0154\u0156\u015a\u015e\u0162\u0165\u016c"+
		"\u0172\u0178\u017d\u0188\u018e\u0192\u0196\u0199\u019d\u01a3\u01a8\u01b1"+
		"\u01b8\u01be\u01c2\u01c6\u01cb\u01d1\u01dd\u01e1\u01e6\u01e9\u01ec\u01f1"+
		"\u01f4\u0202\u0209\u0210\u0212\u0215\u021b\u0220\u0228\u022d\u023c\u0242"+
		"\u024c\u0251\u025b\u025f\u0261\u0265\u026a\u026c\u0274\u027a\u027f\u0286"+
		"\u0291\u0294\u0296\u029d\u02a1\u02a8\u02ae\u02b4\u02ba\u02bf\u02c8\u02cd"+
		"\u02d8\u02dd\u02e8\u02ed\u02f1\u0301\u030b\u0310\u0318\u0324\u0329\u0331"+
		"\u0338\u033b\u0342\u0345\u0348\u034c\u0354\u0359\u0363\u0368\u0371\u0378"+
		"\u037c\u0380\u0383\u038b\u0398\u039b\u03a3\u03ac\u03b0\u03b5\u03d3\u03df"+
		"\u03e4\u03f0\u03f6\u03fd\u0401\u040b\u040e\u0414\u041a\u0423\u0426\u042a"+
		"\u042c\u042e\u0437\u043e\u0445\u044b\u0450\u0458\u045d\u0466\u0471\u0478"+
		"\u047c\u047f\u0483\u048d\u0493\u0495\u049d\u04a4\u04ab\u04b0\u04b2\u04b8"+
		"\u04c1\u04c6\u04cd\u04d1\u04d3\u04d6\u04de\u04e2\u04e5\u04eb\u04ef\u04f4"+
		"\u04fb\u0504\u0508\u050a\u050e\u0517\u051c\u051e\u052b\u052e\u0537\u0542"+
		"\u0549\u054c\u0551\u0555\u0558\u055b\u0560\u0564\u0569\u056c\u056f\u0574"+
		"\u0578\u057b\u0582\u0587\u0590\u0595\u0598\u05a0\u05a4\u05ac\u05af\u05b1"+
		"\u05ba\u05bd\u05bf\u05c3\u05c7\u05cb\u05ce\u05d9\u05de\u05e2\u05e6\u05e9"+
		"\u05ee\u05f4\u05fb\u0602\u0607\u060f\u0615\u061a\u0620\u0627\u062e\u0633"+
		"\u0636\u0639\u063e\u0643\u064a\u064e\u0652\u065c\u0665\u0668\u0671\u0675"+
		"\u067d\u0686\u0689\u0692\u0695\u0698\u069b\u06a5\u06ae\u06b7\u06bb\u06c2"+
		"\u06c9\u06cd\u06d1\u06da\u06de\u06e2\u06e7\u06eb\u06f2\u06fc\u0703\u0708"+
		"\u070b\u070f\u071d\u0729\u0732\u073b\u073f\u0749\u074c\u0755\u075e\u0761"+
		"\u0767\u0775\u0779\u0784\u0789\u0796\u079d\u07a5\u07aa\u07ae\u07bb\u07f8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}//CHECKSTYLE:ON