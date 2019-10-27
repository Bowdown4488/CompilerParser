import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

/**
 * A simple demo to show AST GUI with ANTLR
 * @see http://www.antlr.org/api/Java/org/antlr/v4/runtime/tree/gui/TreeViewer.html
 *
 * @author wangdq
 * 2014-5-24
 *
 */
public class parserMain {
    public static void main(String[] args) throws IOException {
        //prepare token stream
        String s = "testinput.txt";
        CharStream stream = fromFileName(s);
        Java8Lexer lexer  = new Java8Lexer(stream);
        TokenStream tokenStream = new CommonTokenStream(lexer);
        Java8Parser parser = new Java8Parser(tokenStream);

        SyntaxErrorListener listener = new SyntaxErrorListener();

        //HIDES ALL RED COMMENTS
        //parser.removeErrorListener(ConsoleErrorListener.INSTANCE);

        parser.addErrorListener(listener);
        //ArrayList<SyntaxError> SyEx = new ArrayList<>(listener.getSyntaxErrors());


        //show AST in console
        ParseTree tree = parser.compilationUnit();
        //System.out.println(tree.toStringTree(parser));

        // check syntax error class to see this function
        // maybe check the stuff within message and make a new message out of it
        listener.getSyntaxErrors().get(0).printALL();


        //show AST in GUI
        JFrame frame = new JFrame("Antlr AST");
        JPanel panel = new JPanel();
        TreeViewer viewr = new TreeViewer(Arrays.asList(
                parser.getRuleNames()),tree);
        //SIZE CHANGE HERE
        viewr.setScale(1);//scale a little
        //
        panel.add(viewr);

        JScrollPane scrollPane = new JScrollPane(panel);
        frame.add(scrollPane);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200,200);
        frame.setVisible(true);

    }
}
