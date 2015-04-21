package fr.enslyon;

import fr.enslyon.DivisionRing.DoubleDivisionRing;
import fr.enslyon.LinearCombination.DictionaryEntryException;
import fr.enslyon.LinearCombination.LinearCombinationException;
import fr.enslyon.SimplexAlgorithm.Dictionary;
import fr.enslyon.SimplexAlgorithm.Simplex;
import fr.enslyon.SimplexAlgorithm.SimplexOutput;
import fr.enslyon.gen.InputLexer;
import fr.enslyon.gen.InputParser;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args)
        throws DictionaryEntryException, LinearCombinationException
    {
        try {
            InputLexer lexer = new InputLexer(new ANTLRFileStream("/Users/quentin/Projet/LPSolver/MobilePhone.lp"));
            InputParser parser = new InputParser(new CommonTokenStream(lexer));
            parser.setBuildParseTree(true);
            ParseTree tree = parser.linearSystem();
            ParserVisitor visitor = new ParserVisitor();
            visitor.visit(tree);

            LinearProgram<Double> lp = visitor.getLinearProgram();

            DoubleDivisionRing ring = new DoubleDivisionRing();
            LinearProgramToDictionary<Double> lpConverter =
                    new LinearProgramToDictionary<Double>(lp, ring);

            lpConverter.makeUniform();

            HashMap<String, Integer> indexAssociatedToVariables = lpConverter.associateIndexToVariables();
            Dictionary<Double> dictionary = lpConverter.convertToDictionary(indexAssociatedToVariables);

            System.out.println(lpConverter.getLinearProgram().toString());

            dictionary.printDictionary();

            Simplex<Double> s = new Simplex<Double>(dictionary, ring);
            SimplexOutput<Double> solution = s.solve();

            solution.print();


        }
        catch (IOException e) {
            System.err.println("IO error");
        }
        catch(java.lang.NumberFormatException e) {
            System.err.println("Syntax error");
            System.err.println(e.getMessage());
        }


    }
}