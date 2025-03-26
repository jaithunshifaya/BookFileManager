import java.io.*;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    private String title;
    private String author;
    private String isbn;

    // Constructor
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }

    // toString method for easy printing
    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", isbn=" + isbn + "]";
    }


    public static void serializeBook(Book book, String filePath) {
        File file = new File(filePath);
        File parentDir = file.getParentFile();
        if(parentDir!= null && !parentDir.exists()){
            parentDir.mkdirs();
        }

        try (FileOutputStream fileOut = new FileOutputStream(filePath);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(book);
            System.out.println("Serialized book saved in" +filePath);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Book deserializeBook(String filePath) {
        File file= new File(filePath);
        if(!file.exists()) {
            System.out.println("Error serialized file does not exist.");
            return null; }

            try (FileInputStream fileIn = new FileInputStream(filePath);
                 ObjectInputStream in = new ObjectInputStream(fileIn)) {
                return (Book) in.readObject();
            }
            catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                return  null;
            }
    }

}


