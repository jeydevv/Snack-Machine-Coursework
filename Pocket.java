import java.util.HashSet;
import java.util.Iterator;

/**
 * A class to represent a pocket to store pennies
 * 
 * @author Joshua Sawyer
 * @version 1.0
 */
public class Pocket
{
    // Hashset of Penny's to store all the pennies in the pocket
    private HashSet<Penny> pennies;
    
    /**
     * Initializes the class field
     * 
     * @param pocketSize the amount of pennies in the pocket
     */
    public Pocket(int pocketSize)
    {
        pennies = new HashSet<Penny>(pocketSize);
        // Fills the hashset with new Penny objects
        for (int i = 0; i < pocketSize; i++)
        {
            pennies.add(new Penny());
        }
    }
    
    /**
     * Returns the number of pennies in the pocket
     * 
     * @return the amount of pennies left in the pocket
     */
    public int pennyCount()
    {
        return pennies.size();
    }
    
    /**
     * Removes a single penny from the pocket
     * 
     * @return the removed penny
     */
    public Penny removePenny()
    {
        Iterator<Penny> itr = pennies.iterator();
        // If there is atleast 1 penny left in pennies, remove and return it
        if (itr.hasNext())
        {
            Penny tmpPenny = itr.next();
            pennies.remove(tmpPenny);
            return tmpPenny;
        }
        // Otherwise return null
        return null;
    }
}
