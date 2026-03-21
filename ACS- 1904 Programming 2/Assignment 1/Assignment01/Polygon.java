/*
 * Daljeet Singh 3169763
 * 28th September 2024 
 */


import java.util.Arrays;

public class Polygon
{
    private double[][] points;
    
    public Polygon(double[][] points){
        this.points = points;
    }
    
    private boolean checkDimensions(double[][] points){
        /* This method will check that all of the points in an array have the same dimensions (length) */
        boolean valid = (points.length != 0); 
        if(!valid){
            return false;
        }
        
        double dimensions = points[0].length;
        
        for(int i = 0; i < points.length; i++){
           if(points[i].length != dimensions){
               return false;
           }
        }
        return true;
    }
    public void append(Polygon p){
        /* The points of a second polygon to this polygon */
        int dimension1 = this.points[0].length;
        int dimension2 = p.getPoints()[0].length;
        
        if(dimension1 == dimension2){
            int totalLength = this.points.length + p.getPoints().length;
            double [][] totalPoints = new double[totalLength][];
            
            for(int i = 0; i < this.points.length; i++){
                totalPoints[i] = this.points[i];
            }
            for(int i = 0; i < p.getPoints().length; i++){
                totalPoints[this.points.length + i] = p.getPoints()[i];
                
            }
            this.points = totalPoints;
        }else{
            throw new IllegalArgumentException("Polygens should have same number of dimensions.");
        }
    }
    
    public double[][] getPoints(){return this.points;}
    public void setPoints(double[][] points){
        this.points = points;
    }
    
    public double calculateLength(){
        /* Calculate the total length of all the polygon's sides */
        double totalLengths = 0;
        if(points.length == 0 || points[0].length == 0){
            throw new IllegalArgumentException("Polygons must be valid and contain the values");
        }else{
            for(int i = 0; i < points.length; i++){
                if(i == points.length - 1){
                totalLengths += calculateDistance(points[i], points[0]);
            }else{
                totalLengths += calculateDistance(points[i], points[i + 1]);
            }
            }
            
        }
        return totalLengths;
    }
    
    public static double calculateDistance(double[] p1, double[] p2){
        /* Calculate the euclidean distance between two given points */
        int d1 = p1.length;
        int d2 = p2.length;
        
        double sum = 0.0;
        if(d1 == d2){
            for( int i = 0; i < p1.length; i++){
                sum += Math.pow(p1[i] - p2[i], 2);
            }
            double value = Math.sqrt(sum);
            return value;
        }else{
            throw new IllegalArgumentException("Invalid polygon");
        }
    }
    
    public double[][] calculateBoundingBox(){
        /* Create a bounding box which contains the minimum values for each dimension, and the maximum values */
        int coordinates = points[0].length;
        
        double[] smallestPoint = new double[coordinates];
        double[] largestPoint = new double[coordinates];
        
        for(int i = 0; i < coordinates; i++){
            smallestPoint[i] = points[0][i];
            largestPoint[i] = points[0][i];  
        }
        for(int i = 1; i < points.length; i++){
            double[] point = points[i];
            for(int j = 0; j < coordinates; j++){
                smallestPoint[j] = Math.min(smallestPoint[j], point[j]);
                largestPoint[j] = Math.max(largestPoint[j], point[j]);
            }
        }
        return new double[][] {smallestPoint, largestPoint};
    }
    
    public String toString(){
        return Arrays.deepToString(this.points);
    }
}
