package fr.enslyon.Parser;

import fr.enslyon.DivisionRing.DivisionRing;
import fr.enslyon.Parser.gen.InputLexer;
import fr.enslyon.Parser.gen.InputParser;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

/**
 * Created by quentin on 21/04/15.
 */
public class Parser<T> {
    public LinearProgram<T> parse(DivisionRing<T> ring, String file) throws IOException {

        InputLexer lexer = new InputLexer(new ANTLRFileStream(file));
        InputParser parser = new InputParser(new CommonTokenStream(lexer));
        parser.setBuildParseTree(true);
        ParseTree tree = parser.linearSystem();

        ParserVisitor<T> visitor = new ParserVisitor<T>(ring);
        visitor.visit(tree);

        return visitor.getLinearProgram();
    }
}
