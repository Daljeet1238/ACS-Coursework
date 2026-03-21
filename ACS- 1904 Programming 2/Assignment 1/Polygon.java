import java.util.Arrays;

public class Polygon
{
    private double[][] points;
    
    public Polygon(double[][] points){
		// Your code goes here
    }
    
    private boolean checkDimensions(double[][] points){
        /* This method will check that all of the points in an array have the same dimensions (length) */
       // Your code goes here
    }
    public void append(Polygon p){
        /* The points of a second polygon to this polygon */
        // Your code goes here
    }
    
    public double[][] getPoints(){return this.points;}
    public void setPoints(double[][] points){
        // Your code goes here
    }
    
    public double calculateLength(){
        /* Calculate the total length of all the polygon's sides */
        // Your code goes here
    }
    
    public static double calculateDistance(double[] p1, double[] p2){
		/* Calculate the euclidean distance between two given points */
        // Your code goes here
    }
    
    public double[][] calculateBoundingBox(){
		/* Create a bounding box which contains the minimum values for each dimension, and the maximum values */
        // Your code goes here
    }
    
    public String toString(){
        return Arrays.deepToString(this.points);
    }
}
