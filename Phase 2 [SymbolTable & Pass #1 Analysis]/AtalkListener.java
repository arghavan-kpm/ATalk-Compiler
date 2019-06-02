// Generated from Atalk.g4 by ANTLR 4.7

	import java.util.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AtalkParser}.
 */
public interface AtalkListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AtalkParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(AtalkParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(AtalkParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkParser#actor}.
	 * @param ctx the parse tree
	 */
	void enterActor(AtalkParser.ActorContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkParser#actor}.
	 * @param ctx the parse tree
	 */
	void exitActor(AtalkParser.ActorContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkParser#state}.
	 * @param ctx the parse tree
	 */
	void enterState(AtalkParser.StateContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkParser#state}.
	 * @param ctx the parse tree
	 */
	void exitState(AtalkParser.StateContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkParser#receiver}.
	 * @param ctx the parse tree
	 */
	void enterReceiver(AtalkParser.ReceiverContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkParser#receiver}.
	 * @param ctx the parse tree
	 */
	void exitReceiver(AtalkParser.ReceiverContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(AtalkParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(AtalkParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(AtalkParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(AtalkParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(AtalkParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(AtalkParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(AtalkParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(AtalkParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkParser#stm_vardef}.
	 * @param ctx the parse tree
	 */
	void enterStm_vardef(AtalkParser.Stm_vardefContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkParser#stm_vardef}.
	 * @param ctx the parse tree
	 */
	void exitStm_vardef(AtalkParser.Stm_vardefContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkParser#stm_tell}.
	 * @param ctx the parse tree
	 */
	void enterStm_tell(AtalkParser.Stm_tellContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkParser#stm_tell}.
	 * @param ctx the parse tree
	 */
	void exitStm_tell(AtalkParser.Stm_tellContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkParser#stm_write}.
	 * @param ctx the parse tree
	 */
	void enterStm_write(AtalkParser.Stm_writeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkParser#stm_write}.
	 * @param ctx the parse tree
	 */
	void exitStm_write(AtalkParser.Stm_writeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkParser#stm_if_elseif_else}.
	 * @param ctx the parse tree
	 */
	void enterStm_if_elseif_else(AtalkParser.Stm_if_elseif_elseContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkParser#stm_if_elseif_else}.
	 * @param ctx the parse tree
	 */
	void exitStm_if_elseif_else(AtalkParser.Stm_if_elseif_elseContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkParser#stm_foreach}.
	 * @param ctx the parse tree
	 */
	void enterStm_foreach(AtalkParser.Stm_foreachContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkParser#stm_foreach}.
	 * @param ctx the parse tree
	 */
	void exitStm_foreach(AtalkParser.Stm_foreachContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkParser#stm_quit}.
	 * @param ctx the parse tree
	 */
	void enterStm_quit(AtalkParser.Stm_quitContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkParser#stm_quit}.
	 * @param ctx the parse tree
	 */
	void exitStm_quit(AtalkParser.Stm_quitContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkParser#stm_break}.
	 * @param ctx the parse tree
	 */
	void enterStm_break(AtalkParser.Stm_breakContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkParser#stm_break}.
	 * @param ctx the parse tree
	 */
	void exitStm_break(AtalkParser.Stm_breakContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkParser#stm_assignment}.
	 * @param ctx the parse tree
	 */
	void enterStm_assignment(AtalkParser.Stm_assignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkParser#stm_assignment}.
	 * @param ctx the parse tree
	 */
	void exitStm_assignment(AtalkParser.Stm_assignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(AtalkParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(AtalkParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkParser#expr_assign}.
	 * @param ctx the parse tree
	 */
	void enterExpr_assign(AtalkParser.Expr_assignContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkParser#expr_assign}.
	 * @param ctx the parse tree
	 */
	void exitExpr_assign(AtalkParser.Expr_assignContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkParser#expr_or}.
	 * @param ctx the parse tree
	 */
	void enterExpr_or(AtalkParser.Expr_orContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkParser#expr_or}.
	 * @param ctx the parse tree
	 */
	void exitExpr_or(AtalkParser.Expr_orContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkParser#expr_or_tmp}.
	 * @param ctx the parse tree
	 */
	void enterExpr_or_tmp(AtalkParser.Expr_or_tmpContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkParser#expr_or_tmp}.
	 * @param ctx the parse tree
	 */
	void exitExpr_or_tmp(AtalkParser.Expr_or_tmpContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkParser#expr_and}.
	 * @param ctx the parse tree
	 */
	void enterExpr_and(AtalkParser.Expr_andContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkParser#expr_and}.
	 * @param ctx the parse tree
	 */
	void exitExpr_and(AtalkParser.Expr_andContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkParser#expr_and_tmp}.
	 * @param ctx the parse tree
	 */
	void enterExpr_and_tmp(AtalkParser.Expr_and_tmpContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkParser#expr_and_tmp}.
	 * @param ctx the parse tree
	 */
	void exitExpr_and_tmp(AtalkParser.Expr_and_tmpContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkParser#expr_eq}.
	 * @param ctx the parse tree
	 */
	void enterExpr_eq(AtalkParser.Expr_eqContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkParser#expr_eq}.
	 * @param ctx the parse tree
	 */
	void exitExpr_eq(AtalkParser.Expr_eqContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkParser#expr_eq_tmp}.
	 * @param ctx the parse tree
	 */
	void enterExpr_eq_tmp(AtalkParser.Expr_eq_tmpContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkParser#expr_eq_tmp}.
	 * @param ctx the parse tree
	 */
	void exitExpr_eq_tmp(AtalkParser.Expr_eq_tmpContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkParser#expr_cmp}.
	 * @param ctx the parse tree
	 */
	void enterExpr_cmp(AtalkParser.Expr_cmpContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkParser#expr_cmp}.
	 * @param ctx the parse tree
	 */
	void exitExpr_cmp(AtalkParser.Expr_cmpContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkParser#expr_cmp_tmp}.
	 * @param ctx the parse tree
	 */
	void enterExpr_cmp_tmp(AtalkParser.Expr_cmp_tmpContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkParser#expr_cmp_tmp}.
	 * @param ctx the parse tree
	 */
	void exitExpr_cmp_tmp(AtalkParser.Expr_cmp_tmpContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkParser#expr_add}.
	 * @param ctx the parse tree
	 */
	void enterExpr_add(AtalkParser.Expr_addContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkParser#expr_add}.
	 * @param ctx the parse tree
	 */
	void exitExpr_add(AtalkParser.Expr_addContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkParser#expr_add_tmp}.
	 * @param ctx the parse tree
	 */
	void enterExpr_add_tmp(AtalkParser.Expr_add_tmpContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkParser#expr_add_tmp}.
	 * @param ctx the parse tree
	 */
	void exitExpr_add_tmp(AtalkParser.Expr_add_tmpContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkParser#expr_mult}.
	 * @param ctx the parse tree
	 */
	void enterExpr_mult(AtalkParser.Expr_multContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkParser#expr_mult}.
	 * @param ctx the parse tree
	 */
	void exitExpr_mult(AtalkParser.Expr_multContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkParser#expr_mult_tmp}.
	 * @param ctx the parse tree
	 */
	void enterExpr_mult_tmp(AtalkParser.Expr_mult_tmpContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkParser#expr_mult_tmp}.
	 * @param ctx the parse tree
	 */
	void exitExpr_mult_tmp(AtalkParser.Expr_mult_tmpContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkParser#expr_un}.
	 * @param ctx the parse tree
	 */
	void enterExpr_un(AtalkParser.Expr_unContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkParser#expr_un}.
	 * @param ctx the parse tree
	 */
	void exitExpr_un(AtalkParser.Expr_unContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkParser#expr_mem}.
	 * @param ctx the parse tree
	 */
	void enterExpr_mem(AtalkParser.Expr_memContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkParser#expr_mem}.
	 * @param ctx the parse tree
	 */
	void exitExpr_mem(AtalkParser.Expr_memContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkParser#expr_mem_tmp}.
	 * @param ctx the parse tree
	 */
	void enterExpr_mem_tmp(AtalkParser.Expr_mem_tmpContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkParser#expr_mem_tmp}.
	 * @param ctx the parse tree
	 */
	void exitExpr_mem_tmp(AtalkParser.Expr_mem_tmpContext ctx);
	/**
	 * Enter a parse tree produced by {@link AtalkParser#expr_other}.
	 * @param ctx the parse tree
	 */
	void enterExpr_other(AtalkParser.Expr_otherContext ctx);
	/**
	 * Exit a parse tree produced by {@link AtalkParser#expr_other}.
	 * @param ctx the parse tree
	 */
	void exitExpr_other(AtalkParser.Expr_otherContext ctx);
}