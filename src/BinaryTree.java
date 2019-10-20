import java.util.ArrayList;

public class BinaryTree{

    AVLNode rootPtr;


    public void insert(String key, Book book)
    {
        AVLNode newAVLNode = new AVLNode(key,book); //creates a new node with the isbn as key and the book saved
        recursiveInsert(newAVLNode, rootPtr);
    }

    public void recursiveInsert(AVLNode newAVLNode, AVLNode root) //inserts new nodes into a binary tree recursively
    {

        if (root == null) //if there are no nodes in the binary tree
            rootPtr = newAVLNode;
        else if (newAVLNode.getKey().compareTo(root.getKey()) < 0) //value < root.getVal(), if the current value is less than the one being compared to
        {
            if (root.getLeftPtr() != null)
                recursiveInsert(newAVLNode,root.getLeftPtr());
            else
                root.setLeftPtr(newAVLNode);
        }
        else
        {
            if (root.getRightPtr() != null)
                recursiveInsert(newAVLNode, root.getRightPtr());
            else
                root.setRightPtr(newAVLNode);
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
        else if (root.getKey().equals(title)) //if the title is found in the list, return the node of the title
            return root;
        else
        {
            if (title.compareTo(root.getKey()) < 0) //if the title being searched is less than the current one, go to the left child
                returnVal = recursiveSearch(title,root.getLeftPtr());
            else
                returnVal = recursiveSearch(title,root.getRightPtr()); //go right since the current title is larger than the one being searched
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

        recursiveInOrder(root.getLeftPtr(), list);
        list.add(root); //stores the inorder traversal nodes in the list
        recursiveInOrder(root.getRightPtr(), list);
    }
}