// Generated from /Users/lytai1/eclipse-workspace/l_python/LightPython.g4 by ANTLR 4.8
 package edu.sjsu.lpython.parser; 
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LightPythonLexer extends Lexer {
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
		OPEN_BRACE=36, CLOSE_BRACE=37, SKIP_=38, UNKNOWN_CHAR=39;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "BOOLEAN", "NONE", "STRING", 
			"NUMBER", "INTEGER", "NEWLINE", "NAME", "STRING_LITERAL", "DECIMAL_INTEGER", 
			"OPEN_PAREN", "CLOSE_PAREN", "OPEN_BRACK", "CLOSE_BRACK", "OPEN_BRACE", 
			"CLOSE_BRACE", "SKIP_", "UNKNOWN_CHAR", "NON_ZERO_DIGIT", "DIGIT", "SPACES", 
			"COMMENT", "LINE_JOINING", "ID_START", "ID_CONTINUE"
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
			"OPEN_BRACE", "CLOSE_BRACE", "SKIP_", "UNKNOWN_CHAR"
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


	  // A queue where extra tokens are pushed on (see the NEWLINE lexer rule).
	  private java.util.LinkedList<Token> tokens = new java.util.LinkedList<>();
	  // The stack that keeps track of the indentation level.
	  private java.util.Stack<Integer> indents = new java.util.Stack<>();
	  // The amount of opened braces, brackets and parenthesis.
	  private int opened = 0;
	  // The most recently produced token.
	  private Token lastToken = null;
	  @Override
	  public void emit(Token t) {
	    super.setToken(t);
	    tokens.offer(t);
	  }

	  @Override
	  public Token nextToken() {
	    // Check if the end-of-file is ahead and there are still some DEDENTS expected.
	    if (_input.LA(1) == EOF && !this.indents.isEmpty()) {
	      // Remove any trailing EOF tokens from our buffer.
	      for (int i = tokens.size() - 1; i >= 0; i--) {
	        if (tokens.get(i).getType() == EOF) {
	          tokens.remove(i);
	        }
	      }

	      // First emit an extra line break that serves as the end of the statement.
	      this.emit(commonToken(LightPythonParser.NEWLINE, "\n"));

	      // Now emit as much DEDENT tokens as needed.
	      while (!indents.isEmpty()) {
	        this.emit(createDedent());
	        indents.pop();
	      }

	      // Put the EOF back on the token stream.
	      this.emit(commonToken(LightPythonParser.EOF, "<EOF>"));
	    }

	    Token next = super.nextToken();

	    if (next.getChannel() == Token.DEFAULT_CHANNEL) {
	      // Keep track of the last token on the default channel.
	      this.lastToken = next;
	    }

	    return tokens.isEmpty() ? next : tokens.poll();
	  }

	  private Token createDedent() {
	    CommonToken dedent = commonToken(LightPythonParser.DEDENT, "");
	    dedent.setLine(this.lastToken.getLine());
	    return dedent;
	  }

	  private CommonToken commonToken(int type, String text) {
	    int stop = this.getCharIndex() - 1;
	    int start = text.isEmpty() ? stop : stop - text.length() + 1;
	    return new CommonToken(this._tokenFactorySourcePair, type, DEFAULT_TOKEN_CHANNEL, start, stop);
	  }

	  // Calculates the indentation of the provided spaces, taking the
	  // following rules into account:
	  //
	  // "Tabs are replaced (from left to right) by one to eight spaces
	  //  such that the total number of characters up to and including
	  //  the replacement is a multiple of eight [...]"
	  //
	  //  -- https://docs.python.org/3.1/reference/lexical_analysis.html#indentation
	  static int getIndentationCount(String spaces) {
	    int count = 0;
	    for (char ch : spaces.toCharArray()) {
	      switch (ch) {
	        case '\t':
	          count += 8 - (count % 8);
	          break;
	        default:
	          // A normal space char.
	          count++;
	      }
	    }

	    return count;
	  }

	  boolean atStartOfInput() {
	    return super.getCharPositionInLine() == 0 && super.getLine() == 1;
	  }


	public LightPythonLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LightPython.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 27:
			NEWLINE_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void NEWLINE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:

			     String newLine = getText().replaceAll("[^\r\n]+", "");
			     String spaces = getText().replaceAll("[\r\n]+", "");
			     int next = _input.LA(1);
			     if (opened > 0 || next == '\r' || next == '\n' || next == '#') {
			       // If we're inside a list or on a blank line, ignore all indents, 
			       // dedents and line breaks.
			       skip();
			     }
			     else {
			       emit(commonToken(NEWLINE, newLine));
			       int indent = getIndentationCount(spaces);
			       int previous = indents.isEmpty() ? 0 : indents.peek();
			       if (indent == previous) {
			         // skip indents of the same size as the present indent-size
			         skip();
			       }
			       else if (indent > previous) {
			         indents.push(indent);
			         emit(commonToken(LightPythonParser.INDENT, spaces));
			       }
			       else {
			         // Possibly emit more than 1 DEDENT token.
			         while(!indents.isEmpty() && indents.peek() > indent) {
			           this.emit(createDedent());
			           indents.pop();
			         }
			       }
			     }
			   
			break;
		}
	}
	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 27:
			return NEWLINE_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean NEWLINE_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return atStartOfInput();
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2)\u013a\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23"+
		"\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\5\30\u00ad\n\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\33"+
		"\3\33\3\34\3\34\3\35\3\35\3\35\5\35\u00bd\n\35\3\35\3\35\5\35\u00c1\n"+
		"\35\3\35\5\35\u00c4\n\35\5\35\u00c6\n\35\3\35\3\35\3\36\3\36\7\36\u00cc"+
		"\n\36\f\36\16\36\u00cf\13\36\3\37\3\37\7\37\u00d3\n\37\f\37\16\37\u00d6"+
		"\13\37\3\37\3\37\3 \3 \7 \u00dc\n \f \16 \u00df\13 \3 \6 \u00e2\n \r "+
		"\16 \u00e3\5 \u00e6\n \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3"+
		"\'\5\'\u00f7\n\'\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\6+\u0102\n+\r+\16+\u0103"+
		"\3,\3,\7,\u0108\n,\f,\16,\u010b\13,\3,\3,\3,\3,\3,\7,\u0112\n,\f,\16,"+
		"\u0115\13,\3,\3,\3,\3,\3,\3,\3,\3,\7,\u011f\n,\f,\16,\u0122\13,\3,\3,"+
		"\3,\5,\u0127\n,\3-\3-\5-\u012b\n-\3-\5-\u012e\n-\3-\3-\5-\u0132\n-\3."+
		"\5.\u0135\n.\3/\3/\5/\u0139\n/\5\u00d4\u0113\u0120\2\60\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%I&K\'M(O)Q\2S\2U\2W\2Y\2[\2]\2\3\2\7\3\2\63;\3\2\62;\4\2\13\13\"\"\4"+
		"\2\f\f\16\17\5\2C\\aac|\2\u0148\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2"+
		"\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2"+
		"\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O"+
		"\3\2\2\2\3_\3\2\2\2\5a\3\2\2\2\7d\3\2\2\2\tf\3\2\2\2\13k\3\2\2\2\rp\3"+
		"\2\2\2\17v\3\2\2\2\21z\3\2\2\2\23\u0080\3\2\2\2\25\u0084\3\2\2\2\27\u0087"+
		"\3\2\2\2\31\u0089\3\2\2\2\33\u008b\3\2\2\2\35\u008e\3\2\2\2\37\u0091\3"+
		"\2\2\2!\u0094\3\2\2\2#\u0097\3\2\2\2%\u0099\3\2\2\2\'\u009b\3\2\2\2)\u009d"+
		"\3\2\2\2+\u009f\3\2\2\2-\u00a1\3\2\2\2/\u00ac\3\2\2\2\61\u00ae\3\2\2\2"+
		"\63\u00b3\3\2\2\2\65\u00b5\3\2\2\2\67\u00b7\3\2\2\29\u00c5\3\2\2\2;\u00c9"+
		"\3\2\2\2=\u00d0\3\2\2\2?\u00e5\3\2\2\2A\u00e7\3\2\2\2C\u00e9\3\2\2\2E"+
		"\u00eb\3\2\2\2G\u00ed\3\2\2\2I\u00ef\3\2\2\2K\u00f1\3\2\2\2M\u00f6\3\2"+
		"\2\2O\u00fa\3\2\2\2Q\u00fc\3\2\2\2S\u00fe\3\2\2\2U\u0101\3\2\2\2W\u0126"+
		"\3\2\2\2Y\u0128\3\2\2\2[\u0134\3\2\2\2]\u0138\3\2\2\2_`\7?\2\2`\4\3\2"+
		"\2\2ab\7k\2\2bc\7h\2\2c\6\3\2\2\2de\7<\2\2e\b\3\2\2\2fg\7g\2\2gh\7n\2"+
		"\2hi\7k\2\2ij\7h\2\2j\n\3\2\2\2kl\7g\2\2lm\7n\2\2mn\7u\2\2no\7g\2\2o\f"+
		"\3\2\2\2pq\7y\2\2qr\7j\2\2rs\7k\2\2st\7n\2\2tu\7g\2\2u\16\3\2\2\2vw\7"+
		"p\2\2wx\7q\2\2xy\7v\2\2y\20\3\2\2\2z{\7r\2\2{|\7t\2\2|}\7k\2\2}~\7p\2"+
		"\2~\177\7v\2\2\177\22\3\2\2\2\u0080\u0081\7c\2\2\u0081\u0082\7p\2\2\u0082"+
		"\u0083\7f\2\2\u0083\24\3\2\2\2\u0084\u0085\7q\2\2\u0085\u0086\7t\2\2\u0086"+
		"\26\3\2\2\2\u0087\u0088\7>\2\2\u0088\30\3\2\2\2\u0089\u008a\7@\2\2\u008a"+
		"\32\3\2\2\2\u008b\u008c\7?\2\2\u008c\u008d\7?\2\2\u008d\34\3\2\2\2\u008e"+
		"\u008f\7@\2\2\u008f\u0090\7?\2\2\u0090\36\3\2\2\2\u0091\u0092\7>\2\2\u0092"+
		"\u0093\7?\2\2\u0093 \3\2\2\2\u0094\u0095\7#\2\2\u0095\u0096\7?\2\2\u0096"+
		"\"\3\2\2\2\u0097\u0098\7,\2\2\u0098$\3\2\2\2\u0099\u009a\7\61\2\2\u009a"+
		"&\3\2\2\2\u009b\u009c\7\'\2\2\u009c(\3\2\2\2\u009d\u009e\7-\2\2\u009e"+
		"*\3\2\2\2\u009f\u00a0\7/\2\2\u00a0,\3\2\2\2\u00a1\u00a2\7.\2\2\u00a2."+
		"\3\2\2\2\u00a3\u00a4\7V\2\2\u00a4\u00a5\7t\2\2\u00a5\u00a6\7w\2\2\u00a6"+
		"\u00ad\7g\2\2\u00a7\u00a8\7H\2\2\u00a8\u00a9\7c\2\2\u00a9\u00aa\7n\2\2"+
		"\u00aa\u00ab\7u\2\2\u00ab\u00ad\7g\2\2\u00ac\u00a3\3\2\2\2\u00ac\u00a7"+
		"\3\2\2\2\u00ad\60\3\2\2\2\u00ae\u00af\7P\2\2\u00af\u00b0\7q\2\2\u00b0"+
		"\u00b1\7p\2\2\u00b1\u00b2\7g\2\2\u00b2\62\3\2\2\2\u00b3\u00b4\5=\37\2"+
		"\u00b4\64\3\2\2\2\u00b5\u00b6\5\67\34\2\u00b6\66\3\2\2\2\u00b7\u00b8\5"+
		"? \2\u00b88\3\2\2\2\u00b9\u00ba\6\35\2\2\u00ba\u00c6\5U+\2\u00bb\u00bd"+
		"\7\17\2\2\u00bc\u00bb\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00be\3\2\2\2"+
		"\u00be\u00c1\7\f\2\2\u00bf\u00c1\7\17\2\2\u00c0\u00bc\3\2\2\2\u00c0\u00bf"+
		"\3\2\2\2\u00c1\u00c3\3\2\2\2\u00c2\u00c4\5U+\2\u00c3\u00c2\3\2\2\2\u00c3"+
		"\u00c4\3\2\2\2\u00c4\u00c6\3\2\2\2\u00c5\u00b9\3\2\2\2\u00c5\u00c0\3\2"+
		"\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c8\b\35\2\2\u00c8:\3\2\2\2\u00c9\u00cd"+
		"\5[.\2\u00ca\u00cc\5]/\2\u00cb\u00ca\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd"+
		"\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce<\3\2\2\2\u00cf\u00cd\3\2\2\2"+
		"\u00d0\u00d4\7$\2\2\u00d1\u00d3\13\2\2\2\u00d2\u00d1\3\2\2\2\u00d3\u00d6"+
		"\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5\u00d7\3\2\2\2\u00d6"+
		"\u00d4\3\2\2\2\u00d7\u00d8\7$\2\2\u00d8>\3\2\2\2\u00d9\u00dd\5Q)\2\u00da"+
		"\u00dc\5S*\2\u00db\u00da\3\2\2\2\u00dc\u00df\3\2\2\2\u00dd\u00db\3\2\2"+
		"\2\u00dd\u00de\3\2\2\2\u00de\u00e6\3\2\2\2\u00df\u00dd\3\2\2\2\u00e0\u00e2"+
		"\7\62\2\2\u00e1\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e1\3\2\2\2"+
		"\u00e3\u00e4\3\2\2\2\u00e4\u00e6\3\2\2\2\u00e5\u00d9\3\2\2\2\u00e5\u00e1"+
		"\3\2\2\2\u00e6@\3\2\2\2\u00e7\u00e8\7*\2\2\u00e8B\3\2\2\2\u00e9\u00ea"+
		"\7+\2\2\u00eaD\3\2\2\2\u00eb\u00ec\7]\2\2\u00ecF\3\2\2\2\u00ed\u00ee\7"+
		"_\2\2\u00eeH\3\2\2\2\u00ef\u00f0\7}\2\2\u00f0J\3\2\2\2\u00f1\u00f2\7\177"+
		"\2\2\u00f2L\3\2\2\2\u00f3\u00f7\5U+\2\u00f4\u00f7\5W,\2\u00f5\u00f7\5"+
		"Y-\2\u00f6\u00f3\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f6\u00f5\3\2\2\2\u00f7"+
		"\u00f8\3\2\2\2\u00f8\u00f9\b\'\3\2\u00f9N\3\2\2\2\u00fa\u00fb\13\2\2\2"+
		"\u00fbP\3\2\2\2\u00fc\u00fd\t\2\2\2\u00fdR\3\2\2\2\u00fe\u00ff\t\3\2\2"+
		"\u00ffT\3\2\2\2\u0100\u0102\t\4\2\2\u0101\u0100\3\2\2\2\u0102\u0103\3"+
		"\2\2\2\u0103\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104V\3\2\2\2\u0105\u0109"+
		"\7%\2\2\u0106\u0108\n\5\2\2\u0107\u0106\3\2\2\2\u0108\u010b\3\2\2\2\u0109"+
		"\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u0127\3\2\2\2\u010b\u0109\3\2"+
		"\2\2\u010c\u010d\7$\2\2\u010d\u010e\7$\2\2\u010e\u010f\7$\2\2\u010f\u0113"+
		"\3\2\2\2\u0110\u0112\13\2\2\2\u0111\u0110\3\2\2\2\u0112\u0115\3\2\2\2"+
		"\u0113\u0114\3\2\2\2\u0113\u0111\3\2\2\2\u0114\u0116\3\2\2\2\u0115\u0113"+
		"\3\2\2\2\u0116\u0117\7$\2\2\u0117\u0118\7$\2\2\u0118\u0127\7$\2\2\u0119"+
		"\u011a\7)\2\2\u011a\u011b\7)\2\2\u011b\u011c\7)\2\2\u011c\u0120\3\2\2"+
		"\2\u011d\u011f\13\2\2\2\u011e\u011d\3\2\2\2\u011f\u0122\3\2\2\2\u0120"+
		"\u0121\3\2\2\2\u0120\u011e\3\2\2\2\u0121\u0123\3\2\2\2\u0122\u0120\3\2"+
		"\2\2\u0123\u0124\7)\2\2\u0124\u0125\7)\2\2\u0125\u0127\7)\2\2\u0126\u0105"+
		"\3\2\2\2\u0126\u010c\3\2\2\2\u0126\u0119\3\2\2\2\u0127X\3\2\2\2\u0128"+
		"\u012a\7^\2\2\u0129\u012b\5U+\2\u012a\u0129\3\2\2\2\u012a\u012b\3\2\2"+
		"\2\u012b\u0131\3\2\2\2\u012c\u012e\7\17\2\2\u012d\u012c\3\2\2\2\u012d"+
		"\u012e\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0132\7\f\2\2\u0130\u0132\4\16"+
		"\17\2\u0131\u012d\3\2\2\2\u0131\u0130\3\2\2\2\u0132Z\3\2\2\2\u0133\u0135"+
		"\t\6\2\2\u0134\u0133\3\2\2\2\u0135\\\3\2\2\2\u0136\u0139\5[.\2\u0137\u0139"+
		"\t\3\2\2\u0138\u0136\3\2\2\2\u0138\u0137\3\2\2\2\u0139^\3\2\2\2\30\2\u00ac"+
		"\u00bc\u00c0\u00c3\u00c5\u00cd\u00d4\u00dd\u00e3\u00e5\u00f6\u0103\u0109"+
		"\u0113\u0120\u0126\u012a\u012d\u0131\u0134\u0138\4\3\35\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}