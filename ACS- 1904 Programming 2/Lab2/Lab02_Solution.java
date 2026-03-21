
/**
 * A quick analysis of some search volumes in 2023-2024
 *
 * @author Jesse Harder
 * @version 1.0.0
 */
public class Lab02
{
    public static int calcMax(int[] a){
        int greatestIndex = 0; // Stores the index of the greatest value
        for(int i=1; i<a.length; i++){
            if(a[i] > a[greatestIndex]){
                greatestIndex = i;
            }
        }
        return greatestIndex;
    }

    public static double calcAverage(int[] a){
        double total = 0; // Sum up the array
        for(int i=0; i<a.length; i++){
            total += a[i];
        }
        return total / a.length; // Divide by the length (the number of values)
    }

    public static int calcMonthMax(int[][] a, int monthIndex){
        int greatestIndex = 0; // Stores the index of the greatest value
        for(int i=1; i<a.length; i++){
            if(a[i][monthIndex] > a[greatestIndex][monthIndex]){
                greatestIndex = i;
            }
        }
        return greatestIndex;
    }

    public static int calcMonthTotal(int[][] a, int monthIndex){
        int total = 0;
        for(int i=0; i<a.length; i++){
            total += a[i][monthIndex];
        }
        return total;
    }

    public static int calcGrandTotal(int[][] a){
        int total = 0;
        for(int i=0; i<a.length; i++){
            for(int j=0; j<a[i].length; j++){
                total += a[i][j];
            }
        }
        return total;
    }

    public static void main(String[] args){
        String[] months = {"Aug-23", "Sep-23", "Oct-23", "Nov-23", "Dec-23", "Jan-24", "Feb-24", "Mar-24", "Apr-24", "May-24", "Jun-24", "Jul-24"};
        String[] searchTerms = {"java", "c++", "sql", "javascript", "c#"};
        int[][] searchVols = {
            {201000, 200000, 200000, 201000, 201000, 246000, 450000, 201000, 201000, 201000, 201000, 201000},
            {60500, 74000, 74000, 60500, 49500, 74000, 74000, 60500, 60500, 49500, 49500, 49500},
            {135000, 135000, 135000, 135000, 110000, 165000, 135000, 135000, 135000, 135000, 110000, 110000},
            {201000, 201000, 201000, 165000, 165000, 201000, 201000, 165000, 165000, 165000, 135000, 165000},
            {40500, 40500, 33100, 33100, 27100, 40500, 33100, 33100, 33100, 33100, 27100, 27100}
        };

        System.out.println("Term analysis:");
        for(int i=0; i<searchTerms.length; i++){
            System.out.println("\t" + searchTerms[i] + ":");

            double avg = calcAverage(searchVols[i]);
            System.out.println("\t\tAverage: " + avg);

            String bestMonth = months[calcMax(searchVols[i])];
            System.out.println("\t\tBest Month: " + bestMonth);
        }

        System.out.println("Monthly analysis:");
        for(int i=0; i<months.length; i++){
            System.out.println("\t" + months[i] + ":");

            String bestTerm = searchTerms[calcMonthMax(searchVols, i)];
            System.out.println("\t\tBest Term: " + bestTerm);

            int bestMonth = calcMonthTotal(searchVols, i);
            System.out.println("\t\tTotal: " + bestMonth);
        }

        System.out.println("The grand total search volume is " + calcGrandTotal(searchVols));

    }
}
