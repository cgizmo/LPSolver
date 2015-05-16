package fr.enslyon.Parser;

import java.util.ArrayList;

/**
 * Created by quentin on 16/04/15.
 */
public class Inequalities<T> {
    private ArrayList<Inequality<T>> inequalities;
    Inequalities() {
        inequalities = new ArrayList<Inequality<T>>();
    }
    public void add(Inequality<T> inequality) {
        inequalities.add(inequality);
    }
    public Inequality<T> get(int index) {
        return inequalities.get(index);
    }
    public int size() {
        return inequalities.size();
    }
    public String toString() {
        String output = "";
        for(Inequality<T> inequality: inequalities) {
            output += inequality.toString() + "\n";
        }
        return output;
    }
}
