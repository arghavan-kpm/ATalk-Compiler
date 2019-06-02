// Generated from AtalkPass2.g4 by ANTLR 4.7

	import java.util.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AtalkPass2Parser}.
 */
public interface AtalkPass2Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AtalkPass2Parser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(AtalkPass2Parser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass2Parser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(AtalkPass2Parser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass2Parser#actor}.
	 * @param ctx the parse tree
	 */
	void enterActor(AtalkPass2Parser.ActorContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass2Parser#actor}.
	 * @param ctx the parse tree
	 */
	void exitActor(AtalkPass2Parser.ActorContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass2Parser#state}.
	 * @param ctx the parse tree
	 */
	void enterState(AtalkPass2Parser.StateContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass2Parser#state}.
	 * @param ctx the parse tree
	 */
	void exitState(AtalkPass2Parser.StateContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass2Parser#receiver}.
	 * @param ctx the parse tree
	 */
	void enterReceiver(AtalkPass2Parser.ReceiverContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass2Parser#receiver}.
	 * @param ctx the parse tree
	 */
	void exitReceiver(AtalkPass2Parser.ReceiverContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass2Parser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(AtalkPass2Parser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass2Parser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(AtalkPass2Parser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass2Parser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(AtalkPass2Parser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass2Parser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(AtalkPass2Parser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass2Parser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(AtalkPass2Parser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass2Parser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(AtalkPass2Parser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass2Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(AtalkPass2Parser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass2Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(AtalkPass2Parser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass2Parser#stm_vardef}.
	 * @param ctx the parse tree
	 */
	void enterStm_vardef(AtalkPass2Parser.Stm_vardefContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass2Parser#stm_vardef}.
	 * @param ctx the parse tree
	 */
	void exitStm_vardef(AtalkPass2Parser.Stm_vardefContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass2Parser#stm_tell}.
	 * @param ctx the parse tree
	 */
	void enterStm_tell(AtalkPass2Parser.Stm_tellContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass2Parser#stm_tell}.
	 * @param ctx the parse tree
	 */
	void exitStm_tell(AtalkPass2Parser.Stm_tellContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass2Parser#stm_write}.
	 * @param ctx the parse tree
	 */
	void enterStm_write(AtalkPass2Parser.Stm_writeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass2Parser#stm_write}.
	 * @param ctx the parse tree
	 */
	void exitStm_write(AtalkPass2Parser.Stm_writeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass2Parser#stm_if_elseif_else}.
	 * @param ctx the parse tree
	 */
	void enterStm_if_elseif_else(AtalkPass2Parser.Stm_if_elseif_elseContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass2Parser#stm_if_elseif_else}.
	 * @param ctx the parse tree
	 */
	void exitStm_if_elseif_else(AtalkPass2Parser.Stm_if_elseif_elseContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass2Parser#stm_foreach}.
	 * @param ctx the parse tree
	 */
	void enterStm_foreach(AtalkPass2Parser.Stm_foreachContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass2Parser#stm_foreach}.
	 * @param ctx the parse tree
	 */
	void exitStm_foreach(AtalkPass2Parser.Stm_foreachContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass2Parser#stm_quit}.
	 * @param ctx the parse tree
	 */
	void enterStm_quit(AtalkPass2Parser.Stm_quitContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass2Parser#stm_quit}.
	 * @param ctx the parse tree
	 */
	void exitStm_quit(AtalkPass2Parser.Stm_quitContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass2Parser#stm_break}.
	 * @param ctx the parse tree
	 */
	void enterStm_break(AtalkPass2Parser.Stm_breakContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass2Parser#stm_break}.
	 * @param ctx the parse tree
	 */
	void exitStm_break(AtalkPass2Parser.Stm_breakContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass2Parser#stm_assignment}.
	 * @param ctx the parse tree
	 */
	void enterStm_assignment(AtalkPass2Parser.Stm_assignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass2Parser#stm_assignment}.
	 * @param ctx the parse tree
	 */
	void exitStm_assignment(AtalkPass2Parser.Stm_assignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(AtalkPass2Parser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(AtalkPass2Parser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass2Parser#expr_assign}.
	 * @param ctx the parse tree
	 */
	void enterExpr_assign(AtalkPass2Parser.Expr_assignContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass2Parser#expr_assign}.
	 * @param ctx the parse tree
	 */
	void exitExpr_assign(AtalkPass2Parser.Expr_assignContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass2Parser#expr_or}.
	 * @param ctx the parse tree
	 */
	void enterExpr_or(AtalkPass2Parser.Expr_orContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass2Parser#expr_or}.
	 * @param ctx the parse tree
	 */
	void exitExpr_or(AtalkPass2Parser.Expr_orContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass2Parser#expr_or_tmp}.
	 * @param ctx the parse tree
	 */
	void enterExpr_or_tmp(AtalkPass2Parser.Expr_or_tmpContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass2Parser#expr_or_tmp}.
	 * @param ctx the parse tree
	 */
	void exitExpr_or_tmp(AtalkPass2Parser.Expr_or_tmpContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass2Parser#expr_and}.
	 * @param ctx the parse tree
	 */
	void enterExpr_and(AtalkPass2Parser.Expr_andContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass2Parser#expr_and}.
	 * @param ctx the parse tree
	 */
	void exitExpr_and(AtalkPass2Parser.Expr_andContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass2Parser#expr_and_tmp}.
	 * @param ctx the parse tree
	 */
	void enterExpr_and_tmp(AtalkPass2Parser.Expr_and_tmpContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass2Parser#expr_and_tmp}.
	 * @param ctx the parse tree
	 */
	void exitExpr_and_tmp(AtalkPass2Parser.Expr_and_tmpContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass2Parser#expr_eq}.
	 * @param ctx the parse tree
	 */
	void enterExpr_eq(AtalkPass2Parser.Expr_eqContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass2Parser#expr_eq}.
	 * @param ctx the parse tree
	 */
	void exitExpr_eq(AtalkPass2Parser.Expr_eqContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass2Parser#expr_eq_tmp}.
	 * @param ctx the parse tree
	 */
	void enterExpr_eq_tmp(AtalkPass2Parser.Expr_eq_tmpContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass2Parser#expr_eq_tmp}.
	 * @param ctx the parse tree
	 */
	void exitExpr_eq_tmp(AtalkPass2Parser.Expr_eq_tmpContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass2Parser#expr_cmp}.
	 * @param ctx the parse tree
	 */
	void enterExpr_cmp(AtalkPass2Parser.Expr_cmpContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass2Parser#expr_cmp}.
	 * @param ctx the parse tree
	 */
	void exitExpr_cmp(AtalkPass2Parser.Expr_cmpContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass2Parser#expr_cmp_tmp}.
	 * @param ctx the parse tree
	 */
	void enterExpr_cmp_tmp(AtalkPass2Parser.Expr_cmp_tmpContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass2Parser#expr_cmp_tmp}.
	 * @param ctx the parse tree
	 */
	void exitExpr_cmp_tmp(AtalkPass2Parser.Expr_cmp_tmpContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass2Parser#expr_add}.
	 * @param ctx the parse tree
	 */
	void enterExpr_add(AtalkPass2Parser.Expr_addContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass2Parser#expr_add}.
	 * @param ctx the parse tree
	 */
	void exitExpr_add(AtalkPass2Parser.Expr_addContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass2Parser#expr_add_tmp}.
	 * @param ctx the parse tree
	 */
	void enterExpr_add_tmp(AtalkPass2Parser.Expr_add_tmpContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass2Parser#expr_add_tmp}.
	 * @param ctx the parse tree
	 */
	void exitExpr_add_tmp(AtalkPass2Parser.Expr_add_tmpContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass2Parser#expr_mult}.
	 * @param ctx the parse tree
	 */
	void enterExpr_mult(AtalkPass2Parser.Expr_multContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass2Parser#expr_mult}.
	 * @param ctx the parse tree
	 */
	void exitExpr_mult(AtalkPass2Parser.Expr_multContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass2Parser#expr_mult_tmp}.
	 * @param ctx the parse tree
	 */
	void enterExpr_mult_tmp(AtalkPass2Parser.Expr_mult_tmpContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass2Parser#expr_mult_tmp}.
	 * @param ctx the parse tree
	 */
	void exitExpr_mult_tmp(AtalkPass2Parser.Expr_mult_tmpContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass2Parser#expr_un}.
	 * @param ctx the parse tree
	 */
	void enterExpr_un(AtalkPass2Parser.Expr_unContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass2Parser#expr_un}.
	 * @param ctx the parse tree
	 */
	void exitExpr_un(AtalkPass2Parser.Expr_unContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass2Parser#expr_mem}.
	 * @param ctx the parse tree
	 */
	void enterExpr_mem(AtalkPass2Parser.Expr_memContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass2Parser#expr_mem}.
	 * @param ctx the parse tree
	 */
	void exitExpr_mem(AtalkPass2Parser.Expr_memContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass2Parser#expr_mem_tmp}.
	 * @param ctx the parse tree
	 */
	void enterExpr_mem_tmp(AtalkPass2Parser.Expr_mem_tmpContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass2Parser#expr_mem_tmp}.
	 * @param ctx the parse tree
	 */
	void exitExpr_mem_tmp(AtalkPass2Parser.Expr_mem_tmpContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass2Parser#expr_other}.
	 * @param ctx the parse tree
	 */
	void enterExpr_other(AtalkPass2Parser.Expr_otherContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass2Parser#expr_other}.
	 * @param ctx the parse tree
	 */
	void exitExpr_other(AtalkPass2Parser.Expr_otherContext ctx);
}