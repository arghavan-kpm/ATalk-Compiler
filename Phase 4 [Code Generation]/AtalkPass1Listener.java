// Generated from AtalkPass1.g4 by ANTLR 4.7

	import java.util.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AtalkPass1Parser}.
 */
public interface AtalkPass1Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AtalkPass1Parser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(AtalkPass1Parser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass1Parser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(AtalkPass1Parser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass1Parser#actor}.
	 * @param ctx the parse tree
	 */
	void enterActor(AtalkPass1Parser.ActorContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass1Parser#actor}.
	 * @param ctx the parse tree
	 */
	void exitActor(AtalkPass1Parser.ActorContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass1Parser#state}.
	 * @param ctx the parse tree
	 */
	void enterState(AtalkPass1Parser.StateContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass1Parser#state}.
	 * @param ctx the parse tree
	 */
	void exitState(AtalkPass1Parser.StateContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass1Parser#receiver}.
	 * @param ctx the parse tree
	 */
	void enterReceiver(AtalkPass1Parser.ReceiverContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass1Parser#receiver}.
	 * @param ctx the parse tree
	 */
	void exitReceiver(AtalkPass1Parser.ReceiverContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass1Parser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(AtalkPass1Parser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass1Parser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(AtalkPass1Parser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass1Parser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(AtalkPass1Parser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass1Parser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(AtalkPass1Parser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass1Parser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(AtalkPass1Parser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass1Parser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(AtalkPass1Parser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass1Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(AtalkPass1Parser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass1Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(AtalkPass1Parser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass1Parser#stm_vardef}.
	 * @param ctx the parse tree
	 */
	void enterStm_vardef(AtalkPass1Parser.Stm_vardefContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass1Parser#stm_vardef}.
	 * @param ctx the parse tree
	 */
	void exitStm_vardef(AtalkPass1Parser.Stm_vardefContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass1Parser#stm_tell}.
	 * @param ctx the parse tree
	 */
	void enterStm_tell(AtalkPass1Parser.Stm_tellContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass1Parser#stm_tell}.
	 * @param ctx the parse tree
	 */
	void exitStm_tell(AtalkPass1Parser.Stm_tellContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass1Parser#stm_write}.
	 * @param ctx the parse tree
	 */
	void enterStm_write(AtalkPass1Parser.Stm_writeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass1Parser#stm_write}.
	 * @param ctx the parse tree
	 */
	void exitStm_write(AtalkPass1Parser.Stm_writeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass1Parser#stm_if_elseif_else}.
	 * @param ctx the parse tree
	 */
	void enterStm_if_elseif_else(AtalkPass1Parser.Stm_if_elseif_elseContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass1Parser#stm_if_elseif_else}.
	 * @param ctx the parse tree
	 */
	void exitStm_if_elseif_else(AtalkPass1Parser.Stm_if_elseif_elseContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass1Parser#stm_foreach}.
	 * @param ctx the parse tree
	 */
	void enterStm_foreach(AtalkPass1Parser.Stm_foreachContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass1Parser#stm_foreach}.
	 * @param ctx the parse tree
	 */
	void exitStm_foreach(AtalkPass1Parser.Stm_foreachContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass1Parser#stm_quit}.
	 * @param ctx the parse tree
	 */
	void enterStm_quit(AtalkPass1Parser.Stm_quitContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass1Parser#stm_quit}.
	 * @param ctx the parse tree
	 */
	void exitStm_quit(AtalkPass1Parser.Stm_quitContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass1Parser#stm_break}.
	 * @param ctx the parse tree
	 */
	void enterStm_break(AtalkPass1Parser.Stm_breakContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass1Parser#stm_break}.
	 * @param ctx the parse tree
	 */
	void exitStm_break(AtalkPass1Parser.Stm_breakContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass1Parser#stm_assignment}.
	 * @param ctx the parse tree
	 */
	void enterStm_assignment(AtalkPass1Parser.Stm_assignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass1Parser#stm_assignment}.
	 * @param ctx the parse tree
	 */
	void exitStm_assignment(AtalkPass1Parser.Stm_assignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(AtalkPass1Parser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(AtalkPass1Parser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass1Parser#expr_assign}.
	 * @param ctx the parse tree
	 */
	void enterExpr_assign(AtalkPass1Parser.Expr_assignContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass1Parser#expr_assign}.
	 * @param ctx the parse tree
	 */
	void exitExpr_assign(AtalkPass1Parser.Expr_assignContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass1Parser#expr_or}.
	 * @param ctx the parse tree
	 */
	void enterExpr_or(AtalkPass1Parser.Expr_orContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass1Parser#expr_or}.
	 * @param ctx the parse tree
	 */
	void exitExpr_or(AtalkPass1Parser.Expr_orContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass1Parser#expr_or_tmp}.
	 * @param ctx the parse tree
	 */
	void enterExpr_or_tmp(AtalkPass1Parser.Expr_or_tmpContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass1Parser#expr_or_tmp}.
	 * @param ctx the parse tree
	 */
	void exitExpr_or_tmp(AtalkPass1Parser.Expr_or_tmpContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass1Parser#expr_and}.
	 * @param ctx the parse tree
	 */
	void enterExpr_and(AtalkPass1Parser.Expr_andContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass1Parser#expr_and}.
	 * @param ctx the parse tree
	 */
	void exitExpr_and(AtalkPass1Parser.Expr_andContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass1Parser#expr_and_tmp}.
	 * @param ctx the parse tree
	 */
	void enterExpr_and_tmp(AtalkPass1Parser.Expr_and_tmpContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass1Parser#expr_and_tmp}.
	 * @param ctx the parse tree
	 */
	void exitExpr_and_tmp(AtalkPass1Parser.Expr_and_tmpContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass1Parser#expr_eq}.
	 * @param ctx the parse tree
	 */
	void enterExpr_eq(AtalkPass1Parser.Expr_eqContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass1Parser#expr_eq}.
	 * @param ctx the parse tree
	 */
	void exitExpr_eq(AtalkPass1Parser.Expr_eqContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass1Parser#expr_eq_tmp}.
	 * @param ctx the parse tree
	 */
	void enterExpr_eq_tmp(AtalkPass1Parser.Expr_eq_tmpContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass1Parser#expr_eq_tmp}.
	 * @param ctx the parse tree
	 */
	void exitExpr_eq_tmp(AtalkPass1Parser.Expr_eq_tmpContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass1Parser#expr_cmp}.
	 * @param ctx the parse tree
	 */
	void enterExpr_cmp(AtalkPass1Parser.Expr_cmpContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass1Parser#expr_cmp}.
	 * @param ctx the parse tree
	 */
	void exitExpr_cmp(AtalkPass1Parser.Expr_cmpContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass1Parser#expr_cmp_tmp}.
	 * @param ctx the parse tree
	 */
	void enterExpr_cmp_tmp(AtalkPass1Parser.Expr_cmp_tmpContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass1Parser#expr_cmp_tmp}.
	 * @param ctx the parse tree
	 */
	void exitExpr_cmp_tmp(AtalkPass1Parser.Expr_cmp_tmpContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass1Parser#expr_add}.
	 * @param ctx the parse tree
	 */
	void enterExpr_add(AtalkPass1Parser.Expr_addContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass1Parser#expr_add}.
	 * @param ctx the parse tree
	 */
	void exitExpr_add(AtalkPass1Parser.Expr_addContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass1Parser#expr_add_tmp}.
	 * @param ctx the parse tree
	 */
	void enterExpr_add_tmp(AtalkPass1Parser.Expr_add_tmpContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass1Parser#expr_add_tmp}.
	 * @param ctx the parse tree
	 */
	void exitExpr_add_tmp(AtalkPass1Parser.Expr_add_tmpContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass1Parser#expr_mult}.
	 * @param ctx the parse tree
	 */
	void enterExpr_mult(AtalkPass1Parser.Expr_multContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass1Parser#expr_mult}.
	 * @param ctx the parse tree
	 */
	void exitExpr_mult(AtalkPass1Parser.Expr_multContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass1Parser#expr_mult_tmp}.
	 * @param ctx the parse tree
	 */
	void enterExpr_mult_tmp(AtalkPass1Parser.Expr_mult_tmpContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass1Parser#expr_mult_tmp}.
	 * @param ctx the parse tree
	 */
	void exitExpr_mult_tmp(AtalkPass1Parser.Expr_mult_tmpContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass1Parser#expr_un}.
	 * @param ctx the parse tree
	 */
	void enterExpr_un(AtalkPass1Parser.Expr_unContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass1Parser#expr_un}.
	 * @param ctx the parse tree
	 */
	void exitExpr_un(AtalkPass1Parser.Expr_unContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass1Parser#expr_mem}.
	 * @param ctx the parse tree
	 */
	void enterExpr_mem(AtalkPass1Parser.Expr_memContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass1Parser#expr_mem}.
	 * @param ctx the parse tree
	 */
	void exitExpr_mem(AtalkPass1Parser.Expr_memContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass1Parser#expr_mem_tmp}.
	 * @param ctx the parse tree
	 */
	void enterExpr_mem_tmp(AtalkPass1Parser.Expr_mem_tmpContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass1Parser#expr_mem_tmp}.
	 * @param ctx the parse tree
	 */
	void exitExpr_mem_tmp(AtalkPass1Parser.Expr_mem_tmpContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkPass1Parser#expr_other}.
	 * @param ctx the parse tree
	 */
	void enterExpr_other(AtalkPass1Parser.Expr_otherContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkPass1Parser#expr_other}.
	 * @param ctx the parse tree
	 */
	void exitExpr_other(AtalkPass1Parser.Expr_otherContext ctx);
}