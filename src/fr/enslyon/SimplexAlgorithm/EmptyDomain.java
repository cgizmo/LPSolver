package fr.enslyon.SimplexAlgorithm;

/**
 * Created by quentin on 02/04/15.
 */
public class EmptyDomain<T> implements SimplexOutput<T> {
    @Override
    public void print() {
        System.out.println("The domain is empty");
    }
}
