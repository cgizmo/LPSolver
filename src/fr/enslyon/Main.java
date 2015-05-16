package fr.enslyon;

import fr.enslyon.LinearCombination.DictionaryEntryException;
import fr.enslyon.LinearCombination.LinearCombinationException;

import java.io.IOException;

public class Main {
    public static void printUsage() {
        System.out.println("Usage: ./toto file.lp [-d | -h | -l | -double | -rationals | -latex]");
    }
    public static void main(String[] args)
        throws DictionaryEntryException, LinearCombinationException
    {
        try {

            if(args.length == 0) {
                printUsage();
                return;
            }
            String pathFile = "";
            String ring = "rationals";

            boolean debug = false;
            boolean latex = false;

            for(String s:args) {
                if (s.equals("-debug") || s.equals("-d") || s.equals("--debug")) {
                    debug = true;
                }
                else if (s.equals("-latex") || s.equals("-l") || s.equals("--latex")) {
                    latex = true;
                }
                else if (s.equals("-help") || s.equals("-h") || s.equals("--help")) {
                    printUsage();
                    return;
                }
                else if (s.equals("-double")|| s.equals("--double")) {
                    ring = "double";
                }
                else if (s.equals("-rationals")|| s.equals("--rationals") || s.equals("-r")) {
                    ring = "rationals";
                }
                else {
                    pathFile = s;
                }
            }

            FactorySolver.solve(pathFile, debug, latex, ring);

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