/**
 * treeNode contains data of the contacts
 *
 * @author emily erskine
 */

public class treeNode
{
    // instance variables
    int ID;
    String name;
    String phoneNumber;
    treeNode left;
    treeNode right;

    /**
     * Constructor for objects of class treeNode
     */
    public treeNode(int ID, String name, String phoneNumber)
    {
        this.ID = ID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        left = null;
        right = null;
    }

}
