// Generated from C:/Users/Paolo/IdeaProjects/untitled\g.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link gParser}.
 */
public interface gListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link gParser#prule}.
	 * @param ctx the parse tree
	 */
	void enterPrule(gParser.PruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#prule}.
	 * @param ctx the parse tree
	 */
	void exitPrule(gParser.PruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#s}.
	 * @param ctx the parse tree
	 */
	void enterS(gParser.SContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#s}.
	 * @param ctx the parse tree
	 */
	void exitS(gParser.SContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#c}.
	 * @param ctx the parse tree
	 */
	void enterC(gParser.CContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#c}.
	 * @param ctx the parse tree
	 */
	void exitC(gParser.CContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#r}.
	 * @param ctx the parse tree
	 */
	void enterR(gParser.RContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#r}.
	 * @param ctx the parse tree
	 */
	void exitR(gParser.RContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#o}.
	 * @param ctx the parse tree
	 */
	void enterO(gParser.OContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#o}.
	 * @param ctx the parse tree
	 */
	void exitO(gParser.OContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#n}.
	 * @param ctx the parse tree
	 */
	void enterN(gParser.NContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#n}.
	 * @param ctx the parse tree
	 */
	void exitN(gParser.NContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#d}.
	 * @param ctx the parse tree
	 */
	void enterD(gParser.DContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#d}.
	 * @param ctx the parse tree
	 */
	void exitD(gParser.DContext ctx);
}