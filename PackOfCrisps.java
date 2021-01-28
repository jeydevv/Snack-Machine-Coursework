/**
 * Class to represent a single packet of crisps
 * 
 * @author Joshua Sawyer
 * @version 1.0
 */
public class PackOfCrisps
{
    // Whether or not the packet is open
    private boolean open;
    // The number of crisps left in the packet
    private int numOfCrisps;
    // The flavour of the crisp packet
    private String flavour;
    
    /**
     * Initializes all class fields
     * 
     * @param packFlavour the flavour of the packet
     */
    public PackOfCrisps(String packFlavour)
    {
        flavour = packFlavour;
        open = false;
        numOfCrisps = 10;
    }
    
    /**
     * Returns whether the packet is empty
     * 
     * @return true if packet is empty, false if not
     */
    public boolean isEmpty()
    {
        return (numOfCrisps == 0);
    }
    
    /**
     * Returns whether the packet is closed
     * 
     * @return true if the packet is closed, false if not
     */
    public boolean isClosed()
    {
        return !open;
    }
    
    /**
     * Opens the packet if it isn't already
     */
    public void open()
    {
        if (!open)
        {
            open = true;
        }
        else
        {
            System.out.println("The packet is already open!");
        }
    }
    
    /**
     * Returns the flavour of the packet
     * 
     * @return the flavour of the packet
     */
    public String getFlavour()
    {
        return flavour;
    }
    
    /**
     * Removes a single crisp if the packet is open and there's atleast 1 left
     */
    public void eatCrisp()
    {
        if (open)
        {
            if (numOfCrisps > 0)
            {
                numOfCrisps--;
            }
            else
            {
                System.out.println("The packet is empty!");
            }
        }
        else
        {
            System.out.println("Need to open the packet first!");
        }
    }
}
