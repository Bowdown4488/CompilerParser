import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import static org.antlr.v4.runtime.CharStreams.fromFileName;
import static org.antlr.v4.runtime.CharStreams.fromString;

public class parserMain {
    static public double SIZE = 1;
    public static void main(String[] args) throws IOException {
        //prepare token stream

        String s = "testinput.txt";
        CharStream stream = fromFileName(s);
        Java8Lexer lexer  = new Java8Lexer(stream);
        TokenStream tokenStream = new CommonTokenStream(lexer);
        Java8Parser parser = new Java8Parser(tokenStream);

        SyntaxErrorListener Slistener = new SyntaxErrorListener();

//        HIDES ALL RED COMMENTS
        parser.removeErrorListener(ConsoleErrorListener.INSTANCE);

        parser.addErrorListener(Slistener);
        //ArrayList<SyntaxError> SyEx = new ArrayList<>(Slistener.getSyntaxErrors());


        //show AST in console
        ParseTree tree = parser.compilationUnit();
        //System.out.println(tree.toStringTree(parser));

        // check syntax error class to see this function
        // maybe check the stuff within message and make a new message out of it
        //Slistener.getSyntaxErrors().get(0).printALL();
        for(int i = 0; i< Slistener.getSyntaxErrors().size();i++){
            System.out.println("ERROR # "+i);
            Slistener.getSyntaxErrors().get(i).printALL();
            System.out.println("_____________________________");
        }

        MyListener listener = new MyListener();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener,tree);





        //show AST in GUI
        //FRAME 1 CONTAINS TREE
        JFrame frame = new JFrame("Antlr Tree");
        frame.setLocation(600,0);
        JPanel panel = new JPanel();
        TreeViewer viewr = new TreeViewer(Arrays.asList(
                parser.getRuleNames()),tree);
        //SIZE CHANGE HERE
        viewr.setScale(SIZE);//scale a little
        //
        panel.add(viewr);
        JScrollPane scrollPane = new JScrollPane(panel);
        frame.add(scrollPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,400);
        frame.setVisible(true);

        //FRAME 2 CONTAINS ERROR
        JFrame frame2 = new JFrame("Antlr Errors");
        JPanel panel2 = new JPanel();
        JTextArea textarea = new JTextArea();
        panel2.add(textarea);
        textarea.setEditable(false);
        for(int i=0;i<Slistener.getSyntaxErrors().size();i++) {
            //System.out.println("Line " + Slistener.getSyntaxErrors().get(i).getLine());
            //System.out.println("Message: "+Slistener.getSyntaxErrors().get(i).getOffendingSymbol());
            String msg = Slistener.getSyntaxErrors().get(i).getMessage();
            String error = msg.split("'")[1];
            //System.out.println(msg.split("'")[0]);
            //System.out.println("Error symbols found: " + error);
            //System.out.println("_____________________________________________________________");
            if (msg.contains("missing")) {
                textarea.append("(Syntax error at line:" + Slistener.getSyntaxErrors().get(i).getLine() + ") " + "missing -> " + error + "\n");
            }
            else if (msg.contains("extraneous input")){
                textarea.append("(Syntax error at line:" + Slistener.getSyntaxErrors().get(i).getLine() + ") " + "extra character/s -> " + error + "\n");
            }
            else if(msg.contains("mismatched input")){
                textarea.append("(Syntax error at line:" + Slistener.getSyntaxErrors().get(i).getLine() + ") " + "unexpected -> " + error + "\n");
            }
            else if(msg.contains("no viable alternative at input")){
                String test = Slistener.getSyntaxErrors().get(i).getOffendingSymbol().toString();
                test = test.split("'")[1];
//                System.out.println(test);
                textarea.append("(Syntax error at line:" + Slistener.getSyntaxErrors().get(i).getLine() + ") " + "consider changing symbol in expression -> " + test + "\n");
            }
            else if(msg.contains("cannot find symbol")){
                textarea.append("(Syntax error at line:" + Slistener.getSyntaxErrors().get(i).getLine() + ") " + "missing symbol -> " + error + "\n");
            }
            else {
                textarea.append("(Syntax error at line:" + Slistener.getSyntaxErrors().get(i).getLine() + ") " + Slistener.getSyntaxErrors().get(i).getMessage() + "\n");
            }
        }
        JScrollPane scrollPane2 = new JScrollPane(panel2);
        frame2.add(scrollPane2);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(600,400);
        frame2.setLocation(0,400);
        frame2.setVisible(true);

        //FRAME 3 CONTAINS INPUT
        JFrame frame3 = new JFrame("Input Box");
        JPanel panel3 = new JPanel();
        JButton b1 = new JButton("run");
        JLabel message = new JLabel("Place input here");
        JTextArea input = new JTextArea("Delete all of this before typing Something");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                process(input.getText(),textarea,viewr);
                panel.repaint();
                panel.revalidate();
            }
        });

        panel3.add(b1);
        panel3.add(message);
        panel3.add(input);
        frame3.add(panel3);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setSize(600,400);
        frame3.setVisible(true);

    }

    /*
    static public void walk(MyListener listener, ParseTree t) {
        if ( t instanceof ErrorNode) {
            listener.visitErrorNode((ErrorNode)t);
            return;
        }
        else if ( t instanceof TerminalNode) {
            listener.visitTerminal((TerminalNode)t);
            return;
        }
        RuleNode r = (RuleNode)t;
        enterRule(listener, r);
        int n = r.getChildCount();
        for (int i = 0; i<n; i++) {
            walk(listener, r.getChild(i));
        }
        exitRule(listener, r);
    }
    */

    static public void process(String input, JTextArea errors,TreeViewer viewr){
        CharStream stream = fromString(input);
        Java8Lexer lexer  = new Java8Lexer(stream);
        TokenStream tokenStream = new CommonTokenStream(lexer);
        Java8Parser parser = new Java8Parser(tokenStream);

        SyntaxErrorListener listener = new SyntaxErrorListener();
        parser.addErrorListener(listener);
        ParseTree tree = parser.compilationUnit();

        errors.setText("");
        for(int i=0;i<listener.getSyntaxErrors().size();i++){
            String msg = listener.getSyntaxErrors().get(i).getMessage();
            String error = msg.split("'")[1];
            System.out.println(error);
            if (error.contains("missing")) {
                errors.append("(Syntax error at line:" + listener.getSyntaxErrors().get(i).getLine() + ") " + "missing " + error + "\n");
            } else {
                errors.append("(Syntax error at line:" + listener.getSyntaxErrors().get(i).getLine() + ") " + listener.getSyntaxErrors().get(i).getMessage() + "\n");
            }
        }

        viewr.setScale(SIZE);//scale a little
        viewr.setRuleNames(Arrays.asList(parser.getRuleNames()));
        viewr.setTree(tree);

    }
    /*
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();


        jButton1.setText("jButton1");

        jLabel1.setText("jLabel1");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

     */
}
