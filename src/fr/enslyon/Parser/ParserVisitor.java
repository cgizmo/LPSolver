package fr.enslyon.Parser;

import fr.enslyon.DivisionRing.DivisionRing;
import fr.enslyon.Parser.gen.InputBaseVisitor;
import fr.enslyon.Parser.gen.InputParser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;


/**
 * Created by quentin on 16/04/15.
 */
public class ParserVisitor<T> extends InputBaseVisitor<Value<T>> {
    private DivisionRing<T> ring;
    LinearProgram<T> linearProgram = new LinearProgram<T>();

    public ParserVisitor(DivisionRing<T> ring) {
        this.ring = ring;
    }

    public LinearProgram<T> getLinearProgram() {
        return linearProgram;
    }

    private T readFloat(ParseTree ctx) {
        return ring.fromString(ctx.getText());
    }

    @Override public Value<T> visitLinearSystem(InputParser.LinearSystemContext ctx) {
        Boolean isMaximize = ctx.objective().getText().equals("MAXIMIZE");

        SyntacticLinearCombination<T> linearObj =
                visitLinearCombination(ctx.linearCombination()).asSyntacticLinearCombination();

        Objective<T> objective = new Objective<T>(ring, isMaximize, linearObj);

        linearProgram.setObjective(objective);

        visitInequalities(ctx.inequalities());
        visitBounds(ctx.bounds());
        visitVariablesList(ctx.variablesList());


        return new Value<T>(null);
    }


    @Override public Value<T> visitLinearCombination(InputParser.LinearCombinationContext ctx) {
        SyntacticLinearCombination<T> l = new SyntacticLinearCombination<T>(ring);
        Boolean isPlus = true;
        for(ParseTree child: ctx.children) {
            if(child.getText().equals("+")) {
                isPlus = true;
            }
            else if(child.getText().equals("-")) {
                isPlus = false;
            }
            else {
                Value v = visit(child);
                @SuppressWarnings("unchecked")
                Item<T> item = v.asItem();
                if(!isPlus) {
                    item.setConstant(ring.opposite(item.getConstant()));
                }
                l.setOrUpdateVariable(item.getVariable(), item.getConstant());
            }
        }
        return new Value<T>(l);
    }

    @Override public Value<T> visitConstantAndVariableItem(@NotNull InputParser.ConstantAndVariableItemContext ctx) {
        T value = this.readFloat(ctx.Float());
        return new Value<T>(new Item<T>(ctx.Variable().getText(), value));
    }
    @Override public Value<T> visitConstantItem(@NotNull InputParser.ConstantItemContext ctx) {
        T value = this.readFloat(ctx.Float());
        return new Value<T>(new Item<T>(value));
    }
    @Override public Value<T> visitVariableItem(@NotNull InputParser.VariableItemContext ctx) {
        return new Value<T>(new Item<T>(ctx.Variable().getText(), ring.fromInteger(1)));
    }
    @Override public Value<T> visitFirstItem(InputParser.FirstItemContext ctx) {
        Item<T> item = visit(ctx.item()).asItem();
        if(ctx.getText().charAt(0) == '-' ) {
            item.setConstant(ring.opposite(item.getConstant()));
        }
        return new Value<T>(item);
    }


    @Override public Value<T> visitInequalities(InputParser.InequalitiesContext ctx) {
        Inequalities<T> inequalities = new Inequalities<T>();
        linearProgram.setInequalities(inequalities);
        for(ParseTree ctxChild: ctx.children) {
            visit(ctxChild);
        }
        return new Value<T>(null);
    }

    @Override public Value<T> visitInequality(InputParser.InequalityContext ctx) {
        SyntacticLinearCombination<T> l =
                visitLinearCombination(ctx.linearCombination()).asSyntacticLinearCombination();
        boolean isGreater = (ctx.comparisonOrEqual().getText().equals(">="));


        T constant = this.readFloat(ctx.Float());
        if(ctx.operator() != null) {
            if (ctx.operator().getText().equals("-")) {
                constant = ring.opposite(constant);
            }
        }

        Inequality<T> inequality = new Inequality<T>(ring, l, isGreater, constant);
        linearProgram.getInequalities().add(inequality);

        if(ctx.comparisonOrEqual().getText().equals("=")) {
            SyntacticLinearCombination<T> l2 =
                    visitLinearCombination(ctx.linearCombination()).asSyntacticLinearCombination();
            Inequality<T> inequality2 = new Inequality<T>(ring, l2, !isGreater, constant);
            linearProgram.getInequalities().add(inequality2);
        }

        return new Value<T>(null);

    }

    @Override public Value<T> visitBounds(InputParser.BoundsContext ctx) {
        Bounds<T> bounds = new Bounds<T>();
        linearProgram.setBounds(bounds);
        for(InputParser.BoundContext bound: ctx.bound()) {
            visit(bound);
        }
        return new Value<T>(null);
    }

    @Override public Value<T> visitUpperBound(InputParser.UpperBoundContext ctx) {
        String v = ctx.Variable().getText();
        T upper = this.readFloat(ctx.Float());
        Bound<T> bound = new Bound<T>(v);
        if(ctx.comparison().getText().equals("<="))
            bound.setUpperBound(upper);
        else
            bound.setLowerBound(upper);
        linearProgram.getBounds().add(bound);
        return new Value<T>(null);
    }
    @Override public Value<T> visitLowerBound(InputParser.LowerBoundContext ctx) {
        String v = ctx.Variable().getText();
        T lower = this.readFloat(ctx.Float());
        Bound<T> bound = new Bound<T>(v);
        if(ctx.comparison().getText().equals("<="))
            bound.setLowerBound(lower);
        else
            bound.setUpperBound(lower);

        linearProgram.getBounds().add(bound);
        return new Value<T>(null);
    }
    @Override public Value<T> visitLowerAndUpperBound(InputParser.LowerAndUpperBoundContext ctx) {
        String v = ctx.Variable().getText();
        T lower = this.readFloat(ctx.Float(0));
        T upper = this.readFloat(ctx.Float(1));
        Bound<T> bound = new Bound<T>(v);
        if(ctx.comparison(0).getText().equals("<=")) {
            bound.setLowerBound(lower);
            bound.setUpperBound(upper);
        }
        else {
            bound.setLowerBound(upper);
            bound.setUpperBound(lower);
        }

        linearProgram.getBounds().add(bound);
        return new Value<T>(null);
    }


    @Override public Value<T> visitVariablesList(InputParser.VariablesListContext ctx) {
        Variables vars = new Variables();
        for(ParseTree variable: ctx.children) {
            vars.add(variable.getText());
        }
        linearProgram.setVariables(vars);

        return new Value<T>(null);
    }
}
