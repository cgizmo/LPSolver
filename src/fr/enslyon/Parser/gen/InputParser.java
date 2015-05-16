// Generated from /Users/quentin/Projet/LPSolver/src/fr/enslyon/Parser/Input.g4 by ANTLR 4.5

     package fr.enslyon.Parser.gen;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class InputParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, MINIMIZE=2, MAXIMIZE=3, SUBJECTTO=4, BOUNDS=5, VARIABLES=6, END=7, 
		Plus=8, Minus=9, LessEqual=10, GreaterEqual=11, Equal=12, Float=13, Variable=14, 
		BlockComment=15, LineComment=16;
	public static final int
		RULE_linearSystem = 0, RULE_objective = 1, RULE_linearCombination = 2, 
		RULE_item = 3, RULE_firstItem = 4, RULE_inequalities = 5, RULE_inequality = 6, 
		RULE_bounds = 7, RULE_bound = 8, RULE_variablesList = 9, RULE_operator = 10, 
		RULE_comparisonOrEqual = 11, RULE_comparison = 12;
	public static final String[] ruleNames = {
		"linearSystem", "objective", "linearCombination", "item", "firstItem", 
		"inequalities", "inequality", "bounds", "bound", "variablesList", "operator", 
		"comparisonOrEqual", "comparison"
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

	@Override
	public String getGrammarFileName() { return "Input.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public InputParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class LinearSystemContext extends ParserRuleContext {
		public ObjectiveContext objective() {
			return getRuleContext(ObjectiveContext.class,0);
		}
		public LinearCombinationContext linearCombination() {
			return getRuleContext(LinearCombinationContext.class,0);
		}
		public TerminalNode SUBJECTTO() { return getToken(InputParser.SUBJECTTO, 0); }
		public InequalitiesContext inequalities() {
			return getRuleContext(InequalitiesContext.class,0);
		}
		public TerminalNode BOUNDS() { return getToken(InputParser.BOUNDS, 0); }
		public BoundsContext bounds() {
			return getRuleContext(BoundsContext.class,0);
		}
		public TerminalNode VARIABLES() { return getToken(InputParser.VARIABLES, 0); }
		public VariablesListContext variablesList() {
			return getRuleContext(VariablesListContext.class,0);
		}
		public TerminalNode END() { return getToken(InputParser.END, 0); }
		public LinearSystemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_linearSystem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitLinearSystem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LinearSystemContext linearSystem() throws RecognitionException {
		LinearSystemContext _localctx = new LinearSystemContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_linearSystem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26); 
			objective();
			setState(27); 
			linearCombination();
			setState(28); 
			match(SUBJECTTO);
			setState(29); 
			inequalities();
			setState(30); 
			match(BOUNDS);
			setState(31); 
			bounds();
			setState(32); 
			match(VARIABLES);
			setState(33); 
			variablesList();
			setState(35);
			_la = _input.LA(1);
			if (_la==END) {
				{
				setState(34); 
				match(END);
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

	public static class ObjectiveContext extends ParserRuleContext {
		public TerminalNode MAXIMIZE() { return getToken(InputParser.MAXIMIZE, 0); }
		public TerminalNode MINIMIZE() { return getToken(InputParser.MINIMIZE, 0); }
		public ObjectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objective; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitObjective(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectiveContext objective() throws RecognitionException {
		ObjectiveContext _localctx = new ObjectiveContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_objective);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			_la = _input.LA(1);
			if ( !(_la==MINIMIZE || _la==MAXIMIZE) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class LinearCombinationContext extends ParserRuleContext {
		public FirstItemContext firstItem() {
			return getRuleContext(FirstItemContext.class,0);
		}
		public List<OperatorContext> operator() {
			return getRuleContexts(OperatorContext.class);
		}
		public OperatorContext operator(int i) {
			return getRuleContext(OperatorContext.class,i);
		}
		public List<ItemContext> item() {
			return getRuleContexts(ItemContext.class);
		}
		public ItemContext item(int i) {
			return getRuleContext(ItemContext.class,i);
		}
		public LinearCombinationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_linearCombination; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitLinearCombination(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LinearCombinationContext linearCombination() throws RecognitionException {
		LinearCombinationContext _localctx = new LinearCombinationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_linearCombination);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39); 
			firstItem();
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Plus || _la==Minus) {
				{
				{
				setState(40); 
				operator();
				setState(41); 
				item();
				}
				}
				setState(47);
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

	public static class ItemContext extends ParserRuleContext {
		public ItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item; }
	 
		public ItemContext() { }
		public void copyFrom(ItemContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VariableItemContext extends ItemContext {
		public TerminalNode Variable() { return getToken(InputParser.Variable, 0); }
		public VariableItemContext(ItemContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitVariableItem(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConstantAndVariableItemContext extends ItemContext {
		public TerminalNode Float() { return getToken(InputParser.Float, 0); }
		public TerminalNode Variable() { return getToken(InputParser.Variable, 0); }
		public ConstantAndVariableItemContext(ItemContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitConstantAndVariableItem(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConstantItemContext extends ItemContext {
		public TerminalNode Float() { return getToken(InputParser.Float, 0); }
		public ConstantItemContext(ItemContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitConstantItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ItemContext item() throws RecognitionException {
		ItemContext _localctx = new ItemContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_item);
		try {
			setState(52);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new ConstantAndVariableItemContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(48); 
				match(Float);
				setState(49); 
				match(Variable);
				}
				break;
			case 2:
				_localctx = new VariableItemContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(50); 
				match(Variable);
				}
				break;
			case 3:
				_localctx = new ConstantItemContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(51); 
				match(Float);
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

	public static class FirstItemContext extends ParserRuleContext {
		public ItemContext item() {
			return getRuleContext(ItemContext.class,0);
		}
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public FirstItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_firstItem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitFirstItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FirstItemContext firstItem() throws RecognitionException {
		FirstItemContext _localctx = new FirstItemContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_firstItem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			_la = _input.LA(1);
			if (_la==Plus || _la==Minus) {
				{
				setState(54); 
				operator();
				}
			}

			setState(57); 
			item();
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

	public static class InequalitiesContext extends ParserRuleContext {
		public List<InequalityContext> inequality() {
			return getRuleContexts(InequalityContext.class);
		}
		public InequalityContext inequality(int i) {
			return getRuleContext(InequalityContext.class,i);
		}
		public InequalitiesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inequalities; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitInequalities(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InequalitiesContext inequalities() throws RecognitionException {
		InequalitiesContext _localctx = new InequalitiesContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_inequalities);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Plus) | (1L << Minus) | (1L << Float) | (1L << Variable))) != 0)) {
				{
				{
				setState(59); 
				inequality();
				}
				}
				setState(64);
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

	public static class InequalityContext extends ParserRuleContext {
		public LinearCombinationContext linearCombination() {
			return getRuleContext(LinearCombinationContext.class,0);
		}
		public ComparisonOrEqualContext comparisonOrEqual() {
			return getRuleContext(ComparisonOrEqualContext.class,0);
		}
		public TerminalNode Float() { return getToken(InputParser.Float, 0); }
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public InequalityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inequality; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitInequality(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InequalityContext inequality() throws RecognitionException {
		InequalityContext _localctx = new InequalityContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_inequality);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(65); 
			linearCombination();
			setState(66); 
			comparisonOrEqual();
			setState(68);
			_la = _input.LA(1);
			if (_la==Plus || _la==Minus) {
				{
				setState(67); 
				operator();
				}
			}

			setState(70); 
			match(Float);
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

	public static class BoundsContext extends ParserRuleContext {
		public List<BoundContext> bound() {
			return getRuleContexts(BoundContext.class);
		}
		public BoundContext bound(int i) {
			return getRuleContext(BoundContext.class,i);
		}
		public BoundsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bounds; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitBounds(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoundsContext bounds() throws RecognitionException {
		BoundsContext _localctx = new BoundsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_bounds);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Float || _la==Variable) {
				{
				{
				setState(72); 
				bound();
				}
				}
				setState(77);
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

	public static class BoundContext extends ParserRuleContext {
		public BoundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bound; }
	 
		public BoundContext() { }
		public void copyFrom(BoundContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LowerBoundContext extends BoundContext {
		public TerminalNode Float() { return getToken(InputParser.Float, 0); }
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public TerminalNode Variable() { return getToken(InputParser.Variable, 0); }
		public LowerBoundContext(BoundContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitLowerBound(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LowerAndUpperBoundContext extends BoundContext {
		public List<TerminalNode> Float() { return getTokens(InputParser.Float); }
		public TerminalNode Float(int i) {
			return getToken(InputParser.Float, i);
		}
		public List<ComparisonContext> comparison() {
			return getRuleContexts(ComparisonContext.class);
		}
		public ComparisonContext comparison(int i) {
			return getRuleContext(ComparisonContext.class,i);
		}
		public TerminalNode Variable() { return getToken(InputParser.Variable, 0); }
		public LowerAndUpperBoundContext(BoundContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitLowerAndUpperBound(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UpperBoundContext extends BoundContext {
		public TerminalNode Variable() { return getToken(InputParser.Variable, 0); }
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public TerminalNode Float() { return getToken(InputParser.Float, 0); }
		public UpperBoundContext(BoundContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitUpperBound(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoundContext bound() throws RecognitionException {
		BoundContext _localctx = new BoundContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_bound);
		try {
			setState(92);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new UpperBoundContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(78); 
				match(Variable);
				setState(79); 
				comparison();
				setState(80); 
				match(Float);
				}
				break;
			case 2:
				_localctx = new LowerBoundContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(82); 
				match(Float);
				setState(83); 
				comparison();
				setState(84); 
				match(Variable);
				}
				break;
			case 3:
				_localctx = new LowerAndUpperBoundContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(86); 
				match(Float);
				setState(87); 
				comparison();
				setState(88); 
				match(Variable);
				setState(89); 
				comparison();
				setState(90); 
				match(Float);
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

	public static class VariablesListContext extends ParserRuleContext {
		public List<TerminalNode> Variable() { return getTokens(InputParser.Variable); }
		public TerminalNode Variable(int i) {
			return getToken(InputParser.Variable, i);
		}
		public VariablesListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variablesList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitVariablesList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariablesListContext variablesList() throws RecognitionException {
		VariablesListContext _localctx = new VariablesListContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_variablesList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Variable) {
				{
				{
				setState(94); 
				match(Variable);
				}
				}
				setState(99);
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

	public static class OperatorContext extends ParserRuleContext {
		public TerminalNode Plus() { return getToken(InputParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(InputParser.Minus, 0); }
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			_la = _input.LA(1);
			if ( !(_la==Plus || _la==Minus) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class ComparisonOrEqualContext extends ParserRuleContext {
		public TerminalNode LessEqual() { return getToken(InputParser.LessEqual, 0); }
		public TerminalNode GreaterEqual() { return getToken(InputParser.GreaterEqual, 0); }
		public TerminalNode Equal() { return getToken(InputParser.Equal, 0); }
		public ComparisonOrEqualContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonOrEqual; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitComparisonOrEqual(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonOrEqualContext comparisonOrEqual() throws RecognitionException {
		ComparisonOrEqualContext _localctx = new ComparisonOrEqualContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_comparisonOrEqual);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LessEqual) | (1L << GreaterEqual) | (1L << Equal))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class ComparisonContext extends ParserRuleContext {
		public TerminalNode LessEqual() { return getToken(InputParser.LessEqual, 0); }
		public TerminalNode GreaterEqual() { return getToken(InputParser.GreaterEqual, 0); }
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputVisitor ) return ((InputVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_comparison);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			_la = _input.LA(1);
			if ( !(_la==LessEqual || _la==GreaterEqual) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\22m\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2&\n\2"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\7\4.\n\4\f\4\16\4\61\13\4\3\5\3\5\3\5\3\5\5\5"+
		"\67\n\5\3\6\5\6:\n\6\3\6\3\6\3\7\7\7?\n\7\f\7\16\7B\13\7\3\b\3\b\3\b\5"+
		"\bG\n\b\3\b\3\b\3\t\7\tL\n\t\f\t\16\tO\13\t\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n_\n\n\3\13\7\13b\n\13\f\13\16\13e\13"+
		"\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\2\2\17\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\2\6\3\2\4\5\3\2\n\13\3\2\f\16\3\2\f\rj\2\34\3\2\2\2\4\'\3\2\2\2\6"+
		")\3\2\2\2\b\66\3\2\2\2\n9\3\2\2\2\f@\3\2\2\2\16C\3\2\2\2\20M\3\2\2\2\22"+
		"^\3\2\2\2\24c\3\2\2\2\26f\3\2\2\2\30h\3\2\2\2\32j\3\2\2\2\34\35\5\4\3"+
		"\2\35\36\5\6\4\2\36\37\7\6\2\2\37 \5\f\7\2 !\7\7\2\2!\"\5\20\t\2\"#\7"+
		"\b\2\2#%\5\24\13\2$&\7\t\2\2%$\3\2\2\2%&\3\2\2\2&\3\3\2\2\2\'(\t\2\2\2"+
		"(\5\3\2\2\2)/\5\n\6\2*+\5\26\f\2+,\5\b\5\2,.\3\2\2\2-*\3\2\2\2.\61\3\2"+
		"\2\2/-\3\2\2\2/\60\3\2\2\2\60\7\3\2\2\2\61/\3\2\2\2\62\63\7\17\2\2\63"+
		"\67\7\20\2\2\64\67\7\20\2\2\65\67\7\17\2\2\66\62\3\2\2\2\66\64\3\2\2\2"+
		"\66\65\3\2\2\2\67\t\3\2\2\28:\5\26\f\298\3\2\2\29:\3\2\2\2:;\3\2\2\2;"+
		"<\5\b\5\2<\13\3\2\2\2=?\5\16\b\2>=\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2"+
		"\2A\r\3\2\2\2B@\3\2\2\2CD\5\6\4\2DF\5\30\r\2EG\5\26\f\2FE\3\2\2\2FG\3"+
		"\2\2\2GH\3\2\2\2HI\7\17\2\2I\17\3\2\2\2JL\5\22\n\2KJ\3\2\2\2LO\3\2\2\2"+
		"MK\3\2\2\2MN\3\2\2\2N\21\3\2\2\2OM\3\2\2\2PQ\7\20\2\2QR\5\32\16\2RS\7"+
		"\17\2\2S_\3\2\2\2TU\7\17\2\2UV\5\32\16\2VW\7\20\2\2W_\3\2\2\2XY\7\17\2"+
		"\2YZ\5\32\16\2Z[\7\20\2\2[\\\5\32\16\2\\]\7\17\2\2]_\3\2\2\2^P\3\2\2\2"+
		"^T\3\2\2\2^X\3\2\2\2_\23\3\2\2\2`b\7\20\2\2a`\3\2\2\2be\3\2\2\2ca\3\2"+
		"\2\2cd\3\2\2\2d\25\3\2\2\2ec\3\2\2\2fg\t\3\2\2g\27\3\2\2\2hi\t\4\2\2i"+
		"\31\3\2\2\2jk\t\5\2\2k\33\3\2\2\2\13%/\669@FM^c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}