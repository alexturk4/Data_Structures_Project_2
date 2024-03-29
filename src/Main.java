//

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        readFile(tree);
        System.out.println(tree.inOrder());
    }

    // this will get the number of books
    public static int getNumberOfBooks() {
        int num = 0;
        try {
            // reads the information from the books from a file called bookInfo.txt
            Scanner input = new Scanner(new File("bookInfo.txt"));

            // the pointer which will be used to store the contents of the binary tree
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

                // this removes the dash from the ISBN number
                //isbnStr = isbn.replace("-","");
                Book newBook = new Book(isbn,title,lastName);

                // insert newBook into the AVL tree
                tree.insert(isbn,newBook);

            }
        }
        catch (IOException e){
            System.out.println("Error reading file");
        }
        return 0;
    }

}
