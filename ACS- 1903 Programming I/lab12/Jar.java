import java.util.ArrayList;
/** 
 * ACS-1903 Lab 12 Q7
 * Daljeet Singh 3169763
*/

public class Jar{
    // fields
    private String name;
    private ArrayList<Cookie> cookies;
    
    // constructor
    public Jar(String name){
        this.name = name;
        cookies = new ArrayList<Cookie>();
    }
    
    // getters and setters
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }

    public ArrayList<Cookie> getCookie(){
        return cookies;
    }
    
    public void setCookie(ArrayList<Cookie> cookies){
        this.cookies = cookies;
    }
    // other methods
    public void addCookie(Cookie cookies){
        this.cookies.add(cookies);
    }   
    public String toString(){
        String s = "My cookies: " + cookies;
        
        return s;
    }

}
