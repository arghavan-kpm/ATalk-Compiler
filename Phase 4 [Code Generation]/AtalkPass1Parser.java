// Generated from AtalkPass1.g4 by ANTLR 4.7

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
public class AtalkPass1Parser extends Parser {
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
	public String getGrammarFileName() { return "AtalkPass1.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


		int actorCnt = 0;
		int IsInFor = 0;
		int IsThereErr = 0;
		String PrintOut = "";
	    ArrayList Dim = new ArrayList();
	    ArrayList args = new ArrayList();
	    void print(String str){
	        System.out.println(str);
	    }

	    void putLocalVar(String name, Type type) throws ItemAlreadyExistsException {
	        PrintOut += "var name: " + name + " var type: " + type.toString() + " offset: " + Integer.toString(SymbolTable.top.getOffset(Register.SP)) + " var size: " + Integer.toString(type.size()) + "\n";
	        SymbolTable.top.put(
	            new SymbolTableLocalVariableItem(
	                new Variable(name, type),
	                SymbolTable.top.getOffset(Register.SP)
	            )
	        );
	    }

	    void addActor(String name, ArrayList arg, int MaxArgSize,int bufSize) throws ItemAlreadyExistsException {
	    	SymbolTable.top.put( new ActorType(name, arg, MaxArgSize,bufSize) );
	    }

	    void addReceiver(String name,ArrayList args) throws ItemAlreadyExistsException {
	   		SymbolTable.top.getPreSymbolTable().put( new ReceiveType(name,args) );			
	    }
	    
	    void addLocalVar(String name,Type type,int line){
	    	try {
	            putLocalVar(name, type);

	        }
	        catch(ItemAlreadyExistsException e) {
	        	print(String.format("[Line #%s] Variable \"%s\" already exists.", line, name));
	        	IsThereErr = 1;

	        	String s = name + "_Temporary_";
		        	int cnt = 1;
		        	while(true){
		        		try{
		        			putLocalVar(s + Integer.toString(cnt), type);
		        		}
		        		catch(ItemAlreadyExistsException exp){
		        			cnt++;
		        			continue;
		        		}
		        		break;
		        	}
	        }
	    }

	    void addActorVar(String name,Type type,int line){
	    	try {
	            PrintOut += "var name: " + name + " var type: " + type.toString() + " offset: " + Integer.toString(SymbolTable.top.getOffset(Register.GP)) + " var size: " + Integer.toString(type.size()) + "\n";
		        SymbolTable.top.put(
		            new SymbolTableActorVariableItem(
		                new Variable(name, type),
		                SymbolTable.top.getOffset(Register.GP)
		            )
		        );

	        }
	        catch(ItemAlreadyExistsException e) {
	        	print(String.format("[Line #%s] Variable \"%s\" already exists.", line, name));
	        	IsThereErr = 1;

	        	String s = name + "_Temporary_";
		        	int cnt = 1;
		        	while(true){
		        		try{
		        			 SymbolTable.top.put(
					            new SymbolTableActorVariableItem(
					                new Variable(s + Integer.toString(cnt), type),
					                SymbolTable.top.getOffset(Register.GP)
					            )
					        );
		        		}
		        		catch(ItemAlreadyExistsException exp){
		        			cnt++;
		        			continue;
		        		}
		        		break;
		        	}
	        }
	    }

	    void beginScope() {
	    	int soffset = 0;
	    	int goffset = 0;
	    	if(SymbolTable.top != null){
	        	soffset = SymbolTable.top.getOffset(Register.SP);
	        	goffset = SymbolTable.top.getOffset(Register.GP);

	    	}
	        SymbolTable.push(new SymbolTable(SymbolTable.top));
	        SymbolTable.top.setOffset(Register.SP, soffset);
	        SymbolTable.top.setOffset(Register.GP, goffset);
	       
	    }
	    
	    void endScope() {
	        print("Stack offset: " + SymbolTable.top.getOffset(Register.SP));
	        SymbolTable.pop();
	    }

	public AtalkPass1Parser(TokenStream input) {
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
		public List<TerminalNode> NL() { return getTokens(AtalkPass1Parser.NL); }
		public TerminalNode NL(int i) {
			return getToken(AtalkPass1Parser.NL, i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			beginScope();
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
				
					if(actorCnt == 0){
						print("No actor<> exists");
						IsThereErr = 1;
					}
					endScope();   
					if(IsThereErr == 0){
						print(PrintOut);
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

	public static class ActorContext extends ParserRuleContext {
		public Token act_id;
		public Token num;
		public ReceiverContext recv;
		public List<TerminalNode> NL() { return getTokens(AtalkPass1Parser.NL); }
		public TerminalNode NL(int i) {
			return getToken(AtalkPass1Parser.NL, i);
		}
		public TerminalNode ID() { return getToken(AtalkPass1Parser.ID, 0); }
		public TerminalNode CONST_NUM() { return getToken(AtalkPass1Parser.CONST_NUM, 0); }
		public TerminalNode EOF() { return getToken(AtalkPass1Parser.EOF, 0); }
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
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).enterActor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).exitActor(this);
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
			((ActorContext)_localctx).act_id = match(ID);
			setState(80);
			match(T__1);
			setState(81);
			((ActorContext)_localctx).num = match(CONST_NUM);
			setState(82);
			match(T__2);
			setState(83);
			match(NL);

						beginScope();
						int MaxArgSize = 0;
						PrintOut += "actor name: " + (((ActorContext)_localctx).act_id!=null?((ActorContext)_localctx).act_id.getText():null) + " queue length: " + (((ActorContext)_localctx).num!=null?((ActorContext)_localctx).num.getText():null) + "\n";
						actorCnt++;
						ArrayList arg = new ArrayList();
					
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__8) | (1L << T__11) | (1L << NL))) != 0)) {
				{
				setState(90);
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
					((ActorContext)_localctx).recv = receiver();

										arg.add(((ActorContext)_localctx).recv.signature);
										if(MaxArgSize < ((ActorContext)_localctx).recv.argSize)
											MaxArgSize = ((ActorContext)_localctx).recv.argSize;
									
					}
					break;
				case NL:
					{
					setState(89);
					match(NL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(95);
			match(T__3);
			setState(96);
			_la = _input.LA(1);
			if ( !(_la==EOF || _la==NL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			 endScope(); 
			 
						if(Integer.parseInt((((ActorContext)_localctx).num!=null?((ActorContext)_localctx).num.getText():null)) <= 0){
							print(String.format("[Line #%d] Actor mailbox size must be more than 0", ((ActorContext)_localctx).num.getLine() )); 
							IsThereErr = 1;
						}

						try {
			            	addActor((((ActorContext)_localctx).act_id!=null?((ActorContext)_localctx).act_id.getText():null), arg, MaxArgSize,Integer.parseInt((((ActorContext)_localctx).num!=null?((ActorContext)_localctx).num.getText():null)));
				        }
				        catch(ItemAlreadyExistsException e) {
				        	print(String.format("[Line #%s] Actor \"%s\" already exists.", ((ActorContext)_localctx).act_id.getLine(), (((ActorContext)_localctx).act_id!=null?((ActorContext)_localctx).act_id.getText():null)));
				        	IsThereErr = 1;

				        	String s = (((ActorContext)_localctx).act_id!=null?((ActorContext)_localctx).act_id.getText():null) + "_Temporary_";
				        	int cnt = 1;
				        	while(true){
				        		try{
				        			addActor(s + Integer.toString(cnt), arg, MaxArgSize,Integer.parseInt((((ActorContext)_localctx).num!=null?((ActorContext)_localctx).num.getText():null)));
				        		}
				        		catch(ItemAlreadyExistsException exp){
				        			cnt++;
				        			continue;
				        		}
				        		break;
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

	public static class StateContext extends ParserRuleContext {
		public TypeContext var_type;
		public Token var_id;
		public TerminalNode NL() { return getToken(AtalkPass1Parser.NL, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(AtalkPass1Parser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AtalkPass1Parser.ID, i);
		}
		public StateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_state; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).enterState(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).exitState(this);
		}
	}

	public final StateContext state() throws RecognitionException {
		StateContext _localctx = new StateContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_state);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			((StateContext)_localctx).var_type = type();
			setState(101);
			((StateContext)_localctx).var_id = match(ID);
			 addActorVar( (((StateContext)_localctx).var_id!=null?((StateContext)_localctx).var_id.getText():null),((StateContext)_localctx).var_type.return_type,((StateContext)_localctx).var_id.getLine() ); 
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(103);
				match(T__4);
				setState(104);
				((StateContext)_localctx).var_id = match(ID);
				 addActorVar( (((StateContext)_localctx).var_id!=null?((StateContext)_localctx).var_id.getText():null),((StateContext)_localctx).var_type.return_type,((StateContext)_localctx).var_id.getLine() ); 
				}
				}
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(111);
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
		public String signature;
		public int argSize;
		public Token recv_id;
		public TypeContext var_type;
		public Token var_id;
		public List<TerminalNode> NL() { return getTokens(AtalkPass1Parser.NL); }
		public TerminalNode NL(int i) {
			return getToken(AtalkPass1Parser.NL, i);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(AtalkPass1Parser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AtalkPass1Parser.ID, i);
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
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).enterReceiver(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).exitReceiver(this);
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
			 args.clear(); ((ReceiverContext)_localctx).argSize =  0;
			setState(115);
			match(T__5);
			setState(116);
			((ReceiverContext)_localctx).recv_id = match(ID);
			setState(117);
			match(T__6);
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8 || _la==T__11) {
				{
				setState(118);
				((ReceiverContext)_localctx).var_type = type();
				setState(119);
				((ReceiverContext)_localctx).var_id = match(ID);
				 _localctx.argSize+= ((ReceiverContext)_localctx).var_type.return_type.size(); args.add(((ReceiverContext)_localctx).var_type.return_type.toString()); addLocalVar( (((ReceiverContext)_localctx).var_id!=null?((ReceiverContext)_localctx).var_id.getText():null),((ReceiverContext)_localctx).var_type.return_type,((ReceiverContext)_localctx).var_id.getLine() ); 
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(121);
					match(T__4);
					setState(122);
					((ReceiverContext)_localctx).var_type = type();
					setState(123);
					((ReceiverContext)_localctx).var_id = match(ID);
					 _localctx.argSize+= ((ReceiverContext)_localctx).var_type.return_type.size(); args.add(((ReceiverContext)_localctx).var_type.return_type.toString()); addLocalVar( (((ReceiverContext)_localctx).var_id!=null?((ReceiverContext)_localctx).var_id.getText():null),((ReceiverContext)_localctx).var_type.return_type,((ReceiverContext)_localctx).var_id.getLine() ); 
					}
					}
					setState(130);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(133);
			match(T__7);
			setState(134);
			match(NL);
			 
						try {
			            	addReceiver((((ReceiverContext)_localctx).recv_id!=null?((ReceiverContext)_localctx).recv_id.getText():null),args);
			            	PrintOut += "Receiver signature: " + new ReceiveType((((ReceiverContext)_localctx).recv_id!=null?((ReceiverContext)_localctx).recv_id.getText():null), args).getKey() + "\n";
			            	((ReceiverContext)_localctx).signature =  new  ReceiveType((((ReceiverContext)_localctx).recv_id!=null?((ReceiverContext)_localctx).recv_id.getText():null), args).getKey();
				        }
				        catch(ItemAlreadyExistsException e) {
				        	print(String.format("[Line #%s] Receiver \"%s\" already exists.", ((ReceiverContext)_localctx).recv_id.getLine(), (((ReceiverContext)_localctx).recv_id!=null?((ReceiverContext)_localctx).recv_id.getText():null)));
				        	IsThereErr = 1;

				        	String s = (((ReceiverContext)_localctx).recv_id!=null?((ReceiverContext)_localctx).recv_id.getText():null) + "_Temporary_";
				        	int cnt = 1;
				        	while(true){
				        		try{
				        			addReceiver(s + Integer.toString(cnt), args);
				        		}
				        		catch(ItemAlreadyExistsException exp){
				        			cnt++;
				        			continue;
				        		}
				        		break;
				        	}
				        }
					
			setState(136);
			statements();
			setState(137);
			match(T__3);
			setState(138);
			match(NL);
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
		public Type return_type;
		public Token tmp;
		public List<TerminalNode> CONST_NUM() { return getTokens(AtalkPass1Parser.CONST_NUM); }
		public TerminalNode CONST_NUM(int i) {
			return getToken(AtalkPass1Parser.CONST_NUM, i);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type);
		int _la;
		try {
			setState(165);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(141);
				match(T__8);
				 Dim.clear(); 
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(143);
					match(T__9);
					setState(144);
					((TypeContext)_localctx).tmp = match(CONST_NUM);
					setState(145);
					match(T__10);
					 

								Dim.add( (((TypeContext)_localctx).tmp!=null?((TypeContext)_localctx).tmp.getText():null) ); 
								if(Integer.parseInt((((TypeContext)_localctx).tmp!=null?((TypeContext)_localctx).tmp.getText():null)) <= 0) {
									print(String.format("[Line #%d] Array size must be more than 0", ((TypeContext)_localctx).tmp.getLine() )); 
									IsThereErr = 1;
								}

								
					}
					}
					setState(151);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				 
							
							if(Dim.size() == 0)
								((TypeContext)_localctx).return_type =  CharType.getInstance();  
							else
								((TypeContext)_localctx).return_type =  ArrType.getInstance(CharType.getInstance(), Dim);
						
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				setState(153);
				match(T__11);
				 Dim.clear(); 
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(155);
					match(T__9);
					setState(156);
					((TypeContext)_localctx).tmp = match(CONST_NUM);
					setState(157);
					match(T__10);
					 
								Dim.add( (((TypeContext)_localctx).tmp!=null?((TypeContext)_localctx).tmp.getText():null) ); 
								if(Integer.parseInt((((TypeContext)_localctx).tmp!=null?((TypeContext)_localctx).tmp.getText():null)) <= 0) {
									print(String.format("[Line #%d] Array size must be more than 0", ((TypeContext)_localctx).tmp.getLine() )); 
									IsThereErr = 1;
								}
									
					}
					}
					setState(163);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				 
							if(Dim.size() == 0)
								((TypeContext)_localctx).return_type =  IntType.getInstance();  
							else
								((TypeContext)_localctx).return_type =  ArrType.getInstance(IntType.getInstance(), Dim);
						
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
		public List<TerminalNode> NL() { return getTokens(AtalkPass1Parser.NL); }
		public TerminalNode NL(int i) {
			return getToken(AtalkPass1Parser.NL, i);
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
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			 beginScope();
			setState(168);
			match(T__12);
			setState(169);
			match(NL);
			setState(170);
			statements();
			setState(171);
			match(T__3);
			setState(172);
			match(NL);
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
		public List<TerminalNode> NL() { return getTokens(AtalkPass1Parser.NL); }
		public TerminalNode NL(int i) {
			return getToken(AtalkPass1Parser.NL, i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).exitStatements(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__8) | (1L << T__11) | (1L << T__12) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__30) | (1L << T__33) | (1L << T__34) | (1L << T__36) | (1L << CONST_NUM) | (1L << CONST_CHAR) | (1L << CONST_STR) | (1L << NL) | (1L << ID))) != 0)) {
				{
				setState(177);
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
					setState(175);
					statement();
					}
					break;
				case NL:
					{
					setState(176);
					match(NL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(181);
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
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_statement);
		try {
			setState(191);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(182);
				stm_vardef();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(183);
				stm_assignment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(184);
				stm_foreach();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(185);
				stm_if_elseif_else();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(186);
				stm_quit();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(187);
				stm_break();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(188);
				stm_tell();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(189);
				stm_write();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(190);
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
		public TypeContext var_type;
		public Token var_id;
		public TerminalNode NL() { return getToken(AtalkPass1Parser.NL, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(AtalkPass1Parser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AtalkPass1Parser.ID, i);
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
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).enterStm_vardef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).exitStm_vardef(this);
		}
	}

	public final Stm_vardefContext stm_vardef() throws RecognitionException {
		Stm_vardefContext _localctx = new Stm_vardefContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_stm_vardef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			((Stm_vardefContext)_localctx).var_type = type();
			setState(194);
			((Stm_vardefContext)_localctx).var_id = match(ID);
			 addLocalVar( (((Stm_vardefContext)_localctx).var_id!=null?((Stm_vardefContext)_localctx).var_id.getText():null),((Stm_vardefContext)_localctx).var_type.return_type,((Stm_vardefContext)_localctx).var_id.getLine() ); 
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(196);
				match(T__13);
				setState(197);
				expr();
				}
			}

			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(200);
				match(T__4);
				setState(201);
				((Stm_vardefContext)_localctx).var_id = match(ID);
				 addLocalVar( (((Stm_vardefContext)_localctx).var_id!=null?((Stm_vardefContext)_localctx).var_id.getText():null),((Stm_vardefContext)_localctx).var_type.return_type,((Stm_vardefContext)_localctx).var_id.getLine() ); 
				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(203);
					match(T__13);
					setState(204);
					expr();
					}
				}

				}
				}
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(212);
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
		public List<TerminalNode> ID() { return getTokens(AtalkPass1Parser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AtalkPass1Parser.ID, i);
		}
		public TerminalNode NL() { return getToken(AtalkPass1Parser.NL, 0); }
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
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).enterStm_tell(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).exitStm_tell(this);
		}
	}

	public final Stm_tellContext stm_tell() throws RecognitionException {
		Stm_tellContext _localctx = new Stm_tellContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_stm_tell);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << ID))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(215);
			match(T__16);
			setState(216);
			match(ID);
			setState(217);
			match(T__6);
			setState(226);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__30) | (1L << T__33) | (1L << T__34) | (1L << T__36) | (1L << CONST_NUM) | (1L << CONST_CHAR) | (1L << CONST_STR) | (1L << ID))) != 0)) {
				{
				setState(218);
				expr();
				setState(223);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(219);
					match(T__4);
					setState(220);
					expr();
					}
					}
					setState(225);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(228);
			match(T__7);
			setState(229);
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

	public static class Stm_writeContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NL() { return getToken(AtalkPass1Parser.NL, 0); }
		public Stm_writeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stm_write; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).enterStm_write(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).exitStm_write(this);
		}
	}

	public final Stm_writeContext stm_write() throws RecognitionException {
		Stm_writeContext _localctx = new Stm_writeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_stm_write);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(T__17);
			setState(232);
			match(T__6);
			setState(233);
			expr();
			setState(234);
			match(T__7);
			setState(235);
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
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(AtalkPass1Parser.NL); }
		public TerminalNode NL(int i) {
			return getToken(AtalkPass1Parser.NL, i);
		}
		public List<StatementsContext> statements() {
			return getRuleContexts(StatementsContext.class);
		}
		public StatementsContext statements(int i) {
			return getRuleContext(StatementsContext.class,i);
		}
		public Stm_if_elseif_elseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stm_if_elseif_else; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).enterStm_if_elseif_else(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).exitStm_if_elseif_else(this);
		}
	}

	public final Stm_if_elseif_elseContext stm_if_elseif_else() throws RecognitionException {
		Stm_if_elseif_elseContext _localctx = new Stm_if_elseif_elseContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_stm_if_elseif_else);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 beginScope(); 
			setState(238);
			match(T__18);
			setState(239);
			expr();
			setState(240);
			match(NL);
			setState(241);
			statements();
			 endScope(); 
			setState(252);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19) {
				{
				{
				 beginScope(); 
				setState(244);
				match(T__19);
				setState(245);
				expr();
				setState(246);
				match(NL);
				setState(247);
				statements();
				 endScope(); 
				}
				}
				setState(254);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(261);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				 beginScope(); 
				setState(256);
				match(T__20);
				setState(257);
				match(NL);
				setState(258);
				statements();
				 endScope(); 
				}
			}

			setState(263);
			match(T__3);
			setState(264);
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(AtalkPass1Parser.NL); }
		public TerminalNode NL(int i) {
			return getToken(AtalkPass1Parser.NL, i);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode ID() { return getToken(AtalkPass1Parser.ID, 0); }
		public Stm_foreachContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stm_foreach; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).enterStm_foreach(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).exitStm_foreach(this);
		}
	}

	public final Stm_foreachContext stm_foreach() throws RecognitionException {
		Stm_foreachContext _localctx = new Stm_foreachContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_stm_foreach);
		try {
			enterOuterAlt(_localctx, 1);
			{
			 beginScope(); 
			setState(267);
			match(T__21);
			setState(268);
			((Stm_foreachContext)_localctx).temp = match(ID);
			setState(269);
			match(T__22);
			setState(270);
			expr();
			setState(271);
			match(NL);

							IsInFor = 1;
							addLocalVar((((Stm_foreachContext)_localctx).temp!=null?((Stm_foreachContext)_localctx).temp.getText():null),NoType.getInstance(),((Stm_foreachContext)_localctx).temp.getLine());
						
			setState(273);
			statements();
			setState(274);
			match(T__3);
			setState(275);
			match(NL);
			IsInFor = 0;
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

	public static class Stm_quitContext extends ParserRuleContext {
		public TerminalNode NL() { return getToken(AtalkPass1Parser.NL, 0); }
		public Stm_quitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stm_quit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).enterStm_quit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).exitStm_quit(this);
		}
	}

	public final Stm_quitContext stm_quit() throws RecognitionException {
		Stm_quitContext _localctx = new Stm_quitContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_stm_quit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			match(T__23);
			setState(280);
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

	public static class Stm_breakContext extends ParserRuleContext {
		public TerminalNode NL() { return getToken(AtalkPass1Parser.NL, 0); }
		public Stm_breakContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stm_break; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).enterStm_break(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).exitStm_break(this);
		}
	}

	public final Stm_breakContext stm_break() throws RecognitionException {
		Stm_breakContext _localctx = new Stm_breakContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_stm_break);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			match(T__24);
			setState(283);
			match(NL);
			if(IsInFor == 0)
						print("break out of for");
					
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
		public TerminalNode NL() { return getToken(AtalkPass1Parser.NL, 0); }
		public Stm_assignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stm_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).enterStm_assignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).exitStm_assignment(this);
		}
	}

	public final Stm_assignmentContext stm_assignment() throws RecognitionException {
		Stm_assignmentContext _localctx = new Stm_assignmentContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_stm_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			expr();
			setState(287);
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
		public Expr_assignContext expr_assign() {
			return getRuleContext(Expr_assignContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			expr_assign();
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
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).enterExpr_assign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).exitExpr_assign(this);
		}
	}

	public final Expr_assignContext expr_assign() throws RecognitionException {
		Expr_assignContext _localctx = new Expr_assignContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_expr_assign);
		try {
			setState(296);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(291);
				expr_or();
				setState(292);
				match(T__13);
				setState(293);
				expr_assign();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(295);
				expr_or();
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
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).enterExpr_or(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).exitExpr_or(this);
		}
	}

	public final Expr_orContext expr_or() throws RecognitionException {
		Expr_orContext _localctx = new Expr_orContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_expr_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			expr_and();
			setState(299);
			expr_or_tmp();
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
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).enterExpr_or_tmp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).exitExpr_or_tmp(this);
		}
	}

	public final Expr_or_tmpContext expr_or_tmp() throws RecognitionException {
		Expr_or_tmpContext _localctx = new Expr_or_tmpContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_expr_or_tmp);
		try {
			setState(306);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__25:
				enterOuterAlt(_localctx, 1);
				{
				setState(301);
				match(T__25);
				setState(302);
				expr_and();
				setState(303);
				expr_or_tmp();
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
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).enterExpr_and(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).exitExpr_and(this);
		}
	}

	public final Expr_andContext expr_and() throws RecognitionException {
		Expr_andContext _localctx = new Expr_andContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_expr_and);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			expr_eq();
			setState(309);
			expr_and_tmp();
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
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).enterExpr_and_tmp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).exitExpr_and_tmp(this);
		}
	}

	public final Expr_and_tmpContext expr_and_tmp() throws RecognitionException {
		Expr_and_tmpContext _localctx = new Expr_and_tmpContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_expr_and_tmp);
		try {
			setState(316);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__26:
				enterOuterAlt(_localctx, 1);
				{
				setState(311);
				match(T__26);
				setState(312);
				expr_eq();
				setState(313);
				expr_and_tmp();
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
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).enterExpr_eq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).exitExpr_eq(this);
		}
	}

	public final Expr_eqContext expr_eq() throws RecognitionException {
		Expr_eqContext _localctx = new Expr_eqContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_expr_eq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			expr_cmp();
			setState(319);
			expr_eq_tmp();
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
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).enterExpr_eq_tmp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).exitExpr_eq_tmp(this);
		}
	}

	public final Expr_eq_tmpContext expr_eq_tmp() throws RecognitionException {
		Expr_eq_tmpContext _localctx = new Expr_eq_tmpContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_expr_eq_tmp);
		int _la;
		try {
			setState(326);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__27:
			case T__28:
				enterOuterAlt(_localctx, 1);
				{
				setState(321);
				_la = _input.LA(1);
				if ( !(_la==T__27 || _la==T__28) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(322);
				expr_cmp();
				setState(323);
				expr_eq_tmp();
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
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).enterExpr_cmp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).exitExpr_cmp(this);
		}
	}

	public final Expr_cmpContext expr_cmp() throws RecognitionException {
		Expr_cmpContext _localctx = new Expr_cmpContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_expr_cmp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			expr_add();
			setState(329);
			expr_cmp_tmp();
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
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).enterExpr_cmp_tmp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).exitExpr_cmp_tmp(this);
		}
	}

	public final Expr_cmp_tmpContext expr_cmp_tmp() throws RecognitionException {
		Expr_cmp_tmpContext _localctx = new Expr_cmp_tmpContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_expr_cmp_tmp);
		int _la;
		try {
			setState(336);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(331);
				_la = _input.LA(1);
				if ( !(_la==T__1 || _la==T__2) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(332);
				expr_add();
				setState(333);
				expr_cmp_tmp();
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
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).enterExpr_add(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).exitExpr_add(this);
		}
	}

	public final Expr_addContext expr_add() throws RecognitionException {
		Expr_addContext _localctx = new Expr_addContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_expr_add);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			expr_mult();
			setState(339);
			expr_add_tmp();
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
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).enterExpr_add_tmp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).exitExpr_add_tmp(this);
		}
	}

	public final Expr_add_tmpContext expr_add_tmp() throws RecognitionException {
		Expr_add_tmpContext _localctx = new Expr_add_tmpContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_expr_add_tmp);
		int _la;
		try {
			setState(346);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__29:
			case T__30:
				enterOuterAlt(_localctx, 1);
				{
				setState(341);
				_la = _input.LA(1);
				if ( !(_la==T__29 || _la==T__30) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(342);
				expr_mult();
				setState(343);
				expr_add_tmp();
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
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).enterExpr_mult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).exitExpr_mult(this);
		}
	}

	public final Expr_multContext expr_mult() throws RecognitionException {
		Expr_multContext _localctx = new Expr_multContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_expr_mult);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(348);
			expr_un();
			setState(349);
			expr_mult_tmp();
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
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).enterExpr_mult_tmp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).exitExpr_mult_tmp(this);
		}
	}

	public final Expr_mult_tmpContext expr_mult_tmp() throws RecognitionException {
		Expr_mult_tmpContext _localctx = new Expr_mult_tmpContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_expr_mult_tmp);
		int _la;
		try {
			setState(356);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__31:
			case T__32:
				enterOuterAlt(_localctx, 1);
				{
				setState(351);
				_la = _input.LA(1);
				if ( !(_la==T__31 || _la==T__32) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(352);
				expr_un();
				setState(353);
				expr_mult_tmp();
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
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).enterExpr_un(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).exitExpr_un(this);
		}
	}

	public final Expr_unContext expr_un() throws RecognitionException {
		Expr_unContext _localctx = new Expr_unContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_expr_un);
		int _la;
		try {
			setState(361);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
			case T__33:
				enterOuterAlt(_localctx, 1);
				{
				setState(358);
				_la = _input.LA(1);
				if ( !(_la==T__30 || _la==T__33) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(359);
				expr_un();
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
				setState(360);
				expr_mem();
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
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).enterExpr_mem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).exitExpr_mem(this);
		}
	}

	public final Expr_memContext expr_mem() throws RecognitionException {
		Expr_memContext _localctx = new Expr_memContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_expr_mem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(363);
			expr_other();
			setState(364);
			expr_mem_tmp();
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
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).enterExpr_mem_tmp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).exitExpr_mem_tmp(this);
		}
	}

	public final Expr_mem_tmpContext expr_mem_tmp() throws RecognitionException {
		Expr_mem_tmpContext _localctx = new Expr_mem_tmpContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_expr_mem_tmp);
		try {
			setState(372);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(366);
				match(T__9);
				setState(367);
				expr();
				setState(368);
				match(T__10);
				setState(369);
				expr_mem_tmp();
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
		public TerminalNode CONST_NUM() { return getToken(AtalkPass1Parser.CONST_NUM, 0); }
		public TerminalNode CONST_CHAR() { return getToken(AtalkPass1Parser.CONST_CHAR, 0); }
		public TerminalNode CONST_STR() { return getToken(AtalkPass1Parser.CONST_STR, 0); }
		public TerminalNode ID() { return getToken(AtalkPass1Parser.ID, 0); }
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
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).enterExpr_other(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkPass1Listener ) ((AtalkPass1Listener)listener).exitExpr_other(this);
		}
	}

	public final Expr_otherContext expr_other() throws RecognitionException {
		Expr_otherContext _localctx = new Expr_otherContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_expr_other);
		int _la;
		try {
			setState(397);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONST_NUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(374);
				match(CONST_NUM);
				}
				break;
			case CONST_CHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(375);
				match(CONST_CHAR);
				}
				break;
			case CONST_STR:
				enterOuterAlt(_localctx, 3);
				{
				setState(376);
				match(CONST_STR);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 4);
				{
				setState(377);
				match(ID);
				}
				break;
			case T__34:
				enterOuterAlt(_localctx, 5);
				{
				setState(378);
				match(T__34);
				setState(379);
				expr();
				setState(384);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(380);
					match(T__4);
					setState(381);
					expr();
					}
					}
					setState(386);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(387);
				match(T__35);
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 6);
				{
				setState(389);
				match(T__36);
				setState(390);
				match(T__6);
				setState(391);
				match(CONST_NUM);
				setState(392);
				match(T__7);
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 7);
				{
				setState(393);
				match(T__6);
				setState(394);
				expr();
				setState(395);
				match(T__7);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u0192\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\2\7\2J\n\2\f\2\16\2M\13\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3]\n\3\f\3\16\3`\13\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\7\4m\n\4\f\4\16\4p\13\4\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\u0081\n\5\f\5"+
		"\16\5\u0084\13\5\5\5\u0086\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\7\6\u0096\n\6\f\6\16\6\u0099\13\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\7\6\u00a2\n\6\f\6\16\6\u00a5\13\6\3\6\5\6\u00a8\n\6\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\7\b\u00b4\n\b\f\b\16\b\u00b7\13\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00c2\n\t\3\n\3\n\3\n\3\n\3\n\5\n\u00c9"+
		"\n\n\3\n\3\n\3\n\3\n\3\n\5\n\u00d0\n\n\7\n\u00d2\n\n\f\n\16\n\u00d5\13"+
		"\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00e0\n\13\f\13\16"+
		"\13\u00e3\13\13\5\13\u00e5\n\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00fd\n\r\f\r"+
		"\16\r\u0100\13\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0108\n\r\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23"+
		"\3\23\5\23\u012b\n\23\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\5\25\u0135"+
		"\n\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\5\27\u013f\n\27\3\30\3\30"+
		"\3\30\3\31\3\31\3\31\3\31\3\31\5\31\u0149\n\31\3\32\3\32\3\32\3\33\3\33"+
		"\3\33\3\33\3\33\5\33\u0153\n\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35"+
		"\5\35\u015d\n\35\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\5\37\u0167\n"+
		"\37\3 \3 \3 \5 \u016c\n \3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u0177\n"+
		"\"\3#\3#\3#\3#\3#\3#\3#\3#\7#\u0181\n#\f#\16#\u0184\13#\3#\3#\3#\3#\3"+
		"#\3#\3#\3#\3#\3#\5#\u0190\n#\3#\2\2$\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\64\668:<>@BD\2\t\3\3++\4\2\21\22,,\3\2\36\37\3\2"+
		"\4\5\3\2 !\3\2\"#\4\2!!$$\2\u019b\2F\3\2\2\2\4P\3\2\2\2\6f\3\2\2\2\bs"+
		"\3\2\2\2\n\u00a7\3\2\2\2\f\u00a9\3\2\2\2\16\u00b5\3\2\2\2\20\u00c1\3\2"+
		"\2\2\22\u00c3\3\2\2\2\24\u00d8\3\2\2\2\26\u00e9\3\2\2\2\30\u00ef\3\2\2"+
		"\2\32\u010c\3\2\2\2\34\u0119\3\2\2\2\36\u011c\3\2\2\2 \u0120\3\2\2\2\""+
		"\u0123\3\2\2\2$\u012a\3\2\2\2&\u012c\3\2\2\2(\u0134\3\2\2\2*\u0136\3\2"+
		"\2\2,\u013e\3\2\2\2.\u0140\3\2\2\2\60\u0148\3\2\2\2\62\u014a\3\2\2\2\64"+
		"\u0152\3\2\2\2\66\u0154\3\2\2\28\u015c\3\2\2\2:\u015e\3\2\2\2<\u0166\3"+
		"\2\2\2>\u016b\3\2\2\2@\u016d\3\2\2\2B\u0176\3\2\2\2D\u018f\3\2\2\2FK\b"+
		"\2\1\2GJ\5\4\3\2HJ\7+\2\2IG\3\2\2\2IH\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3"+
		"\2\2\2LN\3\2\2\2MK\3\2\2\2NO\b\2\1\2O\3\3\2\2\2PQ\7\3\2\2QR\7,\2\2RS\7"+
		"\4\2\2ST\7(\2\2TU\7\5\2\2UV\7+\2\2V^\b\3\1\2W]\5\6\4\2XY\5\b\5\2YZ\b\3"+
		"\1\2Z]\3\2\2\2[]\7+\2\2\\W\3\2\2\2\\X\3\2\2\2\\[\3\2\2\2]`\3\2\2\2^\\"+
		"\3\2\2\2^_\3\2\2\2_a\3\2\2\2`^\3\2\2\2ab\7\6\2\2bc\t\2\2\2cd\b\3\1\2d"+
		"e\b\3\1\2e\5\3\2\2\2fg\5\n\6\2gh\7,\2\2hn\b\4\1\2ij\7\7\2\2jk\7,\2\2k"+
		"m\b\4\1\2li\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2oq\3\2\2\2pn\3\2\2\2"+
		"qr\7+\2\2r\7\3\2\2\2st\b\5\1\2tu\b\5\1\2uv\7\b\2\2vw\7,\2\2w\u0085\7\t"+
		"\2\2xy\5\n\6\2yz\7,\2\2z\u0082\b\5\1\2{|\7\7\2\2|}\5\n\6\2}~\7,\2\2~\177"+
		"\b\5\1\2\177\u0081\3\2\2\2\u0080{\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080"+
		"\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0085"+
		"x\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\7\n\2\2"+
		"\u0088\u0089\7+\2\2\u0089\u008a\b\5\1\2\u008a\u008b\5\16\b\2\u008b\u008c"+
		"\7\6\2\2\u008c\u008d\7+\2\2\u008d\u008e\b\5\1\2\u008e\t\3\2\2\2\u008f"+
		"\u0090\7\13\2\2\u0090\u0097\b\6\1\2\u0091\u0092\7\f\2\2\u0092\u0093\7"+
		"(\2\2\u0093\u0094\7\r\2\2\u0094\u0096\b\6\1\2\u0095\u0091\3\2\2\2\u0096"+
		"\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009a\3\2"+
		"\2\2\u0099\u0097\3\2\2\2\u009a\u00a8\b\6\1\2\u009b\u009c\7\16\2\2\u009c"+
		"\u00a3\b\6\1\2\u009d\u009e\7\f\2\2\u009e\u009f\7(\2\2\u009f\u00a0\7\r"+
		"\2\2\u00a0\u00a2\b\6\1\2\u00a1\u009d\3\2\2\2\u00a2\u00a5\3\2\2\2\u00a3"+
		"\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a6\3\2\2\2\u00a5\u00a3\3\2"+
		"\2\2\u00a6\u00a8\b\6\1\2\u00a7\u008f\3\2\2\2\u00a7\u009b\3\2\2\2\u00a8"+
		"\13\3\2\2\2\u00a9\u00aa\b\7\1\2\u00aa\u00ab\7\17\2\2\u00ab\u00ac\7+\2"+
		"\2\u00ac\u00ad\5\16\b\2\u00ad\u00ae\7\6\2\2\u00ae\u00af\7+\2\2\u00af\u00b0"+
		"\b\7\1\2\u00b0\r\3\2\2\2\u00b1\u00b4\5\20\t\2\u00b2\u00b4\7+\2\2\u00b3"+
		"\u00b1\3\2\2\2\u00b3\u00b2\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2"+
		"\2\2\u00b5\u00b6\3\2\2\2\u00b6\17\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00c2"+
		"\5\22\n\2\u00b9\u00c2\5 \21\2\u00ba\u00c2\5\32\16\2\u00bb\u00c2\5\30\r"+
		"\2\u00bc\u00c2\5\34\17\2\u00bd\u00c2\5\36\20\2\u00be\u00c2\5\24\13\2\u00bf"+
		"\u00c2\5\26\f\2\u00c0\u00c2\5\f\7\2\u00c1\u00b8\3\2\2\2\u00c1\u00b9\3"+
		"\2\2\2\u00c1\u00ba\3\2\2\2\u00c1\u00bb\3\2\2\2\u00c1\u00bc\3\2\2\2\u00c1"+
		"\u00bd\3\2\2\2\u00c1\u00be\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c0\3\2"+
		"\2\2\u00c2\21\3\2\2\2\u00c3\u00c4\5\n\6\2\u00c4\u00c5\7,\2\2\u00c5\u00c8"+
		"\b\n\1\2\u00c6\u00c7\7\20\2\2\u00c7\u00c9\5\"\22\2\u00c8\u00c6\3\2\2\2"+
		"\u00c8\u00c9\3\2\2\2\u00c9\u00d3\3\2\2\2\u00ca\u00cb\7\7\2\2\u00cb\u00cc"+
		"\7,\2\2\u00cc\u00cf\b\n\1\2\u00cd\u00ce\7\20\2\2\u00ce\u00d0\5\"\22\2"+
		"\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d2\3\2\2\2\u00d1\u00ca"+
		"\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4"+
		"\u00d6\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00d7\7+\2\2\u00d7\23\3\2\2\2"+
		"\u00d8\u00d9\t\3\2\2\u00d9\u00da\7\23\2\2\u00da\u00db\7,\2\2\u00db\u00e4"+
		"\7\t\2\2\u00dc\u00e1\5\"\22\2\u00dd\u00de\7\7\2\2\u00de\u00e0\5\"\22\2"+
		"\u00df\u00dd\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2"+
		"\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4\u00dc\3\2\2\2\u00e4"+
		"\u00e5\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\7\n\2\2\u00e7\u00e8\7+"+
		"\2\2\u00e8\25\3\2\2\2\u00e9\u00ea\7\24\2\2\u00ea\u00eb\7\t\2\2\u00eb\u00ec"+
		"\5\"\22\2\u00ec\u00ed\7\n\2\2\u00ed\u00ee\7+\2\2\u00ee\27\3\2\2\2\u00ef"+
		"\u00f0\b\r\1\2\u00f0\u00f1\7\25\2\2\u00f1\u00f2\5\"\22\2\u00f2\u00f3\7"+
		"+\2\2\u00f3\u00f4\5\16\b\2\u00f4\u00fe\b\r\1\2\u00f5\u00f6\b\r\1\2\u00f6"+
		"\u00f7\7\26\2\2\u00f7\u00f8\5\"\22\2\u00f8\u00f9\7+\2\2\u00f9\u00fa\5"+
		"\16\b\2\u00fa\u00fb\b\r\1\2\u00fb\u00fd\3\2\2\2\u00fc\u00f5\3\2\2\2\u00fd"+
		"\u0100\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0107\3\2"+
		"\2\2\u0100\u00fe\3\2\2\2\u0101\u0102\b\r\1\2\u0102\u0103\7\27\2\2\u0103"+
		"\u0104\7+\2\2\u0104\u0105\5\16\b\2\u0105\u0106\b\r\1\2\u0106\u0108\3\2"+
		"\2\2\u0107\u0101\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u0109\3\2\2\2\u0109"+
		"\u010a\7\6\2\2\u010a\u010b\7+\2\2\u010b\31\3\2\2\2\u010c\u010d\b\16\1"+
		"\2\u010d\u010e\7\30\2\2\u010e\u010f\7,\2\2\u010f\u0110\7\31\2\2\u0110"+
		"\u0111\5\"\22\2\u0111\u0112\7+\2\2\u0112\u0113\b\16\1\2\u0113\u0114\5"+
		"\16\b\2\u0114\u0115\7\6\2\2\u0115\u0116\7+\2\2\u0116\u0117\b\16\1\2\u0117"+
		"\u0118\b\16\1\2\u0118\33\3\2\2\2\u0119\u011a\7\32\2\2\u011a\u011b\7+\2"+
		"\2\u011b\35\3\2\2\2\u011c\u011d\7\33\2\2\u011d\u011e\7+\2\2\u011e\u011f"+
		"\b\20\1\2\u011f\37\3\2\2\2\u0120\u0121\5\"\22\2\u0121\u0122\7+\2\2\u0122"+
		"!\3\2\2\2\u0123\u0124\5$\23\2\u0124#\3\2\2\2\u0125\u0126\5&\24\2\u0126"+
		"\u0127\7\20\2\2\u0127\u0128\5$\23\2\u0128\u012b\3\2\2\2\u0129\u012b\5"+
		"&\24\2\u012a\u0125\3\2\2\2\u012a\u0129\3\2\2\2\u012b%\3\2\2\2\u012c\u012d"+
		"\5*\26\2\u012d\u012e\5(\25\2\u012e\'\3\2\2\2\u012f\u0130\7\34\2\2\u0130"+
		"\u0131\5*\26\2\u0131\u0132\5(\25\2\u0132\u0135\3\2\2\2\u0133\u0135\3\2"+
		"\2\2\u0134\u012f\3\2\2\2\u0134\u0133\3\2\2\2\u0135)\3\2\2\2\u0136\u0137"+
		"\5.\30\2\u0137\u0138\5,\27\2\u0138+\3\2\2\2\u0139\u013a\7\35\2\2\u013a"+
		"\u013b\5.\30\2\u013b\u013c\5,\27\2\u013c\u013f\3\2\2\2\u013d\u013f\3\2"+
		"\2\2\u013e\u0139\3\2\2\2\u013e\u013d\3\2\2\2\u013f-\3\2\2\2\u0140\u0141"+
		"\5\62\32\2\u0141\u0142\5\60\31\2\u0142/\3\2\2\2\u0143\u0144\t\4\2\2\u0144"+
		"\u0145\5\62\32\2\u0145\u0146\5\60\31\2\u0146\u0149\3\2\2\2\u0147\u0149"+
		"\3\2\2\2\u0148\u0143\3\2\2\2\u0148\u0147\3\2\2\2\u0149\61\3\2\2\2\u014a"+
		"\u014b\5\66\34\2\u014b\u014c\5\64\33\2\u014c\63\3\2\2\2\u014d\u014e\t"+
		"\5\2\2\u014e\u014f\5\66\34\2\u014f\u0150\5\64\33\2\u0150\u0153\3\2\2\2"+
		"\u0151\u0153\3\2\2\2\u0152\u014d\3\2\2\2\u0152\u0151\3\2\2\2\u0153\65"+
		"\3\2\2\2\u0154\u0155\5:\36\2\u0155\u0156\58\35\2\u0156\67\3\2\2\2\u0157"+
		"\u0158\t\6\2\2\u0158\u0159\5:\36\2\u0159\u015a\58\35\2\u015a\u015d\3\2"+
		"\2\2\u015b\u015d\3\2\2\2\u015c\u0157\3\2\2\2\u015c\u015b\3\2\2\2\u015d"+
		"9\3\2\2\2\u015e\u015f\5> \2\u015f\u0160\5<\37\2\u0160;\3\2\2\2\u0161\u0162"+
		"\t\7\2\2\u0162\u0163\5> \2\u0163\u0164\5<\37\2\u0164\u0167\3\2\2\2\u0165"+
		"\u0167\3\2\2\2\u0166\u0161\3\2\2\2\u0166\u0165\3\2\2\2\u0167=\3\2\2\2"+
		"\u0168\u0169\t\b\2\2\u0169\u016c\5> \2\u016a\u016c\5@!\2\u016b\u0168\3"+
		"\2\2\2\u016b\u016a\3\2\2\2\u016c?\3\2\2\2\u016d\u016e\5D#\2\u016e\u016f"+
		"\5B\"\2\u016fA\3\2\2\2\u0170\u0171\7\f\2\2\u0171\u0172\5\"\22\2\u0172"+
		"\u0173\7\r\2\2\u0173\u0174\5B\"\2\u0174\u0177\3\2\2\2\u0175\u0177\3\2"+
		"\2\2\u0176\u0170\3\2\2\2\u0176\u0175\3\2\2\2\u0177C\3\2\2\2\u0178\u0190"+
		"\7(\2\2\u0179\u0190\7)\2\2\u017a\u0190\7*\2\2\u017b\u0190\7,\2\2\u017c"+
		"\u017d\7%\2\2\u017d\u0182\5\"\22\2\u017e\u017f\7\7\2\2\u017f\u0181\5\""+
		"\22\2\u0180\u017e\3\2\2\2\u0181\u0184\3\2\2\2\u0182\u0180\3\2\2\2\u0182"+
		"\u0183\3\2\2\2\u0183\u0185\3\2\2\2\u0184\u0182\3\2\2\2\u0185\u0186\7&"+
		"\2\2\u0186\u0190\3\2\2\2\u0187\u0188\7\'\2\2\u0188\u0189\7\t\2\2\u0189"+
		"\u018a\7(\2\2\u018a\u0190\7\n\2\2\u018b\u018c\7\t\2\2\u018c\u018d\5\""+
		"\22\2\u018d\u018e\7\n\2\2\u018e\u0190\3\2\2\2\u018f\u0178\3\2\2\2\u018f"+
		"\u0179\3\2\2\2\u018f\u017a\3\2\2\2\u018f\u017b\3\2\2\2\u018f\u017c\3\2"+
		"\2\2\u018f\u0187\3\2\2\2\u018f\u018b\3\2\2\2\u0190E\3\2\2\2!IK\\^n\u0082"+
		"\u0085\u0097\u00a3\u00a7\u00b3\u00b5\u00c1\u00c8\u00cf\u00d3\u00e1\u00e4"+
		"\u00fe\u0107\u012a\u0134\u013e\u0148\u0152\u015c\u0166\u016b\u0176\u0182"+
		"\u018f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}