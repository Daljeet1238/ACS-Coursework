
/**
 * Daljeet Singh 3169763
 * ACS-2947
 */

public class Duo <T> {

    //Declare the private variable.
    private T thing1;
    private T thing2;

    //Make the constructor for the class.
    public Duo(T t1, T t2){
        thing1 = t1;
        thing2 = t2;
    }

    //getters and setter 
    public T getThing1(){
        return thing1;
    }

    public void setThing1(T t1){
        thing1 = t1;
    }

    public T getThing2(){
        return thing2;
    }

    public void setThing2(T t2){
        thing2 = t2;
    }

    @Override
    //Make the toString Method for the class.
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(thing1);
        sb.append(" & ");
        sb.append(thing2);
        sb.append("]");

        return sb.toString();
    }
}
