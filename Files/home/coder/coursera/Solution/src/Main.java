import java.io.File;
public class Main {
    public static void main(String[] args) {
        // Creating book files in myBooks directory
        String directoryPath = "./myBooks";
        String[] titles = {"The Great Gatsby", "1984", "To Kill a Mockingbird"};
        String[] authors = {"F. Scott Fitzgerald", "George Orwell", "Harper Lee"};

        for (int i = 0; i < titles.length; i++) {
            String fileName = titles[i] + ".txt";
            String content = "Title: " + titles[i] + "\nAuthor: " + authors[i] + "\nSample Content...";
            FileCreator.createSampleFile(directoryPath, fileName, content);
        }

        // Task 1: List files
        DirectoryManager.listFilesAndDirectories(directoryPath);

        // Task 2: Create a directory
        String backupDir = "./myBooksBackup";
        DirectoryManager.createDirectory(backupDir);

        // Task 3: Rename directory
        DirectoryManager.renameDirectory(backupDir, "./BooksBackupDirectory");

        // Task 4: Copy files
        DirectoryManager.copyFiles(directoryPath, "./BooksBackupDirectory");

        // Task 5: Delete a file
        DirectoryManager.deleteFile("./myBooks/1984.txt");

        // Task 6: Serialize and Deserialize Book
        Book book = new Book("1984", "George Orwell", "978-0451524935");
        String bookFilePath = "./myBooks/book.ser";
        Book.serializeBook(book, bookFilePath);
        Book deserializedBook = Book.deserializeBook(bookFilePath);
        System.out.println("Deserialized Book: " + deserializedBook);
    }
}

