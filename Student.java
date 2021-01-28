/**
 * Class to represent a student
 * 
 * @author Joshua Sawyer
 * @version 1.0
 */
public class Student
{
    // Static id to be incremented for each new student
    private static int STUDENT_ID = 0;
    // Students favourite flavour
    private String favFlavour;
    // The machine that the student is going to use
    private SnackMachine chosenMachine;
    // The id of the student
    private String id;
    // The students coin pocket
    private Pocket coinPocket;
    // The pack of crisps that the student has
    private PackOfCrisps pack;

    /**
     * Initializes the class fields
     * 
     * @param flavour the students favourite flavour
     * @param machine the SnackMachine that the student is going to use
     */
    public Student(String flavour, SnackMachine machine)
    {
        favFlavour = flavour;
        chosenMachine = machine;
        // ++STUDENT_ID increments STUDENT_ID by one, then uses its new value - on first use this will be 1
        id = "SID_" + ++STUDENT_ID;
        coinPocket = new Pocket(20);
        pack = null;
    }

    /**
     * Buys a pack of crisps from the machine as long as they have enough pennies and their favourite flavour is in stock
     */
    private void buyCrisps()
    {
        // If the student has enough money
        if (coinPocket.pennyCount() >= chosenMachine.getCost())
        {
            // If the machine has atleast 1 packet of the chosen flavour
            if (chosenMachine.countPacks(favFlavour) > 0)
            {
                // Insert coin from the students pocket chosenMachine.getCost() number of times
                for (int i = 0; i < chosenMachine.getCost(); i++)
                {
                    chosenMachine.insertMoney(coinPocket.removePenny());
                }
                pack = chosenMachine.buyPack(favFlavour);
            }
            else
            {
                System.out.println("No " + favFlavour + " crisps!");
            }
        }
        else
        {
            System.out.println("Not enough money!");
        }
    }

    /**
     * Eat a crisp from the crisp packet as long as the packet: exists, is open and isn't empty
     */
    public void snackTime()
    {
        // If pack exists
        if (pack != null)
        {
            // If pack is open
            if (!pack.isClosed())
            {
                // If pack isn't empty
                if (!pack.isEmpty())
                {
                    System.out.println(id + " is eating a " + pack.getFlavour() + " crisp!");
                    pack.eatCrisp();
                }
                else
                {
                    System.out.println(id + " is throwing away their finished packet!");
                    pack = null;
                }
            }
            else
            {
                System.out.println(id + " is opening a " + pack.getFlavour() + " pack of crisps!");
                pack.open();
            }
        }
        else
        {
            System.out.println(id + " is buying a pack of crisps!");
            buyCrisps();
        }
    }
}
