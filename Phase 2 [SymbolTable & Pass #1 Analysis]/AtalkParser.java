// Generated from Atalk.g4 by ANTLR 4.7

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
public class AtalkParser extends Parser {
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
	public String getGrammarFileName() { return "Atalk.g4"; }

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

	    void addActor(String name) throws ItemAlreadyExistsException {
	    	SymbolTable.top.put( new ActorType(name) );
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

	    void beginScope() {
	    	int offset = 0;
	    	if(SymbolTable.top != null){
	        	offset = SymbolTable.top.getOffset(Register.SP);
	    	}
	        SymbolTable.push(new SymbolTable(SymbolTable.top));
	        SymbolTable.top.setOffset(Register.SP, offset);
	       
	    }
	    
	    void endScope() {
	        print("Stack offset: " + SymbolTable.top.getOffset(Register.SP));
	        //print(Integer.toString(IsThereErr));
	        SymbolTable.pop();
	    }

	public AtalkParser(TokenStream input) {
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
		public List<TerminalNode> NL() { return getTokens(AtalkParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(AtalkParser.NL, i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).exitProgram(this);
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
		public List<TerminalNode> NL() { return getTokens(AtalkParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(AtalkParser.NL, i);
		}
		public TerminalNode ID() { return getToken(AtalkParser.ID, 0); }
		public TerminalNode CONST_NUM() { return getToken(AtalkParser.CONST_NUM, 0); }
		public TerminalNode EOF() { return getToken(AtalkParser.EOF, 0); }
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
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).enterActor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).exitActor(this);
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
			 
						PrintOut += "actor name: " + (((ActorContext)_localctx).act_id!=null?((ActorContext)_localctx).act_id.getText():null) + " queue length: " + (((ActorContext)_localctx).num!=null?((ActorContext)_localctx).num.getText():null) + "\n";
						actorCnt++;
						if(Integer.parseInt((((ActorContext)_localctx).num!=null?((ActorContext)_localctx).num.getText():null)) <= 0){
							print(String.format("[Line #%d] Actor mailbox size must be more than 0", ((ActorContext)_localctx).num.getLine() )); 
							IsThereErr = 1;
						}

						try {
			            	addActor((((ActorContext)_localctx).act_id!=null?((ActorContext)_localctx).act_id.getText():null));
				        }
				        catch(ItemAlreadyExistsException e) {
				        	print(String.format("[Line #%s] Actor \"%s\" already exists.", ((ActorContext)_localctx).act_id.getLine(), (((ActorContext)_localctx).act_id!=null?((ActorContext)_localctx).act_id.getText():null)));
				        	IsThereErr = 1;

				        	String s = (((ActorContext)_localctx).act_id!=null?((ActorContext)_localctx).act_id.getText():null) + "_Temporary_";
				        	int cnt = 1;
				        	while(true){
				        		try{
				        			addActor(s + Integer.toString(cnt));
				        		}
				        		catch(ItemAlreadyExistsException exp){
				        			cnt++;
				        			continue;
				        		}
				        		break;
				        	}
				        }
					
			 beginScope(); 
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__8) | (1L << T__11) | (1L << NL))) != 0)) {
				{
				setState(89);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__8:
				case T__11:
					{
					setState(86);
					state();
					}
					break;
				case T__5:
					{
					setState(87);
					receiver();
					}
					break;
				case NL:
					{
					setState(88);
					match(NL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94);
			match(T__3);
			setState(95);
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
		public TerminalNode NL() { return getToken(AtalkParser.NL, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(AtalkParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AtalkParser.ID, i);
		}
		public StateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_state; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).enterState(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).exitState(this);
		}
	}

	public final StateContext state() throws RecognitionException {
		StateContext _localctx = new StateContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_state);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			((StateContext)_localctx).var_type = type();
			setState(99);
			((StateContext)_localctx).var_id = match(ID);
			 addLocalVar( (((StateContext)_localctx).var_id!=null?((StateContext)_localctx).var_id.getText():null),((StateContext)_localctx).var_type.return_type,((StateContext)_localctx).var_id.getLine() ); 
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(101);
				match(T__4);
				setState(102);
				((StateContext)_localctx).var_id = match(ID);
				 addLocalVar( (((StateContext)_localctx).var_id!=null?((StateContext)_localctx).var_id.getText():null),((StateContext)_localctx).var_type.return_type,((StateContext)_localctx).var_id.getLine() ); 
				}
				}
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(109);
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
		public Token recv_id;
		public TypeContext var_type;
		public Token var_id;
		public List<TerminalNode> NL() { return getTokens(AtalkParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(AtalkParser.NL, i);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(AtalkParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AtalkParser.ID, i);
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
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).enterReceiver(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).exitReceiver(this);
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
			 args.clear(); 
			setState(113);
			match(T__5);
			setState(114);
			((ReceiverContext)_localctx).recv_id = match(ID);
			setState(115);
			match(T__6);
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8 || _la==T__11) {
				{
				setState(116);
				((ReceiverContext)_localctx).var_type = type();
				setState(117);
				((ReceiverContext)_localctx).var_id = match(ID);
				 args.add((((ReceiverContext)_localctx).var_type!=null?_input.getText(((ReceiverContext)_localctx).var_type.start,((ReceiverContext)_localctx).var_type.stop):null)); addLocalVar( (((ReceiverContext)_localctx).var_id!=null?((ReceiverContext)_localctx).var_id.getText():null),((ReceiverContext)_localctx).var_type.return_type,((ReceiverContext)_localctx).var_id.getLine() ); 
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(119);
					match(T__4);
					setState(120);
					((ReceiverContext)_localctx).var_type = type();
					setState(121);
					((ReceiverContext)_localctx).var_id = match(ID);
					 args.add((((ReceiverContext)_localctx).var_type!=null?_input.getText(((ReceiverContext)_localctx).var_type.start,((ReceiverContext)_localctx).var_type.stop):null)); addLocalVar( (((ReceiverContext)_localctx).var_id!=null?((ReceiverContext)_localctx).var_id.getText():null),((ReceiverContext)_localctx).var_type.return_type,((ReceiverContext)_localctx).var_id.getLine() ); 
					}
					}
					setState(128);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(131);
			match(T__7);
			setState(132);
			match(NL);
			 
						try {
			            	addReceiver((((ReceiverContext)_localctx).recv_id!=null?((ReceiverContext)_localctx).recv_id.getText():null),args);
			            	PrintOut += "Receiver signature: " + new ReceiveType((((ReceiverContext)_localctx).recv_id!=null?((ReceiverContext)_localctx).recv_id.getText():null), args).getKey() + "\n";
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
					
			setState(134);
			statements();
			setState(135);
			match(T__3);
			setState(136);
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
		public List<TerminalNode> CONST_NUM() { return getTokens(AtalkParser.CONST_NUM); }
		public TerminalNode CONST_NUM(int i) {
			return getToken(AtalkParser.CONST_NUM, i);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type);
		int _la;
		try {
			setState(163);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(139);
				match(T__8);
				 Dim.clear(); 
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(141);
					match(T__9);
					setState(142);
					((TypeContext)_localctx).tmp = match(CONST_NUM);
					setState(143);
					match(T__10);
					 

								Dim.add( (((TypeContext)_localctx).tmp!=null?((TypeContext)_localctx).tmp.getText():null) ); 
								if(Integer.parseInt((((TypeContext)_localctx).tmp!=null?((TypeContext)_localctx).tmp.getText():null)) <= 0) {
									print(String.format("[Line #%d] Array size must be more than 0", ((TypeContext)_localctx).tmp.getLine() )); 
									IsThereErr = 1;
								}

								
					}
					}
					setState(149);
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
				setState(151);
				match(T__11);
				 Dim.clear(); 
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(153);
					match(T__9);
					setState(154);
					((TypeContext)_localctx).tmp = match(CONST_NUM);
					setState(155);
					match(T__10);
					 
								Dim.add( (((TypeContext)_localctx).tmp!=null?((TypeContext)_localctx).tmp.getText():null) ); 
								if(Integer.parseInt((((TypeContext)_localctx).tmp!=null?((TypeContext)_localctx).tmp.getText():null)) <= 0) {
									print(String.format("[Line #%d] Array size must be more than 0", ((TypeContext)_localctx).tmp.getLine() )); 
									IsThereErr = 1;
								}
									
					}
					}
					setState(161);
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
		public List<TerminalNode> NL() { return getTokens(AtalkParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(AtalkParser.NL, i);
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
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			 beginScope();
			setState(166);
			match(T__12);
			setState(167);
			match(NL);
			setState(168);
			statements();
			setState(169);
			match(T__3);
			setState(170);
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
		public List<TerminalNode> NL() { return getTokens(AtalkParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(AtalkParser.NL, i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).exitStatements(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__8) | (1L << T__11) | (1L << T__12) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__30) | (1L << T__33) | (1L << T__34) | (1L << T__36) | (1L << CONST_NUM) | (1L << CONST_CHAR) | (1L << CONST_STR) | (1L << NL) | (1L << ID))) != 0)) {
				{
				setState(175);
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
					setState(173);
					statement();
					}
					break;
				case NL:
					{
					setState(174);
					match(NL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(179);
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
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_statement);
		try {
			setState(189);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(180);
				stm_vardef();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(181);
				stm_assignment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(182);
				stm_foreach();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(183);
				stm_if_elseif_else();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(184);
				stm_quit();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(185);
				stm_break();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(186);
				stm_tell();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(187);
				stm_write();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(188);
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
		public TerminalNode NL() { return getToken(AtalkParser.NL, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(AtalkParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AtalkParser.ID, i);
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
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).enterStm_vardef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).exitStm_vardef(this);
		}
	}

	public final Stm_vardefContext stm_vardef() throws RecognitionException {
		Stm_vardefContext _localctx = new Stm_vardefContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_stm_vardef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			((Stm_vardefContext)_localctx).var_type = type();
			setState(192);
			((Stm_vardefContext)_localctx).var_id = match(ID);
			 addLocalVar( (((Stm_vardefContext)_localctx).var_id!=null?((Stm_vardefContext)_localctx).var_id.getText():null),((Stm_vardefContext)_localctx).var_type.return_type,((Stm_vardefContext)_localctx).var_id.getLine() ); 
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(194);
				match(T__13);
				setState(195);
				expr();
				}
			}

			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(198);
				match(T__4);
				setState(199);
				((Stm_vardefContext)_localctx).var_id = match(ID);
				 addLocalVar( (((Stm_vardefContext)_localctx).var_id!=null?((Stm_vardefContext)_localctx).var_id.getText():null),((Stm_vardefContext)_localctx).var_type.return_type,((Stm_vardefContext)_localctx).var_id.getLine() ); 
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(201);
					match(T__13);
					setState(202);
					expr();
					}
				}

				}
				}
				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(210);
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
		public List<TerminalNode> ID() { return getTokens(AtalkParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AtalkParser.ID, i);
		}
		public TerminalNode NL() { return getToken(AtalkParser.NL, 0); }
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
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).enterStm_tell(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).exitStm_tell(this);
		}
	}

	public final Stm_tellContext stm_tell() throws RecognitionException {
		Stm_tellContext _localctx = new Stm_tellContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_stm_tell);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << ID))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(213);
			match(T__16);
			setState(214);
			match(ID);
			setState(215);
			match(T__6);
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__30) | (1L << T__33) | (1L << T__34) | (1L << T__36) | (1L << CONST_NUM) | (1L << CONST_CHAR) | (1L << CONST_STR) | (1L << ID))) != 0)) {
				{
				setState(216);
				expr();
				setState(221);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(217);
					match(T__4);
					setState(218);
					expr();
					}
					}
					setState(223);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(226);
			match(T__7);
			setState(227);
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
		public TerminalNode NL() { return getToken(AtalkParser.NL, 0); }
		public Stm_writeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stm_write; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).enterStm_write(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).exitStm_write(this);
		}
	}

	public final Stm_writeContext stm_write() throws RecognitionException {
		Stm_writeContext _localctx = new Stm_writeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_stm_write);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			match(T__17);
			setState(230);
			match(T__6);
			setState(231);
			expr();
			setState(232);
			match(T__7);
			setState(233);
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
		public List<TerminalNode> NL() { return getTokens(AtalkParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(AtalkParser.NL, i);
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
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).enterStm_if_elseif_else(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).exitStm_if_elseif_else(this);
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
			setState(236);
			match(T__18);
			setState(237);
			expr();
			setState(238);
			match(NL);
			setState(239);
			statements();
			 endScope(); 
			setState(250);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19) {
				{
				{
				 beginScope(); 
				setState(242);
				match(T__19);
				setState(243);
				expr();
				setState(244);
				match(NL);
				setState(245);
				statements();
				 endScope(); 
				}
				}
				setState(252);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				 beginScope(); 
				setState(254);
				match(T__20);
				setState(255);
				match(NL);
				setState(256);
				statements();
				 endScope(); 
				}
			}

			setState(261);
			match(T__3);
			setState(262);
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
		public TerminalNode ID() { return getToken(AtalkParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(AtalkParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(AtalkParser.NL, i);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public Stm_foreachContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stm_foreach; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).enterStm_foreach(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).exitStm_foreach(this);
		}
	}

	public final Stm_foreachContext stm_foreach() throws RecognitionException {
		Stm_foreachContext _localctx = new Stm_foreachContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_stm_foreach);
		try {
			enterOuterAlt(_localctx, 1);
			{
			 beginScope(); 
			setState(265);
			match(T__21);
			setState(266);
			match(ID);
			setState(267);
			match(T__22);
			setState(268);
			expr();
			setState(269);
			match(NL);
			IsInFor = 1;
			setState(271);
			statements();
			setState(272);
			match(T__3);
			setState(273);
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
		public TerminalNode NL() { return getToken(AtalkParser.NL, 0); }
		public Stm_quitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stm_quit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).enterStm_quit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).exitStm_quit(this);
		}
	}

	public final Stm_quitContext stm_quit() throws RecognitionException {
		Stm_quitContext _localctx = new Stm_quitContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_stm_quit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			match(T__23);
			setState(278);
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
		public TerminalNode NL() { return getToken(AtalkParser.NL, 0); }
		public Stm_breakContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stm_break; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).enterStm_break(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).exitStm_break(this);
		}
	}

	public final Stm_breakContext stm_break() throws RecognitionException {
		Stm_breakContext _localctx = new Stm_breakContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_stm_break);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			match(T__24);
			setState(281);
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
		public TerminalNode NL() { return getToken(AtalkParser.NL, 0); }
		public Stm_assignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stm_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).enterStm_assignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).exitStm_assignment(this);
		}
	}

	public final Stm_assignmentContext stm_assignment() throws RecognitionException {
		Stm_assignmentContext _localctx = new Stm_assignmentContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_stm_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			expr();
			setState(285);
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
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
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
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).enterExpr_assign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).exitExpr_assign(this);
		}
	}

	public final Expr_assignContext expr_assign() throws RecognitionException {
		Expr_assignContext _localctx = new Expr_assignContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_expr_assign);
		try {
			setState(294);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(289);
				expr_or();
				setState(290);
				match(T__13);
				setState(291);
				expr_assign();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(293);
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
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).enterExpr_or(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).exitExpr_or(this);
		}
	}

	public final Expr_orContext expr_or() throws RecognitionException {
		Expr_orContext _localctx = new Expr_orContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_expr_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			expr_and();
			setState(297);
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
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).enterExpr_or_tmp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).exitExpr_or_tmp(this);
		}
	}

	public final Expr_or_tmpContext expr_or_tmp() throws RecognitionException {
		Expr_or_tmpContext _localctx = new Expr_or_tmpContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_expr_or_tmp);
		try {
			setState(304);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__25:
				enterOuterAlt(_localctx, 1);
				{
				setState(299);
				match(T__25);
				setState(300);
				expr_and();
				setState(301);
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
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).enterExpr_and(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).exitExpr_and(this);
		}
	}

	public final Expr_andContext expr_and() throws RecognitionException {
		Expr_andContext _localctx = new Expr_andContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_expr_and);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			expr_eq();
			setState(307);
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
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).enterExpr_and_tmp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).exitExpr_and_tmp(this);
		}
	}

	public final Expr_and_tmpContext expr_and_tmp() throws RecognitionException {
		Expr_and_tmpContext _localctx = new Expr_and_tmpContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_expr_and_tmp);
		try {
			setState(314);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__26:
				enterOuterAlt(_localctx, 1);
				{
				setState(309);
				match(T__26);
				setState(310);
				expr_eq();
				setState(311);
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
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).enterExpr_eq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).exitExpr_eq(this);
		}
	}

	public final Expr_eqContext expr_eq() throws RecognitionException {
		Expr_eqContext _localctx = new Expr_eqContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_expr_eq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
			expr_cmp();
			setState(317);
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
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).enterExpr_eq_tmp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).exitExpr_eq_tmp(this);
		}
	}

	public final Expr_eq_tmpContext expr_eq_tmp() throws RecognitionException {
		Expr_eq_tmpContext _localctx = new Expr_eq_tmpContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_expr_eq_tmp);
		int _la;
		try {
			setState(324);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__27:
			case T__28:
				enterOuterAlt(_localctx, 1);
				{
				setState(319);
				_la = _input.LA(1);
				if ( !(_la==T__27 || _la==T__28) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(320);
				expr_cmp();
				setState(321);
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
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).enterExpr_cmp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).exitExpr_cmp(this);
		}
	}

	public final Expr_cmpContext expr_cmp() throws RecognitionException {
		Expr_cmpContext _localctx = new Expr_cmpContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_expr_cmp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			expr_add();
			setState(327);
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
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).enterExpr_cmp_tmp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).exitExpr_cmp_tmp(this);
		}
	}

	public final Expr_cmp_tmpContext expr_cmp_tmp() throws RecognitionException {
		Expr_cmp_tmpContext _localctx = new Expr_cmp_tmpContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_expr_cmp_tmp);
		int _la;
		try {
			setState(334);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(329);
				_la = _input.LA(1);
				if ( !(_la==T__1 || _la==T__2) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(330);
				expr_add();
				setState(331);
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
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).enterExpr_add(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).exitExpr_add(this);
		}
	}

	public final Expr_addContext expr_add() throws RecognitionException {
		Expr_addContext _localctx = new Expr_addContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_expr_add);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			expr_mult();
			setState(337);
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
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).enterExpr_add_tmp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).exitExpr_add_tmp(this);
		}
	}

	public final Expr_add_tmpContext expr_add_tmp() throws RecognitionException {
		Expr_add_tmpContext _localctx = new Expr_add_tmpContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_expr_add_tmp);
		int _la;
		try {
			setState(344);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__29:
			case T__30:
				enterOuterAlt(_localctx, 1);
				{
				setState(339);
				_la = _input.LA(1);
				if ( !(_la==T__29 || _la==T__30) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(340);
				expr_mult();
				setState(341);
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
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).enterExpr_mult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).exitExpr_mult(this);
		}
	}

	public final Expr_multContext expr_mult() throws RecognitionException {
		Expr_multContext _localctx = new Expr_multContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_expr_mult);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
			expr_un();
			setState(347);
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
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).enterExpr_mult_tmp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).exitExpr_mult_tmp(this);
		}
	}

	public final Expr_mult_tmpContext expr_mult_tmp() throws RecognitionException {
		Expr_mult_tmpContext _localctx = new Expr_mult_tmpContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_expr_mult_tmp);
		int _la;
		try {
			setState(354);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__31:
			case T__32:
				enterOuterAlt(_localctx, 1);
				{
				setState(349);
				_la = _input.LA(1);
				if ( !(_la==T__31 || _la==T__32) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(350);
				expr_un();
				setState(351);
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
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).enterExpr_un(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).exitExpr_un(this);
		}
	}

	public final Expr_unContext expr_un() throws RecognitionException {
		Expr_unContext _localctx = new Expr_unContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_expr_un);
		int _la;
		try {
			setState(359);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
			case T__33:
				enterOuterAlt(_localctx, 1);
				{
				setState(356);
				_la = _input.LA(1);
				if ( !(_la==T__30 || _la==T__33) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(357);
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
				setState(358);
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
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).enterExpr_mem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).exitExpr_mem(this);
		}
	}

	public final Expr_memContext expr_mem() throws RecognitionException {
		Expr_memContext _localctx = new Expr_memContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_expr_mem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(361);
			expr_other();
			setState(362);
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
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).enterExpr_mem_tmp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).exitExpr_mem_tmp(this);
		}
	}

	public final Expr_mem_tmpContext expr_mem_tmp() throws RecognitionException {
		Expr_mem_tmpContext _localctx = new Expr_mem_tmpContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_expr_mem_tmp);
		try {
			setState(370);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(364);
				match(T__9);
				setState(365);
				expr();
				setState(366);
				match(T__10);
				setState(367);
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
		public TerminalNode CONST_NUM() { return getToken(AtalkParser.CONST_NUM, 0); }
		public TerminalNode CONST_CHAR() { return getToken(AtalkParser.CONST_CHAR, 0); }
		public TerminalNode CONST_STR() { return getToken(AtalkParser.CONST_STR, 0); }
		public TerminalNode ID() { return getToken(AtalkParser.ID, 0); }
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
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).enterExpr_other(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AtalkListener ) ((AtalkListener)listener).exitExpr_other(this);
		}
	}

	public final Expr_otherContext expr_other() throws RecognitionException {
		Expr_otherContext _localctx = new Expr_otherContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_expr_other);
		int _la;
		try {
			setState(395);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONST_NUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(372);
				match(CONST_NUM);
				}
				break;
			case CONST_CHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(373);
				match(CONST_CHAR);
				}
				break;
			case CONST_STR:
				enterOuterAlt(_localctx, 3);
				{
				setState(374);
				match(CONST_STR);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 4);
				{
				setState(375);
				match(ID);
				}
				break;
			case T__34:
				enterOuterAlt(_localctx, 5);
				{
				setState(376);
				match(T__34);
				setState(377);
				expr();
				setState(382);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(378);
					match(T__4);
					setState(379);
					expr();
					}
					}
					setState(384);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(385);
				match(T__35);
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 6);
				{
				setState(387);
				match(T__36);
				setState(388);
				match(T__6);
				setState(389);
				match(CONST_NUM);
				setState(390);
				match(T__7);
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 7);
				{
				setState(391);
				match(T__6);
				setState(392);
				expr();
				setState(393);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u0190\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\2\7\2J\n\2\f\2\16\2M\13\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\\\n\3\f\3\16\3_\13\3\3\3\3\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\7\4k\n\4\f\4\16\4n\13\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\177\n\5\f\5\16\5\u0082"+
		"\13\5\5\5\u0084\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\7\6\u0094\n\6\f\6\16\6\u0097\13\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7"+
		"\6\u00a0\n\6\f\6\16\6\u00a3\13\6\3\6\5\6\u00a6\n\6\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\b\3\b\7\b\u00b2\n\b\f\b\16\b\u00b5\13\b\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\5\t\u00c0\n\t\3\n\3\n\3\n\3\n\3\n\5\n\u00c7\n\n\3"+
		"\n\3\n\3\n\3\n\3\n\5\n\u00ce\n\n\7\n\u00d0\n\n\f\n\16\n\u00d3\13\n\3\n"+
		"\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00de\n\13\f\13\16\13\u00e1"+
		"\13\13\5\13\u00e3\n\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00fb\n\r\f\r\16\r\u00fe"+
		"\13\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0106\n\r\3\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\5\23"+
		"\u0129\n\23\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\5\25\u0133\n\25\3"+
		"\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\5\27\u013d\n\27\3\30\3\30\3\30"+
		"\3\31\3\31\3\31\3\31\3\31\5\31\u0147\n\31\3\32\3\32\3\32\3\33\3\33\3\33"+
		"\3\33\3\33\5\33\u0151\n\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\5\35"+
		"\u015b\n\35\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\5\37\u0165\n\37\3"+
		" \3 \3 \5 \u016a\n \3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u0175\n\"\3#"+
		"\3#\3#\3#\3#\3#\3#\3#\7#\u017f\n#\f#\16#\u0182\13#\3#\3#\3#\3#\3#\3#\3"+
		"#\3#\3#\3#\5#\u018e\n#\3#\2\2$\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(*,.\60\62\64\668:<>@BD\2\t\3\3++\4\2\21\22,,\3\2\36\37\3\2\4\5\3"+
		"\2 !\3\2\"#\4\2!!$$\2\u0199\2F\3\2\2\2\4P\3\2\2\2\6d\3\2\2\2\bq\3\2\2"+
		"\2\n\u00a5\3\2\2\2\f\u00a7\3\2\2\2\16\u00b3\3\2\2\2\20\u00bf\3\2\2\2\22"+
		"\u00c1\3\2\2\2\24\u00d6\3\2\2\2\26\u00e7\3\2\2\2\30\u00ed\3\2\2\2\32\u010a"+
		"\3\2\2\2\34\u0117\3\2\2\2\36\u011a\3\2\2\2 \u011e\3\2\2\2\"\u0121\3\2"+
		"\2\2$\u0128\3\2\2\2&\u012a\3\2\2\2(\u0132\3\2\2\2*\u0134\3\2\2\2,\u013c"+
		"\3\2\2\2.\u013e\3\2\2\2\60\u0146\3\2\2\2\62\u0148\3\2\2\2\64\u0150\3\2"+
		"\2\2\66\u0152\3\2\2\28\u015a\3\2\2\2:\u015c\3\2\2\2<\u0164\3\2\2\2>\u0169"+
		"\3\2\2\2@\u016b\3\2\2\2B\u0174\3\2\2\2D\u018d\3\2\2\2FK\b\2\1\2GJ\5\4"+
		"\3\2HJ\7+\2\2IG\3\2\2\2IH\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2LN\3\2"+
		"\2\2MK\3\2\2\2NO\b\2\1\2O\3\3\2\2\2PQ\7\3\2\2QR\7,\2\2RS\7\4\2\2ST\7("+
		"\2\2TU\7\5\2\2UV\7+\2\2VW\b\3\1\2W]\b\3\1\2X\\\5\6\4\2Y\\\5\b\5\2Z\\\7"+
		"+\2\2[X\3\2\2\2[Y\3\2\2\2[Z\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^`\3"+
		"\2\2\2_]\3\2\2\2`a\7\6\2\2ab\t\2\2\2bc\b\3\1\2c\5\3\2\2\2de\5\n\6\2ef"+
		"\7,\2\2fl\b\4\1\2gh\7\7\2\2hi\7,\2\2ik\b\4\1\2jg\3\2\2\2kn\3\2\2\2lj\3"+
		"\2\2\2lm\3\2\2\2mo\3\2\2\2nl\3\2\2\2op\7+\2\2p\7\3\2\2\2qr\b\5\1\2rs\b"+
		"\5\1\2st\7\b\2\2tu\7,\2\2u\u0083\7\t\2\2vw\5\n\6\2wx\7,\2\2x\u0080\b\5"+
		"\1\2yz\7\7\2\2z{\5\n\6\2{|\7,\2\2|}\b\5\1\2}\177\3\2\2\2~y\3\2\2\2\177"+
		"\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0084\3\2\2\2"+
		"\u0082\u0080\3\2\2\2\u0083v\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\3"+
		"\2\2\2\u0085\u0086\7\n\2\2\u0086\u0087\7+\2\2\u0087\u0088\b\5\1\2\u0088"+
		"\u0089\5\16\b\2\u0089\u008a\7\6\2\2\u008a\u008b\7+\2\2\u008b\u008c\b\5"+
		"\1\2\u008c\t\3\2\2\2\u008d\u008e\7\13\2\2\u008e\u0095\b\6\1\2\u008f\u0090"+
		"\7\f\2\2\u0090\u0091\7(\2\2\u0091\u0092\7\r\2\2\u0092\u0094\b\6\1\2\u0093"+
		"\u008f\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2"+
		"\2\2\u0096\u0098\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u00a6\b\6\1\2\u0099"+
		"\u009a\7\16\2\2\u009a\u00a1\b\6\1\2\u009b\u009c\7\f\2\2\u009c\u009d\7"+
		"(\2\2\u009d\u009e\7\r\2\2\u009e\u00a0\b\6\1\2\u009f\u009b\3\2\2\2\u00a0"+
		"\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a4\3\2"+
		"\2\2\u00a3\u00a1\3\2\2\2\u00a4\u00a6\b\6\1\2\u00a5\u008d\3\2\2\2\u00a5"+
		"\u0099\3\2\2\2\u00a6\13\3\2\2\2\u00a7\u00a8\b\7\1\2\u00a8\u00a9\7\17\2"+
		"\2\u00a9\u00aa\7+\2\2\u00aa\u00ab\5\16\b\2\u00ab\u00ac\7\6\2\2\u00ac\u00ad"+
		"\7+\2\2\u00ad\u00ae\b\7\1\2\u00ae\r\3\2\2\2\u00af\u00b2\5\20\t\2\u00b0"+
		"\u00b2\7+\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b0\3\2\2\2\u00b2\u00b5\3\2"+
		"\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\17\3\2\2\2\u00b5\u00b3"+
		"\3\2\2\2\u00b6\u00c0\5\22\n\2\u00b7\u00c0\5 \21\2\u00b8\u00c0\5\32\16"+
		"\2\u00b9\u00c0\5\30\r\2\u00ba\u00c0\5\34\17\2\u00bb\u00c0\5\36\20\2\u00bc"+
		"\u00c0\5\24\13\2\u00bd\u00c0\5\26\f\2\u00be\u00c0\5\f\7\2\u00bf\u00b6"+
		"\3\2\2\2\u00bf\u00b7\3\2\2\2\u00bf\u00b8\3\2\2\2\u00bf\u00b9\3\2\2\2\u00bf"+
		"\u00ba\3\2\2\2\u00bf\u00bb\3\2\2\2\u00bf\u00bc\3\2\2\2\u00bf\u00bd\3\2"+
		"\2\2\u00bf\u00be\3\2\2\2\u00c0\21\3\2\2\2\u00c1\u00c2\5\n\6\2\u00c2\u00c3"+
		"\7,\2\2\u00c3\u00c6\b\n\1\2\u00c4\u00c5\7\20\2\2\u00c5\u00c7\5\"\22\2"+
		"\u00c6\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00d1\3\2\2\2\u00c8\u00c9"+
		"\7\7\2\2\u00c9\u00ca\7,\2\2\u00ca\u00cd\b\n\1\2\u00cb\u00cc\7\20\2\2\u00cc"+
		"\u00ce\5\"\22\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00d0\3"+
		"\2\2\2\u00cf\u00c8\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1"+
		"\u00d2\3\2\2\2\u00d2\u00d4\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d4\u00d5\7+"+
		"\2\2\u00d5\23\3\2\2\2\u00d6\u00d7\t\3\2\2\u00d7\u00d8\7\23\2\2\u00d8\u00d9"+
		"\7,\2\2\u00d9\u00e2\7\t\2\2\u00da\u00df\5\"\22\2\u00db\u00dc\7\7\2\2\u00dc"+
		"\u00de\5\"\22\2\u00dd\u00db\3\2\2\2\u00de\u00e1\3\2\2\2\u00df\u00dd\3"+
		"\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2"+
		"\u00da\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5\7\n"+
		"\2\2\u00e5\u00e6\7+\2\2\u00e6\25\3\2\2\2\u00e7\u00e8\7\24\2\2\u00e8\u00e9"+
		"\7\t\2\2\u00e9\u00ea\5\"\22\2\u00ea\u00eb\7\n\2\2\u00eb\u00ec\7+\2\2\u00ec"+
		"\27\3\2\2\2\u00ed\u00ee\b\r\1\2\u00ee\u00ef\7\25\2\2\u00ef\u00f0\5\"\22"+
		"\2\u00f0\u00f1\7+\2\2\u00f1\u00f2\5\16\b\2\u00f2\u00fc\b\r\1\2\u00f3\u00f4"+
		"\b\r\1\2\u00f4\u00f5\7\26\2\2\u00f5\u00f6\5\"\22\2\u00f6\u00f7\7+\2\2"+
		"\u00f7\u00f8\5\16\b\2\u00f8\u00f9\b\r\1\2\u00f9\u00fb\3\2\2\2\u00fa\u00f3"+
		"\3\2\2\2\u00fb\u00fe\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd"+
		"\u0105\3\2\2\2\u00fe\u00fc\3\2\2\2\u00ff\u0100\b\r\1\2\u0100\u0101\7\27"+
		"\2\2\u0101\u0102\7+\2\2\u0102\u0103\5\16\b\2\u0103\u0104\b\r\1\2\u0104"+
		"\u0106\3\2\2\2\u0105\u00ff\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0107\3\2"+
		"\2\2\u0107\u0108\7\6\2\2\u0108\u0109\7+\2\2\u0109\31\3\2\2\2\u010a\u010b"+
		"\b\16\1\2\u010b\u010c\7\30\2\2\u010c\u010d\7,\2\2\u010d\u010e\7\31\2\2"+
		"\u010e\u010f\5\"\22\2\u010f\u0110\7+\2\2\u0110\u0111\b\16\1\2\u0111\u0112"+
		"\5\16\b\2\u0112\u0113\7\6\2\2\u0113\u0114\7+\2\2\u0114\u0115\b\16\1\2"+
		"\u0115\u0116\b\16\1\2\u0116\33\3\2\2\2\u0117\u0118\7\32\2\2\u0118\u0119"+
		"\7+\2\2\u0119\35\3\2\2\2\u011a\u011b\7\33\2\2\u011b\u011c\7+\2\2\u011c"+
		"\u011d\b\20\1\2\u011d\37\3\2\2\2\u011e\u011f\5\"\22\2\u011f\u0120\7+\2"+
		"\2\u0120!\3\2\2\2\u0121\u0122\5$\23\2\u0122#\3\2\2\2\u0123\u0124\5&\24"+
		"\2\u0124\u0125\7\20\2\2\u0125\u0126\5$\23\2\u0126\u0129\3\2\2\2\u0127"+
		"\u0129\5&\24\2\u0128\u0123\3\2\2\2\u0128\u0127\3\2\2\2\u0129%\3\2\2\2"+
		"\u012a\u012b\5*\26\2\u012b\u012c\5(\25\2\u012c\'\3\2\2\2\u012d\u012e\7"+
		"\34\2\2\u012e\u012f\5*\26\2\u012f\u0130\5(\25\2\u0130\u0133\3\2\2\2\u0131"+
		"\u0133\3\2\2\2\u0132\u012d\3\2\2\2\u0132\u0131\3\2\2\2\u0133)\3\2\2\2"+
		"\u0134\u0135\5.\30\2\u0135\u0136\5,\27\2\u0136+\3\2\2\2\u0137\u0138\7"+
		"\35\2\2\u0138\u0139\5.\30\2\u0139\u013a\5,\27\2\u013a\u013d\3\2\2\2\u013b"+
		"\u013d\3\2\2\2\u013c\u0137\3\2\2\2\u013c\u013b\3\2\2\2\u013d-\3\2\2\2"+
		"\u013e\u013f\5\62\32\2\u013f\u0140\5\60\31\2\u0140/\3\2\2\2\u0141\u0142"+
		"\t\4\2\2\u0142\u0143\5\62\32\2\u0143\u0144\5\60\31\2\u0144\u0147\3\2\2"+
		"\2\u0145\u0147\3\2\2\2\u0146\u0141\3\2\2\2\u0146\u0145\3\2\2\2\u0147\61"+
		"\3\2\2\2\u0148\u0149\5\66\34\2\u0149\u014a\5\64\33\2\u014a\63\3\2\2\2"+
		"\u014b\u014c\t\5\2\2\u014c\u014d\5\66\34\2\u014d\u014e\5\64\33\2\u014e"+
		"\u0151\3\2\2\2\u014f\u0151\3\2\2\2\u0150\u014b\3\2\2\2\u0150\u014f\3\2"+
		"\2\2\u0151\65\3\2\2\2\u0152\u0153\5:\36\2\u0153\u0154\58\35\2\u0154\67"+
		"\3\2\2\2\u0155\u0156\t\6\2\2\u0156\u0157\5:\36\2\u0157\u0158\58\35\2\u0158"+
		"\u015b\3\2\2\2\u0159\u015b\3\2\2\2\u015a\u0155\3\2\2\2\u015a\u0159\3\2"+
		"\2\2\u015b9\3\2\2\2\u015c\u015d\5> \2\u015d\u015e\5<\37\2\u015e;\3\2\2"+
		"\2\u015f\u0160\t\7\2\2\u0160\u0161\5> \2\u0161\u0162\5<\37\2\u0162\u0165"+
		"\3\2\2\2\u0163\u0165\3\2\2\2\u0164\u015f\3\2\2\2\u0164\u0163\3\2\2\2\u0165"+
		"=\3\2\2\2\u0166\u0167\t\b\2\2\u0167\u016a\5> \2\u0168\u016a\5@!\2\u0169"+
		"\u0166\3\2\2\2\u0169\u0168\3\2\2\2\u016a?\3\2\2\2\u016b\u016c\5D#\2\u016c"+
		"\u016d\5B\"\2\u016dA\3\2\2\2\u016e\u016f\7\f\2\2\u016f\u0170\5\"\22\2"+
		"\u0170\u0171\7\r\2\2\u0171\u0172\5B\"\2\u0172\u0175\3\2\2\2\u0173\u0175"+
		"\3\2\2\2\u0174\u016e\3\2\2\2\u0174\u0173\3\2\2\2\u0175C\3\2\2\2\u0176"+
		"\u018e\7(\2\2\u0177\u018e\7)\2\2\u0178\u018e\7*\2\2\u0179\u018e\7,\2\2"+
		"\u017a\u017b\7%\2\2\u017b\u0180\5\"\22\2\u017c\u017d\7\7\2\2\u017d\u017f"+
		"\5\"\22\2\u017e\u017c\3\2\2\2\u017f\u0182\3\2\2\2\u0180\u017e\3\2\2\2"+
		"\u0180\u0181\3\2\2\2\u0181\u0183\3\2\2\2\u0182\u0180\3\2\2\2\u0183\u0184"+
		"\7&\2\2\u0184\u018e\3\2\2\2\u0185\u0186\7\'\2\2\u0186\u0187\7\t\2\2\u0187"+
		"\u0188\7(\2\2\u0188\u018e\7\n\2\2\u0189\u018a\7\t\2\2\u018a\u018b\5\""+
		"\22\2\u018b\u018c\7\n\2\2\u018c\u018e\3\2\2\2\u018d\u0176\3\2\2\2\u018d"+
		"\u0177\3\2\2\2\u018d\u0178\3\2\2\2\u018d\u0179\3\2\2\2\u018d\u017a\3\2"+
		"\2\2\u018d\u0185\3\2\2\2\u018d\u0189\3\2\2\2\u018eE\3\2\2\2!IK[]l\u0080"+
		"\u0083\u0095\u00a1\u00a5\u00b1\u00b3\u00bf\u00c6\u00cd\u00d1\u00df\u00e2"+
		"\u00fc\u0105\u0128\u0132\u013c\u0146\u0150\u015a\u0164\u0169\u0174\u0180"+
		"\u018d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}