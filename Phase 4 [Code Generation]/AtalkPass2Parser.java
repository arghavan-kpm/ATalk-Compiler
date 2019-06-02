// Generated from AtalkPass2.g4 by ANTLR 4.7

	import java.util.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AtalkPass2Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, CONST_NUM=38, 
		CONST_CHAR=39, CONST_STR=40, NL=41, ID=42, COMMENT=43, WS=44;
	public static final int
		RULE_program = 0, RULE_actor = 1, RULE_state = 2, RULE_receiver = 3, RULE_type = 4, 
		RULE_block = 5, RULE_statements = 6, RULE_statement = 7, RULE_stm_vardef = 8, 
		RULE_stm_tell = 9, RULE_stm_write = 10, RULE_stm_if_elseif_else = 11, 
		RULE_stm_foreach = 12, RULE_stm_quit = 13, RULE_stm_break = 14, RULE_stm_assignment = 15, 
		RULE_expr = 16, RULE_expr_assign = 17, RULE_expr_or = 18, RULE_expr_or_tmp = 19, 
		RULE_expr_and = 20, RULE_expr_and_tmp = 21, RULE_expr_eq = 22, RULE_expr_eq_tmp = 23, 
		RULE_expr_cmp = 24, RULE_expr_cmp_tmp = 25, RULE_expr_add = 26, RULE_expr_add_tmp = 27, 
		RULE_expr_mult = 28, RULE_expr_mult_tmp = 29, RULE_expr_un = 30, RULE_expr_mem = 31, 
		RULE_expr_mem_tmp = 32, RULE_expr_other = 33;
	public static final String[] ruleNames = {
		"program", "actor", "state", "receiver", "type", "block", "statements", 
		"statement", "stm_vardef", "stm_tell", "stm_write", "stm_if_elseif_else", 
		"stm_foreach", "stm_quit", "stm_break", "stm_assignment", "expr", "expr_assign", 
		"expr_or", "expr_or_tmp", "expr_and", "expr_and_tmp", "expr_eq", "expr_eq_tmp", 
		"expr_cmp", "expr_cmp_tmp", "expr_add", "expr_add_tmp", "expr_mult", "expr_mult_tmp", 
		"expr_un", "expr_mem", "expr_mem_tmp", "expr_other"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'actor'", "'<'", "'>'", "'end'", "','", "'receiver'", "'('", "')'", 
		"'char'", "'['", "']'", "'int'", "'begin'", "'='", "'sender'", "'self'", 
		"'<<'", "'write'", "'if'", "'elseif'", "'else'", "'foreach'", "'in'", 
		"'quit'", "'break'", "'or'", "'and'", "'=='", "'<>'", "'+'", "'-'", "'*'", 
		"'/'", "'not'", "'{'", "'}'", "'read'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "CONST_NUM", "CONST_CHAR", "CONST_STR", "NL", "ID", "COMMENT", 
		"WS"
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

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "AtalkPass2.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


		int IsInit = 0;
		int IsElementArrNotProper = 0;
		int forStack = 0;
		int ifCnt = 0;
		int forCnt = 0;
		int RecvCnt = 0;
		int ActorCnt = 0;
		int MaxMesgSize = 0;
		ArrayList<Integer> ActorSize = new ArrayList<Integer>();
		ArrayList<Integer> initInd = new ArrayList<Integer>();
		String CurrActor ="";
		Stack<Integer> forCntStack = new Stack<Integer>();
		HashMap<String, Integer> Act2Ind = new HashMap<String, Integer>();
		HashMap<String, Integer> Recv2Ind = new HashMap<String, Integer>();

		void print(String str){
	        System.out.println(str);
	    }

	    void beginScope() {
	        SymbolTable.push();
	    }

	    void endScope() {
	        print("Stack offset: " + SymbolTable.top.getOffset(Register.SP) + ", Global offset: " + SymbolTable.top.getOffset(Register.GP));
	        SymbolTable.pop();
	    }

	    void putNoTypeVar(String name){
	        try{
		        SymbolTable.top.put(
		            new SymbolTableLocalVariableItem(
		                new Variable(name, NoType.getInstance()),
		                SymbolTable.top.getOffset(Register.SP)
		            )
		        );
	   		}
	   		catch(ItemAlreadyExistsException e){}
	    }

			AtalkTranslator mips = new AtalkTranslator();

	public AtalkPass2Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public List<ActorContext> actor() {
			return getRuleContexts(ActorContext.class);
		}
		public ActorContext actor(int i) {
			return getRuleContext(ActorContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(AtalkPass2Parser.NL); }
		public TerminalNode NL(int i) {
			return getToken(AtalkPass2Parser.NL, i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

			        print("Pass2 started -------------------------");
			        beginScope();
			        int rcvCnt = 0;
			        ArrayList Actors = new ArrayList(SymbolTable.top.items.values()) ;
			        for(int i=Actors.size() - 1; i >= 0; i--){
			        	ActorType tmp = (ActorType) Actors.get(i);
			        	ActorSize.add(tmp.BufSize);
			        	if(MaxMesgSize < tmp.MaxMesg)
			        		MaxMesgSize = tmp.MaxMesg;
			        	Act2Ind.put(tmp.getKey(), Actors.size() - i - 1);
			        	boolean This_flag = false;
			        	for(int j=0; j< tmp.Recv.size(); j++){
			        		rcvCnt++;
			        		
							Recv2Ind.put(tmp.getKey()+"_"+tmp.Recv.get(j), rcvCnt);
							if(tmp.Recv.get(j).equals("init()") == true){
								initInd.add(rcvCnt);
								This_flag = true;
							}
							
						}
						if(This_flag == false)
							initInd.add(0);

			        }
			        mips.setMaxMesg(MaxMesgSize + 4);
			    
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0 || _la==NL) {
				{
				setState(71);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(69);
					actor();
					}
					break;
				case NL:
					{
					setState(70);
					match(NL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}


			        endScope();
			        print("Pass2 finished -------------------------");
							mips.makeOutput(ActorSize, initInd, MaxMesgSize+4,RecvCnt);
			    
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

	public static class ActorContext extends ParserRuleContext {
		public Token actor_name;
		public Token num;
		public List<TerminalNode> NL() { return getTokens(AtalkPass2Parser.NL); }
		public TerminalNode NL(int i) {
			return getToken(AtalkPass2Parser.NL, i);
		}
		public TerminalNode ID() { return getToken(AtalkPass2Parser.ID, 0); }
		public TerminalNode CONST_NUM() { return getToken(AtalkPass2Parser.CONST_NUM, 0); }
		public TerminalNode EOF() { return getToken(AtalkPass2Parser.EOF, 0); }
		public List<StateContext> state() {
			return getRuleContexts(StateContext.class);
		}
		public StateContext state(int i) {
			return getRuleContext(StateContext.class,i);
		}
		public List<ReceiverContext> receiver() {
			return getRuleContexts(ReceiverContext.class);
		}
		public ReceiverContext receiver(int i) {
			return getRuleContext(ReceiverContext.class,i);
		}
		public ActorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).enterActor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).exitActor(this);
		}
	}

	public final ActorContext actor() throws RecognitionException {
		ActorContext _localctx = new ActorContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_actor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(T__0);
			setState(79);
			((ActorContext)_localctx).actor_name = match(ID);
			setState(80);
			match(T__1);
			setState(81);
			((ActorContext)_localctx).num = match(CONST_NUM);
			setState(82);
			match(T__2);
			setState(83);
			match(NL);

						beginScope();
						
						CurrActor = (((ActorContext)_localctx).actor_name!=null?((ActorContext)_localctx).actor_name.getText():null) ;
						
						
					
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__8) | (1L << T__11) | (1L << NL))) != 0)) {
				{
				setState(88);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__8:
				case T__11:
					{
					setState(85);
					state();
					}
					break;
				case T__5:
					{
					setState(86);
					receiver();
					}
					break;
				case NL:
					{
					setState(87);
					match(NL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(93);
			match(T__3);
			setState(94);
			_la = _input.LA(1);
			if ( !(_la==EOF || _la==NL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			endScope(); ActorCnt++;
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

	public static class StateContext extends ParserRuleContext {
		public TypeContext var_type;
		public Token var_id;
		public TerminalNode NL() { return getToken(AtalkPass2Parser.NL, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(AtalkPass2Parser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AtalkPass2Parser.ID, i);
		}
		public StateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_state; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).enterState(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).exitState(this);
		}
	}

	public final StateContext state() throws RecognitionException {
		StateContext _localctx = new StateContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_state);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			((StateContext)_localctx).var_type = type();
			setState(98);
			((StateContext)_localctx).var_id = match(ID);

							SymbolTableItem item = SymbolTable.top.get((((StateContext)_localctx).var_id!=null?((StateContext)_localctx).var_id.getText():null));
							SymbolTableVariableItemBase var = (SymbolTableVariableItemBase) item;
							mips.addGlobalVariable(var.getOffset(), var.getVariable().getType());
						
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(100);
				match(T__4);
				setState(101);
				((StateContext)_localctx).var_id = match(ID);

								item = SymbolTable.top.get((((StateContext)_localctx).var_id!=null?((StateContext)_localctx).var_id.getText():null));
								var = (SymbolTableVariableItemBase) item;
								mips.addGlobalVariable(var.getOffset(), var.getVariable().getType());
							
				}
				}
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(108);
			match(NL);
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

	public static class ReceiverContext extends ParserRuleContext {
		public Token temp;
		public Token id;
		public List<TerminalNode> NL() { return getTokens(AtalkPass2Parser.NL); }
		public TerminalNode NL(int i) {
			return getToken(AtalkPass2Parser.NL, i);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(AtalkPass2Parser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AtalkPass2Parser.ID, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public ReceiverContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_receiver; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).enterReceiver(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).exitReceiver(this);
		}
	}

	public final ReceiverContext receiver() throws RecognitionException {
		ReceiverContext _localctx = new ReceiverContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_receiver);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 
						beginScope();
						int cnt = 0; RecvCnt++;
			        		
						int RecvMesgSize = 0;
						int argSize = 0;
						mips.startRecv(RecvCnt);
					
			setState(111);
			match(T__5);
			setState(112);
			((ReceiverContext)_localctx).temp = match(ID);
			setState(113);
			match(T__6);
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8 || _la==T__11) {
				{
				setState(114);
				type();
				setState(115);
				((ReceiverContext)_localctx).id = match(ID);


							cnt++; 
							SymbolTable.define(); 
							SymbolTableLocalVariableItem var = (SymbolTableLocalVariableItem)SymbolTable.top.get((((ReceiverContext)_localctx).id!=null?((ReceiverContext)_localctx).id.getText():null));

							mips.addLocalVariable(var.getOffset(), var.getVariable().getType());

							mips.addLocalVariableAddrToStack(var.getOffset());
							mips.loadFromQ(ActorSize, Act2Ind.get(CurrActor), argSize, var.getVariable().getType());
							mips.assignCommand(var.getVariable().getType());
							argSize += var.getVariable().getType().size();
						
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(117);
					match(T__4);
					setState(118);
					type();
					setState(119);
					((ReceiverContext)_localctx).id = match(ID);
					 
								cnt++; 
								SymbolTable.define(); 
								SymbolTableLocalVariableItem item = (SymbolTableLocalVariableItem)SymbolTable.top.get((((ReceiverContext)_localctx).id!=null?((ReceiverContext)_localctx).id.getText():null));

								mips.addLocalVariable(item.getOffset(), item.getVariable().getType());

								mips.addLocalVariableAddrToStack(item.getOffset());
								mips.loadFromQ(ActorSize, Act2Ind.get(CurrActor), argSize, item.getVariable().getType());
								mips.assignCommand(item.getVariable().getType());
								argSize += item.getVariable().getType().size();

							
					}
					}
					setState(126);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(129);
			match(T__7);
			setState(130);
			match(NL);
							
							if(MaxMesgSize < RecvMesgSize)
								MaxMesgSize = RecvMesgSize;
							
							mips.loadFromQ(ActorSize, Act2Ind.get(CurrActor));
							
							if(((((ReceiverContext)_localctx).temp!=null?((ReceiverContext)_localctx).temp.getText():null).equals("init") == true) && (cnt == 0))
								IsInit = 1;
						
			setState(132);
			statements();
			setState(133);
			match(T__3);
			setState(134);
			match(NL);

						mips.endRecv(RecvCnt);
						IsInit = 0;
						endScope();
					
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

	public static class TypeContext extends ParserRuleContext {
		public List<TerminalNode> CONST_NUM() { return getTokens(AtalkPass2Parser.CONST_NUM); }
		public TerminalNode CONST_NUM(int i) {
			return getToken(AtalkPass2Parser.CONST_NUM, i);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type);
		int _la;
		try {
			setState(155);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				match(T__8);
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(138);
					match(T__9);
					setState(139);
					match(CONST_NUM);
					setState(140);
					match(T__10);
					}
					}
					setState(145);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				setState(146);
				match(T__11);
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(147);
					match(T__9);
					setState(148);
					match(CONST_NUM);
					setState(149);
					match(T__10);
					}
					}
					setState(154);
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

	public static class BlockContext extends ParserRuleContext {
		public List<TerminalNode> NL() { return getTokens(AtalkPass2Parser.NL); }
		public TerminalNode NL(int i) {
			return getToken(AtalkPass2Parser.NL, i);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{

						beginScope();
						SymbolTable.top.setOffset(Register.SP,SymbolTable.top.getOffset(Register.SP) + forStack);
						mips.beginBlock();

					
			setState(158);
			match(T__12);
			setState(159);
			match(NL);
			setState(160);
			statements();
			setState(161);
			match(T__3);
			setState(162);
			match(NL);

						mips.endBlock();
						endScope();
					
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

	public static class StatementsContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(AtalkPass2Parser.NL); }
		public TerminalNode NL(int i) {
			return getToken(AtalkPass2Parser.NL, i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).exitStatements(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__8) | (1L << T__11) | (1L << T__12) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__30) | (1L << T__33) | (1L << T__34) | (1L << T__36) | (1L << CONST_NUM) | (1L << CONST_CHAR) | (1L << CONST_STR) | (1L << NL) | (1L << ID))) != 0)) {
				{
				setState(167);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__6:
				case T__8:
				case T__11:
				case T__12:
				case T__14:
				case T__15:
				case T__17:
				case T__18:
				case T__21:
				case T__23:
				case T__24:
				case T__30:
				case T__33:
				case T__34:
				case T__36:
				case CONST_NUM:
				case CONST_CHAR:
				case CONST_STR:
				case ID:
					{
					setState(165);
					statement();
					}
					break;
				case NL:
					{
					setState(166);
					match(NL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(171);
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

	public static class StatementContext extends ParserRuleContext {
		public Stm_vardefContext stm_vardef() {
			return getRuleContext(Stm_vardefContext.class,0);
		}
		public Stm_assignmentContext stm_assignment() {
			return getRuleContext(Stm_assignmentContext.class,0);
		}
		public Stm_foreachContext stm_foreach() {
			return getRuleContext(Stm_foreachContext.class,0);
		}
		public Stm_if_elseif_elseContext stm_if_elseif_else() {
			return getRuleContext(Stm_if_elseif_elseContext.class,0);
		}
		public Stm_quitContext stm_quit() {
			return getRuleContext(Stm_quitContext.class,0);
		}
		public Stm_breakContext stm_break() {
			return getRuleContext(Stm_breakContext.class,0);
		}
		public Stm_tellContext stm_tell() {
			return getRuleContext(Stm_tellContext.class,0);
		}
		public Stm_writeContext stm_write() {
			return getRuleContext(Stm_writeContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_statement);
		try {
			setState(181);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				stm_vardef();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
				stm_assignment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(174);
				stm_foreach();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(175);
				stm_if_elseif_else();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(176);
				stm_quit();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(177);
				stm_break();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(178);
				stm_tell();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(179);
				stm_write();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(180);
				block();
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

	public static class Stm_vardefContext extends ParserRuleContext {
		public Token id;
		public ExprContext temp;
		public Token id1;
		public ExprContext tmp;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode NL() { return getToken(AtalkPass2Parser.NL, 0); }
		public List<TerminalNode> ID() { return getTokens(AtalkPass2Parser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AtalkPass2Parser.ID, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Stm_vardefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stm_vardef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).enterStm_vardef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).exitStm_vardef(this);
		}
	}

	public final Stm_vardefContext stm_vardef() throws RecognitionException {
		Stm_vardefContext _localctx = new Stm_vardefContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_stm_vardef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			type();
			setState(184);
			((Stm_vardefContext)_localctx).id = match(ID);

					 	SymbolTable.define(); 
					 	SymbolTableLocalVariableItem var = (SymbolTableLocalVariableItem)SymbolTable.top.get((((Stm_vardefContext)_localctx).id!=null?((Stm_vardefContext)_localctx).id.getText():null));
					 	mips.addLocalVariable(var.getOffset(), var.getVariable().getType());

					
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(186);
				match(T__13);
				 mips.addLocalVariableAddrToStack(var.getOffset()); 
				setState(188);
				((Stm_vardefContext)_localctx).temp = expr();

								mips.assignCommand(((Stm_vardefContext)_localctx).temp.return_type);
								SymbolTableLocalVariableItem item = (SymbolTableLocalVariableItem)SymbolTable.top.get((((Stm_vardefContext)_localctx).id!=null?((Stm_vardefContext)_localctx).id.getText():null));

								if(((Stm_vardefContext)_localctx).temp.return_type.toString().equals(item.getVariable().getType().toString()) == false ){
									print(String.format("[Line #%s] assignment unavailable", ((Stm_vardefContext)_localctx).temp.line));
								}
							
				}
			}

			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(193);
				match(T__4);
				setState(194);
				((Stm_vardefContext)_localctx).id1 = match(ID);
				 
							SymbolTable.define(); 
							SymbolTableLocalVariableItem var1 = (SymbolTableLocalVariableItem)SymbolTable.top.get((((Stm_vardefContext)_localctx).id1!=null?((Stm_vardefContext)_localctx).id1.getText():null));
						 	mips.addLocalVariable(var1.getOffset(), var1.getVariable().getType());
						
				setState(201);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(196);
					match(T__13);
					 mips.addLocalVariableAddrToStack(var1.getOffset()); 
					setState(198);
					((Stm_vardefContext)_localctx).tmp = expr();

									mips.assignCommand(((Stm_vardefContext)_localctx).tmp.return_type);
									SymbolTableLocalVariableItem item = (SymbolTableLocalVariableItem)SymbolTable.top.get((((Stm_vardefContext)_localctx).id1!=null?((Stm_vardefContext)_localctx).id1.getText():null));

									if(((Stm_vardefContext)_localctx).tmp.return_type.toString().equals(item.getVariable().getType().toString()) == false ){
										print(String.format("[Line #%s] assignment unavailable", ((Stm_vardefContext)_localctx).temp.line));
									}
								
					}
				}

				}
				}
				setState(207);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(208);
			match(NL);
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

	public static class Stm_tellContext extends ParserRuleContext {
		public Token id;
		public Token temp;
		public ExprContext Tmp;
		public ExprContext tmp;
		public TerminalNode NL() { return getToken(AtalkPass2Parser.NL, 0); }
		public List<TerminalNode> ID() { return getTokens(AtalkPass2Parser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AtalkPass2Parser.ID, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Stm_tellContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stm_tell; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).enterStm_tell(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).exitStm_tell(this);
		}
	}

	public final Stm_tellContext stm_tell() throws RecognitionException {
		Stm_tellContext _localctx = new Stm_tellContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_stm_tell);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			String TELL;
			setState(217);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(211);
				((Stm_tellContext)_localctx).id = match(ID);

							TELL = (((Stm_tellContext)_localctx).id!=null?((Stm_tellContext)_localctx).id.getText():null);

							
							//System.err.println("Hello");
				            if(Act2Ind.containsKey(TELL) == false)
				                print(String.format("[Line #%s] actor \"%s\" doesn't exist.", ((Stm_tellContext)_localctx).id.getLine(), (((Stm_tellContext)_localctx).id!=null?((Stm_tellContext)_localctx).id.getText():null)));
						
				}
				break;
			case T__14:
				{
				setState(213);
				((Stm_tellContext)_localctx).id = match(T__14);

								TELL = "sender";
								if(IsInit == 1)
									print(String.format("[Line #%s] \"init\" receiver has no access to sender actor.", ((Stm_tellContext)_localctx).id.getLine()));
									/* EMTIAZI */
							
				}
				break;
			case T__15:
				{
				setState(215);
				match(T__15);

								TELL = "self";
							
				}
				break;
			default:
				throw new NoViableAltException(this);
			}

						ArrayList arg = new ArrayList();
					
			setState(220);
			match(T__16);
			setState(221);
			((Stm_tellContext)_localctx).temp = match(ID);
			setState(222);
			match(T__6);
			setState(234);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__30) | (1L << T__33) | (1L << T__34) | (1L << T__36) | (1L << CONST_NUM) | (1L << CONST_CHAR) | (1L << CONST_STR) | (1L << ID))) != 0)) {
				{
				setState(223);
				((Stm_tellContext)_localctx).Tmp = expr();

							if(((Stm_tellContext)_localctx).Tmp.IsLvalue == 1)
								mips.addVariableToStack(((Stm_tellContext)_localctx).Tmp.return_type);
							arg.add(((Stm_tellContext)_localctx).Tmp.return_type);
						
				setState(231);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(225);
					match(T__4);
					setState(226);
					((Stm_tellContext)_localctx).tmp = expr();

								if(((Stm_tellContext)_localctx).tmp.IsLvalue == 1)
									mips.addVariableToStack(((Stm_tellContext)_localctx).tmp.return_type);
								arg.add(((Stm_tellContext)_localctx).tmp.return_type);

							
					}
					}
					setState(233);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(236);
			match(T__7);
			setState(237);
			match(NL);

						String sign = new ReceiveType((((Stm_tellContext)_localctx).temp!=null?((Stm_tellContext)_localctx).temp.getText():null), arg).getKey();

						if(TELL.equals("self") == true){
							SymbolTableItem item = SymbolTable.top.get(sign);
							if(item == null)
			                	print(String.format("[Line #%s] this actor has not receiver \"%s\".", ((Stm_tellContext)_localctx).temp.getLine(), sign));
			                else{
			                	mips.add2Q(ActorSize,Act2Ind.get(CurrActor), Recv2Ind.get(CurrActor + "_" + sign), arg);
			                }
						}
						else if(TELL.equals("sender") == true){/*EMTIAZI*/

						}
						else{
							
							if(Act2Ind.containsKey(TELL) == true){
								int haveRecv = 0;
								SymbolTableItem item = SymbolTable.top.get(TELL);
								ActorType casted = (ActorType)item;
								for(int i=0; i<casted.Recv.size(); i++){
									if(casted.Recv.get(i).equals(sign) == true){
										haveRecv = 1;
										
										mips.add2Q(ActorSize,Act2Ind.get(TELL), Recv2Ind.get(TELL + "_" + sign), arg);
									}
								}
								if(haveRecv == 0)
									print(String.format("[Line #%s] actor \"%s\" doesn't have receiver \"%s\".", ((Stm_tellContext)_localctx).temp.getLine(), TELL, sign));

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

	public static class Stm_writeContext extends ParserRuleContext {
		public ExprContext temp;
		public TerminalNode NL() { return getToken(AtalkPass2Parser.NL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Stm_writeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stm_write; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).enterStm_write(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).exitStm_write(this);
		}
	}

	public final Stm_writeContext stm_write() throws RecognitionException {
		Stm_writeContext _localctx = new Stm_writeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_stm_write);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			match(T__17);
			setState(241);
			match(T__6);
			setState(242);
			((Stm_writeContext)_localctx).temp = expr();

						if((((Stm_writeContext)_localctx).temp.return_type.toString().equals("int") == true) || ((Stm_writeContext)_localctx).temp.return_type.toString().equals("char")==true ||
						 ((((Stm_writeContext)_localctx).temp.return_type instanceof ArrType) && (((ArrType)((Stm_writeContext)_localctx).temp.return_type).base.toString().equals("char") == true) && (((ArrType)((Stm_writeContext)_localctx).temp.return_type).dimension.size()== 1))){
						 	if(((Stm_writeContext)_localctx).temp.IsLvalue ==1)
						 		mips.addVariableToStack(((Stm_writeContext)_localctx).temp.return_type);
							mips.write(((Stm_writeContext)_localctx).temp.return_type);
						}
						else{
							print(String.format("[Line #%s] \"write\" operation in not valid.", ((Stm_writeContext)_localctx).temp.line));
						}
					
			setState(244);
			match(T__7);
			setState(245);
			match(NL);
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

	public static class Stm_if_elseif_elseContext extends ParserRuleContext {
		public ExprContext temp;
		public ExprContext tmp;
		public List<TerminalNode> NL() { return getTokens(AtalkPass2Parser.NL); }
		public TerminalNode NL(int i) {
			return getToken(AtalkPass2Parser.NL, i);
		}
		public List<StatementsContext> statements() {
			return getRuleContexts(StatementsContext.class);
		}
		public StatementsContext statements(int i) {
			return getRuleContext(StatementsContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Stm_if_elseif_elseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stm_if_elseif_else; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).enterStm_if_elseif_else(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).exitStm_if_elseif_else(this);
		}
	}

	public final Stm_if_elseif_elseContext stm_if_elseif_else() throws RecognitionException {
		Stm_if_elseif_elseContext _localctx = new Stm_if_elseif_elseContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_stm_if_elseif_else);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

						int thisIfInd = 0;
						beginScope();
						int elseIfCnt = 0;
						SymbolTable.top.setOffset(Register.SP,SymbolTable.top.getOffset(Register.SP) + forStack);

					
			setState(248);
			match(T__18);
			setState(249);
			((Stm_if_elseif_elseContext)_localctx).temp = expr();

						ifCnt++;
						thisIfInd = ifCnt;
						if(((Stm_if_elseif_elseContext)_localctx).temp.return_type.toString().equals("int") == false){
							print(String.format("[Line #%s] if condition is invalid.", ((Stm_if_elseif_elseContext)_localctx).temp.line));
						}
						mips.ifChecking(thisIfInd);
					
			setState(251);
			match(NL);
			setState(252);
			statements();

						endScope();
						mips.ifEnd(thisIfInd);
					
			setState(265);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19) {
				{
				{

								beginScope();
								SymbolTable.top.setOffset(Register.SP,SymbolTable.top.getOffset(Register.SP) + forStack);
							
				setState(255);
				match(T__19);
				 mips.putNotIf_NotElseIf(thisIfInd, elseIfCnt); 
				setState(257);
				((Stm_if_elseif_elseContext)_localctx).tmp = expr();
								

								elseIfCnt++;
								if(((Stm_if_elseif_elseContext)_localctx).tmp.return_type.toString().equals("int") == false){
									print(String.format("[Line #%s] if condition is invalid.", ((Stm_if_elseif_elseContext)_localctx).tmp.line));
								}
								mips.elseifChecking(thisIfInd, elseIfCnt);
							
				setState(259);
				match(NL);
				setState(260);
				statements();

								endScope();
								mips.ifEnd(thisIfInd);
							
				}
				}
				setState(267);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 mips.putNotIf_NotElseIf(thisIfInd, elseIfCnt); 
			setState(275);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{

								beginScope();
								SymbolTable.top.setOffset(Register.SP,SymbolTable.top.getOffset(Register.SP) + forStack);
							
				setState(270);
				match(T__20);
				setState(271);
				match(NL);
				setState(272);
				statements();
				endScope();
				}
			}

			 mips.putEndIf(thisIfInd); 
			setState(278);
			match(T__3);
			setState(279);
			match(NL);
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

	public static class Stm_foreachContext extends ParserRuleContext {
		public Token temp;
		public ExprContext tmp;
		public List<TerminalNode> NL() { return getTokens(AtalkPass2Parser.NL); }
		public TerminalNode NL(int i) {
			return getToken(AtalkPass2Parser.NL, i);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode ID() { return getToken(AtalkPass2Parser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Stm_foreachContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stm_foreach; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).enterStm_foreach(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).exitStm_foreach(this);
		}
	}

	public final Stm_foreachContext stm_foreach() throws RecognitionException {
		Stm_foreachContext _localctx = new Stm_foreachContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_stm_foreach);
		try {
			enterOuterAlt(_localctx, 1);
			{

						int thisForInd = forCnt++;
						forCntStack.push(thisForInd);
						beginScope();
						int thisForVar = 0;
					
			setState(282);
			match(T__21);
			setState(283);
			((Stm_foreachContext)_localctx).temp = match(ID);
			setState(284);
			match(T__22);
			setState(285);
			((Stm_foreachContext)_localctx).tmp = expr();
			setState(286);
			match(NL);

						if(((Stm_foreachContext)_localctx).tmp.return_type instanceof ArrType){
							ArrType G = (ArrType)((Stm_foreachContext)_localctx).tmp.return_type;
							forStack += G.base.size();
							if(G.dimension.size() == 1){
							        SymbolTable.top.replace((((Stm_foreachContext)_localctx).temp!=null?((Stm_foreachContext)_localctx).temp.getText():null) ,
							            new SymbolTableLocalVariableItem(
							                new Variable((((Stm_foreachContext)_localctx).temp!=null?((Stm_foreachContext)_localctx).temp.getText():null), G.base),
							                SymbolTable.top.getOffset(Register.SP) + forStack
							            )
							        );
							        SymbolTable.define();
							        SymbolTableVariableItemBase castedItem = (SymbolTableVariableItemBase)SymbolTable.top.get((((Stm_foreachContext)_localctx).temp!=null?((Stm_foreachContext)_localctx).temp.getText():null));
							        thisForVar = G.base.size();
							        SymbolTable.top.setOffset(Register.SP,SymbolTable.top.getOffset(Register.SP) + forStack);
							}
							else{
								ArrayList arg = new ArrayList(G.dimension.subList(1, G.dimension.size()));
							    SymbolTableVariableItemBase castedItem = (SymbolTableVariableItemBase)SymbolTable.top.get((((Stm_foreachContext)_localctx).temp!=null?((Stm_foreachContext)_localctx).temp.getText():null));
							    thisForVar = G.size() / Integer.parseInt(G.dimension.get(0).toString());
							    forStack += G.size() / Integer.parseInt(G.dimension.get(0).toString());
						        SymbolTable.top.replace((((Stm_foreachContext)_localctx).temp!=null?((Stm_foreachContext)_localctx).temp.getText():null),
						            new SymbolTableLocalVariableItem(
						                new Variable((((Stm_foreachContext)_localctx).temp!=null?((Stm_foreachContext)_localctx).temp.getText():null), ArrType.getInstance(G.base, arg)),
						                SymbolTable.top.getOffset(Register.SP) + forStack
						            )
						        );
						        SymbolTable.define();
							    SymbolTable.top.setOffset(Register.SP,SymbolTable.top.getOffset(Register.SP) + forStack);
							}
							if(((Stm_foreachContext)_localctx).tmp.IsLvalue == 1)
								mips.addVariableToStack(((Stm_foreachContext)_localctx).tmp.return_type); //const for tmp

							mips.addConstIntToStack(Integer.parseInt (G.dimension.get(0).toString())); // add size to stack
							mips.addConstIntToStack(0); // add counter to stack

						}
						else{
							print(String.format("[Line #%s] can not iterate in non array variable.", ((Stm_foreachContext)_localctx).tmp.line));
						}
					
			 
							mips.beginBlock();
							mips.putForLabel(thisForInd);
							
							SymbolTableLocalVariableItem var = (SymbolTableLocalVariableItem)SymbolTable.top.get((((Stm_foreachContext)_localctx).temp!=null?((Stm_foreachContext)_localctx).temp.getText():null));
							mips.addLocalVariable(SymbolTable.top.getOffset(Register.SP), var.getVariable().getType());
							mips.addLocalVariableAddrToStack(SymbolTable.top.getOffset(Register.SP));
							mips.assigningID(var.getVariable().getType(), thisForInd);
						
			setState(289);
			statements();
			setState(290);
			match(T__3);
			setState(291);
			match(NL);

						mips.EndForLabel(thisForInd);
						mips.endBlock();
						endScope();
						forStack -= thisForVar;
						forCntStack.pop();
					
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

	public static class Stm_quitContext extends ParserRuleContext {
		public TerminalNode NL() { return getToken(AtalkPass2Parser.NL, 0); }
		public Stm_quitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stm_quit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).enterStm_quit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).exitStm_quit(this);
		}
	}

	public final Stm_quitContext stm_quit() throws RecognitionException {
		Stm_quitContext _localctx = new Stm_quitContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_stm_quit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			match(T__23);
			setState(295);
			match(NL);

						mips.jumpEndRecv(RecvCnt);
					
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

	public static class Stm_breakContext extends ParserRuleContext {
		public TerminalNode NL() { return getToken(AtalkPass2Parser.NL, 0); }
		public Stm_breakContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stm_break; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).enterStm_break(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).exitStm_break(this);
		}
	}

	public final Stm_breakContext stm_break() throws RecognitionException {
		Stm_breakContext _localctx = new Stm_breakContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_stm_break);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			match(T__24);
			setState(299);
			match(NL);

						mips.jumpEndForLabel(forCntStack.Top());
					
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

	public static class Stm_assignmentContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NL() { return getToken(AtalkPass2Parser.NL, 0); }
		public Stm_assignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stm_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).enterStm_assignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).exitStm_assignment(this);
		}
	}

	public final Stm_assignmentContext stm_assignment() throws RecognitionException {
		Stm_assignmentContext _localctx = new Stm_assignmentContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_stm_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			expr();
			setState(303);
			match(NL);
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
		public Type return_type;
		public int line;
		public int IsLvalue;
		public Expr_assignContext temp;
		public Expr_assignContext expr_assign() {
			return getRuleContext(Expr_assignContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			((ExprContext)_localctx).temp = expr_assign();

						((ExprContext)_localctx).return_type =  ((ExprContext)_localctx).temp.return_type;
						((ExprContext)_localctx).line =  ((ExprContext)_localctx).temp.line;
						((ExprContext)_localctx).IsLvalue =  ((ExprContext)_localctx).temp.IsLvalue;
					
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

	public static class Expr_assignContext extends ParserRuleContext {
		public Type return_type;
		public int line;
		public int IsLvalue;
		public Expr_orContext temp;
		public Expr_assignContext tmp;
		public Expr_orContext expr_or() {
			return getRuleContext(Expr_orContext.class,0);
		}
		public Expr_assignContext expr_assign() {
			return getRuleContext(Expr_assignContext.class,0);
		}
		public Expr_assignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).enterExpr_assign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).exitExpr_assign(this);
		}
	}

	public final Expr_assignContext expr_assign() throws RecognitionException {
		Expr_assignContext _localctx = new Expr_assignContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_expr_assign);
		try {
			setState(316);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(308);
				((Expr_assignContext)_localctx).temp = expr_or();
				setState(309);
				match(T__13);
				setState(310);
				((Expr_assignContext)_localctx).tmp = expr_assign();

							if(((Expr_assignContext)_localctx).temp.return_type.toString().equals(((Expr_assignContext)_localctx).tmp.return_type.toString()) == false ){
								((Expr_assignContext)_localctx).return_type =  NoType.getInstance();
								((Expr_assignContext)_localctx).line =  ((Expr_assignContext)_localctx).temp.line;
								print(String.format("[Line #%s] assignment unavailable", ((Expr_assignContext)_localctx).temp.line));
							}
							else{
								((Expr_assignContext)_localctx).return_type =  ((Expr_assignContext)_localctx).temp.return_type;
								((Expr_assignContext)_localctx).line =  ((Expr_assignContext)_localctx).temp.line;

							}
							if(((Expr_assignContext)_localctx).temp.IsLvalue == 0)
								print(String.format("[Line #%s] Lvalue is not correct", ((Expr_assignContext)_localctx).temp.line));
							else{
								((Expr_assignContext)_localctx).IsLvalue =  1;
								if(((Expr_assignContext)_localctx).tmp.IsLvalue == 1){
									mips.addVariableToStack(((Expr_assignContext)_localctx).tmp.return_type);
								}
								mips.assignCommand(((Expr_assignContext)_localctx).tmp.return_type);
							}
						
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(313);
				((Expr_assignContext)_localctx).temp = expr_or();

							((Expr_assignContext)_localctx).return_type =  ((Expr_assignContext)_localctx).temp.return_type;
							((Expr_assignContext)_localctx).line =  ((Expr_assignContext)_localctx).temp.line;
							((Expr_assignContext)_localctx).IsLvalue =  ((Expr_assignContext)_localctx).temp.IsLvalue;
						
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

	public static class Expr_orContext extends ParserRuleContext {
		public Type return_type;
		public int line;
		public int IsLvalue;
		public Expr_andContext temp;
		public Expr_or_tmpContext tmp;
		public Expr_andContext expr_and() {
			return getRuleContext(Expr_andContext.class,0);
		}
		public Expr_or_tmpContext expr_or_tmp() {
			return getRuleContext(Expr_or_tmpContext.class,0);
		}
		public Expr_orContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_or; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).enterExpr_or(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).exitExpr_or(this);
		}
	}

	public final Expr_orContext expr_or() throws RecognitionException {
		Expr_orContext _localctx = new Expr_orContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_expr_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			((Expr_orContext)_localctx).temp = expr_and();
			setState(319);
			((Expr_orContext)_localctx).tmp = expr_or_tmp();

						if(((Expr_orContext)_localctx).tmp.return_type != null && (((Expr_orContext)_localctx).temp.return_type.toString().equals(((Expr_orContext)_localctx).tmp.return_type.toString()) == false) )
							((Expr_orContext)_localctx).return_type =  NoType.getInstance();

						if(((Expr_orContext)_localctx).tmp.return_type != null && (((Expr_orContext)_localctx).temp.return_type.toString().equals("int") == false) && (((Expr_orContext)_localctx).temp.return_type.toString().equals("NoType") == false)){
							((Expr_orContext)_localctx).return_type =  NoType.getInstance();
							print(String.format("[Line #%s] \"or\" can't be used.", ((Expr_orContext)_localctx).temp.line));
						}
						else{
							((Expr_orContext)_localctx).return_type =  ((Expr_orContext)_localctx).temp.return_type;
						}
						((Expr_orContext)_localctx).line =  ((Expr_orContext)_localctx).temp.line;
						if(((Expr_orContext)_localctx).tmp.return_type != null){
							((Expr_orContext)_localctx).IsLvalue =  0;
							if(((Expr_orContext)_localctx).temp.IsLvalue == 1){ // addr bud
								mips.addrOrCommand();
							}
							if(((Expr_orContext)_localctx).temp.IsLvalue == 0){ // const bud
								mips.constOrCommand();
							}
						}
						else
							((Expr_orContext)_localctx).IsLvalue =  ((Expr_orContext)_localctx).temp.IsLvalue;
					
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

	public static class Expr_or_tmpContext extends ParserRuleContext {
		public Type return_type;
		public int line;
		public Expr_andContext temp;
		public Expr_or_tmpContext tmp;
		public Expr_andContext expr_and() {
			return getRuleContext(Expr_andContext.class,0);
		}
		public Expr_or_tmpContext expr_or_tmp() {
			return getRuleContext(Expr_or_tmpContext.class,0);
		}
		public Expr_or_tmpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_or_tmp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).enterExpr_or_tmp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).exitExpr_or_tmp(this);
		}
	}

	public final Expr_or_tmpContext expr_or_tmp() throws RecognitionException {
		Expr_or_tmpContext _localctx = new Expr_or_tmpContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_expr_or_tmp);
		try {
			setState(328);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__25:
				enterOuterAlt(_localctx, 1);
				{
				setState(322);
				match(T__25);
				setState(323);
				((Expr_or_tmpContext)_localctx).temp = expr_and();
				setState(324);
				((Expr_or_tmpContext)_localctx).tmp = expr_or_tmp();

							if( (((Expr_or_tmpContext)_localctx).temp.return_type.toString().equals("int") == false) && (((Expr_or_tmpContext)_localctx).temp.return_type.toString().equals("NoType") == false) ){
								((Expr_or_tmpContext)_localctx).return_type =  NoType.getInstance();
								((Expr_or_tmpContext)_localctx).line =  ((Expr_or_tmpContext)_localctx).temp.line;
								print(String.format("[Line #%s] \"or\" can't be used.", ((Expr_or_tmpContext)_localctx).temp.line));
							}
							else{
								((Expr_or_tmpContext)_localctx).return_type =  ((Expr_or_tmpContext)_localctx).temp.return_type;
								((Expr_or_tmpContext)_localctx).line =  ((Expr_or_tmpContext)_localctx).temp.line;
								if(((Expr_or_tmpContext)_localctx).tmp.return_type == null && ((Expr_or_tmpContext)_localctx).temp.IsLvalue == 1){
									mips.addVariableToStack(((Expr_or_tmpContext)_localctx).temp.return_type);
								}
								if(((Expr_or_tmpContext)_localctx).tmp.return_type != null && ((Expr_or_tmpContext)_localctx).temp.IsLvalue == 1){ // addr bud
									mips.addrOrCommand();
								}
								if(((Expr_or_tmpContext)_localctx).tmp.return_type != null && ((Expr_or_tmpContext)_localctx).temp.IsLvalue == 0){ // const bud
									mips.constOrCommand();
								}
							}
						
				}
				break;
			case T__4:
			case T__7:
			case T__10:
			case T__13:
			case T__35:
			case NL:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class Expr_andContext extends ParserRuleContext {
		public Type return_type;
		public int line;
		public int IsLvalue;
		public Expr_eqContext temp;
		public Expr_and_tmpContext tmp;
		public Expr_eqContext expr_eq() {
			return getRuleContext(Expr_eqContext.class,0);
		}
		public Expr_and_tmpContext expr_and_tmp() {
			return getRuleContext(Expr_and_tmpContext.class,0);
		}
		public Expr_andContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_and; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).enterExpr_and(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).exitExpr_and(this);
		}
	}

	public final Expr_andContext expr_and() throws RecognitionException {
		Expr_andContext _localctx = new Expr_andContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_expr_and);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
			((Expr_andContext)_localctx).temp = expr_eq();
			setState(331);
			((Expr_andContext)_localctx).tmp = expr_and_tmp();

						if(((Expr_andContext)_localctx).tmp.return_type != null && (((Expr_andContext)_localctx).temp.return_type.toString().equals(((Expr_andContext)_localctx).tmp.return_type.toString()) == false) )
							((Expr_andContext)_localctx).return_type =  NoType.getInstance();

						if(((Expr_andContext)_localctx).tmp.return_type != null && (((Expr_andContext)_localctx).temp.return_type.toString().equals("int") == false) && (((Expr_andContext)_localctx).temp.return_type.toString().equals("NoType") == false) ){
							((Expr_andContext)_localctx).return_type =  NoType.getInstance();
							print(String.format("[Line #%s] \"and\" can't be used.", ((Expr_andContext)_localctx).temp.line));
						}
						else{
							((Expr_andContext)_localctx).return_type =  ((Expr_andContext)_localctx).temp.return_type;
						}
						((Expr_andContext)_localctx).line =  ((Expr_andContext)_localctx).temp.line;
						if(((Expr_andContext)_localctx).tmp.return_type != null){

							((Expr_andContext)_localctx).IsLvalue =  0;
							if(((Expr_andContext)_localctx).temp.IsLvalue == 1){ // addr bud
								mips.addrAndCommand();
							}
							if(((Expr_andContext)_localctx).temp.IsLvalue == 0){ // const bud
								mips.constAndCommand();
							}
						}
						else
							((Expr_andContext)_localctx).IsLvalue =  ((Expr_andContext)_localctx).temp.IsLvalue;
					
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

	public static class Expr_and_tmpContext extends ParserRuleContext {
		public Type return_type;
		public int line;
		public Expr_eqContext temp;
		public Expr_and_tmpContext tmp;
		public Expr_eqContext expr_eq() {
			return getRuleContext(Expr_eqContext.class,0);
		}
		public Expr_and_tmpContext expr_and_tmp() {
			return getRuleContext(Expr_and_tmpContext.class,0);
		}
		public Expr_and_tmpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_and_tmp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).enterExpr_and_tmp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).exitExpr_and_tmp(this);
		}
	}

	public final Expr_and_tmpContext expr_and_tmp() throws RecognitionException {
		Expr_and_tmpContext _localctx = new Expr_and_tmpContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_expr_and_tmp);
		try {
			setState(340);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__26:
				enterOuterAlt(_localctx, 1);
				{
				setState(334);
				match(T__26);
				setState(335);
				((Expr_and_tmpContext)_localctx).temp = expr_eq();
				setState(336);
				((Expr_and_tmpContext)_localctx).tmp = expr_and_tmp();

							if( (((Expr_and_tmpContext)_localctx).temp.return_type.toString().equals("int") == false) && (((Expr_and_tmpContext)_localctx).temp.return_type.toString().equals("NoType") == false) ){
								((Expr_and_tmpContext)_localctx).return_type =  NoType.getInstance();
								((Expr_and_tmpContext)_localctx).line =  ((Expr_and_tmpContext)_localctx).temp.line;
								print(String.format("[Line #%s] \"and\" can't be used.", ((Expr_and_tmpContext)_localctx).temp.line));
							}
							else{
								((Expr_and_tmpContext)_localctx).return_type =  ((Expr_and_tmpContext)_localctx).temp.return_type;
								((Expr_and_tmpContext)_localctx).line =  ((Expr_and_tmpContext)_localctx).temp.line;
								if(((Expr_and_tmpContext)_localctx).tmp.return_type == null && ((Expr_and_tmpContext)_localctx).temp.IsLvalue == 1){
									mips.addVariableToStack(((Expr_and_tmpContext)_localctx).temp.return_type);
								}
								if(((Expr_and_tmpContext)_localctx).tmp.return_type != null && ((Expr_and_tmpContext)_localctx).temp.IsLvalue == 1){ // addr bud
									mips.addrAndCommand();
								}
								if(((Expr_and_tmpContext)_localctx).tmp.return_type != null && ((Expr_and_tmpContext)_localctx).temp.IsLvalue == 0){ // const bud
									mips.constAndCommand();
								}
							}
						
				}
				break;
			case T__4:
			case T__7:
			case T__10:
			case T__13:
			case T__25:
			case T__35:
			case NL:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class Expr_eqContext extends ParserRuleContext {
		public Type return_type;
		public int line;
		public int IsLvalue;
		public Expr_cmpContext temp;
		public Expr_eq_tmpContext tmp;
		public Expr_cmpContext expr_cmp() {
			return getRuleContext(Expr_cmpContext.class,0);
		}
		public Expr_eq_tmpContext expr_eq_tmp() {
			return getRuleContext(Expr_eq_tmpContext.class,0);
		}
		public Expr_eqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_eq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).enterExpr_eq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).exitExpr_eq(this);
		}
	}

	public final Expr_eqContext expr_eq() throws RecognitionException {
		Expr_eqContext _localctx = new Expr_eqContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_expr_eq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			((Expr_eqContext)_localctx).temp = expr_cmp();
			setState(343);
			((Expr_eqContext)_localctx).tmp = expr_eq_tmp();

						if(((Expr_eqContext)_localctx).tmp.return_type != null && (((Expr_eqContext)_localctx).temp.return_type.toString().equals(((Expr_eqContext)_localctx).tmp.return_type.toString()) == false) ){
							((Expr_eqContext)_localctx).return_type =  NoType.getInstance();
							print(String.format("[Line #%s] \"==\" or \"<>\" can't be used.", ((Expr_eqContext)_localctx).temp.line));
						}
						else if(((Expr_eqContext)_localctx).tmp.return_type == null){
							((Expr_eqContext)_localctx).return_type =  ((Expr_eqContext)_localctx).temp.return_type;
						}
						else{	// baraye moqayese ebarat e bi mani mitavan an ra 0 va 1 dar nazar gereft
							((Expr_eqContext)_localctx).return_type =  IntType.getInstance();
						}
			 			((Expr_eqContext)_localctx).line =  ((Expr_eqContext)_localctx).temp.line;
			 			if(((Expr_eqContext)_localctx).tmp.return_type != null){
							((Expr_eqContext)_localctx).IsLvalue =  0;
							if(((Expr_eqContext)_localctx).temp.IsLvalue == 1){ // addr bud
								mips.addrEqCommand(((Expr_eqContext)_localctx).tmp.opr, ((Expr_eqContext)_localctx).temp.return_type);
							}
							if(((Expr_eqContext)_localctx).temp.IsLvalue == 0){ // const bud
								mips.constEqCommand(((Expr_eqContext)_localctx).tmp.opr, ((Expr_eqContext)_localctx).temp.return_type);
							}
			 			}
						else
							((Expr_eqContext)_localctx).IsLvalue =  ((Expr_eqContext)_localctx).temp.IsLvalue;
					
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

	public static class Expr_eq_tmpContext extends ParserRuleContext {
		public Type return_type;
		public int line;
		public String opr;
		public Token op;
		public Expr_cmpContext temp;
		public Expr_eq_tmpContext tmp;
		public Expr_cmpContext expr_cmp() {
			return getRuleContext(Expr_cmpContext.class,0);
		}
		public Expr_eq_tmpContext expr_eq_tmp() {
			return getRuleContext(Expr_eq_tmpContext.class,0);
		}
		public Expr_eq_tmpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_eq_tmp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).enterExpr_eq_tmp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).exitExpr_eq_tmp(this);
		}
	}

	public final Expr_eq_tmpContext expr_eq_tmp() throws RecognitionException {
		Expr_eq_tmpContext _localctx = new Expr_eq_tmpContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_expr_eq_tmp);
		int _la;
		try {
			setState(352);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__27:
			case T__28:
				enterOuterAlt(_localctx, 1);
				{
				setState(346);
				((Expr_eq_tmpContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__27 || _la==T__28) ) {
					((Expr_eq_tmpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(347);
				((Expr_eq_tmpContext)_localctx).temp = expr_cmp();
				setState(348);
				((Expr_eq_tmpContext)_localctx).tmp = expr_eq_tmp();

							((Expr_eq_tmpContext)_localctx).opr =  (((Expr_eq_tmpContext)_localctx).op!=null?((Expr_eq_tmpContext)_localctx).op.getText():null);
							if(((Expr_eq_tmpContext)_localctx).tmp.return_type != null){
								((Expr_eq_tmpContext)_localctx).return_type =  NoType.getInstance();
								((Expr_eq_tmpContext)_localctx).line =  ((Expr_eq_tmpContext)_localctx).temp.line;
								print(String.format("[Line #%s] multiple comparison can't be used.", ((Expr_eq_tmpContext)_localctx).temp.line));
							}
							else{
								((Expr_eq_tmpContext)_localctx).return_type =  ((Expr_eq_tmpContext)_localctx).temp.return_type;
								((Expr_eq_tmpContext)_localctx).line =  ((Expr_eq_tmpContext)_localctx).temp.line;
								if(((Expr_eq_tmpContext)_localctx).tmp.return_type == null && ((Expr_eq_tmpContext)_localctx).temp.IsLvalue == 1){
									mips.addVariableToStack(((Expr_eq_tmpContext)_localctx).temp.return_type);
								}
								if(((Expr_eq_tmpContext)_localctx).tmp.return_type != null && ((Expr_eq_tmpContext)_localctx).temp.IsLvalue == 1){ // addr bud
									mips.addrEqCommand((((Expr_eq_tmpContext)_localctx).op!=null?((Expr_eq_tmpContext)_localctx).op.getText():null), ((Expr_eq_tmpContext)_localctx).temp.return_type);
								}
								if(((Expr_eq_tmpContext)_localctx).tmp.return_type != null && ((Expr_eq_tmpContext)_localctx).temp.IsLvalue == 0){ // const bud
									mips.constEqCommand((((Expr_eq_tmpContext)_localctx).op!=null?((Expr_eq_tmpContext)_localctx).op.getText():null), ((Expr_eq_tmpContext)_localctx).temp.return_type);
								}
							}
						
				}
				break;
			case T__4:
			case T__7:
			case T__10:
			case T__13:
			case T__25:
			case T__26:
			case T__35:
			case NL:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class Expr_cmpContext extends ParserRuleContext {
		public Type return_type;
		public int line;
		public int IsLvalue;
		public Expr_addContext temp;
		public Expr_cmp_tmpContext tmp;
		public Expr_addContext expr_add() {
			return getRuleContext(Expr_addContext.class,0);
		}
		public Expr_cmp_tmpContext expr_cmp_tmp() {
			return getRuleContext(Expr_cmp_tmpContext.class,0);
		}
		public Expr_cmpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_cmp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).enterExpr_cmp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).exitExpr_cmp(this);
		}
	}

	public final Expr_cmpContext expr_cmp() throws RecognitionException {
		Expr_cmpContext _localctx = new Expr_cmpContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_expr_cmp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			((Expr_cmpContext)_localctx).temp = expr_add();
			setState(355);
			((Expr_cmpContext)_localctx).tmp = expr_cmp_tmp();

						if(((Expr_cmpContext)_localctx).tmp.return_type != null && (((Expr_cmpContext)_localctx).temp.return_type.toString().equals(((Expr_cmpContext)_localctx).tmp.return_type.toString()) == false) ){
							((Expr_cmpContext)_localctx).return_type =  NoType.getInstance();
							print(String.format("[Line #%s] \"<\" or \">\" can't be used.", ((Expr_cmpContext)_localctx).temp.line));
						}
						else if(((Expr_cmpContext)_localctx).tmp.return_type == null){
							((Expr_cmpContext)_localctx).return_type =  ((Expr_cmpContext)_localctx).temp.return_type;
						}
						else{	// baraye moqayese ebarat e bi mani mitavan an ra 0 va 1 dar nazar gereft
							((Expr_cmpContext)_localctx).return_type =  IntType.getInstance();
						}
			 			((Expr_cmpContext)_localctx).line =  ((Expr_cmpContext)_localctx).temp.line;
			 			if(((Expr_cmpContext)_localctx).tmp.return_type != null){
							((Expr_cmpContext)_localctx).IsLvalue =  0;
							if(((Expr_cmpContext)_localctx).temp.IsLvalue == 1){ // addr bud
								mips.addrCmpCommand(((Expr_cmpContext)_localctx).tmp.opr);
							}
							if(((Expr_cmpContext)_localctx).temp.IsLvalue == 0){ // const bud
								mips.constCmpCommand(((Expr_cmpContext)_localctx).tmp.opr);
							}
			 			}
						else
							((Expr_cmpContext)_localctx).IsLvalue =  ((Expr_cmpContext)_localctx).temp.IsLvalue;
					
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

	public static class Expr_cmp_tmpContext extends ParserRuleContext {
		public Type return_type;
		public int line;
		public String opr;
		public Token op;
		public Expr_addContext temp;
		public Expr_cmp_tmpContext tmp;
		public Expr_addContext expr_add() {
			return getRuleContext(Expr_addContext.class,0);
		}
		public Expr_cmp_tmpContext expr_cmp_tmp() {
			return getRuleContext(Expr_cmp_tmpContext.class,0);
		}
		public Expr_cmp_tmpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_cmp_tmp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).enterExpr_cmp_tmp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).exitExpr_cmp_tmp(this);
		}
	}

	public final Expr_cmp_tmpContext expr_cmp_tmp() throws RecognitionException {
		Expr_cmp_tmpContext _localctx = new Expr_cmp_tmpContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_expr_cmp_tmp);
		int _la;
		try {
			setState(364);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(358);
				((Expr_cmp_tmpContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__1 || _la==T__2) ) {
					((Expr_cmp_tmpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(359);
				((Expr_cmp_tmpContext)_localctx).temp = expr_add();
				setState(360);
				((Expr_cmp_tmpContext)_localctx).tmp = expr_cmp_tmp();

							((Expr_cmp_tmpContext)_localctx).opr =  (((Expr_cmp_tmpContext)_localctx).op!=null?((Expr_cmp_tmpContext)_localctx).op.getText():null);
							if(((Expr_cmp_tmpContext)_localctx).tmp.return_type != null){
								((Expr_cmp_tmpContext)_localctx).return_type =  NoType.getInstance();
								((Expr_cmp_tmpContext)_localctx).line =  ((Expr_cmp_tmpContext)_localctx).temp.line;
								print(String.format("[Line #%s] multiple comparison can't be used.", ((Expr_cmp_tmpContext)_localctx).temp.line));
							}
							else{
								((Expr_cmp_tmpContext)_localctx).return_type =  ((Expr_cmp_tmpContext)_localctx).temp.return_type;
								((Expr_cmp_tmpContext)_localctx).line =  ((Expr_cmp_tmpContext)_localctx).temp.line;
								if(((Expr_cmp_tmpContext)_localctx).tmp.return_type == null && ((Expr_cmp_tmpContext)_localctx).temp.IsLvalue == 1){
									mips.addVariableToStack(((Expr_cmp_tmpContext)_localctx).temp.return_type);
								}
								if(((Expr_cmp_tmpContext)_localctx).tmp.return_type != null && ((Expr_cmp_tmpContext)_localctx).temp.IsLvalue == 1){ // addr bud
									mips.addrCmpCommand((((Expr_cmp_tmpContext)_localctx).op!=null?((Expr_cmp_tmpContext)_localctx).op.getText():null));
								}
								if(((Expr_cmp_tmpContext)_localctx).tmp.return_type != null && ((Expr_cmp_tmpContext)_localctx).temp.IsLvalue == 0){ // const bud
									mips.constCmpCommand((((Expr_cmp_tmpContext)_localctx).op!=null?((Expr_cmp_tmpContext)_localctx).op.getText():null));
								}
							}
						
				}
				break;
			case T__4:
			case T__7:
			case T__10:
			case T__13:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__35:
			case NL:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class Expr_addContext extends ParserRuleContext {
		public Type return_type;
		public int line;
		public int IsLvalue;
		public Expr_multContext temp;
		public Expr_add_tmpContext tmp;
		public Expr_multContext expr_mult() {
			return getRuleContext(Expr_multContext.class,0);
		}
		public Expr_add_tmpContext expr_add_tmp() {
			return getRuleContext(Expr_add_tmpContext.class,0);
		}
		public Expr_addContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_add; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).enterExpr_add(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).exitExpr_add(this);
		}
	}

	public final Expr_addContext expr_add() throws RecognitionException {
		Expr_addContext _localctx = new Expr_addContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_expr_add);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
			((Expr_addContext)_localctx).temp = expr_mult();
			setState(367);
			((Expr_addContext)_localctx).tmp = expr_add_tmp();

						if(((Expr_addContext)_localctx).tmp.return_type != null && (((Expr_addContext)_localctx).temp.return_type.toString().equals(((Expr_addContext)_localctx).tmp.return_type.toString()) == false) )
							((Expr_addContext)_localctx).return_type =  NoType.getInstance();

						if(((Expr_addContext)_localctx).tmp.return_type != null && (((Expr_addContext)_localctx).temp.return_type.toString().equals("int") == false) && (((Expr_addContext)_localctx).temp.return_type.toString().equals("NoType") == false) ){
							((Expr_addContext)_localctx).return_type =  NoType.getInstance();
							print(String.format("[Line #%s] \"+\" or \"-\" can't be used.", ((Expr_addContext)_localctx).temp.line));
						}
						else{
							((Expr_addContext)_localctx).return_type =  ((Expr_addContext)_localctx).temp.return_type;
						}
						((Expr_addContext)_localctx).line =  ((Expr_addContext)_localctx).temp.line;
						if(((Expr_addContext)_localctx).tmp.return_type != null){
							((Expr_addContext)_localctx).IsLvalue =  0;
							if(((Expr_addContext)_localctx).temp.IsLvalue == 1){ // addr bud
								mips.addrAddCommand(((Expr_addContext)_localctx).tmp.opr);
							}
							if(((Expr_addContext)_localctx).temp.IsLvalue == 0){ // const bud
								mips.constAddCommand(((Expr_addContext)_localctx).tmp.opr);
							}
						}
						else
							((Expr_addContext)_localctx).IsLvalue =  ((Expr_addContext)_localctx).temp.IsLvalue;
					
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

	public static class Expr_add_tmpContext extends ParserRuleContext {
		public Type return_type;
		public int line;
		public String opr;
		public Token op;
		public Expr_multContext temp;
		public Expr_add_tmpContext tmp;
		public Expr_multContext expr_mult() {
			return getRuleContext(Expr_multContext.class,0);
		}
		public Expr_add_tmpContext expr_add_tmp() {
			return getRuleContext(Expr_add_tmpContext.class,0);
		}
		public Expr_add_tmpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_add_tmp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).enterExpr_add_tmp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).exitExpr_add_tmp(this);
		}
	}

	public final Expr_add_tmpContext expr_add_tmp() throws RecognitionException {
		Expr_add_tmpContext _localctx = new Expr_add_tmpContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_expr_add_tmp);
		int _la;
		try {
			setState(376);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__29:
			case T__30:
				enterOuterAlt(_localctx, 1);
				{
				setState(370);
				((Expr_add_tmpContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__29 || _la==T__30) ) {
					((Expr_add_tmpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(371);
				((Expr_add_tmpContext)_localctx).temp = expr_mult();
				setState(372);
				((Expr_add_tmpContext)_localctx).tmp = expr_add_tmp();

							((Expr_add_tmpContext)_localctx).opr =  (((Expr_add_tmpContext)_localctx).op!=null?((Expr_add_tmpContext)_localctx).op.getText():null);
							if((((Expr_add_tmpContext)_localctx).temp.return_type.toString().equals("int") == false) && (((Expr_add_tmpContext)_localctx).temp.return_type.toString().equals("NoType") == false) ){
								((Expr_add_tmpContext)_localctx).return_type =  NoType.getInstance();
								((Expr_add_tmpContext)_localctx).line =  ((Expr_add_tmpContext)_localctx).temp.line;
								print(String.format("[Line #%s] \"+\" or \"-\" can't be used.", ((Expr_add_tmpContext)_localctx).temp.line));
							}
							else{
								((Expr_add_tmpContext)_localctx).return_type =  ((Expr_add_tmpContext)_localctx).temp.return_type;
								((Expr_add_tmpContext)_localctx).line =  ((Expr_add_tmpContext)_localctx).temp.line;
								if(((Expr_add_tmpContext)_localctx).tmp.return_type == null && ((Expr_add_tmpContext)_localctx).temp.IsLvalue == 1){
									mips.addVariableToStack(((Expr_add_tmpContext)_localctx).temp.return_type);
								}
								if(((Expr_add_tmpContext)_localctx).tmp.return_type != null && ((Expr_add_tmpContext)_localctx).temp.IsLvalue == 1){ // addr bud
									mips.addrAddCommand((((Expr_add_tmpContext)_localctx).op!=null?((Expr_add_tmpContext)_localctx).op.getText():null));
								}
								if(((Expr_add_tmpContext)_localctx).tmp.return_type != null && ((Expr_add_tmpContext)_localctx).temp.IsLvalue == 0){ // const bud
									mips.constAddCommand((((Expr_add_tmpContext)_localctx).op!=null?((Expr_add_tmpContext)_localctx).op.getText():null));
								}
							}
						
				}
				break;
			case T__1:
			case T__2:
			case T__4:
			case T__7:
			case T__10:
			case T__13:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__35:
			case NL:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class Expr_multContext extends ParserRuleContext {
		public Type return_type;
		public int line;
		public int IsLvalue;
		public Expr_unContext temp;
		public Expr_mult_tmpContext tmp;
		public Expr_unContext expr_un() {
			return getRuleContext(Expr_unContext.class,0);
		}
		public Expr_mult_tmpContext expr_mult_tmp() {
			return getRuleContext(Expr_mult_tmpContext.class,0);
		}
		public Expr_multContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_mult; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).enterExpr_mult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).exitExpr_mult(this);
		}
	}

	public final Expr_multContext expr_mult() throws RecognitionException {
		Expr_multContext _localctx = new Expr_multContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_expr_mult);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			((Expr_multContext)_localctx).temp = expr_un();
			setState(379);
			((Expr_multContext)_localctx).tmp = expr_mult_tmp();

						if(((Expr_multContext)_localctx).tmp.return_type != null && (((Expr_multContext)_localctx).temp.return_type.toString().equals(((Expr_multContext)_localctx).tmp.return_type.toString()) == false) )
							((Expr_multContext)_localctx).return_type =  NoType.getInstance();
						if(((Expr_multContext)_localctx).tmp.return_type != null && (((Expr_multContext)_localctx).temp.return_type.toString().equals("int") == false) && (((Expr_multContext)_localctx).temp.return_type.toString().equals("NoType") == false) ){
							((Expr_multContext)_localctx).return_type =  NoType.getInstance();
							print(String.format("[Line #%s] \"*\" or \"/\" can't be used.", ((Expr_multContext)_localctx).temp.line));
						}
						else{
							((Expr_multContext)_localctx).return_type =  ((Expr_multContext)_localctx).temp.return_type;
						}
						((Expr_multContext)_localctx).line =  ((Expr_multContext)_localctx).temp.line;
						if(((Expr_multContext)_localctx).tmp.return_type != null){
							((Expr_multContext)_localctx).IsLvalue =  0;
							if(((Expr_multContext)_localctx).temp.IsLvalue == 1){ // addr bud
								mips.addrMultCommand(((Expr_multContext)_localctx).tmp.opr);
							}
							if(((Expr_multContext)_localctx).temp.IsLvalue == 0){ // const bud
								mips.constMultCommand(((Expr_multContext)_localctx).tmp.opr);
							}
						}
						else
							((Expr_multContext)_localctx).IsLvalue =  ((Expr_multContext)_localctx).temp.IsLvalue;

					
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

	public static class Expr_mult_tmpContext extends ParserRuleContext {
		public Type return_type;
		public int line;
		public String opr;
		public Token op;
		public Expr_unContext temp;
		public Expr_mult_tmpContext tmp;
		public Expr_unContext expr_un() {
			return getRuleContext(Expr_unContext.class,0);
		}
		public Expr_mult_tmpContext expr_mult_tmp() {
			return getRuleContext(Expr_mult_tmpContext.class,0);
		}
		public Expr_mult_tmpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_mult_tmp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).enterExpr_mult_tmp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).exitExpr_mult_tmp(this);
		}
	}

	public final Expr_mult_tmpContext expr_mult_tmp() throws RecognitionException {
		Expr_mult_tmpContext _localctx = new Expr_mult_tmpContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_expr_mult_tmp);
		int _la;
		try {
			setState(388);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__31:
			case T__32:
				enterOuterAlt(_localctx, 1);
				{
				setState(382);
				((Expr_mult_tmpContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__31 || _la==T__32) ) {
					((Expr_mult_tmpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(383);
				((Expr_mult_tmpContext)_localctx).temp = expr_un();
				setState(384);
				((Expr_mult_tmpContext)_localctx).tmp = expr_mult_tmp();

							((Expr_mult_tmpContext)_localctx).opr =  (((Expr_mult_tmpContext)_localctx).op!=null?((Expr_mult_tmpContext)_localctx).op.getText():null); 
							if((((Expr_mult_tmpContext)_localctx).temp.return_type.toString().equals("int") == false) && (((Expr_mult_tmpContext)_localctx).temp.return_type.toString().equals("NoType") == false) ){
								((Expr_mult_tmpContext)_localctx).return_type =  NoType.getInstance();
								((Expr_mult_tmpContext)_localctx).line =  ((Expr_mult_tmpContext)_localctx).temp.line;
								print(String.format("[Line #%s] \"*\" or \"/\" can't be used.", ((Expr_mult_tmpContext)_localctx).temp.line));
							}
							else{
								((Expr_mult_tmpContext)_localctx).return_type =  ((Expr_mult_tmpContext)_localctx).temp.return_type;
								((Expr_mult_tmpContext)_localctx).line =  ((Expr_mult_tmpContext)_localctx).temp.line;
								if(((Expr_mult_tmpContext)_localctx).tmp.return_type == null && ((Expr_mult_tmpContext)_localctx).temp.IsLvalue == 1){
									mips.addVariableToStack(((Expr_mult_tmpContext)_localctx).temp.return_type);
								}
								if(((Expr_mult_tmpContext)_localctx).tmp.return_type != null && ((Expr_mult_tmpContext)_localctx).temp.IsLvalue == 1){ // addr bud
									mips.addrMultCommand((((Expr_mult_tmpContext)_localctx).op!=null?((Expr_mult_tmpContext)_localctx).op.getText():null));
								}
								if(((Expr_mult_tmpContext)_localctx).tmp.return_type != null && ((Expr_mult_tmpContext)_localctx).temp.IsLvalue == 0){ // const bud
									mips.constMultCommand((((Expr_mult_tmpContext)_localctx).op!=null?((Expr_mult_tmpContext)_localctx).op.getText():null));
								}
							}

						
				}
				break;
			case T__1:
			case T__2:
			case T__4:
			case T__7:
			case T__10:
			case T__13:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__29:
			case T__30:
			case T__35:
			case NL:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class Expr_unContext extends ParserRuleContext {
		public Type return_type;
		public int line;
		public int IsLvalue;
		public Token op;
		public Expr_unContext tmp;
		public Expr_memContext temp;
		public Expr_unContext expr_un() {
			return getRuleContext(Expr_unContext.class,0);
		}
		public Expr_memContext expr_mem() {
			return getRuleContext(Expr_memContext.class,0);
		}
		public Expr_unContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_un; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).enterExpr_un(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).exitExpr_un(this);
		}
	}

	public final Expr_unContext expr_un() throws RecognitionException {
		Expr_unContext _localctx = new Expr_unContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_expr_un);
		int _la;
		try {
			setState(397);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
			case T__33:
				enterOuterAlt(_localctx, 1);
				{
				setState(390);
				((Expr_unContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__30 || _la==T__33) ) {
					((Expr_unContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(391);
				((Expr_unContext)_localctx).tmp = expr_un();

							if((((Expr_unContext)_localctx).tmp.return_type.toString().equals("int") == false) && (((Expr_unContext)_localctx).tmp.return_type.toString().equals("NoType") == false) ){
								((Expr_unContext)_localctx).return_type =  NoType.getInstance();
								((Expr_unContext)_localctx).line =  ((Expr_unContext)_localctx).tmp.line;
								print(String.format("[Line #%s] \"not\" or \"-\" can't be used.", ((Expr_unContext)_localctx).tmp.line));
							}
							else{
								((Expr_unContext)_localctx).return_type =  ((Expr_unContext)_localctx).tmp.return_type;
								((Expr_unContext)_localctx).line =  ((Expr_unContext)_localctx).tmp.line;
							}
							((Expr_unContext)_localctx).IsLvalue =  0;	
							if(((Expr_unContext)_localctx).tmp.IsLvalue == 1){
								mips.addVariableToStack(((Expr_unContext)_localctx).tmp.return_type);
							}
							mips.notVarCommand((((Expr_unContext)_localctx).op!=null?((Expr_unContext)_localctx).op.getText():null));
							
						
				}
				break;
			case T__6:
			case T__34:
			case T__36:
			case CONST_NUM:
			case CONST_CHAR:
			case CONST_STR:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(394);
				((Expr_unContext)_localctx).temp = expr_mem();

						((Expr_unContext)_localctx).return_type =  ((Expr_unContext)_localctx).temp.return_type;
						((Expr_unContext)_localctx).line =  ((Expr_unContext)_localctx).temp.line;
						((Expr_unContext)_localctx).IsLvalue =  ((Expr_unContext)_localctx).temp.IsLvalue;
						
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

	public static class Expr_memContext extends ParserRuleContext {
		public Type return_type;
		public int line;
		public int IsLvalue;
		public Expr_otherContext temp;
		public Expr_mem_tmpContext mem_cnt;
		public Expr_otherContext expr_other() {
			return getRuleContext(Expr_otherContext.class,0);
		}
		public Expr_mem_tmpContext expr_mem_tmp() {
			return getRuleContext(Expr_mem_tmpContext.class,0);
		}
		public Expr_memContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_mem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).enterExpr_mem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).exitExpr_mem(this);
		}
	}

	public final Expr_memContext expr_mem() throws RecognitionException {
		Expr_memContext _localctx = new Expr_memContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_expr_mem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(399);
			((Expr_memContext)_localctx).temp = expr_other();
			setState(400);
			((Expr_memContext)_localctx).mem_cnt = expr_mem_tmp();


						if(((Expr_memContext)_localctx).mem_cnt.cnt == 0){
							((Expr_memContext)_localctx).return_type =  ((Expr_memContext)_localctx).temp.return_type;

						}
						else if( ((Expr_memContext)_localctx).temp.return_type instanceof ArrType ){
							ArrType tmp = (ArrType)((Expr_memContext)_localctx).temp.return_type;
							if(((Expr_memContext)_localctx).mem_cnt.cnt < tmp.dimension.size()){
								((Expr_memContext)_localctx).return_type =  ArrType.getInstance(tmp.base, new ArrayList(tmp.dimension.subList(((Expr_memContext)_localctx).mem_cnt.cnt, tmp.dimension.size())));
								mips.addArrayAddrToStack(((Expr_memContext)_localctx).mem_cnt.cnt, tmp);
							}

							if(((Expr_memContext)_localctx).mem_cnt.cnt == tmp.dimension.size()){
								((Expr_memContext)_localctx).return_type =  tmp.base;
								mips.addArrayAddrToStack(((Expr_memContext)_localctx).mem_cnt.cnt, tmp);
							}

							if(((Expr_memContext)_localctx).mem_cnt.cnt > tmp.dimension.size()){
								((Expr_memContext)_localctx).return_type =  NoType.getInstance();
								print(String.format("[Line #%s] dimensions of array variable doesn't match.", ((Expr_memContext)_localctx).temp.line));
							}
						}
						else if(((Expr_memContext)_localctx).temp.IsLvalue == 1){
							((Expr_memContext)_localctx).return_type =  NoType.getInstance();
							print(String.format("[Line #%s] variable isn't array.", ((Expr_memContext)_localctx).temp.line));
						}
						else{
							((Expr_memContext)_localctx).return_type =  NoType.getInstance();
							print(String.format("[Line #%s] Lvalue is not correct.", ((Expr_memContext)_localctx).temp.line));
						}

						((Expr_memContext)_localctx).line =  ((Expr_memContext)_localctx).temp.line;
						((Expr_memContext)_localctx).IsLvalue =  ((Expr_memContext)_localctx).temp.IsLvalue;
					
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

	public static class Expr_mem_tmpContext extends ParserRuleContext {
		public int cnt;
		public ExprContext temp;
		public Expr_mem_tmpContext tmp;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_mem_tmpContext expr_mem_tmp() {
			return getRuleContext(Expr_mem_tmpContext.class,0);
		}
		public Expr_mem_tmpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_mem_tmp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).enterExpr_mem_tmp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).exitExpr_mem_tmp(this);
		}
	}

	public final Expr_mem_tmpContext expr_mem_tmp() throws RecognitionException {
		Expr_mem_tmpContext _localctx = new Expr_mem_tmpContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_expr_mem_tmp);
		try {
			setState(410);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(403);
				match(T__9);
				setState(404);
				((Expr_mem_tmpContext)_localctx).temp = expr();
				setState(405);
				match(T__10);
				setState(406);
				((Expr_mem_tmpContext)_localctx).tmp = expr_mem_tmp();

							if(((Expr_mem_tmpContext)_localctx).temp.IsLvalue == 1) 
								mips.addVariableToStack(((Expr_mem_tmpContext)_localctx).temp.return_type);
							((Expr_mem_tmpContext)_localctx).cnt =  ((Expr_mem_tmpContext)_localctx).tmp.cnt + 1;
							if(((Expr_mem_tmpContext)_localctx).temp.return_type.toString().equals("int") == false){
								print(String.format("[Line #%s] invalid array index.", ((Expr_mem_tmpContext)_localctx).temp.line));
							}
						
				}
				break;
			case T__1:
			case T__2:
			case T__4:
			case T__7:
			case T__10:
			case T__13:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__29:
			case T__30:
			case T__31:
			case T__32:
			case T__35:
			case NL:
				enterOuterAlt(_localctx, 2);
				{
				 ((Expr_mem_tmpContext)_localctx).cnt =  0; 
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

	public static class Expr_otherContext extends ParserRuleContext {
		public Type return_type;
		public int line;
		public int IsLvalue;
		public Token temp;
		public Token id;
		public ExprContext Temp;
		public ExprContext tmp;
		public TerminalNode CONST_NUM() { return getToken(AtalkPass2Parser.CONST_NUM, 0); }
		public TerminalNode CONST_CHAR() { return getToken(AtalkPass2Parser.CONST_CHAR, 0); }
		public TerminalNode CONST_STR() { return getToken(AtalkPass2Parser.CONST_STR, 0); }
		public TerminalNode ID() { return getToken(AtalkPass2Parser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Expr_otherContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_other; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).enterExpr_other(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass2Listener ) ((AtalkPass2Listener)listener).exitExpr_other(this);
		}
	}

	public final Expr_otherContext expr_other() throws RecognitionException {
		Expr_otherContext _localctx = new Expr_otherContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_expr_other);
		int _la;
		try {
			setState(446);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONST_NUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(412);
				((Expr_otherContext)_localctx).temp = match(CONST_NUM);

							((Expr_otherContext)_localctx).return_type =  IntType.getInstance();
							((Expr_otherContext)_localctx).line =  ((Expr_otherContext)_localctx).temp.getLine();
							((Expr_otherContext)_localctx).IsLvalue =  0;
							mips.addConstIntToStack( Integer.parseInt((((Expr_otherContext)_localctx).temp!=null?((Expr_otherContext)_localctx).temp.getText():null)));
						
				}
				break;
			case CONST_CHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(414);
				((Expr_otherContext)_localctx).temp = match(CONST_CHAR);

							((Expr_otherContext)_localctx).return_type =  CharType.getInstance();
							((Expr_otherContext)_localctx).line =  ((Expr_otherContext)_localctx).temp.getLine();
							((Expr_otherContext)_localctx).IsLvalue =  0;
							mips.addConstCharToStack( (int)(((Expr_otherContext)_localctx).temp!=null?((Expr_otherContext)_localctx).temp.getText():null).charAt(1) );
						
				}
				break;
			case CONST_STR:
				enterOuterAlt(_localctx, 3);
				{
				setState(416);
				((Expr_otherContext)_localctx).temp = match(CONST_STR);

							ArrayList arg = new ArrayList();
							arg.add((((Expr_otherContext)_localctx).temp!=null?((Expr_otherContext)_localctx).temp.getText():null).length() - 2);
							((Expr_otherContext)_localctx).return_type =  ArrType.getInstance(CharType.getInstance(), arg);
							((Expr_otherContext)_localctx).line =  ((Expr_otherContext)_localctx).temp.getLine();
							((Expr_otherContext)_localctx).IsLvalue =  0;
							mips.addConstStrToStack( (((Expr_otherContext)_localctx).temp!=null?((Expr_otherContext)_localctx).temp.getText():null) );
						
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 4);
				{
				setState(418);
				((Expr_otherContext)_localctx).id = match(ID);


							SymbolTableItem item = SymbolTable.top.get((((Expr_otherContext)_localctx).id!=null?((Expr_otherContext)_localctx).id.getText():null));
				            if(item == null) {
				                print(String.format("[Line #%s] variable \"%s\" is not defined.", ((Expr_otherContext)_localctx).id.getLine(), (((Expr_otherContext)_localctx).id!=null?((Expr_otherContext)_localctx).id.getText():null)));
				                putNoTypeVar((((Expr_otherContext)_localctx).id!=null?((Expr_otherContext)_localctx).id.getText():null));
				                ((Expr_otherContext)_localctx).return_type =  NoType.getInstance();
				                ((Expr_otherContext)_localctx).line =  ((Expr_otherContext)_localctx).id.getLine();
				            }
				            else if(item instanceof SymbolTableVariableItemBase) {
				            	SymbolTableVariableItemBase castedItem = (SymbolTableVariableItemBase) item;
				            	((Expr_otherContext)_localctx).line =  ((Expr_otherContext)_localctx).id.getLine();
				            	((Expr_otherContext)_localctx).return_type =  castedItem.getVariable().getType();
				            	if(castedItem.getBaseRegister() == Register.GP)//	Variable is global
				            		mips.addGlobalVariableAddrToStack(castedItem.getOffset());
				            	else if(castedItem.getBaseRegister() == Register.SP){
				            		mips.addLocalVariableAddrToStack(castedItem.getOffset());
				            	}
				            }
				           	else{
				           		print(String.format("[Line #%s] variable \"%s\" is not defined.", ((Expr_otherContext)_localctx).id.getLine(), (((Expr_otherContext)_localctx).id!=null?((Expr_otherContext)_localctx).id.getText():null)));
				                putNoTypeVar((((Expr_otherContext)_localctx).id!=null?((Expr_otherContext)_localctx).id.getText():null));
				                ((Expr_otherContext)_localctx).line =  ((Expr_otherContext)_localctx).id.getLine();
				   				((Expr_otherContext)_localctx).return_type =  NoType.getInstance();
				           	}
				           	((Expr_otherContext)_localctx).IsLvalue =  1;

						
				}
				break;
			case T__34:
				enterOuterAlt(_localctx, 5);
				{
				setState(420);
				match(T__34);

								IsElementArrNotProper = 0;

								int ElementCounter = 1;
							
				setState(422);
				((Expr_otherContext)_localctx).Temp = expr();

								if(((Expr_otherContext)_localctx).Temp.IsLvalue == 1) 
									mips.addVariableToStack(((Expr_otherContext)_localctx).Temp.return_type);

						    
				setState(430);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(424);
					match(T__4);
					setState(425);
					((Expr_otherContext)_localctx).tmp = expr();

									if(((Expr_otherContext)_localctx).Temp.IsLvalue == 1) 
										mips.addVariableToStack(((Expr_otherContext)_localctx).Temp.return_type);
									ElementCounter += 1;
									if(((Expr_otherContext)_localctx).Temp.return_type.toString().equals(((Expr_otherContext)_localctx).tmp.return_type.toString()) == false) {
										((Expr_otherContext)_localctx).return_type =  NoType.getInstance();
										((Expr_otherContext)_localctx).line =  ((Expr_otherContext)_localctx).Temp.line;
										IsElementArrNotProper = 1;
										print(String.format("[Line #%s] elements are not from the same type.", ((Expr_otherContext)_localctx).Temp.line));
									}
								
					}
					}
					setState(432);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(433);
				match(T__35);


						mips.arrange(((Expr_otherContext)_localctx).Temp.return_type, ElementCounter);

						if(IsElementArrNotProper == 0){
							if(((Expr_otherContext)_localctx).Temp.return_type instanceof ArrType){
								ArrayList arg = new ArrayList();
								arg.add(ElementCounter);
								ArrType G = (ArrType)((Expr_otherContext)_localctx).Temp.return_type;
								arg.addAll(G.dimension);
								((Expr_otherContext)_localctx).return_type =  ArrType.getInstance(G.base, arg);
								((Expr_otherContext)_localctx).line =  ((Expr_otherContext)_localctx).Temp.line;
							}
							else{
								ArrayList arg = new ArrayList();
								arg.add(ElementCounter);
								((Expr_otherContext)_localctx).return_type =  ArrType.getInstance(((Expr_otherContext)_localctx).Temp.return_type, arg);
								((Expr_otherContext)_localctx).line =  ((Expr_otherContext)_localctx).Temp.line;
							}
						}
						((Expr_otherContext)_localctx).IsLvalue =  0;
					
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 6);
				{
				setState(436);
				match(T__36);
				setState(437);
				match(T__6);
				setState(438);
				((Expr_otherContext)_localctx).temp = match(CONST_NUM);
				setState(439);
				match(T__7);

							ArrayList arg = new ArrayList();
							arg.add(Integer.parseInt((((Expr_otherContext)_localctx).temp!=null?((Expr_otherContext)_localctx).temp.getText():null)));
							((Expr_otherContext)_localctx).return_type =  ArrType.getInstance(CharType.getInstance(), arg);
							((Expr_otherContext)_localctx).line =  ((Expr_otherContext)_localctx).temp.getLine();
							((Expr_otherContext)_localctx).IsLvalue =  0;
							mips.readStr(Integer.parseInt((((Expr_otherContext)_localctx).temp!=null?((Expr_otherContext)_localctx).temp.getText():null)));

						
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 7);
				{
				setState(441);
				match(T__6);
				setState(442);
				((Expr_otherContext)_localctx).tmp = expr();
				setState(443);
				match(T__7);

							if(((Expr_otherContext)_localctx).tmp.IsLvalue == 1) 
								mips.addVariableToStack(((Expr_otherContext)_localctx).tmp.return_type);
							((Expr_otherContext)_localctx).return_type =  ((Expr_otherContext)_localctx).tmp.return_type;
							((Expr_otherContext)_localctx).line =  ((Expr_otherContext)_localctx).tmp.line;
							((Expr_otherContext)_localctx).IsLvalue =  0;
						
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u01c3\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\2\7\2J\n\2\f\2\16\2M\13\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3[\n\3\f\3\16\3^\13\3\3\3\3\3\3\3\3"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\4\7\4j\n\4\f\4\16\4m\13\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5}\n\5\f\5\16\5\u0080\13\5\5\5"+
		"\u0082\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\7\6\u0090\n"+
		"\6\f\6\16\6\u0093\13\6\3\6\3\6\3\6\3\6\7\6\u0099\n\6\f\6\16\6\u009c\13"+
		"\6\5\6\u009e\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\7\b\u00aa\n\b"+
		"\f\b\16\b\u00ad\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00b8\n\t"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00c2\n\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\5\n\u00cc\n\n\7\n\u00ce\n\n\f\n\16\n\u00d1\13\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00dc\n\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\7\13\u00e8\n\13\f\13\16\13\u00eb\13\13\5\13"+
		"\u00ed\n\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u010a\n\r\f"+
		"\r\16\r\u010d\13\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0116\n\r\3\r\3\r\3"+
		"\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u013f\n\23\3\24\3\24\3\24"+
		"\3\24\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u014b\n\25\3\26\3\26\3\26\3\26"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u0157\n\27\3\30\3\30\3\30\3\30\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\5\31\u0163\n\31\3\32\3\32\3\32\3\32\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\5\33\u016f\n\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\5\35\u017b\n\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\5\37\u0187\n\37\3 \3 \3 \3 \3 \3 \3 \5 \u0190\n \3!\3!\3!\3"+
		"!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u019d\n\"\3#\3#\3#\3#\3#\3#\3#\3#\3"+
		"#\3#\3#\3#\3#\3#\3#\3#\7#\u01af\n#\f#\16#\u01b2\13#\3#\3#\3#\3#\3#\3#"+
		"\3#\3#\3#\3#\3#\3#\3#\5#\u01c1\n#\3#\2\2$\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\60\62\64\668:<>@BD\2\b\3\3++\3\2\36\37\3\2\4\5\3\2"+
		" !\3\2\"#\4\2!!$$\2\u01ce\2F\3\2\2\2\4P\3\2\2\2\6c\3\2\2\2\bp\3\2\2\2"+
		"\n\u009d\3\2\2\2\f\u009f\3\2\2\2\16\u00ab\3\2\2\2\20\u00b7\3\2\2\2\22"+
		"\u00b9\3\2\2\2\24\u00d4\3\2\2\2\26\u00f2\3\2\2\2\30\u00f9\3\2\2\2\32\u011b"+
		"\3\2\2\2\34\u0128\3\2\2\2\36\u012c\3\2\2\2 \u0130\3\2\2\2\"\u0133\3\2"+
		"\2\2$\u013e\3\2\2\2&\u0140\3\2\2\2(\u014a\3\2\2\2*\u014c\3\2\2\2,\u0156"+
		"\3\2\2\2.\u0158\3\2\2\2\60\u0162\3\2\2\2\62\u0164\3\2\2\2\64\u016e\3\2"+
		"\2\2\66\u0170\3\2\2\28\u017a\3\2\2\2:\u017c\3\2\2\2<\u0186\3\2\2\2>\u018f"+
		"\3\2\2\2@\u0191\3\2\2\2B\u019c\3\2\2\2D\u01c0\3\2\2\2FK\b\2\1\2GJ\5\4"+
		"\3\2HJ\7+\2\2IG\3\2\2\2IH\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2LN\3\2"+
		"\2\2MK\3\2\2\2NO\b\2\1\2O\3\3\2\2\2PQ\7\3\2\2QR\7,\2\2RS\7\4\2\2ST\7("+
		"\2\2TU\7\5\2\2UV\7+\2\2V\\\b\3\1\2W[\5\6\4\2X[\5\b\5\2Y[\7+\2\2ZW\3\2"+
		"\2\2ZX\3\2\2\2ZY\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]_\3\2\2\2^\\"+
		"\3\2\2\2_`\7\6\2\2`a\t\2\2\2ab\b\3\1\2b\5\3\2\2\2cd\5\n\6\2de\7,\2\2e"+
		"k\b\4\1\2fg\7\7\2\2gh\7,\2\2hj\b\4\1\2if\3\2\2\2jm\3\2\2\2ki\3\2\2\2k"+
		"l\3\2\2\2ln\3\2\2\2mk\3\2\2\2no\7+\2\2o\7\3\2\2\2pq\b\5\1\2qr\7\b\2\2"+
		"rs\7,\2\2s\u0081\7\t\2\2tu\5\n\6\2uv\7,\2\2v~\b\5\1\2wx\7\7\2\2xy\5\n"+
		"\6\2yz\7,\2\2z{\b\5\1\2{}\3\2\2\2|w\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~"+
		"\177\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0081t\3\2\2\2\u0081\u0082"+
		"\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\7\n\2\2\u0084\u0085\7+\2\2\u0085"+
		"\u0086\b\5\1\2\u0086\u0087\5\16\b\2\u0087\u0088\7\6\2\2\u0088\u0089\7"+
		"+\2\2\u0089\u008a\b\5\1\2\u008a\t\3\2\2\2\u008b\u0091\7\13\2\2\u008c\u008d"+
		"\7\f\2\2\u008d\u008e\7(\2\2\u008e\u0090\7\r\2\2\u008f\u008c\3\2\2\2\u0090"+
		"\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u009e\3\2"+
		"\2\2\u0093\u0091\3\2\2\2\u0094\u009a\7\16\2\2\u0095\u0096\7\f\2\2\u0096"+
		"\u0097\7(\2\2\u0097\u0099\7\r\2\2\u0098\u0095\3\2\2\2\u0099\u009c\3\2"+
		"\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009e\3\2\2\2\u009c"+
		"\u009a\3\2\2\2\u009d\u008b\3\2\2\2\u009d\u0094\3\2\2\2\u009e\13\3\2\2"+
		"\2\u009f\u00a0\b\7\1\2\u00a0\u00a1\7\17\2\2\u00a1\u00a2\7+\2\2\u00a2\u00a3"+
		"\5\16\b\2\u00a3\u00a4\7\6\2\2\u00a4\u00a5\7+\2\2\u00a5\u00a6\b\7\1\2\u00a6"+
		"\r\3\2\2\2\u00a7\u00aa\5\20\t\2\u00a8\u00aa\7+\2\2\u00a9\u00a7\3\2\2\2"+
		"\u00a9\u00a8\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac"+
		"\3\2\2\2\u00ac\17\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00b8\5\22\n\2\u00af"+
		"\u00b8\5 \21\2\u00b0\u00b8\5\32\16\2\u00b1\u00b8\5\30\r\2\u00b2\u00b8"+
		"\5\34\17\2\u00b3\u00b8\5\36\20\2\u00b4\u00b8\5\24\13\2\u00b5\u00b8\5\26"+
		"\f\2\u00b6\u00b8\5\f\7\2\u00b7\u00ae\3\2\2\2\u00b7\u00af\3\2\2\2\u00b7"+
		"\u00b0\3\2\2\2\u00b7\u00b1\3\2\2\2\u00b7\u00b2\3\2\2\2\u00b7\u00b3\3\2"+
		"\2\2\u00b7\u00b4\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b6\3\2\2\2\u00b8"+
		"\21\3\2\2\2\u00b9\u00ba\5\n\6\2\u00ba\u00bb\7,\2\2\u00bb\u00c1\b\n\1\2"+
		"\u00bc\u00bd\7\20\2\2\u00bd\u00be\b\n\1\2\u00be\u00bf\5\"\22\2\u00bf\u00c0"+
		"\b\n\1\2\u00c0\u00c2\3\2\2\2\u00c1\u00bc\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2"+
		"\u00cf\3\2\2\2\u00c3\u00c4\7\7\2\2\u00c4\u00c5\7,\2\2\u00c5\u00cb\b\n"+
		"\1\2\u00c6\u00c7\7\20\2\2\u00c7\u00c8\b\n\1\2\u00c8\u00c9\5\"\22\2\u00c9"+
		"\u00ca\b\n\1\2\u00ca\u00cc\3\2\2\2\u00cb\u00c6\3\2\2\2\u00cb\u00cc\3\2"+
		"\2\2\u00cc\u00ce\3\2\2\2\u00cd\u00c3\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf"+
		"\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d2\3\2\2\2\u00d1\u00cf\3\2"+
		"\2\2\u00d2\u00d3\7+\2\2\u00d3\23\3\2\2\2\u00d4\u00db\b\13\1\2\u00d5\u00d6"+
		"\7,\2\2\u00d6\u00dc\b\13\1\2\u00d7\u00d8\7\21\2\2\u00d8\u00dc\b\13\1\2"+
		"\u00d9\u00da\7\22\2\2\u00da\u00dc\b\13\1\2\u00db\u00d5\3\2\2\2\u00db\u00d7"+
		"\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00de\b\13\1\2"+
		"\u00de\u00df\7\23\2\2\u00df\u00e0\7,\2\2\u00e0\u00ec\7\t\2\2\u00e1\u00e2"+
		"\5\"\22\2\u00e2\u00e9\b\13\1\2\u00e3\u00e4\7\7\2\2\u00e4\u00e5\5\"\22"+
		"\2\u00e5\u00e6\b\13\1\2\u00e6\u00e8\3\2\2\2\u00e7\u00e3\3\2\2\2\u00e8"+
		"\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00ed\3\2"+
		"\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00e1\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed"+
		"\u00ee\3\2\2\2\u00ee\u00ef\7\n\2\2\u00ef\u00f0\7+\2\2\u00f0\u00f1\b\13"+
		"\1\2\u00f1\25\3\2\2\2\u00f2\u00f3\7\24\2\2\u00f3\u00f4\7\t\2\2\u00f4\u00f5"+
		"\5\"\22\2\u00f5\u00f6\b\f\1\2\u00f6\u00f7\7\n\2\2\u00f7\u00f8\7+\2\2\u00f8"+
		"\27\3\2\2\2\u00f9\u00fa\b\r\1\2\u00fa\u00fb\7\25\2\2\u00fb\u00fc\5\"\22"+
		"\2\u00fc\u00fd\b\r\1\2\u00fd\u00fe\7+\2\2\u00fe\u00ff\5\16\b\2\u00ff\u010b"+
		"\b\r\1\2\u0100\u0101\b\r\1\2\u0101\u0102\7\26\2\2\u0102\u0103\b\r\1\2"+
		"\u0103\u0104\5\"\22\2\u0104\u0105\b\r\1\2\u0105\u0106\7+\2\2\u0106\u0107"+
		"\5\16\b\2\u0107\u0108\b\r\1\2\u0108\u010a\3\2\2\2\u0109\u0100\3\2\2\2"+
		"\u010a\u010d\3\2\2\2\u010b\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010e"+
		"\3\2\2\2\u010d\u010b\3\2\2\2\u010e\u0115\b\r\1\2\u010f\u0110\b\r\1\2\u0110"+
		"\u0111\7\27\2\2\u0111\u0112\7+\2\2\u0112\u0113\5\16\b\2\u0113\u0114\b"+
		"\r\1\2\u0114\u0116\3\2\2\2\u0115\u010f\3\2\2\2\u0115\u0116\3\2\2\2\u0116"+
		"\u0117\3\2\2\2\u0117\u0118\b\r\1\2\u0118\u0119\7\6\2\2\u0119\u011a\7+"+
		"\2\2\u011a\31\3\2\2\2\u011b\u011c\b\16\1\2\u011c\u011d\7\30\2\2\u011d"+
		"\u011e\7,\2\2\u011e\u011f\7\31\2\2\u011f\u0120\5\"\22\2\u0120\u0121\7"+
		"+\2\2\u0121\u0122\b\16\1\2\u0122\u0123\b\16\1\2\u0123\u0124\5\16\b\2\u0124"+
		"\u0125\7\6\2\2\u0125\u0126\7+\2\2\u0126\u0127\b\16\1\2\u0127\33\3\2\2"+
		"\2\u0128\u0129\7\32\2\2\u0129\u012a\7+\2\2\u012a\u012b\b\17\1\2\u012b"+
		"\35\3\2\2\2\u012c\u012d\7\33\2\2\u012d\u012e\7+\2\2\u012e\u012f\b\20\1"+
		"\2\u012f\37\3\2\2\2\u0130\u0131\5\"\22\2\u0131\u0132\7+\2\2\u0132!\3\2"+
		"\2\2\u0133\u0134\5$\23\2\u0134\u0135\b\22\1\2\u0135#\3\2\2\2\u0136\u0137"+
		"\5&\24\2\u0137\u0138\7\20\2\2\u0138\u0139\5$\23\2\u0139\u013a\b\23\1\2"+
		"\u013a\u013f\3\2\2\2\u013b\u013c\5&\24\2\u013c\u013d\b\23\1\2\u013d\u013f"+
		"\3\2\2\2\u013e\u0136\3\2\2\2\u013e\u013b\3\2\2\2\u013f%\3\2\2\2\u0140"+
		"\u0141\5*\26\2\u0141\u0142\5(\25\2\u0142\u0143\b\24\1\2\u0143\'\3\2\2"+
		"\2\u0144\u0145\7\34\2\2\u0145\u0146\5*\26\2\u0146\u0147\5(\25\2\u0147"+
		"\u0148\b\25\1\2\u0148\u014b\3\2\2\2\u0149\u014b\3\2\2\2\u014a\u0144\3"+
		"\2\2\2\u014a\u0149\3\2\2\2\u014b)\3\2\2\2\u014c\u014d\5.\30\2\u014d\u014e"+
		"\5,\27\2\u014e\u014f\b\26\1\2\u014f+\3\2\2\2\u0150\u0151\7\35\2\2\u0151"+
		"\u0152\5.\30\2\u0152\u0153\5,\27\2\u0153\u0154\b\27\1\2\u0154\u0157\3"+
		"\2\2\2\u0155\u0157\3\2\2\2\u0156\u0150\3\2\2\2\u0156\u0155\3\2\2\2\u0157"+
		"-\3\2\2\2\u0158\u0159\5\62\32\2\u0159\u015a\5\60\31\2\u015a\u015b\b\30"+
		"\1\2\u015b/\3\2\2\2\u015c\u015d\t\3\2\2\u015d\u015e\5\62\32\2\u015e\u015f"+
		"\5\60\31\2\u015f\u0160\b\31\1\2\u0160\u0163\3\2\2\2\u0161\u0163\3\2\2"+
		"\2\u0162\u015c\3\2\2\2\u0162\u0161\3\2\2\2\u0163\61\3\2\2\2\u0164\u0165"+
		"\5\66\34\2\u0165\u0166\5\64\33\2\u0166\u0167\b\32\1\2\u0167\63\3\2\2\2"+
		"\u0168\u0169\t\4\2\2\u0169\u016a\5\66\34\2\u016a\u016b\5\64\33\2\u016b"+
		"\u016c\b\33\1\2\u016c\u016f\3\2\2\2\u016d\u016f\3\2\2\2\u016e\u0168\3"+
		"\2\2\2\u016e\u016d\3\2\2\2\u016f\65\3\2\2\2\u0170\u0171\5:\36\2\u0171"+
		"\u0172\58\35\2\u0172\u0173\b\34\1\2\u0173\67\3\2\2\2\u0174\u0175\t\5\2"+
		"\2\u0175\u0176\5:\36\2\u0176\u0177\58\35\2\u0177\u0178\b\35\1\2\u0178"+
		"\u017b\3\2\2\2\u0179\u017b\3\2\2\2\u017a\u0174\3\2\2\2\u017a\u0179\3\2"+
		"\2\2\u017b9\3\2\2\2\u017c\u017d\5> \2\u017d\u017e\5<\37\2\u017e\u017f"+
		"\b\36\1\2\u017f;\3\2\2\2\u0180\u0181\t\6\2\2\u0181\u0182\5> \2\u0182\u0183"+
		"\5<\37\2\u0183\u0184\b\37\1\2\u0184\u0187\3\2\2\2\u0185\u0187\3\2\2\2"+
		"\u0186\u0180\3\2\2\2\u0186\u0185\3\2\2\2\u0187=\3\2\2\2\u0188\u0189\t"+
		"\7\2\2\u0189\u018a\5> \2\u018a\u018b\b \1\2\u018b\u0190\3\2\2\2\u018c"+
		"\u018d\5@!\2\u018d\u018e\b \1\2\u018e\u0190\3\2\2\2\u018f\u0188\3\2\2"+
		"\2\u018f\u018c\3\2\2\2\u0190?\3\2\2\2\u0191\u0192\5D#\2\u0192\u0193\5"+
		"B\"\2\u0193\u0194\b!\1\2\u0194A\3\2\2\2\u0195\u0196\7\f\2\2\u0196\u0197"+
		"\5\"\22\2\u0197\u0198\7\r\2\2\u0198\u0199\5B\"\2\u0199\u019a\b\"\1\2\u019a"+
		"\u019d\3\2\2\2\u019b\u019d\b\"\1\2\u019c\u0195\3\2\2\2\u019c\u019b\3\2"+
		"\2\2\u019dC\3\2\2\2\u019e\u019f\7(\2\2\u019f\u01c1\b#\1\2\u01a0\u01a1"+
		"\7)\2\2\u01a1\u01c1\b#\1\2\u01a2\u01a3\7*\2\2\u01a3\u01c1\b#\1\2\u01a4"+
		"\u01a5\7,\2\2\u01a5\u01c1\b#\1\2\u01a6\u01a7\7%\2\2\u01a7\u01a8\b#\1\2"+
		"\u01a8\u01a9\5\"\22\2\u01a9\u01b0\b#\1\2\u01aa\u01ab\7\7\2\2\u01ab\u01ac"+
		"\5\"\22\2\u01ac\u01ad\b#\1\2\u01ad\u01af\3\2\2\2\u01ae\u01aa\3\2\2\2\u01af"+
		"\u01b2\3\2\2\2\u01b0\u01ae\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b1\u01b3\3\2"+
		"\2\2\u01b2\u01b0\3\2\2\2\u01b3\u01b4\7&\2\2\u01b4\u01b5\b#\1\2\u01b5\u01c1"+
		"\3\2\2\2\u01b6\u01b7\7\'\2\2\u01b7\u01b8\7\t\2\2\u01b8\u01b9\7(\2\2\u01b9"+
		"\u01ba\7\n\2\2\u01ba\u01c1\b#\1\2\u01bb\u01bc\7\t\2\2\u01bc\u01bd\5\""+
		"\22\2\u01bd\u01be\7\n\2\2\u01be\u01bf\b#\1\2\u01bf\u01c1\3\2\2\2\u01c0"+
		"\u019e\3\2\2\2\u01c0\u01a0\3\2\2\2\u01c0\u01a2\3\2\2\2\u01c0\u01a4\3\2"+
		"\2\2\u01c0\u01a6\3\2\2\2\u01c0\u01b6\3\2\2\2\u01c0\u01bb\3\2\2\2\u01c1"+
		"E\3\2\2\2\"IKZ\\k~\u0081\u0091\u009a\u009d\u00a9\u00ab\u00b7\u00c1\u00cb"+
		"\u00cf\u00db\u00e9\u00ec\u010b\u0115\u013e\u014a\u0156\u0162\u016e\u017a"+
		"\u0186\u018f\u019c\u01b0\u01c0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}