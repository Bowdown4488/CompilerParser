// Generated from C:/Users/Paolo/IdeaProjects/untitled\g.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link gParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface gVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link gParser#prule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrule(gParser.PruleContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#s}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitS(gParser.SContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#c}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitC(gParser.CContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#r}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitR(gParser.RContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#o}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitO(gParser.OContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#n}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitN(gParser.NContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#d}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitD(gParser.DContext ctx);
}