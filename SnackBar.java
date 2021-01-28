import java.util.Random;
import java.util.ArrayList;

/**
 * Class to represent a singular snack bar
 * 
 * @author Joshua Sawyer
 * @version 1.0
 */
public class SnackBar
{
    // Random class to generate random numbers
    private Random rand;
    // Array of possible crisp flavours
    private String[] flavours;
    // Machine that the students will use at the snack bar
    private SnackMachine machine;
    // List of students at the snack bar
    private ArrayList<Student> students;
    
    /**
     * The main function for program entry through the command line
     * 
     * @param args the arguments parsed in the command line
     */
    public static void main(String[] args)
    {
        if (args.length == 2)
        {
            // Tries to parse the arguments but if invalid just uses the defaults
            try
            {
                int students = Integer.parseInt(args[0]);
                int iterations = Integer.parseInt(args[1]);
                SnackBar bar = new SnackBar(students, 10, 5);
                bar.runSnackBar(iterations);
            }
            catch (Exception e)
            {
                System.out.println("Bad arguments! Using defaults...");
                SnackBar bar = new SnackBar(10, 10, 5);
                bar.runSnackBar(25);
            }
        }
        else
        {
            // The defaults
            SnackBar bar = new SnackBar(10, 10, 5);
            bar.runSnackBar(25);
        }
    }
    
    /**
     * Initializes and sets all class fields
     * 
     * @param numOfStudents the number of students in the snack bar
     * @param packetCount the amount of packets in the snack machine
     * @param packetCost the cost of a single packet of crisps
     */
    public SnackBar(int numOfStudents, int packetCount, int packetCost)
    {
        rand = new Random();
        flavours = new String[]{"salt and vinegar", "bbq beef", "ready salted", "prawn cocktail", "roast chicken"};

        machine = new SnackMachine(packetCount, packetCost);
        // Fills the machine with crisp packets
        for (int i = 0; i < packetCount; i++)
        {
            machine.addPack(new PackOfCrisps(randomFlavour()));
        }

        students = new ArrayList<Student>();
        // Fills the arraylist with students
        for (int i = 0; i < numOfStudents; i++)
        {
            students.add(new Student(randomFlavour(), machine));
        }
    }

    /**
     * Returns a random flavour
     * 
     * @return a random flavour
     */
    private String randomFlavour()
    {
        return flavours[rand.nextInt(flavours.length)];
    }

    /**
     * Prints a summary of the snack bar students and stock
     */
    public void describe()
    {
        System.out.println("The SnackBar has " + students.size() + " hungry students!");
        System.out.println("The SnackMachine has:");
        // Prints the amount of packets for every flavour
        for (int i = 0; i < flavours.length; i++)
        {
            System.out.println(machine.countPacks(flavours[i]) + " packets of " + flavours[i]);
        }
    }

    /**
     * Calls snackTime() on a random students nSteps number of times
     * 
     * @param nSteps the number of steps to run
     */
    public void runSnackBar(int nSteps)
    {
        for (int i = 0; i < nSteps; i++)
        {
            System.out.println("\nTime Step " + (i + 1));
            describe();
            // Gets random student and calls snackTimer()
            students.get(rand.nextInt(students.size())).snackTime();
        }
    }
}
