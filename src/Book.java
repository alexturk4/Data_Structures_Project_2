public class Book {
    //•	ISBN Number <space> Title <space> Author’s last name
    String isbn;
    String lastName;
    String title;

    public Book(String i, String t, String lastN) {
        isbn = i;
        title = t;
        lastName = lastN;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getLastName() {
        return lastName;
    }
}

