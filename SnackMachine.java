import java.util.ArrayList;

/**
 * Class to represent a snack machine containing crisps
 * 
 * @author Joshua Sawyer
 * @version 1.0
 */
public class SnackMachine
{
    // The packets in the machine
    private ArrayList<PackOfCrisps> packets;
    // The capacity of the machine, cost of 1 packet and amount of money in the machine
    private int capacity, cost, payment;
    // The pennies in the machine
    private ArrayList<Penny> pennies;
    
    /**
     * Initializes class fields
     * 
     * @param maxCapacity the maximum capacity of the machine
     * @param packCost the cost of 1 packet of crisps
     */
    public SnackMachine(int maxCapacity, int packCost)
    {
        capacity = maxCapacity;
        cost = packCost;
        payment = 0;
        packets = new ArrayList<PackOfCrisps>();
        pennies = new ArrayList<Penny>();
    }
    
    /**
     * Returns the cost of a single packet of crisps
     * 
     * @return the cost of a single packet of crisps
     */
    public int getCost()
    {
        return cost;
    }
    
    /**
     * Adds a packet to the machine
     * 
     * @param pack the PackOfCrisps to add
     */
    public void addPack(PackOfCrisps pack)
    {
        if (packets.size() < capacity)
        {
            packets.add(pack);
        }
        else
        {
            System.out.println("Machine is already at capacity!");
        }
    }
    
    /**
     * Counts the amount of packets of a given flavour
     * 
     * @return number of packets with the given flavour
     * @param flavour the flavour of the packets to count
     */
    public int countPacks(String flavour)
    {
        int flavourCount = 0;
        for (PackOfCrisps curPack : packets)
        {
            if (curPack.getFlavour() == flavour)
            {
                flavourCount++;
            }
        }
        return flavourCount;
    }
    
    /**
     * Inserts a penny into the machine
     * 
     * @param penny the penny to insert
     */
    public void insertMoney(Penny penny)
    {
        pennies.add(penny);
        payment++;
    }
    
    /**
     * Purchases a pack of crisps from the machine as long as there is enough money and the desired flavour is in stock
     * 
     * @return the bought packet of crisps
     * @param flavour the flavour to buy
     */
    public PackOfCrisps buyPack(String flavour)
    {
        if (payment >= cost)
        {
            for (int i = 0; i < packets.size(); i++)
            {
                PackOfCrisps curPack = packets.get(i);
                if (curPack.getFlavour() == flavour)
                {
                    packets.remove(i);
                    payment = 0;
                    return curPack;
                }
            }
            System.out.println("There are no " + flavour + " crisps!");
            return null;
        }
        else
        {
            System.out.println("You need to insert more pennies!");
            return null;
        }
    }
    
    /**
     * Prints how many packets the machine holds and the amount of money in the machine
     */
    public void describe()
    {
        System.out.println("The snack machine has " + packets.size() + " packets of crisps left and has taken " + payment + " pennies in payment!");
    }
}
