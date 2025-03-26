import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class DirectoryManager {

    public static void listFilesAndDirectories(String directoryPath) {
        File directory = new File(directoryPath); // Ensure this directory exists in your project folder
        File[] filesList = directory.listFiles(); // This method returns an array of File objects

        if (filesList != null) {
            System.out.println("List of books available in " + directoryPath + " directory:");
            for (File file : filesList) {
                System.out.println("Title: " + file.getName()); // Print the name of each file or directory
            }
        } else {
            System.out.println("The directory is empty or does not exist."); // Error handling
        }
    }

    public  static  void createDirectory(String directoryPath){
        File directory = new File(directoryPath);

        // Create the directory if it does not exist
        if (!directory.exists()) {
            if (directory.mkdirs()) {
                System.out.println("Directory created successfully: " + directoryPath);
            } else {
                System.out.println("Failed to create directory");
                return;
            }
        }
    }

    public static void renameDirectory(String currentDirectory, String newDirectory) {
        File oldDir = new File(currentDirectory); // Use variable, not string literal
        File newDir = new File(newDirectory);     // Use variable, not string literal

        // Ensure the new directory does not already exist
        if (newDir.exists()) {
            System.out.println("Error: The new directory name already exists.");
            return;
        }

        if (!oldDir.renameTo(newDir)) {
            System.out.println("Failed to rename directory.");
        } else {
            System.out.println("Directory has been renamed successfully.");
        }
    }

    public static void copyFiles(String sourceDir, String destDir) {
        try {
            // Create Path objects from the String parameters
            Path sourcePath = Paths.get(sourceDir);
            Path destPath = Paths.get(destDir);

            // Create the destination directory if it doesn't exist
            if (!Files.exists(destPath)) {
                Files.createDirectories(destPath);
            }

            // Iterate through the files in the source directory
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(sourcePath);
            for (Path sourceFilePath : directoryStream) {
                Path destFilePath = destPath.resolve(sourceFilePath.getFileName());

                // Copy the file to the destination directory
                Files.copy(sourceFilePath, destFilePath, StandardCopyOption.REPLACE_EXISTING);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.delete()) {
            System.out.println(fileName + " has been deleted.");
        } else {
            System.out.println("Failed to delete " + fileName);
        }
    }

}

