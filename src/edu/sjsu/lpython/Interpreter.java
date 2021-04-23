package edu.sjsu.lpython;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import edu.sjsu.lpython.parser.LightPythonLexer;
import edu.sjsu.lpython.parser.LightPythonParser;

import java.io.FileInputStream;
import java.io.InputStream;

public class Interpreter {

    public static void main(String[] args) throws Exception {
        String inputFile = null;
        if (args.length>0) inputFile = args[0];
        InputStream is = System.in;
        if (inputFile!=null) is = new FileInputStream(inputFile);

        CharStream stream = CharStreams.fromStream(is);
        LightPythonLexer lexer = new LightPythonLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LightPythonParser parser = new LightPythonParser(tokens);
        ParseTree tree = parser.file_input(); // parse

        StatementBuilderVisitor builder = new StatementBuilderVisitor();
        Statement prog = builder.visit(tree);
        Environment e = new Environment();
        prog.evaluate(e);
        System.out.println(e);
    }

}
