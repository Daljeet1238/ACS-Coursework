/** 
 * ACS-1903 Lab 12 Q7
 * Daljeet Singh 3169763
*/
public class Cookie{
    // fields
    private String flavour;
    private Jar jar;
    
    // constructors
    public Cookie(){
        flavour = "unkown";
    }
    
    public Cookie(String flavour){
        this.flavour = flavour;
    }
    
    // getters and setters
    public String getFlavour(){
        return flavour;
    }
    
    public void setFlavour(String flavour){
        this.flavour = flavour;
    }

    public Jar getJar(){
        return jar;
    }
    
    public void setJar(Jar jar){
        this.jar = jar;
    }
    // other methods
    public String toString(){
        return flavour; 
    }
    
    
}
