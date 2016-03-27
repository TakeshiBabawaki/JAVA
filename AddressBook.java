import java.util.ArrayList;
import java.util.Iterator;

/**
 * The class AddressBook provide information about address(es).
 * It lists address(es) entered in the program by a user.
 * 
 * @author Meneceur Samir
 * @version 1.0 (05 Feb. 2016)
 */

public class AddressBook { 
   //ArrayList holding String objects
   private ArrayList<String>addresses;

   /**
   *Constructor for objects of the class AddressBook.
   *Initialise the "addresses" field.
   */
  
   public AddressBook()
    {
        //An ArrayList to be used with the String objects
        addresses = new ArrayList<String>();
    } 
    
   /**
   *A Method to allow users to type addresses.
   *Method accepting one parameter of type String.
   *The parameter is an address from any kind (city, town etc.).
   */
   
   public void insertAddress(String address)
    {
 
        if(addresses.isEmpty()) {
            //Printed only for the 1st address entered by the user
            System.out.println("Congratulations, you have entered your first address");
    
         
        } else { 
            //Printed for the following address(es)
            System.out.println("Address successfully entered!");
        }
        
        addresses.add(address);
        
    }
    
   /**
   *A Method using an Iterator to output all addresses in the terminal window.
   *Addresses are listed in order they have been entered  by the user. 
   */
   
   public void listAddressesIterator()
    { 
        //Iterator using a String object to iterate addresses
        Iterator<String> it=addresses.iterator();
        
        int i=0;
        //integer to list addresses by order with numbers
        while(it.hasNext()){
            String address = it.next();
            i++;//increment the value of the integer i
            System.out.println("*******************************");
            System.out.println("Address " + i + ":" + address);
            System.out.println("*******************************");
           
        }
    } 
    
   /**
   *A Method using a "for each" loop to output all addresses. 
   *Addresses are listed in order they have been entered by the user.
   */

   public void listAddressesLoop ()
    { 
       int i=0;//integer to list addresses in order by number
       
       //"for each" loop using a String for the address(es)
       for(String address: addresses)
       
        //Printed when an address(es) is/are found 
        //++i to increment the result(s) found
        System.out.println("Address " + ++i + ":" + address);
                
    } 
    
   /**
   *A Method to allow users to search for addresses.
   *A "while" loop is used to iterate through the ArrayList.
   *@param searchString - the address searched.
   */
       
   public void search(String searchString) 
    { 
      //Iterator using a String object to iterate addresses
      Iterator<String> it=addresses.iterator();
      
      //while loop 
      while(it.hasNext()) 
        {
          String address = it.next();
            if (address.indexOf(searchString) >=0)//Indexing address(es) entered by the user 
          {
            // Printed if an address is contained in searchString
            System.out.println("Your Search returned: " + address);
            return;
          }
        }
        
      // Printed if an address is not contained in searchString
      System.out.println("Your Search did not return any result");
    }
}
