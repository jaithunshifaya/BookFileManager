import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class DirectoryManager {

    
    public static void listFilesAndDirectories(String directoryPath) {
        File directory = new File(directoryPath);
        if(!directory.exists()){
            System.out.println("Error: directory does not exist");
        }
        File[] filesList =directory.listFiles();


        if (filesList == null || filesList.length == 0) {
            System.out.println("The directory is empty");
            return;

        }
        else {
            System.out.println("Books available in the directory");
            for(File file: filesList){
                System.out.println("Title"+file.getName());
            }

        }
    }

     public static void createDirectory(String directoryPath) {
         File directory = new File(directoryPath);
         if (!directory.exists()) {
             if (directory.mkdirs()) {
                 System.out.println("Directory created successfully");
             } else {
                 System.out.println("Failed to create directory");
             }
         }
     }



      public static void renameDirectory(String currentDirectory, String newDirectory) {
        File oldDir = new File(currentDirectory);
        File newDir= new File(newDirectory);
        if(!oldDir.exists()){
            System.out.println("Directory does not exist");
            return;
        }
         if (newDir.exists()) {
             System.out.println("New directory name already exists");
             return;

        }

         if (!oldDir.renameTo(newDir)) {

            System.out.println("Directory renamed successfully");

        }
        else {
            System.out.println("Failed to rename directory");

        }
    }

    public static void copyFiles(String sourceDir, String destDir) {

        try {
            Path sourcePath = Paths.get(sourceDir);
            Path destPath = Paths.get(destDir);
               if (!Files.exists(sourcePath)) {
                   System.out.println("Source directory does not exist");
                   return;
               }
               if(!Files.exists(destPath)){
                   Files.createDirectories(destPath);
               }

               try(DirectoryStream<Path> directoryStream = Files.newDirectoryStream(sourcePath)){
                   for(Path sourceFilePath: directoryStream){
                       if(Files.isRegularFile(sourceFilePath)){
                           Path destFilePath = destPath.resolve(sourceFilePath.getFileName());
                           Files.copy(sourceFilePath,destFilePath,StandardCopyOption.REPLACE_EXISTING);
                           System.out.println("Copies:" +sourceFilePath.getFileName());
                       }
                   }
               }

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

     public static void deleteFile(String fileName) {
         File file = new File((fileName));
         if(file.exists() && file.isFile()){
         if (file.delete()) {
            System.out.println(fileName+ "has been deleted");

        } else {
             System.out.println("Failed to delete" +fileName);
         }

         } else{
             System.out.println("Error: file does not exist");
         }
    }

}

