import java.util.ArrayList;

public class BinaryTree{

    AVLNode rootPtr;


    public void insert(String key, Book book)
    {
        AVLNode newAVLNode = new AVLNode(key,book); //creates a new node with the isbn as key and the book saved

        // if we are inserting into the first element of the tree, set the height at 0
        if (rootPtr == null){
            newAVLNode.setHeight(0);
        }

        recursiveInsert(newAVLNode, rootPtr);
    }

    // used to check the height of a node which may or may not exist
    public int checkHeight(AVLNode newAVLNode){
        if (newAVLNode != null){
            return newAVLNode.getHeight();
        }
        else
            return 0;
    }

    public int checkBalance(AVLNode node){
        return (checkHeight(node.getRightPtr()) - checkHeight(node.getLeftPtr()));
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

        // set the height of the maximum height between the left and right child
        if (root != null)
            root.setHeight(Math.max(checkHeight(root.getLeftPtr()),checkHeight(root.getRightPtr())) + 1);

        // now check the balance of the node
        int balance = checkBalance(newAVLNode);

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

    ArrayList<String> inOrder() //calls the recursive inorder traversal function
    {
        ArrayList<String> list = new ArrayList<String>();
        recursiveInOrder(rootPtr, list);
        return list;
    }

    void recursiveInOrder(AVLNode root, ArrayList<String> list) //recursively gets the inorder of the tree
    {
        if (root == null)
            return;

        //process left child, then node, then right child

        recursiveInOrder(root.getLeftPtr(), list);
        list.add(root.getKey() + " " + root.getHeight()); //stores the inorder traversal nodes in the list
        recursiveInOrder(root.getRightPtr(), list);
    }
}