public class Main {

    public static void main(String[] args) {
        String directoryPath="./myBooks";
        String[] titles ={"The Great Gatsby","1984","To kill a Mockingbird"};
        String[] authors ={"F.Scott fitzgerald", "George Orwell","Harpee Lee"};

        for(int i=0;i<titles.length;i++){
            String fileName = titles[i] +".txt";
            String content = "Title:"+titles[i]+"\nAuthor" +authors[i] + "\nSample Content...";
            FileCreator.createSampleFile(directoryPath,fileName,content);
        }

        DirectoryManager.listFilesAndDirectories(directoryPath);
        String backupDir ="./myBooksBackup";
        DirectoryManager.createDirectory(backupDir);

        DirectoryManager.renameDirectory(backupDir,"./BooksBackupDirectory");
        DirectoryManager.copyFiles(directoryPath,"./BooksBackupDirectory");
        DirectoryManager.deleteFile("./myBooks/1984.txt");

        Book book = new Book("1984", "George Orwell", "978-0451524935");
        String filePath = "./myBooks/book.ser";
        Book.serializeBook(book, filePath);
        Book deserializedBook = Book.deserializeBook(filePath);
        System.out.println("Deserialized Book: " + deserializedBook);


    }

}
