// Generated from /Users/quentin/Projet/LPSolver/src/fr/enslyon/Parser/Input.g4 by ANTLR 4.5

     package fr.enslyon.Parser.gen;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class InputLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, MINIMIZE=2, MAXIMIZE=3, SUBJECTTO=4, BOUNDS=5, VARIABLES=6, END=7, 
		Plus=8, Minus=9, LessEqual=10, GreaterEqual=11, Equal=12, Float=13, Variable=14, 
		BlockComment=15, LineComment=16;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"WS", "MINIMIZE", "MAXIMIZE", "SUBJECTTO", "BOUNDS", "VARIABLES", "END", 
		"Plus", "Minus", "LessEqual", "GreaterEqual", "Equal", "Float", "Variable", 
		"BlockComment", "LineComment"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, "'MINIMIZE'", "'MAXIMIZE'", "'SUBJECT TO'", "'BOUNDS'", "'VARIABLES'", 
		"'END'", "'+'", "'-'", "'<='", "'>='", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WS", "MINIMIZE", "MAXIMIZE", "SUBJECTTO", "BOUNDS", "VARIABLES", 
		"END", "Plus", "Minus", "LessEqual", "GreaterEqual", "Equal", "Float", 
		"Variable", "BlockComment", "LineComment"
	};
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
	@NotNull
	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public InputLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Input.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\22\u00a0\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\6"+
		"\2%\n\2\r\2\16\2&\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3"+
		"\16\6\16j\n\16\r\16\16\16k\3\16\3\16\6\16p\n\16\r\16\16\16q\3\16\3\16"+
		"\6\16v\n\16\r\16\16\16w\7\16z\n\16\f\16\16\16}\13\16\5\16\177\n\16\3\17"+
		"\3\17\7\17\u0083\n\17\f\17\16\17\u0086\13\17\3\20\3\20\3\20\3\20\7\20"+
		"\u008c\n\20\f\20\16\20\u008f\13\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\7\21\u009a\n\21\f\21\16\21\u009d\13\21\3\21\3\21\3\u008d\2"+
		"\22\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22\3\2\7\5\2\13\f\17\17\"\"\4\2GGgg\5\2C\\aac|\6\2\62;C\\a"+
		"ac|\4\2\f\f\17\17\u00a8\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\3$\3\2\2\2\5*\3\2\2\2\7\63\3\2\2\2\t<\3\2\2\2\13G\3\2"+
		"\2\2\rN\3\2\2\2\17X\3\2\2\2\21\\\3\2\2\2\23^\3\2\2\2\25`\3\2\2\2\27c\3"+
		"\2\2\2\31f\3\2\2\2\33i\3\2\2\2\35\u0080\3\2\2\2\37\u0087\3\2\2\2!\u0095"+
		"\3\2\2\2#%\t\2\2\2$#\3\2\2\2%&\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'(\3\2\2\2"+
		"()\b\2\2\2)\4\3\2\2\2*+\7O\2\2+,\7K\2\2,-\7P\2\2-.\7K\2\2./\7O\2\2/\60"+
		"\7K\2\2\60\61\7\\\2\2\61\62\7G\2\2\62\6\3\2\2\2\63\64\7O\2\2\64\65\7C"+
		"\2\2\65\66\7Z\2\2\66\67\7K\2\2\678\7O\2\289\7K\2\29:\7\\\2\2:;\7G\2\2"+
		";\b\3\2\2\2<=\7U\2\2=>\7W\2\2>?\7D\2\2?@\7L\2\2@A\7G\2\2AB\7E\2\2BC\7"+
		"V\2\2CD\7\"\2\2DE\7V\2\2EF\7Q\2\2F\n\3\2\2\2GH\7D\2\2HI\7Q\2\2IJ\7W\2"+
		"\2JK\7P\2\2KL\7F\2\2LM\7U\2\2M\f\3\2\2\2NO\7X\2\2OP\7C\2\2PQ\7T\2\2QR"+
		"\7K\2\2RS\7C\2\2ST\7D\2\2TU\7N\2\2UV\7G\2\2VW\7U\2\2W\16\3\2\2\2XY\7G"+
		"\2\2YZ\7P\2\2Z[\7F\2\2[\20\3\2\2\2\\]\7-\2\2]\22\3\2\2\2^_\7/\2\2_\24"+
		"\3\2\2\2`a\7>\2\2ab\7?\2\2b\26\3\2\2\2cd\7@\2\2de\7?\2\2e\30\3\2\2\2f"+
		"g\7?\2\2g\32\3\2\2\2hj\4\62;\2ih\3\2\2\2jk\3\2\2\2ki\3\2\2\2kl\3\2\2\2"+
		"l~\3\2\2\2mo\7\60\2\2np\4\62;\2on\3\2\2\2pq\3\2\2\2qo\3\2\2\2qr\3\2\2"+
		"\2r{\3\2\2\2su\t\3\2\2tv\4\62;\2ut\3\2\2\2vw\3\2\2\2wu\3\2\2\2wx\3\2\2"+
		"\2xz\3\2\2\2ys\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|\177\3\2\2\2}{\3"+
		"\2\2\2~m\3\2\2\2~\177\3\2\2\2\177\34\3\2\2\2\u0080\u0084\t\4\2\2\u0081"+
		"\u0083\t\5\2\2\u0082\u0081\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082\3\2"+
		"\2\2\u0084\u0085\3\2\2\2\u0085\36\3\2\2\2\u0086\u0084\3\2\2\2\u0087\u0088"+
		"\7\61\2\2\u0088\u0089\7,\2\2\u0089\u008d\3\2\2\2\u008a\u008c\13\2\2\2"+
		"\u008b\u008a\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008e\3\2\2\2\u008d\u008b"+
		"\3\2\2\2\u008e\u0090\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0091\7,\2\2\u0091"+
		"\u0092\7\61\2\2\u0092\u0093\3\2\2\2\u0093\u0094\b\20\2\2\u0094 \3\2\2"+
		"\2\u0095\u0096\7\61\2\2\u0096\u0097\7\61\2\2\u0097\u009b\3\2\2\2\u0098"+
		"\u009a\n\6\2\2\u0099\u0098\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2"+
		"\2\2\u009b\u009c\3\2\2\2\u009c\u009e\3\2\2\2\u009d\u009b\3\2\2\2\u009e"+
		"\u009f\b\21\2\2\u009f\"\3\2\2\2\f\2&kqw{~\u0084\u008d\u009b\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}