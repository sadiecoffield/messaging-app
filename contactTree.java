import java.util.Scanner;
/**
 * Binary Tree containing the contact list
 *
 * @author emily erskine
 */

public class contactTree
{
    // instance variables
    private treeNode root;
    String tempName;
    String tempNum;
    int tempID;

    /**
     * Constructor for objects of class contactTree
     */
    
    public contactTree()
    {
        // initialise instance variables
        root = null;
    }
    
     /**
     * Method to get info input from user
     * 
     */
    public void createContact() {
        // initialise scanner for uer input
        Scanner s = new Scanner(System.in);
        // initialise variables
        String userName = "";
        String userNum = "";
        int defaultID = contactCount(root);
        
        System.out.println("Enter new Contact Info : ");
        
        System.out.println("Please enter the name of contact : ");
        userName = s.nextLine();
        
        if (userName.length() < 0 || userName.length() > 25){
            System.out.println("Please enter a valid item contact name between 1 & 25 characters");
            userName = s.nextLine();
        }
        
        if (existContact(root, userName))
        {
            System.out.println("This contact name is already in use please enter a different name");
            userName = s.nextLine();
        }
        
        System.out.println("Please enter the number of contact in the format XXXXX XXXXXX : ");
        userNum = s.nextLine();
        
        if (userNum.length() < 12 || userNum.length() > 12){
            System.out.println("Please enter number in the form above");
            userNum = s.nextLine();
        }
        
        addContact(defaultID, userName, userNum);
    }
    
     /**
     * Method to allow user to edit an existing contact
     * 
     */
    public void editContact() 
    {
        // initialise scanner for uer input
        Scanner s = new Scanner(System.in);
        // initialise variables
        String originalName = "";
        String userNum = "";
        
        System.out.println("Enter the info of the contact you would like to edit : ");
        
        System.out.println("Please enter the name of the existing contact: ");
        originalName = s.nextLine();
        
        if (originalName.length() < 0 || originalName.length() > 25){
            System.out.println("Please enter a valid item contact name between 1 & 25 characters");
            originalName = s.nextLine();
        }
        
        findContact(root, originalName);
        
        System.out.println("You would like to edit the following contact : ");
        System.out.println(tempName + " " + tempNum);
        
        System.out.println("Please enter the new contact name : ");
        tempName = s.nextLine();
        
        if (tempName.length() < 0 || tempName.length() > 25){
            System.out.println("Please enter a valid item contact name between 1 & 25 characters");
            tempName = s.nextLine();
        }
        
        if (existContact(root, tempName))
        {
            System.out.println("This contact name is already in use please enter a different name");
            tempName = s.nextLine();
        }
        
        System.out.println("Please enter the new contact number : ");
        tempNum = s.nextLine();
        
        if (tempNum.length() < 12 || tempNum.length() > 12){
            System.out.println("Please enter number in the form XXXXX XXXXXX");
            tempNum = s.nextLine();
        }
        
        delete(tempID);
        addContact(tempID, tempName, tempNum);
                
    }
    
     /**
     * Method to find an existing contact using name but additionally set all temp values to values found
     * 
     * @ param currentNode and originalName which is the name to be found
     */
    public boolean findContact(treeNode currentNode, String originalName)
    {
         if (currentNode == null) {
            return false;
        }

        if (currentNode.name.equals(originalName))
        {   
            tempName = currentNode.name;
            tempNum = currentNode.phoneNumber;
            tempID = currentNode.ID;
            return true;
        }
        
        return findContact(currentNode.left, originalName) || findContact(currentNode.right, originalName);
    }
    
     /**
     * Method to add a contact using recurring
     *
     * @param name and number for new contact
     * 
     */
    
    public void addContact(int ID, String name, String phoneNumber) {
        root = addContactRec(root, ID, name, phoneNumber);
    }

    /**
     * Method to add a contact using recurring
     *
     * @param name and number for new contact as well as contact ID and current Node
     * 
     */
    
    public treeNode addContactRec(treeNode currentNode, int ID, String name, String phoneNumber)
    {
        if (currentNode == null) {
            return new treeNode(ID, name, phoneNumber);
        }
        
        if(ID < currentNode.ID) {
            currentNode.left = addContactRec(currentNode.left, ID, name, phoneNumber);
        }
        else if (ID > currentNode.ID) {
            currentNode.right = addContactRec(currentNode.right, ID, name, phoneNumber);
        }
        else {
            return currentNode;
        }
        
        return currentNode;
    }
    
    /**
     * Method to traverse tree
     *
     * @param current Node
     * 
     */
    public void traverseTree(treeNode currentNode) {

        if (currentNode != null) {
            traverseTree(currentNode.left);
            System.out.println(currentNode.name + "    " + currentNode.phoneNumber);
            traverseTree(currentNode.right);
        }
        
    }
    
    /**
     * Method to print out contents of the tree in order of addition
     */
    public void getContacts() {
        System.out.println("name    number");
        traverseTree(root);
    }
    
    /**
     * Method to delete a tree node
     *
     * @param contact ID
     * 
     */
    public treeNode delete(int ID) {
        return deleteRec(root, ID);
    }
    
    /**
     * Method to delete a tree node using recurring
     *
     * @param current Node, ID of contact to delete
     * 
     */
    public treeNode deleteRec(treeNode currentNode, int ID) {
        if (currentNode == null) {
            return null;
        }

        if (ID == currentNode.ID) {
            if (currentNode.left == null && currentNode.right == null) {
                // means this node is a leaf
                return null;
            }
            if (currentNode.right == null) {
                // node only has left child
                return currentNode.left;
            }
            if (currentNode.left == null) {
                // Node only has right child
                return currentNode.right;
            }
            // Node has two children
            int smallest = findSmall(currentNode.right);
            currentNode.ID = smallest;
            currentNode.right = deleteRec(currentNode.right, smallest);
            return currentNode;
        }

        if (ID < currentNode.ID) {
            currentNode.left = deleteRec(currentNode.left, ID);
            return currentNode;
        }

        currentNode.right = deleteRec(currentNode.right, ID);
        return currentNode;
    }
    
    /**
     * Method to find the smallest
     *
     * @param root Node
     * @return smallest 
     * 
     */
    private int findSmall(treeNode root) {
        if (root.left == null) {
            return root.ID;
         } else {
            return findSmall(root.left);
        }
    }
    
    /**
     * Method to check if a contact with chosen name already exists
     *
     * @param current Node, contact name
     * 
     */
    public boolean existContact(treeNode currentNode, String contactName)
    {
        if (currentNode == null)
        {
            return false;
        }
        
        if (currentNode.name.equals(contactName))
        {
            return true;
        }
        
        return existContact(currentNode.left, contactName) || existContact(currentNode.right, contactName);
    }
    
    /**
     * Method to count how many contacts are in the tree
     *
     * @param root node for start point
     * @return total number of nodes
     * 
     */
    public int contactCount(treeNode root) 
    {
        if (root == null) 
        {
            return 0;
        }
        
        int leftNum = contactCount(root.left);
        int rightNum = contactCount(root.right);
        
        return 1 + leftNum + rightNum;
    }
}
