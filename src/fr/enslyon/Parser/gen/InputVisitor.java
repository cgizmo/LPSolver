// Generated from /Users/quentin/Projet/LPSolver/src/fr/enslyon/Parser/Input.g4 by ANTLR 4.5

     package fr.enslyon.Parser.gen;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link InputParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface InputVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link InputParser#linearSystem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLinearSystem(@NotNull InputParser.LinearSystemContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#objective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjective(@NotNull InputParser.ObjectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#linearCombination}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLinearCombination(@NotNull InputParser.LinearCombinationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constantAndVariableItem}
	 * labeled alternative in {@link InputParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantAndVariableItem(@NotNull InputParser.ConstantAndVariableItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variableItem}
	 * labeled alternative in {@link InputParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableItem(@NotNull InputParser.VariableItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constantItem}
	 * labeled alternative in {@link InputParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantItem(@NotNull InputParser.ConstantItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#firstItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFirstItem(@NotNull InputParser.FirstItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#inequalities}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInequalities(@NotNull InputParser.InequalitiesContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#inequality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInequality(@NotNull InputParser.InequalityContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#bounds}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBounds(@NotNull InputParser.BoundsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code upperBound}
	 * labeled alternative in {@link InputParser#bound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpperBound(@NotNull InputParser.UpperBoundContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lowerBound}
	 * labeled alternative in {@link InputParser#bound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLowerBound(@NotNull InputParser.LowerBoundContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lowerAndUpperBound}
	 * labeled alternative in {@link InputParser#bound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLowerAndUpperBound(@NotNull InputParser.LowerAndUpperBoundContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#variablesList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariablesList(@NotNull InputParser.VariablesListContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(@NotNull InputParser.OperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#comparisonOrEqual}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonOrEqual(@NotNull InputParser.ComparisonOrEqualContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(@NotNull InputParser.ComparisonContext ctx);
}