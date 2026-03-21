
/**
 * Write a description of class valueb here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class valueb
{
   public static void main(String[] args) {
       String s= "Barbir & ken";
       int a= 4 , b = 3;
       a= a+s.indexOf(b);
       if(a<4) {
           b = b+s.indexOf('r');
       }
       else if(a<8) {
           b=b+s.indexOf('i');
       }
       else if(a<10){
           b=b+s.indexOf('&');
       }
       System.out.println(b);
   }
}
