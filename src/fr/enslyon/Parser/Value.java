package fr.enslyon.Parser;

/**
 * Created by quentin on 16/04/15.
 */
public class Value<T> {
    final Object value;

    public Value(Object value) {
        this.value = value;
    }

    @SuppressWarnings("unchecked")
    public Item<T> asItem() {
        return (Item<T>) value;
    }
    @SuppressWarnings("unchecked")
    public SyntacticLinearCombination<T> asSyntacticLinearCombination() {
        return (SyntacticLinearCombination<T>)value;
    }


    @Override
    public int hashCode() {

        if(value == null) {
            return 0;
        }

        return this.value.hashCode();
    }

    @Override
    public boolean equals(Object o) {

        if(value == o) {
            return true;
        }

        if(value == null || o == null || o.getClass() != value.getClass()) {
            return false;
        }

        Value that = (Value)o;

        return this.value.equals(that.value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}