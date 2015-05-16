package fr.enslyon.Parser;

import fr.enslyon.Parser.Bound;

import java.util.ArrayList;

/**
 * Created by quentin on 17/04/15.
 */
public class Bounds<T> {
    private ArrayList<Bound<T>> bounds;
    Bounds() {
        bounds= new ArrayList<Bound<T>>();
    }
    public void add(Bound<T> bound) {
        bounds.add(bound);
    }
    public Bound<T> get(int index) {
        return bounds.get(index);
    }
    public int size() {
        return bounds.size();
    }
    public String toString() {
        String output = "";
        for(Bound<T> bound: bounds) {
            output += bound.toString() + "\n";
        }
        return output;
    }
}
