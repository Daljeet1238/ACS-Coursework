
/**
 * Daljeet Singh 3169763
 * ACS-2947
 */

public class Pair <A,B>{
    
    //Declaring the private variable
    private A first;
    private B second;

    //Make the constructor
    public Pair(A a, B b){
        first = a;
        second = b;
    }

    //getters
    public A getFirst(){
        return first;
    }

    public B getSecond(){
        return second;
    }

    @Override
    //make the toString method using StringBuilder.
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(first);
        sb.append(second);

        return sb.toString();
    }
}
