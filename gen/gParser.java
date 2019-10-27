// Generated from C:/Users/Paolo/IdeaProjects/untitled\g.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class gParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, A=5, X=6;
	public static final int
		RULE_prule = 0, RULE_s = 1, RULE_c = 2, RULE_r = 3, RULE_o = 4, RULE_n = 5, 
		RULE_d = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"prule", "s", "c", "r", "o", "n", "d"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "' U '", "'('", "')'", "'E'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "A", "X"
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
	public String getGrammarFileName() { return "g.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public gParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class PruleContext extends ParserRuleContext {
		public SContext s() {
			return getRuleContext(SContext.class,0);
		}
		public PruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterPrule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitPrule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitPrule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PruleContext prule() throws RecognitionException {
		PruleContext _localctx = new PruleContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			s(0);
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

	public static class SContext extends ParserRuleContext {
		public CContext c() {
			return getRuleContext(CContext.class,0);
		}
		public SContext s() {
			return getRuleContext(SContext.class,0);
		}
		public SContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_s; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitS(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitS(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SContext s() throws RecognitionException {
		return s(0);
	}

	private SContext s(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		SContext _localctx = new SContext(_ctx, _parentState);
		SContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_s, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(17);
			c();
			}
			_ctx.stop = _input.LT(-1);
			setState(24);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new SContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_s);
					setState(19);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(20);
					match(T__0);
					setState(21);
					c();
					}
					} 
				}
				setState(26);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
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

	public static class CContext extends ParserRuleContext {
		public RContext r() {
			return getRuleContext(RContext.class,0);
		}
		public SContext s() {
			return getRuleContext(SContext.class,0);
		}
		public OContext o() {
			return getRuleContext(OContext.class,0);
		}
		public CContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_c; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterC(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitC(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitC(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CContext c() throws RecognitionException {
		CContext _localctx = new CContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_c);
		try {
			setState(37);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(27);
				r();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(28);
				match(T__1);
				setState(29);
				s(0);
				setState(30);
				match(T__2);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(32);
				match(T__1);
				setState(33);
				s(0);
				setState(34);
				match(T__2);
				setState(35);
				o();
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

	public static class RContext extends ParserRuleContext {
		public NContext n() {
			return getRuleContext(NContext.class,0);
		}
		public RContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_r; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitR(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitR(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RContext r() throws RecognitionException {
		RContext _localctx = new RContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_r);
		try {
			setState(41);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case A:
				enterOuterAlt(_localctx, 1);
				{
				setState(39);
				n(0);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(40);
				match(T__3);
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

	public static class OContext extends ParserRuleContext {
		public TerminalNode X() { return getToken(gParser.X, 0); }
		public NContext n() {
			return getRuleContext(NContext.class,0);
		}
		public OContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_o; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterO(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitO(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitO(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OContext o() throws RecognitionException {
		OContext _localctx = new OContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_o);
		try {
			setState(46);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				match(X);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				match(X);
				setState(45);
				n(0);
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

	public static class NContext extends ParserRuleContext {
		public DContext d() {
			return getRuleContext(DContext.class,0);
		}
		public NContext n() {
			return getRuleContext(NContext.class,0);
		}
		public NContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_n; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterN(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitN(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitN(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NContext n() throws RecognitionException {
		return n(0);
	}

	private NContext n(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		NContext _localctx = new NContext(_ctx, _parentState);
		NContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_n, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(49);
			d();
			}
			_ctx.stop = _input.LT(-1);
			setState(55);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new NContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_n);
					setState(51);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(52);
					d();
					}
					} 
				}
				setState(57);
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
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class DContext extends ParserRuleContext {
		public TerminalNode A() { return getToken(gParser.A, 0); }
		public TerminalNode X() { return getToken(gParser.X, 0); }
		public DContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_d; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterD(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitD(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitD(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DContext d() throws RecognitionException {
		DContext _localctx = new DContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_d);
		try {
			setState(61);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				match(A);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				match(A);
				setState(60);
				match(X);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return s_sempred((SContext)_localctx, predIndex);
		case 5:
			return n_sempred((NContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean s_sempred(SContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean n_sempred(NContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\bB\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\7\3\31\n\3\f\3\16\3\34\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\5\4(\n\4\3\5\3\5\5\5,\n\5\3\6\3\6\3\6\5\6\61\n\6\3\7\3\7\3\7\3\7\3"+
		"\7\7\78\n\7\f\7\16\7;\13\7\3\b\3\b\3\b\5\b@\n\b\3\b\2\4\4\f\t\2\4\6\b"+
		"\n\f\16\2\2\2A\2\20\3\2\2\2\4\22\3\2\2\2\6\'\3\2\2\2\b+\3\2\2\2\n\60\3"+
		"\2\2\2\f\62\3\2\2\2\16?\3\2\2\2\20\21\5\4\3\2\21\3\3\2\2\2\22\23\b\3\1"+
		"\2\23\24\5\6\4\2\24\32\3\2\2\2\25\26\f\3\2\2\26\27\7\3\2\2\27\31\5\6\4"+
		"\2\30\25\3\2\2\2\31\34\3\2\2\2\32\30\3\2\2\2\32\33\3\2\2\2\33\5\3\2\2"+
		"\2\34\32\3\2\2\2\35(\5\b\5\2\36\37\7\4\2\2\37 \5\4\3\2 !\7\5\2\2!(\3\2"+
		"\2\2\"#\7\4\2\2#$\5\4\3\2$%\7\5\2\2%&\5\n\6\2&(\3\2\2\2\'\35\3\2\2\2\'"+
		"\36\3\2\2\2\'\"\3\2\2\2(\7\3\2\2\2),\5\f\7\2*,\7\6\2\2+)\3\2\2\2+*\3\2"+
		"\2\2,\t\3\2\2\2-\61\7\b\2\2./\7\b\2\2/\61\5\f\7\2\60-\3\2\2\2\60.\3\2"+
		"\2\2\61\13\3\2\2\2\62\63\b\7\1\2\63\64\5\16\b\2\649\3\2\2\2\65\66\f\3"+
		"\2\2\668\5\16\b\2\67\65\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:\r\3\2"+
		"\2\2;9\3\2\2\2<@\7\7\2\2=>\7\7\2\2>@\7\b\2\2?<\3\2\2\2?=\3\2\2\2@\17\3"+
		"\2\2\2\b\32\'+\609?";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}