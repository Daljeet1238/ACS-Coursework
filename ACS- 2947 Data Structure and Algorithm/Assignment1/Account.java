/**
 * ACS-2947 Assingment - 1
 * Daljeet Singh 3169763
 */

public class Account{
    private ArrayQueue<Double> shares;              //reference too the shares in the Arrayqueue
    private double totalValue;                      //reference to the total value of the shares
    private int totalShares;                        //reference to the total number of shares holds

    /**
     * constructor for the Account class
     */
    public Account(){
        shares = new ArrayQueue<>(); 
        totalValue = 0.0;
        totalShares = 0;
    }

    /**
     * method to buy the shares 
     * @param numShares number of shares to buy
     * @param pricePershare price of per share
     */
    public void buyShares(int numShares, double pricePershare){
        totalShares += numShares;
        totalValue += numShares * pricePershare;
        //adding the price per shares times the number of shares
        for(int i = 0; i < numShares; i++) {
            shares.enqueue(pricePershare);
        }
    }

    /**
     * method to sell the shares
     * @param numShares number of shares to sell
     * @param sellPrice represents the selling price of per share
     * @return capital which is gain or loss with the amount
     */
    public double sellShares(int numShares, double sellPrice){
        double capital = 0.0;
        if(numShares > totalShares){
            System.out.println("Not enough shares");
            return 0.0;
        }else{
            for(int i = 0; i < numShares; i++){
                double purchasePrice = shares.dequeue();
                capital += (sellPrice - purchasePrice);
                totalValue -= purchasePrice;
            }
            totalShares -= numShares;
            return capital;

        }
    }

    //getter for the total value
    public double getTotalValues(){
        return totalValue;
    }

    //getter for the total shares a person have
    public int getTotalShares(){
        return totalShares;
    }
}