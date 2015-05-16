# LPSolver

A linear programming solver in Java.

## Installation and features

### To compile the solver:

    make   

### To launch it

    ./toto file.lp [OPTIONS]

   Example:
   
    ./toto lp_examples/mobilePhone.lp -rationals -debug


### Efficient mode

To use it on large entries, use it with doubles:

    time ./toto lp_examples/generated-100-10000.lp -double
    
Or:

    time ./totoopt lp_examples/generated-100-10000.lp
    
    
    ./toto lp_examples/generated-100-10000.lp -double  33.11s user 2.80s system 224% cpu 15.981 total


### To produce a pdf (only, of course, for small instances)

    ./totoprint file.lp [OPTIONS]

    It creates a pdf file ```out.pdf```

### Options


The OPTIONS are the following:

    * --double  -> use doubles to do the computation
    * --rationals -> use rationals
    * --latex -> output a latex file
    * --debug -> output every steps of the simplex algorithm


## How it works


This solver supports arbitrary division ring.
A division ring is defined in the ```DivisionRing``` module. To create a new division ring, you should implement the
interface ```DivisionRing<T>```.


The simplex algorithm is implemented in the ```SimplexAlgorithm``` module.
The file ```SimplexBase.java``` implements the second phase of the algorithm (when the initial dictionary represent an
effective solution).
The file ```Simplex.java``` implements the first phase (find an initial solution or return an empty domain).



The main data structure is defined in the module ```LinearCombination```: it represents the dictionary entries.
It based on native arrays (which are quite efficient, even in Java).
It's a sparse structure for inequalities, and a compact structure for variables.
Thanks to this structure, the solver supports linear program with 100 variables and 10 000 inequalities.

The parser (module ```Parser```) is realised with ANLTR (http://www.antlr.org/) and a Visitor Pattern
(see ```ParserVisitor.java```).

The classes ```Item```, ```Variables```, ```Bound```, ```Bounds```, ```Inequality```, ```Inequalities```, ```Objective``` and ```LinearProgram``` are a network of classes to represent the parsed linear program.

The class ```LinearProgramToSimplexEncapsulation``` takes a ```LinearProgram``` and make it uniform, ie on the following form:

    Maximize z0 + z1 * x1 + ...
    
    s.t.:
        a0 + a1 * x1 + ... <= c0
        b0 + b1 * x1 + ... <= c1
    ...
    
    with:
        x1 >= 0
        x2 >= 0
    ...


In order to do that, ```LinearProgramToSimplexEncapsulation```:

* transform a minimization problem into a maximization one.
* remove useless bounds
* transform greater inequalities into lesser inequalities
* translate bounds on the form: ```x_i >= a``` into ```x_i >= 0```
* introduce new variables when initial variables are unbounded



