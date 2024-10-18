import java.util.Scanner; 
import java.util.InputMismatchException; 
import javafx.scene.Node;

/**
 * Write a description of class Tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tester
{

private String Message; 
private String  UserProfile;
private String contactTree; 
private String Files;
private Node treeNode; 
private String userID; 
private String Name;
private String phoneNumber; 
/**
 * Default constructor 
 */
public Tester() 
{
    Message= "";
    contactTree= "";
    UserProfile= "";
    Files = ""; 
}

// default constructor 

public void functionInit(String message, String contact, String userProfile)
{
    this.Message = message;
    this.contactTree = contactTree;
    this.UserProfile = UserProfile; 
    this.Files = Files; 
}
// process tester functionalities 
private void process()

{
    runTestMenu(); 
}

private void runAutomatedTests()
{
    
}

// initilise tester functionalities 
private void init()
{
    treeNode = new Node(); 
}

private void runTestMenu()
{
    String choice; 
    boolean exit=false; 
    
    System.out.println("List Menu"); 
    System.out.println("1.View or edit your profile");
    System.out.println("2.View your contacts");
    System.out.println("3.Create a new contact");
    System.out.println("4.Exit Menu");
    
    choice = getString("Please choose a number and press enter"); 
    
    // Depending on the choice, you may need to call different methods 
    switch (choice)
    {
        case "1":
            // view or edit profile method 
            break;
        case "2":
            // View contacts method
            break;
        case "3":
            // Creat new contact method
            break;
        case "4":
            exit = true; 
            break; 
            default:
                System.out.println("You have entered an invalid choice");
                break; 
    }
    if(!exit)
    {
        // call menu again if user didnt choose to exit 
        runTestMenu(); 
    }
    
}

private String getString(String prompt)
{
    Scanner scanner = new Scanner(System.in);
    System.out.println(prompt);
    return scanner.nextLine();
}

public static void main(String args[])
{
    Tester test = new Tester();
    test.init();
    test.process();
}

public String getMessage()
{
    return Message;
}

public String getUserProfile()
{
    return UserProfile; 
}

public String getcontactTree()
{
    return contactTree;
}

public String getFiles()
{
    return Files;
}

public String getuserID()
{
    return userID;
}

public String getName()
{
    return Name;
}

public String getphoneNumber()
{
    return phoneNumber; 
}
//Method to find something 
private void find()
{
    String userID;
    String name;
    String phoneNumber; 
    treeNode foundNode; 
    
    userID = getString("Please enter user ID number");
    foundNode = treeNode.findInNode(userID); 
    if (foundNode != null)
    System.out.println("User ID number entered has name and phone number: " +foundNode.getName() + foundNode.getphoneNumber()); 
    
    else 
    System.out.println("User ID number entered is not valid. Please try again");
    
    
    name = getString("Please enter the name of the contact");
    foundNode = treeNode.findInNode(name);
    if(foundNode != null)
    System.out.println("Name entered has user ID number and phone number : " +foundNode.getuserID() + foundNode.getphoneNumber());
    else 
    System.out.println("The name entered isn valid. Please try again"); 
    
}

//Method to add contact information 

private void addContact()
{
    String userID;
    String name; 
    String phoneNumber; 
    
    userID= getString ("Please type in the person's user ID number");
    name=getString("Please type in their name");
    phoneNumber = getString("Please type in the persons phone number");
    
    while(phoneNumber.length() != 11)
    {
        System.out.println("You have entered an invalid number. Please try again");
        phoneNumber = getString("Please type in the person's phone number");
    }
    
    treeNode.addToNode(userID, name, phoneNumber); 
    
}
private void addChat()
{
    String contactName = getString("Please enter the name of the contact you wish to text");
    
    String message = getString("Please enter your message");
}
}
