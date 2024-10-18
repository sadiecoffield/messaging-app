import java.util.Scanner;
/**
 * Stores and displays the data required for the user's profile
 *
 * @author Sadie Coffield
 * @version (a version number or a date)
 */
public class UserProfile
{
    //fields of the UserProfile class
    private String userID;
    private String name; 
    private String phoneNumber;

    /**
     * Default constructor. Initialise fields to default values
     */
    public UserProfile()
    {
        userID = "";
        name = "";
        phoneNumber = "";
    }
    
    /**
     * Alternative constructor. Set fields to given values.
     */
    public UserProfile(String userID, String name, String phoneNumber)
    {
        //set fields to given values
        this.userID = userID;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    
    /**
     * Method to get the user's ID
     * 
     * @return The user's ID
     */
    public String getUserID()
    {
        return userID;
    }
    
    /**
     * Method to get the user's name
     * 
     * @return The user's name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Method to get the user's phone number
     * 
     * @return The user's telephone number
     */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    
    /**
     * Method to set the user's ID
     * 
     * @param newUserID The user's new ID
     */
    public void setUserID(String newUserID)
    {
        userID = newUserID;
    }
    
    /**
     * Method to set the user's name
     * 
     * @param newUserID The user's new name
     */
    public void setName(String newName)
    {
        name = newName;
    }
    
    /**
     * Method to set the user's phone number
     * 
     * @param newPhoneNumber The user's new phone number
     */
    public void setPhoneNumber(String newPhoneNumber)
    {
        phoneNumber = newPhoneNumber;
    }
    
    /**
     * Method to display the user's information
     */
    public int displayUserProfile()
    {
        Scanner s = new Scanner(System.in);
        boolean validChoiceProvided = false;
        int userChoice = 0;
        
        while (!validChoiceProvided)
        {
            System.out.println("");
            System.out.println("Your Profile:");
            System.out.println("");
            System.out.println("1. User ID: " + userID);
            System.out.println("2. Name: " + name);
            System.out.println("3. Telephone Number: " + phoneNumber);
            System.out.println("4. Exit");
            System.out.println("");
            
            System.out.println("To edit, enter the number of the field you would like to change, or enter 4 to exit: ");
            userChoice = s.nextInt();
            
            if ((userChoice >= 1) && (userChoice <= 4))
            {
                validChoiceProvided = true;
            }
            else
            {
                System.out.println("Please enter a valid choice");
            }
        }
        
        return userChoice;
    }
    
    /**
     * Method to edit the user's profile
     */
    public void editUserProfile()
    {
        Scanner s = new Scanner(System.in);
        
        boolean exitSelected = false;
        int userChoice = 0;
        
        while (!exitSelected)
        {
            userChoice = displayUserProfile();
            
            switch (userChoice)
            {
                case 1:
                    System.out.println("");
                    System.out.println("What would you like to change your user ID to? ");
                    userID = s.nextLine();
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("What would you like to change your name to?");
                    name = s.nextLine();
                    break;
                case 3: 
                    System.out.println("What would you like to change your phone number to?");
                    phoneNumber = s.nextLine();
                    break;
                case 4:
                    System.out.println("");
                    System.out.println("Exiting user profile...");
                    exitSelected = true;
                    break;
                
                default:
                    break;
            }
        }
    }
}
