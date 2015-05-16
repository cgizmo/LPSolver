package fr.enslyon.Parser;

/**
 * Created by quentin on 16/04/15.
 */
public class LinearProgram<T> {
    private Variables variables;
    private Objective<T> objective;
    private Inequalities<T> inequalities;
    private Bounds<T> bounds;

    LinearProgram() {
        this.variables = new Variables();
        this.bounds = new Bounds<T>();
        this.inequalities = new Inequalities<T>();
    }
    public Inequalities<T>  getInequalities() {
        return this.inequalities;
    }
    public void setObjective(Objective<T> objective) {
        this.objective = objective;
    }

    public void setInequalities(Inequalities<T> inequalities) {
        this.inequalities = inequalities;
    }
    public void setVariables(Variables vars) {
        this.variables = vars;
    }
    public void setBounds(Bounds<T> bounds) {
        this.bounds = bounds;
    }
    public Objective<T> getObjective() {
        return this.objective;
    }
    public Variables getVariables() {
        return this.variables;
    }
    public Bounds<T> getBounds() {
        return this.bounds;
    }
    public String toString() {
        return String.format("%s\nSUBJECT TO\n%sBOUNDS\n%sVARIABLES\n%sEND",
                objective.toString(),
                inequalities.toString(),
                bounds.toString(),
                variables.toString());
    }

}
