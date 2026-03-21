import java.util.Arrays;

/**
 * This is a driver class for Assignment 01
 * It will instantiate and run some operations on Polygon objects
 */
public class Ass01
{
    public static void main(String[] args){
        // A 2 dimensional square
        System.out.println("Square:");
        double[][] sqPoints = {{0.0, 1.0}, {1.0, 1.0}, {1.0, 0.0}, {0.0, 0.0}};
        Polygon square = new Polygon(sqPoints);
        System.out.println("\tPoints: " + square);
        System.out.println("\tLength: " + square.calculateLength());
        System.out.println("\tBounding Box: " + Arrays.deepToString(square.calculateBoundingBox()));
        
        // A 2 dimensional triangle
        System.out.println("Triangle:");
        double[][] trPoints = {{-1.0, 0.0}, {-2.0, 0.0}, {-1.0, 1.0}};
        Polygon triangle = new Polygon(trPoints);
        System.out.println("\tPoints: " + triangle);
        System.out.println("\tLength: " + triangle.calculateLength());
        System.out.println("\tBounding Box: " + Arrays.deepToString(triangle.calculateBoundingBox()));
        
        // Combine the square and triangle into 1 2D poly
        System.out.println("Square append Triangle:");
        square.append(triangle);
        System.out.println("\tPoints: " + square);
        System.out.println("\tLength: " + square.calculateLength());
        System.out.println("\tBounding Box: " + Arrays.deepToString(square.calculateBoundingBox()));
        
        // A polygon in 3 dimensions
        System.out.println("3D Poly:");
        double[][] poly3Points = {{0.0, 1.0, 1.0}, {1.0, 1.0, 2.0}, {1.0, 0.0, 2.0}, {0.0, 0.0, 1.0}};
        Polygon poly3D = new Polygon(poly3Points);
        System.out.println("\tPoints: " + poly3D);
        System.out.println("\tLength: " + poly3D.calculateLength());
        System.out.println("\tBounding Box: " + Arrays.deepToString(poly3D.calculateBoundingBox()));
        
        // A polygon in n-dimensions  (n=5)
        System.out.println("n-Dimensional Poly:");
        double[][] polyNPoints = {{-6.5, 1.0, 1.0, 10.2, 5.0}, {-3.0, 1.0, 2.0, 10.0, 5.2}, {1.0, 0.0, 2.0, 8.8, 4.4}, {0.0, 0.0, 1.0, 8.0, 4.0}};
        Polygon polyN = new Polygon(polyNPoints);
        System.out.println("\tPoints: " + polyN);
        System.out.println("\tLength: " + polyN.calculateLength());
        System.out.println("\tBounding Box: " + Arrays.deepToString(polyN.calculateBoundingBox()));
        
        // A polygon where the points don't have a consistent dimension
        System.out.println("Broken Dimension Poly:");
        double[][] brokenPoints = {{-6.5, 1.0, 1.}, {-3.0}, {1.0, 0.0}};
        try{
            Polygon polyBroken = new Polygon(brokenPoints);
            System.out.println("\tPoints: " + polyN);
            System.out.println("\tLength: " + polyN.calculateLength());
            System.out.println("\tBounding Box: " + Arrays.deepToString(polyN.calculateBoundingBox()));
        }catch(IllegalArgumentException e){
            System.out.println("\tInvalid polygon");
        }
        
        // Try to merge a 2d poly with a 3d poly
        System.out.println("Append different dimensions:");
        try{
            triangle.append(poly3D);
            System.out.println("\tPoints: " + triangle);
            System.out.println("\tLength: " + triangle.calculateLength());
            System.out.println("\tBounding Box: " + Arrays.deepToString(triangle.calculateBoundingBox()));
        }catch(IllegalArgumentException e){
            System.out.println("\tInvalid polygon");
        }
        
    }
}
