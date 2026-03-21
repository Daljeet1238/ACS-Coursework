/**
 * Daljeet Singh 3169763
 * ACS- 2947- 002
 * Lab -7
 */

public class RGBColor {
    private String color;
    private int red;
    private int blue;
    private int green;

    public RGBColor(String color, int red, int blue, int green){
        this.color = color;
        setRed(red);
        setBlue(blue);
        setGreen(green);
    }

    //getters and setters
    public String getColor(){
        return color;
    }

    public int getRed(){
        return red;
    }

    public int getBlue(){
        return blue;
    }

    public int getGreen(){
        return green;
    }

    public void setColor(String c){
        color = c;
    }

    public void setRed(int r){
        if(r < 0 || r > 255){
            throw new IllegalArgumentException("Value should be between 0 and 255");
        }
        this.red = r;
    }

    public void setBlue(int b){
        if(b < 0 || b > 255){
            throw new IllegalArgumentException("Value should be between 0 and 255");
        }
        this.blue = b;
    }

    public void setGreen(int g){
        if(g < 0 || g > 255){
            throw new IllegalArgumentException("Value should be between 0 and 255");
        }
        this.green = g;
    }

    @Override
    public boolean equals(Object o){
        if(this.getColor() != ((RGBColor) o).getColor()) return false;
        RGBColor other = (RGBColor) o;
        if(red != other.getRed()) return false;
        if(green != other.getGreen()) return false;
        if(blue != other.getBlue()) return false;

        return true;  
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(color + " ");
        sb.append("(");
        sb.append(red + ", ");
        sb.append(green + ", ");
        sb.append(blue + ")");

        return sb.toString();
    }
}
