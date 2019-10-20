//

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int bookNum;

    }

    // this will get the number of books
    public static int getNumberOfBooks() {
        int num = 0;
        try {
            // reads the information from the books from a file called bookInfo.txt
            Scanner input = new Scanner(new File("bookInfo.txt"));

            // the pointer which will be used to store the contents of the binary tree
            BinaryTree tree = new BinaryTree();

            while (input.hasNext()){
                input.nextLine();
                num++;
            }
        }
        catch (IOException e){
            System.out.println("Error reading file");
        }
        return num;
    }

    public static int readFile(BinaryTree tree) {

        try {
            // reads the information from the books from a file called bookInfo.txt
            Scanner input = new Scanner(new File("bookInfo.txt"));

            while (input.hasNext()){
                // read the ISBN, title, and last name into 3 strings
                String isbn = input.next();
                String title = input.next();
                String lastName = input.next();

                // make a new book
               // Book newBook = new Book(isbn,title,lastName);
                tree.insert(isbn,);
                // insert newBook into the AVL tree
            }
        }
        catch (IOException e){
            System.out.println("Error reading file");
        }
        return num;
    }

}
