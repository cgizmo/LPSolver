// Define a grammar called Hello



grammar Input;

@lexer::header {
     package fr.enslyon.gen;
}

@parser::header {
     package fr.enslyon.gen;
}

options {
    // antlr will generate java lexer and parser
    language = Java;
}



linearSystem  : objective linearCombination SUBJECTTO inequalities BOUNDS bounds VARIABLES variablesList END;
WS : [ \t\r\n]+ -> skip; // skip spaces, tabs, newlines


objective : MAXIMIZE | MINIMIZE;
MINIMIZE : 'MINIMIZE';
MAXIMIZE : 'MAXIMIZE';
SUBJECTTO : 'SUBJECT TO';
BOUNDS: 'BOUNDS';
VARIABLES: 'VARIABLES';
END: 'END';


linearCombination : firstItem (operator item)*;

item :
    Float Variable #constantAndVariableItem
  | Variable #variableItem
  | Float    #constantItem
  ;

firstItem: '-'? item;

inequalities: inequality*;
inequality:
     (linearCombination comparison '-'? Float);

bounds: bound*;

bound:
     Variable comparison Float #upperBound
   | Float comparison Variable #lowerBound
   | Float comparison Variable comparison Float #lowerAndUpperBound
   ;

variablesList:
     Variable*;

operator : Plus | Minus;


Plus : '+';
Minus : '-';

comparison: LessEqual | GreaterEqual;

LessEqual : '<=';
GreaterEqual : '>=';

Float : ('0'..'9')+ ('.' ('0'..'9')+ ( ('e' | 'E') ('0'..'9')+)*)?;
Variable : ('a'..'z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*;