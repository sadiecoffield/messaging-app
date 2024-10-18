import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
/**
 * Saves and loads data to and from files
 *
 * @author Sadie Coffield
 * @version 1
 */
public class Files
{
    /**
     * Method to save the details of the user profile to a file
     */
    public void saveUserProfile(String userID, String name, String phoneNumber)
    {
        FileOutputStream outputStream = null;
        PrintWriter printWriter = null;
        
        try
        {
            outputStream = new FileOutputStream("savedUserProfile.txt");
            printWriter = new PrintWriter(outputStream);
            
            printWriter.println(userID);
            printWriter.println(name);
            printWriter.println(phoneNumber);
        }
        catch (IOException e)
        {
            System.out.println("There is a problem with saving the user profile details.");
        }
        finally
        {
            if (printWriter != null)
            {
                printWriter.close();
            }
        }
    }
    
    /**
     * Method to load the details of the user profile from file
     */
    public void loadUserProfile()
    {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        
        try
        {
            fileReader = new FileReader("savedUserProfile.txt");
            bufferedReader = new BufferedReader(fileReader);
            
            String loadedUserID = bufferedReader.readLine();
            String loadedName = bufferedReader.readLine();
            String loadedPhoneNumber = bufferedReader.readLine();
            
            UserProfile user = new UserProfile(loadedUserID, loadedName, loadedPhoneNumber);
            
            user.editUserProfile();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("The file was not found");
        }
        catch (IOException e)
        {
            System.out.println("There is a problem with loading the user profile details.");
        }
        finally
        {
            try
            {
                bufferedReader.close();
            }
            catch (IOException e)
            {
                System.out.println("There is a problem closing the file");
            }
        }
    }
    
    /**
     * Method to save the list of contacts to file
     */
    public void saveContacts()
    {
        contactTree contact = new contactTree();
        
        FileOutputStream outputStream = null;
        PrintWriter printWriter = null;
        
        
    }
}
