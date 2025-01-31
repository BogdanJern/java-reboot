package ru.sberbank.edu;

import java.util.Objects;

public class Person implements Comparable<Person>{
    private final String name;
    private final String city;
    private final int age;

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure {@link Integer#signum
     * signum}{@code (x.compareTo(y)) == -signum(y.compareTo(x))} for
     * all {@code x} and {@code y}.  (This implies that {@code
     * x.compareTo(y)} must throw an exception if and only if {@code
     * y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
     * {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code
     * x.compareTo(y)==0} implies that {@code signum(x.compareTo(z))
     * == signum(y.compareTo(z))}, for all {@code z}.
     *
     * @param other the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     * @apiNote It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
     * class that implements the {@code Comparable} interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     */
    @Override
    public int compareTo(Person other) {
        if(this.city.equalsIgnoreCase(other.city) && this.name.equalsIgnoreCase(other.name)){
            return  0;
        }
        if(this.city.equalsIgnoreCase(other.city)){
            return this.name.compareToIgnoreCase(other.name);
        }

        return this.city.compareToIgnoreCase(other.city);
    }
    public Person( String name, String city, int age ){
        this.name = name;
        this.city = city;
        this.age = age;
    }
    @Override
    public boolean equals(Object obj){

        if(obj == null)
            return false;

        if(this == obj)
            return true;

        if(!this.getClass().equals(obj.getClass())){
            return false;
        }

        Person other = (Person)obj;
        return this.name.equalsIgnoreCase(other.name) &&
                this.city.equalsIgnoreCase(other.city) &&
                this.age == other.age;
    }
    @Override
    public int hashCode(){
        return Objects.hash(name.toLowerCase(), city.toLowerCase(), age);
    }
    @Override
    public String toString(){
        return "Person{"+
                "name = "+ name +"/"+
                " city = "+ city +"/"+
                " age = "+ age + '}';
    }
}
