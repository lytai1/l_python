// Generated from LightPython.g4 by ANTLR 4.9.2
 package edu.sjsu.lpython.parser; 
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LightPythonParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LightPythonVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LightPythonParser#single_input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingle_input(LightPythonParser.Single_inputContext ctx);
	/**
	 * Visit a parse tree produced by {@link LightPythonParser#file_input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile_input(LightPythonParser.File_inputContext ctx);
	/**
	 * Visit a parse tree produced by {@link LightPythonParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(LightPythonParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LightPythonParser#simple_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_stmt(LightPythonParser.Simple_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LightPythonParser#small_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSmall_stmt(LightPythonParser.Small_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LightPythonParser#assignment_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment_stmt(LightPythonParser.Assignment_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LightPythonParser#compound_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompound_stmt(LightPythonParser.Compound_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LightPythonParser#if_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_stmt(LightPythonParser.If_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LightPythonParser#while_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_stmt(LightPythonParser.While_stmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code suite1}
	 * labeled alternative in {@link LightPythonParser#suite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuite1(LightPythonParser.Suite1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code suite2}
	 * labeled alternative in {@link LightPythonParser#suite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuite2(LightPythonParser.Suite2Context ctx);
	/**
	 * Visit a parse tree produced by {@link LightPythonParser#test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTest(LightPythonParser.TestContext ctx);
	/**
	 * Visit a parse tree produced by {@link LightPythonParser#print_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint_stmt(LightPythonParser.Print_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LightPythonParser#aon_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAon_op(LightPythonParser.Aon_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link LightPythonParser#comp_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComp_op(LightPythonParser.Comp_opContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negposNum}
	 * labeled alternative in {@link LightPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegposNum(LightPythonParser.NegposNumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDivMod}
	 * labeled alternative in {@link LightPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivMod(LightPythonParser.MulDivModContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AtomTrailer}
	 * labeled alternative in {@link LightPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomTrailer(LightPythonParser.AtomTrailerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link LightPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(LightPythonParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link LightPythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(LightPythonParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link LightPythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(LightPythonParser.IntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code string}
	 * labeled alternative in {@link LightPythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(LightPythonParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolean}
	 * labeled alternative in {@link LightPythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean(LightPythonParser.BooleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code none}
	 * labeled alternative in {@link LightPythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNone(LightPythonParser.NoneContext ctx);
	/**
	 * Visit a parse tree produced by the {@code list}
	 * labeled alternative in {@link LightPythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(LightPythonParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code paren}
	 * labeled alternative in {@link LightPythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParen(LightPythonParser.ParenContext ctx);
	/**
	 * Visit a parse tree produced by {@link LightPythonParser#trailer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrailer(LightPythonParser.TrailerContext ctx);
	/**
	 * Visit a parse tree produced by {@link LightPythonParser#subscriptlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscriptlist(LightPythonParser.SubscriptlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link LightPythonParser#subscript}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscript(LightPythonParser.SubscriptContext ctx);
	/**
	 * Visit a parse tree produced by {@link LightPythonParser#sliceop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSliceop(LightPythonParser.SliceopContext ctx);
}