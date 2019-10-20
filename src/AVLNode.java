public class AVLNode {
    String key;
    Book value; //create a class representing a book with minimum attributes
    int height;
    AVLNode leftPtr;
    AVLNode rightPtr;

    public AVLNode(String k, Book val) {
        key = k;
        value = val;
    }

    AVLNode getLeftPtr() {return leftPtr;}
    AVLNode getRightPtr() {return rightPtr;}

    int getHeight() {return height;}
    Book getValue() {return value;}
    String getKey() {return key;}

    public void setLeftPtr(AVLNode leftPtr) {
        this.leftPtr = leftPtr;
    }

    public void setRightPtr(AVLNode rightPtr) {
        this.rightPtr = rightPtr;
    }
}

