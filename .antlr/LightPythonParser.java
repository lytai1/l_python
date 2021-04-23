// Generated from /Users/lytai1/eclipse-workspace/l_python/LightPython.g4 by ANTLR 4.8
 package edu.sjsu.lpython.parser; 
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LightPythonParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, BOOLEAN=23, NONE=24, 
		STRING=25, NUMBER=26, INTEGER=27, NEWLINE=28, NAME=29, STRING_LITERAL=30, 
		DECIMAL_INTEGER=31, OPEN_PAREN=32, CLOSE_PAREN=33, OPEN_BRACK=34, CLOSE_BRACK=35, 
		OPEN_BRACE=36, CLOSE_BRACE=37, SKIP_=38, UNKNOWN_CHAR=39, INDENT=40, DEDENT=41;
	public static final int
		RULE_single_input = 0, RULE_file_input = 1, RULE_stmt = 2, RULE_simple_stmt = 3, 
		RULE_small_stmt = 4, RULE_assignment_stmt = 5, RULE_compound_stmt = 6, 
		RULE_if_stmt = 7, RULE_while_stmt = 8, RULE_suite = 9, RULE_test = 10, 
		RULE_print_stmt = 11, RULE_aon_op = 12, RULE_comp_op = 13, RULE_expr = 14, 
		RULE_atom = 15, RULE_trailer = 16, RULE_subscriptlist = 17, RULE_subscript = 18, 
		RULE_sliceop = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"single_input", "file_input", "stmt", "simple_stmt", "small_stmt", "assignment_stmt", 
			"compound_stmt", "if_stmt", "while_stmt", "suite", "test", "print_stmt", 
			"aon_op", "comp_op", "expr", "atom", "trailer", "subscriptlist", "subscript", 
			"sliceop"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'if'", "':'", "'elif'", "'else'", "'while'", "'not'", "'print'", 
			"'and'", "'or'", "'<'", "'>'", "'=='", "'>='", "'<='", "'!='", "'*'", 
			"'/'", "'%'", "'+'", "'-'", "','", null, "'None'", null, null, null, 
			null, null, null, null, "'('", "')'", "'['", "']'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "BOOLEAN", 
			"NONE", "STRING", "NUMBER", "INTEGER", "NEWLINE", "NAME", "STRING_LITERAL", 
			"DECIMAL_INTEGER", "OPEN_PAREN", "CLOSE_PAREN", "OPEN_BRACK", "CLOSE_BRACK", 
			"OPEN_BRACE", "CLOSE_BRACE", "SKIP_", "UNKNOWN_CHAR", "INDENT", "DEDENT"
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
	public String getGrammarFileName() { return "LightPython.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LightPythonParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class Single_inputContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(LightPythonParser.NEWLINE, 0); }
		public Simple_stmtContext simple_stmt() {
			return getRuleContext(Simple_stmtContext.class,0);
		}
		public Compound_stmtContext compound_stmt() {
			return getRuleContext(Compound_stmtContext.class,0);
		}
		public Single_inputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_single_input; }
	}

	public final Single_inputContext single_input() throws RecognitionException {
		Single_inputContext _localctx = new Single_inputContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_single_input);
		try {
			setState(45);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEWLINE:
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				match(NEWLINE);
				}
				break;
			case T__7:
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(41);
				simple_stmt();
				}
				break;
			case T__1:
			case T__5:
				enterOuterAlt(_localctx, 3);
				{
				setState(42);
				compound_stmt();
				setState(43);
				match(NEWLINE);
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

	public static class File_inputContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(LightPythonParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(LightPythonParser.NEWLINE, i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode EOF() { return getToken(LightPythonParser.EOF, 0); }
		public File_inputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file_input; }
	}

	public final File_inputContext file_input() throws RecognitionException {
		File_inputContext _localctx = new File_inputContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_file_input);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__5) | (1L << T__7) | (1L << NEWLINE) | (1L << NAME))) != 0)) {
				{
				setState(49);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NEWLINE:
					{
					setState(47);
					match(NEWLINE);
					}
					break;
				case T__1:
				case T__5:
				case T__7:
				case NAME:
					{
					setState(48);
					stmt();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(55);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(54);
				match(EOF);
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

	public static class StmtContext extends ParserRuleContext {
		public Simple_stmtContext simple_stmt() {
			return getRuleContext(Simple_stmtContext.class,0);
		}
		public Compound_stmtContext compound_stmt() {
			return getRuleContext(Compound_stmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stmt);
		try {
			setState(59);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				simple_stmt();
				}
				break;
			case T__1:
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				compound_stmt();
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

	public static class Simple_stmtContext extends ParserRuleContext {
		public Small_stmtContext small_stmt() {
			return getRuleContext(Small_stmtContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(LightPythonParser.NEWLINE, 0); }
		public Simple_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_stmt; }
	}

	public final Simple_stmtContext simple_stmt() throws RecognitionException {
		Simple_stmtContext _localctx = new Simple_stmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_simple_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			small_stmt();
			setState(62);
			match(NEWLINE);
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

	public static class Small_stmtContext extends ParserRuleContext {
		public Assignment_stmtContext assignment_stmt() {
			return getRuleContext(Assignment_stmtContext.class,0);
		}
		public Print_stmtContext print_stmt() {
			return getRuleContext(Print_stmtContext.class,0);
		}
		public Small_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_small_stmt; }
	}

	public final Small_stmtContext small_stmt() throws RecognitionException {
		Small_stmtContext _localctx = new Small_stmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_small_stmt);
		try {
			setState(66);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				assignment_stmt();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				print_stmt();
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

	public static class Assignment_stmtContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(LightPythonParser.NAME, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Assignment_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment_stmt; }
	}

	public final Assignment_stmtContext assignment_stmt() throws RecognitionException {
		Assignment_stmtContext _localctx = new Assignment_stmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assignment_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(NAME);
			setState(69);
			match(T__0);
			setState(70);
			expr(0);
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

	public static class Compound_stmtContext extends ParserRuleContext {
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
		}
		public While_stmtContext while_stmt() {
			return getRuleContext(While_stmtContext.class,0);
		}
		public Compound_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_stmt; }
	}

	public final Compound_stmtContext compound_stmt() throws RecognitionException {
		Compound_stmtContext _localctx = new Compound_stmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_compound_stmt);
		try {
			setState(74);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(72);
				if_stmt();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				while_stmt();
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

	public static class If_stmtContext extends ParserRuleContext {
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public List<SuiteContext> suite() {
			return getRuleContexts(SuiteContext.class);
		}
		public SuiteContext suite(int i) {
			return getRuleContext(SuiteContext.class,i);
		}
		public If_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stmt; }
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_if_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(T__1);
			setState(77);
			test(0);
			setState(78);
			match(T__2);
			setState(79);
			suite();
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(80);
				match(T__3);
				setState(81);
				test(0);
				setState(82);
				match(T__2);
				setState(83);
				suite();
				}
				}
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(90);
				match(T__4);
				setState(91);
				match(T__2);
				setState(92);
				suite();
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

	public static class While_stmtContext extends ParserRuleContext {
		public TestContext test() {
			return getRuleContext(TestContext.class,0);
		}
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public While_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_stmt; }
	}

	public final While_stmtContext while_stmt() throws RecognitionException {
		While_stmtContext _localctx = new While_stmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_while_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(T__5);
			setState(96);
			test(0);
			setState(97);
			match(T__2);
			setState(98);
			suite();
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

	public static class SuiteContext extends ParserRuleContext {
		public SuiteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suite; }
	 
		public SuiteContext() { }
		public void copyFrom(SuiteContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Suite2Context extends SuiteContext {
		public TerminalNode NEWLINE() { return getToken(LightPythonParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(LightPythonParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(LightPythonParser.DEDENT, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public Suite2Context(SuiteContext ctx) { copyFrom(ctx); }
	}
	public static class Suite1Context extends SuiteContext {
		public Simple_stmtContext simple_stmt() {
			return getRuleContext(Simple_stmtContext.class,0);
		}
		public Suite1Context(SuiteContext ctx) { copyFrom(ctx); }
	}

	public final SuiteContext suite() throws RecognitionException {
		SuiteContext _localctx = new SuiteContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_suite);
		int _la;
		try {
			setState(110);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
			case NAME:
				_localctx = new Suite1Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(100);
				simple_stmt();
				}
				break;
			case NEWLINE:
				_localctx = new Suite2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
				match(NEWLINE);
				setState(102);
				match(INDENT);
				setState(104); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(103);
					stmt();
					}
					}
					setState(106); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__5) | (1L << T__7) | (1L << NAME))) != 0) );
				setState(108);
				match(DEDENT);
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

	public static class TestContext extends ParserRuleContext {
		public TestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_test; }
	 
		public TestContext() { }
		public void copyFrom(TestContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NotContext extends TestContext {
		public TestContext test() {
			return getRuleContext(TestContext.class,0);
		}
		public NotContext(TestContext ctx) { copyFrom(ctx); }
	}
	public static class CompOpContext extends TestContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Comp_opContext comp_op() {
			return getRuleContext(Comp_opContext.class,0);
		}
		public CompOpContext(TestContext ctx) { copyFrom(ctx); }
	}
	public static class BoolOpContext extends TestContext {
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public Aon_opContext aon_op() {
			return getRuleContext(Aon_opContext.class,0);
		}
		public BoolOpContext(TestContext ctx) { copyFrom(ctx); }
	}
	public static class TestExprContext extends TestContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TestExprContext(TestContext ctx) { copyFrom(ctx); }
	}

	public final TestContext test() throws RecognitionException {
		return test(0);
	}

	private TestContext test(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TestContext _localctx = new TestContext(_ctx, _parentState);
		TestContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_test, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(113);
				match(T__6);
				setState(114);
				test(4);
				}
				break;
			case 2:
				{
				_localctx = new CompOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(115);
				expr(0);
				setState(116);
				comp_op();
				setState(117);
				expr(0);
				}
				break;
			case 3:
				{
				_localctx = new TestExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(119);
				expr(0);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(128);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BoolOpContext(new TestContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_test);
					setState(122);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(123);
					aon_op();
					setState(124);
					test(4);
					}
					} 
				}
				setState(130);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	public static class Print_stmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Print_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print_stmt; }
	}

	public final Print_stmtContext print_stmt() throws RecognitionException {
		Print_stmtContext _localctx = new Print_stmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_print_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(T__7);
			setState(132);
			expr(0);
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

	public static class Aon_opContext extends ParserRuleContext {
		public Aon_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aon_op; }
	}

	public final Aon_opContext aon_op() throws RecognitionException {
		Aon_opContext _localctx = new Aon_opContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_aon_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			_la = _input.LA(1);
			if ( !(_la==T__8 || _la==T__9) ) {
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

	public static class Comp_opContext extends ParserRuleContext {
		public Comp_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comp_op; }
	}

	public final Comp_opContext comp_op() throws RecognitionException {
		Comp_opContext _localctx = new Comp_opContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_comp_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15))) != 0)) ) {
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NegposNumContext extends ExprContext {
		public Token sign;
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public NegposNumContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class MulDivModContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MulDivModContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class AtomTrailerContext extends ExprContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public List<TrailerContext> trailer() {
			return getRuleContexts(TrailerContext.class);
		}
		public TrailerContext trailer(int i) {
			return getRuleContext(TrailerContext.class,i);
		}
		public AtomTrailerContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class AddSubContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AddSubContext(ExprContext ctx) { copyFrom(ctx); }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__19:
			case T__20:
				{
				_localctx = new NegposNumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(139);
				((NegposNumContext)_localctx).sign = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__19 || _la==T__20) ) {
					((NegposNumContext)_localctx).sign = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(140);
				atom();
				}
				break;
			case BOOLEAN:
			case NONE:
			case STRING:
			case NUMBER:
			case NAME:
			case OPEN_PAREN:
			case OPEN_BRACK:
				{
				_localctx = new AtomTrailerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(141);
				atom();
				setState(145);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(142);
						trailer();
						}
						} 
					}
					setState(147);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(158);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(156);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivModContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(150);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(151);
						((MulDivModContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__17) | (1L << T__18))) != 0)) ) {
							((MulDivModContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(152);
						expr(5);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(153);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(154);
						((AddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__19 || _la==T__20) ) {
							((AddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(155);
						expr(4);
						}
						break;
					}
					} 
				}
				setState(160);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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

	public static class AtomContext extends ParserRuleContext {
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	 
		public AtomContext() { }
		public void copyFrom(AtomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParenContext extends AtomContext {
		public TerminalNode OPEN_PAREN() { return getToken(LightPythonParser.OPEN_PAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CLOSE_PAREN() { return getToken(LightPythonParser.CLOSE_PAREN, 0); }
		public ParenContext(AtomContext ctx) { copyFrom(ctx); }
	}
	public static class BooleanContext extends AtomContext {
		public TerminalNode BOOLEAN() { return getToken(LightPythonParser.BOOLEAN, 0); }
		public BooleanContext(AtomContext ctx) { copyFrom(ctx); }
	}
	public static class StringContext extends AtomContext {
		public TerminalNode STRING() { return getToken(LightPythonParser.STRING, 0); }
		public StringContext(AtomContext ctx) { copyFrom(ctx); }
	}
	public static class VarContext extends AtomContext {
		public TerminalNode NAME() { return getToken(LightPythonParser.NAME, 0); }
		public VarContext(AtomContext ctx) { copyFrom(ctx); }
	}
	public static class NoneContext extends AtomContext {
		public TerminalNode NONE() { return getToken(LightPythonParser.NONE, 0); }
		public NoneContext(AtomContext ctx) { copyFrom(ctx); }
	}
	public static class ListContext extends AtomContext {
		public TerminalNode OPEN_BRACK() { return getToken(LightPythonParser.OPEN_BRACK, 0); }
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public TerminalNode CLOSE_BRACK() { return getToken(LightPythonParser.CLOSE_BRACK, 0); }
		public ListContext(AtomContext ctx) { copyFrom(ctx); }
	}
	public static class IntContext extends AtomContext {
		public TerminalNode NUMBER() { return getToken(LightPythonParser.NUMBER, 0); }
		public IntContext(AtomContext ctx) { copyFrom(ctx); }
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_atom);
		int _la;
		try {
			int _alt;
			setState(184);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				_localctx = new VarContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(161);
				match(NAME);
				}
				break;
			case NUMBER:
				_localctx = new IntContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(162);
				match(NUMBER);
				}
				break;
			case STRING:
				_localctx = new StringContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(163);
				match(STRING);
				}
				break;
			case BOOLEAN:
				_localctx = new BooleanContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(164);
				match(BOOLEAN);
				}
				break;
			case NONE:
				_localctx = new NoneContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(165);
				match(NONE);
				}
				break;
			case OPEN_BRACK:
				_localctx = new ListContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(166);
				match(OPEN_BRACK);
				setState(167);
				test(0);
				setState(172);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(168);
						match(T__21);
						setState(169);
						test(0);
						}
						} 
					}
					setState(174);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				}
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__21) {
					{
					setState(175);
					match(T__21);
					}
				}

				setState(178);
				match(CLOSE_BRACK);
				}
				break;
			case OPEN_PAREN:
				_localctx = new ParenContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(180);
				match(OPEN_PAREN);
				setState(181);
				expr(0);
				setState(182);
				match(CLOSE_PAREN);
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

	public static class TrailerContext extends ParserRuleContext {
		public TerminalNode OPEN_BRACK() { return getToken(LightPythonParser.OPEN_BRACK, 0); }
		public SubscriptlistContext subscriptlist() {
			return getRuleContext(SubscriptlistContext.class,0);
		}
		public TerminalNode CLOSE_BRACK() { return getToken(LightPythonParser.CLOSE_BRACK, 0); }
		public TrailerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trailer; }
	}

	public final TrailerContext trailer() throws RecognitionException {
		TrailerContext _localctx = new TrailerContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_trailer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(OPEN_BRACK);
			setState(187);
			subscriptlist();
			setState(188);
			match(CLOSE_BRACK);
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

	public static class SubscriptlistContext extends ParserRuleContext {
		public List<SubscriptContext> subscript() {
			return getRuleContexts(SubscriptContext.class);
		}
		public SubscriptContext subscript(int i) {
			return getRuleContext(SubscriptContext.class,i);
		}
		public SubscriptlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subscriptlist; }
	}

	public final SubscriptlistContext subscriptlist() throws RecognitionException {
		SubscriptlistContext _localctx = new SubscriptlistContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_subscriptlist);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			subscript();
			setState(195);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(191);
					match(T__21);
					setState(192);
					subscript();
					}
					} 
				}
				setState(197);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__21) {
				{
				setState(198);
				match(T__21);
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

	public static class SubscriptContext extends ParserRuleContext {
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public SliceopContext sliceop() {
			return getRuleContext(SliceopContext.class,0);
		}
		public SubscriptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subscript; }
	}

	public final SubscriptContext subscript() throws RecognitionException {
		SubscriptContext _localctx = new SubscriptContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_subscript);
		int _la;
		try {
			setState(212);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(201);
				test(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__19) | (1L << T__20) | (1L << BOOLEAN) | (1L << NONE) | (1L << STRING) | (1L << NUMBER) | (1L << NAME) | (1L << OPEN_PAREN) | (1L << OPEN_BRACK))) != 0)) {
					{
					setState(202);
					test(0);
					}
				}

				setState(205);
				match(T__2);
				setState(207);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__19) | (1L << T__20) | (1L << BOOLEAN) | (1L << NONE) | (1L << STRING) | (1L << NUMBER) | (1L << NAME) | (1L << OPEN_PAREN) | (1L << OPEN_BRACK))) != 0)) {
					{
					setState(206);
					test(0);
					}
				}

				setState(210);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(209);
					sliceop();
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

	public static class SliceopContext extends ParserRuleContext {
		public TestContext test() {
			return getRuleContext(TestContext.class,0);
		}
		public SliceopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sliceop; }
	}

	public final SliceopContext sliceop() throws RecognitionException {
		SliceopContext _localctx = new SliceopContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_sliceop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			match(T__2);
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__19) | (1L << T__20) | (1L << BOOLEAN) | (1L << NONE) | (1L << STRING) | (1L << NUMBER) | (1L << NAME) | (1L << OPEN_PAREN) | (1L << OPEN_BRACK))) != 0)) {
				{
				setState(215);
				test(0);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 10:
			return test_sempred((TestContext)_localctx, predIndex);
		case 14:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean test_sempred(TestContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3+\u00dd\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\2\3\2\5\2\60\n\2\3\3\3\3"+
		"\7\3\64\n\3\f\3\16\3\67\13\3\3\3\5\3:\n\3\3\4\3\4\5\4>\n\4\3\5\3\5\3\5"+
		"\3\6\3\6\5\6E\n\6\3\7\3\7\3\7\3\7\3\b\3\b\5\bM\n\b\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\7\tX\n\t\f\t\16\t[\13\t\3\t\3\t\3\t\5\t`\n\t\3\n\3\n"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\3\13\6\13k\n\13\r\13\16\13l\3\13\3\13\5\13"+
		"q\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f{\n\f\3\f\3\f\3\f\3\f\7\f\u0081"+
		"\n\f\f\f\16\f\u0084\13\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\3\20\7\20\u0092\n\20\f\20\16\20\u0095\13\20\5\20\u0097\n\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\7\20\u009f\n\20\f\20\16\20\u00a2\13\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u00ad\n\21\f\21\16\21\u00b0"+
		"\13\21\3\21\5\21\u00b3\n\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00bb\n"+
		"\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\7\23\u00c4\n\23\f\23\16\23\u00c7"+
		"\13\23\3\23\5\23\u00ca\n\23\3\24\3\24\5\24\u00ce\n\24\3\24\3\24\5\24\u00d2"+
		"\n\24\3\24\5\24\u00d5\n\24\5\24\u00d7\n\24\3\25\3\25\5\25\u00db\n\25\3"+
		"\25\2\4\26\36\26\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(\2\6\3\2"+
		"\13\f\3\2\r\22\3\2\26\27\3\2\23\25\2\u00ea\2/\3\2\2\2\4\65\3\2\2\2\6="+
		"\3\2\2\2\b?\3\2\2\2\nD\3\2\2\2\fF\3\2\2\2\16L\3\2\2\2\20N\3\2\2\2\22a"+
		"\3\2\2\2\24p\3\2\2\2\26z\3\2\2\2\30\u0085\3\2\2\2\32\u0088\3\2\2\2\34"+
		"\u008a\3\2\2\2\36\u0096\3\2\2\2 \u00ba\3\2\2\2\"\u00bc\3\2\2\2$\u00c0"+
		"\3\2\2\2&\u00d6\3\2\2\2(\u00d8\3\2\2\2*\60\7\36\2\2+\60\5\b\5\2,-\5\16"+
		"\b\2-.\7\36\2\2.\60\3\2\2\2/*\3\2\2\2/+\3\2\2\2/,\3\2\2\2\60\3\3\2\2\2"+
		"\61\64\7\36\2\2\62\64\5\6\4\2\63\61\3\2\2\2\63\62\3\2\2\2\64\67\3\2\2"+
		"\2\65\63\3\2\2\2\65\66\3\2\2\2\669\3\2\2\2\67\65\3\2\2\28:\7\2\2\398\3"+
		"\2\2\29:\3\2\2\2:\5\3\2\2\2;>\5\b\5\2<>\5\16\b\2=;\3\2\2\2=<\3\2\2\2>"+
		"\7\3\2\2\2?@\5\n\6\2@A\7\36\2\2A\t\3\2\2\2BE\5\f\7\2CE\5\30\r\2DB\3\2"+
		"\2\2DC\3\2\2\2E\13\3\2\2\2FG\7\37\2\2GH\7\3\2\2HI\5\36\20\2I\r\3\2\2\2"+
		"JM\5\20\t\2KM\5\22\n\2LJ\3\2\2\2LK\3\2\2\2M\17\3\2\2\2NO\7\4\2\2OP\5\26"+
		"\f\2PQ\7\5\2\2QY\5\24\13\2RS\7\6\2\2ST\5\26\f\2TU\7\5\2\2UV\5\24\13\2"+
		"VX\3\2\2\2WR\3\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z_\3\2\2\2[Y\3\2\2\2"+
		"\\]\7\7\2\2]^\7\5\2\2^`\5\24\13\2_\\\3\2\2\2_`\3\2\2\2`\21\3\2\2\2ab\7"+
		"\b\2\2bc\5\26\f\2cd\7\5\2\2de\5\24\13\2e\23\3\2\2\2fq\5\b\5\2gh\7\36\2"+
		"\2hj\7*\2\2ik\5\6\4\2ji\3\2\2\2kl\3\2\2\2lj\3\2\2\2lm\3\2\2\2mn\3\2\2"+
		"\2no\7+\2\2oq\3\2\2\2pf\3\2\2\2pg\3\2\2\2q\25\3\2\2\2rs\b\f\1\2st\7\t"+
		"\2\2t{\5\26\f\6uv\5\36\20\2vw\5\34\17\2wx\5\36\20\2x{\3\2\2\2y{\5\36\20"+
		"\2zr\3\2\2\2zu\3\2\2\2zy\3\2\2\2{\u0082\3\2\2\2|}\f\5\2\2}~\5\32\16\2"+
		"~\177\5\26\f\6\177\u0081\3\2\2\2\u0080|\3\2\2\2\u0081\u0084\3\2\2\2\u0082"+
		"\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\27\3\2\2\2\u0084\u0082\3\2\2"+
		"\2\u0085\u0086\7\n\2\2\u0086\u0087\5\36\20\2\u0087\31\3\2\2\2\u0088\u0089"+
		"\t\2\2\2\u0089\33\3\2\2\2\u008a\u008b\t\3\2\2\u008b\35\3\2\2\2\u008c\u008d"+
		"\b\20\1\2\u008d\u008e\t\4\2\2\u008e\u0097\5 \21\2\u008f\u0093\5 \21\2"+
		"\u0090\u0092\5\"\22\2\u0091\u0090\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0091"+
		"\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0096"+
		"\u008c\3\2\2\2\u0096\u008f\3\2\2\2\u0097\u00a0\3\2\2\2\u0098\u0099\f\6"+
		"\2\2\u0099\u009a\t\5\2\2\u009a\u009f\5\36\20\7\u009b\u009c\f\5\2\2\u009c"+
		"\u009d\t\4\2\2\u009d\u009f\5\36\20\6\u009e\u0098\3\2\2\2\u009e\u009b\3"+
		"\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1"+
		"\37\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00bb\7\37\2\2\u00a4\u00bb\7\34"+
		"\2\2\u00a5\u00bb\7\33\2\2\u00a6\u00bb\7\31\2\2\u00a7\u00bb\7\32\2\2\u00a8"+
		"\u00a9\7$\2\2\u00a9\u00ae\5\26\f\2\u00aa\u00ab\7\30\2\2\u00ab\u00ad\5"+
		"\26\f\2\u00ac\u00aa\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae"+
		"\u00af\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1\u00b3\7\30"+
		"\2\2\u00b2\u00b1\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4"+
		"\u00b5\7%\2\2\u00b5\u00bb\3\2\2\2\u00b6\u00b7\7\"\2\2\u00b7\u00b8\5\36"+
		"\20\2\u00b8\u00b9\7#\2\2\u00b9\u00bb\3\2\2\2\u00ba\u00a3\3\2\2\2\u00ba"+
		"\u00a4\3\2\2\2\u00ba\u00a5\3\2\2\2\u00ba\u00a6\3\2\2\2\u00ba\u00a7\3\2"+
		"\2\2\u00ba\u00a8\3\2\2\2\u00ba\u00b6\3\2\2\2\u00bb!\3\2\2\2\u00bc\u00bd"+
		"\7$\2\2\u00bd\u00be\5$\23\2\u00be\u00bf\7%\2\2\u00bf#\3\2\2\2\u00c0\u00c5"+
		"\5&\24\2\u00c1\u00c2\7\30\2\2\u00c2\u00c4\5&\24\2\u00c3\u00c1\3\2\2\2"+
		"\u00c4\u00c7\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c9"+
		"\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c8\u00ca\7\30\2\2\u00c9\u00c8\3\2\2\2"+
		"\u00c9\u00ca\3\2\2\2\u00ca%\3\2\2\2\u00cb\u00d7\5\26\f\2\u00cc\u00ce\5"+
		"\26\f\2\u00cd\u00cc\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf"+
		"\u00d1\7\5\2\2\u00d0\u00d2\5\26\f\2\u00d1\u00d0\3\2\2\2\u00d1\u00d2\3"+
		"\2\2\2\u00d2\u00d4\3\2\2\2\u00d3\u00d5\5(\25\2\u00d4\u00d3\3\2\2\2\u00d4"+
		"\u00d5\3\2\2\2\u00d5\u00d7\3\2\2\2\u00d6\u00cb\3\2\2\2\u00d6\u00cd\3\2"+
		"\2\2\u00d7\'\3\2\2\2\u00d8\u00da\7\5\2\2\u00d9\u00db\5\26\f\2\u00da\u00d9"+
		"\3\2\2\2\u00da\u00db\3\2\2\2\u00db)\3\2\2\2\35/\63\659=DLY_lpz\u0082\u0093"+
		"\u0096\u009e\u00a0\u00ae\u00b2\u00ba\u00c5\u00c9\u00cd\u00d1\u00d4\u00d6"+
		"\u00da";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}