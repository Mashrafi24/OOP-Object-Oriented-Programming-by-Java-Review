public class Book {
    private String bookTitle;
    private String author;
    private int publicationYear;
    private boolean isAvailable;
    
    public Book(String bookTitle, String author, int publicationYear) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isAvailable = true;
    }
    
    public String getBookTitle() {
        return bookTitle;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public int getPublicationYear() {
        return publicationYear;
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }
    
    public boolean checkOut() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }
    
    public boolean returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "\"" + bookTitle + "\" by " + author + " (" + publicationYear + ") - " 
               + (isAvailable ? "Available" : "Checked Out");
    }
}
