import java.util.ArrayList;

/**
 * A simple model of an auction.
 * The auction maintains a list of lots of arbitrary length.
 *
 * @author David J. Barnes and Michael Kölling.
 * @version 2011.07.31
 * @Aauthor of the modification and assessment submitted Samir Meneceur
 * @version 1 
 * @date 2016.03.04
 */
public class Auction
{
    // The list of Lots in this auction.
    private ArrayList<Lot> lots;
    // The number that will be given to the next lot entered
    // into this auction.
    private int nextLotNumber;

    /**
     * Create a new auction.
     */
    //A Constructor initialising the object from the class Auction with no parameter
    public Auction()
    {
        lots = new ArrayList<Lot>();
        nextLotNumber = 1;
    }

    /**
     * Enter a new lot into the auction.
     * @param description A description of the lot.
     */
    //A method describing a lot
    public void enterLot(String description)
    {
        lots.add(new Lot(nextLotNumber, description));
        nextLotNumber++;
    }
    
    /**
     * Make a bid for a lot.
     * A message is printed indicating whether the bid is
     * successful or not.
     * 
     * @param lotNumber The lot being bid for.
     * @param bidder The person bidding for the lot.
     * @param value  The value of the bid.
     */
    //A method to get the lot number by a bidder, the value of the bid with a message printed wether successful or not
    public void makeABid(int lotNumber, Person bidder, long value)
    {
        Lot selectedLot = getLot(lotNumber);
        if(selectedLot != null) {
            Bid bid = new Bid(bidder, value);
            boolean successful = selectedLot.bidFor(bid);
            if(successful) {
                System.out.println("The bid for lot number " + lotNumber + " was successful.");
            } else {
                // Report which bid is higher.
                Bid highestBid = selectedLot.getHighestBid();
                System.out.println("Lot number: " + lotNumber + " already has a bid of: " + highestBid.getValue());
            }
        }
    }
    
    /**
    * Added a getUnsold() method to the Auction class
    * return a list of unsold lots
    */
   //A method listing unsold lots
   //A "foreach" loop is used to iterate through the "lots" ArrayList
   //It stores the unsold lots in a new ArrayList local variable
    public ArrayList<Lot>getUnsold()
    {
        ArrayList<Lot> unsold = new ArrayList<Lot>();
        for(Lot lot : lots) {
            Bid bid = lot.getHighestBid();
            if(bid == null) {
                unsold.add(lot);
            }
        }
        return unsold;
    }
    
    /**
     * Return the lot with the given number. Return null
     * if a lot with this number does not exist.
     * @param lotNumber The number of the lot to return.
     */
    //A method that returns a lot with its number by allowing the user to pass in an integer
    //This method will return null if the lot associated to this number doesn't exist
    //A "foreach" loop is used to iterate over the "lots" ArrayList
    public Lot getLot(int lotNumber)
    {
        for(Lot lot:lots) {
            if (lot.getNumber() == lotNumber) {
                return lot;
               //We can eventually add a System.out.println (); to print a message
            } else if 
                (lot.getNumber() > lotNumber) {
                    return null;
                   // We can eventually add  a System.out.println (); to print a message
            }
        }
        return lots.get(lotNumber);
    }
    
    /**
    * Show the full list of lots in this auction.
    */
   //A method that displays the lots listed in the auction 
    public void showLots()
    {
        for(Lot lot : lots) {
            System.out.println(lot.toString());
        }
    }
    
    /**Remove the lot with the given lot number.
    *@param number the number of the lot to be removed.
    *@return The Lot with the given number, or null of there is no such lot. 
    */
    //A method to remove a lot that print a confirmation when removed
    //If there is no lot matching its number or if it's larger, it will return null
    public Lot removeLot(int number) 
    {
        Lot lot = null;
        if ((number >=1))
        {
            lot = getLot(number);
        }
        
        if(lot !=null) 
        {
            lots.remove(lot);
            System.out.print("The Lot has been removed");
        
        }
        return lot;
    } 
    
    //A method using a "foreach" loop to scan the ArrayList
    //It close the auction and print a list of sold and unsold lots,their values and the bidder name 
    //An if statement is added within the loop to check if an item has on bid on it
    //It print the bidder name and its value if the conditions are met
    //if the conditions are not met, an else statement will print a message
    public void close()
    { 
        for(Lot lot: lots) 
        {
            int number = lot.getNumber();
            System.out.println("Lot Number: " + number);
            
            String lotName = lot.getDescription();
            System.out.println(lotName);
            
            Bid highestBid = lot.getHighestBid();
            if (highestBid !=null)
            {
              System.out.print("Sold to: " + highestBid.getBidder().getName());
              System.out.print(" for: € " + highestBid.getValue());
              System.out.println();
            } else {
            System.out.println("This Lot hasn't been sold");
            }
            
        }
        System.out.println("Auction now is closed");
    }
}

