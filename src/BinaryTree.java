import java.util.ArrayList;

public class BinaryTree{

    AVLNode rootPtr;


    public void insert(String t, int numAvail, int numRented)
    {
        AVLNode newAVLNode = new AVLNode(t, numAvail, numRented); //creates a new node with the values specified
        recursiveInsert(newAVLNode, rootPtr);
    }

    public void recursiveInsert(AVLNode newAVLNode, AVLNode root) //inserts new nodes into a binary tree recursively
    {

        if (root == null) //if there are no nodes in the binary tree
            rootPtr = newAVLNode;
        else if (newAVLNode.getTitle().compareTo(root.getTitle()) < 0) //value < root.getVal(), if the current value is less than the one being compared to
        {
            if (root.getLeft() != null)
                recursiveInsert(newAVLNode,root.getLeft());
            else
                root.setLeft(newAVLNode);
        }
        else
        {
            if (root.getRight() != null)
                recursiveInsert(newAVLNode, root.getRight());
            else
                root.setRight(newAVLNode);
        }
    }

    AVLNode search(String title)
    {
        return recursiveSearch(title, rootPtr);
    }

    AVLNode recursiveSearch(String title, AVLNode root) //returns the pointer to the node being searched for
    {
        AVLNode returnVal;
        if (root == null) //if the title was not found in the list, return null
            returnVal = null;
        else if (root.getTitle().equals(title)) //if the title is found in the list, return the node of the title
            return root;
        else
        {
            if (title.compareTo(root.getTitle()) < 0) //if the title being searched is less than the current one, go to the left child
                returnVal = recursiveSearch(title,root.getLeft());
            else
                returnVal = recursiveSearch(title,root.getRight()); //go right since the current title is larger than the one being searched
        }
        return returnVal;

    }

    ArrayList<AVLNode> inOrder() //calls the recursive inorder traversal function
    {
        ArrayList<AVLNode> list = new ArrayList<AVLNode>();
        recursiveInOrder(rootPtr, list);
        return list;
    }

    void recursiveInOrder(AVLNode root, ArrayList<AVLNode> list) //recursively gets the inorder of the tree
    {
        if (root == null)
            return;

        //process left child, then node, then right child

        recursiveInOrder(root.getLeft(), list);
        list.add(root); //stores the inorder traversal nodes in the list
        recursiveInOrder(root.getRight(), list);
    }
}